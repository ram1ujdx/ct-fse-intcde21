package com.cts.app.service;

import com.cts.app.model.AppData;
import com.cts.app.repository.AppRepo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
public class AppServiceImpl implements AppService{
	
	private AppRepo repo;
	
	
	

	@Override
	public String print() {
		
		String str=repo.getData();
		
		str=str.trim();
		return str.substring(0,str.length()-2);
		
	}
	
	@Override
	public AppData getAppData() {
		return repo.getAppData();
	}
	
}
