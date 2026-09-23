package com.google.android.libraries.navigation.internal.bh;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.libraries.navigation.internal.dw.i;
import com.google.android.libraries.navigation.internal.ms.ah;
import com.google.android.libraries.navigation.internal.ms.bt;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.ms.dd;
import com.google.android.libraries.navigation.internal.mx.e;
import com.google.android.libraries.navigation.internal.mx.g;
import com.google.android.libraries.navigation.internal.mx.k;
import com.google.android.libraries.navigation.internal.mx.m;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends bt<com.google.android.libraries.navigation.internal.cb.b> {
    private final boolean a;

    public c() {
        this(false);
    }

    @Override // com.google.android.libraries.navigation.internal.ms.bt
    public final g a() {
        m[] mVarArr = new m[6];
        mVarArr[0] = ah.T(-2);
        mVarArr[1] = ah.ag(-2);
        mVarArr[2] = ah.ab(com.google.android.libraries.navigation.internal.w.c.j());
        mVarArr[3] = ah.I(16);
        mVarArr[4] = new e(ImageView.class, ah.f(com.google.android.libraries.navigation.internal.nc.a.g(14)), ah.X(com.google.android.libraries.navigation.internal.nc.a.g(4)), ah.aI(new dd() { // from class: com.google.android.libraries.navigation.internal.bh.a
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.cb.b) csVar).a();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }));
        m[] mVarArr2 = new m[5];
        mVarArr2[0] = ah.T(-2);
        mVarArr2[1] = ah.ag(-2);
        mVarArr2[2] = new k(new m[]{ah.aP(Integer.valueOf(i.b)), ah.aR(com.google.android.libraries.navigation.internal.w.b.e())});
        mVarArr2[3] = this.a ? com.google.android.libraries.navigation.internal.w.e.f() : m.e;
        mVarArr2[4] = ah.aM(new dd() { // from class: com.google.android.libraries.navigation.internal.bh.b
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.cb.b) csVar).b();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        });
        mVarArr[5] = new e(TextView.class, mVarArr2);
        return new e(LinearLayout.class, mVarArr);
    }

    public c(boolean z) {
        super(Boolean.valueOf(z));
        this.a = z;
    }
}
