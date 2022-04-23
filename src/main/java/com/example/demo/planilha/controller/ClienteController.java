package com.example.demo.planilha.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import com.example.demo.planilha.entity.Cliente;
import com.example.demo.planilha.service.ClienteService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }


    @GetMapping(value = "/{id}")
    @ResponseStatus(OK)
    public Cliente getClienteById(@PathVariable("id") Long id, @Param("nome") String nome) {
        return service.findClienteById(id);
    }

    @GetMapping(value = "/nome")
    @ResponseStatus(OK)
    public List<Cliente> getClienteByNome(@Param("nome") String nome) {
        return service.findClienteByNome(nome);
    }

    @PostMapping(value = "/upload")
    @ResponseStatus(CREATED)
    public boolean createMultipleClients(@RequestParam("file") MultipartFile file) {
        return service.uploadClienteFile(file);
    }

}
