package com.google.android.libraries.navigation.internal.kj;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public static BitmapDrawable a(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.setDensity(0);
        bitmapCreateBitmap.eraseColor(0);
        view.draw(new Canvas(bitmapCreateBitmap));
        return new BitmapDrawable(bitmapCreateBitmap);
    }

    public static boolean b(View view) {
        return view.getLayoutDirection() == 1;
    }

    public static boolean c(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public static void d(View view, boolean z) {
        if (view == null) {
            return;
        }
        int i = true != z ? 8 : 0;
        if (view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }
}
