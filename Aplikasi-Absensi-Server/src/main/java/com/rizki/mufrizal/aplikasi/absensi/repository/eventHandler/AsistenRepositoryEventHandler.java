package com.rizki.mufrizal.aplikasi.absensi.repository.eventHandler;

import com.rizki.mufrizal.aplikasi.absensi.domain.Asisten;
import com.rizki.mufrizal.aplikasi.absensi.domain.AsistenRole;
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
@RepositoryEventHandler(Asisten.class)
public class AsistenRepositoryEventHandler {

    @HandleBeforeCreate
    public void handleUserCreate(Asisten asisten) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        asisten.setPassword(bCryptPasswordEncoder.encode(asisten.getPassword()));

        AsistenRole asistenRole = new AsistenRole();
        asistenRole.setAsisten(asisten);

        Set<AsistenRole> asistenRoles = new HashSet<>();
        asistenRoles.add(asistenRole);
        asisten.setAsistenRoles(asistenRoles);
    }

}
