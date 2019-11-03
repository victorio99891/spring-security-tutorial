package pl.wiktor.testsecurity.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.wiktor.testsecurity.entity.UserEntity;
import pl.wiktor.testsecurity.repository.UserRepository;

import java.util.Optional;

@Slf4j
@Service
public class UserSecurityService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Optional<UserEntity> userToAuthenticate = userRepository.getByUsername(s);

        userToAuthenticate.orElseThrow(() -> {
            log.error(String.format("User with username: %s  not found!", s));
            throw new UsernameNotFoundException(String.format("User with username: %s  not found!", s));
        });

        return new UserSecurityDetails(userToAuthenticate.get());
    }
}
