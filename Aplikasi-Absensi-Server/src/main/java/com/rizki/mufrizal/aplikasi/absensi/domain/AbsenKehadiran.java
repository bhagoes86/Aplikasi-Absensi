package com.rizki.mufrizal.aplikasi.absensi.domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
@Table(name = "tb_absensi_kehadiran", indexes = {
    @Index(name = "idAbsenKehadiran", columnList = "id_absen_kehadiran")
})
public class AbsenKehadiran implements Serializable {

    @Id
    @Column(name = "id_absen_kehadiran", length = 150)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    private String idAbsenKehadiran;

    @Column(name = "mata_praktikum", length = 50)
    private String mataPraktikum;

    @Column(name = "kelas_praktikum", length = 6)
    private String kelasPraktikum;

    @Column(name = "ruang_praktikum", length = 5)
    private String ruangPraktikum;

    @Column(name = "nama_asisten_tetap", length = 50)
    private String namaAsistenTetap;

    @Column(name = "sesi")
    private Integer sesi;

    @Column(name = "baris", length = 10)
    private String baris;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "idAbsensiHari", nullable = false, foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private AbsenHari absenHari = new AbsenHari();

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "npm", nullable = false, foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private Asisten asisten = new Asisten();

    /**
     * @return the idAbsenKehadiran
     */
    public String getIdAbsenKehadiran() {
        return idAbsenKehadiran;
    }

    /**
     * @param idAbsenKehadiran the idAbsenKehadiran to set
     */
    public void setIdAbsenKehadiran(String idAbsenKehadiran) {
        this.idAbsenKehadiran = idAbsenKehadiran;
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
     * @return the sesi
     */
    public Integer getSesi() {
        return sesi;
    }

    /**
     * @param sesi the sesi to set
     */
    public void setSesi(Integer sesi) {
        this.sesi = sesi;
    }

    /**
     * @return the baris
     */
    public String getBaris() {
        return baris;
    }

    /**
     * @param baris the baris to set
     */
    public void setBaris(String baris) {
        this.baris = baris;
    }

    /**
     * @return the absenHari
     */
    public AbsenHari getAbsenHari() {
        return absenHari;
    }

    /**
     * @param absenHari the absenHari to set
     */
    public void setAbsenHari(AbsenHari absenHari) {
        this.absenHari = absenHari;
    }

    /**
     * @return the asisten
     */
    public Asisten getAsisten() {
        return asisten;
    }

    /**
     * @param asisten the asisten to set
     */
    public void setAsisten(Asisten asisten) {
        this.asisten = asisten;
    }

}
