package com.google.android.libraries.navigation.internal.zg;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j extends AbstractMap {
    public static final Comparator a = new g();
    public final Object[] b;
    public final int[] c;
    public final Set d = new i(this, -1);
    private Integer e = null;
    private String f = null;

    public j(j jVar, j jVar2) {
        Object objC;
        Object[] objArr;
        int size = jVar.size() + jVar2.size();
        int iB = jVar.b() + jVar2.b();
        int i = size + 1;
        Object[] objArr2 = new Object[iB];
        int[] iArr = new int[i];
        int i2 = 0;
        iArr[0] = size;
        int i3 = size;
        Map.Entry entryC = jVar.c(0);
        Map.Entry entryC2 = jVar2.c(0);
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (entryC == null && entryC2 == null) {
                break;
            }
            i4++;
            if (entryC != null) {
                if (entryC2 != null) {
                    int iCompareTo = ((String) entryC.getKey()).compareTo((String) entryC2.getKey());
                    if (iCompareTo == 0) {
                        int i7 = i5 + 1;
                        int i8 = i6 + 1;
                        objArr2[i4] = d((String) entryC.getKey(), i4);
                        i iVar = (i) entryC.getValue();
                        i iVar2 = (i) entryC2.getValue();
                        int i9 = i2;
                        int i10 = i9;
                        while (true) {
                            if (i10 >= iVar.size() && i9 >= iVar2.size()) {
                                break;
                            }
                            int iCompare = i10 == iVar.size() ? 1 : i9 == iVar2.size() ? -1 : i2;
                            if (iCompare == 0) {
                                iCompare = l.a.compare(iVar.c(i10), iVar2.c(i9));
                            }
                            if (iCompare < 0) {
                                objC = iVar.c(i10);
                                i10++;
                            } else {
                                int i11 = i9 + 1;
                                Object objC2 = iVar2.c(i9);
                                i10 = iCompare == 0 ? i10 + 1 : i10;
                                objC = objC2;
                                i9 = i11;
                            }
                            objArr2[i3] = objC;
                            i3++;
                            i7 = i7;
                            i2 = 0;
                        }
                        iArr[i4] = i3;
                        entryC = jVar.c(i8);
                        entryC2 = jVar2.c(i7);
                        i5 = i7;
                        i6 = i8;
                    } else {
                        if (iCompareTo < 0) {
                        }
                        i2 = 0;
                    }
                }
                int i12 = i6 + 1;
                int iA = a(entryC, i4, i3, objArr2, iArr);
                entryC = jVar.c(i12);
                i3 = iA;
                i6 = i12;
                i2 = 0;
            }
            int i13 = i5 + 1;
            int iA2 = a(entryC2, i4, i3, objArr2, iArr);
            entryC2 = jVar2.c(i13);
            i3 = iA2;
            i5 = i13;
            i2 = 0;
        }
        int i14 = iArr[i2];
        int i15 = i14 - i4;
        if (i15 != 0) {
            for (int i16 = i2; i16 <= i4; i16++) {
                iArr[i16] = iArr[i16] - i15;
            }
            int i17 = iArr[i4];
            int i18 = i17 - i4;
            if (e(iB, i17)) {
                objArr = new Object[i17];
                System.arraycopy(objArr2, i2, objArr, i2, i4);
            } else {
                objArr = objArr2;
            }
            System.arraycopy(objArr2, i14, objArr, i4, i18);
            objArr2 = objArr;
        }
        this.b = objArr2;
        int i19 = iArr[i2] + 1;
        this.c = e(i, i19) ? Arrays.copyOf(iArr, i19) : iArr;
    }

    private final int a(Map.Entry entry, int i, int i2, Object[] objArr, int[] iArr) {
        i iVar = (i) entry.getValue();
        int iA = iVar.a() - iVar.b();
        System.arraycopy(iVar.b.b, iVar.b(), objArr, i2, iA);
        objArr[i] = d((String) entry.getKey(), i);
        int i3 = i2 + iA;
        iArr[i + 1] = i3;
        return i3;
    }

    private final int b() {
        return this.c[size()];
    }

    private final Map.Entry c(int i) {
        if (i < this.c[0]) {
            return (Map.Entry) this.b[i];
        }
        return null;
    }

    private final Map.Entry d(String str, int i) {
        return new AbstractMap.SimpleImmutableEntry(str, new i(this, i));
    }

    private static boolean e(int i, int i2) {
        return i > 16 && i * 9 > i2 * 10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        return this.d;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        if (this.e == null) {
            this.e = Integer.valueOf(super.hashCode());
        }
        return this.e.intValue();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        if (this.f == null) {
            this.f = super.toString();
        }
        return this.f;
    }

    public j(List list) {
        Iterator it2 = list.iterator();
        if (!it2.hasNext()) {
            int size = list.size();
            Object[] objArr = new Object[size];
            Iterator it3 = list.iterator();
            if (!it3.hasNext()) {
                int[] iArr = {0};
                this.b = e(size, 0) ? Arrays.copyOf(objArr, 0) : objArr;
                this.c = iArr;
                return;
            }
            ((f) it3.next()).a;
            throw null;
        }
        ((f) it2.next()).a;
        throw null;
    }
}
