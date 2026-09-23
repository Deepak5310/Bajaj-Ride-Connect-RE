package com.google.android.libraries.navigation.internal.yz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class du extends aj {
    final Object a;
    int b;
    final /* synthetic */ ed c;

    public du(ed edVar, int i) {
        this.c = edVar;
        this.a = edVar.a[i];
        this.b = i;
    }

    final void a() {
        int i = this.b;
        if (i != -1) {
            ed edVar = this.c;
            if (i <= edVar.c && com.google.android.libraries.navigation.internal.yx.am.a(edVar.a[i], this.a)) {
                return;
            }
        }
        this.b = this.c.b(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.aj, java.util.Map.Entry
    public final Object getKey() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.aj, java.util.Map.Entry
    public final Object getValue() {
        a();
        int i = this.b;
        if (i == -1) {
            return null;
        }
        return this.c.b[i];
    }

    @Override // com.google.android.libraries.navigation.internal.yz.aj, java.util.Map.Entry
    public final Object setValue(Object obj) {
        a();
        int i = this.b;
        if (i == -1) {
            this.c.put(this.a, obj);
            return null;
        }
        Object obj2 = this.c.b[i];
        if (com.google.android.libraries.navigation.internal.yx.am.a(obj2, obj)) {
            return obj;
        }
        this.c.n(this.b, obj);
        return obj2;
    }
}
