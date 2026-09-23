package com.google.android.libraries.navigation.internal.sk;

import android.speech.tts.TextToSpeech;
import com.reactnativekeyboardcontroller.views.background.ImePackages;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ee implements TextToSpeech.OnInitListener {
    final /* synthetic */ TextToSpeech.OnInitListener a;
    final /* synthetic */ ef b;

    public ee(ef efVar, TextToSpeech.OnInitListener onInitListener) {
        this.a = onInitListener;
        this.b = efVar;
    }

    public final /* synthetic */ void a(int i, TextToSpeech.OnInitListener onInitListener) {
        ef efVar = this.b;
        com.google.android.libraries.navigation.internal.yx.ar.k(efVar.f.isDone());
        if (i == 0) {
            i = -1;
            try {
                efVar.j = efVar.c();
                String strB = efVar.b();
                int i2 = (strB == null || !strB.equals(ImePackages.GOOGLE_TTS)) ? -1 : 0;
                efVar.e.q(efVar.b());
                i = i2;
            } catch (Exception e) {
                ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) ef.a.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F((char) 1532)).p("Exception after TTS reported init SUCCESS");
            }
        }
        onInitListener.onInit(i);
    }

    @Override // android.speech.tts.TextToSpeech.OnInitListener
    public final void onInit(final int i) {
        final TextToSpeech.OnInitListener onInitListener = this.a;
        Runnable runnable = new Runnable() { // from class: com.google.android.libraries.navigation.internal.sk.ed
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(i, onInitListener);
            }
        };
        ef efVar = this.b;
        efVar.f.l(runnable, efVar.c);
    }
}
