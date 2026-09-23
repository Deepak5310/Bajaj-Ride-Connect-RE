package com.google.android.libraries.navigation.internal.yz;

import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ca extends aj {
    final /* synthetic */ cc a;
    private final Object b;
    private int c;

    public ca(cc ccVar, int i) {
        this.a = ccVar;
        this.b = ccVar.g(i);
        this.c = i;
    }

    private final void a() {
        int i = this.c;
        if (i == -1 || i >= this.a.size() || !com.google.android.libraries.navigation.internal.yx.am.a(this.b, this.a.g(this.c))) {
            this.c = this.a.f(this.b);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.yz.aj, java.util.Map.Entry
    public final Object getKey() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.aj, java.util.Map.Entry
    public final Object getValue() {
        Map mapN = this.a.n();
        if (mapN != null) {
            return mapN.get(this.b);
        }
        a();
        int i = this.c;
        if (i == -1) {
            return null;
        }
        return this.a.j(i);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.aj, java.util.Map.Entry
    public final Object setValue(Object obj) {
        Map mapN = this.a.n();
        if (mapN != null) {
            return mapN.put(this.b, obj);
        }
        a();
        int i = this.c;
        if (i == -1) {
            this.a.put(this.b, obj);
            return null;
        }
        cc ccVar = this.a;
        Object objJ = ccVar.j(i);
        ccVar.t(this.c, obj);
        return objJ;
    }
}
