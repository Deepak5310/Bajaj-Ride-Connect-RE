package com.google.android.libraries.navigation.internal.abf;

import com.google.maps.api.android.lib6.common.apiexception.ApiIllegalArgumentException;
import com.google.maps.api.android.lib6.common.apiexception.ApiIllegalStateException;
import com.google.maps.api.android.lib6.common.apiexception.ApiNullPointerException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class t {
    public static void a(boolean z, Object obj) {
        if (z) {
            return;
        }
        s.k(obj, "Developer error message cannot be null.");
        throw new ApiIllegalArgumentException(String.valueOf(obj));
    }

    public static void b(boolean z, Object obj) {
        if (z) {
            return;
        }
        s.k(obj, "Developer error message cannot be null.");
        throw new ApiIllegalStateException(String.valueOf(obj));
    }

    public static void c(Object obj, Object obj2) {
        if (obj == null) {
            throw new ApiNullPointerException((String) obj2);
        }
    }
}
