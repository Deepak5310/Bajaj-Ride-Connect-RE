package com.google.android.libraries.navigation.internal.hk;

import android.content.SharedPreferences;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.aeq.d;
import com.google.android.libraries.navigation.internal.iv.ab;
import com.google.android.libraries.navigation.internal.iv.f;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.aw;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements a {
    private static final String[] a = {"zb", "current_account_id", "current_account_name", "signout_reason", "bk_zb"};
    private final f b;
    private final Object c = new Object();

    public b(f fVar) {
        this.b = fVar;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:47:0x0159 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x015b A[Catch: all -> 0x017d, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0035, B:9:0x003c, B:11:0x0040, B:12:0x0042, B:14:0x004a, B:16:0x0050, B:18:0x005f, B:19:0x0061, B:21:0x0074, B:22:0x0077, B:24:0x008e, B:25:0x0091, B:49:0x015d, B:51:0x0162, B:54:0x016c, B:55:0x0170, B:56:0x0173, B:58:0x0178, B:59:0x017b, B:27:0x00c3, B:29:0x00c9, B:31:0x00cf, B:33:0x00dd, B:35:0x00e5, B:36:0x00e8, B:37:0x00f7, B:39:0x00fd, B:41:0x0105, B:42:0x0108, B:43:0x0117, B:45:0x0127, B:46:0x012a, B:48:0x015b), top: B:64:0x0003 }] */
    @Override // com.google.android.libraries.navigation.internal.hk.a
    public final d c() {
        d dVar;
        synchronized (this.c) {
            SharedPreferences.Editor editorEdit = null;
            dVar = (d) this.b.f(ab.x, (dg) d.a.aH(7, null), null);
            SharedPreferences sharedPreferencesC = this.b.c();
            String string = sharedPreferencesC.getString("zb", "");
            String string2 = sharedPreferencesC.getString("current_account_id", "");
            if (string2.equals("*")) {
                string2 = com.google.android.libraries.navigation.internal.hj.c.a.c;
            }
            if (dVar != null) {
                com.google.android.libraries.navigation.internal.aeq.b bVar = dVar.c;
                if (bVar == null) {
                    bVar = com.google.android.libraries.navigation.internal.aeq.b.a;
                }
                if (bVar.d.isEmpty() && !string.isEmpty()) {
                    bb bbVar = (bb) dVar.aH(5, null);
                    bbVar.x(dVar);
                    com.google.android.libraries.navigation.internal.aeq.c cVar = (com.google.android.libraries.navigation.internal.aeq.c) bbVar;
                    com.google.android.libraries.navigation.internal.aeq.b bVar2 = dVar.c;
                    if (bVar2 == null) {
                        bVar2 = com.google.android.libraries.navigation.internal.aeq.b.a;
                    }
                    bb bbVar2 = (bb) bVar2.aH(5, null);
                    bbVar2.x(bVar2);
                    com.google.android.libraries.navigation.internal.aeq.a aVar = (com.google.android.libraries.navigation.internal.aeq.a) bbVar2;
                    if (!aVar.b.H()) {
                        aVar.v();
                    }
                    com.google.android.libraries.navigation.internal.aeq.b bVar3 = (com.google.android.libraries.navigation.internal.aeq.b) aVar.b;
                    string.getClass();
                    bVar3.b |= 2;
                    bVar3.d = string;
                    if (!cVar.b.H()) {
                        cVar.v();
                    }
                    d dVar2 = (d) cVar.b;
                    com.google.android.libraries.navigation.internal.aeq.b bVar4 = (com.google.android.libraries.navigation.internal.aeq.b) aVar.t();
                    bVar4.getClass();
                    dVar2.c = bVar4;
                    dVar2.b |= 1;
                    dVar = (d) cVar.t();
                    editorEdit = sharedPreferencesC.edit();
                    editorEdit.putString(ab.x.toString(), this.b.h(dVar));
                } else if (dVar != null) {
                    if (dVar == null) {
                        dVar = d.a;
                    }
                } else if (dVar == null) {
                    dVar = d.a;
                }
            } else if (dVar != null && (!string.isEmpty() || !string2.isEmpty())) {
                com.google.android.libraries.navigation.internal.aeq.a aVar2 = (com.google.android.libraries.navigation.internal.aeq.a) com.google.android.libraries.navigation.internal.aeq.b.a.q();
                if (!string.isEmpty()) {
                    if (!aVar2.b.H()) {
                        aVar2.v();
                    }
                    com.google.android.libraries.navigation.internal.aeq.b bVar5 = (com.google.android.libraries.navigation.internal.aeq.b) aVar2.b;
                    string.getClass();
                    bVar5.b |= 2;
                    bVar5.d = string;
                }
                if (!string2.isEmpty()) {
                    if (!aVar2.b.H()) {
                        aVar2.v();
                    }
                    com.google.android.libraries.navigation.internal.aeq.b bVar6 = (com.google.android.libraries.navigation.internal.aeq.b) aVar2.b;
                    string2.getClass();
                    bVar6.b |= 1;
                    bVar6.c = string2;
                }
                com.google.android.libraries.navigation.internal.aeq.c cVar2 = (com.google.android.libraries.navigation.internal.aeq.c) d.a.q();
                if (!cVar2.b.H()) {
                    cVar2.v();
                }
                d dVar3 = (d) cVar2.b;
                com.google.android.libraries.navigation.internal.aeq.b bVar7 = (com.google.android.libraries.navigation.internal.aeq.b) aVar2.t();
                bVar7.getClass();
                dVar3.c = bVar7;
                dVar3.b |= 1;
                dVar = (d) cVar2.t();
                editorEdit = sharedPreferencesC.edit();
                editorEdit.putString(ab.x.toString(), this.b.h(dVar));
            } else if (dVar == null) {
                dVar = d.a;
            }
            String[] strArr = a;
            for (int i = 0; i < 5; i++) {
                String str = strArr[i];
                if (sharedPreferencesC.contains(str)) {
                    if (editorEdit == null) {
                        editorEdit = sharedPreferencesC.edit();
                    }
                    editorEdit.remove(str);
                }
            }
            if (editorEdit != null) {
                editorEdit.commit();
            }
        }
        return dVar;
    }

    @Override // com.google.android.libraries.navigation.internal.hk.a
    public final boolean d(an anVar, d dVar) {
        synchronized (this.c) {
            d dVarC = c();
            if (!((bi) ((aw) anVar).a).equals(dVarC)) {
                return false;
            }
            if (dVar.equals(dVarC)) {
                return true;
            }
            this.b.s(ab.x, dVar);
            return this.b.x();
        }
    }
}
