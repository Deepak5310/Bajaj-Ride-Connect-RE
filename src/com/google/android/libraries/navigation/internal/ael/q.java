package com.google.android.libraries.navigation.internal.ael;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class q extends v {
    private static final long serialVersionUID = 1;
    private final int d;
    private final int e;

    public q(byte[] bArr, int i, int i2) {
        super(bArr);
        q(i, i + i2, bArr.length);
        this.d = i;
        this.e = i2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
    }

    @Override // com.google.android.libraries.navigation.internal.ael.v, com.google.android.libraries.navigation.internal.ael.x
    public final byte a(int i) {
        y(i, this.e);
        return this.a[this.d + i];
    }

    @Override // com.google.android.libraries.navigation.internal.ael.v, com.google.android.libraries.navigation.internal.ael.x
    public final byte b(int i) {
        return this.a[this.d + i];
    }

    @Override // com.google.android.libraries.navigation.internal.ael.v
    protected final int c() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.v, com.google.android.libraries.navigation.internal.ael.x
    public final int d() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.v, com.google.android.libraries.navigation.internal.ael.x
    protected final void e(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.a, this.d + i, bArr, i2, i3);
    }

    Object writeReplace() {
        return new v(B());
    }
}
