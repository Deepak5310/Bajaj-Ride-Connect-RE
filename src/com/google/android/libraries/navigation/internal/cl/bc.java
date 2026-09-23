package com.google.android.libraries.navigation.internal.cl;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.libraries.navigation.internal.adr.Cif;
import com.google.android.libraries.navigation.internal.adr.ii;
import com.google.android.libraries.navigation.internal.adr.kd;
import com.google.android.libraries.navigation.internal.bp.cf;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bc extends aw {
    public final com.google.android.libraries.navigation.internal.bp.bg a;

    public bc(com.google.android.libraries.navigation.internal.bp.bg bgVar, com.google.android.libraries.navigation.internal.oe.ad adVar) {
        super(adVar);
        this.a = bgVar;
    }

    public static String f(Resources resources, int i) {
        String[] stringArray = resources.getStringArray(com.google.android.libraries.navigation.internal.qr.a.a);
        return stringArray[i % stringArray.length];
    }

    /* JADX WARN: Code duplicated, block: B:21:0x003e  */
    static ev g(int i, boolean z, List list) {
        String str;
        eq eqVar = new eq();
        for (int i2 = 0; i2 < list.size(); i2++) {
            com.google.android.libraries.navigation.internal.adr.az azVar = (com.google.android.libraries.navigation.internal.adr.az) list.get(i2);
            int iA = com.google.android.libraries.navigation.internal.adr.ay.a(azVar.e);
            if (iA == 0) {
                iA = com.google.android.libraries.navigation.internal.adr.ay.a;
            }
            if (iA == i) {
                if ((azVar.b & 1) == 0) {
                    str = azVar.d;
                } else {
                    com.google.android.libraries.navigation.internal.adr.ah ahVar = azVar.c;
                    if (ahVar == null) {
                        ahVar = com.google.android.libraries.navigation.internal.adr.ah.a;
                    }
                    com.google.android.libraries.navigation.internal.br.d dVar = (com.google.android.libraries.navigation.internal.br.d) com.google.android.libraries.navigation.internal.br.l.b(ahVar);
                    str = dVar.b;
                    String str2 = dVar.a;
                    if (!z || str == null) {
                        if (str2 != null) {
                            str = str2;
                        } else {
                            str = azVar.d;
                        }
                    }
                }
                eqVar.h(str);
            }
        }
        return eqVar.g();
    }

    public final com.google.android.libraries.navigation.internal.yx.an a() {
        return this.a.j.equals(com.google.android.libraries.navigation.internal.ady.al.BICYCLE) ? com.google.android.libraries.navigation.internal.yx.an.j(this.a.g) : com.google.android.libraries.navigation.internal.yx.a.a;
    }

    final com.google.android.libraries.navigation.internal.yx.an b(Context context) {
        com.google.android.libraries.navigation.internal.yx.an anVarA = a();
        if (!anVarA.g()) {
            return com.google.android.libraries.navigation.internal.yx.a.a;
        }
        Cif cifF = ((cf) anVarA.c()).f();
        String string = null;
        if ((cifF.b & 1024) != 0) {
            com.google.android.libraries.navigation.internal.adr.ap apVar = cifF.j;
            if (apVar == null) {
                apVar = com.google.android.libraries.navigation.internal.adr.ap.a;
            }
            for (com.google.android.libraries.navigation.internal.adr.ao aoVar : apVar.b) {
                int iA = com.google.android.libraries.navigation.internal.adr.an.a(aoVar.b);
                if (iA == 0) {
                    iA = com.google.android.libraries.navigation.internal.adr.an.a;
                }
                if (iA != com.google.android.libraries.navigation.internal.adr.an.a) {
                    ii.a aVar = ii.a.DELAY_NODATA;
                    int iA2 = com.google.android.libraries.navigation.internal.adr.an.a(aoVar.b);
                    if (iA2 == 0) {
                        iA2 = com.google.android.libraries.navigation.internal.adr.an.a;
                    }
                    if (iA2 == 0) {
                        throw null;
                    }
                    switch (iA2 - 1) {
                        case 1:
                            string = context.getString(com.google.android.libraries.navigation.internal.bx.g.l);
                            break;
                        case 2:
                            string = context.getString(com.google.android.libraries.navigation.internal.bx.g.m);
                            break;
                        case 3:
                            string = context.getString(com.google.android.libraries.navigation.internal.bx.g.p);
                            break;
                        case 4:
                            string = context.getString(com.google.android.libraries.navigation.internal.bx.g.r);
                            break;
                        case 5:
                            string = context.getString(com.google.android.libraries.navigation.internal.bx.g.f363n);
                            break;
                        case 6:
                            string = context.getString(com.google.android.libraries.navigation.internal.bx.g.o);
                            break;
                        case 7:
                            string = context.getString(com.google.android.libraries.navigation.internal.bx.g.q);
                            break;
                    }
                }
            }
        }
        return com.google.android.libraries.navigation.internal.yx.an.i(string);
    }

    final com.google.android.libraries.navigation.internal.yx.an c(Resources resources, com.google.android.libraries.navigation.internal.bj.b bVar) {
        kd kdVarB = kd.b(this.a.g.a.x);
        if (kdVarB == null) {
            kdVarB = kd.UNKNOWN_LICENSE_PLATE_RESTRICTION;
        }
        int i = com.google.android.libraries.navigation.internal.qr.e.m;
        int i2 = com.google.android.libraries.navigation.internal.qr.e.c;
        int i3 = com.google.android.libraries.navigation.internal.qr.e.p;
        com.google.android.libraries.navigation.internal.yx.an anVarJ = bVar.b(3) ? com.google.android.libraries.navigation.internal.yx.an.j(Integer.valueOf(com.google.android.libraries.navigation.internal.qr.e.h)) : com.google.android.libraries.navigation.internal.yx.a.a;
        String string = null;
        switch (kdVarB) {
            case EVEN_ONLY:
                string = resources.getString(i2);
                break;
            case ODD_ONLY:
                string = resources.getString(i);
                break;
            case RODIZIO_1_2:
            case RODIZIO_3_4:
            case RODIZIO_5_6:
            case RODIZIO_7_8:
            case RODIZIO_9_0:
                string = resources.getString(i3, com.google.android.libraries.navigation.internal.bj.c.a(kdVarB).c(), com.google.android.libraries.navigation.internal.bj.c.b(kdVarB).c());
                break;
            case MANILA_1_2:
            case MANILA_3_4:
            case MANILA_5_6:
            case MANILA_7_8:
            case MANILA_9_0:
                if (anVarJ.g()) {
                    string = resources.getString(((Integer) anVarJ.c()).intValue(), com.google.android.libraries.navigation.internal.bj.c.a(kdVarB).c(), com.google.android.libraries.navigation.internal.bj.c.b(kdVarB).c());
                }
                break;
        }
        return string == null ? com.google.android.libraries.navigation.internal.yx.a.a : com.google.android.libraries.navigation.internal.yx.an.j(string.toString());
    }

    public final ev d(boolean z) {
        return g(com.google.android.libraries.navigation.internal.adr.ay.c, z, this.a.h);
    }

    public final ev e(boolean z) {
        return g(com.google.android.libraries.navigation.internal.adr.ay.b, z, this.a.h);
    }
}
