package com.google.android.libraries.navigation.internal.ck;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.HashMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cw {
    public static final ev a = ev.r(new com.google.android.libraries.navigation.internal.yx.ao(12, Float.valueOf(9.5f)), new com.google.android.libraries.navigation.internal.yx.ao(16, Float.valueOf(16.0f)));
    public static final ev b = ev.r(new com.google.android.libraries.navigation.internal.yx.ao(12, Float.valueOf(6.0f)), new com.google.android.libraries.navigation.internal.yx.ao(16, Float.valueOf(8.5f)));
    public final Canvas c = new Canvas();
    public final Paint d = new Paint();
    public final HashMap e = new HashMap();
    private final Resources f;

    public cw(Resources resources) {
        this.f = resources;
    }

    public static int a(float f) {
        return Math.round(f * 8.0f);
    }

    public final int b(float f) {
        return Math.round(f * this.f.getDisplayMetrics().density);
    }
}
