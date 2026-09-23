package com.google.android.libraries.navigation.internal.m;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import com.google.android.libraries.navigation.internal.af.e;
import com.google.android.libraries.navigation.internal.f.d;
import com.google.android.libraries.navigation.internal.nc.ae;
import com.google.android.libraries.navigation.internal.nc.ah;
import com.google.android.libraries.navigation.internal.nc.aj;
import com.google.android.libraries.navigation.internal.nc.j;
import com.google.android.libraries.navigation.internal.nc.x;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static final c a = c.d(null, false);
    public static final c b = c.d(ae.g(), false);
    public static final c c = c.d(e.a(com.google.android.libraries.navigation.internal.f.b.G, com.google.android.libraries.navigation.internal.v.a.r), false);
    public static final ah d;
    public static final c e;

    static {
        aj.a(ae.g());
        ah ahVarG = j.g(d.j);
        d = ahVarG;
        e = c.d(ahVarG, true);
    }

    public static int a(Context context, x xVar) {
        if (xVar == null) {
            return 0;
        }
        return xVar.b(context);
    }

    @Deprecated
    public static ah b(int i, int i2, c cVar) {
        return c(i == 0 ? null : j.f(i), i2 != 0 ? j.f(i2) : null, cVar);
    }

    public static ah c(final x xVar, final x xVar2, final c cVar) {
        return new ah(new Object[]{xVar, xVar2, cVar}) { // from class: com.google.android.libraries.navigation.internal.m.b.1
            @Override // com.google.android.libraries.navigation.internal.nc.ah
            public final Drawable a(Context context) {
                Drawable drawableMutate;
                c cVar2 = cVar;
                ah ahVar = cVar2 == null ? null : ((a) cVar2).a;
                x xVar3 = xVar2;
                if (xVar3 == null) {
                    drawableMutate = null;
                } else if (ahVar == null) {
                    c cVar3 = b.a;
                    drawableMutate = new ColorDrawable(xVar3.b(context));
                } else {
                    drawableMutate = ahVar.a(context).mutate();
                    drawableMutate.setColorFilter(b.a(context, xVar2), PorterDuff.Mode.SRC_IN);
                }
                return new RippleDrawable(ColorStateList.valueOf(b.a(context, xVar)), drawableMutate, ahVar != null ? ahVar.a(context) : null);
            }
        };
    }
}
