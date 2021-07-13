package ru.autoblog.services;


//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import ru.autoblog.model.User;
import ru.autoblog.repo.UserRepository;

import java.util.Arrays;

public class UserService
//implements UserDetailsService
{
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
//    public UserDetails loadUserByUsername(String userName)
//            throws UsernameNotFoundException
//    {
//        User user = userRepository.findByUserName(userName);
//
//        if (user == null)
//        {
//            throw new UsernameNotFoundException(userName);
//        }
//
//        return new org.springframework.security.core.userdetails.User(
//                user.getUserName(), user.getPassword(),
//                Arrays.asList(new SimpleGrantedAuthority(user.getRole())));
//    }

    @Transactional(rollbackFor = Exception.class)
    public User create(User user)
    {
        return userRepository.save(user);
    }
}
