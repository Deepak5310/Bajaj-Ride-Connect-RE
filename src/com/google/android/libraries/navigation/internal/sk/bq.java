package com.google.android.libraries.navigation.internal.sk;

import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bq {
    public final Locale a;
    public final String b;
    public final bo c;
    public int d = 2;
    private final String e = "CannedSpeechManager#loadBundleByFilename()";

    public bq(Locale locale, String str, bo boVar) {
        this.a = locale;
        this.b = str;
        this.c = boVar;
    }

    final com.google.android.libraries.navigation.internal.afm.af a() {
        com.google.android.libraries.navigation.internal.afm.ae aeVar = (com.google.android.libraries.navigation.internal.afm.ae) com.google.android.libraries.navigation.internal.afm.af.a.q();
        if (!aeVar.b.H()) {
            aeVar.v();
        }
        String str = this.b;
        com.google.android.libraries.navigation.internal.afm.af afVar = (com.google.android.libraries.navigation.internal.afm.af) aeVar.b;
        afVar.b |= 2;
        afVar.d = "/file/".concat(String.valueOf(str));
        String str2 = this.e;
        if (!aeVar.b.H()) {
            aeVar.v();
        }
        com.google.android.libraries.navigation.internal.afm.af afVar2 = (com.google.android.libraries.navigation.internal.afm.af) aeVar.b;
        afVar2.b |= 8;
        afVar2.e = str2;
        bo boVar = this.c;
        if (boVar != null) {
            if (!aeVar.b.H()) {
                aeVar.v();
            }
            long j = boVar.b;
            com.google.android.libraries.navigation.internal.afm.af afVar3 = (com.google.android.libraries.navigation.internal.afm.af) aeVar.b;
            afVar3.b |= 1;
            afVar3.c = j;
        }
        return (com.google.android.libraries.navigation.internal.afm.af) aeVar.t();
    }

    public final String toString() {
        return "Locale=" + String.valueOf(this.a) + ", filename=" + this.b;
    }
}
