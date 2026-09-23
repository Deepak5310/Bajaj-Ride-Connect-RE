package com.google.android.libraries.navigation.internal.ms;

import android.view.View;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bj extends a {
    @Override // com.google.android.libraries.navigation.internal.ms.a, com.google.android.libraries.navigation.internal.ms.cx
    public final boolean a(cw cwVar, Object obj, ck ckVar) {
        boolean z = false;
        if (cwVar instanceof e) {
            View view = ckVar.c;
            if (view instanceof bk) {
                if (((e) cwVar).ordinal() == 213 && (obj instanceof Boolean)) {
                    z = true;
                    if (!((Boolean) obj).booleanValue()) {
                        bk.c(ckVar);
                    }
                }
            }
        }
        return z;
    }
}
