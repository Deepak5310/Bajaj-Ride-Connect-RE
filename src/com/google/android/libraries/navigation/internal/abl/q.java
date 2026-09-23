package com.google.android.libraries.navigation.internal.abl;

import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class q implements Comparator {
    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        n nVar = (n) obj;
        n nVar2 = (n) obj2;
        if (com.google.android.libraries.navigation.internal.afu.d.g()) {
            if (nVar == null && nVar2 == null) {
                return 0;
            }
            if (nVar == null) {
                return -1;
            }
            if (nVar2 == null) {
                return 1;
            }
        }
        return Float.compare(nVar.a(), nVar2.a());
    }
}
