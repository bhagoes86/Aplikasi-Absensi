package com.rizki.mufrizal.aplikasi.absensi.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.time.LocalDate;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 22, 2016
 * @Time 9:31:28 PM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Server
 * @Package com.rizki.mufrizal.aplikasi.absensi.serialization
 *
 */
public class LocalDateSerializer extends JsonSerializer<LocalDate> {

    @Override
    public void serialize(LocalDate t, JsonGenerator jg, SerializerProvider sp) throws IOException, JsonProcessingException {
        jg.writeString(t.toString());
    }

}
