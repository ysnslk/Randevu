package com.randevu.controller;

import com.randevu.dto.request.RandevuCreateRequestDTO;
import com.randevu.dto.response.RandevuResponseDTO;
import com.randevu.exceptions.ErrorType;
import com.randevu.exceptions.RandevuException;
import com.randevu.repository.entity.Randevu;
import com.randevu.service.RandevuService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.randevu.constants.RestApiList.*;
@RestController
@RequestMapping(RANDEVU)
@RequiredArgsConstructor
public class RandevuController {

    private final RandevuService randevuService;
    @GetMapping(FINDBYID)
    public Optional<Randevu> findByID(Long randevuId){
        Optional<Randevu> randevu = randevuService.findyById(randevuId);
        if(randevu.isEmpty()){
            throw new RandevuException(ErrorType.RANDEVU_BULUNAMADI);
        }else {
            return randevu;
        }
    }
    @PostMapping(SAVEDTO)
    public ResponseEntity<Randevu> createRandevu(@RequestBody RandevuCreateRequestDTO randevuDTO) {
        Randevu randevu = randevuService.createRandevu(randevuDTO);
        return ResponseEntity.ok(randevu);
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<Randevu>> getAllRandevular() {
        List<Randevu> randevular = randevuService.getAllRandevular();
        return ResponseEntity.ok(randevular);
    }

    @GetMapping(BOSSAATLER)
    public ResponseEntity<List<String>> getBosRandevuSaatleri(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime tarih) {
        List<String> bosSaatler = randevuService.getBosRandevuSaatleri(tarih);
        return ResponseEntity.ok(bosSaatler);
    }

    @DeleteMapping(DELETE)
    public void iptalEtRandevu(Long randevuId) {
        Optional<Randevu> randevu = randevuService.findyById(randevuId);
        if (randevu.isPresent()) {
            randevu.get().setDurum(false);
            randevuService.save(randevu.get());
        } else {
            throw new RandevuException(ErrorType.RANDEVU_BULUNAMADI);
        }
    }


}
