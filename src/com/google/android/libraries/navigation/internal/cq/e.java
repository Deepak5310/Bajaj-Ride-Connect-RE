package com.google.android.libraries.navigation.internal.cq;

import com.google.android.libraries.navigation.internal.aaq.an;
import com.google.android.libraries.navigation.internal.adg.ex;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends ab {
    public ex a;
    public an b;
    private int c;
    private int d;
    private String e;
    private k f;
    private byte g;

    @Override // com.google.android.libraries.navigation.internal.cq.ab
    public final ac a() {
        String str;
        k kVar;
        if (this.g != 3 || (str = this.e) == null || (kVar = this.f) == null) {
            throw new IllegalStateException();
        }
        return new f(this.c, this.d, str, kVar, null, this.b);
    }

    @Override // com.google.android.libraries.navigation.internal.cq.ab
    public final void b(k kVar) {
        Objects.requireNonNull(kVar);
        this.f = kVar;
    }

    @Override // com.google.android.libraries.navigation.internal.cq.ab
    public final void c(String str) {
        Objects.requireNonNull(str);
        this.e = str;
    }

    @Override // com.google.android.libraries.navigation.internal.cq.ab
    public final void d(int i) {
        this.d = i;
        this.g = (byte) (this.g | 2);
    }

    @Override // com.google.android.libraries.navigation.internal.cq.ab
    public final void e(int i) {
        this.c = i;
        this.g = (byte) (this.g | 1);
    }
}
