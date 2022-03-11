package com.wjnovoam.app.oauth.security.event;

import com.wjnovoam.app.commons.usuarios.models.entity.Usuario;
import com.wjnovoam.app.oauth.services.IUsuarioService;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationSuccessErrorHandler implements AuthenticationEventPublisher {

    private Logger log = LoggerFactory.getLogger(AuthenticationSuccessErrorHandler.class);

    @Autowired
    private IUsuarioService usuarioService;


    @Override
    public void publishAuthenticationSuccess(Authentication authentication) {

        //if(authentication.getName().equalsIgnoreCase("frontendapp")) return;
        if(authentication.getDetails() instanceof WebAuthenticationDetails)return;

        UserDetails user = (UserDetails) authentication.getPrincipal();
        String mensaje = "Success Login: " + user.getUsername();
        System.out.println(mensaje);
        log.info(mensaje);

        Usuario usuario = usuarioService.findByUsername(authentication.getName());

        if(usuario.getIntentos() != null && usuario.getIntentos() > 0){
            usuario.setIntentos(0);
            usuarioService.update(usuario, usuario.getId());
        }
    }

    @Override
    public void publishAuthenticationFailure(AuthenticationException e, Authentication authentication) {
        String mensaje = "Error en el Login: " + e.getMessage();
        log.info(mensaje);
        System.out.println(mensaje);
        try{
            Usuario usuario = usuarioService.findByUsername(authentication.getName());
            if(usuario.getIntentos()== null){
                usuario.setIntentos(0);
            }

            log.info("Intentos actual es de: " + usuario.getIntentos());
            usuario.setIntentos(usuario.getIntentos() + 1);
            log.info("Intentos despues es de: " + usuario.getIntentos());

            if(usuario.getIntentos() >= 3){
                log.error(String.format("El usuario %s deshabilitado por maximos intentos.", usuario.getUsername()));
                usuario.setEnable(false);
            }

            usuarioService.update(usuario, usuario.getId());

        }catch (FeignException feignException){
            //log.error(feignException.getMessage());
            log.error(String.format("El usuario %s npexiste en el sistema", authentication.getName()));
        }
    }
}
