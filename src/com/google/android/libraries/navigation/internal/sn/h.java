package com.google.android.libraries.navigation.internal.sn;

import android.app.Application;
import com.google.android.libraries.navigation.internal.adr.bm;
import com.google.android.libraries.navigation.internal.adr.dh;
import com.google.android.libraries.navigation.internal.adr.m;
import com.google.android.libraries.navigation.internal.adr.n;
import com.google.android.libraries.navigation.internal.bp.ac;
import com.google.android.libraries.navigation.internal.bp.bn;
import com.google.android.libraries.navigation.internal.bp.bw;
import com.google.android.libraries.navigation.internal.bp.bz;
import com.google.android.libraries.navigation.internal.db.y;
import com.google.android.libraries.navigation.internal.hf.u;
import com.google.android.libraries.navigation.internal.yx.ao;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.zb.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class h {
    private static final j c = j.e("com.google.android.libraries.navigation.internal.sn.h");
    public final Application a;
    public bm.a b;
    private final e d;
    private final HashMap e = new HashMap();
    private final Set f = new HashSet();
    private final com.google.android.libraries.navigation.internal.mj.a g;

    public h(Application application, e eVar, com.google.android.libraries.navigation.internal.mj.a aVar) {
        this.a = application;
        this.d = eVar;
        this.g = aVar;
        eVar.a();
    }

    public static bn a(br brVar) {
        if (brVar == null) {
            return null;
        }
        return (bn) ((Optional) brVar.a()).orElse(null);
    }

    private static ao h(long j, bw bwVar, y yVar, int i) {
        double dB;
        int i2;
        bz bzVar = null;
        if (yVar == null) {
            Iterator it2 = bwVar.c().iterator();
            int i3 = 0;
            while (true) {
                dB = 1.0d;
                if (!it2.hasNext()) {
                    break;
                }
                bz bzVar2 = (bz) it2.next();
                if (!bzVar2.e()) {
                    int iB = bzVar2.b();
                    int iA = bzVar2.a();
                    if (iB == 0) {
                        if (bzVar2.f()) {
                            bzVar = bzVar2;
                            break;
                        }
                        iB = 0;
                    }
                    if (i >= iB && i <= iA && (i2 = iA - iB) > i3) {
                        bzVar = bzVar2;
                        i3 = i2;
                    }
                }
            }
        } else {
            List<bz> listC = bwVar.c();
            int i4 = bwVar.a().m;
            double d = 0.0d;
            for (bz bzVar3 : listC) {
                dB = yVar.b(j, i4 - bzVar3.a(), i4 - bzVar3.b());
                if (dB >= 0.98d) {
                    bzVar = bzVar3;
                } else if (!bzVar3.e() && dB > d) {
                    d = dB;
                    bzVar = bzVar3;
                }
            }
            dB = d;
        }
        return new ao(bzVar, Double.valueOf(dB));
    }

    @Deprecated
    private final String i(int i, int i2) {
        return this.a.getString(i2, new Object[]{u.b(this.a, ((long) i) + this.g.f().getEpochSecond())});
    }

    /* JADX WARN: Multi-variable type inference failed */
    final com.google.android.libraries.navigation.internal.vn.d b(bw bwVar, bz bzVar, double d, int i, int i2) {
        String strReplace;
        c cVar;
        String strA;
        if (bzVar == null) {
            return null;
        }
        bn bnVarA = a(bzVar.c());
        if (bnVarA == null) {
            ((com.google.android.libraries.navigation.internal.zb.h) c.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1563)).p("StepGuidanceWithDistance.SpokenText was null, this should never happen");
            return null;
        }
        boolean zF = bzVar.f();
        String str = bnVarA.a;
        int i3 = 0;
        if (zF) {
            e eVar = this.d;
            bm.a aVarB = eVar.c.b(this.b);
            bm.a aVar = bm.a.KILOMETERS;
            int iOrdinal = aVarB.ordinal();
            if (iOrdinal != 1) {
                cVar = iOrdinal != 2 ? eVar.d : eVar.f;
            } else {
                cVar = eVar.e;
            }
            int size = cVar.size();
            while (true) {
                if (i3 >= size) {
                    ((com.google.android.libraries.navigation.internal.zb.h) e.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(1562)).q("Cannot format distance: %s", i);
                    strA = "";
                    break;
                }
                b bVar = (b) cVar.get(i3);
                i3++;
                if (i < bVar.b) {
                    strA = bVar.a(i);
                    break;
                }
            }
            strReplace = str.replace("$IN_X_DISTANCE", strA);
            i3 = !str.equals(strReplace) ? 1 : 0;
        } else {
            strReplace = str;
        }
        int i4 = i3;
        com.google.android.libraries.navigation.internal.vn.a aVar2 = new com.google.android.libraries.navigation.internal.vn.a(strReplace, bzVar, d, i2);
        com.google.android.libraries.navigation.internal.vn.d dVarB = com.google.android.libraries.navigation.internal.vn.d.b(bwVar, strReplace, ac.b(bnVarA.b), i4 == 0 ? bnVarA.c : null);
        dVarB.f = aVar2;
        return dVarB;
    }

    public final com.google.android.libraries.navigation.internal.vn.d c(int i, List list, int i2, String str) {
        int i3;
        StringBuilder sb = new StringBuilder();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            n nVar = (n) it2.next();
            if (!sb.toString().isEmpty()) {
                sb.append(StringUtils.SPACE);
            }
            int iA = m.a(nVar.d);
            if (iA == 0) {
                iA = m.a;
            }
            if (iA != m.b) {
                i3 = i2;
            } else if (i2 != -1) {
                sb.append(i(i2, com.google.android.libraries.navigation.internal.dw.h.E));
            } else {
                i3 = -1;
            }
            int iA2 = m.a(nVar.d);
            if (iA2 == 0) {
                iA2 = m.a;
            }
            if (iA2 != m.d || i3 == -1) {
                int iA3 = m.a(nVar.d);
                if (iA3 == 0) {
                    iA3 = m.a;
                }
                if (iA3 != m.c || str == null) {
                    sb.append(nVar.c);
                } else {
                    sb.append(str);
                }
            } else {
                sb.append(i(i3, com.google.android.libraries.navigation.internal.dw.h.F));
            }
        }
        return new com.google.android.libraries.navigation.internal.vn.d(com.google.android.libraries.navigation.internal.vn.c.OTHER, null, sb.toString(), null, null, i);
    }

    public final com.google.android.libraries.navigation.internal.vn.d d(bw bwVar, long j, int i, y yVar, int i2) {
        Integer num = (Integer) this.e.get(bwVar);
        if (num != null) {
            float fIntValue = num.intValue();
            float fIntValue2 = num.intValue();
            float fIntValue3 = i - num.intValue();
            if (fIntValue3 >= (-(fIntValue * 0.2f)) && fIntValue3 <= fIntValue2 * 0.4f) {
                i = num.intValue();
            }
        }
        int i3 = i;
        ao aoVarH = h(j, bwVar, yVar, i3);
        return b(bwVar, (bz) aoVarH.a, ((Double) aoVarH.b).doubleValue(), i3, i2);
    }

    public final List e(bw bwVar, y yVar, long j, int i) {
        ArrayList arrayList = new ArrayList();
        ao aoVarH = h(j, bwVar, yVar, i);
        com.google.android.libraries.navigation.internal.vn.d dVarB = b(bwVar, (bz) aoVarH.a, ((Double) aoVarH.b).doubleValue(), i, 0);
        if (dVarB != null) {
            this.e.put(bwVar, Integer.valueOf(i));
            arrayList.add(dVarB);
        }
        g gVar = new g(bwVar);
        gVar.next();
        for (int i2 = 0; i2 < 10 && gVar.hasNext(); i2++) {
            bw bwVarA = gVar.next();
            if (!this.f.contains(bwVarA)) {
                if (bwVarA.a == dh.PREPARE) {
                    bwVarA.a().f355n.toSeconds();
                    int i3 = bwVarA.d;
                    bwVarA.c.toSeconds();
                }
                boolean z = false;
                for (bz bzVar : bwVarA.c()) {
                    bn bnVarA = a(bzVar.c());
                    if (bzVar.d() && bnVarA != null) {
                        arrayList.add(com.google.android.libraries.navigation.internal.vn.d.b(bwVarA, bnVarA.a, ac.b(bnVarA.b), bnVarA.c));
                        bzVar.a();
                        z = true;
                    }
                }
                if (z) {
                    this.f.add(bwVarA);
                }
            }
        }
        return arrayList;
    }

    public final synchronized void f() {
        g();
    }

    public final void g() {
        this.e.clear();
        this.f.clear();
    }
}
