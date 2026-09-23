package com.google.android.libraries.navigation.internal.lc;

import android.os.RemoteException;
import com.google.android.libraries.navigation.internal.lh.an;
import com.google.android.libraries.navigation.internal.lh.ao;
import com.google.android.libraries.navigation.internal.lh.be;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class q extends an {
    private final int a;

    protected q(byte[] bArr) {
        be.a(bArr.length == 25);
        this.a = Arrays.hashCode(bArr);
    }

    protected static byte[] e(String str) {
        try {
            return str.getBytes(CharEncoding.ISO_8859_1);
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lh.ao
    public final int c() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.lh.ao
    public final com.google.android.libraries.navigation.internal.lo.l d() {
        return new com.google.android.libraries.navigation.internal.lo.n(f());
    }

    public final boolean equals(Object obj) {
        com.google.android.libraries.navigation.internal.lo.l lVarD;
        if (obj != null && (obj instanceof ao)) {
            try {
                ao aoVar = (ao) obj;
                if (aoVar.c() == this.a && (lVarD = aoVar.d()) != null) {
                    return Arrays.equals(f(), (byte[]) com.google.android.libraries.navigation.internal.lo.n.b(lVarD));
                }
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    public abstract byte[] f();

    public final int hashCode() {
        return this.a;
    }
}
