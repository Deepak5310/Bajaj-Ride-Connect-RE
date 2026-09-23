package com.google.android.libraries.navigation.internal.oq;

import com.google.android.libraries.navigation.internal.oe.r;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends e {
    private r a;
    private float b;
    private float c;
    private j d;
    private float e;
    private byte f;

    public a() {
    }

    public a(f fVar) {
        b bVar = (b) fVar;
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f = (byte) 7;
    }

    @Override // com.google.android.libraries.navigation.internal.oq.e
    public final float a() {
        if ((this.f & 1) != 0) {
            return this.b;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.navigation.internal.oq.e
    public final float b() {
        if ((this.f & 2) != 0) {
            return this.c;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.navigation.internal.oq.e
    public final float c() {
        if ((this.f & 4) != 0) {
            return this.e;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.navigation.internal.oq.e
    public final r d() {
        r rVar = this.a;
        if (rVar != null) {
            return rVar;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.navigation.internal.oq.e
    public final e e(r rVar) {
        Objects.requireNonNull(rVar);
        this.a = rVar;
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.oq.e
    public final f f() {
        r rVar;
        j jVar;
        if (this.f != 7 || (rVar = this.a) == null || (jVar = this.d) == null) {
            throw new IllegalStateException();
        }
        return new b(rVar, this.b, this.c, jVar, this.e);
    }

    @Override // com.google.android.libraries.navigation.internal.oq.e
    public final j g() {
        j jVar = this.d;
        if (jVar != null) {
            return jVar;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.navigation.internal.oq.e
    public final void h(float f) {
        this.b = f;
        this.f = (byte) (this.f | 1);
    }

    @Override // com.google.android.libraries.navigation.internal.oq.e
    public final void i(j jVar) {
        Objects.requireNonNull(jVar);
        this.d = jVar;
    }

    @Override // com.google.android.libraries.navigation.internal.oq.e
    public final void j(float f) {
        this.c = f;
        this.f = (byte) (this.f | 2);
    }

    @Override // com.google.android.libraries.navigation.internal.oq.e
    public final void k(float f) {
        this.e = f;
        this.f = (byte) (this.f | 4);
    }
}
