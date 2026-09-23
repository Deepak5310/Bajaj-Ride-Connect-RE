package com.google.android.libraries.navigation.internal.tc;

import com.google.android.libraries.navigation.internal.yz.lo;
import com.google.android.libraries.navigation.internal.yz.md;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c extends lo {
    final /* synthetic */ d a;

    public c(d dVar) {
        this.a = dVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.lo, java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final synchronized int compare(String str, String str2) {
        return md.a.compare(Integer.valueOf(this.a.a.b(str)), Integer.valueOf(this.a.a.b(str2)));
    }
}
