package com.google.android.libraries.navigation.internal.ee;

import com.google.android.libraries.navigation.internal.yx.an;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c extends n {
    public int a;
    public byte b;
    private String c;
    private int d;
    private an e;
    private boolean f;
    private boolean g;
    private an h;

    public c() {
        com.google.android.libraries.navigation.internal.yx.a aVar = com.google.android.libraries.navigation.internal.yx.a.a;
        this.e = aVar;
        this.h = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ee.n
    public final p a() {
        String str;
        if (this.b != 15 || (str = this.c) == null) {
            throw new IllegalStateException();
        }
        return new d(str, this.a, this.d, this.e, this.f, this.g, this.h);
    }

    @Override // com.google.android.libraries.navigation.internal.ee.n
    public final void b(String str) {
        Objects.requireNonNull(str);
        this.c = str;
    }

    @Override // com.google.android.libraries.navigation.internal.ee.n
    public final void c(int i) {
        this.e = an.j(Integer.valueOf(i));
    }

    @Override // com.google.android.libraries.navigation.internal.ee.n
    public final void d(int i) {
        this.d = i;
        this.b = (byte) (this.b | 2);
    }

    @Override // com.google.android.libraries.navigation.internal.ee.n
    public final void e(o oVar) {
        this.h = an.j(oVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ee.n
    public final void f(boolean z) {
        this.g = z;
        this.b = (byte) (this.b | 8);
    }

    @Override // com.google.android.libraries.navigation.internal.ee.n
    public final void g(boolean z) {
        this.f = z;
        this.b = (byte) (this.b | 4);
    }
}
