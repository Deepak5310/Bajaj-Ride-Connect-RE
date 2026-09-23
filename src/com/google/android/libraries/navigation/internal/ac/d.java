package com.google.android.libraries.navigation.internal.ac;

import android.view.View;
import com.google.android.libraries.navigation.internal.jy.aa;
import com.google.android.libraries.navigation.internal.jy.o;
import com.google.android.libraries.navigation.internal.jy.p;
import com.google.android.libraries.navigation.internal.jy.v;
import com.google.android.libraries.navigation.internal.zt.as;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d implements View.OnLongClickListener {
    final /* synthetic */ View a;
    final /* synthetic */ Object b;
    final /* synthetic */ f c;

    public d(f fVar, View view, Object obj) {
        this.a = view;
        this.b = obj;
        this.c = fVar;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        boolean z;
        aa aaVarC = com.google.android.libraries.navigation.internal.jw.e.c(view);
        p pVarD = p.a;
        if (aaVarC != null && !aaVarC.equals(aa.c)) {
            o oVarA = com.google.android.libraries.navigation.internal.jw.e.a(view);
            if (oVarA != null) {
                f fVar = this.c;
                pVarD = fVar.b.d(oVarA, new v(as.LONG_PRESS), aaVarC);
            } else {
                pVarD = p.a;
            }
        }
        com.google.android.libraries.navigation.internal.jw.e.e(com.google.android.libraries.navigation.internal.jx.a.I_AM_THE_FRAMEWORK, this.a, pVarD);
        Object obj = this.b;
        if (obj instanceof View.OnLongClickListener) {
            ((View.OnLongClickListener) obj).onLongClick(view);
            z = true;
        } else {
            z = false;
        }
        com.google.android.libraries.navigation.internal.jw.e.e(com.google.android.libraries.navigation.internal.jx.a.I_AM_THE_FRAMEWORK, this.a, null);
        return z;
    }
}
