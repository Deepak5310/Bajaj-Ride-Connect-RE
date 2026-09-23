package com.google.android.libraries.navigation.internal.yz;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ma extends fd {
    public static final fd b = new ma(null, new Object[0], 0);
    private static final long serialVersionUID = 0;
    final transient Object[] c;
    public final transient int d;
    private final transient Object e;

    private ma(Object obj, Object[] objArr, int i) {
        this.e = obj;
        this.c = objArr;
        this.d = i;
    }

    public static ma a(int i, Object[] objArr) {
        return p(i, objArr, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r5v2, types: [int[]] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v7 */
    static ma p(int i, Object[] objArr, ez ezVar) {
        short[] sArr;
        char c;
        char c2;
        ?? r3;
        ?? r6;
        ?? r4;
        int i2 = i;
        Object[] objArrCopyOf = objArr;
        if (i2 == 0) {
            return (ma) b;
        }
        ey eyVar = null;
        ?? r5 = 0;
        ey eyVar2 = null;
        ey eyVar3 = null;
        int i3 = 1;
        if (i2 == 1) {
            bs.a(Objects.requireNonNull(objArrCopyOf[0]), Objects.requireNonNull(objArrCopyOf[1]));
            return new ma(null, objArrCopyOf, 1);
        }
        com.google.android.libraries.navigation.internal.yx.ar.u(i2, objArrCopyOf.length >> 1);
        int iJ = fy.j(i);
        if (i2 == 1) {
            bs.a(Objects.requireNonNull(objArrCopyOf[0]), Objects.requireNonNull(objArrCopyOf[1]));
            c = 1;
            c2 = 2;
        } else {
            int i4 = iJ - 1;
            byte b2 = -1;
            if (iJ <= 128) {
                byte[] bArr = new byte[iJ];
                Arrays.fill(bArr, (byte) -1);
                int i5 = 0;
                int i6 = 0;
                while (i5 < i2) {
                    int i7 = i6 + i6;
                    int i8 = i5 + i5;
                    Object objRequireNonNull = Objects.requireNonNull(objArrCopyOf[i8]);
                    Object objRequireNonNull2 = Objects.requireNonNull(objArrCopyOf[i8 ^ i3]);
                    bs.a(objRequireNonNull, objRequireNonNull2);
                    int iA = eh.a(objRequireNonNull.hashCode());
                    while (true) {
                        int i9 = iA & i4;
                        int i10 = bArr[i9] & 255;
                        if (i10 == 255) {
                            bArr[i9] = (byte) i7;
                            if (i6 < i5) {
                                objArrCopyOf[i7] = objRequireNonNull;
                                objArrCopyOf[i7 ^ 1] = objRequireNonNull2;
                            }
                            i6++;
                            break;
                        }
                        if (objRequireNonNull.equals(objArrCopyOf[i10 == true ? 1 : 0])) {
                            int i11 = ~i10;
                            ey eyVar4 = new ey(objRequireNonNull, objRequireNonNull2, Objects.requireNonNull(objArrCopyOf[i11 == true ? 1 : 0]));
                            objArrCopyOf[i11 == true ? 1 : 0] = objRequireNonNull2;
                            eyVar2 = eyVar4;
                            break;
                        }
                        iA = i9 + 1;
                    }
                    i5++;
                    i3 = 1;
                }
                if (i6 == i2) {
                    r3 = bArr;
                } else {
                    r4 = new Object[]{bArr, Integer.valueOf(i6), eyVar2};
                    c2 = 2;
                }
                c = 1;
                r5 = r4;
            } else {
                if (iJ <= 32768) {
                    sArr = new short[iJ];
                    Arrays.fill(sArr, (short) -1);
                    int i12 = 0;
                    for (int i13 = 0; i13 < i2; i13++) {
                        int i14 = i12 + i12;
                        int i15 = i13 + i13;
                        Object objRequireNonNull3 = Objects.requireNonNull(objArrCopyOf[i15]);
                        Object objRequireNonNull4 = Objects.requireNonNull(objArrCopyOf[i15 ^ 1]);
                        bs.a(objRequireNonNull3, objRequireNonNull4);
                        int iA2 = eh.a(objRequireNonNull3.hashCode());
                        while (true) {
                            int i16 = iA2 & i4;
                            char c3 = (char) sArr[i16];
                            if (c3 == 65535) {
                                sArr[i16] = (short) i14;
                                if (i12 < i13) {
                                    objArrCopyOf[i14] = objRequireNonNull3;
                                    objArrCopyOf[i14 ^ 1] = objRequireNonNull4;
                                }
                                i12++;
                                break;
                            }
                            if (objRequireNonNull3.equals(objArrCopyOf[c3])) {
                                int i17 = c3 ^ 1;
                                ey eyVar5 = new ey(objRequireNonNull3, objRequireNonNull4, Objects.requireNonNull(objArrCopyOf[i17 == true ? 1 : 0]));
                                objArrCopyOf[i17 == true ? 1 : 0] = objRequireNonNull4;
                                eyVar3 = eyVar5;
                                break;
                            }
                            iA2 = i16 + 1;
                        }
                    }
                    if (i12 != i2) {
                        Integer numValueOf = Integer.valueOf(i12);
                        c = 1;
                        c2 = 2;
                        r6 = new Object[]{sArr, numValueOf, eyVar3};
                        r5 = r6;
                    }
                    r3 = sArr;
                } else {
                    int i18 = 1;
                    sArr = new int[iJ];
                    Arrays.fill((int[]) sArr, -1);
                    int i19 = 0;
                    int i20 = 0;
                    while (i19 < i2) {
                        int i21 = i20 + i20;
                        int i22 = i19 + i19;
                        Object objRequireNonNull5 = Objects.requireNonNull(objArrCopyOf[i22]);
                        Object objRequireNonNull6 = Objects.requireNonNull(objArrCopyOf[i22 ^ i18]);
                        bs.a(objRequireNonNull5, objRequireNonNull6);
                        int iA3 = eh.a(objRequireNonNull5.hashCode());
                        while (true) {
                            int i23 = iA3 & i4;
                            ?? r15 = sArr[i23];
                            if (r15 == b2) {
                                sArr[i23] = i21;
                                if (i20 < i19) {
                                    objArrCopyOf[i21] = objRequireNonNull5;
                                    objArrCopyOf[i21 ^ 1] = objRequireNonNull6;
                                }
                                i20++;
                                break;
                            }
                            if (objRequireNonNull5.equals(objArrCopyOf[r15])) {
                                int i24 = r15 ^ 1;
                                ey eyVar6 = new ey(objRequireNonNull5, objRequireNonNull6, Objects.requireNonNull(objArrCopyOf[i24 == true ? 1 : 0]));
                                objArrCopyOf[i24 == true ? 1 : 0] = objRequireNonNull6;
                                eyVar = eyVar6;
                                break;
                            }
                            iA3 = i23 + 1;
                            b2 = -1;
                        }
                        i19++;
                        i18 = 1;
                        b2 = -1;
                    }
                    if (i20 != i2) {
                        c = 1;
                        c2 = 2;
                        r6 = new Object[]{sArr, Integer.valueOf(i20), eyVar};
                        r5 = r6;
                    }
                    r3 = sArr;
                }
                c = 1;
                r5 = r4;
            }
            c2 = 2;
            r4 = r3;
            c = 1;
            r5 = r4;
        }
        boolean z = r5 instanceof Object[];
        ?? r7 = r5;
        if (z) {
            Object[] objArr2 = (Object[]) r5;
            ey eyVar7 = (ey) objArr2[c2];
            if (ezVar == null) {
                throw eyVar7.a();
            }
            ezVar.c = eyVar7;
            Object obj = objArr2[0];
            int iIntValue = ((Integer) objArr2[c]).intValue();
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue + iIntValue);
            r7 = obj;
            i2 = iIntValue;
        }
        return new ma(r7, objArrCopyOf, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fd
    public final boolean c() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fd
    public final ek d() {
        return new lz(this.c, 1, this.d);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fd
    public final fy e() {
        return new lx(this, this.c, 0, this.d);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fd
    public final fy f() {
        return new ly(this, new lz(this.c, 0, this.d));
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0003  */
    @Override // com.google.android.libraries.navigation.internal.yz.fd, java.util.Map
    public final Object get(Object obj) {
        Object objRequireNonNull;
        if (obj == null) {
            objRequireNonNull = null;
        } else {
            int i = this.d;
            Object[] objArr = this.c;
            if (i != 1) {
                Object obj2 = this.e;
                if (obj2 == null) {
                    objRequireNonNull = null;
                } else if (obj2 instanceof byte[]) {
                    byte[] bArr = (byte[]) obj2;
                    int length = bArr.length - 1;
                    int iA = eh.a(obj.hashCode());
                    while (true) {
                        int i2 = iA & length;
                        int i3 = bArr[i2] & 255;
                        if (i3 == 255) {
                            break;
                        }
                        if (obj.equals(objArr[i3])) {
                            objRequireNonNull = objArr[i3 ^ 1];
                        } else {
                            iA = i2 + 1;
                        }
                    }
                    objRequireNonNull = null;
                } else if (obj2 instanceof short[]) {
                    short[] sArr = (short[]) obj2;
                    int length2 = sArr.length - 1;
                    int iA2 = eh.a(obj.hashCode());
                    while (true) {
                        int i4 = iA2 & length2;
                        char c = (char) sArr[i4];
                        if (c == 65535) {
                            break;
                        }
                        if (obj.equals(objArr[c])) {
                            objRequireNonNull = objArr[c ^ 1];
                        } else {
                            iA2 = i4 + 1;
                        }
                    }
                    objRequireNonNull = null;
                } else {
                    int[] iArr = (int[]) obj2;
                    int length3 = iArr.length - 1;
                    int iA3 = eh.a(obj.hashCode());
                    while (true) {
                        int i5 = iA3 & length3;
                        int i6 = iArr[i5];
                        if (i6 == -1) {
                            break;
                        }
                        if (obj.equals(objArr[i6])) {
                            objRequireNonNull = objArr[i6 ^ 1];
                        } else {
                            iA3 = i5 + 1;
                        }
                    }
                    objRequireNonNull = null;
                }
            } else if (Objects.requireNonNull(objArr[0]).equals(obj)) {
                objRequireNonNull = Objects.requireNonNull(objArr[1]);
            } else {
                objRequireNonNull = null;
            }
        }
        if (objRequireNonNull == null) {
            return null;
        }
        return objRequireNonNull;
    }

    @Override // java.util.Map
    public final int size() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fd
    public Object writeReplace() {
        return super.writeReplace();
    }
}
