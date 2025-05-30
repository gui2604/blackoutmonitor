package br.com.fiap.blackoutmonitor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.blackoutmonitor.exception.InvalidCEPException;

@RestController
@RequestMapping("/test")
public class DummyController {

    @GetMapping("/cep-invalido")
    public void testarCep() {
        throw new InvalidCEPException("CEP inválido ou não encontrado");
    }
}
