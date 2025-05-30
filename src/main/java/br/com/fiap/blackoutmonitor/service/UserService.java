package br.com.fiap.blackoutmonitor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fiap.blackoutmonitor.dto.ResetPasswordRequest;
import br.com.fiap.blackoutmonitor.model.User;
import br.com.fiap.blackoutmonitor.repository.UserRepository;
import jakarta.validation.Valid;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public List<User> listAll() {
        return userRepository.findAll();
    }

    public Optional<User> searchForId(Long id) {
        return userRepository.findById(id);
    }

    public User save(User user){
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        return userRepository.save(user);
    }

    public User update(Long id, @Valid User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setClientName(updatedUser.getClientName());
            user.setEmail(updatedUser.getEmail());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found."));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
   
    // ------------------------ SECURITY -----------------------------------------------

    public boolean autenticateUser(String typedUsername, String typedPassword) {
        User user = userRepository.findByUsername(typedUsername)
            .orElseThrow(() -> new RuntimeException("User not found."));

        return passwordEncoder.matches(typedPassword, user.getPassword());
    }

    public boolean resetPassword(String username, ResetPasswordRequest request) {
        Optional<User> usuarioOpt = userRepository.findByUsername(username);

        if (usuarioOpt.isEmpty()) return false;

        User user = usuarioOpt.get();

        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            return false;
        }

        String newPasswordHash = passwordEncoder.encode(request.getNewPassword());
        user.setPassword(newPasswordHash);
        userRepository.save(user);

        return true;
    }
}
