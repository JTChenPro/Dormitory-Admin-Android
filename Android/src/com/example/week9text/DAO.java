package com.example.week9text;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class DAO {
	private Bitmap getBitmapFromServer(String imagePath) { 

	    HttpGet get = new HttpGet(imagePath); 
	    HttpClient client = new DefaultHttpClient(); 
	    Bitmap pic = null; 
	    try { 
	        HttpResponse response = client.execute(get); 
	        HttpEntity entity = response.getEntity(); 
	        InputStream is = entity.getContent(); 

	        pic = BitmapFactory.decodeStream(is);   // 关键是这句代码  

	    } catch (ClientProtocolException e) { 
	        e.printStackTrace(); 
	    } catch (IOException e) { 
	        e.printStackTrace(); 
	    } 
	    return pic; 
	} 
	 public static Bitmap getBitmap(String path) throws IOException{

	        URL url = new URL(path);
	        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	        conn.setConnectTimeout(5000);
	        conn.setRequestMethod("GET");
	        if(conn.getResponseCode() == 200){
	        InputStream inputStream = conn.getInputStream();
	        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
	        return bitmap;
	        }
	        return null;
	        }
	public static String[] getBuildingList() {
		// TODO Auto-generated method stub
		return null;
	}
	public static String[] getFloor(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	public static String[] getRoom(String buildingPosition, String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
