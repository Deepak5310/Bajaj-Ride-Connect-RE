package com.google.android.libraries.navigation.internal.po;

import com.google.android.libraries.navigation.internal.yz.lv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class at implements Runnable {
    final /* synthetic */ ay a;

    public at(ay ayVar) {
        this.a = ayVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        synchronized (this.a.k) {
            z = this.a.l;
        }
        ay ayVar = this.a;
        int i = 0;
        while (true) {
            com.google.android.libraries.navigation.internal.yz.ev evVar = ayVar.w;
            if (i >= ((lv) evVar).c) {
                break;
            }
            ((gw) evVar.get(i)).d.C(z);
            i++;
        }
        com.google.android.libraries.navigation.internal.qq.j jVar = this.a.d;
        if (jVar != null) {
            jVar.C(z);
        }
    }
}
