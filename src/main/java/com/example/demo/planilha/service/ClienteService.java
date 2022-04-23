package com.example.demo.planilha.service;

import com.example.demo.planilha.entity.Cliente;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ClienteService {
    Cliente findClienteById(Long id);

    List<Cliente> findClienteByNome(String nome);

    boolean uploadClienteFile(MultipartFile file);
}
