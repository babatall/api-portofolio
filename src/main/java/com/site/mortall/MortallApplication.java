package com.site.mortall;

import com.site.mortall.entity.Role;
import com.site.mortall.entity.Utilisateur;
import com.site.mortall.repository.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class MortallApplication {

	public static void main(String[] args) {
		SpringApplication.run(MortallApplication.class, args);
	}

	@Bean
	CommandLineRunner initAdmin(UtilisateurRepository repo, PasswordEncoder encoder) {
		return args -> {
			if (repo.findByEmail("admin@mortall.com").isEmpty()) {
				Utilisateur admin = new Utilisateur();
				admin.setEmail("admin@mortall.com");
				admin.setMotDePasse(encoder.encode("T@ll12!!"));
				admin.setRole(Role.ADMIN);
				repo.save(admin);
			}
		};
	}
}