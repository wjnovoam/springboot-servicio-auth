INSERT INTO usuarios (username, password, enable, nombre, apellido, email) VALUES ('William','12345', 1, 'William', 'Novoa','william@gmail.com' );
INSERT INTO usuarios (username, password, enable, nombre, apellido, email) VALUES ('admin','12345', 1, 'Admin William', 'admin','admin@gmail.com' );

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1,1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2,2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2,1);