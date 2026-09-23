package com.google.android.libraries.navigation.internal.bg;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.libraries.navigation.internal.ms.ah;
import com.google.android.libraries.navigation.internal.ms.bt;
import com.google.android.libraries.navigation.internal.ms.cg;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.ms.dd;
import com.google.android.libraries.navigation.internal.mx.m;
import com.google.android.libraries.navigation.internal.va.b;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class l<T extends com.google.android.libraries.navigation.internal.va.b> extends bt<T> {
    public static final /* synthetic */ int a = 0;

    protected static final com.google.android.libraries.navigation.internal.mx.g m(boolean z) {
        dd ddVar = new dd() { // from class: com.google.android.libraries.navigation.internal.bg.j
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.va.b) csVar).h();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        };
        dd ddVar2 = new dd() { // from class: com.google.android.libraries.navigation.internal.bg.k
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.va.b) csVar).g();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        };
        m[] mVarArr = new m[7];
        mVarArr[0] = ah.ag(-1);
        mVarArr[1] = ah.R(new dd() { // from class: com.google.android.libraries.navigation.internal.bg.g
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                ((com.google.android.libraries.navigation.internal.va.b) csVar).m();
                return -2;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        });
        mVarArr[2] = ah.aq(0);
        mVarArr[3] = ah.ay(z ? com.google.android.libraries.navigation.internal.w.c.c() : com.google.android.libraries.navigation.internal.w.c.f());
        mVarArr[4] = ah.r(new dd() { // from class: com.google.android.libraries.navigation.internal.bg.h
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                int i = l.a;
                ((com.google.android.libraries.navigation.internal.va.b) csVar).n();
                return com.google.android.libraries.navigation.internal.af.e.b(com.google.android.libraries.navigation.internal.w.a.q(), com.google.android.libraries.navigation.internal.w.a.q());
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        });
        mVarArr[5] = new com.google.android.libraries.navigation.internal.mx.e(TextView.class, ah.I(16), ah.M(false), ah.aw(com.google.android.libraries.navigation.internal.w.c.e()), ah.aj(1), com.google.android.libraries.navigation.internal.w.e.c(), ah.aQ(new dd() { // from class: com.google.android.libraries.navigation.internal.bg.i
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                int i = l.a;
                ((com.google.android.libraries.navigation.internal.va.b) csVar).n();
                return com.google.android.libraries.navigation.internal.w.b.e();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), ah.G(new cg(ddVar)), ah.aM(ddVar), ah.z(ddVar2));
        m[] mVarArr2 = {ah.Q(16)};
        com.google.android.libraries.navigation.internal.mx.e eVar = new com.google.android.libraries.navigation.internal.mx.e(View.class, ah.s(com.google.android.libraries.navigation.internal.w.b.c()), ah.S(com.google.android.libraries.navigation.internal.nc.a.g(1)), ah.ag(-1), ah.ab(com.google.android.libraries.navigation.internal.nc.a.g(0)), ah.V(com.google.android.libraries.navigation.internal.nc.a.g(0)));
        eVar.e(mVarArr2);
        mVarArr[6] = eVar;
        return new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, mVarArr);
    }

    @Override // com.google.android.libraries.navigation.internal.ms.bt
    protected com.google.android.libraries.navigation.internal.mx.g a() {
        return m(false);
    }
}
