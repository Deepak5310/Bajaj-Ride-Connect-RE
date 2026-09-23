package com.google.android.libraries.navigation.internal.sx;

import com.google.android.libraries.navigation.internal.bp.bg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ao {
    public abstract ap a();

    public abstract void b(boolean z);

    public abstract void c(boolean z);

    public final ap d() {
        bg bgVarA;
        ap apVarA = a();
        if (apVarA.a() == null || apVarA.h() == null || (bgVarA = apVarA.a()) == null || bgVarA.U == null || apVarA.m() == null) {
            return apVarA;
        }
        throw new IllegalArgumentException();
    }
}
