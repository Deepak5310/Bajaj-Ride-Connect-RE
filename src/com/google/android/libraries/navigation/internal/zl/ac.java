package com.google.android.libraries.navigation.internal.zl;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ac extends b implements Serializable {
    private static final long serialVersionUID = 0;
    private final int a;
    private final int b;
    private final long c;
    private final long d;

    static {
        new ac(506097522914230528L, 1084818905618843912L);
    }

    public ac(long j, long j2) {
        ar.d(true, "The number of SipRound iterations (c=%s) during Compression must be positive.", 2);
        ar.d(true, "The number of SipRound iterations (d=%s) during Finalization must be positive.", 4);
        this.a = 2;
        this.b = 4;
        this.c = j;
        this.d = j2;
    }

    @Override // com.google.android.libraries.navigation.internal.zl.m
    public final n e() {
        return new ab(this.c, this.d);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ac) {
            ac acVar = (ac) obj;
            int i = acVar.a;
            int i2 = acVar.b;
            if (this.c == acVar.c && this.d == acVar.d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (int) ((((long) (getClass().hashCode() ^ 6)) ^ this.c) ^ this.d);
    }

    public final String toString() {
        return "Hashing.sipHash24(" + this.c + ", " + this.d + ")";
    }
}
