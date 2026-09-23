package com.google.android.libraries.navigation.internal.dx;

import android.content.res.Resources;
import com.google.android.libraries.navigation.internal.ace.mu;
import com.google.android.libraries.navigation.internal.ace.nx;
import com.google.android.libraries.navigation.internal.ace.nz;
import com.google.android.libraries.navigation.internal.ace.oa;
import com.google.android.libraries.navigation.internal.adu.y;
import com.google.android.libraries.navigation.internal.nc.ah;
import com.google.android.libraries.navigation.internal.nc.x;
import com.google.android.libraries.navigation.internal.yx.as;
import com.google.android.libraries.navigation.internal.yz.de;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class i {
    public final com.google.android.libraries.navigation.internal.bn.d a;
    protected final com.google.android.libraries.navigation.internal.fz.d b;
    public final a c;
    private final o d;

    public i(a aVar, o oVar, com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.bn.d dVar2) {
        this.c = aVar;
        this.d = oVar;
        this.b = dVar;
        this.a = dVar2;
    }

    public static y j(nz nzVar) {
        switch (nzVar.ordinal()) {
            case 1:
                return y.INCIDENT_CRASH;
            case 2:
                return y.INCIDENT_FIXED_CAMERA;
            case 3:
                return y.INCIDENT_MOBILE_CAMERA;
            case 4:
                return y.INCIDENT_SUSPECTED_JAM;
            case 5:
                return y.INCIDENT_CONSTRUCTION;
            case 6:
                return y.INCIDENT_LANE_CLOSURE;
            case 7:
                return y.INCIDENT_STALLED_VEHICLE;
            case 8:
                return y.INCIDENT_OBJECT_ON_ROAD;
            case 9:
            default:
                return null;
            case 10:
                return y.INCIDENT_SUSPECTED_CLOSURE;
            case 11:
                return y.INCIDENT_POLICE_PRESENCE;
            case 12:
                return y.INCIDENT_MOBILE_SPEED_CAMERA;
        }
    }

    public abstract x a(mu muVar);

    public abstract x b(nx nxVar);

    public abstract x c(mu muVar);

    public abstract x d(nx nxVar);

    public final ah e(com.google.android.libraries.navigation.internal.vg.b bVar, mu muVar, final com.google.android.libraries.navigation.internal.bn.b bVar2) {
        final x xVarA = a(muVar);
        final x xVarC = c(muVar);
        com.google.android.libraries.navigation.internal.vg.a aVar = (com.google.android.libraries.navigation.internal.vg.a) bVar;
        ah ahVarA = com.google.android.libraries.navigation.internal.ca.d.a(aVar.a, aVar.b, this.a, new com.google.android.libraries.navigation.internal.bn.b() { // from class: com.google.android.libraries.navigation.internal.dx.h
            @Override // com.google.android.libraries.navigation.internal.bn.b
            public final void a(ah ahVar) {
                bVar2.a(this.a.f(ahVar, xVarA, xVarC));
            }
        });
        if (ahVarA == null) {
            return null;
        }
        return f(ahVarA, xVarA, xVarC);
    }

    public final ah f(ah ahVar, x xVar, x xVar2) {
        return this.d.a() ? com.google.android.libraries.navigation.internal.ae.b.a(com.google.android.libraries.navigation.internal.nc.j.j(ahVar, xVar2), 1.0f, xVar) : ahVar;
    }

    public final com.google.android.libraries.navigation.internal.vg.b g(oa oaVar) {
        if (!this.d.a()) {
            return new com.google.android.libraries.navigation.internal.vg.a(oaVar.d, oaVar.e);
        }
        String str = oaVar.f;
        return new com.google.android.libraries.navigation.internal.vg.a(str, str);
    }

    public final ev h() {
        final HashSet hashSet = new HashSet();
        return de.d(this.b.x().f()).c(new as() { // from class: com.google.android.libraries.navigation.internal.dx.d
            @Override // com.google.android.libraries.navigation.internal.yx.as
            public final boolean a(Object obj) {
                nz nzVarB = nz.b(((oa) obj).c);
                if (nzVarB == null) {
                    nzVarB = nz.UNKNOWN_USER_INCIDENT_TYPE;
                }
                return nzVarB != nz.INCIDENT_SUSPECTED_CLOSURE;
            }
        }).c(new as() { // from class: com.google.android.libraries.navigation.internal.dx.e
            @Override // com.google.android.libraries.navigation.internal.yx.as
            public final boolean a(Object obj) {
                oa oaVar = (oa) obj;
                nz nzVarB = nz.b(oaVar.c);
                if (nzVarB == null) {
                    nzVarB = nz.UNKNOWN_USER_INCIDENT_TYPE;
                }
                if (nzVarB == nz.INCIDENT_POLICE_PRESENCE) {
                    return false;
                }
                nz nzVarB2 = nz.b(oaVar.c);
                if (nzVarB2 == null) {
                    nzVarB2 = nz.UNKNOWN_USER_INCIDENT_TYPE;
                }
                return nzVarB2 != nz.INCIDENT_MOBILE_SPEED_CAMERA;
            }
        }).c(new as() { // from class: com.google.android.libraries.navigation.internal.dx.f
            @Override // com.google.android.libraries.navigation.internal.yx.as
            public final boolean a(Object obj) {
                oa oaVar = (oa) obj;
                nz nzVarB = nz.b(oaVar.c);
                if (nzVarB == null) {
                    nzVarB = nz.UNKNOWN_USER_INCIDENT_TYPE;
                }
                Set set = hashSet;
                if (set.contains(nzVarB)) {
                    return false;
                }
                nz nzVarB2 = nz.b(oaVar.c);
                if (nzVarB2 == null) {
                    nzVarB2 = nz.UNKNOWN_USER_INCIDENT_TYPE;
                }
                set.add(nzVarB2);
                return true;
            }
        }).f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final oa i(y yVar) {
        ev evVarH = h();
        int size = evVarH.size();
        int i = 0;
        while (i < size) {
            oa oaVar = (oa) evVarH.get(i);
            nz nzVarB = nz.b(oaVar.c);
            if (nzVarB == null) {
                nzVarB = nz.UNKNOWN_USER_INCIDENT_TYPE;
            }
            i++;
            if (yVar == j(nzVarB)) {
                return oaVar;
            }
        }
        return null;
    }

    public abstract CharSequence k(Resources resources);

    public abstract CharSequence l(Resources resources);

    public abstract CharSequence m(Resources resources);

    public abstract CharSequence n(Resources resources, com.google.android.libraries.navigation.internal.tt.d dVar);

    public abstract CharSequence o(Resources resources);

    public final boolean p() {
        return !h().isEmpty();
    }

    public final Integer q(int i) {
        if (i == 0) {
            throw null;
        }
        switch (i - 1) {
            case 1:
                return Integer.valueOf(com.google.android.libraries.navigation.internal.dw.h.ax);
            case 2:
                return Integer.valueOf(com.google.android.libraries.navigation.internal.dw.h.aA);
            case 3:
                return Integer.valueOf(com.google.android.libraries.navigation.internal.dw.h.aZ);
            case 4:
                return Integer.valueOf(com.google.android.libraries.navigation.internal.dw.h.aJ);
            case 5:
                return Integer.valueOf(com.google.android.libraries.navigation.internal.dw.h.aD);
            case 6:
                return Integer.valueOf(com.google.android.libraries.navigation.internal.dw.h.aM);
            case 7:
                return Integer.valueOf(com.google.android.libraries.navigation.internal.dw.h.aG);
            case 8:
                return Integer.valueOf(com.google.android.libraries.navigation.internal.dw.h.aS);
            default:
                return null;
        }
    }
}
