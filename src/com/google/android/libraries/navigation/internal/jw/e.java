package com.google.android.libraries.navigation.internal.jw;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.CompoundButton;
import com.bajajconnect.rideapp.R;
import com.google.android.apps.gmm.base.logging.ToggleLoggingLayouts$ToggleLoggingFrameLayout;
import com.google.android.apps.gmm.base.logging.ToggleLoggingLayouts$ToggleLoggingLinearLayout;
import com.google.android.apps.gmm.base.logging.ToggleLoggingLayouts$ToggleLoggingRelativeLayout;
import com.google.android.libraries.navigation.internal.jy.aa;
import com.google.android.libraries.navigation.internal.jy.o;
import com.google.android.libraries.navigation.internal.jy.p;
import com.google.android.libraries.navigation.internal.jy.r;
import com.google.android.libraries.navigation.internal.jy.x;
import com.google.android.libraries.navigation.internal.yx.am;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.zt.af;
import com.google.android.libraries.navigation.internal.zt.ag;
import com.google.android.libraries.navigation.internal.zt.ao;
import com.google.android.libraries.navigation.internal.zt.ap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e {
    public static final int a = com.google.android.libraries.navigation.internal.f.e.l;
    public static final int b = com.google.android.libraries.navigation.internal.f.e.i;
    static final int c = R.animator.design_appbar_state_list_animator;
    public static final int d = com.google.android.libraries.navigation.internal.f.e.j;

    public static o a(View view) {
        return (o) view.getTag(b);
    }

    public static r b(View view) {
        return (r) view.getTag(c);
    }

    public static aa c(View view) {
        aa aaVar = (aa) view.getTag(a);
        if (aaVar == null) {
            return null;
        }
        Integer num = (Integer) view.getTag(com.google.android.libraries.navigation.internal.f.e.c);
        for (ViewParent parent = view.getParent(); parent != null && num == null; parent = parent.getParent()) {
            if (parent instanceof View) {
                num = (Integer) ((View) parent).getTag(com.google.android.libraries.navigation.internal.f.e.c);
            }
        }
        if (num == null) {
            return aaVar;
        }
        af afVar = aaVar.h() == null ? (af) ag.a.q() : (af) ag.a.r(aaVar.h());
        x xVarB = aa.b(aaVar);
        com.google.android.libraries.navigation.internal.zt.g gVar = (com.google.android.libraries.navigation.internal.zt.g) com.google.android.libraries.navigation.internal.zt.h.a.q();
        int iIntValue = num.intValue();
        if (!gVar.b.H()) {
            gVar.v();
        }
        com.google.android.libraries.navigation.internal.zt.h hVar = (com.google.android.libraries.navigation.internal.zt.h) gVar.b;
        hVar.b |= 1;
        hVar.c = iIntValue;
        com.google.android.libraries.navigation.internal.zt.h hVar2 = (com.google.android.libraries.navigation.internal.zt.h) gVar.t();
        if (!afVar.b.H()) {
            afVar.v();
        }
        ag agVar = (ag) afVar.b;
        hVar2.getClass();
        agVar.h = hVar2;
        agVar.c |= Integer.MIN_VALUE;
        xVarB.i((ag) afVar.t());
        return xVarB.b();
    }

    public static void d(View view, o oVar) {
        view.setTag(b, oVar);
    }

    public static void e(com.google.android.libraries.navigation.internal.jx.a aVar, View view, p pVar) {
        ar.q(aVar);
        view.setTag(d, pVar);
    }

    public static void f(View view, aa aaVar) {
        if (am.a(aaVar, aa.c)) {
            return;
        }
        view.setTag(a, aaVar);
    }

    public static aa g(aa aaVar, com.google.android.libraries.navigation.internal.afd.a aVar) {
        ar.q(aVar);
        if (aaVar == null) {
            return null;
        }
        x xVarB = aa.b(aaVar);
        xVarB.i = aVar;
        return xVarB.b();
    }

    @Deprecated
    public static p h(com.google.android.libraries.navigation.internal.jy.af afVar, View view) {
        aa aaVarC = c(view);
        if (am.a(aaVarC, aa.c)) {
            return p.a;
        }
        if (aaVarC == null) {
            return p.a;
        }
        an anVarI = ((view instanceof ToggleLoggingLayouts$ToggleLoggingRelativeLayout) || (view instanceof ToggleLoggingLayouts$ToggleLoggingLinearLayout) || (view instanceof ToggleLoggingLayouts$ToggleLoggingFrameLayout)) ? i(view, 2) : com.google.android.libraries.navigation.internal.yx.a.a;
        if (anVarI.g()) {
            boolean zBooleanValue = ((Boolean) anVarI.c()).booleanValue();
            x xVarB = aa.b(aaVarC);
            com.google.android.libraries.navigation.internal.zt.am amVar = (com.google.android.libraries.navigation.internal.zt.am) ap.a.q();
            int i = zBooleanValue ? ao.b : ao.c;
            if (!amVar.b.H()) {
                amVar.v();
            }
            ap apVar = (ap) amVar.b;
            int i2 = i - 1;
            if (i == 0) {
                throw null;
            }
            apVar.c = i2;
            apVar.b |= 1;
            xVarB.a = (ap) amVar.t();
            aaVarC = xVarB.b();
        }
        o oVarA = a(view);
        if (oVarA == null) {
            oVarA = o.a;
        }
        return afVar.c(oVarA, aaVarC);
    }

    private static an i(View view, int i) {
        if (view instanceof CompoundButton) {
            return an.j(Boolean.valueOf(((CompoundButton) view).isChecked()));
        }
        int i2 = i - 1;
        if (i2 >= 0 && (view instanceof ViewGroup)) {
            int i3 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i3 >= viewGroup.getChildCount()) {
                    break;
                }
                an anVarI = i(viewGroup.getChildAt(i3), i2);
                if (anVarI.g()) {
                    return anVarI;
                }
                i3++;
            }
        }
        return com.google.android.libraries.navigation.internal.yx.a.a;
    }
}
