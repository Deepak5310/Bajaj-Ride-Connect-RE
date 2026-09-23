package com.google.android.libraries.navigation.internal.sa;

import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c extends g {
    private eq a;
    private ev b;
    private String c;
    private String d;
    private String e;
    private String f;

    @Override // com.google.android.libraries.navigation.internal.sa.g
    public final h a() {
        String str;
        String str2;
        String str3;
        eq eqVar = this.a;
        if (eqVar != null) {
            this.b = eqVar.g();
        } else if (this.b == null) {
            int i = ev.d;
            this.b = lv.a;
        }
        String str4 = this.c;
        if (str4 == null || (str = this.d) == null || (str2 = this.e) == null || (str3 = this.f) == null) {
            throw new IllegalStateException();
        }
        return new d(this.b, str4, str, str2, str3);
    }

    @Override // com.google.android.libraries.navigation.internal.sa.g
    public final eq b() {
        if (this.a == null) {
            if (this.b == null) {
                int i = ev.d;
                this.a = new eq();
            } else {
                int i2 = ev.d;
                eq eqVar = new eq();
                this.a = eqVar;
                eqVar.j(this.b);
                this.b = null;
            }
        }
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.sa.g
    public final void c(String str) {
        Objects.requireNonNull(str);
        this.f = str;
    }

    @Override // com.google.android.libraries.navigation.internal.sa.g
    public final void d(String str) {
        Objects.requireNonNull(str);
        this.e = str;
    }

    @Override // com.google.android.libraries.navigation.internal.sa.g
    public final void e(String str) {
        Objects.requireNonNull(str);
        this.d = str;
    }

    @Override // com.google.android.libraries.navigation.internal.sa.g
    public final void f(String str) {
        Objects.requireNonNull(str);
        this.c = str;
    }

    @Override // com.google.android.libraries.navigation.internal.sa.g
    public final void g(ev evVar) {
        Objects.requireNonNull(evVar);
        if (this.a != null) {
            throw new IllegalStateException();
        }
        this.b = evVar;
    }
}
