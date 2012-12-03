/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2011-2012 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

package jp.co.aircast.module;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Undefined;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollInvocation;
import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.KrollProxy;
import org.appcelerator.kroll.KrollProxySupport;
import org.appcelerator.kroll.KrollRuntime;

import org.appcelerator.kroll.common.TiConfig;

import org.appcelerator.kroll.runtime.rhino.KrollBindings;
import org.appcelerator.kroll.runtime.rhino.KrollGeneratedBindings;
import org.appcelerator.kroll.runtime.rhino.Proxy;
import org.appcelerator.kroll.runtime.rhino.ProxyFactory;
import org.appcelerator.kroll.runtime.rhino.RhinoRuntime;
import org.appcelerator.kroll.runtime.rhino.TypeConverter;
import org.appcelerator.kroll.common.Log;

import java.util.HashMap;

import jp.co.aircast.module.ALModuleProxy;

import org.appcelerator.kroll.KrollProxyPrototype;


public class ALModuleProxyPrototype extends KrollProxyPrototype
{
	// GENERATE_SUID

	private static final boolean DBG = TiConfig.LOGD;
	private static final String TAG = "ALModuleProxyPrototype";
	private static final String CLASS_TAG = "ALModuleProxy";
	private static ALModuleProxyPrototype aLModuleProxyPrototype;


	public static ALModuleProxyPrototype getProxyPrototype()
	{
		return aLModuleProxyPrototype;
	}

	public static void dispose()
	{
		if (DBG) {
			Log.d(TAG, "dispose()");
		}
		aLModuleProxyPrototype = null;
	}

	public ALModuleProxyPrototype()
	{
		if (aLModuleProxyPrototype == null && getClass().equals(ALModuleProxyPrototype.class)) {
			aLModuleProxyPrototype = this;
			KrollGeneratedBindings.registerUsedPrototypeClass(getClass());
		}

	}

	public Scriptable getPrototype()
	{
		if (this == aLModuleProxyPrototype) {
			return KrollProxyPrototype.getProxyPrototype();
		}
		return aLModuleProxyPrototype;
	}

	protected Class<? extends Proxy> getParent()
	{
		return KrollProxyPrototype.class;
	}

	protected KrollProxySupport createProxy(String creationUrl, Object[] args)
	{
		return KrollProxy.createProxy(ALModuleProxy.class, getRhinoObject(), args, creationUrl);
	}

	// Methods
	public void sendMessage(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "sendMessage()");
		}

		try {
		ALModuleProxy proxy = (ALModuleProxy) ((Proxy) thisObj).getProxy();
		if (args.length < 2) {
			throw new IllegalArgumentException("sendMessage: Invalid number of arguments. Expected 2 but got " + args.length);
		}
		java.lang.String arg0;
		arg0 = (java.lang.String) TypeConverter.jsObjectToJavaString(args[0], thisObj) ;
		java.lang.String arg1;
		arg1 = (java.lang.String) TypeConverter.jsObjectToJavaString(args[1], thisObj) ;

		proxy.sendMessage(arg0, arg1);
	

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			
		}
	}

	public void setting(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "setting()");
		}

		try {
		ALModuleProxy proxy = (ALModuleProxy) ((Proxy) thisObj).getProxy();

		proxy.setting();
	

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			
		}
	}

	public void set_mic_vol(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "set_mic_vol()");
		}

		try {
		ALModuleProxy proxy = (ALModuleProxy) ((Proxy) thisObj).getProxy();
		if (args.length < 1) {
			throw new IllegalArgumentException("set_mic_vol: Invalid number of arguments. Expected 1 but got " + args.length);
		}
		java.lang.String arg0;
		arg0 = (java.lang.String) TypeConverter.jsObjectToJavaString(args[0], thisObj) ;

		proxy.set_mic_vol(arg0);
	

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			
		}
	}

	public void stopService(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "stopService()");
		}

		try {
		ALModuleProxy proxy = (ALModuleProxy) ((Proxy) thisObj).getProxy();

		proxy.stopService();
	

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			
		}
	}

	public void call(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "call()");
		}

		try {
		ALModuleProxy proxy = (ALModuleProxy) ((Proxy) thisObj).getProxy();
		if (args.length < 5) {
			throw new IllegalArgumentException("call: Invalid number of arguments. Expected 5 but got " + args.length);
		}
		java.lang.String arg0;
		arg0 = (java.lang.String) TypeConverter.jsObjectToJavaString(args[0], thisObj) ;
		java.lang.String arg1;
		arg1 = (java.lang.String) TypeConverter.jsObjectToJavaString(args[1], thisObj) ;
		java.lang.String arg2;
		arg2 = (java.lang.String) TypeConverter.jsObjectToJavaString(args[2], thisObj) ;
		java.lang.String arg3;
		arg3 = (java.lang.String) TypeConverter.jsObjectToJavaString(args[3], thisObj) ;
		java.lang.String arg4;
		arg4 = (java.lang.String) TypeConverter.jsObjectToJavaString(args[4], thisObj) ;

		proxy.call(arg0, arg1, arg2, arg3, arg4);
	

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			
		}
	}

	public void resume(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "resume()");
		}

		try {
		ALModuleProxy proxy = (ALModuleProxy) ((Proxy) thisObj).getProxy();

		proxy.resume();
	

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			
		}
	}

	public void set_speaker_lim(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "set_speaker_lim()");
		}

		try {
		ALModuleProxy proxy = (ALModuleProxy) ((Proxy) thisObj).getProxy();
		if (args.length < 1) {
			throw new IllegalArgumentException("set_speaker_lim: Invalid number of arguments. Expected 1 but got " + args.length);
		}
		java.lang.String arg0;
		arg0 = (java.lang.String) TypeConverter.jsObjectToJavaString(args[0], thisObj) ;

		proxy.set_speaker_lim(arg0);
	

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			
		}
	}

	public void set_mic_lim(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "set_mic_lim()");
		}

		try {
		ALModuleProxy proxy = (ALModuleProxy) ((Proxy) thisObj).getProxy();
		if (args.length < 1) {
			throw new IllegalArgumentException("set_mic_lim: Invalid number of arguments. Expected 1 but got " + args.length);
		}
		java.lang.String arg0;
		arg0 = (java.lang.String) TypeConverter.jsObjectToJavaString(args[0], thisObj) ;

		proxy.set_mic_lim(arg0);
	

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			
		}
	}

	public void videoCall(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "videoCall()");
		}

		try {
		ALModuleProxy proxy = (ALModuleProxy) ((Proxy) thisObj).getProxy();
		if (args.length < 5) {
			throw new IllegalArgumentException("videoCall: Invalid number of arguments. Expected 5 but got " + args.length);
		}
		java.lang.String arg0;
		arg0 = (java.lang.String) TypeConverter.jsObjectToJavaString(args[0], thisObj) ;
		java.lang.String arg1;
		arg1 = (java.lang.String) TypeConverter.jsObjectToJavaString(args[1], thisObj) ;
		java.lang.String arg2;
		arg2 = (java.lang.String) TypeConverter.jsObjectToJavaString(args[2], thisObj) ;
		java.lang.String arg3;
		arg3 = (java.lang.String) TypeConverter.jsObjectToJavaString(args[3], thisObj) ;
		java.lang.String arg4;
		arg4 = (java.lang.String) TypeConverter.jsObjectToJavaString(args[4], thisObj) ;

		proxy.videoCall(arg0, arg1, arg2, arg3, arg4);
	

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			
		}
	}

	public void regist(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "regist()");
		}

		try {
		ALModuleProxy proxy = (ALModuleProxy) ((Proxy) thisObj).getProxy();

		proxy.regist();
	

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			
		}
	}

	public void set_speaker_vol(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "set_speaker_vol()");
		}

		try {
		ALModuleProxy proxy = (ALModuleProxy) ((Proxy) thisObj).getProxy();
		if (args.length < 1) {
			throw new IllegalArgumentException("set_speaker_vol: Invalid number of arguments. Expected 1 but got " + args.length);
		}
		java.lang.String arg0;
		arg0 = (java.lang.String) TypeConverter.jsObjectToJavaString(args[0], thisObj) ;

		proxy.set_speaker_vol(arg0);
	

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			
		}
	}


	// Dynamic properties

// #string_id_map#

	// Prototype IDs
	private static final int
		Id_constructor = 1
,		// Property IDs
		// Method IDs
		Id_sendMessage = 2,
		Id_setting = 3,
		Id_set_mic_vol = 4,
		Id_stopService = 5,
		Id_call = 6,
		Id_resume = 7,
		Id_set_speaker_lim = 8,
		Id_set_mic_lim = 9,
		Id_videoCall = 10,
		Id_regist = 11,
		Id_set_speaker_vol = 12
;
		

	public static final int MAX_PROTOTYPE_ID = 12;

	protected int getMaxPrototypeId()
	{
		return MAX_PROTOTYPE_ID;
	}

	@Override
	protected int findPrototypeId(String s)
	{
		int id = 0;
// #generated# Last update: 2012-12-03 16:10:36 JST
        L0: { id = 0; String X = null; int c;
            L: switch (s.length()) {
            case 4: X="call";id=Id_call; break L;
            case 6: c=s.charAt(2);
                if (c=='g') { X="regist";id=Id_regist; }
                else if (c=='s') { X="resume";id=Id_resume; }
                break L;
            case 7: X="setting";id=Id_setting; break L;
            case 9: X="videoCall";id=Id_videoCall; break L;
            case 11: switch (s.charAt(8)) {
                case 'a': X="sendMessage";id=Id_sendMessage; break L;
                case 'i': X="stopService";id=Id_stopService; break L;
                case 'l': X="set_mic_lim";id=Id_set_mic_lim; break L;
                case 't': X="constructor";id=Id_constructor; break L;
                case 'v': X="set_mic_vol";id=Id_set_mic_vol; break L;
                } break L;
            case 15: c=s.charAt(12);
                if (c=='l') { X="set_speaker_lim";id=Id_set_speaker_lim; }
                else if (c=='v') { X="set_speaker_vol";id=Id_set_speaker_vol; }
                break L;
            }
            if (X!=null && X!=s && !X.equals(s)) id = 0;
            break L0;
        }
// #/generated#
		return id;
	}

// #/string_id_map#

	@Override
	protected void initPrototypeId(int id)
	{
		String name;
		int arity;
		switch (id) {
			case Id_constructor:
				arity = 0;
				name = "constructor";
				break;
			case Id_sendMessage:
				arity = 2;
				name = "sendMessage";
				break;
			case Id_setting:
				arity = 0;
				name = "setting";
				break;
			case Id_set_mic_vol:
				arity = 1;
				name = "set_mic_vol";
				break;
			case Id_stopService:
				arity = 0;
				name = "stopService";
				break;
			case Id_call:
				arity = 5;
				name = "call";
				break;
			case Id_resume:
				arity = 0;
				name = "resume";
				break;
			case Id_set_speaker_lim:
				arity = 1;
				name = "set_speaker_lim";
				break;
			case Id_set_mic_lim:
				arity = 1;
				name = "set_mic_lim";
				break;
			case Id_videoCall:
				arity = 5;
				name = "videoCall";
				break;
			case Id_regist:
				arity = 0;
				name = "regist";
				break;
			case Id_set_speaker_vol:
				arity = 1;
				name = "set_speaker_vol";
				break;
			default:
				super.initPrototypeId(id);
				return;
		}
		initPrototypeMethod(CLASS_TAG, id, name, arity);
	}

	@Override
	public Object execIdCall(IdFunctionObject f,
		Context cx, Scriptable scope, Scriptable thisObj, Object[] args)
	{
		if (!f.hasTag(CLASS_TAG)) {
			return super.execIdCall(f, cx, scope, thisObj, args);
		}

		while (thisObj != null && !(thisObj instanceof ALModuleProxyPrototype)) {
			thisObj = thisObj.getPrototype();
		}

		ALModuleProxyPrototype proxy = (ALModuleProxyPrototype) thisObj;
		int id = f.methodId();
		switch (id) {
			case Id_constructor:
				return jsConstructor(scope, args);
			case Id_sendMessage:
				 sendMessage(cx, thisObj, args);
				return Undefined.instance;
			case Id_setting:
				 setting(cx, thisObj, args);
				return Undefined.instance;
			case Id_set_mic_vol:
				 set_mic_vol(cx, thisObj, args);
				return Undefined.instance;
			case Id_stopService:
				 stopService(cx, thisObj, args);
				return Undefined.instance;
			case Id_call:
				 call(cx, thisObj, args);
				return Undefined.instance;
			case Id_resume:
				 resume(cx, thisObj, args);
				return Undefined.instance;
			case Id_set_speaker_lim:
				 set_speaker_lim(cx, thisObj, args);
				return Undefined.instance;
			case Id_set_mic_lim:
				 set_mic_lim(cx, thisObj, args);
				return Undefined.instance;
			case Id_videoCall:
				 videoCall(cx, thisObj, args);
				return Undefined.instance;
			case Id_regist:
				 regist(cx, thisObj, args);
				return Undefined.instance;
			case Id_set_speaker_vol:
				 set_speaker_vol(cx, thisObj, args);
				return Undefined.instance;
			default:
				throw new IllegalArgumentException(String.valueOf(id));
		}
	}



	public static final int MAX_INSTANCE_ID = -1;


	@Override
	public String getClassName()
	{
		return CLASS_TAG;
	}
}
