package com.google.android.libraries.navigation.internal.mu;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g extends c {
    public g(Drawable drawable) {
        super(drawable);
    }

    @Override // com.google.android.libraries.navigation.internal.mu.c, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.scale(-1.0f, 1.0f, bounds.exactCenterX(), bounds.exactCenterY());
        super.draw(canvas);
        canvas.restore();
    }
}
