package com.yakup.exception;

//package com.yakup.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // Parametresiz bir constructor otomatik oluşturulur.
@AllArgsConstructor // Tüm alanlar için bir constructor otomatik oluşturulur.
public class ErrorMesage {

 private MessageType messageType; // Hata türünü belirler; MessageType enum'u ile tanımlanır.
 private String ofStatic; // Ek hata açıklaması veya detay mesajı için kullanılan bir alan.

 // Bu metot, hata mesajını oluşturur ve döndürür.
 // messageType.getMessage() çağrısı ile MessageType enum'undaki mesaj alınır.
 // Eğer ofStatic değişkeni null değilse, bu bilgiye hata mesajına eklenir.
 public String prepareErrorMessage() {
     StringBuilder builder = new StringBuilder();
     builder.append(messageType.getMessage()); // Ana hata mesajı eklenir.
     if (ofStatic != null) {
         builder.append(" : " + ofStatic); // Ek açıklama varsa hata mesajına eklenir.
     }
     return builder.toString(); // Tamamlanan hata mesajı döndürülür.
 }
}
