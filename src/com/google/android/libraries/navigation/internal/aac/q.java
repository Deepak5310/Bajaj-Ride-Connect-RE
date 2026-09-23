package com.google.android.libraries.navigation.internal.aac;

import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class q extends o {
    @Override // com.google.android.libraries.navigation.internal.aac.o
    public final int a(r rVar) {
        int i;
        synchronized (rVar) {
            i = rVar.remaining - 1;
            rVar.remaining = i;
        }
        return i;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.o
    public final void b(r rVar, Set set) {
        synchronized (rVar) {
            if (rVar.seenExceptions == null) {
                rVar.seenExceptions = set;
            }
        }
    }
}
