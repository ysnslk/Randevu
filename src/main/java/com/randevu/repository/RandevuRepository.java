package com.randevu.repository;

import com.randevu.repository.entity.Randevu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RandevuRepository extends JpaRepository<Randevu, Long> {
    List<Randevu> findByDateTime(LocalDateTime tarih);

    List<Randevu> findByDateTimeAndDurum(LocalDateTime tarih, boolean b);
}
