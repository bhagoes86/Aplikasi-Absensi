package com.rizki.mufrizal.aplikasi.absensi.repository;

import com.rizki.mufrizal.aplikasi.absensi.domain.AbsensiAsisten;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
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
    public Page<AbsensiAsisten> findAll(Pageable pgbl);

}
