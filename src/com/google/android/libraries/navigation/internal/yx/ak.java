package com.google.android.libraries.navigation.internal.yx;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ak {
    private final String a;
    private final aj b;
    private aj c;
    private boolean d;

    public ak(String str) {
        aj ajVar = new aj();
        this.b = ajVar;
        this.c = ajVar;
        this.d = false;
        ar.q(str);
        this.a = str;
    }

    private final aj i() {
        aj ajVar = new aj();
        this.c.c = ajVar;
        this.c = ajVar;
        return ajVar;
    }

    private final void j(String str, Object obj) {
        ai aiVar = new ai();
        this.c.c = aiVar;
        this.c = aiVar;
        aiVar.b = obj;
        aiVar.a = str;
    }

    public final ak a(String str, double d) {
        j(str, String.valueOf(d));
        return this;
    }

    public final ak b(String str, float f) {
        j(str, String.valueOf(f));
        return this;
    }

    public final ak c(String str, int i) {
        j(str, String.valueOf(i));
        return this;
    }

    public final ak d(String str, long j) {
        j(str, String.valueOf(j));
        return this;
    }

    public final ak e(String str, boolean z) {
        j(str, String.valueOf(z));
        return this;
    }

    public final void f(Object obj) {
        i().b = obj;
    }

    public final void g(String str, Object obj) {
        aj ajVarI = i();
        ajVarI.b = obj;
        ar.q(str);
        ajVarI.a = str;
    }

    public final void h() {
        this.d = true;
    }

    public final String toString() {
        boolean z = this.d;
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.a);
        sb.append('{');
        String str = "";
        for (aj ajVar = this.b.c; ajVar != null; ajVar = ajVar.c) {
            boolean z2 = ajVar instanceof ai;
            Object obj = ajVar.b;
            if (z2 || obj != null || !z) {
                sb.append(str);
                String str2 = ajVar.a;
                if (str2 != null) {
                    sb.append(str2);
                    sb.append('=');
                }
                if (obj == null || !obj.getClass().isArray()) {
                    sb.append(obj);
                } else {
                    String strDeepToString = Arrays.deepToString(new Object[]{obj});
                    sb.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
                }
                str = ", ";
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
