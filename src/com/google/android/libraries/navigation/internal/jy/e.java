package com.google.android.libraries.navigation.internal.jy;

import com.google.android.libraries.navigation.internal.zp.ca;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e extends y {
    public com.google.android.libraries.navigation.internal.hc.a a;
    public com.google.android.libraries.navigation.internal.hc.a b;
    public com.google.android.libraries.navigation.internal.hc.a c;
    public com.google.android.libraries.navigation.internal.hc.a d;
    private ca e;
    private int f;
    private byte g;

    @Override // com.google.android.libraries.navigation.internal.jy.y
    public final z a() {
        ca caVar;
        if (this.g != 1 || (caVar = this.e) == null) {
            throw new IllegalStateException();
        }
        return new f(caVar, this.f, this.a, this.b, this.c, this.d);
    }

    @Override // com.google.android.libraries.navigation.internal.jy.y
    public final void b(int i) {
        this.f = i;
        this.g = (byte) 1;
    }

    @Override // com.google.android.libraries.navigation.internal.jy.y
    public final void c(ca caVar) {
        Objects.requireNonNull(caVar);
        this.e = caVar;
    }
}
