package com.github.cawtoz.enfokids.config;

import com.github.cawtoz.enfokids.model.role.Role;
import com.github.cawtoz.enfokids.model.role.RoleEnum;
import com.github.cawtoz.enfokids.model.user.types.Caregiver;
import com.github.cawtoz.enfokids.model.user.types.Child;
import com.github.cawtoz.enfokids.model.user.types.Therapist;
import com.github.cawtoz.enfokids.model.user.User;
import com.github.cawtoz.enfokids.repository.RoleRepository;
import com.github.cawtoz.enfokids.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@Profile("default")
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Crear roles si no existen
        createRoleIfNotFound(RoleEnum.ADMIN);
        createRoleIfNotFound(RoleEnum.THERAPIST);
        createRoleIfNotFound(RoleEnum.CAREGIVER);
        createRoleIfNotFound(RoleEnum.CHILD);
        createRoleIfNotFound(RoleEnum.USER);

        // Crear usuarios de prueba
        createTherapistIfNotFound();
        createCaregiverIfNotFound();
        createChildIfNotFound();
    }

    private void createRoleIfNotFound(RoleEnum roleEnum) {
        Optional<Role> existing = roleRepository.findByName(roleEnum);
        if (existing.isEmpty()) {
            Role r = new Role();
            r.setName(roleEnum);
            roleRepository.save(r);
        }
    }

    private void createTherapistIfNotFound() {
        String username = "therapist";
        if (userRepository.findByUsername(username).isPresent()) return;

        Therapist t = new Therapist();
        t.setUsername(username);
        t.setPassword(passwordEncoder.encode("therapistpass"));
        t.setEmail("therapist@example.com");
        t.setFirstName("Ana");
        t.setLastName("Terapeuta");
        t.setSpeciality("Terapia conductual");

        Role role = roleRepository.findByName(RoleEnum.THERAPIST).orElseThrow();
        t.getRoles().add(role);

        userRepository.save(t);
    }

    private void createCaregiverIfNotFound() {
        String username = "caregiver";
        if (userRepository.findByUsername(username).isPresent()) return;

        Caregiver c = new Caregiver();
        c.setUsername(username);
        c.setPassword(passwordEncoder.encode("caregiverpass"));
        c.setEmail("caregiver@example.com");
        c.setFirstName("Carlos");
        c.setLastName("Cuidador");

        Role role = roleRepository.findByName(RoleEnum.CAREGIVER).orElseThrow();
        c.getRoles().add(role);

        userRepository.save(c);
    }

    private void createChildIfNotFound() {
        String username = "child";
        if (userRepository.findByUsername(username).isPresent()) return;

        // Necesitamos asignar un terapeuta existente
        Optional<User> therapistOpt = userRepository.findByUsername("therapist1");
        if (therapistOpt.isEmpty()) return; // si no existe el terapeuta, saltar

        Therapist therapist = (Therapist) therapistOpt.get();

    Child ch = new Child();
    ch.setUsername(username);
    ch.setPassword(passwordEncoder.encode("childpass"));
    ch.setEmail("child@example.com");
        ch.setFirstName("Pepe");
        ch.setLastName("Niño");
        ch.setDiagnosis("TDAH leve");
        ch.setTherapist(therapist);

        Role role = roleRepository.findByName(RoleEnum.CHILD).orElseThrow();
        ch.getRoles().add(role);

        userRepository.save(ch);
    }
}
