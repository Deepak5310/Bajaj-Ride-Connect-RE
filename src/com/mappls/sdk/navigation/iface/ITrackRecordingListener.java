package com.mappls.sdk.navigation.iface;

/* JADX INFO: loaded from: classes4.dex */
public interface ITrackRecordingListener {
    void onRecordingEnded();

    void onRecordingInfoUpdated(String str, float f, long j);

    void onRecordingStarted();
}
