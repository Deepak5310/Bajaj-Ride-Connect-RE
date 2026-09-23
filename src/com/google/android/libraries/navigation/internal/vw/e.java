package com.google.android.libraries.navigation.internal.vw;

import com.google.android.libraries.navigation.internal.zr.cd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e {
    final /* synthetic */ String a;
    final /* synthetic */ j b;
    private long c = -1;

    public e(j jVar, String str) {
        this.a = str;
        this.b = jVar;
    }

    public final synchronized void a() {
        if (this.c >= 0) {
            j jVar = this.b;
            jVar.B(this.a, cd.b, jVar.c.a() - this.c, null);
        }
    }

    public final synchronized void b() {
        this.c = this.b.c.a();
    }
}
