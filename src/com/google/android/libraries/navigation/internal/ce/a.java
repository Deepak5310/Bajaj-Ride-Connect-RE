package com.google.android.libraries.navigation.internal.ce;

import android.view.View;
import com.google.android.libraries.navigation.internal.ms.ck;
import com.google.android.libraries.navigation.internal.ms.cw;
import com.google.android.libraries.navigation.internal.ms.cx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements cx {
    final c a;

    public a(c cVar) {
        this.a = cVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.cx
    public final boolean a(cw cwVar, Object obj, ck ckVar) {
        if (!(cwVar instanceof com.google.android.libraries.navigation.internal.ms.e) || ((com.google.android.libraries.navigation.internal.ms.e) cwVar).ordinal() != 140) {
            return false;
        }
        View view = ckVar.c;
        if (!(view instanceof View)) {
            return false;
        }
        this.a.a(obj, view, ckVar);
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.cx
    public final boolean b(cw cwVar, ck ckVar) {
        if (!(cwVar instanceof com.google.android.libraries.navigation.internal.ms.e) || ((com.google.android.libraries.navigation.internal.ms.e) cwVar).ordinal() != 140) {
            return false;
        }
        View view = ckVar.c;
        if (!(view instanceof View)) {
            return false;
        }
        this.a.a(null, view, ckVar);
        return true;
    }
}
