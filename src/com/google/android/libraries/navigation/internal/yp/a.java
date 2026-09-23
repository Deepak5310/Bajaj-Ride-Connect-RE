package com.google.android.libraries.navigation.internal.yp;

import com.google.android.libraries.navigation.internal.ael.bm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum a implements bm {
    IDLE(0),
    LISTENING(1),
    RECORDING(2),
    PROCESSING(3),
    PLAYING_TTS(4);

    private final int g;

    a(int i) {
        this.g = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.g;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.g);
    }
}
