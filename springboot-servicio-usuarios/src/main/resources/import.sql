INSERT INTO usuarios (username, password, enable, nombre, apellido, email) VALUES ('william','$2a$10$/eN0ns1lq1umzhAFA1C1NObcCfU.Fx.hWKEmAUuGBXQz9q9/j8oO.', 1, 'William Johan', 'Novoa','william@gmail.com' );
INSERT INTO usuarios (username, password, enable, nombre, apellido, email) VALUES ('admin','$2a$10$EYHTUNgmr8orR/XqXevU.uTRPpBqBS4eu2l9IPzlAPy5RXPH8Z/KC', 1, 'Admin William', 'admin','admin@gmail.com' );

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1,1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2,2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2,1);