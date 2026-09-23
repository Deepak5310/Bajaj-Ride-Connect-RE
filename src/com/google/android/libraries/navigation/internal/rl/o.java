package com.google.android.libraries.navigation.internal.rl;

import com.google.android.libraries.navigation.internal.ol.av;
import com.google.android.libraries.navigation.internal.ol.ax;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class o {
    public final ax a;
    public av c;
    private final int d;
    private int e = 0;
    public int b = 0;
    private final List f = new ArrayList();

    public o(int i, ax axVar) {
        this.d = i;
        this.a = axVar;
    }

    final synchronized int a(i iVar) {
        int iB;
        this.f.add(iVar);
        iB = b() - 1;
        av avVar = this.c;
        if (avVar != null) {
            iVar.a(avVar);
        }
        return iB;
    }

    final synchronized int b() {
        return this.f.size();
    }

    final synchronized p c() {
        av avVar;
        if (this.c == null) {
            ax axVar = this.a;
            int i = this.d;
            Locale locale = Locale.US;
            Integer numValueOf = Integer.valueOf(i);
            int i2 = this.e;
            this.e = i2 + 1;
            av avVarH = axVar.h(String.format(locale, "style_collection_%d_%d", numValueOf, Integer.valueOf(i2)));
            Iterator it2 = this.f.iterator();
            while (it2.hasNext()) {
                ((i) it2.next()).a(avVarH);
            }
            this.c = avVarH;
        }
        this.b++;
        avVar = this.c;
        ar.q(avVar);
        return new p(avVar, this);
    }
}
