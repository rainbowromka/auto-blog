package ru.autoblog.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import ru.autoblog.model.User;
import ru.autoblog.repo.UserRepository;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepoTest
{
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByUsername() throws Exception
    {
        User user = new User();
        user.setUserName("andrey");
        user.setPassword("password2");
        user.setRole("ADMIN");
        testEntityManager.persist(user);
        user = new User();
        user.setUserName("roman");
        user.setPassword("password");
        user.setRole("USER");
        testEntityManager.persist(user);
        testEntityManager.flush();

        User actual = userRepository.findByUserName("roman");
        assertThat(actual).isEqualTo(user);
    }

    @Test
    public void save()
    throws Exception
    {
        User user = new User();
        user.setUserName("roman");
        user.setPassword("passowrd");
        user.setRole("USER");

        User actual = userRepository.save(user);

        assertThat(actual).isNotNull();
        assertThat(actual.getId()).isNotNull();
    }
}
