package com.rizki.mufrizal.aplikasi.absensi.repository;

import com.rizki.mufrizal.aplikasi.absensi.domain.AbsensiAsisten;
import java.time.LocalDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 14, 2016
 * @Time 8:50:06 AM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Server
 * @Package com.rizki.mufrizal.aplikasi.absensi.repository
 *
 */
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RepositoryRestResource(collectionResourceRel = "absensi", path = "absensi", collectionResourceDescription = @Description("API untuk crud data absensi"))
public interface AbsensiAsistenRepository extends PagingAndSortingRepository<AbsensiAsisten, String> {

    @PreAuthorize("hasRole('ROLE_USER')")
    @Override
    public Page<AbsensiAsisten> findAll(Pageable pageable);

    @PreAuthorize("permitAll")
    @RestResource(path = "asisten", rel = "asisten")
    public Page<AbsensiAsisten> findByNpmAsisten(@Param("npmAsisten") String npmAsisten, Pageable pageable);

    @PreAuthorize("permitAll")
    @Override
    public <S extends AbsensiAsisten> S save(S s);

    @PreAuthorize("permitAll")
    @Override
    public Iterable<AbsensiAsisten> findAll();

    @PreAuthorize("permitAll")
    public Iterable<AbsensiAsisten> findByTanggalJagaBetween(LocalDate tanggalAwal, LocalDate tanggalAkhir);

    @PreAuthorize("permitAll")
    public Iterable<AbsensiAsisten> findByNpmAsistenAndTanggalJagaBetween(String npmAsisten, LocalDate tanggalAwal, LocalDate tanggalAkhir);
}
