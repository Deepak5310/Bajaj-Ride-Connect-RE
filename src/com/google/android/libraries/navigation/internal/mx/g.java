package com.google.android.libraries.navigation.internal.mx;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.libraries.navigation.internal.ms.cc;
import com.google.android.libraries.navigation.internal.ms.co;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class g extends i {
    private cc a;

    @SafeVarargs
    public g(m... mVarArr) {
        super(mVarArr);
    }

    public abstract View a(co coVar, int i, Integer num, ViewGroup viewGroup, boolean z);

    public int b() {
        return 0;
    }

    protected cc c() {
        return new cc();
    }

    public final cc d() {
        cc ccVarG = i.g(this.c, this.d);
        if (ccVarG != null) {
            return ccVarG;
        }
        if (this.a == null) {
            this.a = c();
        }
        return this.a;
    }

    @SafeVarargs
    public final void e(m... mVarArr) {
        super.h(mVarArr);
    }

    public final void f(m mVar) {
        super.i(mVar);
    }
}
