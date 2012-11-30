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

import jp.co.aircast.module.VideoViewProxy;

import org.appcelerator.titanium.proxy.TiViewProxyPrototype;


public class VideoViewProxyPrototype extends TiViewProxyPrototype
{
	// GENERATE_SUID

	private static final boolean DBG = TiConfig.LOGD;
	private static final String TAG = "VideoViewProxyPrototype";
	private static final String CLASS_TAG = "VideoViewProxy";
	private static VideoViewProxyPrototype videoViewProxyPrototype;


	public static VideoViewProxyPrototype getProxyPrototype()
	{
		return videoViewProxyPrototype;
	}

	public static void dispose()
	{
		if (DBG) {
			Log.d(TAG, "dispose()");
		}
		videoViewProxyPrototype = null;
	}

	public VideoViewProxyPrototype()
	{
		if (videoViewProxyPrototype == null && getClass().equals(VideoViewProxyPrototype.class)) {
			videoViewProxyPrototype = this;
			KrollGeneratedBindings.registerUsedPrototypeClass(getClass());
		}

	}

	public Scriptable getPrototype()
	{
		if (this == videoViewProxyPrototype) {
			return TiViewProxyPrototype.getProxyPrototype();
		}
		return videoViewProxyPrototype;
	}

	protected Class<? extends Proxy> getParent()
	{
		return TiViewProxyPrototype.class;
	}

	protected KrollProxySupport createProxy(String creationUrl, Object[] args)
	{
		return KrollProxy.createProxy(VideoViewProxy.class, getRhinoObject(), args, creationUrl);
	}

	// Methods
	public void nextCaller(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "nextCaller()");
		}

		try {
		VideoViewProxy proxy = (VideoViewProxy) ((Proxy) thisObj).getProxy();

		proxy.nextCaller();
	

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
		VideoViewProxy proxy = (VideoViewProxy) ((Proxy) thisObj).getProxy();
		if (args.length < 1) {
			throw new IllegalArgumentException("call: Invalid number of arguments. Expected 1 but got " + args.length);
		}
		java.lang.String arg0;
		arg0 = (java.lang.String) TypeConverter.jsObjectToJavaString(args[0], thisObj) ;

		proxy.call(arg0);
	

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			
		}
	}

	public void terminate(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "terminate()");
		}

		try {
		VideoViewProxy proxy = (VideoViewProxy) ((Proxy) thisObj).getProxy();

		proxy.terminate();
	

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			
		}
	}

	public void setCaller(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "setCaller()");
		}

		try {
		VideoViewProxy proxy = (VideoViewProxy) ((Proxy) thisObj).getProxy();
		if (args.length < 1) {
			throw new IllegalArgumentException("setCaller: Invalid number of arguments. Expected 1 but got " + args.length);
		}
		int arg0;
		arg0 = (int) TypeConverter.jsObjectToJavaInt(args[0], thisObj) ;

		proxy.setCaller(arg0);
	

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			
		}
	}

	public void init(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "init()");
		}

		try {
		VideoViewProxy proxy = (VideoViewProxy) ((Proxy) thisObj).getProxy();

		proxy.init();
	

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
		Id_nextCaller = 2,
		Id_call = 3,
		Id_terminate = 4,
		Id_setCaller = 5,
		Id_init = 6
;
		

	public static final int MAX_PROTOTYPE_ID = 6;

	protected int getMaxPrototypeId()
	{
		return MAX_PROTOTYPE_ID;
	}

	@Override
	protected int findPrototypeId(String s)
	{
		int id = 0;
// #generated# Last update: 2012-11-30 14:17:21 JST
        L0: { id = 0; String X = null; int c;
            L: switch (s.length()) {
            case 4: c=s.charAt(0);
                if (c=='c') { X="call";id=Id_call; }
                else if (c=='i') { X="init";id=Id_init; }
                break L;
            case 9: c=s.charAt(0);
                if (c=='s') { X="setCaller";id=Id_setCaller; }
                else if (c=='t') { X="terminate";id=Id_terminate; }
                break L;
            case 10: X="nextCaller";id=Id_nextCaller; break L;
            case 11: X="constructor";id=Id_constructor; break L;
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
			case Id_nextCaller:
				arity = 0;
				name = "nextCaller";
				break;
			case Id_call:
				arity = 1;
				name = "call";
				break;
			case Id_terminate:
				arity = 0;
				name = "terminate";
				break;
			case Id_setCaller:
				arity = 1;
				name = "setCaller";
				break;
			case Id_init:
				arity = 0;
				name = "init";
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

		while (thisObj != null && !(thisObj instanceof VideoViewProxyPrototype)) {
			thisObj = thisObj.getPrototype();
		}

		VideoViewProxyPrototype proxy = (VideoViewProxyPrototype) thisObj;
		int id = f.methodId();
		switch (id) {
			case Id_constructor:
				return jsConstructor(scope, args);
			case Id_nextCaller:
				 nextCaller(cx, thisObj, args);
				return Undefined.instance;
			case Id_call:
				 call(cx, thisObj, args);
				return Undefined.instance;
			case Id_terminate:
				 terminate(cx, thisObj, args);
				return Undefined.instance;
			case Id_setCaller:
				 setCaller(cx, thisObj, args);
				return Undefined.instance;
			case Id_init:
				 init(cx, thisObj, args);
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
