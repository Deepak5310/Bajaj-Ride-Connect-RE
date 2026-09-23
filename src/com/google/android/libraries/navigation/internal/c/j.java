package com.google.android.libraries.navigation.internal.c;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j {
    public final int a;
    public final int b;
    public final InputStream c;
    private final List d;

    public j(int i, List list, int i2, InputStream inputStream) {
        this.a = i;
        this.d = list;
        this.b = i2;
        this.c = inputStream;
    }

    public final List a() {
        return Collections.unmodifiableList(this.d);
    }
}
