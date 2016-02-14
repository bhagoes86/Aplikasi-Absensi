package com.rizki.mufrizal.aplikasi.absensi.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 12, 2016
 * @Time 8:00:57 PM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Server
 * @Package com.rizki.mufrizal.aplikasi.absensi.domain
 *
 */
@Entity
@Table(name = "tb_absensi_asisten", indexes = {
    @Index(name = "idAbsenAsisten", columnList = "id_absen_asisten")
})
public class AbsensiAsisten implements Serializable {

    @Id
    @Column(name = "id_absen_asisten", length = 150)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    private String idAbsenAsisten;

    @Column(name = "npm_asisten", length = 8)
    private String npmAsisten;

    @Column(name = "nama_asisten", length = 50)
    private String namaAsisten;

    @Column(name = "nama_asisten_tetap", length = 50)
    private String namaAsistenTetap;

    @Column(name = "sesi")
    private Integer sesiJaga;

    @Column(name = "baris", length = 10)
    private String barisJaga;

    @Column(name = "hari", length = 10)
    private String hariJaga;

    @Temporal(TemporalType.TIMESTAMP)
    private Date tanggalJaga;
    
        @Column(name = "mata_praktikum", length = 50)
    private String mataPraktikum;

    @Column(name = "kelas_praktikum", length = 6)
    private String kelasPraktikum;

    @Column(name = "ruang_praktikum", length = 5)
    private String ruangPraktikum;

    /**
     * @return the idAbsenAsisten
     */
    public String getIdAbsenAsisten() {
        return idAbsenAsisten;
    }

    /**
     * @param idAbsenAsisten the idAbsenAsisten to set
     */
    public void setIdAbsenAsisten(String idAbsenAsisten) {
        this.idAbsenAsisten = idAbsenAsisten;
    }

    /**
     * @return the npmAsisten
     */
    public String getNpmAsisten() {
        return npmAsisten;
    }

    /**
     * @param npmAsisten the npmAsisten to set
     */
    public void setNpmAsisten(String npmAsisten) {
        this.npmAsisten = npmAsisten;
    }

    /**
     * @return the namaAsisten
     */
    public String getNamaAsisten() {
        return namaAsisten;
    }

    /**
     * @param namaAsisten the namaAsisten to set
     */
    public void setNamaAsisten(String namaAsisten) {
        this.namaAsisten = namaAsisten;
    }

    /**
     * @return the namaAsistenTetap
     */
    public String getNamaAsistenTetap() {
        return namaAsistenTetap;
    }

    /**
     * @param namaAsistenTetap the namaAsistenTetap to set
     */
    public void setNamaAsistenTetap(String namaAsistenTetap) {
        this.namaAsistenTetap = namaAsistenTetap;
    }

    /**
     * @return the sesiJaga
     */
    public Integer getSesiJaga() {
        return sesiJaga;
    }

    /**
     * @param sesiJaga the sesiJaga to set
     */
    public void setSesiJaga(Integer sesiJaga) {
        this.sesiJaga = sesiJaga;
    }

    /**
     * @return the barisJaga
     */
    public String getBarisJaga() {
        return barisJaga;
    }

    /**
     * @param barisJaga the barisJaga to set
     */
    public void setBarisJaga(String barisJaga) {
        this.barisJaga = barisJaga;
    }

    /**
     * @return the hariJaga
     */
    public String getHariJaga() {
        return hariJaga;
    }

    /**
     * @param hariJaga the hariJaga to set
     */
    public void setHariJaga(String hariJaga) {
        this.hariJaga = hariJaga;
    }

    /**
     * @return the tanggalJaga
     */
    public Date getTanggalJaga() {
        return tanggalJaga;
    }

    /**
     * @param tanggalJaga the tanggalJaga to set
     */
    public void setTanggalJaga(Date tanggalJaga) {
        this.tanggalJaga = tanggalJaga;
    }

    /**
     * @return the mataPraktikum
     */
    public String getMataPraktikum() {
        return mataPraktikum;
    }

    /**
     * @param mataPraktikum the mataPraktikum to set
     */
    public void setMataPraktikum(String mataPraktikum) {
        this.mataPraktikum = mataPraktikum;
    }

    /**
     * @return the kelasPraktikum
     */
    public String getKelasPraktikum() {
        return kelasPraktikum;
    }

    /**
     * @param kelasPraktikum the kelasPraktikum to set
     */
    public void setKelasPraktikum(String kelasPraktikum) {
        this.kelasPraktikum = kelasPraktikum;
    }

    /**
     * @return the ruangPraktikum
     */
    public String getRuangPraktikum() {
        return ruangPraktikum;
    }

    /**
     * @param ruangPraktikum the ruangPraktikum to set
     */
    public void setRuangPraktikum(String ruangPraktikum) {
        this.ruangPraktikum = ruangPraktikum;
    }

}
