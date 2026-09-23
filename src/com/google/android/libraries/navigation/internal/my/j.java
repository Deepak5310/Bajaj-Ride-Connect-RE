package com.google.android.libraries.navigation.internal.my;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class j implements i {
    public Object a;

    public final void a() {
        this.a = null;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof i) && l.b(this, (i) obj);
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.my.i
    public final Object get() {
        return this.a;
    }

    public final int hashCode() {
        return System.identityHashCode(this.a);
    }
}
