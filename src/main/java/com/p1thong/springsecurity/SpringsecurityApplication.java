package com.p1thong.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.p1thong.springsecurity.entity.Role;
import com.p1thong.springsecurity.entity.User;
import com.p1thong.springsecurity.repository.UserRepository;

@SpringBootApplication
public class SpringsecurityApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User adminAccount = userRepository.findByRole(Role.ADMIN);
		if(null == adminAccount) {
			User user = new User();
			user.setFullname("Pham Nhat Thong");
			user.setEmail("thongpnse184826@fpt.edu.vn");
			user.setPassword(new BCryptPasswordEncoder().encode("blackpink8816"));
			user.setRole(Role.ADMIN);

			userRepository.save(user);
		}
	}
}