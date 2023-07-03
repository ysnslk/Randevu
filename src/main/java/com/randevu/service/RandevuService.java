package com.randevu.service;

import com.randevu.dto.request.RandevuCreateRequestDTO;
import com.randevu.dto.response.RandevuResponseDTO;
import com.randevu.mapper.IRandevuMapper;
import com.randevu.repository.RandevuRepository;
import com.randevu.repository.entity.Randevu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RandevuService {

    private final RandevuRepository randevuRepository;

    public Randevu createRandevu(RandevuCreateRequestDTO randevuDTO) {
        Randevu randevu = IRandevuMapper.INSTANCE.toSave(randevuDTO);
        return randevuRepository.save(randevu);
    }

    public List<Randevu> getAllRandevular() {
        return randevuRepository.findAll();
    }

    public Randevu save(Randevu randevu) {
        return randevuRepository.save(randevu);
    }

    public List<String> getBosRandevuSaatleri(LocalDateTime tarih) {
        List<Randevu> randevular = randevuRepository.findByDateTimeAndDurum(tarih, false);
        List<String> doluSaatler = randevular.stream()
                .map(Randevu::getDateTime)
                .map(LocalDateTime::toLocalTime)
                .map(LocalTime::toString)
                .collect(Collectors.toList());

        List<String> bosSaatler = new ArrayList<>();
        LocalTime saat = tarih.toLocalTime().withMinute(0).withSecond(0); // Başlangıç saatini belirleyin
        LocalTime bitisSaat = tarih.toLocalTime().withMinute(0).withSecond(0).plusHours(9); // Bitiş saatini belirleyin (9 saat sonrası)
        while (saat.isBefore(bitisSaat)) {
            String saatStr = saat.toString();
            if (!doluSaatler.contains(saatStr)) {
                bosSaatler.add(saatStr);
            }
            saat = saat.plusMinutes(30); // Saate 30 dakika ekleyin
        }

        return bosSaatler;
    }


    public void iptalEtRandevu(Long randevuId) {
        randevuRepository.deleteById(randevuId);
    }

    public Optional<Randevu> findyById(Long randevuId) {
        return randevuRepository.findById(randevuId);
    }


    // Ekstra metotlar buraya eklenebilir
}
