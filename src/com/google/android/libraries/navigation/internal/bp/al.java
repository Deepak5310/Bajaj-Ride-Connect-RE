package com.google.android.libraries.navigation.internal.bp;

import j$.time.Duration;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class al implements an {
    static final al a = new al();

    private al() {
    }

    @Override // com.google.android.libraries.navigation.internal.bp.an
    public final /* bridge */ /* synthetic */ double a(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        Duration duration = (Duration) comparable;
        Duration duration2 = (Duration) comparable2;
        Duration duration3 = (Duration) comparable3;
        if (com.google.android.libraries.navigation.internal.yx.am.a(duration, duration2)) {
            return 0.0d;
        }
        return com.google.android.libraries.navigation.internal.aaa.a.a(duration3.minus(duration)) / com.google.android.libraries.navigation.internal.aaa.a.a(duration2.minus(duration));
    }

    @Override // com.google.android.libraries.navigation.internal.bp.an
    public final /* synthetic */ am b(Comparable comparable) {
        return new am(0, (Duration) comparable, false);
    }

    @Override // com.google.android.libraries.navigation.internal.bp.an
    public final /* synthetic */ Comparable c(am amVar) {
        return amVar.b;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.an
    public final /* bridge */ /* synthetic */ Comparable d(Comparable comparable, Comparable comparable2, double d) {
        Duration duration = (Duration) comparable;
        Duration durationMinus = ((Duration) comparable2).minus(duration);
        if (Double.isNaN(d)) {
            throw new ArithmeticException("Cannot multiply a duration by NaN");
        }
        if (Double.isInfinite(d)) {
            throw new ArithmeticException("result does not fit into the range of a Duration");
        }
        BigDecimal bigDecimalMultiply = BigDecimal.valueOf(durationMinus.getSeconds()).add(BigDecimal.valueOf(durationMinus.getNano(), 9)).multiply(new BigDecimal(d));
        if (bigDecimalMultiply.compareTo(BigDecimal.valueOf(9.223372036854776E18d)) >= 0 || bigDecimalMultiply.compareTo(BigDecimal.valueOf(com.google.android.libraries.navigation.internal.aaa.a.b)) <= 0) {
            throw new ArithmeticException("result does not fit into the range of a Duration");
        }
        long jLongValue = bigDecimalMultiply.longValue();
        return duration.plus(Duration.ofSeconds(jLongValue, bigDecimalMultiply.subtract(BigDecimal.valueOf(jLongValue)).setScale(9, RoundingMode.HALF_EVEN).unscaledValue().longValue()));
    }

    @Override // com.google.android.libraries.navigation.internal.bp.an
    public final boolean e() {
        return false;
    }
}
