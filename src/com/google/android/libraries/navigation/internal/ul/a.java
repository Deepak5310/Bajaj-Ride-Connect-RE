package com.google.android.libraries.navigation.internal.ul;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.libraries.geo.navcore.ui.header.views.f;
import com.google.android.libraries.navigation.internal.f.b;
import com.google.android.libraries.navigation.internal.gw.o;
import com.google.android.libraries.navigation.internal.gw.z;
import com.google.android.libraries.navigation.internal.um.c;
import com.google.android.libraries.navigation.internal.um.d;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static d.a a(Context context) {
        Resources resources = context.getResources();
        return b(context, resources.getColor(b.F), resources.getColor(b.m), resources.getColor(b.F), resources.getColor(b.F), resources.getColor(b.x), resources.getColor(b.F));
    }

    public static d.a b(Context context, int i, int i2, int i3, int i4, int i5, int i6) {
        Resources resources = context.getResources();
        int i7 = f.a;
        int iE = com.google.android.libraries.navigation.internal.nc.a.g(32).e(context);
        int iE2 = com.google.android.libraries.navigation.internal.nc.a.g(6).e(context);
        c cVar = new c(i, i2, i3, iE, iE2);
        c cVar2 = new c(i4, i5, i6, iE, iE2);
        c cVar3 = new c(resources.getColor(b.F), resources.getColor(b.z), resources.getColor(b.F), iE, iE2);
        return new d.a(cVar, cVar2, cVar3, cVar3);
    }

    public static d c(Context context, z zVar, o oVar) {
        return new d(zVar, oVar, com.google.android.libraries.navigation.internal.nc.a.f(168.0500030517578d).e(context), com.google.android.libraries.navigation.internal.nc.a.f(1.3333333730697632d).e(context), com.google.android.libraries.navigation.internal.nc.a.f(6.0d).e(context));
    }
}
