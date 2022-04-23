package com.example.demo.planilha.service.impl;

import com.example.demo.planilha.entity.Cliente;
import com.example.demo.planilha.repository.ClienteRepository;
import com.example.demo.planilha.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository repository;

    public ClienteServiceImpl(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cliente findClienteById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @Override
    public List<Cliente> findClienteByNome(String nome) {
        return repository.findClienteByNome(nome);
    }

    @Override
    @Transactional
    public boolean uploadClienteFile(MultipartFile file) {
        return false;
    }
}
