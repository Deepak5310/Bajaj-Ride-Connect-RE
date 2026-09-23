package com.google.android.libraries.navigation.internal.sk;

import android.app.Application;
import android.speech.tts.TextToSpeech;
import java.util.Locale;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ea implements com.google.android.libraries.navigation.internal.sl.o {
    public volatile int a;
    private final Application b;
    private final com.google.android.libraries.navigation.internal.hn.r c;
    private com.google.android.libraries.navigation.internal.sl.p d = null;
    private volatile boolean e;
    private final d f;
    private final dw g;

    public ea(Application application, d dVar, com.google.android.libraries.navigation.internal.hn.r rVar, dw dwVar) {
        this.b = application;
        this.c = rVar;
        this.g = dwVar;
        this.f = dVar;
    }

    private final synchronized void e(com.google.android.libraries.navigation.internal.sl.n nVar, com.google.android.libraries.navigation.internal.sl.p pVar) {
        this.d = pVar;
        dz dzVar = new dz(this, nVar);
        if (((ef) pVar).h == null) {
            final ee eeVar = new ee((ef) pVar, dzVar);
            Executor executor = ((ef) pVar).c;
            final ef efVar = (ef) pVar;
            executor.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.sk.ec
                @Override // java.lang.Runnable
                public final void run() {
                    TextToSpeech.OnInitListener onInitListener = eeVar;
                    ef efVar2 = efVar;
                    if (efVar2.g.e) {
                        com.google.android.libraries.navigation.internal.hx.ap.ALERT_CONTROLLER.f();
                    }
                    try {
                        efVar2.h = dw.a(efVar2.b, onInitListener);
                        efVar2.i = null;
                    } catch (Throwable th) {
                        try {
                            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) ef.a.d(com.google.android.libraries.navigation.internal.nl.a.a).g(th)).F(1531)).p("Exception or error creating TTS");
                            onInitListener.onInit(-1);
                        } finally {
                            efVar2.f.d(null);
                        }
                    }
                }
            });
        }
    }

    @Override // com.google.android.libraries.navigation.internal.sl.o
    public final com.google.android.libraries.navigation.internal.sl.p a() {
        return this.d;
    }

    public final synchronized void b(int i, Locale locale, com.google.android.libraries.navigation.internal.sl.n nVar) {
        boolean z;
        TextToSpeech textToSpeech;
        com.google.android.libraries.navigation.internal.sl.p pVar;
        int i2 = -2;
        if (i == 0) {
            try {
                com.google.android.libraries.navigation.internal.sl.p pVar2 = this.d;
                if (pVar2 != null) {
                    Locale localeC = pVar2.c();
                    int iIsLanguageAvailable = (localeC == null || (textToSpeech = ((ef) pVar2).h) == null) ? -2 : textToSpeech.isLanguageAvailable(localeC);
                    if (!ef.f(locale, localeC)) {
                        iIsLanguageAvailable = pVar2.a(locale);
                        pVar2.c();
                    }
                    if (iIsLanguageAvailable == -2 || iIsLanguageAvailable == -1) {
                        i = 0;
                        z = false;
                    } else {
                        com.google.android.libraries.navigation.internal.sl.p pVar3 = this.d;
                        TextToSpeech textToSpeech2 = ((ef) pVar3).h;
                        if (textToSpeech2 != null) {
                            textToSpeech2.setSpeechRate(1.0f);
                            ((ef) pVar3).h.setPitch(1.0f);
                        }
                        z = true;
                        i = 0;
                    }
                    i2 = iIsLanguageAvailable;
                } else {
                    i = 0;
                    z = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        } else {
            z = false;
        }
        this.e = true;
        if (i == 0 && (pVar = this.d) != null) {
            pVar.c();
        }
        if (z) {
            nVar.a(0);
        } else if (i2 == -1) {
            nVar.a(1);
        } else {
            nVar.a(2);
        }
        notifyAll();
    }

    @Override // com.google.android.libraries.navigation.internal.sl.o
    public final void c(com.google.android.libraries.navigation.internal.sl.n nVar, com.google.android.libraries.navigation.internal.th.c cVar) {
        e(nVar, new ef(this.b, this.f, this.c, cVar, this.g));
    }

    @Override // com.google.android.libraries.navigation.internal.sl.o
    public final synchronized boolean d(Locale locale, com.google.android.libraries.navigation.internal.sl.n nVar) {
        if (!this.e) {
            return false;
        }
        this.e = false;
        b(this.a, locale, nVar);
        return true;
    }
}
