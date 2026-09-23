package com.google.android.libraries.navigation.internal.mw;

import android.view.View;
import com.google.android.libraries.navigation.internal.ms.ck;
import com.google.android.libraries.navigation.internal.ms.cw;
import com.google.android.libraries.navigation.internal.ms.cx;
import com.google.android.libraries.navigation.internal.nc.ap;
import com.google.android.libraries.navigation.internal.nc.x;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements cx {
    final com.google.android.libraries.navigation.internal.mt.a a;

    public c(com.google.android.libraries.navigation.internal.mt.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.cx
    public final boolean a(cw cwVar, Object obj, ck ckVar) {
        if (!(cwVar instanceof a)) {
            return false;
        }
        View view = ckVar.c;
        int iOrdinal = ((a) cwVar).ordinal();
        if (iOrdinal == 0) {
            if (!(view instanceof com.google.android.libraries.navigation.internal.yo.a)) {
                return false;
            }
            if (obj instanceof ap) {
                this.a.d(view, (ap) obj);
                throw null;
            }
            if (obj instanceof Integer) {
                throw null;
            }
            if (obj != null) {
                return false;
            }
            this.a.w(null);
            return false;
        }
        if (iOrdinal == 1) {
            if (!(view instanceof com.google.android.libraries.navigation.internal.yo.a)) {
                return false;
            }
            if (obj instanceof x) {
                this.a.b(view, (x) obj);
                throw null;
            }
            if (obj instanceof Number) {
                ((Number) obj).intValue();
                throw null;
            }
            if (obj != null) {
                return false;
            }
            this.a.v(null);
            return false;
        }
        if (iOrdinal == 2) {
            if (!(view instanceof com.google.android.libraries.navigation.internal.yo.a)) {
                return false;
            }
            if (obj instanceof ap) {
                this.a.d(view, (ap) obj);
                throw null;
            }
            if (obj instanceof Integer) {
                throw null;
            }
            if (obj != null) {
                return false;
            }
            this.a.w(null);
            return false;
        }
        if (iOrdinal != 3 || !(view instanceof com.google.android.libraries.navigation.internal.yo.a)) {
            return false;
        }
        if (obj instanceof ap) {
            this.a.d(view, (ap) obj);
            throw null;
        }
        if (obj instanceof Integer) {
            throw null;
        }
        if (obj != null) {
            return false;
        }
        this.a.w(null);
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.cx
    public final boolean b(cw cwVar, ck ckVar) {
        return false;
    }
}
