package com.google.android.libraries.navigation.internal.agg;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dz implements Serializable {
    private static final long serialVersionUID = 1;
    protected transient int[] a;
    public int b;
    protected dt c;

    public dz() {
        this(0, null);
    }

    public dz(int i, dt dtVar) {
        this.a = di.a;
        if (i > 0) {
            this.a = new int[i];
        }
        this.c = dtVar;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.a = new int[objectInputStream.readInt()];
        for (int i = 0; i < this.b; i++) {
            this.a[i] = objectInputStream.readInt();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.a.length);
        for (int i = 0; i < this.b; i++) {
            objectOutputStream.writeInt(this.a[i]);
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0046  */
    public final int a() {
        int i;
        int i2 = this.b;
        if (i2 == 0) {
            throw new NoSuchElementException();
        }
        int[] iArr = this.a;
        int i3 = 0;
        int i4 = iArr[0];
        int i5 = i2 - 1;
        this.b = i5;
        int i6 = iArr[i5];
        iArr[0] = i6;
        if (i5 != 0) {
            dt dtVar = this.c;
            if (dtVar != null) {
                while (true) {
                    int i7 = i3 + i3;
                    int i8 = i7 + 1;
                    if (i8 >= i5) {
                        break;
                    }
                    int i9 = iArr[i8];
                    int i10 = i7 + 2;
                    if (i10 < i5) {
                        int i11 = iArr[i10];
                        if (dtVar.a(i11, i9) < 0) {
                            i9 = i11;
                        } else {
                            i10 = i8;
                        }
                    } else {
                        i10 = i8;
                    }
                    if (dtVar.a(i6, i9) <= 0) {
                        break;
                    }
                    iArr[i3] = i9;
                    i3 = i10;
                }
            } else {
                while (true) {
                    int i12 = i3 + i3;
                    int i13 = i12 + 1;
                    if (i13 >= i5) {
                        break;
                    }
                    int i14 = iArr[i13];
                    int i15 = i12 + 2;
                    if (i15 >= i5 || (i = iArr[i15]) >= i14) {
                        i15 = i13;
                    } else {
                        i14 = i;
                    }
                    if (i6 <= i14) {
                        break;
                    }
                    iArr[i3] = i14;
                    i3 = i15;
                }
            }
            iArr[i3] = i6;
        }
        return i4;
    }

    public final int b() {
        if (this.b != 0) {
            return this.a[0];
        }
        throw new NoSuchElementException();
    }

    public final void c(int i) {
        int i2 = this.b;
        int[] iArr = this.a;
        int length = iArr.length;
        if (i2 == length) {
            int i3 = i2 + 1;
            if (i3 > length) {
                int[] iArr2 = new int[(int) Math.max(Math.min(((long) length) + ((long) (length >> 1)), 2147483639L), i3)];
                System.arraycopy(iArr, 0, iArr2, 0, length);
                iArr = iArr2;
            }
            this.a = iArr;
        }
        int[] iArr3 = this.a;
        int i4 = this.b;
        this.b = i4 + 1;
        iArr3[i4] = i;
        dt dtVar = this.c;
        int i5 = iArr3[i4];
        if (dtVar != null) {
            while (i4 != 0) {
                int i6 = (i4 - 1) >>> 1;
                int i7 = iArr3[i6];
                if (dtVar.a(i7, i5) <= 0) {
                    break;
                }
                iArr3[i4] = i7;
                i4 = i6;
            }
        } else {
            while (i4 != 0) {
                int i8 = (i4 - 1) >>> 1;
                int i9 = iArr3[i8];
                if (i9 <= i5) {
                    break;
                }
                iArr3[i4] = i9;
                i4 = i8;
            }
        }
        iArr3[i4] = i5;
    }

    public dz(int i) {
        this(i, null);
    }
}
