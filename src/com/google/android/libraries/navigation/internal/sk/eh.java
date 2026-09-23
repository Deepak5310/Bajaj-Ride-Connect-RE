package com.google.android.libraries.navigation.internal.sk;

import java.io.File;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class eh implements c {
    public c a;
    public final int b;
    private final File c;
    private int d;
    private final ce e;
    private final com.google.android.libraries.navigation.internal.iv.f f;

    public eh(File file, ce ceVar, com.google.android.libraries.navigation.internal.iv.f fVar, boolean z) {
        this.c = file;
        this.e = ceVar;
        this.f = fVar;
        this.b = z ? b.b : b.a;
    }

    @Override // com.google.android.libraries.navigation.internal.sk.c
    public final long a() {
        c cVar = this.a;
        if (cVar != null) {
            return cVar.a();
        }
        return -1L;
    }

    @Override // com.google.android.libraries.navigation.internal.sk.c
    public final void b() {
        c cVar = this.a;
        if (cVar != null) {
            ((cd) cVar).f();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.sk.c
    public final void c(a aVar) {
        c cVar = this.a;
        if (cVar == null) {
            aVar.a(this);
        } else {
            cVar.c(new eg(this, aVar));
            this.d++;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.sk.c
    public final boolean d() {
        c cVarB = this.e.b(this.c, com.google.android.libraries.navigation.internal.sl.s.a(this.f), this.b);
        this.a = cVarB;
        if (cVarB != null) {
            return cVarB.d();
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.sk.c
    public final int e() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eh)) {
            return false;
        }
        eh ehVar = (eh) obj;
        return com.google.android.libraries.navigation.internal.yx.am.a(this.c, ehVar.c) && com.google.android.libraries.navigation.internal.yx.am.a(this.a, ehVar.a) && this.d == ehVar.d;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.c, this.a, Integer.valueOf(this.d)});
    }
}
