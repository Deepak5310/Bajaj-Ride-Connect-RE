package com.google.android.libraries.navigation.internal.uz;

import android.content.Context;
import com.google.android.libraries.navigation.internal.aap.l;
import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.ms.cy;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.zb.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class d implements com.google.android.libraries.navigation.internal.va.c {
    private static final j a = j.e("com.google.android.libraries.navigation.internal.uz.d");
    private final Context b;
    private final i c;
    private final List d = new ArrayList();
    private com.google.android.libraries.navigation.internal.uk.a e;

    public d(Context context, i iVar) {
        this.b = context;
        this.c = iVar;
    }

    @Override // com.google.android.libraries.navigation.internal.cb.a
    public List<? extends com.google.android.libraries.navigation.internal.va.a> a() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.va.c
    public com.google.android.libraries.navigation.internal.uk.a b() {
        return this.e;
    }

    public i c() {
        return this.c;
    }

    public CharSequence d() {
        return this.c.c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void e(com.google.android.libraries.navigation.internal.tj.j jVar, boolean z, List<? extends com.google.android.libraries.navigation.internal.uk.a> list, cs csVar) {
        this.c.d(jVar, z);
        int i = 0;
        if (list.isEmpty()) {
            this.e = null;
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1922)).p("Unexpected state: no header steps.");
        } else {
            this.e = list.get(0);
        }
        ev evVarB = jVar.c().b.B();
        Iterator<? extends com.google.android.libraries.navigation.internal.uk.a> it2 = list.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            com.google.android.libraries.navigation.internal.bl.d.a aVarD = it2.next().d();
            if (aVarD != null && aVarD.a == l.DESTINATION) {
                i2++;
            }
        }
        if (i2 != this.d.size()) {
            this.d.clear();
        }
        ArrayList arrayList = new ArrayList();
        for (com.google.android.libraries.navigation.internal.uk.a aVar : list) {
            arrayList.add(aVar.n());
            com.google.android.libraries.navigation.internal.bl.d.a aVarD2 = aVar.d();
            if (aVarD2 != null && aVarD2.a == l.DESTINATION) {
                int i3 = i + 1;
                String strV = ((ck) evVarB.get(i3)).V();
                if (this.d.size() > i) {
                    ((com.google.android.libraries.navigation.internal.va.a) this.d.get(i)).i(strV, arrayList);
                } else {
                    a aVar2 = new a(this.b, strV, i, arrayList);
                    aVar2.h(csVar);
                    this.d.add(aVar2);
                }
                arrayList = new ArrayList();
                i = i3;
            }
        }
        cy.a(this);
    }
}
