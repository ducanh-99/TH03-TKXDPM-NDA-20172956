package com.oms.serverapi.media;

import java.util.ArrayList;
import java.util.Map;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.oms.bean.DigitalVideoDisc;
import com.oms.serverapi.Connect;
import com.oms.serverapi.abstractmedia.IDvdsApi;

public class DvdsApi extends Connect implements IDvdsApi {
	private static DvdsApi instance;

	private DvdsApi() {
		super();
	}

	public static synchronized DvdsApi getInstance() {
		if (instance == null)
			instance = new DvdsApi();
		return instance;
	}

	@Override
	public ArrayList<DigitalVideoDisc> getDvds(Map<String, String> queryParams) {
		WebTarget webTarget = client.target(PATH).path("dvds");

		if (queryParams != null) {
			for (String key : queryParams.keySet()) {
				String value = queryParams.get(key);
				webTarget = webTarget.queryParam(key, value);
			}
		}

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		ArrayList<DigitalVideoDisc> res = response.readEntity(new GenericType<ArrayList<DigitalVideoDisc>>() {
		});
		System.out.println(res);
		return res;
	}

}
