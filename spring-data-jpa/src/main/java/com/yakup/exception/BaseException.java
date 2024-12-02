package com.yakup.exception;

//package com.yakup.exception;

public class BaseException extends RuntimeException {

 // Parametresiz bir constructor, herhangi bir özel hata mesajı olmadan bir istisna oluşturmak için kullanılır.
 public BaseException() {
 }

 // ErrorMesage nesnesi alan constructor, özel bir hata mesajı ile istisna oluşturmak için kullanılır.
 // ErrorMesage içindeki prepareErrorMessage() metodu, mesajı oluşturarak RuntimeException sınıfına gönderir.
 public BaseException(ErrorMesage errorMesage) {
     super(errorMesage.prepareErrorMessage()); 
     // RuntimeException'ın super() metodu ile mesaj ayarlanır.
 }
 
}
