package com.google.ar.imp.core.media;

import android.media.MediaPlayer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class OnErrorListener implements MediaPlayer.OnErrorListener {
    private final long a;

    public OnErrorListener(long j) {
        this.a = j;
    }

    private static native boolean nOnError(long j, int i, int i2);

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        return nOnError(this.a, i, i2);
    }
}
