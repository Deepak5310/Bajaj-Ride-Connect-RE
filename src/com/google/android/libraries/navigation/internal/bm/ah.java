package com.google.android.libraries.navigation.internal.bm;

import com.google.android.libraries.navigation.internal.yz.no;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ah {
    final /* synthetic */ am a;

    public ah(am amVar) {
        this.a = amVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(String str) {
        synchronized (this.a.X) {
            ak akVar = this.a.Y;
            if (akVar != null) {
                no it2 = akVar.b.iterator();
                while (it2.hasNext()) {
                    com.google.android.libraries.navigation.internal.bo.ao aoVar = (com.google.android.libraries.navigation.internal.bo.ao) it2.next();
                    aoVar.p = str;
                    aoVar.e();
                }
            }
        }
    }
}
