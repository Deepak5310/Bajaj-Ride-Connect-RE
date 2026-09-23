package com.google.android.libraries.navigation.internal.tu;

import android.speech.tts.UtteranceProgressListener;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e extends UtteranceProgressListener {
    final /* synthetic */ f a;

    public e(f fVar) {
        this.a = fVar;
    }

    @Override // android.speech.tts.UtteranceProgressListener
    public final void onDone(String str) {
        this.a.d(str);
    }

    @Override // android.speech.tts.UtteranceProgressListener
    public final void onError(String str) {
        this.a.e(str);
    }

    @Override // android.speech.tts.UtteranceProgressListener
    public final void onStart(String str) {
    }

    @Override // android.speech.tts.UtteranceProgressListener
    public final void onStop(String str, boolean z) {
        this.a.e(str);
    }
}
