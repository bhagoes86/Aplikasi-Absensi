package com.rizki.mufrizal.aplikasi.absensi.controller;

import com.rizki.mufrizal.aplikasi.absensi.domain.Asisten;
import com.rizki.mufrizal.aplikasi.absensi.repository.AsistenRepository;
import java.util.ArrayList;
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

}
