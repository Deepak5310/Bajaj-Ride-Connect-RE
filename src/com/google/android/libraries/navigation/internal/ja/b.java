package com.google.android.libraries.navigation.internal.ja;

import j$.time.DateTimeException;
import j$.time.ZoneId;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static ZoneId a(String str) {
        try {
            return ZoneId.of(str);
        } catch (DateTimeException unused) {
            return null;
        }
    }
}
