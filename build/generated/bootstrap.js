/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2011 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 * Warning: This file is GENERATED, and should not be modified
 */
var bootstrap = kroll.NativeModule.require("bootstrap"),
	invoker = kroll.NativeModule.require("invoker"),
	Titanium = kroll.binding("Titanium").Titanium;

function moduleBootstrap(moduleBinding) {
	function lazyGet(object, binding, name, namespace) {
		return bootstrap.lazyGet(object, binding,
			name, namespace, moduleBinding.getBinding);
	}

	var module = moduleBinding.getBinding("jp.co.aircast.module.ModulesampleModule")["Modulesample"];
	var invocationAPIs = module.invocationAPIs = [];
	module.apiName = "Modulesample";

	function addInvocationAPI(module, moduleNamespace, namespace, api) {
		invocationAPIs.push({ namespace: namespace, api: api });
	}

		addInvocationAPI(module, "Modulesample", "Modulesample", "createALModule");
	addInvocationAPI(module, "Modulesample", "Modulesample", "createMakeIntent");
	addInvocationAPI(module, "Modulesample", "Modulesample", "createVideoView");

			if (!("__propertiesDefined__" in module)) {		
		Object.defineProperties(module, {
			"MakeIntent": {
				get: function() {
					var MakeIntent = lazyGet(this, "jp.co.aircast.module.MakeIntentProxy", "MakeIntent", "MakeIntent");
					return MakeIntent;
				},
				configurable: true
			},
			"VideoView": {
				get: function() {
					var VideoView = lazyGet(this, "jp.co.aircast.module.VideoViewProxy", "VideoView", "VideoView");
					return VideoView;
				},
				configurable: true
			},
			"ALModule": {
				get: function() {
					var ALModule = lazyGet(this, "jp.co.aircast.module.ALModuleProxy", "ALModule", "ALModule");
					return ALModule;
				},
				configurable: true
			},
		
		});
		module.constructor.prototype.createALModule = function() {
			return new module.ALModule(arguments);
		}
		module.constructor.prototype.createMakeIntent = function() {
			return new module.MakeIntent(arguments);
		}
		module.constructor.prototype.createVideoView = function() {
			return new module.VideoView(arguments);
		}
		}
		module.__propertiesDefined__ = true;
		return module;

}
exports.bootstrap = moduleBootstrap;
