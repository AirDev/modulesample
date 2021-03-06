/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package jp.co.aircast.module;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollFunction;
import org.appcelerator.kroll.KrollProxy;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.util.Log;
import org.appcelerator.titanium.util.TiConfig;
import org.json.JSONException;
import org.json.JSONObject;
import org.linphone.ConferenceDetailsActivity;
import org.linphone.FirstLoginActivity;
import org.linphone.IncallActivity;
import org.linphone.IncomingCallActivity;
import org.linphone.LinphoneManager;
import org.linphone.LinphonePreferenceManager;
import org.linphone.LinphonePreferencesActivity;
import org.linphone.LinphoneService;
import org.linphone.LinphoneSimpleListener.LinphoneOnCallStateChangedListener;
import org.linphone.VideoCallActivity;
import org.linphone.core.LinphoneCall;
import org.linphone.core.LinphoneCall.State;
import org.linphone.core.LinphoneCore;
import org.linphone.core.LinphoneCore.RegistrationState;
import org.linphone.mediastream.Version;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.OrientationEventListener;
//import org.linphone.R;


// This proxy can be created by calling Modulesample.createExample({message: "hello world"})
@Kroll.proxy(creatableInModule=ModulesampleModule.class)
public class ALModuleProxy extends KrollProxy implements LinphoneOnCallStateChangedListener
{
	// Standard Debugging variables
	private static final String LCAT = "ExampleProxy";
	private static Activity currentActivity;
	private static final boolean DBG = TiConfig.LOGD;
	private static Context  context;
//	public static String PKG_NAME = "jp.co.aircast.voipsample";
//	public static String ACT_NAME = "VoipsampleActivity";
//	public static String PKG_NAME = "jp.co.aircast.saito.alDev";
//	public static String ACT_NAME = "Al_devActivity";
	private static Handler mHandler = new Handler();
	private static ALModuleProxy instance;
	public static String PREF_FIRST_LAUNCH = "pref_first_launch";
 
	public static int _STOP     = -1;
	public static int _NOMAL    = 0;
	public static int _CHATCHER = 1;
	public static int mode = _NOMAL;

	private static boolean isVideoCall = false;

	// Constructor
	public ALModuleProxy()
	{
		super();
		currentActivity = TiApplication.getInstance().getAppCurrentActivity();
		context         = currentActivity.getApplicationContext();
		
//		String name = currentActivity.getIntent().getComponent().getClassName();
//		int index = name.lastIndexOf(".");
//		PKG_NAME = name.substring(0, index);
//		ACT_NAME = name.substring(index + 1);
		
//		Log.d("currentActivity", currentActivity.getPackageName());
//		Log.d("currentActivity", currentActivity.getApplication().toString());
		
		LinphoneManager.addListener(this);
//		LinphoneManager.setOnTextReceivedListener(this);
//		Log.d("Linphone2", "setlistener");
		
		instance = this;
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
	public void regist()
	{
		String username = (String) getProperty("username");
		String password = (String) getProperty("password");
		String server   = (String) getProperty("server");
		
		regist(username, password, server);
	}

	public void regist(String username, String password, String server)
	{	
		LinphonePreferenceManager.getInstance(context);
		SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
//		final String PREF_FIRST_LAUNCH = "pref_first_launch";
		SharedPreferences.Editor editor = pref.edit();
		
		String prefUser = pref.getString(
							context.getString(R.get("string", "pref_username_key")),
							"");
		
		editor.putString(context.getString(R.get("string", "pref_username_key")), username);
		editor.putString(context.getString(R.get("string", "pref_domain_key")), server + ":5900");
		editor.putString(context.getString(R.get("string", "pref_passwd_key")), password);

//			if(prefUser == "")
		//audio codec setting
		editor.putBoolean(context.getString(R.get("string", "pref_codec_amr_key")), false);
		editor.putBoolean(context.getString(R.get("string", "pref_codec_amrwb_key")), false);
		editor.putBoolean(context.getString(R.get("string", "pref_codec_g722_key")), false);
		editor.putBoolean(context.getString(R.get("string", "pref_codec_g729_key")), false);
		editor.putBoolean(context.getString(R.get("string", "pref_codec_gsm_key")), false);
		editor.putBoolean(context.getString(R.get("string", "pref_codec_ilbc_key")), false);
		editor.putBoolean(context.getString(R.get("string", "pref_codec_pcma_key")), false);
		editor.putBoolean(context.getString(R.get("string", "pref_codec_pcmu_key")), false);
		editor.putBoolean(context.getString(R.get("string", "pref_codec_silk12_key")), false);
		editor.putBoolean(context.getString(R.get("string", "pref_codec_silk16_key")), false);
		editor.putBoolean(context.getString(R.get("string", "pref_codec_silk24_key")), false);
	
		editor.putBoolean(context.getString(R.get("string", "pref_codec_silk8_key")), false);
		editor.putBoolean(context.getString(R.get("string", "pref_codec_speex8_key")), true);
		
		//video codec setting
		editor.putBoolean(context.getString(R.get("string", "pref_video_codec_h263_key")), false);
		editor.putBoolean(context.getString(R.get("string", "pref_video_codec_vp8_key")), false);
		editor.putBoolean(context.getString(R.get("string", "pref_video_codec_mpeg4_key")), true);
		editor.putBoolean(context.getString(R.get("string", "pref_video_codec_h264_key")), true);
		//echo canceler
				boolean ec = false;
				editor.putBoolean(context.getString(R.get("string", "pref_echo_cancellation_key")), ec);
				boolean el = false;
				editor.putBoolean(context.getString(R.get("string", "pref_echo_limiter_key")), el);
		

		editor.putBoolean(PREF_FIRST_LAUNCH, false);
		editor.putInt(context.getString(R.get("string", "pref_extra_accounts")), 1);
		
		editor.putString(context.getString(R.get("string", "pref_proxy_key")), null);
		
		editor.putBoolean(context.getString(R.get("string", "pref_enable_outbound_proxy_key")), false);
		editor.putBoolean(context.getString(R.get("string", "pref_disable_account_key")), true);
		editor.putInt(context.getString(R.get("string", "pref_default_account")), 0);

		//121029suzuki 
		editor.putBoolean(context.getString(R.get("string", "pref_transport_udp_key")), true);
//		editor.putBoolean(context.getString(R.get("string", "pref_wifi_only_key")), false);
		
		editor.commit();
		
		//121025suzuki stop service
//		if(LinphoneService.isReady())
//		{
//			Intent intent= new Intent(Intent.ACTION_MAIN);
//			intent.setClass(context, LinphoneService.class);
//			currentActivity.stopService(intent);
//		}
		
		if(!LinphoneService.isReady())
		{
			Intent intent= new Intent(Intent.ACTION_MAIN);
			intent.setClass(context, LinphoneService.class);
			currentActivity.startService(intent);
		}
		
		resume();

//		Intent intent = new Intent(context, LinphoneLauncherActivity.class);
//		intent.setAction(Intent.ACTION_VIEW);
//		currentActivity.startActivity(intent);
	}
	
	@Kroll.method
	public void call(
		String target,
		String targetName, String targetUrl,
		String myName, String myUrl)
	{
		call(target, _NOMAL, false, targetName, targetUrl, myName, myUrl);
		//LinphoneManager.getInstance().newOutgoingCall(target);
	}
	
	public void call(
		String target,
		int mode,
		boolean isVideoCall,
		String targetName,
		String targetUrl,
		String myName,
		String myUrl)
	{
		if(!LinphoneManager.getInstance().isInstanciated())
		{
			Log.d(LCAT, "call faild");
			return;
		}
		
		this.mode = mode;
		setInitiateVideoCalls(isVideoCall);

		if(mode == ALModuleProxy._NOMAL)
		{
			JSONObject json = new JSONObject();
			try {
				json.put("type", "invite");
				//set my info
				json.put("fromName", myName);
				json.put("fromUrl", myUrl);
				json.put("callType", isVideoCall == true ? "video call" : "voice call");
				sendMessage(target, json.toString());
				
				//set target info
				LinphoneService.instance().postInfo(
						targetUrl,
						targetName,
						"");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		
		LinphoneManager.getInstance().newOutgoingCall(target);
	}
	
	@Kroll.method
	public void videoCall(String target,
		String targetName, String targetUrl,
		String myName, String myUrl)
	{
		call(target, _NOMAL, true, targetName, targetUrl, myName, myUrl);
	}
	
	
	@Kroll.method
	public void setting()
	{
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.setClass(context, LinphonePreferencesActivity.class);
		currentActivity.startActivity(intent);
	}
	
	static final int video_activity = 100;
	static final int FIRST_LOGIN_ACTIVITY = 101;
	static final int INCOMING_CALL_ACTIVITY = 102;
	static final int incall_activity = 104;
	static final int conferenceDetailsActivity = 105;
	
	boolean isOutgoing = false;

	@Override
	public void onCallStateChanged(LinphoneCall call, State state,
			String message) {
		
		Intent intent;
//		Activity activity = TiApplication.getInstance().getCurrentActivity();
//		Context context   = activity.getApplicationContext();
		
		LinphoneCore lc = LinphoneManager.getLcIfManagerNotDestroyedOrNull();
		if (lc==null) {
			/* we are certainly exiting, ignore then.*/
			return;
		}
		
		Log.d("onCallStateChanged", "mode = " + this.mode);
		
		//120927suzuki 
		if(this.mode == ALModuleProxy._CHATCHER)
		{
			if (state == LinphoneCall.State.StreamsRunning)
			{
				LinphoneManager.getLc().pauseCall(call);
			}
		}
		else if(this.mode == ALModuleProxy._NOMAL)
		{
			if (state==State.IncomingReceived) {
	//			if (call.getCurrentParamsCopy().getVideoEnabled())
				isOutgoing = false;
				Log.d("intent", "false");
				startOrientationSensor();
				startIncomingCallActivity();
			}
			if (state == State.OutgoingInit) {
				Log.d("intent", "true");
				isOutgoing = true;
				if (call.getCurrentParamsCopy().getVideoEnabled()) {
					startOrientationSensor();
					startVideoActivity(call, 0);
				} else {
					startIncallActivity(0);
				}
			}
	
			if (state == LinphoneCall.State.StreamsRunning && Version.isVideoCapable() && !call.isInConference()) {
				// call.cameraEnabled() contains the wish of the user
				// set in LinphoneManager#onCallStateChanged(OutgoingInit||IncomingReceived)

				Log.d("intent", "isOutgoin = " + isOutgoing);
				
				LinphoneCall c = LinphoneManager.getLc().getCurrentCall();
				if(isOutgoing)
				{
					c.enableCamera(isVideoCall);
				
					if (c.cameraEnabled()) {
						Log.d("intent", "a");
						currentActivity.finishActivity(incall_activity);
						startVideoActivity(call, 0);
					} else {
						Log.d("intent", "b");
						currentActivity.finishActivity(video_activity);
						startIncallActivity(0);
					}
				}
				else
				{
					if(IncomingCallActivity.isVideoCall)
					{
						Log.d("intent", "cc");
						currentActivity.finishActivity(incall_activity);
						startVideoActivity(call, 0);
					}
					else
					{
						Log.d("intent", "dd");
						currentActivity.finishActivity(video_activity);
						startIncallActivity(0);
					}
				}
			}
	
			if (state == LinphoneCall.State.CallUpdatedByRemote && Version.isVideoCapable()) {
				if (VideoCallActivity.launched && !call.getCurrentParamsCopy().getVideoEnabled()) {
					Log.d("intent", "c");
					currentActivity.finishActivity(video_activity);
					startIncallActivity(0);
				}
			}
			
			if (state == LinphoneCall.State.PausedByRemote) {
				Log.d("intent", "d");
				currentActivity.finishActivity(video_activity);
				startIncallActivity(0);
			}
	
			if (state==State.Error){
			//	showToast(R.get("string", "call_error"), message);
			}
			if (state==State.Error || state==State.CallEnd) {
				
				currentActivity.finishActivity(INCOMING_CALL_ACTIVITY);
				if (lc.getCallsNb() == 0){
					Log.d("intent", "e");
					exitIncallActivity();
					// Might be possible to optimize by disabling it before
					if (mOrientationHelper != null) mOrientationHelper.disable();
				}
				if (ConferenceDetailsActivity.active && lc.getConferenceSize() == 0) {
					Log.d("intent", "f");
					currentActivity.finishActivity(conferenceDetailsActivity);
				}
			}
		}
	}
	
	private void startIncomingCallActivity() {
		if(!IncomingCallActivity.isActive)
		{
			IncomingCallActivity.isActive = true;
			Intent intent = new Intent().setClass(context, IncomingCallActivity.class);
			currentActivity.startActivityForResult(intent, INCOMING_CALL_ACTIVITY);
		}
	}
	public static void startVideoActivity(final LinphoneCall call, int delay) {
		if (VideoCallActivity.launched || call == null) {
			Log.d("ALModule", "not start VideoActivity");
			return;
		}
		
		mHandler.postDelayed(new Runnable() {
			public void run() {
				if (VideoCallActivity.launched) return;
				Log.d("ALModule", "start VideoActivity");
				
//				ALModuleProxy.getInstance().startOrientationSensor();
				LinphoneCall c = LinphoneManager.getLc().getCurrentCall();
				if(c != null) LinphoneManager.getInstance().enableCamera(c, true);
				LinphoneManager lm = LinphoneManager.getInstance();
				if(lm != null)
					lm.enableCamera(call, true);

				Intent intent = new Intent().setClass(context, VideoCallActivity.class);
			//	currentActivity.startActivityForResult(intent, video_activity);
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(intent);
				// Avoid two consecutive runs to enter the previous block
				VideoCallActivity.launched = true;
				}
		}, delay);
		//121205suzuki test
//		}, 100);
		LinphoneManager.getInstance().routeAudioToSpeaker();
	}
	public static synchronized void startIncallActivity(int deray) {
		if (IncallActivity.instance() != null && IncallActivity.instance().isActive()) {
			return;
		}

		mHandler.postDelayed(new Runnable() {
			public void run() {
				if (IncallActivity.active) return;
				Intent intent = new Intent().setClass(context, IncallActivity.class);
//				currentActivity.startActivityForResult(intent, incall_activity);
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(intent);
			}
		}, deray);
	}
	private void exitIncallActivity() {
		currentActivity.setVolumeControlStream(AudioManager.USE_DEFAULT_STREAM_TYPE);
	}
	
	private OrientationEventListener mOrientationHelper;
	/**
	 * Register a sensor to track phoneOrientation changes
	 */
	private synchronized void startOrientationSensor() {
		if (mOrientationHelper == null) {
			mOrientationHelper = new ALModuleProxy.LocalOrientationEventListener(context);
		}
		mOrientationHelper.enable();
	}

	private int mAlwaysChangingPhoneAngle = -1;
	private class LocalOrientationEventListener extends OrientationEventListener {
		public LocalOrientationEventListener(Context context) {
			super(context);
		}
		@Override
		public void onOrientationChanged(final int o) {
			if (o == OrientationEventListener.ORIENTATION_UNKNOWN) return;

			int degrees=270;
			if (o < 45 || o >315) degrees=0;
			else if (o<135) degrees=90;
			else if (o<225) degrees=180;

			if (mAlwaysChangingPhoneAngle == degrees) return;
			mAlwaysChangingPhoneAngle = degrees;

			Log.d("Phone orientation changed to ", ""+degrees);
			int rotation = (360 - degrees) % 360;
			LinphoneCore lc=LinphoneManager.getLcIfManagerNotDestroyedOrNull();
			if (lc!=null){
				lc.setDeviceRotation(rotation);
				LinphoneCall currentCall = lc.getCurrentCall();
				if (currentCall != null && currentCall.cameraEnabled() && currentCall.getCurrentParamsCopy().getVideoEnabled()) {
					lc.updateCall(currentCall, null);
				}
			}
		}
	}
	
	public static void startConferenceDetailsActivity() {
		Intent intent = new Intent().setClass(context, ConferenceDetailsActivity.class);
		currentActivity.startActivityForResult(intent, conferenceDetailsActivity);
	}
	public static void onRegistrationStateChanged(RegistrationState state,
			String message) {
		
		if (FirstLoginActivity.instance != null) {
			FirstLoginActivity.instance.onRegistrationStateChanged(state);
		}
		
		ALModuleProxy a = ALModuleProxy.getInstance();
		if(a == null) return;

		KrollDict dict = new KrollDict();
		dict.put("message", message);

		if(state == RegistrationState.RegistrationOk)
		{
			dict.put("result", "success");
		}
		else if(state == RegistrationState.RegistrationFailed)
		{
			dict.put("result", "faild");
		}
		a.fireEvent(dict, "RegistrationStateChanged");
	}
	
	public static ALModuleProxy getInstance()
	{
		return instance;
	}

//	@Override
//	public void onTextReceived(LinphoneAddress from, String message) {
////		Object[] obj = {from.toString(), message};
//		Log.d("Linphone2", from.toString());
//		Log.d("Linphone2", message);
//
//		if(message.startsWith("invite:") == true)
//		{
//			String callstate = message.substring(7);
//			boolean b = callstate.startsWith("video");
//			
//			Log.d("Linphone2", callstate);
//
//			SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
//			SharedPreferences.Editor editor = pref.edit();
//			editor.putBoolean(context.getString(R.get("string", "pref_video_automatically_accept_video_key")), b);
//			editor.putBoolean(context.getString(R.get("string", "pref_video_initiate_call_with_video_key")), b);
//			
//			LinphoneManager.getLc().setVideoPolicy(b, b);
//			editor.commit();
//			
//			return;
//		}
//	}
	
	@Kroll.method
	public void sendMessage(String target, String message)
	{
		SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
		String domain = pref.getString(context.getString(R.get("string", "pref_domain_key")), "");

		LinphoneManager.getLc()
						.createChatRoom(target + "@" + domain)
						.sendMessage(message);
	}
	
	@Kroll.method
	public void resume()
	{
		LinphoneManager lm;
		
		try{
			lm = LinphoneManager.getInstance();
		} catch (Exception e) {
			return;
		}
		
		LinphoneCall call = lm.getPendingIncomingCall();
		if(call != null)
		{
			startIncomingCallActivity();
		}
	}
	
	private void setInitiateVideoCalls(boolean b)
	{
		SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
		SharedPreferences.Editor editor = pref.edit();
		editor.putBoolean(context.getString(R.get("string", "pref_video_initiate_call_with_video_key")), b);
		editor.putBoolean(context.getString(R.get("string", "pref_video_automatically_accept_video_key")), b);
		editor.putBoolean(context.getString(R.get("string", "pref_video_automatically_share_my_video_key")), b);
		editor.putBoolean(context.getString(R.get("string", "pref_video_enable_key")), b);
		editor.commit();
		
//		LinphoneManager.getLc().enableVideo(b, b);
//		LinphoneCall c = LinphoneManager.getLc().getCurrentCall();
//		if(c != null)
//		{
//			c.enableCamera(b);
//		}

		isVideoCall = b;
	}
	
	@Kroll.method
	public void stopService()
	{
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.setClass(context, LinphoneService.class);
		
		currentActivity.stopService(intent);
	}
	
	public void fireEvent(KrollDict dict, String eventName)
	{
		//
		KrollFunction callback = (KrollFunction)getProperty(eventName);
		if(callback != null)
		{
//			KrollDict dict = new KrollDict();
//			dict.put("from", from.toString());
//			dict.put("message", message);
	
			callback.callAsync(getKrollObject(), dict);
		}
	}
	
//	Thread ringToneThread = null;
//	boolean isRingTone = true;
//	MediaPlayer ring;
//	Runnable ringToneTask = new Runnable(){
//		public void run()
//		{
//			isRingTone = true;
//			ring = MediaPlayer.create(context, R.get("raw", "oldphone_mono"));
//			
//			LinphoneManager.getInstance().routeAudioToReceiver();
//
//			while(isRingTone == true)
//			{
//				if(ring != null && isRingTone == true)
//					ring.start();
//				try {
//					Thread.sleep(2500);
//				} catch (InterruptedException e) {
//
//					stopRingTone();
//					e.printStackTrace();
//				}
//				if(ring != null && isRingTone == true)
//					ring.pause();
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//
//					stopRingTone();
//					e.printStackTrace();
//				}
//			}
//			stopRingTone();
//		}
//	};
	
//	public void stopRingTone()
//	{
//		isRingTone = false;
//		if(ring != null)
//		{
//			ring.stop();
//			ring.release();
//			ring = null;
//		}
//		
//		ringToneThread = null;
//	}

	@Kroll.method
	public void set_mic_vol(String str)
	{
		float f = Float.parseFloat(str);

		LinphoneCore lc = LinphoneManager.getLcIfManagerNotDestroyedOrNull();
		if (lc==null) {
			return;
		}

		f = 1.0f / f;
		lc.setMicVol(f);
	}

	@Kroll.method
	public void set_mic_lim(String str)
	{
		float f = Float.parseFloat(str);

		LinphoneCore lc = LinphoneManager.getLcIfManagerNotDestroyedOrNull();
		if (lc==null) {
			return;
		}

		lc.setMicLim((int)f);
	}

	@Kroll.method
	public void set_speaker_vol(String str)
	{
		float f = Float.parseFloat(str);

		LinphoneCore lc = LinphoneManager.getLcIfManagerNotDestroyedOrNull();
		if (lc==null) {
			return;
		}

		lc.setSpeakerVol(f);
	}

	@Kroll.method
	public void set_speaker_lim(String str)
	{
		float f = Float.parseFloat(str);

		LinphoneCore lc = LinphoneManager.getLcIfManagerNotDestroyedOrNull();
		if (lc==null) {
			return;
		}

		lc.setSpeakerLim((int)f);
	}
	
	public static void setContext(Context context)
	{
		if(ALModuleProxy.context != null) return;
		
		ALModuleProxy.context = context;
	}
}
