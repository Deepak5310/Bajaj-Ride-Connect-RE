package com.google.android.libraries.navigation.internal.mx;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.libraries.navigation.internal.ms.co;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends g {
    public final Class a;

    @SafeVarargs
    public e(Class cls, m... mVarArr) {
        super(mVarArr);
        this.a = cls;
    }

    @Override // com.google.android.libraries.navigation.internal.mx.g
    public final View a(co coVar, int i, Integer num, ViewGroup viewGroup, boolean z) {
        return coVar.d(this.a, i, num, viewGroup, z);
    }
}
