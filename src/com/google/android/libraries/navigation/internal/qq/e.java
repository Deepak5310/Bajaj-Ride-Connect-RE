package com.google.android.libraries.navigation.internal.qq;

import com.google.android.libraries.geo.mapcore.renderer.ez;
import com.google.android.libraries.navigation.internal.yz.kc;
import com.mappls.sdk.navigation.notifications.NavigationNotification;
import java.util.EnumMap;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'c' uses external variables
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
public final class e {
    public static final e a;
    public static final e b;
    public static final e c;
    public static final e d;
    public static final e e;
    public static final e f;
    public static final e g;
    public static final e h;
    public static final e i;
    public static final e j;
    public static final e k;
    public static final e l;
    public static final e m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final e f558n;
    public static final e o;
    public static final e p;
    public static final e q;
    public static final e r;
    public static final e s;
    public static final e t;
    public static final e u;
    public static final e v;
    public static final e w;
    public static final e x;
    public static final e y;
    private static final /* synthetic */ e[] z;
    private final f A;
    private final f B;

    static {
        e eVar = new e("NO_MAP", 0, ez.HIDDEN, com.google.android.libraries.navigation.internal.rq.a.b, com.google.android.libraries.geo.mapcore.internal.model.aq.a, com.google.android.libraries.geo.mapcore.internal.model.aq.a);
        a = eVar;
        e eVar2 = new e("ROADMAP", 1, ez.DEFAULT, com.google.android.libraries.navigation.internal.rq.a.a, com.google.android.libraries.geo.mapcore.internal.model.aq.a, com.google.android.libraries.geo.mapcore.internal.model.aq.b);
        b = eVar2;
        ez ezVar = ez.DEFAULT;
        com.google.android.libraries.navigation.internal.rq.a aVar = com.google.android.libraries.navigation.internal.rq.a.a;
        com.google.android.libraries.geo.mapcore.internal.model.aq aqVar = com.google.android.libraries.geo.mapcore.internal.model.aq.d;
        e eVar3 = new e(NavigationNotification.GROUP_NAME, 2, ezVar, aVar, aqVar, aqVar);
        c = eVar3;
        ez ezVar2 = ez.DEFAULT;
        com.google.android.libraries.navigation.internal.rq.a aVar2 = com.google.android.libraries.navigation.internal.rq.a.a;
        com.google.android.libraries.geo.mapcore.internal.model.aq aqVar2 = com.google.android.libraries.geo.mapcore.internal.model.aq.e;
        e eVar4 = new e("NAVIGATION_EGMM", 3, ezVar2, aVar2, aqVar2, aqVar2);
        d = eVar4;
        ez ezVar3 = ez.DEFAULT;
        com.google.android.libraries.navigation.internal.rq.a aVar3 = com.google.android.libraries.navigation.internal.rq.a.a;
        com.google.android.libraries.geo.mapcore.internal.model.aq aqVar3 = com.google.android.libraries.geo.mapcore.internal.model.aq.f59n;
        e eVar5 = new e("NAVIGATION_SATELLITE", 4, ezVar3, aVar3, aqVar3, aqVar3);
        e = eVar5;
        ez ezVar4 = ez.DEFAULT;
        com.google.android.libraries.navigation.internal.rq.a aVar4 = com.google.android.libraries.navigation.internal.rq.a.a;
        com.google.android.libraries.geo.mapcore.internal.model.aq aqVar4 = com.google.android.libraries.geo.mapcore.internal.model.aq.o;
        e eVar6 = new e("NAVIGATION_EGMM_SATELLITE", 5, ezVar4, aVar4, aqVar4, aqVar4);
        f = eVar6;
        ez ezVar5 = ez.DEFAULT;
        com.google.android.libraries.navigation.internal.rq.a aVar5 = com.google.android.libraries.navigation.internal.rq.a.a;
        com.google.android.libraries.geo.mapcore.internal.model.aq aqVar5 = com.google.android.libraries.geo.mapcore.internal.model.aq.h;
        e eVar7 = new e("NAVIGATION_EMBEDDED_AUTO", 6, ezVar5, aVar5, aqVar5, aqVar5);
        g = eVar7;
        ez ezVar6 = ez.DEFAULT;
        com.google.android.libraries.navigation.internal.rq.a aVar6 = com.google.android.libraries.navigation.internal.rq.a.a;
        com.google.android.libraries.geo.mapcore.internal.model.aq aqVar6 = com.google.android.libraries.geo.mapcore.internal.model.aq.f;
        e eVar8 = new e("NAVIGATION_AMBIENT", 7, ezVar6, aVar6, aqVar6, aqVar6);
        h = eVar8;
        ez ezVar7 = ez.DEFAULT;
        com.google.android.libraries.navigation.internal.rq.a aVar7 = com.google.android.libraries.navigation.internal.rq.a.a;
        com.google.android.libraries.geo.mapcore.internal.model.aq aqVar7 = com.google.android.libraries.geo.mapcore.internal.model.aq.i;
        e eVar9 = new e("NAVIGATION_HIGH_DETAIL", 8, ezVar7, aVar7, aqVar7, aqVar7);
        i = eVar9;
        ez ezVar8 = ez.DEFAULT;
        com.google.android.libraries.navigation.internal.rq.a aVar8 = com.google.android.libraries.navigation.internal.rq.a.a;
        com.google.android.libraries.geo.mapcore.internal.model.aq aqVar8 = com.google.android.libraries.geo.mapcore.internal.model.aq.k;
        e eVar10 = new e("NAVIGATION_LOW_LIGHT", 9, ezVar8, aVar8, aqVar8, aqVar8);
        j = eVar10;
        ez ezVar9 = ez.DEFAULT;
        com.google.android.libraries.navigation.internal.rq.a aVar9 = com.google.android.libraries.navigation.internal.rq.a.a;
        com.google.android.libraries.geo.mapcore.internal.model.aq aqVar9 = com.google.android.libraries.geo.mapcore.internal.model.aq.l;
        e eVar11 = new e("NAVIGATION_EGMM_LOW_LIGHT", 10, ezVar9, aVar9, aqVar9, aqVar9);
        k = eVar11;
        ez ezVar10 = ez.DEFAULT;
        com.google.android.libraries.navigation.internal.rq.a aVar10 = com.google.android.libraries.navigation.internal.rq.a.a;
        com.google.android.libraries.geo.mapcore.internal.model.aq aqVar10 = com.google.android.libraries.geo.mapcore.internal.model.aq.j;
        e eVar12 = new e("NAVIGATION_EMBEDDED_AUTO_LOW_LIGHT", 11, ezVar10, aVar10, aqVar10, aqVar10);
        l = eVar12;
        ez ezVar11 = ez.DEFAULT;
        com.google.android.libraries.navigation.internal.rq.a aVar11 = com.google.android.libraries.navigation.internal.rq.a.a;
        com.google.android.libraries.geo.mapcore.internal.model.aq aqVar11 = com.google.android.libraries.geo.mapcore.internal.model.aq.g;
        e eVar13 = new e("NAVIGATION_AMBIENT_DARK", 12, ezVar11, aVar11, aqVar11, aqVar11);
        m = eVar13;
        ez ezVar12 = ez.DEFAULT;
        com.google.android.libraries.navigation.internal.rq.a aVar12 = com.google.android.libraries.navigation.internal.rq.a.a;
        com.google.android.libraries.geo.mapcore.internal.model.aq aqVar12 = com.google.android.libraries.geo.mapcore.internal.model.aq.p;
        e eVar14 = new e("NAVIGATION_EMBEDDED_AUTO_SATELLITE", 13, ezVar12, aVar12, aqVar12, aqVar12);
        f558n = eVar14;
        ez ezVar13 = ez.DEFAULT;
        com.google.android.libraries.navigation.internal.rq.a aVar13 = com.google.android.libraries.navigation.internal.rq.a.a;
        com.google.android.libraries.geo.mapcore.internal.model.aq aqVar13 = com.google.android.libraries.geo.mapcore.internal.model.aq.m;
        e eVar15 = new e("NAVIGATION_HIGH_DETAIL_LOW_LIGHT", 14, ezVar13, aVar13, aqVar13, aqVar13);
        o = eVar15;
        ez ezVar14 = ez.DEFAULT;
        com.google.android.libraries.navigation.internal.rq.a aVar14 = com.google.android.libraries.navigation.internal.rq.a.a;
        com.google.android.libraries.geo.mapcore.internal.model.aq aqVar14 = com.google.android.libraries.geo.mapcore.internal.model.aq.b;
        e eVar16 = new e("NAVIGATION_WALKING_LOW_LIGHT", 15, ezVar14, aVar14, aqVar14, aqVar14);
        p = eVar16;
        ez ezVar15 = ez.SATELLITE_HYBRID;
        com.google.android.libraries.navigation.internal.rq.a aVar15 = com.google.android.libraries.navigation.internal.rq.a.a;
        com.google.android.libraries.geo.mapcore.internal.model.aq aqVar15 = com.google.android.libraries.geo.mapcore.internal.model.aq.s;
        e eVar17 = new e("SATELLITE_HYBRID", 16, ezVar15, aVar15, aqVar15, aqVar15);
        q = eVar17;
        ez ezVar16 = ez.SATELLITE_NO_BASEMAP;
        com.google.android.libraries.navigation.internal.rq.a aVarA = com.google.android.libraries.navigation.internal.rq.a.a(6);
        com.google.android.libraries.geo.mapcore.internal.model.aq aqVar16 = com.google.android.libraries.geo.mapcore.internal.model.aq.s;
        e eVar18 = new e("SATELLITE_NO_BASEMAP", 17, ezVar16, aVarA, aqVar16, aqVar16);
        r = eVar18;
        e eVar19 = new e("TERRAIN_VECTOR_CLIENT_LEGEND", 18, ez.TERRAIN, com.google.android.libraries.navigation.internal.rq.a.a, com.google.android.libraries.geo.mapcore.internal.model.aq.x, com.google.android.libraries.geo.mapcore.internal.model.aq.y);
        s = eVar19;
        e eVar20 = new e("TRANSIT_FOCUSED", 19, ez.DEFAULT, com.google.android.libraries.navigation.internal.rq.a.a, com.google.android.libraries.geo.mapcore.internal.model.aq.z, com.google.android.libraries.geo.mapcore.internal.model.aq.A);
        t = eVar20;
        ez ezVar17 = ez.SATELLITE_HYBRID;
        com.google.android.libraries.navigation.internal.rq.a aVar16 = com.google.android.libraries.navigation.internal.rq.a.a;
        com.google.android.libraries.geo.mapcore.internal.model.aq aqVar17 = com.google.android.libraries.geo.mapcore.internal.model.aq.c;
        e eVar21 = new e("SATELLITE_BASEMAP_EDITING", 20, ezVar17, aVar16, aqVar17, aqVar17);
        u = eVar21;
        e eVar22 = new e("ROUTE_OVERVIEW", 21, ez.DEFAULT, com.google.android.libraries.navigation.internal.rq.a.a, com.google.android.libraries.geo.mapcore.internal.model.aq.t, com.google.android.libraries.geo.mapcore.internal.model.aq.u);
        v = eVar22;
        ez ezVar18 = ez.DEFAULT;
        com.google.android.libraries.navigation.internal.rq.a aVar17 = com.google.android.libraries.navigation.internal.rq.a.a;
        com.google.android.libraries.geo.mapcore.internal.model.aq aqVar18 = com.google.android.libraries.geo.mapcore.internal.model.aq.q;
        e eVar23 = new e("ROADMAP_AMBIACTIVE", 22, ezVar18, aVar17, aqVar18, aqVar18);
        w = eVar23;
        ez ezVar19 = ez.DEFAULT;
        com.google.android.libraries.navigation.internal.rq.a aVar18 = com.google.android.libraries.navigation.internal.rq.a.a;
        com.google.android.libraries.geo.mapcore.internal.model.aq aqVar19 = com.google.android.libraries.geo.mapcore.internal.model.aq.r;
        e eVar24 = new e("ROADMAP_AMBIACTIVE_LOW_BIT", 23, ezVar19, aVar18, aqVar19, aqVar19);
        x = eVar24;
        e eVar25 = new e("AIR_QUALITY_HEATMAP", 24, ez.DEFAULT, com.google.android.libraries.navigation.internal.rq.a.a, com.google.android.libraries.geo.mapcore.internal.model.aq.B, com.google.android.libraries.geo.mapcore.internal.model.aq.C);
        y = eVar25;
        z = new e[]{eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8, eVar9, eVar10, eVar11, eVar12, eVar13, eVar14, eVar15, eVar16, eVar17, eVar18, eVar19, eVar20, eVar21, eVar22, eVar23, eVar24, eVar25};
        EnumMap enumMap = new EnumMap(com.google.android.libraries.geo.mapcore.internal.model.aq.class);
        for (e eVar26 : values()) {
            enumMap.put(((b) eVar26.a(true)).c, eVar26);
            enumMap.put(((b) eVar26.a(false)).c, eVar26);
        }
        enumMap.put(com.google.android.libraries.geo.mapcore.internal.model.aq.a, b);
        enumMap.put(com.google.android.libraries.geo.mapcore.internal.model.aq.s, q);
        kc.b(enumMap);
    }

    private e(String str, int i2, ez ezVar, com.google.android.libraries.navigation.internal.rq.a aVar, com.google.android.libraries.geo.mapcore.internal.model.aq aqVar, com.google.android.libraries.geo.mapcore.internal.model.aq aqVar2) {
        super(str, i2);
        this.A = new b(ezVar, aVar, aqVar, false, this);
        this.B = new b(ezVar, aVar, aqVar2, true, this);
    }

    public static e[] values() {
        return (e[]) z.clone();
    }

    public final f a(boolean z2) {
        return z2 ? this.B : this.A;
    }
}
