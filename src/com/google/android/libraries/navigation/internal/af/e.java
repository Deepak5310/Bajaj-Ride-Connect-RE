package com.google.android.libraries.navigation.internal.af;

import android.app.Application;
import android.content.Context;
import android.util.TypedValue;
import com.google.android.libraries.navigation.internal.ed.f;
import com.google.android.libraries.navigation.internal.ed.g;
import com.google.android.libraries.navigation.internal.nc.ah;
import com.google.android.libraries.navigation.internal.nc.j;
import com.google.android.libraries.navigation.internal.nc.x;
import com.google.android.libraries.navigation.internal.yx.aa;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.zb.h;
import java.lang.ref.WeakReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e {
    public static final e a = new e();

    private e() {
    }

    @JvmStatic
    public static final a a(int i, int i2) {
        x xVarF = j.f(i);
        Intrinsics.checkNotNullExpressionValue(xVarF, "color(...)");
        x xVarF2 = j.f(i2);
        Intrinsics.checkNotNullExpressionValue(xVarF2, "color(...)");
        return b(xVarF, xVarF2);
    }

    @JvmStatic
    public static final a b(x dayValue, x nightValue) {
        Intrinsics.checkNotNullParameter(dayValue, "dayValue");
        Intrinsics.checkNotNullParameter(nightValue, "nightValue");
        return new a(dayValue, nightValue);
    }

    @JvmStatic
    public static final b c(int i, int i2) {
        ah ahVarG = j.g(i);
        Intrinsics.checkNotNullExpressionValue(ahVarG, "drawable(...)");
        ah ahVarG2 = j.g(i2);
        Intrinsics.checkNotNullExpressionValue(ahVarG2, "drawable(...)");
        return d(ahVarG, ahVarG2);
    }

    @JvmStatic
    public static final b d(ah dayValue, ah nightValue) {
        Intrinsics.checkNotNullParameter(dayValue, "dayValue");
        Intrinsics.checkNotNullParameter(nightValue, "nightValue");
        return new b(dayValue, nightValue);
    }

    @JvmStatic
    public static final boolean e(Context context) {
        an anVarI;
        Intrinsics.checkNotNullParameter(context, "context");
        TypedValue typedValue = new TypedValue();
        int iOrdinal = (context.getTheme().resolveAttribute(com.google.android.libraries.navigation.internal.f.a.a, typedValue, true) ? d.values()[typedValue.data] : d.OFF).ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return true;
            }
            if (iOrdinal == 2) {
                return false;
            }
            throw new NoWhenBranchMatchedException();
        }
        WeakReference weakReference = (WeakReference) com.google.android.libraries.navigation.internal.ed.e.a.get(context);
        com.google.android.libraries.navigation.internal.ed.b bVar = null;
        com.google.android.libraries.navigation.internal.ed.b bVar2 = weakReference != null ? (com.google.android.libraries.navigation.internal.ed.b) weakReference.get() : null;
        if (bVar2 == null) {
            if (context instanceof Application) {
                ((h) ((h) com.google.android.libraries.navigation.internal.zb.j.b.h(com.google.android.libraries.navigation.internal.zb.an.MEDIUM)).F(437)).p("NightModeIndicator queried from the Application context instead of activity");
            } else {
                bVar = (com.google.android.libraries.navigation.internal.ed.b) com.google.android.libraries.navigation.internal.ii.a.a(f.class, context).b(new aa() { // from class: com.google.android.libraries.navigation.internal.ed.c
                    @Override // com.google.android.libraries.navigation.internal.yx.aa
                    public final Object ak(Object obj) {
                        return ((f) obj).a();
                    }
                }).f();
            }
            if (bVar != null) {
                com.google.android.libraries.navigation.internal.ed.e.a.put(context, new WeakReference(bVar));
            }
            bVar2 = bVar;
        }
        if (bVar2 == null) {
            try {
                anVarI = an.i(com.google.android.libraries.navigation.internal.ii.b.a.a(g.class));
            } catch (ClassCastException unused) {
                anVarI = com.google.android.libraries.navigation.internal.yx.a.a;
            }
            bVar2 = (com.google.android.libraries.navigation.internal.ed.b) anVarI.b(new aa() { // from class: com.google.android.libraries.navigation.internal.ed.d
                @Override // com.google.android.libraries.navigation.internal.yx.aa
                public final Object ak(Object obj) {
                    return ((g) obj).c();
                }
            }).f();
        }
        if (bVar2 != null && bVar2.c()) {
            return true;
        }
        com.google.android.libraries.navigation.internal.cj.b.a(context);
        return false;
    }

    public static final Object f(c nightAwareValue, Context context) {
        Intrinsics.checkNotNullParameter(nightAwareValue, "nightAwareValue");
        Intrinsics.checkNotNullParameter(context, "context");
        return e(context) ? nightAwareValue.e() : nightAwareValue.d();
    }
}
