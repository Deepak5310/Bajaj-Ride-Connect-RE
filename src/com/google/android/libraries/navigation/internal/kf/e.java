package com.google.android.libraries.navigation.internal.kf;

import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class e {
    public abstract int a();

    public abstract long b();

    public final String toString() {
        return "http://go/veat/" + a() + " @ " + SimpleDateFormat.getDateTimeInstance().format(new Date(b()));
    }
}
