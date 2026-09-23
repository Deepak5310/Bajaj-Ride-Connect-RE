package com.google.android.libraries.navigation.internal.zd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum b {
    STRING('s', d.GENERAL, "-#", true),
    BOOLEAN('b', d.BOOLEAN, "-", true),
    CHAR('c', d.CHARACTER, "-", true),
    DECIMAL('d', d.INTEGRAL, "-0+ ,(", false),
    OCTAL('o', d.INTEGRAL, "-#0(", false),
    HEX('x', d.INTEGRAL, "-#0(", true),
    FLOAT('f', d.FLOAT, "-#0+ ,(", false),
    EXPONENT('e', d.FLOAT, "-#0+ (", true),
    GENERAL('g', d.FLOAT, "-0+ ,(", true),
    EXPONENT_HEX('a', d.FLOAT, "-#0+ ", true);

    public static final b[] k = new b[26];
    public final char l;
    public final d m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f661n;
    public final String o;

    static {
        for (b bVar : values()) {
            k[a(bVar.l)] = bVar;
        }
    }

    b(char c, d dVar, String str, boolean z) {
        this.l = c;
        this.m = dVar;
        int i = true != z ? 0 : 128;
        for (int i2 = 0; i2 < str.length(); i2++) {
            int iA = c.a(str.charAt(i2));
            if (iA < 0) {
                throw new IllegalArgumentException("invalid flags: ".concat(str));
            }
            i |= 1 << iA;
        }
        this.f661n = i;
        this.o = "%" + c;
    }

    public static int a(char c) {
        return (c | ' ') - 97;
    }
}
