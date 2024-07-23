package com.example.demo.classes;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.jose4j.json.internal.json_simple.JSONObject;
import org.jose4j.json.internal.json_simple.parser.JSONParser;

import com.example.demo.model.SearchResults;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.gson.GsonFactory;
import com.google.gson.Gson;

public class GoogleEngine {
	
	private String googleURL="https://api.serpwow.com/live/search?api_key=FEDA942EAD474799B054DE5A52958623&q=";
	
	public void searchEngines(QueryData query) throws IOException{
		String google=googleURL+query.getDesiredLanguage()+"+"+query.getSkill()+"+for"+query.getLevel()+"&num=100";

		  try {			 			  
				URI urlGoogle = new URI(google);
			  	HttpRequestFactory requestFactory
			  		= new NetHttpTransport().createRequestFactory(
			  				(HttpRequest request) -> {
			  					request.setParser(new JsonObjectParser(new GsonFactory()));
			  				});
			  	HttpRequest request = requestFactory.buildGetRequest(
			  			new GenericUrl(urlGoogle));
			  	HttpResponse httpResponse=request.execute();
			  	SearchResults googledocs=httpResponse.parseAs(SearchResults.class);
			  	String j = new Gson().toJson(googledocs);
			  	JSONParser parser=new JSONParser();
			  	JSONObject json = (JSONObject) parser.parse(j);  
			  	predict(json);
		  }
		  catch(Exception c){
			  System.out.println("");
		  }
	}
	public void predict(JSONObject json){
        HttpURLConnection conn = null;
	    try {
			URL url = new URL("http://127.0.0.1:5000/predict");

                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("Accept", "application/json");
                conn.setDoOutput(true);
                DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
                wr.write(json.toString().getBytes());
                wr.flush();
                wr.close();
                if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : "
                            + conn.getResponseCode());
                }

                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (conn.getInputStream())));
                conn.disconnect();
	    }
			catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
				e.printStackTrace();
			}finally
	        {
	            if(conn != null)
	            {
	                conn.disconnect();
	            }
	        }
	}
}
