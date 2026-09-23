package com.google.android.libraries.navigation.internal.tu;

import java.io.File;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class l implements Comparable {
    final File a;
    final long b;

    public l(File file) {
        this.a = file;
        this.b = file.lastModified();
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        long j = ((l) obj).b;
        long j2 = this.b;
        if (j2 < j) {
            return -1;
        }
        return j2 == j ? 0 : 1;
    }
}
