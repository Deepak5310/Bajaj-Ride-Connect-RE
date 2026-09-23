package com.google.android.libraries.navigation.internal.dt;

import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'a' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static final a a;
    public static final a b;
    public static final a c;
    public static final a d;
    private static final /* synthetic */ a[] g;
    public final fd e;
    public final fd f;

    static {
        int i = com.google.android.libraries.navigation.internal.du.c.h;
        int i2 = com.google.android.libraries.navigation.internal.du.c.r;
        int i3 = com.google.android.libraries.navigation.internal.du.c.v;
        int i4 = com.google.android.libraries.navigation.internal.du.c.j;
        int i5 = com.google.android.libraries.navigation.internal.du.c.f414n;
        int i6 = com.google.android.libraries.navigation.internal.du.c.h;
        int i7 = com.google.android.libraries.navigation.internal.du.c.t;
        int i8 = com.google.android.libraries.navigation.internal.du.c.x;
        int i9 = com.google.android.libraries.navigation.internal.du.c.l;
        int i10 = com.google.android.libraries.navigation.internal.du.c.p;
        a aVar = new a("DEFAULT_CONE", 0, i, i2, i3, i4, i5, i5, i6, i7, i8, i9, i10, i10);
        a = aVar;
        int i11 = com.google.android.libraries.navigation.internal.du.c.i;
        int i12 = com.google.android.libraries.navigation.internal.du.c.s;
        int i13 = com.google.android.libraries.navigation.internal.du.c.w;
        int i14 = com.google.android.libraries.navigation.internal.du.c.k;
        int i15 = com.google.android.libraries.navigation.internal.du.c.o;
        int i16 = com.google.android.libraries.navigation.internal.du.c.u;
        int i17 = com.google.android.libraries.navigation.internal.du.c.y;
        int i18 = com.google.android.libraries.navigation.internal.du.c.m;
        int i19 = com.google.android.libraries.navigation.internal.du.c.q;
        a aVar2 = new a("CONE_MAP_COLORS2", 1, i11, i12, i13, i14, i15, i15, i11, i16, i17, i18, i19, i19);
        b = aVar2;
        int i20 = com.google.android.libraries.navigation.internal.du.c.ao;
        int i21 = com.google.android.libraries.navigation.internal.du.c.at;
        int i22 = com.google.android.libraries.navigation.internal.du.c.av;
        int i23 = com.google.android.libraries.navigation.internal.du.c.ap;
        int i24 = com.google.android.libraries.navigation.internal.du.c.ar;
        int i25 = com.google.android.libraries.navigation.internal.du.c.au;
        int i26 = com.google.android.libraries.navigation.internal.du.c.aw;
        int i27 = com.google.android.libraries.navigation.internal.du.c.aq;
        int i28 = com.google.android.libraries.navigation.internal.du.c.as;
        a aVar3 = new a("TRAVEL_MODE_CONE", 2, i20, i21, i22, i23, i24, i24, i20, i25, i26, i27, i28, i28);
        c = aVar3;
        int i29 = com.google.android.libraries.navigation.internal.du.c.P;
        int i30 = com.google.android.libraries.navigation.internal.du.c.U;
        int i31 = com.google.android.libraries.navigation.internal.du.c.W;
        int i32 = com.google.android.libraries.navigation.internal.du.c.Q;
        int i33 = com.google.android.libraries.navigation.internal.du.c.S;
        int i34 = com.google.android.libraries.navigation.internal.du.c.V;
        int i35 = com.google.android.libraries.navigation.internal.du.c.X;
        int i36 = com.google.android.libraries.navigation.internal.du.c.R;
        int i37 = com.google.android.libraries.navigation.internal.du.c.T;
        a aVar4 = new a("INCOGNITO_CONE", 3, i29, i30, i31, i32, i33, i33, i29, i34, i35, i36, i37, i37);
        d = aVar4;
        g = new a[]{aVar, aVar2, aVar3, aVar4};
    }

    private a(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        super(str, i);
        ez ezVar = new ez();
        ezVar.f(4, Integer.valueOf(i2));
        ezVar.f(3, Integer.valueOf(i3));
        ezVar.f(2, Integer.valueOf(i4));
        ezVar.f(1, Integer.valueOf(i5));
        ezVar.f(0, Integer.valueOf(i6));
        ezVar.f(-1, Integer.valueOf(i7));
        this.e = ezVar.d();
        ez ezVar2 = new ez();
        ezVar2.f(4, Integer.valueOf(i8));
        ezVar2.f(3, Integer.valueOf(i9));
        ezVar2.f(2, Integer.valueOf(i10));
        ezVar2.f(1, Integer.valueOf(i11));
        ezVar2.f(0, Integer.valueOf(i12));
        ezVar2.f(-1, Integer.valueOf(i13));
        this.f = ezVar2.d();
    }

    public static a[] values() {
        return (a[]) g.clone();
    }
}
