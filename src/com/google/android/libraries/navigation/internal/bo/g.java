package com.google.android.libraries.navigation.internal.bo;

import com.google.android.libraries.geo.mapcore.renderer.ax;
import com.google.android.libraries.navigation.internal.ck.ck;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements Runnable {
    private final ax a;
    private final List b;
    private final boolean c;
    private final com.google.android.libraries.navigation.internal.oq.d d;
    private volatile boolean e;
    private float f = 1.0f;
    private float g = 0.0f;

    public g(ax axVar, List list, boolean z, boolean z2, com.google.android.libraries.navigation.internal.oq.d dVar) {
        this.a = axVar;
        this.b = list;
        this.c = z;
        this.e = z2;
        this.d = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        float fExp;
        com.google.android.libraries.navigation.internal.oq.d dVar = this.d;
        if (this.e) {
            fExp = 1.0f;
        } else {
            float fC = dVar.a().c();
            boolean z = this.c;
            float f = true != z ? 9 : 6;
            fExp = ((float) Math.exp((z ? com.google.android.libraries.navigation.internal.qd.l.a : com.google.android.libraries.navigation.internal.qd.l.b) * ((Math.min(Math.max(fC, f), 18.0f) - f) / (true == z ? 12 : 9)))) / 2.0f;
        }
        float fA = dVar.a().a();
        if (fExp == this.f && fA == this.g) {
            return;
        }
        int i = 0;
        if (fA != this.g) {
            this.g = fA;
            int i2 = 0;
            while (true) {
                List list = this.b;
                if (i2 >= ((lv) list).c) {
                    break;
                }
                ((ck) list.get(i2)).d(this.g);
                i2++;
            }
        }
        if (fExp != this.f) {
            while (true) {
                List list2 = this.b;
                if (i >= ((lv) list2).c) {
                    break;
                }
                ((ck) this.b.get(i)).e((((ck) list2.get(i)).a() - this.f) + fExp);
                i++;
            }
            this.f = fExp;
        }
        this.a.o();
    }
}
