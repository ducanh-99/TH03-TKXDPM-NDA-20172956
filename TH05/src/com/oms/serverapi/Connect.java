package com.oms.serverapi;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class Connect {
	public static final String PATH = "http://localhost:8080/";
//	public static final String PATH = "https://server-ebr.herokuapp.com/";
	protected Client client;

	public Connect() {
		client = ClientBuilder.newClient();
	}
}
