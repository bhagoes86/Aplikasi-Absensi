package com.rizki.mufrizal.aplikasi.absensi.controller;

import com.rizki.mufrizal.aplikasi.absensi.domain.Asisten;
import com.rizki.mufrizal.aplikasi.absensi.repository.AbsensiAsistenRepository;
import com.rizki.mufrizal.aplikasi.absensi.repository.AsistenRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 15, 2016
 * @Time 2:48:28 PM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Server
 * @Package com.rizki.mufrizal.aplikasi.absensi.controller
 *
 */
@Controller
public class ReportController {

    @Autowired
    private AsistenRepository asistenRepository;

    @Autowired
    private AbsensiAsistenRepository absensiAsistenRepository;

    @RequestMapping(value = "/KartuAsisten", method = RequestMethod.GET)
    public ModelAndView generateKartuAsisten(
            ModelAndView modelAndView,
            @RequestParam(value = "npm") String npm) {

        Asisten asisten = asistenRepository.findOne(npm);

        List<Asisten> asistens = new ArrayList<>();
        asistens.add(asisten);

        modelAndView.addObject("dataSource", asistens);
        modelAndView.addObject("format", "pdf");

        modelAndView.setViewName("report_kartu_asisten");
        return modelAndView;
    }

    @RequestMapping(value = "/LaporanAbsensiAsisten", method = RequestMethod.GET)
    public ModelAndView generateLaporanAbsensiAsisten(
            ModelAndView modelAndView) {

        modelAndView.addObject("dataSource", absensiAsistenRepository.findAll());
        modelAndView.addObject("format", "pdf");

        modelAndView.setViewName("report_absensi_asisten");
        return modelAndView;
    }

    @RequestMapping(value = "/LaporanAbsensiAsistenPerTanggal", method = RequestMethod.GET)
    public ModelAndView generateLaporanAbsensiAsistenBerdasarkanTanggal(
            ModelAndView modelAndView,
            @RequestParam(value = "tanggalAwal") String tanggalAwal,
            @RequestParam(value = "tanggalAkhir") String tanggalAkhir) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date dateAwal = simpleDateFormat.parse(tanggalAwal);
        Date dateAKhir = simpleDateFormat.parse(tanggalAkhir);

        LocalDate localDateAwal = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dateAwal));
        LocalDate localDateAkhir = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dateAKhir));

        modelAndView.addObject("dataSource", absensiAsistenRepository.findByTanggalJagaBetween(localDateAwal, localDateAkhir));
        modelAndView.addObject("format", "pdf");

        modelAndView.setViewName("report_absensi_asisten");
        return modelAndView;
    }

}
