package com.rizki.mufrizal.aplikasi.absensi.service;

import com.rizki.mufrizal.aplikasi.absensi.domain.AsistenRole;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.rizki.mufrizal.aplikasi.absensi.repository.AsistenRepository;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 12, 2016
 * @Time 7:24:25 PM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Server
 * @Package com.rizki.mufrizal.aplikasi.absensi.service
 *
 */
@Service
public class AsistenService implements UserDetailsService {

    @Autowired
    private AsistenRepository asistenRepository;

    @Override
    public UserDetails loadUserByUsername(String npm) throws UsernameNotFoundException {
        com.rizki.mufrizal.aplikasi.absensi.domain.Asisten asisten = asistenRepository.LoginAsisten(npm);

        if (asisten != null) {
            List<GrantedAuthority> authorities = buildUserAuthority(asisten.getAsistenRoles());
            return buildUserForAuthentication(asisten, authorities);
        }

        return null;
    }

    private User buildUserForAuthentication(com.rizki.mufrizal.aplikasi.absensi.domain.Asisten asisten, List<GrantedAuthority> grantedAuthorities) {
        return new User(asisten.getNpm(), asisten.getPassword(), asisten.getEnable(), true, true, true, grantedAuthorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<AsistenRole> asistenRoles) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        asistenRoles.stream().forEach((asistenRole) -> {
            grantedAuthorities.add(new SimpleGrantedAuthority(asistenRole.getRole()));
        });

        return new ArrayList<>(grantedAuthorities);
    }

}
