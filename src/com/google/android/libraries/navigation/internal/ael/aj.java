package com.google.android.libraries.navigation.internal.ael;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class aj implements ev {
    public final ai a;

    public aj(ai aiVar) {
        Charset charset = ca.a;
        this.a = aiVar;
        aiVar.f = this;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ev
    public final void a(int i, boolean z) throws IOException {
        this.a.ay(i, z);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ev
    public final void b(int i, x xVar) throws IOException {
        this.a.az(i, xVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ev
    public final void c(int i, double d) throws IOException {
        this.a.ae(i, d);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ev
    @Deprecated
    public final void d(int i) throws IOException {
        this.a.u(i, 4);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ev
    public final void e(int i, int i2) throws IOException {
        this.a.m(i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ev
    public final void f(int i, int i2) throws IOException {
        this.a.i(i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ev
    public final void g(int i, long j) throws IOException {
        this.a.k(i, j);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ev
    public final void h(int i, float f) throws IOException {
        this.a.ag(i, f);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ev
    public final void i(int i, Object obj, dr drVar) throws IOException {
        ai aiVar = this.a;
        aiVar.u(i, 3);
        drVar.j((cy) obj, aiVar.f);
        aiVar.u(i, 4);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ev
    public final void j(int i, int i2) throws IOException {
        this.a.m(i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ev
    public final void k(int i, long j) throws IOException {
        this.a.x(i, j);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ev
    public final void l(int i, Object obj, dr drVar) throws IOException {
        this.a.o(i, (cy) obj, drVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ev
    public final void m(int i, Object obj) throws IOException {
        if (obj instanceof x) {
            this.a.r(i, (x) obj);
        } else {
            this.a.q(i, (cy) obj);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ev
    public final void n(int i, int i2) throws IOException {
        this.a.i(i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ev
    public final void o(int i, long j) throws IOException {
        this.a.k(i, j);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ev
    public final void p(int i, int i2) throws IOException {
        this.a.aj(i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ev
    public final void q(int i, long j) throws IOException {
        this.a.al(i, j);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ev
    @Deprecated
    public final void r(int i) throws IOException {
        this.a.u(i, 3);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ev
    public final void s(int i, String str) throws IOException {
        this.a.s(i, str);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ev
    public final void t(int i, int i2) throws IOException {
        this.a.v(i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ev
    public final void u(int i, long j) throws IOException {
        this.a.x(i, j);
    }
}
