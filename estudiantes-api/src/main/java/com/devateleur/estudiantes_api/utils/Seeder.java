package com.devateleur.estudiantes_api.utils;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;

import com.devateleur.estudiantes_api.model.Alumno;
import com.devateleur.estudiantes_api.model.Materia;
import com.devateleur.estudiantes_api.model.Role;
import com.devateleur.estudiantes_api.model.User;
import com.devateleur.estudiantes_api.repository.AlumnoRepository;
import com.devateleur.estudiantes_api.repository.MateriaRepository;
import com.devateleur.estudiantes_api.repository.UserRepository;

@Component
public class Seeder implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    private static final Logger logger = LoggerFactory.getLogger(Seeder.class);

    @Override
    public void run(String... args) throws Exception {

        // creación de roles

        // Creación de usuarios
        if (userRepository.count() == 0) {

            User admin = new User();
            admin.setName("Admin");
            admin.setUsername("admin");
            admin.setEmail("admin@example.com");
            admin.setPassword("123123123");
            admin.setRole(Role.ROLE_ADMIN);

            User client = new User();
            client.setName("User");
            client.setUsername("user");
            client.setEmail("user@example.com");
            client.setPassword("123123123");
            client.setRole(Role.ROLE_CLIENT);

            // Guardar usuarios en la base de datos
            userRepository.save(admin);
            userRepository.save(client);

            logger.info("Guardando usuarios en la base de datos");
        }

        // Creación de materias
        if (materiaRepository.count() == 0) {
            String[] nombresMaterias = {
                    "Matemática", "Historia", "Ciencias", "Geografía", "Física",
                    "Química", "Biología", "Literatura", "Filosofía", "Arte",
                    "Música", "Educación Física", "Informática", "Economía", "Psicología",
                    "Sociología", "Política", "Derecho", "Medicina", "Ingeniería"
            };

            for (String nombre : nombresMaterias) {
                Materia materia = new Materia();
                materia.setNombre(nombre);
                materiaRepository.save(materia);
            }

            logger.info("Guardando materias en la base de datos");
        }

        // Creación de alumnas y asignación de materias
        if (alumnoRepository.count() == 0) {
            Alumno alumna1 = new Alumno();
            alumna1.setRut("12345678-9");
            alumna1.setNombre("Ana Pérez");
            alumna1.setDireccion("Calle Falsa 123");

            Alumno alumna2 = new Alumno();
            alumna2.setRut("98765432-1");
            alumna2.setNombre("María López");
            alumna2.setDireccion("Avenida Siempre Viva 742");

            Alumno alumna3 = new Alumno();
            alumna3.setRut("12345678-1");
            alumna3.setNombre("Laura Gómez");
            alumna3.setDireccion("Calle 1");

            Alumno alumna4 = new Alumno();
            alumna4.setRut("12345678-2");
            alumna4.setNombre("Sofía Martínez");
            alumna4.setDireccion("Calle 2");

            Alumno alumna5 = new Alumno();
            alumna5.setRut("12345678-3");
            alumna5.setNombre("Lucía Fernández");
            alumna5.setDireccion("Calle 3");

            Alumno alumno1 = new Alumno();
            alumno1.setRut("98765432-2");
            alumno1.setNombre("Carlos Sánchez");
            alumno1.setDireccion("Avenida 1");

            Alumno alumno2 = new Alumno();
            alumno2.setRut("98765432-3");
            alumno2.setNombre("Miguel Torres");
            alumno2.setDireccion("Avenida 2");

            Alumno alumno3 = new Alumno();
            alumno3.setRut("98765432-4");
            alumno3.setNombre("Juan Pérez");
            alumno3.setDireccion("Avenida 3");

            Alumno alumno4 = new Alumno();
            alumno4.setRut("98765432-5");
            alumno4.setNombre("Luis Gómez");
            alumno4.setDireccion("Avenida 4");

            Alumno alumno5 = new Alumno();
            alumno5.setRut("98765432-6");
            alumno5.setNombre("Javier López");
            alumno5.setDireccion("Avenida 5");

            alumnoRepository.save(alumna1);
            alumnoRepository.save(alumna2);
            alumnoRepository.save(alumna3);
            alumnoRepository.save(alumna4);
            alumnoRepository.save(alumna5);
            alumnoRepository.save(alumno1);
            alumnoRepository.save(alumno2);
            alumnoRepository.save(alumno3);
            alumnoRepository.save(alumno4);
            alumnoRepository.save(alumno5);

            logger.info("Guardando alumnas en la base de datos");
        }
    }
}