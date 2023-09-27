USE pering;

-- insert tech skills
INSERT into tech_skills(id, name)  VALUES(1, "Java");

INSERT INTO tech_skills(id, name) VALUES (2, "Python");

-- 3. JavaScript
INSERT INTO tech_skills(id, name) VALUES (3, "JavaScript");

-- 4. C++
INSERT INTO tech_skills(id, name) VALUES (4, "C++");

-- 5. Ruby
INSERT INTO tech_skills(id, name) VALUES (5, "Ruby");

-- 6. PHP
INSERT INTO tech_skills(id, name) VALUES (6, "PHP");

-- 7. Swift
INSERT INTO tech_skills(id, name) VALUES (7, "Swift");

-- 8. Kotlin
INSERT INTO tech_skills(id, name) VALUES (8, "Kotlin");

-- 9. C#
INSERT INTO tech_skills(id, name) VALUES (9, "C#");

-- 10. SQL
INSERT INTO tech_skills(id, name) VALUES (10, "SQL");

-- 11. HTML
INSERT INTO tech_skills(id, name) VALUES (11, "HTML");

-- 12. CSS
INSERT INTO tech_skills(id, name) VALUES (12, "CSS");

-- 13. React
INSERT INTO tech_skills(id, name) VALUES (13, "React");

-- 14. Angular
INSERT INTO tech_skills(id, name) VALUES (14, "Angular");

-- 15. Vue.js
INSERT INTO tech_skills(id, name) VALUES (15, "Vue.js");

-- 16. Docker
INSERT INTO tech_skills(id, name) VALUES (16, "Docker");

-- 17. Kubernetes
INSERT INTO tech_skills(id, name) VALUES (17, "Kubernetes");

-- 18. AWS
INSERT INTO tech_skills(id, name) VALUES (18, "AWS");

-- 19. Azure
INSERT INTO tech_skills(id, name) VALUES (19, "Azure");

-- 20. Git
INSERT INTO tech_skills(id, name) VALUES (20, "Git");

-- 21. Jenkins
INSERT INTO tech_skills(id, name) VALUES (21, "Jenkins");

-- 22. Terraform
INSERT INTO tech_skills(id, name) VALUES (22, "Terraform");

-- 23. Spring Framework
INSERT INTO tech_skills(id, name) VALUES (23, "Spring Framework");

-- 24. Ruby on Rails
INSERT INTO tech_skills(id, name) VALUES (24, "Ruby on Rails");

-- ----------------------------
-- Insert soft skills
INSERT INTO soft_skills (name) 
VALUES ('Mentalidad de crecimiento');
INSERT INTO soft_skills (name) 
VALUES ('Orientación al futuro');
INSERT INTO soft_skills (name) 
VALUES ('Orientación al detalle');
INSERT INTO soft_skills (name) 
VALUES ('Comunicación');
INSERT INTO soft_skills (name) 
VALUES ('Responsabilidad Personal');
INSERT INTO soft_skills (name) 
VALUES ('Persistencia');
INSERT INTO soft_skills (name) 
VALUES ('Proactividad');
INSERT INTO soft_skills (name) 
VALUES ('Trabajo en equipo');

-- -------------------------------------------------------------------------------------

-- insert hashtag
INSERT INTO hashtag (name) VALUES
    ('Java'),
    ('Python'),
    ('JavaScript'),
    ('C#'),
    ('C++'),
    ('Ruby'),
    ('Swift'),
    ('PHP'),
    ('Go'),
    ('Kotlin'),
    ('Rust');

-- -------------------------------------------------------------------------------------


-- Insert Usuarios

INSERT INTO `pering`.`users` (`username`, `firstname`, `lastname`, `email`, `password`, `profilepic`, `description`, `register_date`)
VALUES
  ('Usuario1', 'Juan', 'Pérez', 'juan@example.com', 'contraseña1', 'https://ae01.alicdn.com/kf/H59d4be5f2fa14c07ae747c79dd8a8fa0B/Perry-The-Platypus-Beautiful-Icons-Pins-Badge-Decoration-Brooches-Metal-Badges-For-Clothes-Backpack-Decoration-58mm.jpg', 'Descripción de Usuario1', '2023-09-18'),
  ('Usuario2', 'María', 'González', 'maria@example.com', 'contraseña2', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQP2O7jVvsiu6VAzLenct84ihy4L0xdHn4Omg&usqp=CAU', 'Descripción de Usuario2', '2023-09-18'),
  ('Usuario3', 'Carlos', 'López', 'carlos@example.com', 'contraseña3', 'https://w7.pngwing.com/pngs/897/929/png-transparent-phineas-flynn-perry-the-platypus-ferb-fletcher-candace-flynn-dr-heinz-doofenshmirtz-others-hat-cartoon-unlimited.png', 'Descripción de Usuario3', '2023-09-18'),
  ('Usuario4', 'Ana', 'Martínez', 'ana@example.com', 'contraseña4',  'https://ae01.alicdn.com/kf/H59d4be5f2fa14c07ae747c79dd8a8fa0B/Perry-The-Platypus-Beautiful-Icons-Pins-Badge-Decoration-Brooches-Metal-Badges-For-Clothes-Backpack-Decoration-58mm.jpg', 'Descripción de Usuario4', '2023-09-18'),
  ('Usuario5', 'Luis', 'Rodríguez', 'luis@example.com', 'contraseña5',  'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQP2O7jVvsiu6VAzLenct84ihy4L0xdHn4Omg&usqp=CAU', 'Descripción de Usuario5', '2023-09-18');



-- --------------------------------------

-- Insert connection

INSERT INTO connections (acepted, sender, receiver) 
VALUES
('1', 1, 2),
('0', 2, 3),
('1', 3, 4),
('0', 4, 5),
('0', 5, 1);


-- insert post


INSERT INTO posts (publication_date, likes, content, fk_users_id, fk_hashtag_id)
	VALUES(CURRENT_TIMESTAMP(), 6, "Hola, soy un apasionado de programación. Actualmente estoy trabajando en un nuevo proyecto propio, sobre una networking, solo que me gustaría colaborar con personas dedicadas al Frontend. Contáctame si te interesa.", 1, 4);
    
INSERT INTO posts (publication_date, likes, content, fk_users_id, fk_hashtag_id)
	VALUES(CURRENT_TIMESTAMP(), 1, "Estoy interesado en encontrar programadores recién egresados con gran interés en crecer profesionalmente y comenzar un camino como freelancer, principalmente con enfoque a fullstack en desarrollo web.", 2, 8);

INSERT INTO posts (publication_date, likes, content, fk_users_id, fk_hashtag_id)
	VALUES(CURRENT_TIMESTAMP(), 0, "Busco urgentemente un desarrollador web que me pueda ayudar con la base de datos de un pequeño e-commerce, el proyecto se debe entregar en dos semanas.", 3, 2);
    
INSERT INTO posts (publication_date, likes, content, fk_users_id, fk_hashtag_id)
	VALUES(CURRENT_TIMESTAMP(), 2, "Me gustaría poder colaborar con personas interesadas en base de datos para un nuevo proyecto de una red social, principalmente con enfoque en SQL.", 4, 2);
    
INSERT INTO posts (publication_date, likes, content, fk_users_id, fk_hashtag_id)
	VALUES(CURRENT_TIMESTAMP(), 1, "Soy un estudiante de ingeniería de software y me gustaría comenzar a aprender como se trabaja dentro del área de desarrollo web, principalmente enfocado en frontend. Busco proyectos pequeños en los cuales pueda poner a prueba mis habilidades.", 5, 4);

-- -------------------------------------------------------------------------------------

-- Insert Comentarios
INSERT INTO comments (id, content, likes, comment_date, fk_posts_id, fk_users_id)
VALUES (1, "Me puedes comentar más información al respecto, por favor.", 1, CURRENT_TIMESTAMP(), 1, 1);

-- Inserción 2
INSERT INTO comments (id, content, likes, comment_date, fk_posts_id, fk_users_id)
VALUES (2, "Éxito en tu protecto.", 5, CURRENT_TIMESTAMP(), 1, 2);

-- Inserción 3
INSERT INTO comments (id, content, likes, comment_date, fk_posts_id, fk_users_id)
VALUES (3, "Ponte en contacto con Joaquín Z.", 2, CURRENT_TIMESTAMP(), 2, 3);

-- Inserción 4
INSERT INTO comments (id, content, likes, comment_date, fk_posts_id, fk_users_id)
VALUES (4, "Parece ser un excelente proyecto", 4, CURRENT_TIMESTAMP(), 2, 4);

-- Inserción 5
INSERT INTO comments (id, content, likes, comment_date, fk_posts_id, fk_users_id)
VALUES (5, "Detalles por favor", 3, CURRENT_TIMESTAMP(), 3, 5);

-- Inserción 6
INSERT INTO comments (id, content, likes, comment_date, fk_posts_id, fk_users_id)
VALUES (6, "Me fascina la idea", 11, CURRENT_TIMESTAMP(), 3, 4);

-- Inserción 7
INSERT INTO comments (id, content, likes, comment_date, fk_posts_id, fk_users_id)
VALUES (7, "Estoy interesado", 1, CURRENT_TIMESTAMP(), 4, 4);

-- Inserción 8
INSERT INTO comments (id, content, likes, comment_date, fk_posts_id, fk_users_id)
VALUES (8, "¿Cómo vas con tu proyecto?", 7, CURRENT_TIMESTAMP(), 4, 3);

-- Inserción 9
INSERT INTO comments (id, content, likes, comment_date, fk_posts_id, fk_users_id)
VALUES (9, "Parece dicifil :c", 3, CURRENT_TIMESTAMP(), 5, 5);

-- Inserción 10
INSERT INTO comments (id, content, likes, comment_date, fk_posts_id, fk_users_id)
VALUES (10, "Juan Z  es muy bueno trabajando Java", 15, CURRENT_TIMESTAMP(), 5, 1);

-- -------------------------------------------------------------------------------------
