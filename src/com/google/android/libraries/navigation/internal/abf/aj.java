package com.google.android.libraries.navigation.internal.abf;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aj {
    private final String a;
    private final ai b;
    private ai c;

    private aj(String str) {
        ai aiVar = new ai();
        this.b = aiVar;
        this.c = aiVar;
        s.j(str);
        this.a = str;
    }

    public static aj f(Object obj) {
        return new aj(obj.getClass().getSimpleName());
    }

    public final aj a(String str, double d) {
        g(str, String.valueOf(d));
        return this;
    }

    public final aj b(String str, float f) {
        g(str, String.valueOf(f));
        return this;
    }

    public final aj c(String str, int i) {
        g(str, String.valueOf(i));
        return this;
    }

    public final aj d(String str, long j) {
        g(str, String.valueOf(j));
        return this;
    }

    public final aj e(String str, boolean z) {
        g(str, String.valueOf(z));
        return this;
    }

    public final void g(String str, Object obj) {
        ai aiVar = new ai();
        this.c.c = aiVar;
        this.c = aiVar;
        aiVar.b = obj;
        s.j(str);
        aiVar.a = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.a);
        sb.append('{');
        ai aiVar = this.b.c;
        String str = "";
        while (aiVar != null) {
            Object obj = aiVar.b;
            sb.append(str);
            String str2 = aiVar.a;
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
            aiVar = aiVar.c;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }
}
