package com.google.android.libraries.navigation.internal.ce;

import android.view.View;
import com.google.android.libraries.navigation.internal.jy.af;
import com.google.android.libraries.navigation.internal.ms.bq;
import com.google.android.libraries.navigation.internal.ms.ck;
import com.google.android.libraries.navigation.internal.ms.cn;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    static final bq a = new bq();
    public final af b;
    public final com.google.android.libraries.navigation.internal.iv.f c;

    public c(af afVar, com.google.android.libraries.navigation.internal.iv.f fVar) {
        this.b = afVar;
        this.c = fVar;
    }

    public final void a(Object obj, View view, ck ckVar) {
        cn.a(view).b(a, obj == null ? null : new b(this, obj, ckVar));
    }
}
