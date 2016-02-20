package com.rizki.mufrizal.aplikasi.absensi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsViewResolver;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 14, 2016
 * @Time 11:49:24 AM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Server
 * @Package com.rizki.mufrizal.aplikasi.absensi.configuration
 *
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    @Bean
    public JasperReportsViewResolver getJasperReportsViewResolver() {
        JasperReportsViewResolver reportsViewResolver = new JasperReportsViewResolver();
        reportsViewResolver.setPrefix("classpath:/reports/");
        reportsViewResolver.setSuffix(".jrxml");
        reportsViewResolver.setViewNames("report_*");
        reportsViewResolver.setViewClass(JasperReportsMultiFormatView.class);
        reportsViewResolver.setOrder(0);
        return reportsViewResolver;
    }
}