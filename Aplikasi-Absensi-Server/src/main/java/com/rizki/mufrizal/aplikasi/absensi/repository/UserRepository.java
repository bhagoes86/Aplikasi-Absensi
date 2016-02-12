package com.rizki.mufrizal.aplikasi.absensi.repository;

import com.rizki.mufrizal.aplikasi.absensi.domain.User;
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
@RepositoryRestResource(collectionResourceRel = "user", path = "user", collectionResourceDescription = @Description("API untuk crud data user"))
public interface UserRepository extends PagingAndSortingRepository<User, String> {

    @PreAuthorize("permitAll")
    @Query("select u from User u left join fetch u.userRoles pd where u.email = :email")
    User LoginUser(@Param("email") String email);

    @Override
    @PreAuthorize("permitAll")
    public <S extends User> S save(S s);
}
