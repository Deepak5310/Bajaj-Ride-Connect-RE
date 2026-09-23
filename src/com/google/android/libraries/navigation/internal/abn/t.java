package com.google.android.libraries.navigation.internal.abn;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class t extends com.google.android.libraries.navigation.internal.ly.f {
    private final u a;
    private final av b;

    public t(u uVar, com.google.android.libraries.navigation.internal.ly.g gVar) {
        this.a = uVar;
        com.google.android.libraries.navigation.internal.abf.s.k(gVar, "Attempted to create no-op CameraAnimation.");
        this.b = new av(gVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ly.g
    public final void a() {
        this.a.e = true;
        try {
            this.b.a();
        } finally {
            this.a.e = false;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ly.g
    public final void b() {
        this.b.b();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.a == tVar.a && com.google.android.libraries.navigation.internal.abf.r.a(this.b, tVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }
}
