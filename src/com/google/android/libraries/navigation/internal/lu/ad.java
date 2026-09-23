package com.google.android.libraries.navigation.internal.lu;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ad {
    public static final DecimalFormat a = new DecimalFormat(".000000", DecimalFormatSymbols.getInstance(Locale.ROOT));
    public static final DecimalFormat b;

    static {
        DecimalFormat decimalFormat = new DecimalFormat(".##", DecimalFormatSymbols.getInstance(Locale.ROOT));
        b = decimalFormat;
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
    }
}
