package com.yakup.exception;

//package com.yakup.exception;

import lombok.Getter;

@Getter
public enum MessageType {

 // Enum sabitleri, hata kodu ve mesaj içerecek şekilde tanımlanır.
 NO_RECORD_EXIST("1001", "Kayıt bulunamadı"),
 GENERAL_EXCEPTION("9999", "Genel bir hata oluştu");

 private String code; // Hata kodunu tutar; her hata türü için benzersizdir.
 private String message; // Hata mesajını tutar.

 // Enum'un constructor'ı, her bir hata türü için kod ve mesaj tanımlanmasını sağlar.
 private MessageType(String code, String message) {
     this.code = code;
     this.message = message;
 }
}

