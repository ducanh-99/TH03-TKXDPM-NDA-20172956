package com.oms.serverapi.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;


import com.oms.bean.DigitalVideoDisc;
import com.oms.serverapi.MediaApi;

public class DvdApiTest {
	private MediaApi api = new MediaApi();

	@Test
	public void testGetAllDvd() {
		ArrayList<DigitalVideoDisc> list = api.getDvds(null);
		assertEquals("Error in getDvds  Api", list.size(), 3);
	}

	@Test(timeout = 1000)
	public void testResponse() {
		
		api.getDvds(null);
	}

//	@Test
//	public void testUpdateDvd() {
//		ArrayList<DigitalVideoDisc> list = api.getDvds(null);
//		assertTrue("No data", list.size() > 0);
//
//		DigitalVideoDisc dvd = list.get(0);
//		String newDirector = "Test";
//		dvd.setDirector(newDirector);
//		api.updateDigitalVideoDisc(dvd);
//
//		HashMap<String, String> params = new HashMap<String, String>();
//
//		params.put("director", newDirector);
//		list = api.getDvds(params);
//		assertTrue("Eror in updateDvd API!", list.size() > 0);
//
//		DigitalVideoDisc newDvd = api.getDvds(params).get(0);
//
//		assertEquals("Eror in updateBook API!", newDvd.getDirector(), newDirector);
//	}

}
