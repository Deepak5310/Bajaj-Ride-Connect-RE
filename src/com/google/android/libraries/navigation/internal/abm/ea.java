package com.google.android.libraries.navigation.internal.abm;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ea {
    final /* synthetic */ Bitmap a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.ly.ch b;
    final /* synthetic */ eb c;

    public ea(eb ebVar, Bitmap bitmap, com.google.android.libraries.navigation.internal.ly.ch chVar) {
        this.a = bitmap;
        this.b = chVar;
        this.c = ebVar;
    }

    public final void a(final Bitmap bitmap) {
        final com.google.android.libraries.navigation.internal.ly.ch chVar = this.b;
        this.c.b.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abm.dz
            @Override // java.lang.Runnable
            public final void run() {
                eb ebVar = this.a.c;
                Bitmap bitmap2 = bitmap;
                ebVar.a(bitmap2);
                eb.b(chVar, bitmap2);
            }
        });
    }

    public final Bitmap b() {
        return this.a;
    }
}
