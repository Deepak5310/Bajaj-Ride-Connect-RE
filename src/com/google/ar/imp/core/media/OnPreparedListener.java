package com.google.ar.imp.core.media;

import android.media.MediaPlayer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
class OnPreparedListener implements MediaPlayer.OnPreparedListener {
    private final long a;

    public OnPreparedListener(long j) {
        this.a = j;
    }

    private static native void nOnPrepared(long j);

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        nOnPrepared(this.a);
    }
}
