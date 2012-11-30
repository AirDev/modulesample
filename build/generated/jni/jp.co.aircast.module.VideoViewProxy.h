/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2011 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

/** This is generated, do not edit by hand. **/

#include <jni.h>

#include "Proxy.h"

		namespace jp {
		namespace co {
		namespace aircast {
		namespace module {
			namespace modulesample {


class VideoViewProxy : public titanium::Proxy
{
public:
	explicit VideoViewProxy(jobject javaObject);

	static void bindProxy(v8::Handle<v8::Object> exports);
	static v8::Handle<v8::FunctionTemplate> getProxyTemplate();
	static void dispose();

	static v8::Persistent<v8::FunctionTemplate> proxyTemplate;
	static jclass javaClass;

private:
	// Methods -----------------------------------------------------------
	static v8::Handle<v8::Value> nextCaller(const v8::Arguments&);
	static v8::Handle<v8::Value> call(const v8::Arguments&);
	static v8::Handle<v8::Value> terminate(const v8::Arguments&);
	static v8::Handle<v8::Value> setCaller(const v8::Arguments&);
	static v8::Handle<v8::Value> init(const v8::Arguments&);

	// Dynamic property accessors ----------------------------------------

};

			} // namespace modulesample
		} // module
		} // aircast
		} // co
		} // jp
