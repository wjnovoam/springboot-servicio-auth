package com.wjnovoam.app.gateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
public class EjemploGobalFilter implements GlobalFilter, Ordered {

    private final Logger logger = LoggerFactory.getLogger(EjemploGobalFilter.class);

    @Override //Filtro para todos los microservicios que estan en el gateway
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("Ejecutando filtro pre");
        exchange.getRequest().mutate().headers(h -> h.add("token", "12345678"));

        return chain.filter(exchange).then(Mono.fromRunnable( ()-> {

            Optional.ofNullable(exchange.getRequest().getHeaders().getFirst("token")).ifPresent(valor-> exchange.getResponse().getHeaders().add("token", valor));

            logger.info("Ejecutando filtro pro");
            exchange.getResponse().getCookies().add("color", ResponseCookie.from("color", "rojo").build());
            //exchange.getResponse().getHeaders().setContentType(MediaType.TEXT_PLAIN);
        }));
    }

    @Override
    public int getOrder() {
        return 10;
    }
}
