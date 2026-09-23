package com.google.android.libraries.navigation.internal.ms;

import com.google.android.libraries.navigation.internal.yz.gs;
import com.google.android.libraries.navigation.internal.yz.lp;
import java.util.Collection;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ch {
    public static com.google.android.libraries.navigation.internal.mx.k a(dd ddVar, com.google.android.libraries.navigation.internal.mx.k kVar, com.google.android.libraries.navigation.internal.mx.k kVar2) {
        com.google.android.libraries.navigation.internal.mx.m mVarA;
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr = kVar.a;
        int length = mVarArr.length;
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr2 = kVar2.a;
        com.google.android.libraries.navigation.internal.yx.ar.b(length == mVarArr2.length, "ifThenElse was called with incompatible thenNode and elseNode: each CompoundViewProperty should have the same number of PropertyNodes.");
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr3 = (com.google.android.libraries.navigation.internal.mx.m[]) lp.a(mVarArr, length);
        for (int i = 0; i < mVarArr.length; i++) {
            com.google.android.libraries.navigation.internal.mx.m mVar = mVarArr[i];
            com.google.android.libraries.navigation.internal.mx.m mVar2 = mVarArr2[i];
            if (mVar == null && mVar2 == null) {
                mVarA = null;
            } else {
                com.google.android.libraries.navigation.internal.mx.m rVar = com.google.android.libraries.navigation.internal.mx.m.e;
                if (mVar == rVar && mVar2 == rVar) {
                    mVarA = rVar;
                } else if ((mVar instanceof com.google.android.libraries.navigation.internal.mx.w) && (mVar2 instanceof com.google.android.libraries.navigation.internal.mx.w)) {
                    rVar = new com.google.android.libraries.navigation.internal.mx.r(ddVar, (com.google.android.libraries.navigation.internal.mx.w) mVar, (com.google.android.libraries.navigation.internal.mx.w) mVar2);
                    mVarA = rVar;
                } else {
                    if (!(mVar instanceof com.google.android.libraries.navigation.internal.mx.k) || !(mVar2 instanceof com.google.android.libraries.navigation.internal.mx.k)) {
                        throw new IllegalArgumentException("ifThenElse was called with incompatible thenNode and elseNode: each PropertyNode in thenNode should be compatible with the corresponding PropertyNode in elseNode.");
                    }
                    mVarA = a(ddVar, (com.google.android.libraries.navigation.internal.mx.k) mVar, (com.google.android.libraries.navigation.internal.mx.k) mVar2);
                }
            }
            mVarArr3[i] = mVarA;
        }
        return new com.google.android.libraries.navigation.internal.mx.k(mVarArr3);
    }

    public static com.google.android.libraries.navigation.internal.mx.w b(by byVar, com.google.android.libraries.navigation.internal.mx.w wVar, com.google.android.libraries.navigation.internal.mx.w wVar2) {
        return new com.google.android.libraries.navigation.internal.mx.r(da.b(byVar), wVar, wVar2);
    }

    public static com.google.android.libraries.navigation.internal.mx.w c(cw cwVar, by byVar) {
        return new com.google.android.libraries.navigation.internal.mx.v(cwVar, byVar, a.e);
    }

    public static com.google.android.libraries.navigation.internal.mx.w d(cw cwVar, dd ddVar) {
        return new com.google.android.libraries.navigation.internal.mx.ac(cwVar, ddVar, a.e);
    }

    public static com.google.android.libraries.navigation.internal.mx.w e(cw cwVar, Object obj) {
        return f(cwVar, obj, a.e);
    }

    public static com.google.android.libraries.navigation.internal.mx.w f(cw cwVar, Object obj, cx cxVar) {
        return new com.google.android.libraries.navigation.internal.mx.t(cwVar, obj, cxVar, com.google.android.libraries.navigation.internal.nc.bi.a(obj));
    }

    public static boolean g(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length() == 0;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        if (obj instanceof Iterable) {
            return gs.h((Iterable) obj);
        }
        return false;
    }
}
