package com.google.android.libraries.navigation.internal.abj;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends f {
    protected final c a;
    protected final c b;

    public e(c cVar, c cVar2) {
        this.a = cVar;
        this.b = cVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (eVar.b.equals(this.b) && eVar.a.equals(this.a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.b.hashCode() + 31) * 31) + this.a.hashCode();
    }

    public final String toString() {
        return "[" + String.valueOf(this.a) + ", " + String.valueOf(this.b) + "]";
    }
}
