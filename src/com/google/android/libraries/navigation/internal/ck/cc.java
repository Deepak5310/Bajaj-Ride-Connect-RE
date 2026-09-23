package com.google.android.libraries.navigation.internal.ck;

import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.adr.fg;
import com.google.android.libraries.navigation.internal.adr.fh;
import com.google.android.libraries.navigation.internal.adr.ii;
import com.google.android.libraries.navigation.internal.adr.io;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cc {
    public static ev a(com.google.android.libraries.navigation.internal.bp.bg bgVar) {
        ii iiVar = bgVar.u;
        if (iiVar == null) {
            int i = ev.d;
            return lv.a;
        }
        io ioVar = iiVar.j;
        if (ioVar == null) {
            ioVar = io.a;
        }
        return ev.o(ioVar.b);
    }

    public static ev b(List list) {
        int i = ev.d;
        eq eqVar = new eq();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            el elVar = (el) it2.next();
            fg fgVar = (elVar.c == 22 ? (fh) elVar.d : fh.a).k;
            if (fgVar == null) {
                fgVar = fg.a;
            }
            if (fgVar.c == 4) {
                fg fgVar2 = (elVar.c == 22 ? (fh) elVar.d : fh.a).k;
                if (fgVar2 == null) {
                    fgVar2 = fg.a;
                }
                eqVar.h(fgVar2);
            }
        }
        return eqVar.g();
    }
}
