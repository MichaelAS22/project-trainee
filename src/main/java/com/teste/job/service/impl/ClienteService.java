package com.teste.job.service.impl;

import com.teste.job.exception.ClientNotFoundException;
import com.teste.job.model.Cliente;
import com.teste.job.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-","");
    }

    @Transactional(readOnly = true)
    public Cliente findById(String id) {
        return clienteRepository.findById(id).orElseThrow(  () ->
                new ClientNotFoundException(id));
    }

    public void delete (String id) {
        findById(id);
        clienteRepository.deleteById(id);
    }

    @Transactional
    public Cliente create(Cliente clienteCreate) {
        String uuid = getUUID();
        clienteCreate.setId(uuid);
        clienteCreate.setEntryDate(LocalDateTime.now());
        clienteRepository.save(clienteCreate);
        return clienteCreate;
    }

    @Transactional
    public  Cliente update(String id, Cliente clienteCreate) {
        Cliente cliente = findById(id);
        cliente.setNome(clienteCreate.getNome());
        cliente.setCnpj(clienteCreate.getCnpj());
        cliente.setCpf(clienteCreate.getCpf());
        return cliente;
    }

    @Transactional
    public Cliente checkout(String id) {
        Cliente cliente = findById(id);
        cliente.setExitDate(LocalDateTime.now());
        cliente.setValor(ClientePag.getValor(cliente));
        clienteRepository.save(cliente);
        return cliente;
    }




}
