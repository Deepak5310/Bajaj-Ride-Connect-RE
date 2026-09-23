package com.google.android.libraries.navigation.internal.hx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ah {
    static void a(String str, String str2) {
        if (str.length() > 15) {
            throw new IllegalArgumentException(String.format("Thread name %s can't be longer than the systrace limit of %d.", str, 15));
        }
    }
}
