package org.pxdev.service.impl;

import org.pxdev.domain.User;
import org.pxdev.repository.IUserRepository;
import org.pxdev.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public String getAllUser() {
        StringBuilder userSB = new StringBuilder();

        for ( User user : userRepository.findAll() ) {
            userSB.append( user.toString() ).append( "\n" );
        }

        return userSB.toString();
    }
}
