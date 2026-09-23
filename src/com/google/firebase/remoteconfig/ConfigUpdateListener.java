package com.google.firebase.remoteconfig;

/* JADX INFO: loaded from: classes6.dex */
public interface ConfigUpdateListener {
    void onError(FirebaseRemoteConfigException firebaseRemoteConfigException);

    void onUpdate(ConfigUpdate configUpdate);
}
