package ru.autoblog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.autoblog.model.User;

/**
 * Репозиторий пользователя.
 */
public interface UserRepository extends JpaRepository<User, Long>
{
    User findByUserName(String username);
}
