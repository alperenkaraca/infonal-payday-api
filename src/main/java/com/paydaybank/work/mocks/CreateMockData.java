package com.paydaybank.work.mocks;

import com.paydaybank.work.entity.Product;
import com.paydaybank.work.entity.Role;
import com.paydaybank.work.entity.RoleName;
import com.paydaybank.work.entity.User;
import com.paydaybank.work.repository.ProductRepository;
import com.paydaybank.work.repository.RoleRepository;
import com.paydaybank.work.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Configuration
public class CreateMockData {

    private final PasswordEncoder encoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    @Autowired
    public CreateMockData(PasswordEncoder encoder,UserRepository userRepository,RoleRepository roleRepository) {
        this.encoder = encoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Bean
    public CommandLineRunner initializeRoles(RoleRepository roleRepository) {
        if (roleRepository.count() == 0) {
            return args -> {
                roleRepository.save(new Role(RoleName.ROLE_USER));
                roleRepository.save(new Role(RoleName.ROLE_ADMIN));
            };
        }
        return null;

    }

    @Bean
    public CommandLineRunner initializeUser(UserRepository userRepository) {
        if (userRepository.count() == 0) {
            return args -> {
                Set<Role> roles = new HashSet<>();
                Optional<Role> userRole = roleRepository.findByName(RoleName.ROLE_USER);
                roles.add(userRole.orElse(null));
                userRepository.save(new User("username","deneme@deneme.com",encoder.encode("123456"),"CEO",roles));
            };
        }
        return null;

    }

    @Bean
    public CommandLineRunner initializeProduct(ProductRepository productRepository) {
        productRepository.save(new Product("product1",12.00,true,"denedim oldu aalalalalalalalall l lal al alal alla ll l l ll al slldalalsdlalsdlasldlasld"));
        productRepository.save(new Product("product2",11.05,true,"denedim oldu"));
        productRepository.save(new Product("product3",13.03,true,"denedim oldu"));
        return null;

    }

}
