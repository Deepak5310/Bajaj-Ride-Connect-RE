package com.google.android.libraries.navigation.internal.sk;

import android.app.Application;
import android.speech.tts.TextToSpeech;
import android.speech.tts.Voice;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ef implements com.google.android.libraries.navigation.internal.sl.p {
    public static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.sk.ef");
    public final Application b;
    public final Executor c;
    public final com.google.android.libraries.navigation.internal.hn.r d;
    public final com.google.android.libraries.navigation.internal.th.c e;
    public final com.google.android.libraries.navigation.internal.aac.ca f = new com.google.android.libraries.navigation.internal.aac.ca();
    public final d g;
    public TextToSpeech h;
    public String i;
    public Locale j;
    public final dw k;

    public ef(Application application, d dVar, com.google.android.libraries.navigation.internal.hn.r rVar, com.google.android.libraries.navigation.internal.th.c cVar, dw dwVar) {
        this.b = application;
        this.c = (Executor) dVar.a().a();
        this.d = rVar;
        this.e = cVar;
        this.k = dwVar;
        this.g = dVar;
    }

    static boolean d(Locale locale, Locale locale2) {
        boolean zEquals = locale.getCountry().equals(locale2.getCountry());
        try {
            return zEquals | locale.getISO3Country().equals(locale2.getCountry());
        } catch (MissingResourceException unused) {
            return zEquals;
        }
    }

    static boolean e(Locale locale, Locale locale2) {
        if (locale2 == null) {
            return false;
        }
        boolean zEquals = locale.getLanguage().equals(locale2.getLanguage());
        try {
            return zEquals | locale.getISO3Language().equals(locale2.getLanguage());
        } catch (MissingResourceException unused) {
            return zEquals;
        }
    }

    static boolean f(Locale locale, Locale locale2) {
        return locale != null && locale2 != null && e(locale, locale2) && d(locale, locale2);
    }

    @Override // com.google.android.libraries.navigation.internal.sl.p
    public final int a(Locale locale) {
        int i = -2;
        if (locale == null) {
            return -2;
        }
        try {
            TextToSpeech textToSpeech = this.h;
            int language = textToSpeech != null ? textToSpeech.setLanguage(locale) : -1;
            Locale localeC = c();
            boolean zF = f(locale, localeC);
            boolean zE = e(locale, localeC);
            if (language == -2 || language == -1) {
                i = language;
            } else if (zF) {
                i = 1;
            } else if (zE) {
                i = 0;
            }
            this.j = localeC;
            return i;
        } catch (Exception e) {
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F((char) 1510)).p("Exception in TTS.setLanguage()");
            return -1;
        }
    }

    public final String b() {
        if (this.h == null) {
            return null;
        }
        try {
            return (String) TextToSpeech.class.getMethod("getCurrentEngine", null).invoke(this.h, null);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.sl.p
    public final Locale c() {
        try {
            TextToSpeech textToSpeech = this.h;
            if (textToSpeech != null) {
                return textToSpeech.getLanguage();
            }
            return null;
        } catch (Exception e) {
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F((char) 1529)).p("Exception calling getLanguage()");
            return new Locale(AppMeasurement.CRASH_ORIGIN);
        }
    }

    public final boolean g(Voice voice, String str) {
        TextToSpeech textToSpeech = this.h;
        if (textToSpeech == null || textToSpeech.setVoice(voice) != 0) {
            this.i = null;
            return false;
        }
        this.i = str;
        return true;
    }
}
