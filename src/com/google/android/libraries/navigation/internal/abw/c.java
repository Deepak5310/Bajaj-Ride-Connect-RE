package com.google.android.libraries.navigation.internal.abw;

import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c implements Comparator {
    public static final c a = new c();

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        b bVar = (b) obj;
        b bVar2 = (b) obj2;
        if (bVar == null && bVar2 == null) {
            return 0;
        }
        if (bVar != null) {
            if (bVar2 != null) {
                long j = bVar2.c;
                long j2 = bVar.c;
                if (j2 >= j) {
                    if (j2 <= j) {
                        return bVar.b.compareTo(bVar2.b);
                    }
                }
            }
            return 1;
        }
        return -1;
    }
}
