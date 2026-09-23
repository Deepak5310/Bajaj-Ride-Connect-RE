package com.google.android.libraries.navigation.internal.on;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public final int a;
    public final float b;
    public final List c = new ArrayList();

    public c(float f, float f2) {
        this.a = Math.round((f * 8.0f) / f2);
        this.b = f2;
    }
}
