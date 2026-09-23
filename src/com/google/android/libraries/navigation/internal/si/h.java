package com.google.android.libraries.navigation.internal.si;

import com.google.android.libraries.navigation.internal.adr.bm;
import java.util.Optional;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h {
    public static final h a = new h(null, bm.a.KILOMETERS, false);
    public final Optional b;
    public final boolean c;
    public final bm.a d;

    public h(Integer num, bm.a aVar, boolean z) {
        this.b = Optional.ofNullable(num);
        this.d = aVar;
        this.c = z;
    }
}
