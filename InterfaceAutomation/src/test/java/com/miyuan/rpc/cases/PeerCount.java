package com.miyuan.rpc.cases;

import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.miyuan.rpc.request.PeerCountRequest;
import com.miyuan.rpc.response.PeerCountResp;
import com.miyuan.rpc.utils.HttpUtils;
import com.miyuan.rpc.utils.PARAMETER;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class PeerCount {
	
	
  @Test(dataProvider = "peerCountData")
  public void peerCount(String jsonrpc, String method,String id,String result) {
	  JSONObject jsonObj = PeerCountRequest.peerCountReq(jsonrpc,method,id);
	  String resultId = jsonObj.getString("id");//使用JSON对象中的方法获取JSON对象中的值
	  String resultJsonrpc = jsonObj.getString("jsonrpc");
	  String results = jsonObj.getString("result");
	  Assert.assertEquals(resultId, id);
	  Assert.assertEquals(resultJsonrpc, jsonrpc);
	  Assert.assertEquals(results, result);
  }
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider
  public Object[][] peerCountData() {
    return new Object[][] {
      { "2.0", "peerCount","74","0x3"},
      //{ 2, "b" },
    };
  }
  
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
