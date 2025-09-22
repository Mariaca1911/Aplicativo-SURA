package com.sura.asesores.controller;

import com.sura.asesores.model.Cliente;
import com.sura.asesores.model.EstadoAfiliacion;
import com.sura.asesores.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> registrarCliente(@RequestBody Cliente cliente) {
        Cliente nuevo = clienteService.registrarCliente(cliente);
        return ResponseEntity.ok(nuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerCliente(@PathVariable Long id) {
        Optional<Cliente> clienteOpt = clienteService.obtenerCliente(id);
        return clienteOpt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<Cliente> actualizarEstado(@PathVariable Long id, @RequestBody EstadoAfiliacion estado) {
        Optional<Cliente> clienteOpt = clienteService.actualizarEstado(id, estado);
        return clienteOpt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Vistas Thymeleaf
    @Controller
    @RequestMapping("/view/clientes")
    public static class ClienteViewController {
        @Autowired
        private ClienteService clienteService;

        @GetMapping
        public String listarClientes(Model model) {
            List<Cliente> clientes = clienteService.listarClientes();
            model.addAttribute("clientes", clientes);
            model.addAttribute("estados", EstadoAfiliacion.values());
            return "clientes";
        }

        @GetMapping("/nuevo")
        public String mostrarFormulario(Model model) {
            model.addAttribute("cliente", new Cliente());
            model.addAttribute("estados", EstadoAfiliacion.values());
            return "formulario";
        }

        @PostMapping
        public String registrarCliente(@ModelAttribute Cliente cliente) {
            clienteService.registrarCliente(cliente);
            return "redirect:/view/clientes";
        }

        @PostMapping("/{id}/estado")
        public String cambiarEstado(@PathVariable Long id, @RequestParam EstadoAfiliacion estado) {
            clienteService.actualizarEstado(id, estado);
            return "redirect:/view/clientes";
        }
    }
}
