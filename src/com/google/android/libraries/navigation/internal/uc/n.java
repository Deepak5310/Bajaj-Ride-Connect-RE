package com.google.android.libraries.navigation.internal.uc;

import com.google.android.libraries.navigation.internal.afl.ff;
import com.google.android.libraries.navigation.internal.zs.aq;
import com.google.android.libraries.navigation.internal.zs.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class n {
    public static final n b;

    static {
        m mVarE = e();
        mVarE.b(ar.UNKNOWN_MODE);
        mVarE.d(aq.UNKNOWN_CAMERA_TYPE);
        mVarE.c(ff.UNKNOWN_VIEW_MODE);
        mVarE.e(new com.google.android.libraries.navigation.internal.pd.f().a());
        b = mVarE.a();
    }

    public static m e() {
        c cVar = new c();
        cVar.b(ar.UNKNOWN_MODE);
        cVar.d(aq.UNKNOWN_CAMERA_TYPE);
        cVar.c(ff.UNKNOWN_VIEW_MODE);
        cVar.e(new com.google.android.libraries.navigation.internal.pd.f().a());
        return cVar;
    }

    public abstract com.google.android.libraries.navigation.internal.pd.i a();

    public abstract aq b();

    public abstract ar c();

    public abstract ff d();
}
