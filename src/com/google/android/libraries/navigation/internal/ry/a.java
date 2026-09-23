package com.google.android.libraries.navigation.internal.ry;

import android.graphics.drawable.Drawable;
import com.google.android.libraries.navigation.internal.adr.hs;
import com.google.android.libraries.navigation.internal.rz.ae;
import com.google.android.libraries.navigation.internal.rz.al;
import com.google.android.libraries.navigation.internal.rz.am;
import com.google.android.libraries.navigation.internal.rz.an;
import com.google.android.libraries.navigation.internal.up.f;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements f {
    public final eq f;
    private final ae h = ae.b().a();
    public String a = "";
    public String b = "";
    public String c = "";
    public String d = "";
    public String e = "";
    public int g = 1;
    private final String i = "";

    public a() {
        int i = ev.d;
        this.f = new eq();
    }

    @Override // com.google.android.libraries.navigation.internal.up.f
    public final void a(String str) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.up.f
    public final void b(int i) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.up.f
    public final void c(String str, String str2, hs hsVar, Drawable drawable) {
        throw null;
    }

    public final void d(com.google.android.libraries.navigation.internal.sa.e eVar, String str, hs hsVar) {
        String strTrim = str.trim();
        al alVarG = an.g(am.EXIT_NUMBER);
        alVarG.f(strTrim);
        alVarG.b(hsVar);
        eVar.c(alVarG.a());
        if (this.e.isEmpty()) {
            return;
        }
        if (this.g == 2) {
            this.c = this.e;
        } else {
            this.d = this.e;
        }
        this.e = "";
    }

    @Override // com.google.android.libraries.navigation.internal.up.f
    public final void e(String str) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.up.f
    public final void f(String str) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.up.f
    public final void g(com.google.android.libraries.navigation.internal.bl.d.a aVar) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.up.f
    public final void h(String str) {
        this.b = str.trim();
        if (!this.e.isEmpty()) {
            if (this.g == 3) {
                this.c = this.e;
            }
            this.e = "";
        }
        this.g = 2;
    }

    @Override // com.google.android.libraries.navigation.internal.up.f
    public final void i(String str) {
        this.a = str.trim();
        this.g = 2;
    }

    @Override // com.google.android.libraries.navigation.internal.up.f
    public final void j(String str, String str2, String str3, Drawable drawable) {
        throw null;
    }

    public final void k(com.google.android.libraries.navigation.internal.sa.e eVar, String str, String str2) {
        String strTrim = str2.trim();
        al alVarG = an.g(am.ROAD_BADGE);
        alVarG.f(strTrim);
        alVarG.c(str);
        eVar.c(alVarG.a());
        if (this.e.isEmpty()) {
            return;
        }
        if (this.g == 2) {
            this.c = this.e;
        } else {
            this.d = this.e;
        }
        this.e = "";
    }

    @Override // com.google.android.libraries.navigation.internal.up.f
    public final void l(String str, String str2, String str3) {
        com.google.android.libraries.navigation.internal.sa.e eVarB = com.google.android.libraries.navigation.internal.sa.f.b();
        if (str != null) {
            n(eVarB, str, false);
        }
        n(eVarB, str2, true);
        if (str3 != null) {
            n(eVarB, str3, false);
        }
        this.f.h(eVarB.a());
        this.g = 3;
    }

    @Override // com.google.android.libraries.navigation.internal.up.f
    public final void m(String str, String str2, String str3) {
        throw null;
    }

    public final void n(com.google.android.libraries.navigation.internal.sa.e eVar, String str, boolean z) {
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return;
        }
        al alVarG = an.g(am.TEXTUAL);
        alVarG.f(strTrim);
        alVarG.d(z);
        eVar.c(alVarG.a());
        if (this.e.isEmpty()) {
            return;
        }
        if (this.g == 2) {
            this.c = this.e;
        } else {
            this.d = this.e;
        }
        this.e = "";
    }
}
