package com.google.android.libraries.navigation.internal.sl;

import com.google.common.base.Ascii;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class j extends f {
    private i a;
    private boolean b;
    private boolean c;
    private boolean d;
    private m e;
    private int f;
    private boolean g;
    private e h;
    private byte i;

    @Override // com.google.android.libraries.navigation.internal.sl.f
    public final g a() {
        i iVar;
        m mVar;
        e eVar;
        if (this.i != 31 || (iVar = this.a) == null || (mVar = this.e) == null || (eVar = this.h) == null) {
            throw new IllegalStateException();
        }
        return new k(iVar, this.b, this.c, this.d, mVar, this.f, this.g, eVar);
    }

    @Override // com.google.android.libraries.navigation.internal.sl.f
    public final void b(boolean z) {
        this.d = z;
        this.i = (byte) (this.i | 4);
    }

    @Override // com.google.android.libraries.navigation.internal.sl.f
    public final void c(boolean z) {
        this.c = z;
        this.i = (byte) (this.i | 2);
    }

    @Override // com.google.android.libraries.navigation.internal.sl.f
    public final void d(boolean z) {
        this.b = z;
        this.i = (byte) (this.i | 1);
    }

    @Override // com.google.android.libraries.navigation.internal.sl.f
    public final void e(i iVar) {
        Objects.requireNonNull(iVar);
        this.a = iVar;
    }

    @Override // com.google.android.libraries.navigation.internal.sl.f
    public final void f(e eVar) {
        Objects.requireNonNull(eVar);
        this.h = eVar;
    }

    @Override // com.google.android.libraries.navigation.internal.sl.f
    public final void g(boolean z) {
        this.g = z;
        this.i = (byte) (this.i | Ascii.DLE);
    }

    @Override // com.google.android.libraries.navigation.internal.sl.f
    public final void h(m mVar) {
        Objects.requireNonNull(mVar);
        this.e = mVar;
    }

    @Override // com.google.android.libraries.navigation.internal.sl.f
    public final void i(int i) {
        this.f = i;
        this.i = (byte) (this.i | 8);
    }
}
