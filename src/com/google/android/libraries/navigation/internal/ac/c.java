package com.google.android.libraries.navigation.internal.ac;

import android.view.View;
import com.google.android.libraries.navigation.internal.jy.af;
import com.google.android.libraries.navigation.internal.ms.ck;
import com.google.android.libraries.navigation.internal.ms.cs;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c implements View.OnClickListener {
    final /* synthetic */ View a;
    final /* synthetic */ Object b;
    final /* synthetic */ ck c;
    final /* synthetic */ f d;

    public c(f fVar, View view, Object obj, ck ckVar) {
        this.a = view;
        this.b = obj;
        this.c = ckVar;
        this.d = fVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        af afVar = this.d.b;
        com.google.android.libraries.navigation.internal.jw.e.e(com.google.android.libraries.navigation.internal.jx.a.I_AM_THE_FRAMEWORK, this.a, com.google.android.libraries.navigation.internal.jw.e.h(afVar, view));
        Object obj = this.b;
        boolean z = true;
        if (obj instanceof View.OnClickListener) {
            if (this.c.j != null) {
                ((View.OnClickListener) obj).onClick(view);
            }
        } else if (!(obj instanceof cs.b)) {
            z = false;
        } else if (this.c.j != null) {
            ((cs.b) obj).a();
        }
        com.google.android.libraries.navigation.internal.jw.e.e(com.google.android.libraries.navigation.internal.jx.a.I_AM_THE_FRAMEWORK, this.a, null);
        if (!z) {
            throw new RuntimeException("Can't apply method to an unsupported type.");
        }
    }
}
