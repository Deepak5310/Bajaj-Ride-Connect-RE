package com.reactnativecommunity.netinfo;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;

/* JADX INFO: loaded from: classes4.dex */
public class NetInfoModuleImpl implements AmazonFireDeviceConnectivityPoller.ConnectivityChangedCallback {
    public static final String NAME = "RNCNetInfo";
    private final AmazonFireDeviceConnectivityPoller mAmazonConnectivityChecker;
    private final ConnectivityReceiver mConnectivityReceiver;
    private int numberOfListeners = 0;

    public NetInfoModuleImpl(ReactApplicationContext reactApplicationContext) {
        this.mConnectivityReceiver = new NetworkCallbackConnectivityReceiver(reactApplicationContext);
        this.mAmazonConnectivityChecker = new AmazonFireDeviceConnectivityPoller(reactApplicationContext, this);
    }

    public void initialize() {
        this.mConnectivityReceiver.register();
        this.mAmazonConnectivityChecker.register();
    }

    public void onCatalystInstanceDestroy() {
        invalidate();
    }

    public void invalidate() {
        this.mAmazonConnectivityChecker.unregister();
        this.mConnectivityReceiver.unregister();
        this.mConnectivityReceiver.hasListener = false;
    }

    @ReactMethod
    public void getCurrentState(String str, Promise promise) {
        this.mConnectivityReceiver.getCurrentState(str, promise);
    }

    @Override // com.reactnativecommunity.netinfo.AmazonFireDeviceConnectivityPoller.ConnectivityChangedCallback
    public void onAmazonFireDeviceConnectivityChanged(boolean z) {
        this.mConnectivityReceiver.setIsInternetReachableOverride(z);
    }

    public void addListener(String str) {
        this.numberOfListeners++;
        this.mConnectivityReceiver.hasListener = true;
    }

    public void removeListeners(double d) {
        int i = (int) (((double) this.numberOfListeners) - d);
        this.numberOfListeners = i;
        if (i == 0) {
            this.mConnectivityReceiver.hasListener = false;
        }
    }
}
