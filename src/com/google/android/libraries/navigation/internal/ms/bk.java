package com.google.android.libraries.navigation.internal.ms;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bk extends View {
    public com.google.android.libraries.navigation.internal.mx.g a;
    public boolean b;
    public com.google.android.libraries.navigation.internal.mx.j c;

    public bk(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setVisibility(8);
        setWillNotDraw(true);
    }

    @SafeVarargs
    public static com.google.android.libraries.navigation.internal.mx.y a(final dd ddVar, com.google.android.libraries.navigation.internal.mx.m... mVarArr) {
        return new com.google.android.libraries.navigation.internal.mx.y(new by() { // from class: com.google.android.libraries.navigation.internal.ms.bh
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                return (Boolean) ddVar.a(csVar);
            }
        }, mVarArr);
    }

    @SafeVarargs
    public static com.google.android.libraries.navigation.internal.mx.y b(final dd ddVar, com.google.android.libraries.navigation.internal.mx.m... mVarArr) {
        return new com.google.android.libraries.navigation.internal.mx.y(new by() { // from class: com.google.android.libraries.navigation.internal.ms.bi
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                return Boolean.valueOf(!((Boolean) ddVar.a(csVar)).booleanValue());
            }
        }, mVarArr);
    }

    public static void c(ck ckVar) {
        View view = ckVar.c;
        bb bbVarB = ckVar.g.b();
        bk bkVar = (bk) view;
        ViewGroup viewGroup = (ViewGroup) bkVar.getParent();
        int iIndexOfChild = viewGroup.indexOfChild(bkVar);
        viewGroup.removeView(bkVar);
        ck ckVarA = bbVarB.a(ckVar.f, bkVar.a, viewGroup, false, null, bkVar, bkVar.b, bkVar.c);
        viewGroup.addView(ckVarA.c, iIndexOfChild);
        cs csVar = ckVar.j;
        cq cqVarE = ckVar.e();
        ckVar.p(null);
        ckVar.r(null, 2);
        ckVarA.p(csVar);
        ckVarA.r(csVar, 2);
        if (cqVarE != null) {
            ckVar.f(null);
            cqVarE.a = ckVarA;
            ckVarA.f(cqVarE);
        }
    }

    @Override // android.view.View
    protected final void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }
}
