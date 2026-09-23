package com.google.android.libraries.navigation.internal.nc;

import android.content.Context;
import android.content.res.ColorStateList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class y {
    public static x a(x xVar, float f) {
        return b(xVar, new r(f));
    }

    public static x b(final x xVar, final ar arVar) {
        return new x(new Object[]{xVar, arVar}) { // from class: com.google.android.libraries.navigation.internal.nc.y.1
            private final int d(Context context) {
                int iB = xVar.b(context);
                return (((int) (arVar.l(context) * (iB >>> 24))) << 24) | (iB & 16777215);
            }

            @Override // com.google.android.libraries.navigation.internal.nc.x
            public final int b(Context context) {
                return d(context);
            }

            @Override // com.google.android.libraries.navigation.internal.nc.x
            public final ColorStateList c(Context context) {
                return ColorStateList.valueOf(d(context));
            }
        };
    }
}
