/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package jp.co.aircast.module;

import java.util.ArrayList;
import java.util.HashMap;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollFunction;
import org.appcelerator.kroll.KrollProxy;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.util.Log;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.speech.RecognizerIntent;
//import org.linphone.R;


// This proxy can be created by calling Modulesample.createExample({message: "hello world"})
@Kroll.proxy(creatableInModule=ModulesampleModule.class)
public class MakeIntentProxy extends KrollProxy
{
	// Standard Debugging variables
	private static final String LCAT = "ExampleProxy";
	private static Activity currentActivity;
//	private static Handler mHandler = new Handler();
	private KrollFunction callback = null;

	// Constructor
	public MakeIntentProxy()
	{
		super();
	}

	// Handle creation options
	@Override
	public void handleCreationDict(KrollDict options)
	{
		super.handleCreationDict(options);
		
		if (options.containsKey("message")) {
			Log.d(LCAT, "example created with message: " + options.get("message"));
		}
	}
	
	@Kroll.method
	public void setCallback(KrollFunction func)
	{
		this.callback = func;
	}
	
	static final String TAG = "MakeIntentProxy";
	
	@Kroll.method
	public void start(KrollDict options)
	{
        Activity currentActivity = TiApplication.getInstance().getCurrentActivity();
        Intent intent = new Intent(
                            currentActivity.getApplicationContext(),
                            MakeIntentActivity.class
                        );
        intent.setAction(Intent.ACTION_VIEW);
     
        //
        //  You can override callback functions.
        //
        if (callback == null && options != null
         && options.containsKey("callback")
         && (options.get("callback") instanceof KrollFunction)) {
        	Log.d(TAG, "overriding callback value");
        	callback = (KrollFunction)options.get("callback");
        }
        
        Handler handler = new Handler() {
            public void handleMessage(Message msg) {
                Log.d(TAG, "Voice Recognition result handled.");
                if (callback != null) {
                	Bundle bundle = msg.getData();
//                    String matches = bundle.getString("VOICE_RESULT");
//                    ArrayList<String> matches = bundle.getStringArrayList("VOICE_RESULT");
//                    for (int i = 0; i < matches.size(); i++) {
//                        Log.d(TAG, " Recognize result -> " + matches.get(i));
//                    }
                    HashMap resultmap = new HashMap();
                    String result_string = bundle.getString("VOICE_RESULT");
                    if(result_string == null) result_string = "";
                    resultmap.put("voice_results", result_string);
                    resultmap.put("voice_enabled", bundle.getBoolean("VOICE_RECOGNITION_ENABLED"));
                    resultmap.put("voice_canceled", bundle.getBoolean("VOICE_RECOGNITION_CANCELED"));
                    callback.callAsync(getKrollObject(), resultmap);
                }
            }
        };

        //
        //    invoke main Activity.
        //
        Messenger msger = new Messenger(handler);
        intent.putExtra("VOICE_RESULT_MESSENGER", msger);
        
        if(options != null)
        {
        	if(options.containsKey("type"))
        	{
        		String type = (String)options.get("type");
        		intent.putExtra("type", type);
        	}
        }
        
//        if (options != null) {
//        	if (options.containsKey(RecognizerIntent.EXTRA_LANGUAGE_MODEL)) {
//        		String extraVal = (String)options.get(RecognizerIntent.EXTRA_LANGUAGE_MODEL);
//        		Log.d(TAG, "overriding RecognizerIntent.EXTRA_LANGUAGE_MODEL value -> " + extraVal);
//        		intent.putExtra("android.speech.extra.LANGUAGE_MODEL", extraVal);
//            }
//            if (options.containsKey(RecognizerIntent.EXTRA_PROMPT)) {
//            	String extraVal = (String)options.get(RecognizerIntent.EXTRA_PROMPT);
//            	Log.d(TAG, "overriding RecognizerIntent.EXTRA_PROMPT value");
//            	intent.putExtra(RecognizerIntent.EXTRA_PROMPT, extraVal);
//            }
//        }
        try {
        	currentActivity.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Log.e(TAG, "VoiceRecognitionActivity not found, check your activity setting in tiapp.xml");
            HashMap resultmap = new HashMap();
            resultmap.put("voice_results", "");
            resultmap.put("voice_enabled", false);
            resultmap.put("voice_canceled", false);
            callback.callAsync(getKrollObject(), resultmap);
        }
	}
}