package com.google.android.libraries.navigation.internal.ol;

import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.adg.fs;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends an {
    public com.google.android.libraries.navigation.internal.yx.an a;
    private ef b;
    private fs c;
    private boolean d;
    private int e;
    private ap f;
    private com.google.android.libraries.navigation.internal.yx.an g;
    private com.google.android.libraries.navigation.internal.yx.an h;
    private byte i;

    public d() {
        com.google.android.libraries.navigation.internal.yx.a aVar = com.google.android.libraries.navigation.internal.yx.a.a;
        this.g = aVar;
        this.h = aVar;
        this.a = aVar;
    }

    public d(ao aoVar) {
        com.google.android.libraries.navigation.internal.yx.a aVar = com.google.android.libraries.navigation.internal.yx.a.a;
        this.g = aVar;
        this.h = aVar;
        this.a = aVar;
        e eVar = (e) aoVar;
        this.b = eVar.a;
        this.c = eVar.b;
        this.d = eVar.c;
        this.e = eVar.d;
        this.f = eVar.e;
        this.g = eVar.f;
        this.h = eVar.g;
        this.a = eVar.h;
        this.i = (byte) 3;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.an
    public final ao a() {
        ef efVar;
        fs fsVar;
        ap apVar;
        if (this.i != 3 || (efVar = this.b) == null || (fsVar = this.c) == null || (apVar = this.f) == null) {
            throw new IllegalStateException();
        }
        return new e(efVar, fsVar, this.d, this.e, apVar, this.g, this.h, this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.an
    public final void b(int i) {
        this.e = i;
        this.i = (byte) (this.i | 2);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.an
    public final void c(boolean z) {
        this.d = z;
        this.i = (byte) (this.i | 1);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.an
    public final void d(com.google.android.libraries.navigation.internal.yx.an anVar) {
        Objects.requireNonNull(anVar);
        this.h = anVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.an
    public final void e(fs fsVar) {
        Objects.requireNonNull(fsVar);
        this.c = fsVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.an
    public final void f(com.google.android.libraries.navigation.internal.yx.an anVar) {
        Objects.requireNonNull(anVar);
        this.g = anVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.an
    public final void g(ef efVar) {
        Objects.requireNonNull(efVar);
        this.b = efVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.an
    public final void h(ap apVar) {
        Objects.requireNonNull(apVar);
        this.f = apVar;
    }
}
