package com.example.demo.planilha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.planilha.entity.Cliente;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    @Query(value = "select * from cliente where LOWER(nome) like LOWER(concat('%', :nome,'%')) ", nativeQuery = true)
    List<Cliente> findClienteByNome(@Param("nome") String nome);
}
