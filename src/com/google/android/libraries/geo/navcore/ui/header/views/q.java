package com.google.android.libraries.geo.navcore.ui.header.views;

import android.view.View;
import com.google.android.libraries.navigation.internal.ms.ck;
import com.google.android.libraries.navigation.internal.ms.cw;
import com.google.android.libraries.navigation.internal.ms.cx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class q implements cx {
    @Override // com.google.android.libraries.navigation.internal.ms.cx
    public final boolean a(cw cwVar, Object obj, ck ckVar) {
        if (!(cwVar instanceof com.google.android.libraries.navigation.internal.ad.b)) {
            return false;
        }
        View view = ckVar.c;
        int iOrdinal = ((com.google.android.libraries.navigation.internal.ad.b) cwVar).ordinal();
        if (iOrdinal == 31) {
            if (!(view instanceof SwipeableHeaderView) || !(obj instanceof Boolean)) {
                return false;
            }
            ((SwipeableHeaderView) view).r = ((Boolean) obj).booleanValue();
            return true;
        }
        if (iOrdinal != 32 || !(view instanceof SwipeableHeaderView) || !(obj instanceof Long)) {
            return false;
        }
        ((SwipeableHeaderView) view).s = ((Long) obj).longValue();
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.cx
    public final boolean b(cw cwVar, ck ckVar) {
        return false;
    }
}
