package com.google.android.libraries.navigation.internal.kp;

import com.google.android.libraries.navigation.internal.agi.ef;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements a {
    public final String a;
    public final ef b = new ef();
    public long c;

    public f(String str) {
        this.a = str;
    }

    public final f a(String str, double d) {
        m(str, Double.toString(d));
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.kp.a
    public final long b() {
        return this.c;
    }

    public final f c(String str, float f) {
        m(str, Float.toString(f));
        return this;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Long.compare(this.c, ((a) obj).b());
    }

    @Override // com.google.android.libraries.navigation.internal.kp.a
    public final /* synthetic */ String d() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.kp.a
    public final /* synthetic */ boolean e() {
        return false;
    }

    public final f f(String str, int i) {
        m(str, Integer.toString(i));
        return this;
    }

    public final f g(String str, long j) {
        m(str, Long.toString(j));
        return this;
    }

    public final f h(String str, boolean z) {
        m(str, Boolean.toString(z));
        return this;
    }

    public final f i(String str, double d) {
        return Double.isNaN(d) ? this : a(str, d);
    }

    public final f j(String str, float f) {
        return Float.isNaN(f) ? this : c(str, f);
    }

    public final f k(String str, String str2) {
        if (str2 == null) {
            return this;
        }
        m(str, str2);
        return this;
    }

    public final f l(String str, boolean z) {
        return z ? h(str, true) : this;
    }

    public final void m(String str, String str2) {
        this.b.put(str, str2);
    }

    @Override // com.google.android.libraries.navigation.internal.kp.a
    public final f n() {
        return this;
    }
}
