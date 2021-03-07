package com.example.istakip.repository;

import com.example.istakip.domain.isDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface isRepository extends JpaRepository<isDO, Long> {
    //Optional<isDO> findByIdAndisId(Long id,Long isId);
}
