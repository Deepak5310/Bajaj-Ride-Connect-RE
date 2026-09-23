package com.google.android.libraries.navigation.internal.ne;

import java.util.TimeZone;
import org.joda.time.DateTimeZone;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends DateTimeZone {
    a a;
    private final TimeZone b;

    public b(TimeZone timeZone) {
        super(timeZone.getID());
        this.a = new a(Long.MIN_VALUE, Long.MIN_VALUE);
        this.b = timeZone;
    }

    private final long c(long j, boolean z, boolean z2) {
        for (int i = 1; i < 5; i++) {
            long j2 = (((long) ((true != z2 ? -1 : 1) * i)) * 7776000000L) + j;
            if (d(j2) != z) {
                return j2;
            }
        }
        return j;
    }

    private final boolean d(long j) {
        TimeZone timeZone = this.b;
        return timeZone.getOffset(j) != timeZone.getRawOffset();
    }

    final a b(long j) {
        boolean zD = d(j);
        long jC = c(j, zD, true);
        if (jC == j) {
            return null;
        }
        long jC2 = c(j, zD, false);
        if (jC2 != j) {
            return new a(a(jC2, j, !zD), a(j, jC, zD));
        }
        return null;
    }

    @Override // org.joda.time.DateTimeZone
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.b.equals(((b) obj).b);
        }
        return false;
    }

    @Override // org.joda.time.DateTimeZone
    public final String getNameKey(long j) {
        return this.b.getID();
    }

    @Override // org.joda.time.DateTimeZone
    public final int getOffset(long j) {
        return this.b.getOffset(j);
    }

    @Override // org.joda.time.DateTimeZone
    public final int getStandardOffset(long j) {
        return this.b.getRawOffset();
    }

    @Override // org.joda.time.DateTimeZone
    public final int hashCode() {
        return this.b.hashCode();
    }

    @Override // org.joda.time.DateTimeZone
    public final boolean isFixed() {
        return false;
    }

    @Override // org.joda.time.DateTimeZone
    public final long nextTransition(long j) {
        a aVar = this.a;
        if (aVar.a(j)) {
            return aVar.b;
        }
        a aVarB = b(j);
        if (aVarB == null) {
            return j;
        }
        this.a = aVarB;
        return aVarB.b;
    }

    @Override // org.joda.time.DateTimeZone
    public final long previousTransition(long j) {
        long j2;
        a aVar = this.a;
        if (aVar.a(j)) {
            j2 = aVar.a;
        } else {
            a aVarB = b(j);
            if (aVarB == null) {
                return j;
            }
            this.a = aVarB;
            j2 = aVarB.a;
        }
        return j2 - 1;
    }

    final long a(long j, long j2, boolean z) {
        if (j2 <= j) {
            throw new AssertionError("upperBound must be greater than instant");
        }
        if (z == d(j2)) {
            throw new AssertionError("instant and upperBound must have different time zone offsets");
        }
        long j3 = j / 1000;
        long j4 = j2 / 1000;
        do {
            long j5 = (j4 + j3) / 2;
            boolean zD = d(j5 * 1000);
            if (zD != z) {
                j4 = j5;
            }
            if (zD == z) {
                j3 = j5;
            }
        } while (j4 - j3 > 1);
        long j6 = j3 * 1000;
        return d(j6) == z ? j4 * 1000 : j6;
    }
}
