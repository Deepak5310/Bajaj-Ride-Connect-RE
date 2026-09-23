package com.google.android.libraries.navigation.internal.zi;

import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends f {
    public static final f a = new b();

    private b() {
    }

    @Override // com.google.android.libraries.navigation.internal.zi.f
    public final int a(c cVar, int i, String str, int i2, int i3, int i4) throws e {
        com.google.android.libraries.navigation.internal.zd.c cVar2;
        com.google.android.libraries.navigation.internal.zh.c bVar;
        com.google.android.libraries.navigation.internal.zh.c aVar;
        char cCharAt = str.charAt(i4);
        int i5 = cCharAt & ' ';
        int i6 = 1;
        boolean z = i5 == 0;
        char c = ' ';
        int i7 = i3;
        if (i7 != i4 || z) {
            int i8 = true != z ? 0 : 128;
            while (true) {
                if (i7 == i4) {
                    cVar2 = new com.google.android.libraries.navigation.internal.zd.c(i8, -1, -1);
                    break;
                }
                int i9 = i7 + 1;
                char cCharAt2 = str.charAt(i7);
                if (cCharAt2 >= c && cCharAt2 <= '0') {
                    int iA = com.google.android.libraries.navigation.internal.zd.c.a(cCharAt2);
                    if (iA < 0) {
                        if (cCharAt2 != '.') {
                            throw e.a("invalid flag", str, i7);
                        }
                        cVar2 = new com.google.android.libraries.navigation.internal.zd.c(i8, -1, com.google.android.libraries.navigation.internal.zd.c.b(str, i9, i4));
                        break;
                    }
                    int i10 = 1 << iA;
                    if ((i8 & i10) != 0) {
                        throw e.a("repeated flag", str, i7);
                    }
                    i8 |= i10;
                    i7 = i9;
                    c = ' ';
                } else {
                    if (cCharAt2 > '9') {
                        throw e.a("invalid flag", str, i7);
                    }
                    int i11 = cCharAt2 - '0';
                    while (true) {
                        if (i9 == i4) {
                            cVar2 = new com.google.android.libraries.navigation.internal.zd.c(i8, i11, -1);
                            break;
                        }
                        int i12 = i9 + 1;
                        char cCharAt3 = str.charAt(i9);
                        if (cCharAt3 == '.') {
                            cVar2 = new com.google.android.libraries.navigation.internal.zd.c(i8, i11, com.google.android.libraries.navigation.internal.zd.c.b(str, i12, i4));
                            break;
                        }
                        char c2 = (char) (cCharAt3 - '0');
                        if (c2 >= '\n') {
                            throw e.a("invalid width character", str, i9);
                        }
                        i11 = (i11 * 10) + c2;
                        if (i11 > 999999) {
                            throw e.b("width too large", str, i7, i4);
                        }
                        i9 = i12;
                        i6 = 1;
                    }
                }
            }
        } else {
            cVar2 = com.google.android.libraries.navigation.internal.zd.c.a;
        }
        com.google.android.libraries.navigation.internal.zd.b bVar2 = com.google.android.libraries.navigation.internal.zd.b.k[com.google.android.libraries.navigation.internal.zd.b.a(cCharAt)];
        if (i5 == 0 && (bVar2 == null || (bVar2.f661n & 128) == 0)) {
            bVar2 = null;
        }
        int i13 = i4 + 1;
        if (bVar2 != null) {
            if (!cVar2.e(bVar2.f661n, bVar2.m.f)) {
                throw e.b("invalid format specifier", str, i2, i13);
            }
            Map map = com.google.android.libraries.navigation.internal.zh.e.c;
            if (i >= 10 || !cVar2.c()) {
                aVar = new com.google.android.libraries.navigation.internal.zh.e(i, bVar2, cVar2);
                bVar = aVar;
            } else {
                com.google.android.libraries.navigation.internal.zh.c[] cVarArr = (com.google.android.libraries.navigation.internal.zh.e[]) com.google.android.libraries.navigation.internal.zh.e.c.get(bVar2);
                com.google.android.libraries.navigation.internal.zj.b.d(cVarArr, "default parameter");
                bVar = cVarArr[i];
            }
        } else if (cCharAt == 't' || cCharAt == 'T') {
            if (!cVar2.e(160, false)) {
                throw e.b("invalid format specification", str, i2, i13);
            }
            int i14 = i4 + 2;
            if (i14 > str.length()) {
                throw e.a("truncated format specifier", str, i2);
            }
            com.google.android.libraries.navigation.internal.zh.a aVar2 = (com.google.android.libraries.navigation.internal.zh.a) com.google.android.libraries.navigation.internal.zh.a.F.get(Character.valueOf(str.charAt(i13)));
            if (aVar2 == null) {
                throw e.a("illegal date/time conversion", str, i13);
            }
            bVar = new com.google.android.libraries.navigation.internal.zh.b(cVar2, i, aVar2);
            i13 = i14;
        } else {
            if (cCharAt != 'h' && cCharAt != 'H') {
                throw e.b("invalid format specification", str, i2, i13);
            }
            if (!cVar2.e(160, false)) {
                throw e.b("invalid format specification", str, i2, i13);
            }
            aVar = new a(cVar2, i);
            bVar = aVar;
        }
        int i15 = bVar.a;
        if (i15 < 32) {
            cVar.c |= i6 << i15;
        }
        cVar.d = Math.max(cVar.d, i15);
        cVar.b(i2, i13, bVar);
        return i13;
    }
}
