package com.google.android.libraries.navigation.internal.ob;

import com.google.android.libraries.navigation.internal.yx.br;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c extends l {
    public br a;
    public m b;
    public String c;
    public byte d;
    private s e;
    private boolean f;

    @Override // com.google.android.libraries.navigation.internal.ob.l
    public final l a(boolean z) {
        this.f = z;
        this.d = (byte) (this.d | 2);
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.ob.l
    public final n b() {
        br brVar;
        m mVar;
        s sVar;
        String str;
        if (this.d != 3 || (brVar = this.a) == null || (mVar = this.b) == null || (sVar = this.e) == null || (str = this.c) == null) {
            throw new IllegalStateException();
        }
        return new d(brVar, mVar, sVar, this.f, str);
    }

    @Override // com.google.android.libraries.navigation.internal.ob.l
    public final void c(s sVar) {
        Objects.requireNonNull(sVar);
        this.e = sVar;
    }
}
