package com.google.android.libraries.navigation.internal.mx;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.libraries.navigation.internal.ms.co;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f extends g {
    private final int a;

    @SafeVarargs
    public f(int i, m... mVarArr) {
        super(mVarArr);
        this.a = i;
    }

    @Override // com.google.android.libraries.navigation.internal.mx.g
    public final View a(co coVar, int i, Integer num, ViewGroup viewGroup, boolean z) {
        return coVar.b(this.a, num, viewGroup, z);
    }

    @Override // com.google.android.libraries.navigation.internal.mx.g
    public final int b() {
        return this.a;
    }
}
