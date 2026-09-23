package com.google.android.libraries.navigation.internal.zx;

import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.kp;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class r implements Comparable, Serializable {
    private static final long serialVersionUID = -1105194233979842380L;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public transient Charset e;
    volatile transient String f;
    private final String g;
    private volatile transient v h;

    public r(String str, String str2, String str3, String str4, String str5, Charset charset) {
        this.a = b(str);
        this.b = str2;
        this.c = str3;
        this.g = str4;
        this.d = str5;
        this.e = charset;
    }

    public r(String str, String str2, String str3, String str4, String str5, Charset charset, String str6) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.g = str4;
        this.d = str5;
        this.e = charset;
        this.f = str6;
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase(Locale.ENGLISH);
    }

    private static String c(String str, String str2) {
        return str != null ? str2 : "";
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.e = Charset.forName((String) Objects.requireNonNull(objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.e.name());
    }

    public final v a() {
        v vVar;
        if (this.h == null) {
            String str = this.g;
            if (str == null) {
                vVar = v.a;
            } else {
                Charset charset = this.e;
                ar.q(str);
                ar.q(charset);
                v vVar2 = new v();
                if (!str.isEmpty()) {
                    String strName = charset.name();
                    int length = strName.length();
                    int i = 0;
                    boolean z = true;
                    if ((length < 9 || !strName.regionMatches(true, length - 9, "SHIFT_JIS", 0, 9)) && (length < 11 || !strName.regionMatches(true, length - 11, "WINDOWS-31J", 0, 11))) {
                        z = false;
                    }
                    while (i <= str.length()) {
                        int iIndexOf = str.indexOf(38, i);
                        if (iIndexOf == -1) {
                            iIndexOf = str.length();
                        }
                        int iIndexOf2 = str.indexOf(61, i);
                        if (iIndexOf2 > iIndexOf) {
                            iIndexOf2 = -1;
                        }
                        vVar2.t(v.f(str, i, iIndexOf2 == -1 ? iIndexOf : iIndexOf2, charset, z), iIndexOf2 == -1 ? "" : v.f(str, iIndexOf2 + 1, iIndexOf, charset, z));
                        i = iIndexOf + 1;
                    }
                }
                vVar = new v(new kp(vVar2.b));
            }
            this.h = vVar;
        }
        return this.h;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        r rVar = (r) obj;
        ar.q(rVar);
        return toString().compareTo(rVar.toString());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final String toString() {
        if (this.f != null) {
            return this.f;
        }
        String str = this.a;
        String str2 = this.b;
        String str3 = this.c;
        String str4 = this.g;
        String str5 = this.d;
        String str6 = aq.b(str) + c(str, ":") + c(str2, "//") + aq.b(str2) + aq.b(str3) + c(str4, "?") + aq.b(str4) + c(str5, "#") + aq.b(str5);
        this.f = str6;
        return str6;
    }
}
