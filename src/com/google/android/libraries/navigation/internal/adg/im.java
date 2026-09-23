package com.google.android.libraries.navigation.internal.adg;

import com.google.android.libraries.navigation.internal.yz.no;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class im extends com.google.android.libraries.navigation.internal.ael.bb implements com.google.android.libraries.navigation.internal.ael.cz {
    public im() {
        super(ip.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(Iterable iterable) {
        if (!this.b.H()) {
            v();
        }
        ip ipVar = (ip) this.b;
        com.google.android.libraries.navigation.internal.ael.br brVar = ip.a;
        ipVar.c();
        no it2 = ((com.google.android.libraries.navigation.internal.yz.ev) iterable).iterator();
        while (it2.hasNext()) {
            ipVar.j.i(((b) it2.next()).j);
        }
    }

    public final void d(b bVar) {
        if (!this.b.H()) {
            v();
        }
        ip ipVar = (ip) this.b;
        com.google.android.libraries.navigation.internal.ael.br brVar = ip.a;
        bVar.getClass();
        ipVar.c();
        ipVar.j.i(bVar.j);
    }
}
