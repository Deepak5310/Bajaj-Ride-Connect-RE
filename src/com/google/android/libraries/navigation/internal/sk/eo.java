package com.google.android.libraries.navigation.internal.sk;

import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class eo {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.sk.eo");
    private final com.google.android.libraries.navigation.internal.fz.d b;
    private final com.google.android.libraries.navigation.internal.iv.f c;
    private String d;

    public eo(com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.iv.f fVar) {
        this.b = dVar;
        this.c = fVar;
    }

    public final String a() {
        if (!e()) {
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1557)).p("getVoiceName() called when VoicePreferenceManager not enabled.");
        }
        String str = this.d;
        return str == null ? b() : str;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0027 A[PHI: r0
      0x0027: PHI (r0v10 java.lang.String) = (r0v8 java.lang.String), (r0v1 java.lang.String) binds: [B:11:0x003d, B:5:0x0024] A[DONT_GENERATE, DONT_INLINE]] */
    public final String b() {
        String str = "";
        String strI = this.c.i(com.google.android.libraries.navigation.internal.iv.ab.aF, "");
        if (com.google.android.libraries.navigation.internal.yx.am.a(Locale.getDefault(), Locale.forLanguageTag(this.c.i(com.google.android.libraries.navigation.internal.iv.ab.aG, ""))) && !strI.isEmpty()) {
            str = strI;
        } else if ((this.b.R().b & 512) != 0) {
            strI = this.b.R().f321n;
            if (strI == null) {
                ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1558)).p("getVoiceName is null even though hasVoiceName is true, see b/174922295.");
            } else {
                str = strI;
            }
        }
        this.d = str;
        return str;
    }

    public final void c(String str, String str2) {
        if (!e()) {
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1559)).p("updateVoicePreferenceInformation() called when VoicePreferenceManager not enabled.");
        }
        this.d = null;
        this.c.t(com.google.android.libraries.navigation.internal.iv.ab.aF, str);
        this.c.t(com.google.android.libraries.navigation.internal.iv.ab.aG, str2);
    }

    public final boolean d() {
        if (!e()) {
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1560)).p("isDefaultMapsVoice() called when VoicePreferenceManager not enabled.");
        }
        return a().equals(this.b.R().f321n);
    }

    public final boolean e() {
        return this.b.R().o;
    }
}
