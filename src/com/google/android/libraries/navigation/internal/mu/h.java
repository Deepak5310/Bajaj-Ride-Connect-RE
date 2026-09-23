package com.google.android.libraries.navigation.internal.mu;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h extends c {
    private final int b;
    private final int c;

    public h(Drawable drawable, int i, int i2) {
        super(drawable);
        this.b = i;
        this.c = i2;
    }

    @Override // com.google.android.libraries.navigation.internal.mu.c, android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.mu.c, android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.b;
    }
}
