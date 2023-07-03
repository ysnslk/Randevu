package com.randevu.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {

    INTERNAL_SERVER_ERROR(1000,"Sunucuda Bilinmeyen bir hata oluştu", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(1001,"İstek formatı hatalı",HttpStatus.BAD_REQUEST),
    RANDEVU_SAATI_DLOU(2001,"Randevu Saati Dolu",HttpStatus.BAD_REQUEST),
    RANDEVU_BULUNAMADI(2001,"Randevu Bulunamadı",HttpStatus.BAD_REQUEST);


    int code;
    String message;
    HttpStatus httpStatus;
}
