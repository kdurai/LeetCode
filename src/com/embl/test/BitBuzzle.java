package com.embl.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class BitBuzzle {

	public static void main(String[] args) {
		
		int mask = 0x000F;
		int value = 0x2222;
		
		System.out.println(value & mask);
		
	}
	
	public int getMobiles(String substr) {
		String response;
		int total = 0;
		 try {
		    URL obj = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr);
		    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		    con.setRequestMethod("GET");
		    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		    while ((response = in.readLine()) != null) {
		      //JsonObject convertedObject = new Gson().fromJson(response, JsonObject.class);
		      //total = convertedObject.get("total").getAsInt();
		    }
		    in.close();
		  } catch (Exception ex) {
		    ex.printStackTrace();
		  }
		return total;
	}

}
