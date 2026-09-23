package com.google.android.libraries.navigation.internal.ti;

import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.ael.ed;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.zs.bk;
import com.google.android.libraries.navigation.internal.zs.bl;
import com.google.android.libraries.navigation.internal.zs.cz;
import com.google.android.libraries.navigation.internal.zs.db;
import com.google.android.libraries.navigation.internal.zs.du;
import com.google.android.libraries.navigation.internal.zs.dv;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public static final c a = new c();
    private Long b;
    private final List c = new ArrayList();

    public final synchronized List a() {
        if (this.c.isEmpty()) {
            int i = ev.d;
            return lv.a;
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar : this.c) {
            if (bVar.d - 1 != 0) {
                bk bkVar = (bk) bl.a.q();
                ev evVar = bVar.a;
                if (!bkVar.b.H()) {
                    bkVar.v();
                }
                bl blVar = (bl) bkVar.b;
                bz bzVar = blVar.c;
                if (!bzVar.c()) {
                    blVar.c = bi.A(bzVar);
                }
                com.google.android.libraries.navigation.internal.ael.b.m(evVar, blVar.c);
                Long l = bVar.b;
                if (l != null) {
                    long jLongValue = l.longValue();
                    if (!bkVar.b.H()) {
                        bkVar.v();
                    }
                    bl blVar2 = (bl) bkVar.b;
                    blVar2.b |= 1;
                    blVar2.d = jLongValue;
                }
                cz czVar = (cz) db.a.q();
                if (!czVar.b.H()) {
                    czVar.v();
                }
                db dbVar = (db) czVar.b;
                bl blVar3 = (bl) bkVar.t();
                blVar3.getClass();
                dbVar.d = blVar3;
                dbVar.c = 26;
                ed edVarB = com.google.android.libraries.navigation.internal.aen.d.b(bVar.c);
                if (!czVar.b.H()) {
                    czVar.v();
                }
                db dbVar2 = (db) czVar.b;
                edVarB.getClass();
                dbVar2.f = edVarB;
                dbVar2.b |= 2;
                arrayList.add(czVar);
            } else {
                du duVar = (du) dv.a.q();
                ev evVar2 = bVar.a;
                if (!duVar.b.H()) {
                    duVar.v();
                }
                dv dvVar = (dv) duVar.b;
                bz bzVar2 = dvVar.c;
                if (!bzVar2.c()) {
                    dvVar.c = bi.A(bzVar2);
                }
                com.google.android.libraries.navigation.internal.ael.b.m(evVar2, dvVar.c);
                Long l2 = bVar.b;
                if (l2 != null) {
                    long jLongValue2 = l2.longValue();
                    if (!duVar.b.H()) {
                        duVar.v();
                    }
                    dv dvVar2 = (dv) duVar.b;
                    dvVar2.b |= 1;
                    dvVar2.d = jLongValue2;
                }
                cz czVar2 = (cz) db.a.q();
                if (!czVar2.b.H()) {
                    czVar2.v();
                }
                db dbVar3 = (db) czVar2.b;
                dv dvVar3 = (dv) duVar.t();
                dvVar3.getClass();
                dbVar3.d = dvVar3;
                dbVar3.c = 25;
                ed edVarB2 = com.google.android.libraries.navigation.internal.aen.d.b(bVar.c);
                if (!czVar2.b.H()) {
                    czVar2.v();
                }
                db dbVar4 = (db) czVar2.b;
                edVarB2.getClass();
                dbVar4.f = edVarB2;
                dbVar4.b |= 2;
                arrayList.add(czVar2);
            }
        }
        this.c.clear();
        return ev.o(arrayList);
    }

    public final synchronized void b(long j, List list) {
        this.c.add(new b(2, j, list, this.b));
    }

    public final synchronized void c(long j, List list) {
        this.c.add(new b(1, j, list, this.b));
    }

    public final synchronized void d(long j) {
        this.b = Long.valueOf(j);
    }
}
