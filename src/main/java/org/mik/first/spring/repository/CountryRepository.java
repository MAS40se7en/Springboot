package org.mik.first.spring.repository;

import org.mik.first.spring.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findByName(String name);
    Optional<Country> findByNameAndSignOrderByNameDesc(String name, String sign);

    @Query(nativeQuery = true, value = "Select country c from country where name like '@:name'")
    List<Country> getByNameLike(String name);
}
