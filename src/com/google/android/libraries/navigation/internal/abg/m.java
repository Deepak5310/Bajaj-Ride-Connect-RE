package com.google.android.libraries.navigation.internal.abg;

import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.afl.at;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m extends h {
    private final p b;
    private final com.google.android.libraries.navigation.internal.abf.u c;

    public m(p pVar) {
        com.google.android.libraries.navigation.internal.abf.u uVar = com.google.android.libraries.navigation.internal.abf.u.a;
        this.b = pVar;
        this.c = uVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abg.h, com.google.android.libraries.navigation.internal.abg.n
    public final boolean e() {
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof m) {
            return com.google.android.libraries.navigation.internal.abf.r.a(this.b, ((m) obj).b);
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.abg.h, com.google.android.libraries.navigation.internal.abg.n
    public final boolean f() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.abg.n
    public final int h() {
        return 62;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b});
    }

    @Override // com.google.android.libraries.navigation.internal.abg.n
    public final void i(DataOutputStream dataOutputStream) throws IOException {
        this.b.o();
        this.c.b(dataOutputStream, this.b.d());
    }

    @Override // com.google.android.libraries.navigation.internal.abg.n
    public final void j(DataInputStream dataInputStream) throws IOException {
        this.b.p((at) this.c.a((dg) at.a.aH(7, null), dataInputStream));
    }

    @Override // com.google.android.libraries.navigation.internal.abg.h
    public final String toString() {
        p pVar = this.b;
        return "[" + getClass().getSimpleName() + "@" + String.valueOf(pVar) + "]";
    }
}
