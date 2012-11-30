package jp.co.aircast.module;

import java.util.HashMap;

import org.appcelerator.kroll.runtime.rhino.KrollBindings;

public class modulesampleGeneratedBindings
{
	public static void init()
	{
		KrollBindings.addExternalBinding("jp.co.aircast.module.ALModuleProxy", jp.co.aircast.module.ALModuleProxyPrototype.class);
		KrollBindings.addExternalBinding("jp.co.aircast.module.ModulesampleModule", jp.co.aircast.module.ModulesampleModulePrototype.class);
		KrollBindings.addExternalBinding("jp.co.aircast.module.MakeIntentProxy", jp.co.aircast.module.MakeIntentProxyPrototype.class);
		KrollBindings.addExternalBinding("jp.co.aircast.module.VideoViewProxy", jp.co.aircast.module.VideoViewProxyPrototype.class);
	}
}