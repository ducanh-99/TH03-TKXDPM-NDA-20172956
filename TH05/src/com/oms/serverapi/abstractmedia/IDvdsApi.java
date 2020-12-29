package com.oms.serverapi.abstractmedia;

import java.util.ArrayList;
import java.util.Map;

import com.oms.bean.DigitalVideoDisc;

public interface IDvdsApi {
	public ArrayList<DigitalVideoDisc> getDvds(Map<String, String> queryParams);
}
