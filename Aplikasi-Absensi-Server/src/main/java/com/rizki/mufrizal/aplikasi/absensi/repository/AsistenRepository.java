package com.rizki.mufrizal.aplikasi.absensi.repository;

import com.rizki.mufrizal.aplikasi.absensi.domain.Asisten;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Feb 12, 2016
 * @Time 7:21:21 PM
 * @Encoding UTF-8
 * @Project Aplikasi-Absensi-Server
 * @Package com.rizki.mufrizal.aplikasi.absensi.repository
 *
 */
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RepositoryRestResource(collectionResourceRel = "asisten", path = "asisten", collectionResourceDescription = @Description("API untuk crud data asisten"))
public interface AsistenRepository extends PagingAndSortingRepository<Asisten, String> {

    @PreAuthorize("permitAll")
    @Query("select u from Asisten u left join fetch u.asistenRoles pd where u.npm = :npm")
    Asisten LoginAsisten(@Param("npm") String npm);

    @Override
    @PreAuthorize("permitAll")
    public <S extends Asisten> S save(S s);
}
