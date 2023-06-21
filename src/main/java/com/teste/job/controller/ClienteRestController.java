package com.teste.job.controller;


import com.teste.job.controller.dto.ClienteCreateDTO;
import com.teste.job.controller.dto.ClienteDTO;
import com.teste.job.controller.mapper.ClienteMapper;
import com.teste.job.model.Cliente;
import com.teste.job.service.impl.ClienteService;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteRestController {

    private final ClienteService clienteService;
    private final ClienteMapper clienteMapper;

    public ClienteRestController(ClienteService clienteService, ClienteMapper clienteMapper) {
        this.clienteService = clienteService;
        this.clienteMapper = clienteMapper;
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() {
        List<Cliente> clienteList = clienteService.findAll();
        List<ClienteDTO> resultado = clienteMapper.toClienteDTOList(clienteList);
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> findByID(@PathVariable String id) {
        Cliente cliente = clienteService.findById(id);
        ClienteDTO resultado = clienteMapper.toClienteDTO(cliente);
        return ResponseEntity.ok(resultado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> create(@RequestBody ClienteCreateDTO dto) {
        var clienteCreate = clienteMapper.toClienteCreate(dto);
        var cliente = clienteService.create(clienteCreate);
        var resultado = clienteMapper.toClienteDTO(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable String id, @RequestBody ClienteCreateDTO clienteCreateDTO) {
        Cliente clienteUpdate = ClienteMapper.toClienteCreate(clienteCreateDTO);
        Cliente cliente = clienteService.update(id, clienteUpdate);
        return ResponseEntity.ok(ClienteMapper.toClienteDTO(cliente));
    }

    public ResponseEntity<ClienteDTO> checkout(@PathVariable String id) {
        Cliente cliente = clienteService.checkout(id);
        return ResponseEntity.ok(clienteMapper.toClienteDTO(cliente));
    }


}
