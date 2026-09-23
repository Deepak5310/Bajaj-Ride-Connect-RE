package com.google.android.libraries.navigation.internal.ae;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.google.android.libraries.navigation.internal.nc.ah;
import com.google.android.libraries.navigation.internal.nc.aj;
import com.google.android.libraries.navigation.internal.nc.am;
import com.google.android.libraries.navigation.internal.nc.ap;
import com.google.android.libraries.navigation.internal.nc.x;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static ah a(ah ahVar, float f, x xVar) {
        ah[] ahVarArr = {aj.a(xVar), aj.d(ahVar, f)};
        return new am(ahVarArr, ahVarArr);
    }

    public static ah b(final x xVar, final ap apVar) {
        return new ah(new Object[]{xVar, apVar}) { // from class: com.google.android.libraries.navigation.internal.ae.b.1
            @Override // com.google.android.libraries.navigation.internal.nc.ah
            public final Drawable a(Context context) {
                int iB = xVar.b(context);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(apVar.e(context));
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(iB);
                return gradientDrawable;
            }
        };
    }

    public static ah c(final x xVar, final x xVar2, final ap apVar, final ap apVar2) {
        return new ah(new Object[]{xVar, xVar2, apVar, apVar2}) { // from class: com.google.android.libraries.navigation.internal.ae.b.2
            @Override // com.google.android.libraries.navigation.internal.nc.ah
            public final Drawable a(Context context) {
                int iB = xVar.b(context);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(apVar2.e(context));
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(iB);
                gradientDrawable.setStroke(apVar.e(context), xVar2.b(context));
                return gradientDrawable;
            }
        };
    }

    public static ah d(int i) {
        com.google.android.libraries.navigation.internal.gw.x xVar = com.google.android.libraries.navigation.internal.gw.x.c;
        return new a(new Object[]{Integer.valueOf(i), xVar}, i, xVar);
    }

    public static ah e(final x xVar, final x xVar2, final ap apVar, ap apVar2) {
        final ap[] apVarArr = {apVar2, apVar2, com.google.android.libraries.navigation.internal.nc.a.g(0), com.google.android.libraries.navigation.internal.nc.a.g(0)};
        return new ah(new Object[]{xVar, xVar2, apVar, apVarArr}) { // from class: com.google.android.libraries.navigation.internal.ae.b.3
            @Override // com.google.android.libraries.navigation.internal.nc.ah
            public final Drawable a(Context context) {
                int iB = xVar.b(context);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadii(new float[]{apVarArr[0].e(context), apVarArr[0].e(context), apVarArr[1].e(context), apVarArr[1].e(context), apVarArr[2].e(context), apVarArr[2].e(context), apVarArr[3].e(context), apVarArr[3].e(context)});
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(iB);
                gradientDrawable.setStroke(apVar.e(context), xVar2.b(context));
                return gradientDrawable;
            }
        };
    }
}
