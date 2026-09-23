package com.google.android.libraries.navigation.internal.fx;

import android.content.IntentFilter;
import com.reactnativecommunity.netinfo.BroadcastReceiverConnectivityReceiver;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class g implements Runnable {
    final /* synthetic */ i a;

    public g(i iVar) {
        this.a = iVar;
    }

    @Override // java.lang.Runnable
    public final synchronized void run() {
        i iVar = this.a;
        a aVarA = iVar.m.a(iVar.g);
        if (aVarA != null) {
            long epochMilli = this.a.h.f().toEpochMilli();
            long j = aVarA.b;
            long j2 = j - epochMilli;
            if (j2 > i.a) {
                this.a.e(aVarA.a, j, j2);
                return;
            }
            i iVar2 = this.a;
            synchronized (iVar2) {
                iVar2.f434n = null;
                long epochMilli2 = iVar2.h.f().toEpochMilli();
                if (epochMilli2 >= iVar2.l + i.b) {
                    iVar2.l = epochMilli2;
                    iVar2.m.b();
                }
            }
        }
        if (i.g(this.a.f)) {
            i iVar3 = this.a;
            iVar3.p.c(iVar3.r);
            return;
        }
        h hVar = new h(this.a);
        i iVar4 = this.a;
        hVar.a = true;
        iVar4.f.registerReceiver(hVar, new IntentFilter(BroadcastReceiverConnectivityReceiver.CONNECTIVITY_ACTION));
    }
}
