package com.google.android.libraries.navigation.internal.dx;

import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.libraries.navigation.internal.ace.mu;
import com.google.android.libraries.navigation.internal.ace.nx;
import com.google.android.libraries.navigation.internal.adr.Cdo;
import com.google.android.libraries.navigation.internal.nc.ae;
import com.google.android.libraries.navigation.internal.nc.x;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j extends i {
    private static final x d = ae.d(14431790);
    private static final x e = ae.d(16759593);
    private static final x f = ae.d(1797875);
    private static final x g = ae.d(14148847);
    private final o h;

    public j(a aVar, o oVar, com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.bn.d dVar2) {
        super(aVar, oVar, dVar, dVar2);
        this.h = oVar;
    }

    @Override // com.google.android.libraries.navigation.internal.dx.i
    public final x a(mu muVar) {
        int iOrdinal = muVar.ordinal();
        if (iOrdinal == 1) {
            return d;
        }
        if (iOrdinal != 3) {
            return iOrdinal != 4 ? e : g;
        }
        return f;
    }

    @Override // com.google.android.libraries.navigation.internal.dx.i
    public final x b(nx nxVar) {
        int iOrdinal = nxVar.ordinal();
        if (iOrdinal != 1) {
            return iOrdinal != 3 ? e : f;
        }
        return d;
    }

    @Override // com.google.android.libraries.navigation.internal.dx.i
    public final x c(mu muVar) {
        int iOrdinal = muVar.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    if (iOrdinal != 3) {
                        if (iOrdinal != 4) {
                            return com.google.android.libraries.navigation.internal.w.a.b();
                        }
                    }
                }
            }
            return com.google.android.libraries.navigation.internal.w.a.r();
        }
        return com.google.android.libraries.navigation.internal.w.a.b();
    }

    @Override // com.google.android.libraries.navigation.internal.dx.i
    public final x d(nx nxVar) {
        int iOrdinal = nxVar.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    if (iOrdinal != 3) {
                        return com.google.android.libraries.navigation.internal.w.a.b();
                    }
                }
            }
            return com.google.android.libraries.navigation.internal.w.a.r();
        }
        return com.google.android.libraries.navigation.internal.w.a.b();
    }

    @Override // com.google.android.libraries.navigation.internal.dx.i
    public final CharSequence k(Resources resources) {
        return resources.getText(com.google.android.libraries.navigation.internal.dw.h.an);
    }

    @Override // com.google.android.libraries.navigation.internal.dx.i
    public final CharSequence l(Resources resources) {
        return resources.getText(com.google.android.libraries.navigation.internal.dw.h.al);
    }

    @Override // com.google.android.libraries.navigation.internal.dx.i
    public final CharSequence m(Resources resources) {
        return resources.getText(com.google.android.libraries.navigation.internal.dw.h.ac);
    }

    @Override // com.google.android.libraries.navigation.internal.dx.i
    public final CharSequence n(Resources resources, com.google.android.libraries.navigation.internal.tt.d dVar) {
        Cdo cdoM = dVar.m();
        String strW = dVar.w();
        if (TextUtils.isEmpty(strW) || !(cdoM == Cdo.INCIDENT_POLICE_PRESENCE || cdoM == Cdo.INCIDENT_MOBILE_SPEED_CAMERA)) {
            return !dVar.L().isEmpty() ? resources.getText(com.google.android.libraries.navigation.internal.dw.h.ab) : resources.getText(com.google.android.libraries.navigation.internal.dw.h.aa);
        }
        return strW;
    }

    @Override // com.google.android.libraries.navigation.internal.dx.i
    public final CharSequence o(Resources resources) {
        return resources.getText(com.google.android.libraries.navigation.internal.dw.h.ak);
    }
}
