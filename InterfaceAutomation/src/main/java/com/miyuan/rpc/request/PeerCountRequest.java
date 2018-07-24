package com.miyuan.rpc.request;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.miyuan.rpc.response.PeerCountResp;
import com.miyuan.rpc.utils.HttpUtils;
import com.miyuan.rpc.utils.PARAMETER;

public class PeerCountRequest {
	
	public static JSONObject peerCountReq(String jsonrpc,String method,String id) {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		JSONObject json = new JSONObject();
		json.put("jsonrpc", jsonrpc);
		json.put("method", method);
		json.put("id", id);
		json.put("params", params);
		String respString = HttpUtils.sendJson(PARAMETER.url,json.toString());
		JSONObject jsonObj = JSON.parseObject(respString);//将respString JSON字符串解析为JSON对象
		return jsonObj;
	}

}
