package com.google.ar.imp.core.media;

import android.media.MediaPlayer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
class OnSeekCompleteListener implements MediaPlayer.OnSeekCompleteListener {
    private final long a;

    public OnSeekCompleteListener(long j) {
        this.a = j;
    }

    private static native void nSeekComplete(long j);

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public final void onSeekComplete(MediaPlayer mediaPlayer) {
        nSeekComplete(this.a);
    }
}
