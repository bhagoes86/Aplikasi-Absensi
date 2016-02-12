package com.rizki.mufrizal.aplikasi.absensi.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 12, 2016
 * @Time 8:00:48 PM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Server
 * @Package com.rizki.mufrizal.aplikasi.absensi.domain
 *
 */
@Entity
@Table(name = "tb_absensi_hari", indexes = {
    @Index(name = "idAbsensiHari", columnList = "id_absensi_hari")
})
public class AbsenHari implements Serializable {

    @Id
    @Column(name = "id_absensi_hari", length = 150)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    private String idAbsensiHari;

    @Column(name = "hari", length = 10)
    private String hari;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "absenHari", targetEntity = AbsenKehadiran.class)
    private List<AbsenKehadiran> absenKehadirans = new ArrayList<>();

    /**
     * @return the idAbsensiHari
     */
    public String getIdAbsensiHari() {
        return idAbsensiHari;
    }

    /**
     * @param idAbsensiHari the idAbsensiHari to set
     */
    public void setIdAbsensiHari(String idAbsensiHari) {
        this.idAbsensiHari = idAbsensiHari;
    }

    /**
     * @return the hari
     */
    public String getHari() {
        return hari;
    }

    /**
     * @param hari the hari to set
     */
    public void setHari(String hari) {
        this.hari = hari;
    }

    /**
     * @return the absenKehadirans
     */
    public List<AbsenKehadiran> getAbsenKehadirans() {
        return absenKehadirans;
    }

    /**
     * @param absenKehadirans the absenKehadirans to set
     */
    public void setAbsenKehadirans(List<AbsenKehadiran> absenKehadirans) {
        this.absenKehadirans = absenKehadirans;
    }

}
