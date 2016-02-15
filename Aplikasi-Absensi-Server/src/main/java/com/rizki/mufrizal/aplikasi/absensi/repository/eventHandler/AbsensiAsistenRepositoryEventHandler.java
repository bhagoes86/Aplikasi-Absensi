package com.rizki.mufrizal.aplikasi.absensi.repository.eventHandler;

import com.rizki.mufrizal.aplikasi.absensi.domain.AbsensiAsisten;
import com.rizki.mufrizal.aplikasi.absensi.domain.Asisten;
import com.rizki.mufrizal.aplikasi.absensi.repository.AsistenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 15, 2016
 * @Time 6:16:07 PM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Server
 * @Package com.rizki.mufrizal.aplikasi.absensi.repository.eventHandler
 *
 */
@Component
@RepositoryEventHandler(AbsensiAsisten.class)
public class AbsensiAsistenRepositoryEventHandler {

    @Autowired
    private AsistenRepository asistenRepository;

    @HandleBeforeCreate
    public void handleAbsensiAsistenCreate(AbsensiAsisten absensiAsisten) {
        Asisten asisten = asistenRepository.findOne(absensiAsisten.getNpmAsisten());
        absensiAsisten.setNamaAsisten(asisten.getNama());
    }

}
