package com.google.android.libraries.navigation.internal.sk;

import android.speech.tts.TextToSpeech;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dz implements TextToSpeech.OnInitListener {
    final /* synthetic */ com.google.android.libraries.navigation.internal.sl.n a;
    final /* synthetic */ ea b;

    public dz(ea eaVar, com.google.android.libraries.navigation.internal.sl.n nVar) {
        this.a = nVar;
        this.b = eaVar;
    }

    @Override // android.speech.tts.TextToSpeech.OnInitListener
    public final void onInit(int i) {
        this.b.a = i;
        this.b.b(i, Locale.getDefault(), this.a);
    }
}
