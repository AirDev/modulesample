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

import jp.co.aircast.module.MakeIntentProxy;

import org.appcelerator.kroll.KrollProxyPrototype;


public class MakeIntentProxyPrototype extends KrollProxyPrototype
{
	// GENERATE_SUID

	private static final boolean DBG = TiConfig.LOGD;
	private static final String TAG = "MakeIntentProxyPrototype";
	private static final String CLASS_TAG = "MakeIntentProxy";
	private static MakeIntentProxyPrototype makeIntentProxyPrototype;


	public static MakeIntentProxyPrototype getProxyPrototype()
	{
		return makeIntentProxyPrototype;
	}

	public static void dispose()
	{
		if (DBG) {
			Log.d(TAG, "dispose()");
		}
		makeIntentProxyPrototype = null;
	}

	public MakeIntentProxyPrototype()
	{
		if (makeIntentProxyPrototype == null && getClass().equals(MakeIntentProxyPrototype.class)) {
			makeIntentProxyPrototype = this;
			KrollGeneratedBindings.registerUsedPrototypeClass(getClass());
		}

	}

	public Scriptable getPrototype()
	{
		if (this == makeIntentProxyPrototype) {
			return KrollProxyPrototype.getProxyPrototype();
		}
		return makeIntentProxyPrototype;
	}

	protected Class<? extends Proxy> getParent()
	{
		return KrollProxyPrototype.class;
	}

	protected KrollProxySupport createProxy(String creationUrl, Object[] args)
	{
		return KrollProxy.createProxy(MakeIntentProxy.class, getRhinoObject(), args, creationUrl);
	}

	// Methods
	public void start(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "start()");
		}

		try {
		MakeIntentProxy proxy = (MakeIntentProxy) ((Proxy) thisObj).getProxy();
		if (args.length < 1) {
			throw new IllegalArgumentException("start: Invalid number of arguments. Expected 1 but got " + args.length);
		}
		org.appcelerator.kroll.KrollDict arg0;
		if (args[0] == null) {
			arg0 = null;
		} else {
		arg0 = new KrollDict((HashMap)  TypeConverter.jsObjectToJavaObject(args[0], thisObj) );
		}

		proxy.start(arg0);
	

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			
		}
	}

	public void setCallback(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "setCallback()");
		}

		try {
		MakeIntentProxy proxy = (MakeIntentProxy) ((Proxy) thisObj).getProxy();
		if (args.length < 1) {
			throw new IllegalArgumentException("setCallback: Invalid number of arguments. Expected 1 but got " + args.length);
		}
		org.appcelerator.kroll.KrollFunction arg0;
		arg0 = (org.appcelerator.kroll.KrollFunction) TypeConverter.jsObjectToJavaObject(args[0], thisObj) ;

		proxy.setCallback(arg0);
	

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
		Id_start = 2,
		Id_setCallback = 3
;
		

	public static final int MAX_PROTOTYPE_ID = 3;

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
            int s_length = s.length();
            if (s_length==5) { X="start";id=Id_start; }
            else if (s_length==11) {
                c=s.charAt(0);
                if (c=='c') { X="constructor";id=Id_constructor; }
                else if (c=='s') { X="setCallback";id=Id_setCallback; }
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
			case Id_start:
				arity = 1;
				name = "start";
				break;
			case Id_setCallback:
				arity = 1;
				name = "setCallback";
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

		while (thisObj != null && !(thisObj instanceof MakeIntentProxyPrototype)) {
			thisObj = thisObj.getPrototype();
		}

		MakeIntentProxyPrototype proxy = (MakeIntentProxyPrototype) thisObj;
		int id = f.methodId();
		switch (id) {
			case Id_constructor:
				return jsConstructor(scope, args);
			case Id_start:
				 start(cx, thisObj, args);
				return Undefined.instance;
			case Id_setCallback:
				 setCallback(cx, thisObj, args);
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
