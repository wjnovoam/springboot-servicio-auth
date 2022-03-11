package com.wjnovoam.app.oauth.services;

import com.wjnovoam.app.commons.usuarios.models.entity.Usuario;

public interface IUsuarioService {

    Usuario findByUsername(String username);

    Usuario update( Usuario usuario, Long id);
}
