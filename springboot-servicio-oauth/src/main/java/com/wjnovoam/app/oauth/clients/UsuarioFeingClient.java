package com.wjnovoam.app.oauth.clients;

import com.wjnovoam.app.commons.usuarios.models.entity.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "servicio-usuarios")
public interface UsuarioFeingClient {
    @GetMapping("/usuarios/search/buscar-username")
    Usuario findByUsername(@RequestParam String username);

    @PutMapping("/usuarios/{id}")
    Usuario update(@RequestBody Usuario usuario, @PathVariable Long id);
}
