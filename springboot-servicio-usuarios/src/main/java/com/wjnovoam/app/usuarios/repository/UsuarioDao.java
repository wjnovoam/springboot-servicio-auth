package com.wjnovoam.app.usuarios.repository;

import com.wjnovoam.app.usuarios.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "usuarios")
public interface UsuarioDao extends PagingAndSortingRepository<Usuario, Long> {
    Usuario findByUsername(String username);

    @Query("select u from Usuario u where u.username=?1")
    Usuario obtenerPorUsername(String username);
}
