package com.rizki.mufrizal.aplikasi.absensi.repository.eventHandler;

import com.rizki.mufrizal.aplikasi.absensi.domain.User;
import com.rizki.mufrizal.aplikasi.absensi.domain.UserRole;
import java.util.HashSet;
import java.util.Set;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 12, 2016
 * @Time 7:20:21 PM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Server
 * @Package com.rizki.mufrizal.aplikasi.absensi.repository.eventHandler
 *
 */
@Component
@RepositoryEventHandler(User.class)
public class UserRepositoryEventHandler {

    @HandleBeforeCreate
    public void handleUserCreate(User user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        UserRole userRole = new UserRole();
        userRole.setUser(user);

        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setUserRoles(userRoles);
    }

}
