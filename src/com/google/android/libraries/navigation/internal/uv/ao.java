package com.google.android.libraries.navigation.internal.uv;

import android.widget.FrameLayout;
import com.google.android.libraries.navigation.internal.ms.bt;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.ms.dd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ao extends bt<com.google.android.libraries.navigation.internal.ux.d> implements com.google.android.libraries.navigation.internal.yt.e {
    private static final com.google.android.libraries.navigation.internal.xn.a a = com.google.android.libraries.navigation.internal.xn.a.d("SpeedLimitContainerLayout");

    @Override // com.google.android.libraries.navigation.internal.ms.bt
    protected final com.google.android.libraries.navigation.internal.mx.g a() {
        return new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.v(false), com.google.android.libraries.navigation.internal.ms.ah.c(new am(), new dd() { // from class: com.google.android.libraries.navigation.internal.uv.an
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.ux.d) csVar).a();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.m[0]));
    }

    @Override // com.google.android.libraries.navigation.internal.yt.e
    public final com.google.android.libraries.navigation.internal.xn.a b() {
        return a;
    }
}
