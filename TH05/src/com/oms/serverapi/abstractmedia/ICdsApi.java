package com.oms.serverapi.abstractmedia;

import java.util.ArrayList;
import java.util.Map;

import com.oms.bean.CompactDisc;

public interface ICdsApi {
	public ArrayList<CompactDisc> getCds(Map<String, String> queryParams);
}
