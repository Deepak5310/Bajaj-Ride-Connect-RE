package com.google.android.libraries.navigation.internal.cn;

import com.google.android.libraries.navigation.internal.adr.bm;
import com.google.android.libraries.navigation.internal.cl.bd;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i extends w {
    public ev a;
    public ev b;
    public ev c;
    public int d;
    public bd e;
    public String f;
    public bm.a g;
    public byte h;

    @Override // com.google.android.libraries.navigation.internal.cn.w
    public final void a(List list) {
        this.b = ev.o(list);
    }

    @Override // com.google.android.libraries.navigation.internal.cn.w
    public final void b(List list) {
        this.c = ev.o(list);
    }

    @Override // com.google.android.libraries.navigation.internal.cn.w
    public final void c(ev evVar) {
        Objects.requireNonNull(evVar);
        this.a = evVar;
    }

    @Override // com.google.android.libraries.navigation.internal.cn.w
    public final void d(int i) {
        this.d = i;
        this.h = (byte) 1;
    }
}
