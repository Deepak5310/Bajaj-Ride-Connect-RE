package com.mappls.sdk.navigation.iface;

/* JADX INFO: loaded from: classes4.dex */
public interface VoiceCommandListener {
    void speak(String str);

    default String willSpeak(String str) {
        return null;
    }
}
