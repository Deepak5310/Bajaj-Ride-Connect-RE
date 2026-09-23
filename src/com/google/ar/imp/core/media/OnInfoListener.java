package com.google.ar.imp.core.media;

import android.media.MediaPlayer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class OnInfoListener implements MediaPlayer.OnInfoListener {
    private final long a;

    public OnInfoListener(long j) {
        this.a = j;
    }

    private static native boolean nOnInfo(long j, int i, int i2);

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        return nOnInfo(this.a, i, i2);
    }
}
