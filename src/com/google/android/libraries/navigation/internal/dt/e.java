package com.google.android.libraries.navigation.internal.dt;

import com.google.android.libraries.navigation.internal.oe.x;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e {
    public final x a;
    public float b;
    public float c;
    public boolean d;
    public String e;

    public e(e eVar) {
        this.b = Float.NaN;
        this.c = Float.NaN;
        this.d = false;
        this.e = "";
        this.a = new x(eVar.a);
        this.b = eVar.b;
        this.c = eVar.c;
        this.d = false;
        this.e = eVar.e;
    }

    public final void a(e eVar) {
        this.a.W(eVar.a);
        this.b = eVar.b;
        this.c = eVar.c;
        this.d = false;
        this.e = eVar.e;
    }
}
