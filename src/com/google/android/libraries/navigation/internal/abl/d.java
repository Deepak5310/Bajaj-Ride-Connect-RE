package com.google.android.libraries.navigation.internal.abl;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d implements com.google.android.libraries.navigation.internal.b.y {
    final /* synthetic */ int a;
    final /* synthetic */ i b;

    public d(i iVar, int i) {
        this.a = i;
        this.b = iVar;
    }

    @Override // com.google.android.libraries.navigation.internal.b.y
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        if (this.a <= 1 || obj == null) {
            this.b.k = (Bitmap) obj;
        } else {
            i iVar = this.b;
            aa aaVar = iVar.j;
            iVar.k = Bitmap.createScaledBitmap((Bitmap) obj, aaVar.f, aaVar.g, false);
        }
        this.b.c();
    }
}
