package com.google.android.libraries.navigation.internal.zx;

import com.google.android.libraries.navigation.internal.yx.am;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n implements Serializable {
    private static final long serialVersionUID = 0;
    public final String a;
    public final boolean b;
    private final int c;

    public n(String str, int i, boolean z) {
        this.a = str;
        this.c = i;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (am.a(this.a, nVar.a) && this.c == nVar.c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Integer.valueOf(this.c)});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(this.a.length() + 8);
        String str = this.a;
        if (str.indexOf(58) >= 0) {
            sb.append('[');
            sb.append(this.a);
            sb.append(']');
        } else {
            sb.append(str);
        }
        if (this.c >= 0) {
            sb.append(':');
            sb.append(this.c);
        }
        return sb.toString();
    }
}
