package com.google.android.libraries.navigation.internal.yz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dv extends aj {
    final ed a;
    final Object b;
    int c;

    public dv(ed edVar, int i) {
        this.a = edVar;
        this.b = edVar.b[i];
        this.c = i;
    }

    private final void a() {
        int i = this.c;
        if (i != -1) {
            ed edVar = this.a;
            if (i <= edVar.c && com.google.android.libraries.navigation.internal.yx.am.a(this.b, edVar.b[i])) {
                return;
            }
        }
        this.c = this.a.e(this.b);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.aj, java.util.Map.Entry
    public final Object getKey() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.aj, java.util.Map.Entry
    public final Object getValue() {
        a();
        int i = this.c;
        if (i == -1) {
            return null;
        }
        return this.a.a[i];
    }

    @Override // com.google.android.libraries.navigation.internal.yz.aj, java.util.Map.Entry
    public final Object setValue(Object obj) {
        a();
        int i = this.c;
        if (i == -1) {
            this.a.l(this.b, obj);
            return null;
        }
        Object obj2 = this.a.a[i];
        if (com.google.android.libraries.navigation.internal.yx.am.a(obj2, obj)) {
            return obj;
        }
        this.a.m(this.c, obj);
        return obj2;
    }
}
