package br.com.fiap.blackoutmonitor.dto;

import lombok.Data;

@Data
public class ResetPasswordRequest {
    private String currentPassword;
    private String newPassword;
}
