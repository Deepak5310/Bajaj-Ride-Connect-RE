package com.google.android.libraries.navigation.internal.xt;

import com.google.android.libraries.navigation.internal.yz.fw;
import com.google.android.libraries.navigation.internal.yz.mq;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n implements j {
    public final AtomicBoolean a = new AtomicBoolean(false);
    public final ConcurrentMap b = new ConcurrentHashMap();
    public final ConcurrentMap c = new ConcurrentHashMap();
    public final ConcurrentMap d = new ConcurrentHashMap();
    public final ConcurrentMap e = new ConcurrentHashMap();

    /* JADX WARN: Code duplicated, block: B:24:0x007b  */
    public static void a(com.google.android.libraries.navigation.internal.ky.n nVar, com.google.android.libraries.navigation.internal.yx.br brVar) {
        String str;
        int[] iArr;
        int[] iArr2;
        byte[][] bArr;
        byte[][] bArr2;
        byte[] bArr3;
        int[] iArr3;
        int[] iArr4;
        byte[][] bArr4;
        byte[][] bArr5;
        com.google.android.libraries.navigation.internal.ma.l lVar;
        byte[][] bArr6;
        int[] iArr5;
        byte[][] bArr7;
        int[] iArr6;
        ArrayList<com.google.android.libraries.navigation.internal.ma.l> arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        if (!nVar.h.isEmpty()) {
            for (i iVar : (Set) brVar.a()) {
                arrayList.add(iVar.a);
                hashSet.add(iVar.b);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        int i = 0;
        if (arrayList.size() == 1) {
            lVar = (com.google.android.libraries.navigation.internal.ma.l) arrayList.get(0);
        } else {
            if (!arrayList.isEmpty()) {
                String str2 = ((com.google.android.libraries.navigation.internal.ma.l) arrayList.get(0)).b;
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        str = arrayList.isEmpty() ? "" : ((com.google.android.libraries.navigation.internal.ma.l) arrayList.get(0)).b;
                    } else if (!com.google.android.libraries.navigation.internal.ma.am.a(str2, ((com.google.android.libraries.navigation.internal.ma.l) it2.next()).b)) {
                    }
                }
            } else if (arrayList.isEmpty()) {
            }
            String str3 = str;
            byte[][] bArrA = com.google.android.libraries.navigation.internal.ma.l.a(arrayList, new com.google.android.libraries.navigation.internal.ma.k() { // from class: com.google.android.libraries.navigation.internal.ma.g
                @Override // com.google.android.libraries.navigation.internal.ma.k
                public final byte[][] a(l lVar2) {
                    return lVar2.d;
                }
            });
            byte[][] bArrA2 = com.google.android.libraries.navigation.internal.ma.l.a(arrayList, new com.google.android.libraries.navigation.internal.ma.k() { // from class: com.google.android.libraries.navigation.internal.ma.h
                @Override // com.google.android.libraries.navigation.internal.ma.k
                public final byte[][] a(l lVar2) {
                    return lVar2.e;
                }
            });
            byte[][] bArrA3 = com.google.android.libraries.navigation.internal.ma.l.a(arrayList, new com.google.android.libraries.navigation.internal.ma.k() { // from class: com.google.android.libraries.navigation.internal.ma.i
                @Override // com.google.android.libraries.navigation.internal.ma.k
                public final byte[][] a(l lVar2) {
                    return lVar2.f;
                }
            });
            byte[][] bArrA4 = com.google.android.libraries.navigation.internal.ma.l.a(arrayList, new com.google.android.libraries.navigation.internal.ma.k() { // from class: com.google.android.libraries.navigation.internal.ma.j
                @Override // com.google.android.libraries.navigation.internal.ma.k
                public final byte[][] a(l lVar2) {
                    return lVar2.g;
                }
            });
            boolean z = true;
            int length = 0;
            for (com.google.android.libraries.navigation.internal.ma.l lVar2 : arrayList) {
                if (lVar2 != null && (iArr6 = lVar2.h) != null) {
                    length += iArr6.length;
                    z = false;
                }
            }
            if (z) {
                iArr = null;
            } else {
                iArr = new int[length];
                int i2 = 0;
                for (com.google.android.libraries.navigation.internal.ma.l lVar3 : arrayList) {
                    if (lVar3 != null && (iArr2 = lVar3.h) != null) {
                        int i3 = 0;
                        while (i3 < iArr2.length) {
                            iArr[i2] = iArr2[i3];
                            i3++;
                            i2++;
                        }
                    }
                }
            }
            int length2 = 0;
            boolean z2 = true;
            for (com.google.android.libraries.navigation.internal.ma.l lVar4 : arrayList) {
                if (lVar4 != null && lVar4.c != null) {
                    length2++;
                    z2 = false;
                }
                if (lVar4 != null && (bArr7 = lVar4.i) != null) {
                    length2 += bArr7.length;
                    z2 = false;
                }
            }
            if (z2) {
                bArr = null;
            } else {
                byte[][] bArr8 = new byte[length2][];
                int i4 = 0;
                for (com.google.android.libraries.navigation.internal.ma.l lVar5 : arrayList) {
                    if (lVar5 != null && (bArr3 = lVar5.c) != null) {
                        bArr8[i4] = bArr3;
                        i4++;
                    }
                    if (lVar5 != null && (bArr2 = lVar5.i) != null) {
                        int i5 = i;
                        while (i5 < bArr2.length) {
                            bArr8[i4] = bArr2[i5];
                            i5++;
                            i4++;
                        }
                    }
                    i = 0;
                }
                bArr = bArr8;
            }
            boolean z3 = true;
            int length3 = 0;
            for (com.google.android.libraries.navigation.internal.ma.l lVar6 : arrayList) {
                if (lVar6 != null && (iArr5 = lVar6.j) != null) {
                    length3 += iArr5.length;
                    z3 = false;
                }
            }
            if (z3) {
                iArr3 = null;
            } else {
                int[] iArr7 = new int[length3];
                int i6 = 0;
                for (Iterator it3 = arrayList.iterator(); it3.hasNext(); it3 = it3) {
                    com.google.android.libraries.navigation.internal.ma.l lVar7 = (com.google.android.libraries.navigation.internal.ma.l) it3.next();
                    if (lVar7 != null && (iArr4 = lVar7.j) != null) {
                        int i7 = 0;
                        while (i7 < iArr4.length) {
                            iArr7[i6] = iArr4[i7];
                            i7++;
                            i6++;
                        }
                    }
                }
                iArr3 = iArr7;
            }
            boolean z4 = true;
            int length4 = 0;
            for (com.google.android.libraries.navigation.internal.ma.l lVar8 : arrayList) {
                if (lVar8 != null && (bArr6 = lVar8.k) != null) {
                    length4 += bArr6.length;
                    z4 = false;
                }
            }
            if (z4) {
                bArr4 = null;
            } else {
                byte[][] bArr9 = new byte[length4][];
                int i8 = 0;
                for (Iterator it4 = arrayList.iterator(); it4.hasNext(); it4 = it4) {
                    com.google.android.libraries.navigation.internal.ma.l lVar9 = (com.google.android.libraries.navigation.internal.ma.l) it4.next();
                    if (lVar9 != null && (bArr5 = lVar9.k) != null) {
                        for (byte[] bArr10 : bArr5) {
                            if (bArr10 != null) {
                                bArr9[i8] = bArr10;
                                i8++;
                            }
                        }
                    }
                }
                bArr4 = bArr9;
            }
            lVar = new com.google.android.libraries.navigation.internal.ma.l(str3, null, bArrA, bArrA2, bArrA3, bArrA4, iArr, bArr, iArr3, bArr4);
        }
        if (nVar.a.c()) {
            throw new IllegalArgumentException("addExperimentTokens forbidden on deidentified logger");
        }
        if (nVar.g == null) {
            nVar.g = new HashSet();
        }
        nVar.g.addAll(hashSet);
        if (nVar.a.c()) {
            throw new IllegalArgumentException("addExperimentTokens forbidden on deidentified logger");
        }
        if (lVar == null) {
            return;
        }
        if (nVar.e == null) {
            nVar.e = new ArrayList();
        }
        nVar.e.add(lVar);
    }

    public static final void b(i iVar, Object obj, ConcurrentMap concurrentMap) {
        Set set = (Set) concurrentMap.putIfAbsent(obj, new mq(iVar));
        if (set != null) {
            fw fwVar = new fw();
            fwVar.k(set);
            fwVar.c(iVar);
            concurrentMap.put(obj, fwVar.i());
        }
    }
}
