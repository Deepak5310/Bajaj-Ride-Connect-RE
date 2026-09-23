package com.google.android.libraries.navigation.internal.bt;

import android.content.Context;
import com.google.android.libraries.navigation.internal.adq.ar;
import com.google.android.libraries.navigation.internal.adr.le;
import com.google.android.libraries.navigation.internal.adr.lg;
import com.google.android.libraries.navigation.internal.adr.lj;
import com.google.android.libraries.navigation.internal.adr.ls;
import com.google.android.libraries.navigation.internal.adr.lv;
import com.google.android.libraries.navigation.internal.adr.lx;
import com.google.android.libraries.navigation.internal.adr.lz;
import com.google.android.libraries.navigation.internal.adr.ma;
import com.google.android.libraries.navigation.internal.ady.ab;
import com.google.android.libraries.navigation.internal.bp.af;
import com.google.android.libraries.navigation.internal.bp.cj;
import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.bp.t;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j {
    /* JADX WARN: Code duplicated, block: B:101:0x010a  */
    /* JADX WARN: Code duplicated, block: B:103:0x010e  */
    /* JADX WARN: Code duplicated, block: B:107:0x0117  */
    /* JADX WARN: Code duplicated, block: B:110:0x0122  */
    /* JADX WARN: Code duplicated, block: B:113:0x012b  */
    /* JADX WARN: Code duplicated, block: B:115:0x012f  */
    /* JADX WARN: Code duplicated, block: B:118:0x0135  */
    /* JADX WARN: Code duplicated, block: B:122:0x0140  */
    /* JADX WARN: Code duplicated, block: B:124:0x0148  */
    /* JADX WARN: Code duplicated, block: B:128:0x0150  */
    /* JADX WARN: Code duplicated, block: B:135:0x015b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:16:0x0033  */
    /* JADX WARN: Code duplicated, block: B:18:0x0037  */
    /* JADX WARN: Code duplicated, block: B:21:0x003f  */
    /* JADX WARN: Code duplicated, block: B:23:0x0043  */
    /* JADX WARN: Code duplicated, block: B:26:0x0049  */
    /* JADX WARN: Code duplicated, block: B:29:0x004f  */
    /* JADX WARN: Code duplicated, block: B:32:0x0055  */
    /* JADX WARN: Code duplicated, block: B:35:0x0066  */
    /* JADX WARN: Code duplicated, block: B:38:0x006d  */
    /* JADX WARN: Code duplicated, block: B:41:0x0075  */
    /* JADX WARN: Code duplicated, block: B:43:0x0079  */
    /* JADX WARN: Code duplicated, block: B:46:0x007f  */
    /* JADX WARN: Code duplicated, block: B:50:0x0088  */
    /* JADX WARN: Code duplicated, block: B:53:0x0093  */
    /* JADX WARN: Code duplicated, block: B:56:0x009b  */
    /* JADX WARN: Code duplicated, block: B:58:0x009f  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:77:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:80:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:82:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:85:0x00df  */
    /* JADX WARN: Code duplicated, block: B:89:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:92:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:95:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:97:0x00fe  */
    public static ev a(af afVar, Context context) {
        lg lgVar;
        lg lgVar2;
        ls lsVar;
        lg lgVar3;
        ls lsVar2;
        t tVar;
        lg lgVar4;
        lg lgVar5;
        lg lgVar6;
        lg lgVar7;
        lg lgVar8;
        lg lgVar9;
        lg lgVar10;
        lg lgVar11;
        lg lgVar12;
        int iA;
        lg lgVar13;
        com.google.android.libraries.navigation.internal.adq.t tVar2;
        lz lzVar;
        lg lgVar14;
        lg lgVar15;
        ab abVar;
        lg lgVar16;
        ar arVarB;
        lg lgVar17;
        com.google.android.libraries.navigation.internal.adr.b bVar;
        lg lgVar18;
        le leVar;
        eq eqVar = new eq();
        for (int i = 0; i < afVar.d(); i++) {
            String strK = afVar.k();
            ma maVarH = afVar.h(i);
            int iA2 = lx.a(maVarH.d);
            if (iA2 == 0) {
                iA2 = lx.a;
            }
            ck ckVarB = null;
            if (iA2 == lx.a) {
                lgVar = maVarH.c;
                if (lgVar == null) {
                    lgVar = lg.a;
                }
                if ((lgVar.b & 1) == 0) {
                    lgVar2 = maVarH.c;
                    if (lgVar2 == null) {
                        lgVar2 = lg.a;
                    }
                    lsVar = lgVar2.c;
                    if (lsVar == null) {
                        lsVar = ls.a;
                    }
                    lgVar3 = maVarH.c;
                    if (lgVar3 == null) {
                        lgVar3 = lg.a;
                    }
                    lsVar2 = lgVar3.c;
                    if (lsVar2 == null) {
                        lsVar2 = ls.a;
                    }
                    tVar = new t(ck.O(lsVar2, context));
                    if ((lsVar.b & 256) == 0) {
                        b(context, tVar, maVarH);
                    }
                    lgVar4 = maVarH.c;
                    if (lgVar4 == null) {
                        lgVar4 = lg.a;
                    }
                    if ((lgVar4.b & 256) != 0) {
                        lgVar18 = maVarH.c;
                        if (lgVar18 == null) {
                            lgVar18 = lg.a;
                        }
                        leVar = lgVar18.e;
                        if (leVar == null) {
                            leVar = le.a;
                        }
                        tVar.x(leVar);
                    }
                    lgVar5 = maVarH.c;
                    if (lgVar5 == null) {
                        lgVar5 = lg.a;
                    }
                    tVar.y(lgVar5.f);
                    lgVar6 = maVarH.c;
                    if (lgVar6 == null) {
                        lgVar6 = lg.a;
                    }
                    if ((lgVar6.b & 2) != 0) {
                        lgVar17 = maVarH.c;
                        if (lgVar17 == null) {
                            lgVar17 = lg.a;
                        }
                        bVar = lgVar17.d;
                        if (bVar == null) {
                            bVar = com.google.android.libraries.navigation.internal.adr.b.a;
                        }
                        tVar.C(bVar);
                    }
                    lgVar7 = maVarH.c;
                    if (lgVar7 == null) {
                        lgVar7 = lg.a;
                    }
                    if ((lgVar7.b & 2048) != 0) {
                        lgVar16 = maVarH.c;
                        if (lgVar16 == null) {
                            lgVar16 = lg.a;
                        }
                        arVarB = ar.b(lgVar16.h);
                        if (arVarB == null) {
                            arVarB = ar.UNKNOWN_PARKING_DIFFICULTY;
                        }
                        tVar.r(arVarB);
                    }
                    lgVar8 = maVarH.c;
                    if (lgVar8 == null) {
                        lgVar8 = lg.a;
                    }
                    if ((lgVar8.b & 8192) != 0) {
                        lgVar15 = maVarH.c;
                        if (lgVar15 == null) {
                            lgVar15 = lg.a;
                        }
                        abVar = lgVar15.i;
                        if (abVar == null) {
                            abVar = ab.a;
                        }
                        tVar.F(abVar);
                    }
                    if (!aq.c(strK)) {
                        tVar.h = strK;
                    }
                    lgVar9 = maVarH.c;
                    if (lgVar9 == null) {
                        lgVar9 = lg.a;
                    }
                    if ((lgVar9.b & 32768) != 0) {
                        lgVar14 = maVarH.c;
                        if (lgVar14 == null) {
                            lgVar14 = lg.a;
                        }
                        tVar.i = lgVar14.j;
                    }
                    if ((maVarH.b & 64) != 0) {
                        lzVar = maVarH.f;
                        if (lzVar == null) {
                            lzVar = lz.a;
                        }
                        tVar.A(lzVar);
                    }
                    lgVar10 = maVarH.c;
                    if (lgVar10 == null) {
                        lgVar10 = lg.a;
                    }
                    tVar.p(lgVar10.k);
                    lgVar11 = maVarH.c;
                    if (lgVar11 == null) {
                        lgVar11 = lg.a;
                    }
                    if ((lgVar11.b & 131072) != 0) {
                        lgVar13 = maVarH.c;
                        if (lgVar13 == null) {
                            lgVar13 = lg.a;
                        }
                        tVar2 = lgVar13.l;
                        if (tVar2 == null) {
                            tVar2 = com.google.android.libraries.navigation.internal.adq.t.a;
                        }
                        tVar.D(tVar2);
                    }
                    if ((maVarH.b & 128) != 0) {
                        iA = lv.a(maVarH.g);
                        if (iA == 0) {
                            iA = lv.a;
                        }
                        tVar.m = iA;
                    }
                    lgVar12 = maVarH.c;
                    if (lgVar12 == null) {
                        lgVar12 = lg.a;
                    }
                    tVar.l(lgVar12.g);
                    ckVarB = tVar.B();
                }
            } else {
                int iA3 = lx.a(maVarH.d);
                if (iA3 == 0) {
                    iA3 = lx.a;
                }
                if (iA3 == lx.b) {
                    lgVar = maVarH.c;
                    if (lgVar == null) {
                        lgVar = lg.a;
                    }
                    if ((lgVar.b & 1) == 0) {
                        lgVar2 = maVarH.c;
                        if (lgVar2 == null) {
                            lgVar2 = lg.a;
                        }
                        lsVar = lgVar2.c;
                        if (lsVar == null) {
                            lsVar = ls.a;
                        }
                        lgVar3 = maVarH.c;
                        if (lgVar3 == null) {
                            lgVar3 = lg.a;
                        }
                        lsVar2 = lgVar3.c;
                        if (lsVar2 == null) {
                            lsVar2 = ls.a;
                        }
                        tVar = new t(ck.O(lsVar2, context));
                        if ((lsVar.b & 256) == 0) {
                            b(context, tVar, maVarH);
                        }
                        lgVar4 = maVarH.c;
                        if (lgVar4 == null) {
                            lgVar4 = lg.a;
                        }
                        if ((lgVar4.b & 256) != 0) {
                            lgVar18 = maVarH.c;
                            if (lgVar18 == null) {
                                lgVar18 = lg.a;
                            }
                            leVar = lgVar18.e;
                            if (leVar == null) {
                                leVar = le.a;
                            }
                            tVar.x(leVar);
                        }
                        lgVar5 = maVarH.c;
                        if (lgVar5 == null) {
                            lgVar5 = lg.a;
                        }
                        tVar.y(lgVar5.f);
                        lgVar6 = maVarH.c;
                        if (lgVar6 == null) {
                            lgVar6 = lg.a;
                        }
                        if ((lgVar6.b & 2) != 0) {
                            lgVar17 = maVarH.c;
                            if (lgVar17 == null) {
                                lgVar17 = lg.a;
                            }
                            bVar = lgVar17.d;
                            if (bVar == null) {
                                bVar = com.google.android.libraries.navigation.internal.adr.b.a;
                            }
                            tVar.C(bVar);
                        }
                        lgVar7 = maVarH.c;
                        if (lgVar7 == null) {
                            lgVar7 = lg.a;
                        }
                        if ((lgVar7.b & 2048) != 0) {
                            lgVar16 = maVarH.c;
                            if (lgVar16 == null) {
                                lgVar16 = lg.a;
                            }
                            arVarB = ar.b(lgVar16.h);
                            if (arVarB == null) {
                                arVarB = ar.UNKNOWN_PARKING_DIFFICULTY;
                            }
                            tVar.r(arVarB);
                        }
                        lgVar8 = maVarH.c;
                        if (lgVar8 == null) {
                            lgVar8 = lg.a;
                        }
                        if ((lgVar8.b & 8192) != 0) {
                            lgVar15 = maVarH.c;
                            if (lgVar15 == null) {
                                lgVar15 = lg.a;
                            }
                            abVar = lgVar15.i;
                            if (abVar == null) {
                                abVar = ab.a;
                            }
                            tVar.F(abVar);
                        }
                        if (!aq.c(strK)) {
                            tVar.h = strK;
                        }
                        lgVar9 = maVarH.c;
                        if (lgVar9 == null) {
                            lgVar9 = lg.a;
                        }
                        if ((lgVar9.b & 32768) != 0) {
                            lgVar14 = maVarH.c;
                            if (lgVar14 == null) {
                                lgVar14 = lg.a;
                            }
                            tVar.i = lgVar14.j;
                        }
                        if ((maVarH.b & 64) != 0) {
                            lzVar = maVarH.f;
                            if (lzVar == null) {
                                lzVar = lz.a;
                            }
                            tVar.A(lzVar);
                        }
                        lgVar10 = maVarH.c;
                        if (lgVar10 == null) {
                            lgVar10 = lg.a;
                        }
                        tVar.p(lgVar10.k);
                        lgVar11 = maVarH.c;
                        if (lgVar11 == null) {
                            lgVar11 = lg.a;
                        }
                        if ((lgVar11.b & 131072) != 0) {
                            lgVar13 = maVarH.c;
                            if (lgVar13 == null) {
                                lgVar13 = lg.a;
                            }
                            tVar2 = lgVar13.l;
                            if (tVar2 == null) {
                                tVar2 = com.google.android.libraries.navigation.internal.adq.t.a;
                            }
                            tVar.D(tVar2);
                        }
                        if ((maVarH.b & 128) != 0) {
                            iA = lv.a(maVarH.g);
                            if (iA == 0) {
                                iA = lv.a;
                            }
                            tVar.m = iA;
                        }
                        lgVar12 = maVarH.c;
                        if (lgVar12 == null) {
                            lgVar12 = lg.a;
                        }
                        tVar.l(lgVar12.g);
                        ckVarB = tVar.B();
                    }
                }
            }
            com.google.android.libraries.navigation.internal.yx.ar.q(ckVarB);
            eqVar.h(ckVarB);
        }
        return eqVar.g();
    }

    /* JADX WARN: Code duplicated, block: B:51:0x0089  */
    /* JADX WARN: Code duplicated, block: B:53:0x008f  */
    /* JADX WARN: Code duplicated, block: B:55:0x0097  */
    /* JADX WARN: Code duplicated, block: B:56:0x0099  */
    static void b(Context context, cj cjVar, ma maVar) {
        lj ljVarB;
        String str;
        String string;
        com.google.android.libraries.navigation.internal.yx.ar.q(maVar);
        lg lgVar = maVar.c;
        if (lgVar == null) {
            lgVar = lg.a;
        }
        ls lsVar = lgVar.c;
        if (lsVar == null) {
            lsVar = ls.a;
        }
        if ((lsVar.b & 512) != 0) {
            lg lgVar2 = maVar.c;
            if (lgVar2 == null) {
                lgVar2 = lg.a;
            }
            ls lsVar2 = lgVar2.c;
            if (lsVar2 == null) {
                lsVar2 = ls.a;
            }
            ljVarB = lj.b(lsVar2.k);
            if (ljVarB == null) {
                ljVarB = lj.ENTITY_TYPE_DEFAULT;
            }
        } else {
            ljVarB = lj.ENTITY_TYPE_DEFAULT;
        }
        if (ljVarB == lj.ENTITY_TYPE_MY_LOCATION) {
            string = context.getString(com.google.android.libraries.navigation.internal.f.h.D);
        } else {
            lg lgVar3 = maVar.c;
            if (lgVar3 == null) {
                lgVar3 = lg.a;
            }
            if ((lgVar3.b & 2) != 0) {
                com.google.android.libraries.navigation.internal.adr.b bVar = lgVar3.d;
                if (bVar == null) {
                    bVar = com.google.android.libraries.navigation.internal.adr.b.a;
                }
                if ((bVar.b & 1) != 0) {
                    string = bVar.d;
                } else if (bVar.c.size() > 0) {
                    string = (String) bVar.c.get(0);
                } else {
                    string = context.getString(com.google.android.libraries.navigation.internal.f.h.u);
                }
            } else {
                ls lsVar3 = lgVar3.c;
                if (lsVar3 == null) {
                    lsVar3 = ls.a;
                }
                if ((lsVar3.b & 2) != 0) {
                    ls lsVar4 = lgVar3.c;
                    if (lsVar4 == null) {
                        lsVar4 = ls.a;
                    }
                    if (!lsVar4.d.isEmpty()) {
                        ls lsVar5 = lgVar3.c;
                        if (lsVar5 == null) {
                            lsVar5 = ls.a;
                        }
                        string = lsVar5.d;
                    } else if ((maVar.b & 8) != 0) {
                        str = maVar.e;
                        if (str.isEmpty()) {
                            string = context.getString(com.google.android.libraries.navigation.internal.f.h.u);
                        } else {
                            string = str;
                        }
                    } else {
                        string = context.getString(com.google.android.libraries.navigation.internal.f.h.u);
                    }
                } else if ((maVar.b & 8) != 0) {
                    str = maVar.e;
                    if (str.isEmpty()) {
                        string = str;
                    } else {
                        string = context.getString(com.google.android.libraries.navigation.internal.f.h.u);
                    }
                } else {
                    string = context.getString(com.google.android.libraries.navigation.internal.f.h.u);
                }
            }
        }
        if (aq.c(string)) {
            return;
        }
        ((t) cjVar).f = string;
        cjVar.v(true);
    }
}
