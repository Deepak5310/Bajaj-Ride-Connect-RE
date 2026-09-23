package com.google.android.libraries.navigation.internal.abh;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fb implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ ImageView a;

    public fb(ImageView imageView) {
        this.a = imageView;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        View view = (View) this.a.getParent();
        Rect rect = new Rect();
        this.a.getHitRect(rect);
        rect.top -= 3;
        rect.left -= 3;
        rect.bottom += 3;
        rect.right += 3;
        view.setTouchDelegate(new TouchDelegate(rect, this.a));
    }
}
