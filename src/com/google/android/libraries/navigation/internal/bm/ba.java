package com.google.android.libraries.navigation.internal.bm;

import android.graphics.Rect;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ba implements com.google.android.libraries.navigation.internal.yx.aa {
    final /* synthetic */ double a;

    public ba(double d) {
        this.a = d;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.aa
    public final /* bridge */ /* synthetic */ Object ak(Object obj) {
        Rect rect = (Rect) obj;
        double dWidth = ((double) rect.width()) / ((double) rect.height());
        double d = this.a;
        return Double.valueOf(d < dWidth ? d / dWidth : dWidth / d);
    }
}
