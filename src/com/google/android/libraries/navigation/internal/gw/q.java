package com.google.android.libraries.navigation.internal.gw;

import android.graphics.Bitmap;
import androidx.core.graphics.BitmapCompat;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class q extends com.google.android.libraries.navigation.internal.fq.k {
    public q(com.google.android.libraries.navigation.internal.fq.h hVar, com.google.android.libraries.navigation.internal.fq.f fVar) {
        super(1024000, hVar, fVar);
    }

    @Override // com.google.android.libraries.navigation.internal.fq.k
    public final /* synthetic */ int d(Object obj) {
        return BitmapCompat.getAllocationByteCount((Bitmap) obj);
    }
}
