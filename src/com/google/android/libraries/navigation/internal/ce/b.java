package com.google.android.libraries.navigation.internal.ce;

import android.view.View;
import com.google.android.libraries.navigation.internal.ms.ck;
import com.google.android.libraries.navigation.internal.ms.cs;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b implements View.OnClickListener {
    final /* synthetic */ Object a;
    final /* synthetic */ ck b;
    final /* synthetic */ c c;

    public b(c cVar, Object obj, ck ckVar) {
        this.a = obj;
        this.b = ckVar;
        this.c = cVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.google.android.libraries.navigation.internal.jw.e.e(com.google.android.libraries.navigation.internal.jx.a.I_AM_THE_FRAMEWORK, view, com.google.android.libraries.navigation.internal.jw.e.h(this.c.b, view));
        Object obj = this.a;
        boolean z = true;
        if (obj instanceof View.OnClickListener) {
            if (this.b.j != null) {
                ((View.OnClickListener) obj).onClick(view);
            }
        } else if (!(obj instanceof cs.b)) {
            z = false;
        } else if (this.b.j != null) {
            ((cs.b) obj).a();
        }
        com.google.android.libraries.navigation.internal.jw.e.e(com.google.android.libraries.navigation.internal.jx.a.I_AM_THE_FRAMEWORK, view, null);
        if (!z) {
            throw new RuntimeException("Can't apply method to an unsupported type. Unexpected type: ".concat(this.a.toString()));
        }
    }
}
