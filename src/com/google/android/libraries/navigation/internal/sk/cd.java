package com.google.android.libraries.navigation.internal.sk;

import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.audiofx.LoudnessEnhancer;
import com.google.android.libraries.navigation.internal.ace.hm;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cd implements c {
    public a a;
    private ca b;
    private final AtomicBoolean c = new AtomicBoolean(false);
    private final AtomicBoolean d = new AtomicBoolean(false);
    private final com.google.android.libraries.navigation.internal.sl.s e;
    private MediaPlayer f;
    private final Executor g;
    private final com.google.android.libraries.navigation.internal.hn.r h;
    private final int i;

    public cd(MediaPlayer mediaPlayer, com.google.android.libraries.navigation.internal.sl.s sVar, Executor executor, int i, com.google.android.libraries.navigation.internal.hn.r rVar) {
        this.f = mediaPlayer;
        this.e = sVar;
        this.g = executor;
        this.i = i;
        this.h = rVar;
        mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setUsage(12).setContentType(1).build());
        if (com.google.android.libraries.navigation.internal.j.a.a()) {
            this.b = new ca();
        }
        g(mediaPlayer);
    }

    private final void g(MediaPlayer mediaPlayer) {
        ca caVar;
        mediaPlayer.setVolume(1.0f, 1.0f);
        int audioSessionId = mediaPlayer.getAudioSessionId();
        if (!com.google.android.libraries.navigation.internal.j.a.a() || (caVar = this.b) == null) {
            return;
        }
        int i = this.e.d;
        try {
            caVar.a = new LoudnessEnhancer(audioSessionId);
            caVar.a.setEnabled(true);
            LoudnessEnhancer loudnessEnhancer = caVar.a;
            if (loudnessEnhancer != null) {
                loudnessEnhancer.setTargetGain(i * 100);
            }
        } catch (Exception unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1454)).p("Error when enabling loudness enhancer:");
        }
    }

    private final synchronized void h() {
        MediaPlayer mediaPlayer = this.f;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            if (((hm) this.h.b()).i) {
                MediaPlayer mediaPlayer2 = this.f;
                com.google.android.libraries.navigation.internal.yx.ar.q(mediaPlayer2);
                mediaPlayer2.reset();
            }
            MediaPlayer mediaPlayer3 = this.f;
            com.google.android.libraries.navigation.internal.yx.ar.q(mediaPlayer3);
            mediaPlayer3.release();
            this.f = null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.sk.c
    public final long a() {
        if (!((hm) this.h.b()).s) {
            MediaPlayer mediaPlayer = this.f;
            return mediaPlayer == null ? -1 : mediaPlayer.getDuration();
        }
        MediaPlayer mediaPlayer2 = this.f;
        if (mediaPlayer2 == null || !this.c.get() || !this.d.get()) {
            return -1L;
        }
        try {
            return mediaPlayer2.getDuration();
        } catch (RuntimeException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1455)).p("MediaPlayer.getDuration() failed.");
            return -1L;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.sk.c
    public final void b() {
        f();
    }

    @Override // com.google.android.libraries.navigation.internal.sk.c
    public final synchronized void c(a aVar) {
        com.google.android.libraries.navigation.internal.yx.ar.k(this.c.get());
        this.a = aVar;
        MediaPlayer mediaPlayer = this.f;
        if (mediaPlayer == null) {
            if (aVar != null) {
                aVar.a(this);
            }
        } else {
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.google.android.libraries.navigation.internal.sk.cb
                @Override // android.media.MediaPlayer.OnCompletionListener
                public final void onCompletion(MediaPlayer mediaPlayer2) {
                    this.a.f();
                }
            });
            g(mediaPlayer);
            aVar.b(this);
            mediaPlayer.start();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.sk.c
    public final boolean d() {
        this.c.set(true);
        MediaPlayer mediaPlayer = this.f;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.prepare();
                this.d.set(true);
            } catch (Exception unused) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1466)).p("Exception while preparing MediaPlayer");
                mediaPlayer.release();
                this.f = null;
                this.c.set(false);
                this.d.set(false);
            }
        }
        return this.c.get();
    }

    @Override // com.google.android.libraries.navigation.internal.sk.c
    public final int e() {
        return this.i;
    }

    final void f() {
        ca caVar;
        h();
        if (com.google.android.libraries.navigation.internal.j.a.a() && (caVar = this.b) != null) {
            LoudnessEnhancer loudnessEnhancer = caVar.a;
            if (loudnessEnhancer != null) {
                loudnessEnhancer.release();
                caVar.a = null;
            }
            this.b = null;
        }
        this.g.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.sk.cc
            @Override // java.lang.Runnable
            public final void run() {
                cd cdVar = this.a;
                a aVar = cdVar.a;
                if (aVar != null) {
                    aVar.a(cdVar);
                }
                cdVar.a = null;
            }
        });
    }
}
