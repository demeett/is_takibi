package com.example.istakip.repository;

import com.example.istakip.domain.PersonelDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonelRepository extends JpaRepository<PersonelDO,Long> {
    //Optional<PersonelDO> findBysurname(String surname);

}
