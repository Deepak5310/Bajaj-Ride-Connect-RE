package com.google.android.libraries.navigation.internal.yz;

import java.io.Serializable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class cv implements Comparable, Serializable {
    private static final long serialVersionUID = 0;
    final Comparable b;

    public cv(Comparable comparable) {
        this.b = comparable;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(cv cvVar) {
        if (cvVar == ct.a) {
            return 1;
        }
        if (cvVar == cr.a) {
            return -1;
        }
        int iB = lr.b(this.b, cvVar.b);
        return iB != 0 ? iB : Boolean.compare(this instanceof cs, cvVar instanceof cs);
    }

    public Comparable b() {
        return this.b;
    }

    public abstract void c(StringBuilder sb);

    public abstract void d(StringBuilder sb);

    public abstract boolean e(Comparable comparable);

    public final boolean equals(Object obj) {
        if (obj instanceof cv) {
            try {
                if (compareTo((cv) obj) == 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    public abstract int hashCode();
}
