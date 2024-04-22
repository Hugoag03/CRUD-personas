¡Bienvenido a la Aplicación de Gestión de Personas

Esta es una aplicación web basada en un CRUD.
Antes de probarla debes tener en cuenta varios factores.

Como puedes ver está dividido en distintas ramas, la master tiene la parte más simple, un crud de personas, sin ningún tipo de seguridad.

Las demás ramas fueron trabajadas con Spring Security, además de un poco de estilo.

Hay distintas branches, Spring Security en memoria, Spring Security usando JDBC... Cada una se entiende que tipo usa por el nombre de estas.

Ahora debes seguir algunas pautas.
Para poder ejecutar esta app debes realizar varios pasos:


1. Crea una base de datos en MySQL con el nombre que prefieras (te recomiendo llamarla 'bbdd_primeraapp' para no tener que modificarla después).

  
2. Configura el archivo application.properties modificando las siguientes partes (te muestro un ejemplo):

#Configuraciones de la base de datos

spring.datasource.url=jdbc:mysql://localhost:3306/bbdd_primeraapp  --> Introduce tu puerto y el nombre de la bbdd que creaste

spring.datasource.username=root --> Introduce el username para acceder a tu bbdd

spring.datasource.password=123456 --> Introduce la contraseña para acceder a tu bbdd

Luego ejecuta la base de datos.


3. (Si pruebas la rama de seguridad-roles) Agrega desde la base de datos algunos usuarios y roles para poder acceder (Debes haber ejecutado el programa antes de rellenar las tablas).

Ejemplo:

INSERT INTO `bbdd_primeraapp`.`users` (`user_id`, `enabled`, `password`, `username`) VALUES (1, 1, '$2a$10$WJkrk.OUbtwc67Pbfri0/.GEf7104PvMHitBTvV2Y5PqeXSnyGeE2', 'admin');

INSERT INTO `bbdd_primeraapp`.`users` (`user_id`, `enabled`, `password`, `username`) VALUES (2, 1, '$2a$10$WJkrk.OUbtwc67Pbfri0/.GEf7104PvMHitBTvV2Y5PqeXSnyGeE2', 'user1');

INSERT INTO `bbdd_primeraapp`.`users` (`user_id`, `enabled`, `password`, `username`) VALUES (3, 1, '$2a$10$WJkrk.OUbtwc67Pbfri0/.GEf7104PvMHitBTvV2Y5PqeXSnyGeE2', 'user2');
      
INSERT INTO `bbdd_primeraapp`.`roles` (`role_id`, `nombre`) VALUES ('1', 'ADMIN');

INSERT INTO `bbdd_primeraapp`.`roles` (`role_id`, `nombre`) VALUES ('2', 'USER');

INSERT INTO `bbdd_primeraapp`.`roles` (`role_id`, `nombre`) VALUES ('3', 'EDITOR');

INSERT INTO `bbdd_primeraapp`.`roles` (`role_id`, `nombre`) VALUES ('4', 'CREATOR');

INSERT INTO `bbdd_primeraapp`.`users_roles` (`user_id`, `role_id`) VALUES ('1', '1');

INSERT INTO `bbdd_primeraapp`.`users_roles` (`user_id`, `role_id`) VALUES ('2', '2');

INSERT INTO `bbdd_primeraapp`.`users_roles` (`user_id`, `role_id`) VALUES ('2', '4');

INSERT INTO `bbdd_primeraapp`.`users_roles` (`user_id`, `role_id`) VALUES ('3', '3');

Para probar la web debes introducir el username de alguno de los usuarios creados y la contraseña está encriptada pero para acceder tan solo debes escribir 'password'.

Si en lugar de probar esta rama (que es la más recomendable y completa) quieres probar otra, debes añadir datos tan solo a la tabla de users pero añadiendole otro campo llamado role_id.

5. ¡Disfruta de la Experiencia!
