package com.rizki.mufrizal.aplikasi.absensi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 12, 2016
 * @Time 7:28:05 PM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Server
 * @Package com.rizki.mufrizal.aplikasi.absensi
 *
 */
@SpringBootApplication
@EnableRedisHttpSession
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class AplikasiAbsensi {

    public static void main(String[] args) {
        SpringApplication.run(AplikasiAbsensi.class, args);
    }

}
