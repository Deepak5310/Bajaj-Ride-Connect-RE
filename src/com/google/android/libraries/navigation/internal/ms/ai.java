package com.google.android.libraries.navigation.internal.ms;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ai extends bu {
    private final bt a;
    private final com.google.android.libraries.navigation.internal.yx.br b;

    public ai(bt btVar, com.google.android.libraries.navigation.internal.yx.br brVar) {
        if (btVar == null) {
            throw new NullPointerException("Null layout");
        }
        this.a = btVar;
        this.b = brVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.bu
    public final bt a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.bu
    public final com.google.android.libraries.navigation.internal.yx.br b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.bu
    public final void c() {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof bu) {
            bu buVar = (bu) obj;
            if (this.a.equals(buVar.a()) && this.b.equals(buVar.b())) {
                buVar.c();
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ 1231;
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.br brVar = this.b;
        return "LayoutItem{layout=" + this.a.toString() + ", viewModelSupplier=" + brVar.toString() + ", enabled=true}";
    }
}
