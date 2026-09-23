package com.google.android.libraries.navigation.internal.rz;

import com.google.android.libraries.navigation.internal.adr.hs;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class q extends al {
    public am a;
    private String b;
    private String c;
    private hs d;
    private ae e;
    private boolean f;
    private byte g;

    @Override // com.google.android.libraries.navigation.internal.rz.al
    public final an a() {
        am amVar;
        String str;
        String str2;
        hs hsVar;
        ae aeVar;
        if (this.g != 1 || (amVar = this.a) == null || (str = this.b) == null || (str2 = this.c) == null || (hsVar = this.d) == null || (aeVar = this.e) == null) {
            throw new IllegalStateException();
        }
        return new r(amVar, str, str2, hsVar, aeVar, this.f);
    }

    @Override // com.google.android.libraries.navigation.internal.rz.al
    public final void b(hs hsVar) {
        Objects.requireNonNull(hsVar);
        this.d = hsVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.al
    public final void c(String str) {
        Objects.requireNonNull(str);
        this.c = str;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.al
    public final void d(boolean z) {
        this.f = z;
        this.g = (byte) 1;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.al
    public final void e(ae aeVar) {
        Objects.requireNonNull(aeVar);
        this.e = aeVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.al
    public final void f(String str) {
        Objects.requireNonNull(str);
        this.b = str;
    }
}
