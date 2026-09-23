package com.google.android.libraries.navigation.internal.aga;

import java.net.SocketAddress;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bh implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ bt b;

    public bh(bt btVar, List list) {
        this.a = list;
        this.b = btVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        de deVar;
        bn bnVar = this.b.h;
        SocketAddress socketAddressB = this.b.h.b();
        bnVar.a = this.a;
        bnVar.c();
        this.b.i = this.a;
        if (this.b.r.a != com.google.android.libraries.navigation.internal.afx.r.READY && this.b.r.a != com.google.android.libraries.navigation.internal.afx.r.CONNECTING) {
            deVar = null;
            break;
        }
        bt btVar = this.b;
        int i = 0;
        while (true) {
            bn bnVar2 = btVar.h;
            if (i < bnVar2.a.size()) {
                int iIndexOf = ((com.google.android.libraries.navigation.internal.afx.z) bnVar2.a.get(i)).b.indexOf(socketAddressB);
                if (iIndexOf == -1) {
                    i++;
                } else {
                    bnVar2.b = i;
                    bnVar2.c = iIndexOf;
                }
            } else {
                if (this.b.r.a == com.google.android.libraries.navigation.internal.afx.r.READY) {
                    bt btVar2 = this.b;
                    deVar = btVar2.q;
                    btVar2.q = null;
                    this.b.h.c();
                    this.b.d(com.google.android.libraries.navigation.internal.afx.r.IDLE);
                    break;
                }
                this.b.p.c(com.google.android.libraries.navigation.internal.afx.cl.f.b("InternalSubchannel closed pending transport due to address change"));
                this.b.p = null;
                this.b.h.c();
                this.b.h();
            }
            deVar = null;
            break;
        }
        if (deVar != null) {
            bt btVar3 = this.b;
            if (btVar3.l != null) {
                btVar3.m.c(com.google.android.libraries.navigation.internal.afx.cl.f.b("InternalSubchannel closed transport early due to address change"));
                this.b.l.a();
                bt btVar4 = this.b;
                btVar4.l = null;
                btVar4.m = null;
            }
            bt btVar5 = this.b;
            btVar5.m = deVar;
            btVar5.l = btVar5.g.a(new bg(this), 5L, TimeUnit.SECONDS, this.b.b);
        }
    }
}
