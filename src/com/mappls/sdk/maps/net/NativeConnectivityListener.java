package com.mappls.sdk.maps.net;

import com.mappls.sdk.maps.LibraryLoader;

/* JADX INFO: loaded from: classes4.dex */
class NativeConnectivityListener implements ConnectivityListener {
    private boolean invalidated;
    private long nativePtr;

    protected native void finalize() throws Throwable;

    protected native void initialize();

    protected native void nativeOnConnectivityStateChanged(boolean z);

    static {
        LibraryLoader.load();
    }

    NativeConnectivityListener(long j) {
        this.nativePtr = j;
    }

    NativeConnectivityListener() {
        initialize();
    }

    @Override // com.mappls.sdk.maps.net.ConnectivityListener
    public void onNetworkStateChanged(boolean z) {
        nativeOnConnectivityStateChanged(z);
    }
}
