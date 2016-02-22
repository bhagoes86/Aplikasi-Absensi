package com.rizki.mufrizal.aplikasi.absensi.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.LocalDate;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 22, 2016
 * @Time 9:33:40 PM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Server
 * @Package com.rizki.mufrizal.aplikasi.absensi.serialization
 *
 */
public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

    @Override
    public LocalDate deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
        return LocalDate.parse(jp.getText());
    }

}
