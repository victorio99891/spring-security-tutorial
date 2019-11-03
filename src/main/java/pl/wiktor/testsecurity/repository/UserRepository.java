package pl.wiktor.testsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wiktor.testsecurity.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> getByUsername(String userName);
}
