package com.google.android.libraries.navigation.internal.ms;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class bm extends ax {
    protected final Context a;
    private final bg b;

    public bm(Context context, bg bgVar) {
        super(context.getResources().getConfiguration());
        this.a = context;
        this.b = bgVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.ax
    protected final bb a() {
        return new bb(this, this.b, p(), j());
    }

    @Override // com.google.android.libraries.navigation.internal.ms.ax
    protected final be c() {
        return new be();
    }

    @Override // com.google.android.libraries.navigation.internal.ms.ax
    protected final bg e() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.ax
    protected bl g() {
        return new bl();
    }

    @Override // com.google.android.libraries.navigation.internal.ms.ax
    protected final co i() {
        return new bo(this.a, new com.google.android.libraries.navigation.internal.my.a());
    }

    @Override // com.google.android.libraries.navigation.internal.ms.ax
    protected final cr k() {
        return new cr(this.a, j(), b(), f());
    }

    @Override // com.google.android.libraries.navigation.internal.ms.ax
    protected final cv m() {
        return new cv();
    }

    @Override // com.google.android.libraries.navigation.internal.ms.ax
    protected final cx o() {
        ArrayList arrayList = new ArrayList();
        q(arrayList);
        return new am(arrayList);
    }

    protected void q(List list) {
        list.add(new bj());
        list.add(new f(new m(this), new com.google.android.libraries.navigation.internal.mt.a()));
    }
}
