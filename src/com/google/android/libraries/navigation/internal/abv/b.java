package com.google.android.libraries.navigation.internal.abv;

import com.google.android.libraries.navigation.internal.abf.s;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends FilterInputStream implements DataInput {
    private final DataInputStream a;

    public b(InputStream inputStream) {
        super(inputStream);
        this.a = new DataInputStream(inputStream);
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.DataInput
    public final byte readByte() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.DataInput
    public final char readChar() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.DataInput
    public final double readDouble() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.DataInput
    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(readUnsignedByte() | (readUnsignedByte() << 8) | (readUnsignedByte() << 16) | (readUnsignedByte() << 24));
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) throws IOException {
        s.k(bArr, "buffer");
        this.a.readFully(bArr);
    }

    @Override // java.io.DataInput
    public final int readInt() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.DataInput
    public final String readLine() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.DataInput
    public final long readLong() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.DataInput
    public final short readShort() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.DataInput
    public final String readUTF() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() throws IOException {
        return read() & 255;
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() throws IOException {
        return readUnsignedByte() | (readUnsignedByte() << 8);
    }

    @Override // java.io.DataInput
    public final int skipBytes(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException();
    }
}
