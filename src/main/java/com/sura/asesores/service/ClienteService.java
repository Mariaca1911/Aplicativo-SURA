package com.sura.asesores.service;

import com.sura.asesores.model.Cliente;
import com.sura.asesores.model.EstadoAfiliacion;
import com.sura.asesores.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente registrarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> obtenerCliente(Long id) {
        return clienteRepository.findById(id);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> actualizarEstado(Long id, EstadoAfiliacion estado) {
        Optional<Cliente> clienteOpt = clienteRepository.findById(id);
        if (clienteOpt.isPresent()) {
            Cliente cliente = clienteOpt.get();
            cliente.setEstadoAfiliacion(estado);
            clienteRepository.save(cliente);
            return Optional.of(cliente);
        }
        return Optional.empty();
    }
}
