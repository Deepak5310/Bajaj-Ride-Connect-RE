package com.google.android.libraries.navigation.internal.afx;

import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cf implements Comparator {
    final /* synthetic */ cg a;

    public cf(cg cgVar) {
        this.a = cgVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        cg cgVar = this.a;
        cgVar.a(obj);
        cgVar.a(obj2);
        return obj.getClass().getName().compareTo(obj2.getClass().getName());
    }
}
