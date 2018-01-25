package com.example.week9text;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;



import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
public class login extends Activity {
	Button login=null;
	Button signup=null;
	EditText et1=null;
	EditText et2=null;
	private static String url="http://211.67.51.214:8080/Test/index.jsp";
	private static String url1="http://211.67.51.214:8080/Test/index.jsp";
	private void getPDAServerData(String id,String passwd){
		url=url1;
	    url+="?id=";
	    url+=id;
	    url+="&password=";
	    url+=passwd;
	    
	    StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
	    Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				 try {
					 	HttpClient client=new DefaultHttpClient();
					    HttpGet request;
					    request = new HttpGet(new URI(url));
					  
					    HttpResponse response=client.execute(request);
					    //判断请求是否成功
					    if(response.getStatusLine().getStatusCode()!=404){
					    HttpEntity entity=response.getEntity();
					    if(entity!=null){
					    String out=EntityUtils.toString(entity);
					    new AlertDialog.Builder(login.this).setMessage(out).create().show();
//					    new Toast(login.this).makeText(login.this, out, Toast.LENGTH_LONG).show();
					    return ;
					    }
					    }
					    }catch (URISyntaxException e) {
					    e.printStackTrace();
					    }
					    catch (ClientProtocolException e) {
					    e.printStackTrace();
					    } catch (IOException e) {
					    e.printStackTrace();
					    }
			}
		});
	    t1.start();
	   
   }
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
		login=(Button)findViewById(R.id.login);
		signup=(Button)findViewById(R.id.signup);
		et1=(EditText)findViewById(R.id.id);
		et2=(EditText)findViewById(R.id.password);
//		getPDAServerData("123","mldn");
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//				getPDAServerData(url,et1.getText().toString(),et2.getText().toString());
				getPDAServerData("123","111");
//				Intent  intent = new Intent();
//            	intent.setClass(login.this, MainActivity.class);
//            	if(intent.getStringExtra("id")!="")
//            	intent.removeExtra("id");
//            	intent.putExtra("id", et1.getText().toString());
//            	startActivity(intent);
				
			}
		});
		signup.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent  intent = new Intent();
            	intent.setClass(login.this, SignUp.class);
            	startActivity(intent);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
