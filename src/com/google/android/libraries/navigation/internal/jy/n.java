package com.google.android.libraries.navigation.internal.jy;

import com.google.android.libraries.navigation.internal.yx.an;
import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class n implements Serializable {
    private final String a;

    public n(String str) {
        this.a = str;
    }

    public final an a() {
        return an.i(this.a);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof n) {
            return a().equals(((n) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return a().hashCode();
    }

    public final String toString() {
        return a().toString();
    }
}
