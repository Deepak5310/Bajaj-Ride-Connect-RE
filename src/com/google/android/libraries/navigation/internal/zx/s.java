package com.google.android.libraries.navigation.internal.zx;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.io.Serializable;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class s implements Cloneable, Serializable {
    private static final long serialVersionUID = -8238943980617262692L;
    public final Charset a;
    public String b;
    public String c;
    public String d;
    public String e;
    private v f;

    public s() {
        this.a = t.a;
    }

    public final v a() {
        if (this.f == null) {
            this.f = new v();
        }
        return this.f;
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        s sVar = new s();
        String str = this.b;
        if (str != null) {
            sVar.b = str;
        }
        String str2 = this.c;
        if (str2 != null) {
            sVar.c = str2;
        }
        String str3 = this.d;
        if (str3 != null) {
            sVar.d = str3;
        }
        String str4 = this.e;
        if (str4 != null) {
            sVar.e = str4;
        }
        v vVar = this.f;
        if (vVar != null) {
            sVar.f = vVar.clone();
        }
        return sVar;
    }

    public final String toString() {
        u uVar = u.a;
        String str = this.b;
        String str2 = this.c;
        String str3 = this.d;
        v vVar = this.f;
        String strB = null;
        if (vVar != null && !vVar.A()) {
            strB = q.b(this.f, uVar, this.a);
        }
        return new r(str, str2, str3, strB, this.e, this.a).toString();
    }

    public s(Charset charset) {
        ar.q(charset);
        this.a = charset;
    }
}
