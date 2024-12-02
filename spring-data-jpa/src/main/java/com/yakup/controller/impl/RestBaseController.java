package com.yakup.controller.impl;

import com.yakup.entites.RootEntity;

public class RestBaseController {
	
	public <T> RootEntity<T> ok(T data){
		return RootEntity.ok(data);
	}
	
	public <T> RootEntity<T> error(String errorMassage){
		return RootEntity.error(errorMassage);
	}


}
