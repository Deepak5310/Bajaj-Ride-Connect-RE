package com.google.android.libraries.navigation.internal.afn;

import org.xml.sax.Attributes;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class k {
    n a;
    Attributes b;

    public k(Attributes attributes) {
        this.a = null;
        this.b = attributes;
        String strD = o.d("style", attributes);
        if (strD != null) {
            this.a = new n(strD);
        }
    }

    public final Float a(String str) {
        String strC = c(str);
        if (strC == null) {
            return null;
        }
        try {
            return Float.valueOf(Float.parseFloat(strC));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public final Integer b(String str) {
        String strC = c(str);
        if (strC == null) {
            return null;
        }
        if (!strC.startsWith("#") || (strC.length() != 4 && strC.length() != 7)) {
            return (Integer) c.a.get(strC);
        }
        try {
            int i = Integer.parseInt(strC.substring(1), 16);
            if (strC.length() == 4) {
                int i2 = i & 3840;
                int i3 = i & 240;
                int i4 = i & 15;
                i = i4 | (i2 << 12) | (i2 << 8) | (i3 << 4) | (i3 << 8) | (i4 << 4);
            }
            return Integer.valueOf(i);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public final String c(String str) {
        n nVar = this.a;
        String strA = nVar != null ? nVar.a(str) : null;
        return strA == null ? o.d(str, this.b) : strA;
    }
}
