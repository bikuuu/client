package com.biku.parcellocker.client.user;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitUser implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setUserName("biku");
        user.setPassword("1234");
        user.setEmail("biku@gmail.com");
        user.setRole(new SimpleGrantedAuthority("ROLE_USER"));
        userRepository.save(user);

        for (User user1 : userRepository.findAll()) {
            System.out.println(user1);
        }
    }
}
