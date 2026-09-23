package com.google.android.libraries.navigation.internal.mh;

import android.content.ContentResolver;
import android.net.Uri;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public static final e a;

    static {
        Uri uri = d.a;
        a = f.a();
    }

    public static int a(ContentResolver contentResolver) {
        Object obj;
        int i;
        Integer numValueOf;
        e eVar = a;
        m.d(contentResolver);
        synchronized (eVar) {
            ((m) eVar).b(contentResolver);
            obj = ((m) eVar).d;
            i = -1;
            numValueOf = (Integer) m.e(((m) eVar).b, "location:proks_config", -1);
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        String strA = ((m) eVar).a(contentResolver, "location:proks_config");
        if (strA != null) {
            try {
                int i2 = Integer.parseInt(strA);
                numValueOf = Integer.valueOf(i2);
                i = i2;
            } catch (NumberFormatException unused) {
            }
        }
        synchronized (eVar) {
            ((m) eVar).c(obj, ((m) eVar).b, "location:proks_config", numValueOf);
        }
        return i;
    }

    public static long b(ContentResolver contentResolver) {
        Object obj;
        long j;
        Long lValueOf;
        e eVar = a;
        m.d(contentResolver);
        synchronized (eVar) {
            ((m) eVar).b(contentResolver);
            obj = ((m) eVar).d;
            j = 0;
            lValueOf = (Long) m.e(((m) eVar).c, "android_id", 0L);
        }
        if (lValueOf != null) {
            return lValueOf.longValue();
        }
        String strA = ((m) eVar).a(contentResolver, "android_id");
        if (strA != null) {
            try {
                long j2 = Long.parseLong(strA);
                lValueOf = Long.valueOf(j2);
                j = j2;
            } catch (NumberFormatException unused) {
            }
        }
        synchronized (eVar) {
            ((m) eVar).c(obj, ((m) eVar).c, "android_id", lValueOf);
        }
        return j;
    }
}
