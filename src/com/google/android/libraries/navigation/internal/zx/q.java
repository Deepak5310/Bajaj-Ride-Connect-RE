package com.google.android.libraries.navigation.internal.zx;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.Typography;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q {
    public static r a(String str) {
        String str2;
        String strSubstring;
        String strSubstring2;
        Charset charset = t.a;
        ar.q(str);
        ar.q(charset);
        int i = 0;
        int i2 = 0;
        while (i2 < str.length() && ":/\\?#".indexOf(str.charAt(i2)) < 0) {
            i2++;
        }
        if (i2 <= 0 || !str.startsWith(":", i2)) {
            str2 = null;
        } else {
            String strSubstring3 = str.substring(0, i2);
            int i3 = i2 + 1;
            str2 = strSubstring3;
            i = i3;
        }
        if (str.startsWith("//", i)) {
            int i4 = i + 2;
            int i5 = i4;
            while (i5 < str.length() && "/\\?#".indexOf(str.charAt(i5)) < 0) {
                i5++;
            }
            int i6 = i5;
            strSubstring = str.substring(i4, i5);
            i = i6;
        } else {
            strSubstring = null;
        }
        int i7 = i;
        while (i7 < str.length() && "?#".indexOf(str.charAt(i7)) < 0) {
            i7++;
        }
        String strSubstring4 = i7 > i ? str.substring(i, i7) : null;
        if (str.startsWith("?", i7)) {
            int i8 = i7 + 1;
            while (i7 < str.length() && str.charAt(i7) != '#') {
                i7++;
            }
            strSubstring2 = str.substring(i8, i7);
        } else {
            strSubstring2 = null;
        }
        String strSubstring5 = str.startsWith("#", i7) ? str.substring(i7 + 1) : null;
        return ((str2 == null || str2.equals(r.b(str2))) && t.a.equals(charset)) ? new r(str2, strSubstring, strSubstring4, strSubstring2, strSubstring5, charset, str) : new r(str2, strSubstring, strSubstring4, strSubstring2, strSubstring5, charset);
    }

    static String b(v vVar, u uVar, Charset charset) {
        ar.q(charset);
        StringBuilder sb = new StringBuilder();
        try {
            Iterator it2 = vVar.u().iterator();
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                sb.append((CharSequence) t.a((String) entry.getKey(), charset));
                if (!"".equals(entry.getValue())) {
                    sb.append('=').append(t.a((String) entry.getValue(), charset));
                }
                if (it2.hasNext()) {
                    sb.append(Typography.amp);
                }
            }
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
