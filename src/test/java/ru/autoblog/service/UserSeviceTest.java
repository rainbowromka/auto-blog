package ru.autoblog.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import ru.autoblog.model.User;
import ru.autoblog.repo.UserRepository;
import ru.autoblog.services.UserService;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class UserSeviceTest
{
    @MockBean
    private UserRepository userRepository;

    private UserService userService;

    @Before
    public void init()
    {
        this.userService = new UserService(userRepository);
    }

    @Test
    public void getAllUsers() {
        User user = new User();
        user.setUserName("roman");
        user.setPassword("password");
        user.setRole("USER");

        when(userRepository.findByUserName("roman")).thenReturn(user);

//        UserDetails actual = userService.loadUserByUsername("roman");

        verify(userRepository, times(1)).findByUserName("roman");
    }
}
