package com.yakup.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RootEntity<T> {
	private boolean result;
	
	private String errorMessage;
	
	private T data;
	
	//Dışarıdan erişebilmek için static olarak tanımladık
	public static <T> RootEntity<T> ok(T data){
		RootEntity<T> rootEntity=new RootEntity<>();
		rootEntity.setResult(true);
		rootEntity.setErrorMessage(null);
		rootEntity.setData(data);
		return rootEntity;
		
	}
	
	public static <T> RootEntity<T> error(String errorMassage){
		RootEntity<T> rootEntity=new RootEntity<>();
		rootEntity.setResult(false);
		rootEntity.setErrorMessage(errorMassage);
		rootEntity.setData(null);
		return rootEntity;
		
	}
	

}
