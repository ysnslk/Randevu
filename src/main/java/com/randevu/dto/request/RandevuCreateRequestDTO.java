package com.randevu.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RandevuCreateRequestDTO {
    private LocalDateTime dateTime;
    private String adSoyad;
    private String email;
    private String telefon;
    private String pozisyon;
    private String gorusulecekKisi;
    private boolean durum = true;
}
