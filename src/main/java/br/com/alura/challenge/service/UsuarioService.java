package br.com.alura.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public String criptografaSenha(String senha){
        return passwordEncoder.encode(senha);
    }
}
