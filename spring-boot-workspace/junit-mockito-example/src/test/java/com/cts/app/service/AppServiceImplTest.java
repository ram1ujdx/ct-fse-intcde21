package com.cts.app.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cts.app.model.AppData;
import com.cts.app.repository.AppRepo;
@ExtendWith(MockitoExtension.class)
class AppServiceImplTest {
	
	@InjectMocks
	AppServiceImpl service;
	
	@Mock
	AppRepo mockedRepo;

	@Test
	void testPrint() {
		
		when(mockedRepo.getData()).thenReturn(" Hello Everyone ");
		assertEquals("Hello Everyo", service.print());
	}
	
	@Test
	void testGetAppData() {
		
		AppData data=new AppData(101,"Data Info");
		
		when(mockedRepo.getAppData()).thenReturn(data);
		
		assertEquals(data, service.getAppData());
		
		
	}
	
	
	

}
