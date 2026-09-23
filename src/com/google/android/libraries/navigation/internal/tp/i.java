package com.google.android.libraries.navigation.internal.tp;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i {
    public final RemoteViews a;

    public i(Context context) {
        this.a = new RemoteViews(context.getApplicationContext().getPackageName(), com.google.android.libraries.navigation.internal.dw.e.c);
    }

    public final void a(int i) {
        j.a(this.a, com.google.android.libraries.navigation.internal.dw.d.g, i);
    }

    public final void b(CharSequence charSequence) {
        this.a.setTextViewText(com.google.android.libraries.navigation.internal.dw.d.i, charSequence);
        this.a.setViewVisibility(com.google.android.libraries.navigation.internal.dw.d.e, 8);
        this.a.setViewVisibility(com.google.android.libraries.navigation.internal.dw.d.f, 8);
        this.a.setViewVisibility(com.google.android.libraries.navigation.internal.dw.d.i, 0);
    }

    public final void c(Bitmap bitmap) {
        j.b(this.a, com.google.android.libraries.navigation.internal.dw.d.h, bitmap);
    }
}
