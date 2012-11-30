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

import jp.co.aircast.module.ModulesampleModule;

import org.appcelerator.kroll.KrollModulePrototype;


public class ModulesampleModulePrototype extends KrollModulePrototype
{
	// GENERATE_SUID

	private static final boolean DBG = TiConfig.LOGD;
	private static final String TAG = "ModulesampleModulePrototype";
	private static final String CLASS_TAG = "ModulesampleModule";
	private static ModulesampleModulePrototype modulesampleModulePrototype;

	// Lazy loaded child APIs
	private Object API_VideoView = null;
	private Object API_ALModule = null;
	private Object API_MakeIntent = null;

	public static ModulesampleModulePrototype getProxyPrototype()
	{
		return modulesampleModulePrototype;
	}

	public static void dispose()
	{
		if (DBG) {
			Log.d(TAG, "dispose()");
		}
		modulesampleModulePrototype = null;
	}

	public ModulesampleModulePrototype()
	{
		if (modulesampleModulePrototype == null && getClass().equals(ModulesampleModulePrototype.class)) {
			modulesampleModulePrototype = this;
			KrollGeneratedBindings.registerUsedPrototypeClass(getClass());
		}

		isModule = true;
	}

	public Scriptable getPrototype()
	{
		if (this == modulesampleModulePrototype) {
			return KrollModulePrototype.getProxyPrototype();
		}
		return modulesampleModulePrototype;
	}

	protected Class<? extends Proxy> getParent()
	{
		return KrollModulePrototype.class;
	}

	protected KrollProxySupport createProxy(String creationUrl, Object[] args)
	{
		return KrollProxy.createProxy(ModulesampleModule.class, getRhinoObject(), args, creationUrl);
	}

	// Methods
	public Object getPhoneNumber(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "getPhoneNumber()");
		}

		try {
		ModulesampleModule proxy = (ModulesampleModule) ((Proxy) thisObj).getProxy();

		java.lang.String javaResult = proxy.getPhoneNumber();

		String rhinoResult = (String) javaResult;
	
			return rhinoResult;

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			return Undefined.instance;
		}
	}


	// Dynamic properties

// #string_id_map#

	// Prototype IDs
	private static final int
		Id_constructor = 1
,		// Property IDs
		// Method IDs
		Id_getPhoneNumber = 2,
		Id_createALModule = 3,
				Id_createMakeIntent = 4,
				Id_createVideoView = 5
		;
		

	public static final int MAX_PROTOTYPE_ID = 5;

	protected int getMaxPrototypeId()
	{
		return MAX_PROTOTYPE_ID;
	}

	@Override
	protected int findPrototypeId(String s)
	{
		int id = 0;
// #generated# Last update: 2012-11-30 20:51:11 JST
        L0: { id = 0; String X = null; int c;
            L: switch (s.length()) {
            case 11: X="constructor";id=Id_constructor; break L;
            case 14: c=s.charAt(0);
                if (c=='c') { X="createALModule";id=Id_createALModule; }
                else if (c=='g') { X="getPhoneNumber";id=Id_getPhoneNumber; }
                break L;
            case 15: X="createVideoView";id=Id_createVideoView; break L;
            case 16: X="createMakeIntent";id=Id_createMakeIntent; break L;
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
			case Id_getPhoneNumber:
				arity = 0;
				name = "getPhoneNumber";
				break;
			case Id_createALModule:
				arity = 1;
				name = "createALModule";
				break;
			case Id_createMakeIntent:
				arity = 1;
				name = "createMakeIntent";
				break;
			case Id_createVideoView:
				arity = 1;
				name = "createVideoView";
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

		while (thisObj != null && !(thisObj instanceof ModulesampleModulePrototype)) {
			thisObj = thisObj.getPrototype();
		}

		ModulesampleModulePrototype proxy = (ModulesampleModulePrototype) thisObj;
		int id = f.methodId();
		switch (id) {
			case Id_constructor:
				return jsConstructor(scope, args);
			case Id_getPhoneNumber:
				return getPhoneNumber(cx, thisObj, args);
				
			case Id_createALModule:
				return ProxyFactory.createRhinoProxy(cx, scope,
					"jp.co.aircast.module.ALModuleProxy", args);
			case Id_createMakeIntent:
				return ProxyFactory.createRhinoProxy(cx, scope,
					"jp.co.aircast.module.MakeIntentProxy", args);
			case Id_createVideoView:
				return ProxyFactory.createRhinoProxy(cx, scope,
					"jp.co.aircast.module.VideoViewProxy", args);
			default:
				throw new IllegalArgumentException(String.valueOf(id));
		}
	}



// #string_id_map#

	// Instance IDs
	private static final int ISTART = 0;
;

;

	// Child APIs
	private static final int

		Id_VideoView = 1
		,		
		Id_ALModule = 2
		,		
		Id_MakeIntent = 3
		;

	public static final int MAX_INSTANCE_ID = 3;

	@Override
	protected int getMaxInstanceId()
	{
		return MAX_INSTANCE_ID;
	}

	@Override
	protected int findInstanceIdInfo(String s)
	{
		int id = 0;
// #generated# Last update: 2012-11-30 20:51:11 JST
        L0: { id = 0; String X = null;
            int s_length = s.length();
            if (s_length==8) { X="ALModule";id=Id_ALModule; }
            else if (s_length==9) { X="VideoView";id=Id_VideoView; }
            else if (s_length==10) { X="MakeIntent";id=Id_MakeIntent; }
            if (X!=null && X!=s && !X.equals(s)) id = 0;
            break L0;
        }
// #/generated#
		if (id == 0) {
			return id;
		}
		return instanceIdInfo(PERMANENT, id);
	}

// #/string_id_map#

	@Override
	protected String getInstanceIdName(int id)
	{
		switch (id) {
			case Id_VideoView:
				return "VideoView";
			case Id_ALModule:
				return "ALModule";
			case Id_MakeIntent:
				return "MakeIntent";
			default:
				throw new IllegalArgumentException(String.valueOf(id));
		}
	}

	@Override
	protected Object getInstanceIdValue(int id, Scriptable start)
	{
		ModulesampleModulePrototype proxy = this;
		while (start != null && !(start instanceof ModulesampleModulePrototype)) {
			start = start.getPrototype();
		}

		if (start instanceof ModulesampleModulePrototype) {
			proxy = (ModulesampleModulePrototype) start;
		}

		switch (id) {
			case Id_VideoView:
				if (proxy.API_VideoView == null) {
					Context context = Context.getCurrentContext();
					Scriptable scope = RhinoRuntime.getGlobalScope();

					proxy.API_VideoView = KrollBindings.getProxyBinding(context, scope,
						"jp.co.aircast.module.VideoViewProxy", jp.co.aircast.module.VideoViewProxyPrototype.class); 
				}
				return proxy.API_VideoView;
			case Id_ALModule:
				if (proxy.API_ALModule == null) {
					Context context = Context.getCurrentContext();
					Scriptable scope = RhinoRuntime.getGlobalScope();

					proxy.API_ALModule = KrollBindings.getProxyBinding(context, scope,
						"jp.co.aircast.module.ALModuleProxy", jp.co.aircast.module.ALModuleProxyPrototype.class); 
				}
				return proxy.API_ALModule;
			case Id_MakeIntent:
				if (proxy.API_MakeIntent == null) {
					Context context = Context.getCurrentContext();
					Scriptable scope = RhinoRuntime.getGlobalScope();

					proxy.API_MakeIntent = KrollBindings.getProxyBinding(context, scope,
						"jp.co.aircast.module.MakeIntentProxy", jp.co.aircast.module.MakeIntentProxyPrototype.class); 
				}
				return proxy.API_MakeIntent;
			default:
				throw new IllegalArgumentException(String.valueOf(id));
		}
	}

	@Override
	protected void setInstanceIdValue(int id, Scriptable start, Object value)
	{
		Scriptable original = start;
		ModulesampleModulePrototype proxy = this;
		while (start != null && !(start instanceof ModulesampleModulePrototype)) {
			start = start.getPrototype();
		}

		if (start instanceof ModulesampleModulePrototype) {
			proxy = (ModulesampleModulePrototype) start;
		}

		switch (id) {
			case Id_VideoView:
				if (value instanceof Proxy) {
					proxy.API_VideoView = value;
				} else {
					defineProperty(original, "VideoView", value, 0);
				}
				break;
			case Id_ALModule:
				if (value instanceof Proxy) {
					proxy.API_ALModule = value;
				} else {
					defineProperty(original, "ALModule", value, 0);
				}
				break;
			case Id_MakeIntent:
				if (value instanceof Proxy) {
					proxy.API_MakeIntent = value;
				} else {
					defineProperty(original, "MakeIntent", value, 0);
				}
				break;
			default:
				throw new IllegalArgumentException(String.valueOf(id));
		}
	}

	@Override
	public String getClassName()
	{
		return CLASS_TAG;
	}
}
