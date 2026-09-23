package com.google.android.libraries.navigation.internal.ai;

import com.google.android.libraries.navigation.internal.af.e;
import com.google.android.libraries.navigation.internal.jy.aa;
import com.google.android.libraries.navigation.internal.jy.p;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.nc.ah;
import com.google.android.libraries.navigation.internal.nc.aj;
import com.google.android.libraries.navigation.internal.nc.ap;
import com.google.android.libraries.navigation.internal.nc.j;
import com.google.android.libraries.navigation.internal.nc.x;
import com.google.android.libraries.navigation.internal.w.d;
import kotlin.Deprecated;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public interface b extends cs {

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'a' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:160)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: PG */
    public final class a {

        @Deprecated(message = "Use NO_TINT_DAY_NIGHT_ON_WHITE instead")
        public static final a a;

        @Deprecated(message = "Use NO_TINT_DAY_NIGHT_ON_WHITE_WITH_GREY_SHADOW instead")
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        public static final a g;
        public static final a h;
        public static final a i;
        public static final a j;
        public static final a k;
        public static final a l;
        public static final a m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final a f340n;
        public static final a o;
        public static final a p;
        private static final /* synthetic */ a[] s;
        public final ah q;
        public final x r;

        static {
            ah FAB_WHITE_DAY_NIGHT_BACKGROUND = com.google.android.libraries.navigation.internal.z.a.b;
            Intrinsics.checkNotNullExpressionValue(FAB_WHITE_DAY_NIGHT_BACKGROUND, "FAB_WHITE_DAY_NIGHT_BACKGROUND");
            a aVar = new a("NO_TINT_ON_WHITE", 0, FAB_WHITE_DAY_NIGHT_BACKGROUND);
            a = aVar;
            ah FAB_WHITE_DAY_NIGHT_BACKGROUND_WITH_GREY_SHADOW = com.google.android.libraries.navigation.internal.z.a.d;
            Intrinsics.checkNotNullExpressionValue(FAB_WHITE_DAY_NIGHT_BACKGROUND_WITH_GREY_SHADOW, "FAB_WHITE_DAY_NIGHT_BACKGROUND_WITH_GREY_SHADOW");
            a aVar2 = new a("NO_TINT_ON_WHITE_WITH_GREY_SHADOW", 1, FAB_WHITE_DAY_NIGHT_BACKGROUND_WITH_GREY_SHADOW);
            b = aVar2;
            ah FAB_NIGHT_BACKGROUND_WITH_WHITE_SHADOW = com.google.android.libraries.navigation.internal.z.a.f;
            Intrinsics.checkNotNullExpressionValue(FAB_NIGHT_BACKGROUND_WITH_WHITE_SHADOW, "FAB_NIGHT_BACKGROUND_WITH_WHITE_SHADOW");
            a aVar3 = new a("NO_TINT_ON_BLACK_WITH_WHITE_SHADOW", 2, FAB_NIGHT_BACKGROUND_WITH_WHITE_SHADOW);
            c = aVar3;
            ah FAB_NIGHT_BACKGROUND_WITH_WHITE_SHADOW2 = com.google.android.libraries.navigation.internal.z.a.f;
            Intrinsics.checkNotNullExpressionValue(FAB_NIGHT_BACKGROUND_WITH_WHITE_SHADOW2, "FAB_NIGHT_BACKGROUND_WITH_WHITE_SHADOW");
            a aVar4 = new a("MOD_GREY_ON_NIGHTBLACK_WITH_WHITE_SHADOW", 3, FAB_NIGHT_BACKGROUND_WITH_WHITE_SHADOW2, com.google.android.libraries.navigation.internal.w.a.f());
            d = aVar4;
            ah FAB_DARK_BACKGROUND_WITH_WHITE_SHADOW = com.google.android.libraries.navigation.internal.z.a.g;
            Intrinsics.checkNotNullExpressionValue(FAB_DARK_BACKGROUND_WITH_WHITE_SHADOW, "FAB_DARK_BACKGROUND_WITH_WHITE_SHADOW");
            a aVar5 = new a("MOD_GREY_ON_DARK_GREY_WITH_WHITE_SHADOW", 4, FAB_DARK_BACKGROUND_WITH_WHITE_SHADOW, com.google.android.libraries.navigation.internal.w.a.g());
            e = aVar5;
            ah FAB_DARK_BACKGROUND_WITH_WHITE_SHADOW2 = com.google.android.libraries.navigation.internal.z.a.g;
            Intrinsics.checkNotNullExpressionValue(FAB_DARK_BACKGROUND_WITH_WHITE_SHADOW2, "FAB_DARK_BACKGROUND_WITH_WHITE_SHADOW");
            a aVar6 = new a("NO_TINT_ON_DARK_GREY_WITH_WHITE_SHADOW", 5, FAB_DARK_BACKGROUND_WITH_WHITE_SHADOW2);
            f = aVar6;
            ah FAB_WHITE_BACKGROUND_WITH_GREY_SHADOW = com.google.android.libraries.navigation.internal.z.a.c;
            Intrinsics.checkNotNullExpressionValue(FAB_WHITE_BACKGROUND_WITH_GREY_SHADOW, "FAB_WHITE_BACKGROUND_WITH_GREY_SHADOW");
            a aVar7 = new a("WHITE_BACKGROUND_WITH_GREY_SHADOW", 6, FAB_WHITE_BACKGROUND_WITH_GREY_SHADOW);
            g = aVar7;
            ah ahVarC = aj.c();
            Intrinsics.checkNotNullExpressionValue(ahVarC, "emptyDrawable(...)");
            a aVar8 = new a("NO_TINT_ON_TRANSPARENT", 7, ahVarC);
            h = aVar8;
            int i2 = d.a;
            ah ahVarC2 = com.google.android.libraries.navigation.internal.m.b.c(com.google.android.libraries.navigation.internal.w.b.b(), e.b(com.google.android.libraries.navigation.internal.w.a.r(), j.f(com.google.android.libraries.navigation.internal.v.a.C)), com.google.android.libraries.navigation.internal.m.b.e);
            Intrinsics.checkNotNullExpressionValue(ahVarC2, "modFabWhiteDayNightBackground(...)");
            a aVar9 = new a("NO_TINT_MOD_DAY_NIGHT_WHITE", 8, ahVarC2);
            i = aVar9;
            ah FAB_WHITE_DAY_NIGHT_BACKGROUND2 = com.google.android.libraries.navigation.internal.z.a.b;
            Intrinsics.checkNotNullExpressionValue(FAB_WHITE_DAY_NIGHT_BACKGROUND2, "FAB_WHITE_DAY_NIGHT_BACKGROUND");
            a aVar10 = new a("NO_TINT_DAY_NIGHT_ON_WHITE", 9, FAB_WHITE_DAY_NIGHT_BACKGROUND2);
            j = aVar10;
            ah FAB_WHITE_DAY_NIGHT_BACKGROUND_WITH_GREY_SHADOW2 = com.google.android.libraries.navigation.internal.z.a.d;
            Intrinsics.checkNotNullExpressionValue(FAB_WHITE_DAY_NIGHT_BACKGROUND_WITH_GREY_SHADOW2, "FAB_WHITE_DAY_NIGHT_BACKGROUND_WITH_GREY_SHADOW");
            a aVar11 = new a("NO_TINT_DAY_NIGHT_ON_WHITE_WITH_GREY_SHADOW", 10, FAB_WHITE_DAY_NIGHT_BACKGROUND_WITH_GREY_SHADOW2);
            k = aVar11;
            ah FAB_WHITE_DAY_NIGHT_BACKGROUND_WITH_WHITE_SHADOW = com.google.android.libraries.navigation.internal.z.a.e;
            Intrinsics.checkNotNullExpressionValue(FAB_WHITE_DAY_NIGHT_BACKGROUND_WITH_WHITE_SHADOW, "FAB_WHITE_DAY_NIGHT_BACKGROUND_WITH_WHITE_SHADOW");
            a aVar12 = new a("NO_TINT_DAY_NIGHT_ON_WHITE_WITH_WHITE_SHADOW", 11, FAB_WHITE_DAY_NIGHT_BACKGROUND_WITH_WHITE_SHADOW);
            l = aVar12;
            ah ahVarC3 = com.google.android.libraries.navigation.internal.m.b.c(com.google.android.libraries.navigation.internal.ju.d.a, com.google.android.libraries.navigation.internal.ju.b.i, com.google.android.libraries.navigation.internal.m.b.e);
            Intrinsics.checkNotNullExpressionValue(ahVarC3, "ripple(...)");
            a aVar13 = new a("MOD_DAY_NIGHT_WHITE_ON_BLUE", 12, ahVarC3, com.google.android.libraries.navigation.internal.ju.b.e);
            m = aVar13;
            ah FAB_LIGHT_BLUE_DAY_NIGHT_GREY_BACKGROUND = com.google.android.libraries.navigation.internal.z.a.h;
            Intrinsics.checkNotNullExpressionValue(FAB_LIGHT_BLUE_DAY_NIGHT_GREY_BACKGROUND, "FAB_LIGHT_BLUE_DAY_NIGHT_GREY_BACKGROUND");
            a aVar14 = new a("DAY_NIGHT_GREY_ON_LIGHT_BLUE_GREY", 13, FAB_LIGHT_BLUE_DAY_NIGHT_GREY_BACKGROUND, e.b(com.google.android.libraries.navigation.internal.w.a.i(), com.google.android.libraries.navigation.internal.w.a.i()));
            f340n = aVar14;
            ah FAB_WHITE_DAY_NIGHT_BACKGROUND3 = com.google.android.libraries.navigation.internal.z.a.b;
            Intrinsics.checkNotNullExpressionValue(FAB_WHITE_DAY_NIGHT_BACKGROUND3, "FAB_WHITE_DAY_NIGHT_BACKGROUND");
            a aVar15 = new a("DAY_NIGHT_BLUE_ON_WHITE", 14, FAB_WHITE_DAY_NIGHT_BACKGROUND3, com.google.android.libraries.navigation.internal.ju.b.f);
            o = aVar15;
            ah FAB_WHITE_DAY_NIGHT_BACKGROUND4 = com.google.android.libraries.navigation.internal.z.a.b;
            Intrinsics.checkNotNullExpressionValue(FAB_WHITE_DAY_NIGHT_BACKGROUND4, "FAB_WHITE_DAY_NIGHT_BACKGROUND");
            a aVar16 = new a("DAY_NIGHT_RED_ON_WHITE", 15, FAB_WHITE_DAY_NIGHT_BACKGROUND4, e.b(com.google.android.libraries.navigation.internal.w.a.o(), j.f(com.google.android.libraries.navigation.internal.v.a.t)));
            p = aVar16;
            a[] aVarArr = {aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10, aVar11, aVar12, aVar13, aVar14, aVar15, aVar16};
            s = aVarArr;
            EnumEntriesKt.enumEntries(aVarArr);
        }

        private a(String str, int i2, ah ahVar, x xVar) {
            super(str, i2);
            this.q = ahVar;
            this.r = xVar;
        }

        public static a[] values() {
            return (a[]) s.clone();
        }

        public /* synthetic */ a(String str, int i2, ah ahVar) {
            this(str, i2, ahVar, null);
        }
    }

    float a();

    float b();

    int c();

    int d();

    aa e();

    com.google.android.libraries.navigation.internal.ms.c f();

    cs.a g();

    ah h();

    ah i();

    ah j();

    ap k();

    ap l();

    String m();

    boolean p();

    boolean q();

    boolean r();

    boolean s();

    boolean t();

    boolean u();

    cs.a w(p pVar);
}
