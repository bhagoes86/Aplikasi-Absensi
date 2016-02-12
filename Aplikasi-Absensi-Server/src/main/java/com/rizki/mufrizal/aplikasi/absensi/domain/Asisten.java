package com.rizki.mufrizal.aplikasi.absensi.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 12, 2016
 * @Time 7:17:37 PM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Server
 * @Package com.rizki.mufrizal.aplikasi.absensi.domain
 *
 */
@Entity
@Table(name = "tb_user", indexes = {
    @Index(columnList = "email", name = "email"),
    @Index(columnList = "nama", name = "nama")
})
public class Asisten implements Serializable {

    @Id
    @Column(name = "npm", length = 8)
    private String npm;

    @Column(name = "nama", length = 50)
    private String nama;

    @Column(name = "kelas", length = 6)
    private String kelas;

    @Column(name = "password", length = 150)
    private String password;

    @Column(name = "enable", length = 50)
    private Boolean enable = Boolean.TRUE;

    @OneToMany(mappedBy = "asisten", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<AsistenRole> asistenRoles = new HashSet<>();

    @OneToMany(mappedBy = "asisten", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<AbsenKehadiran> absenKehadirans = new HashSet<>();

    /**
     * @return the npm
     */
    public String getNpm() {
        return npm;
    }

    /**
     * @param npm the npm to set
     */
    public void setNpm(String npm) {
        this.npm = npm;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the kelas
     */
    public String getKelas() {
        return kelas;
    }

    /**
     * @param kelas the kelas to set
     */
    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the enable
     */
    public Boolean getEnable() {
        return enable;
    }

    /**
     * @param enable the enable to set
     */
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    /**
     * @return the asistenRoles
     */
    public Set<AsistenRole> getAsistenRoles() {
        return asistenRoles;
    }

    /**
     * @param asistenRoles the asistenRoles to set
     */
    public void setAsistenRoles(Set<AsistenRole> asistenRoles) {
        this.asistenRoles = asistenRoles;
    }

    /**
     * @return the absenKehadirans
     */
    public Set<AbsenKehadiran> getAbsenKehadirans() {
        return absenKehadirans;
    }

    /**
     * @param absenKehadirans the absenKehadirans to set
     */
    public void setAbsenKehadirans(Set<AbsenKehadiran> absenKehadirans) {
        this.absenKehadirans = absenKehadirans;
    }

}
