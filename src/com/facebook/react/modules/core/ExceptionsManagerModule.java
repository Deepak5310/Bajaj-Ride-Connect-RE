package com.facebook.react.modules.core;

import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeExceptionsManagerSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.JavascriptException;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.devsupport.StackTraceHelper;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.util.ExceptionDataHelper;
import com.facebook.react.util.JSStackTrace;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = NativeExceptionsManagerSpec.NAME)
public class ExceptionsManagerModule extends NativeExceptionsManagerSpec {
    private final DevSupportManager mDevSupportManager;

    public ExceptionsManagerModule(DevSupportManager devSupportManager) {
        super(null);
        this.mDevSupportManager = devSupportManager;
    }

    @Override // com.facebook.fbreact.specs.NativeExceptionsManagerSpec
    public void reportFatalException(String str, ReadableArray readableArray, double d) {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.putString(StackTraceHelper.MESSAGE_KEY, str);
        javaOnlyMap.putArray(StackTraceHelper.STACK_KEY, readableArray);
        javaOnlyMap.putInt("id", (int) d);
        javaOnlyMap.putBoolean(StackTraceHelper.IS_FATAL_KEY, true);
        reportException(javaOnlyMap);
    }

    @Override // com.facebook.fbreact.specs.NativeExceptionsManagerSpec
    public void reportSoftException(String str, ReadableArray readableArray, double d) {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.putString(StackTraceHelper.MESSAGE_KEY, str);
        javaOnlyMap.putArray(StackTraceHelper.STACK_KEY, readableArray);
        javaOnlyMap.putInt("id", (int) d);
        javaOnlyMap.putBoolean(StackTraceHelper.IS_FATAL_KEY, false);
        reportException(javaOnlyMap);
    }

    @Override // com.facebook.fbreact.specs.NativeExceptionsManagerSpec
    public void reportException(ReadableMap readableMap) {
        String string = readableMap.hasKey(StackTraceHelper.MESSAGE_KEY) ? readableMap.getString(StackTraceHelper.MESSAGE_KEY) : "";
        ReadableArray array = readableMap.hasKey(StackTraceHelper.STACK_KEY) ? readableMap.getArray(StackTraceHelper.STACK_KEY) : Arguments.createArray();
        boolean z = readableMap.hasKey(StackTraceHelper.IS_FATAL_KEY) ? readableMap.getBoolean(StackTraceHelper.IS_FATAL_KEY) : false;
        String extraDataAsJson = ExceptionDataHelper.getExtraDataAsJson(readableMap);
        if (z) {
            throw new JavascriptException(JSStackTrace.format(string, array)).setExtraDataAsJson(extraDataAsJson);
        }
        FLog.e(ReactConstants.TAG, JSStackTrace.format(string, array));
        if (extraDataAsJson != null) {
            FLog.d(ReactConstants.TAG, "extraData: %s", extraDataAsJson);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeExceptionsManagerSpec
    public void updateExceptionMessage(String str, ReadableArray readableArray, double d) {
        int i = (int) d;
        if (this.mDevSupportManager.getDevSupportEnabled()) {
            this.mDevSupportManager.updateJSError(str, readableArray, i);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeExceptionsManagerSpec
    public void dismissRedbox() {
        if (this.mDevSupportManager.getDevSupportEnabled()) {
            this.mDevSupportManager.hideRedboxDialog();
        }
    }
}
