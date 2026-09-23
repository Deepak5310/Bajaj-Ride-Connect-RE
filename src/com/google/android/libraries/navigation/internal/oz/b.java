package com.google.android.libraries.navigation.internal.oz;

import com.google.android.libraries.navigation.internal.adg.hg;
import com.google.android.libraries.navigation.internal.zy.k;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements Comparable {
    public final hg a;

    public b(hg hgVar) {
        this.a = hgVar;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Long.compare(this.a.f, ((b) obj).a.f);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof b) && ((b) obj).a.f == this.a.f;
    }

    public final int hashCode() {
        return k.a(this.a.f);
    }
}
