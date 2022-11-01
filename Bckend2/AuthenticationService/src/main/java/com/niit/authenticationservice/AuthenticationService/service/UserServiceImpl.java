package com.niit.authenticationservice.AuthenticationService.service;

import com.niit.authenticationservice.AuthenticationService.domain.User;
import com.niit.authenticationservice.AuthenticationService.exception.UserNotFoundException;
import com.niit.authenticationservice.AuthenticationService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) throws UserNotFoundException {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user == null)
        {
            throw new UserNotFoundException();
        }
        return user;
    }

//    public User findByUsernameAndPassword1(String username, String password) throws UserNotFoundException {
//        User user = userRepository.findByUsernameAndPassword(username, password);
//        if (user == null)
//        {
//            throw new UserNotFoundException();
//        } else if ((username=="admin1") )
//        {
//            return user;
//        }
//        return user;
//    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
