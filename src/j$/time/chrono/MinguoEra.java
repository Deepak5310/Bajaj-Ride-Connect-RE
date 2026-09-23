package j$.time.chrono;

import j$.time.DateTimeException;

/* JADX INFO: loaded from: classes8.dex */
public enum MinguoEra implements Era {
    BEFORE_ROC,
    ROC;

    public static MinguoEra of(int i) {
        if (i == 0) {
            return BEFORE_ROC;
        }
        if (i == 1) {
            return ROC;
        }
        throw new DateTimeException("Invalid era: " + i);
    }

    @Override // j$.time.chrono.Era
    public int getValue() {
        return ordinal();
    }
}
