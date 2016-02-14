package com.rizki.mufrizal.aplikasi.absensi.controller;

import com.rizki.mufrizal.aplikasi.absensi.domain.Asisten;
import com.rizki.mufrizal.aplikasi.absensi.repository.AsistenRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 14, 2016
 * @Time 11:59:16 PM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Server
 * @Package com.rizki.mufrizal.aplikasi.absensi.controller
 *
 */
@RestController
@RequestMapping(value = "/api")
public class AsistenAuthController {

    @Autowired
    private AsistenRepository asistenRepository;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/auth", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> authenticateUser(@RequestBody Asisten asisten) {

        Asisten a = asistenRepository.LoginAsisten(asisten.getNpm());

        Map<String, Object> map = new HashMap<>();

        if (a != null) {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            if (bCryptPasswordEncoder.matches(asisten.getPassword(), a.getPassword())) {
                map.put("success", Boolean.TRUE);
                map.put("info", "anda berhasil login");
                map.put("token", UUID.randomUUID().toString());
            } else {
                map.put("success", Boolean.FALSE);
                map.put("info", "password anda salah");
            }
        } else {
            map.put("success", Boolean.FALSE);
            map.put("info", "username dan password salah");
        }

        return map;
    }

}
