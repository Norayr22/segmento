package com.segmento.api.Test;

import static io.restassured.RestAssured.get;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTestForEmployeers {
	JSONObject obj;
	JSONObject obj1;
	JSONObject obj2;
	JSONParser helper;

	@Test
	public void testBody1() throws org.json.simple.parser.ParseException {

		String data = get("http://overpass-api.de/api/interpreter?data=[out:json];node(around:400,59.93823555,30.2668659740719)[amenity=cafe];out;").asString();
		System.out.println(data);
		int code  = get("http://overpass-api.de/api/interpreter?data=[out:json];node(around:400,59.93823555,30.2668659740719)[amenity=cafe];out;").getStatusCode();
		System.out.println(code);
		Assert.assertEquals(code, 200);
		JSONObject obj;
		helper = new JSONParser();
		obj = (JSONObject)helper.parse(data);
		// Note that these may throw several exceptions
		JSONArray array = (JSONArray)obj.get("elements");
		int cafe_count = array.size();
		System.out.println("COUNT OF CAFES IN SPECIFIED RADIUS IS: "+array.size());

		String bars = get("http://overpass-api.de/api/interpreter?data=[out:json];node(around:400,59.93823555,30.2668659740719)[amenity=bar];out;").asString();
		System.out.println(bars);
		int code1  = get("http://overpass-api.de/api/interpreter?data=[out:json];node(around:400,59.93823555,30.2668659740719)[amenity=bar];out;").getStatusCode();
		System.out.println(code1);
		Assert.assertEquals(code1, 200);
		JSONObject obj1;
		helper = new JSONParser();
		obj1 = (JSONObject)helper.parse(bars);
		JSONArray array1 = (JSONArray)obj1.get("elements");
		int bar_count = array1.size();
		System.out.println("COUNT OF BARS IN SPECIFIED RADIUS IS: "+array1.size());

		String transport_stations = get("http://overpass-api.de/api/interpreter?data=[out:json];node(around:400,59.93823555,30.2668659740719)[public_transport=platform];out;").asString();
		System.out.println(transport_stations);
		int stautscode  = get("http://overpass-api.de/api/interpreter?data=[out:json];node(around:400,59.93823555,30.2668659740719)[public_transport=platform];out;").getStatusCode();
		System.out.println(stautscode);
		Assert.assertEquals(stautscode, 200);
		JSONObject obj2;
		helper = new JSONParser();
		obj2= (JSONObject)helper.parse(transport_stations);
		JSONArray arr = (JSONArray)obj2.get("elements");
		int transport_stations_count = arr.size();
		System.out.println("COUNT OF TRANSPORT STATIONS IN SPECIFIED RADIUS IS: "+arr.size());




		Assert.assertTrue(cafe_count  >= 2 , "there is not enough cafe in specified radious");
		Assert.assertTrue(transport_stations_count > 0 , "there is not transport_stations in specified radious"); 
		Assert.assertTrue(bar_count  >= 1 , "there is not enough bars in specified radious"); 
	}

}
