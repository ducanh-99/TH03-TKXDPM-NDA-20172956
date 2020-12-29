package com.oms.serverapi.media;

import java.util.ArrayList;
import java.util.Map;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.oms.bean.CompactDisc;
import com.oms.serverapi.Connect;
import com.oms.serverapi.abstractmedia.ICdsApi;

public class CdsApi extends Connect implements ICdsApi {
	private static CdsApi instance;

	private CdsApi() {
		super();
	}

	public static synchronized CdsApi getInstance() {
		if (instance == null)
			instance = new CdsApi();
		return instance;
	}

	@Override
	public ArrayList<CompactDisc> getCds(Map<String, String> queryParams) {
		WebTarget webTarget = client.target(PATH).path("cds");

		if (queryParams != null) {
			for (String key : queryParams.keySet()) {
				String value = queryParams.get(key);
				webTarget = webTarget.queryParam(key, value);
			}
		}

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		ArrayList<CompactDisc> res = response.readEntity(new GenericType<ArrayList<CompactDisc>>() {
		});
		System.out.println(res);
		return res;
	}

}
