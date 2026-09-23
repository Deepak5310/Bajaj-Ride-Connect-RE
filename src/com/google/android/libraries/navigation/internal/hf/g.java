package com.google.android.libraries.navigation.internal.hf;

import com.google.firebase.crashlytics.internal.common.IdManager;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class g {
    public final Locale a;
    public final NumberFormat b;
    public final NumberFormat c;

    public g(Locale locale) {
        this.a = locale;
        DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance(locale);
        this.b = new DecimalFormat(IdManager.DEFAULT_VERSION_NAME, decimalFormatSymbols);
        this.c = new DecimalFormat("#,###", decimalFormatSymbols);
    }
}
