package com.google.android.libraries.navigation.internal.pb;

import android.graphics.Rect;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k {
    private Rect a;
    private final List b = new ArrayList();
    private ev c;
    private final Rect d;

    public k(int i, int i2) {
        this.d = new Rect(0, 0, i, i2);
    }

    public final synchronized Rect a() {
        if (this.a == null) {
            this.a = this.d;
        }
        return this.a;
    }

    public final synchronized ev b() {
        if (this.c == null) {
            this.c = ev.o(this.b);
        }
        return this.c;
    }
}
