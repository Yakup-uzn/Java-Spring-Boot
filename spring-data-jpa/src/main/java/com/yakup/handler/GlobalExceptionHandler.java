package com.yakup.handler;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.yakup.exception.BaseException;


//@RestControllerAdvice anotasyonu ile bu sınıfın tüm controller'lar için istisna yakalama işlevi gördüğünü belirtiriz.
@ControllerAdvice
public class GlobalExceptionHandler {

    
	
	//hata oldugunda fırlatılan exceptiona yakalar
   @ExceptionHandler(value = BaseException.class)
   public ResponseEntity<ApiError> handleBaseException(BaseException exception,WebRequest request) {
   
	   return ResponseEntity.badRequest().body(createApiError(exception.getMessage(),request));
   }

   
   
   public <E> ApiError<E> createApiError(E message ,WebRequest request){
	   ApiError<E> apiError=new ApiError<>();
	   apiError.setStatus(HttpStatus.BAD_REQUEST.value());
	   Exception<E> exception=new Exception<>();
	   exception.setCreateTime(new Date());
	   exception.setHostName(getHostName());
	   
	   //url adresini dönüyor
	   exception.setPath(request.getDescription(false).substring(4));
	   exception.setMessage(message);
	   
	   apiError.setException(exception);

	   return apiError;
	   
	   
	   
   } 
   
   
   
   private String getHostName() {
		  
	   try {
		   return InetAddress.getLocalHost().getHostName();
	} catch (UnknownHostException e) {
		System.out.printf("Hata oluştu");
	}
	   
	   return null;
   }
   
   
   
   
   
}

