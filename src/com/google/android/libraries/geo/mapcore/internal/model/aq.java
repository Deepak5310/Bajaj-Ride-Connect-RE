package com.google.android.libraries.geo.mapcore.internal.model;

import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.kc;
import com.mappls.sdk.navigation.notifications.NavigationNotification;
import java.util.EnumMap;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'e' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class aq {
    public static final aq A;
    public static final aq B;
    public static final aq C;
    private static final fd H;
    private static final /* synthetic */ aq[] I;
    public static final aq a;
    public static final aq b;
    public static final aq c;
    public static final aq d;
    public static final aq e;
    public static final aq f;
    public static final aq g;
    public static final aq h;
    public static final aq i;
    public static final aq j;
    public static final aq k;
    public static final aq l;
    public static final aq m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final aq f59n;
    public static final aq o;
    public static final aq p;
    public static final aq q;
    public static final aq r;
    public static final aq s;
    public static final aq t;
    public static final aq u;
    public static final aq v;
    public static final aq w;
    public static final aq x;
    public static final aq y;
    public static final aq z;
    public final int D;
    public final com.google.android.libraries.navigation.internal.adi.bo E;
    public final boolean F;
    public final boolean G;

    static {
        aq aqVar = new aq("ROADMAP", 0, -987675, com.google.android.libraries.navigation.internal.adi.bo.ROADMAP, true, false);
        a = aqVar;
        aq aqVar2 = new aq("ROADMAP_DARK", 1, -15592942, com.google.android.libraries.navigation.internal.adi.bo.ROADMAP_DARK, false, true);
        b = aqVar2;
        aq aqVar3 = new aq("BASEMAP_EDITING_SATELLITE", 2, -15525081, com.google.android.libraries.navigation.internal.adi.bo.BASEMAP_EDITING_SATELLITE, false, false);
        c = aqVar3;
        aq aqVar4 = new aq(NavigationNotification.GROUP_NAME, 3, -1973791, com.google.android.libraries.navigation.internal.adi.bo.NAVIGATION, true, false);
        d = aqVar4;
        aq aqVar5 = new aq("NAVIGATION_EGMM", 4, aqVar4.D, com.google.android.libraries.navigation.internal.adi.bo.NAVIGATION_EGMM, false, false);
        e = aqVar5;
        aq aqVar6 = new aq("NAVIGATION_AMBIENT", 5, -4341306, com.google.android.libraries.navigation.internal.adi.bo.NAVIGATION_AMBIENT, false, false);
        f = aqVar6;
        aq aqVar7 = new aq("NAVIGATION_AMBIENT_DARK", 6, -14803167, com.google.android.libraries.navigation.internal.adi.bo.NAVIGATION_AMBIENT_DARK, false, true);
        g = aqVar7;
        aq aqVar8 = new aq("NAVIGATION_EMBEDDED_AUTO", 7, -4341306, com.google.android.libraries.navigation.internal.adi.bo.NAVIGATION_EMBEDDED_AUTO, false, false);
        h = aqVar8;
        aq aqVar9 = new aq("NAVIGATION_HIGH_DETAIL", 8, aqVar4.D, com.google.android.libraries.navigation.internal.adi.bo.NAVIGATION_HIGH_DETAIL, false, false);
        i = aqVar9;
        aq aqVar10 = new aq("NAVIGATION_EMBEDDED_AUTO_LOW_LIGHT", 9, -14803167, com.google.android.libraries.navigation.internal.adi.bo.NAVIGATION_EMBEDDED_AUTO_LOW_LIGHT, false, true);
        j = aqVar10;
        aq aqVar11 = new aq("NAVIGATION_LOW_LIGHT", 10, -15525081, com.google.android.libraries.navigation.internal.adi.bo.NAVIGATION_LOW_LIGHT, true, true);
        k = aqVar11;
        aq aqVar12 = new aq("NAVIGATION_EGMM_LOW_LIGHT", 11, aqVar11.D, com.google.android.libraries.navigation.internal.adi.bo.NAVIGATION_EGMM_LOW_LIGHT, false, true);
        l = aqVar12;
        aq aqVar13 = new aq("NAVIGATION_HIGH_DETAIL_LOW_LIGHT", 12, aqVar11.D, com.google.android.libraries.navigation.internal.adi.bo.NAVIGATION_HIGH_DETAIL_LOW_LIGHT, false, true);
        m = aqVar13;
        aq aqVar14 = new aq("NAVIGATION_SATELLITE", 13, aqVar11.D, com.google.android.libraries.navigation.internal.adi.bo.NAVIGATION_SATELLITE, false, false);
        f59n = aqVar14;
        aq aqVar15 = new aq("NAVIGATION_EGMM_SATELLITE", 14, aqVar14.D, com.google.android.libraries.navigation.internal.adi.bo.NAVIGATION_EGMM_SATELLITE, false, false);
        o = aqVar15;
        aq aqVar16 = new aq("NAVIGATION_EMBEDDED_AUTO_SATELLITE", 15, aqVar11.D, com.google.android.libraries.navigation.internal.adi.bo.NAVIGATION_EMBEDDED_AUTO_SATELLITE, false, false);
        p = aqVar16;
        aq aqVar17 = new aq("ROADMAP_AMBIACTIVE", 16, aqVar.D, com.google.android.libraries.navigation.internal.adi.bo.ROADMAP_AMBIACTIVE, false, false);
        q = aqVar17;
        aq aqVar18 = new aq("ROADMAP_AMBIACTIVE_LOW_BIT", 17, 0, com.google.android.libraries.navigation.internal.adi.bo.ROADMAP_AMBIACTIVE_LOW_BIT, false, false);
        r = aqVar18;
        aq aqVar19 = new aq("ROADMAP_SATELLITE", 18, aqVar11.D, com.google.android.libraries.navigation.internal.adi.bo.ROADMAP_SATELLITE, false, false);
        s = aqVar19;
        aq aqVar20 = new aq("ROUTE_OVERVIEW", 19, aqVar.D, com.google.android.libraries.navigation.internal.adi.bo.ROUTE_OVERVIEW, false, false);
        t = aqVar20;
        aq aqVar21 = new aq("ROUTE_OVERVIEW_DARK", 20, aqVar2.D, com.google.android.libraries.navigation.internal.adi.bo.ROUTE_OVERVIEW_DARK, false, true);
        u = aqVar21;
        aq aqVar22 = new aq("SAFETY", 21, aqVar.D, com.google.android.libraries.navigation.internal.adi.bo.SAFETY, false, false);
        v = aqVar22;
        aq aqVar23 = new aq("SAFETY_DARK", 22, aqVar2.D, com.google.android.libraries.navigation.internal.adi.bo.SAFETY_DARK, false, true);
        w = aqVar23;
        aq aqVar24 = new aq("TERRAIN_VECTOR_CLIENT", 23, aqVar.D, com.google.android.libraries.navigation.internal.adi.bo.TERRAIN_VECTOR_CLIENT, false, false);
        x = aqVar24;
        aq aqVar25 = new aq("TERRAIN_VECTOR_CLIENT_DARK", 24, aqVar.D, com.google.android.libraries.navigation.internal.adi.bo.TERRAIN_VECTOR_CLIENT_DARK, false, true);
        y = aqVar25;
        aq aqVar26 = new aq("TRANSIT_FOCUSED", 25, aqVar.D, com.google.android.libraries.navigation.internal.adi.bo.TRANSIT_FOCUSED, false, false);
        z = aqVar26;
        aq aqVar27 = new aq("TRANSIT_FOCUSED_DARK", 26, aqVar2.D, com.google.android.libraries.navigation.internal.adi.bo.TRANSIT_FOCUSED_DARK, false, true);
        A = aqVar27;
        aq aqVar28 = new aq("AIR_QUALITY_HEATMAP", 27, aqVar.D, com.google.android.libraries.navigation.internal.adi.bo.AIR_QUALITY_HEATMAP, false, false);
        B = aqVar28;
        aq aqVar29 = new aq("AIR_QUALITY_HEATMAP_DARK", 28, aqVar2.D, com.google.android.libraries.navigation.internal.adi.bo.AIR_QUALITY_HEATMAP_DARK, false, true);
        C = aqVar29;
        I = new aq[]{aqVar, aqVar2, aqVar3, aqVar4, aqVar5, aqVar6, aqVar7, aqVar8, aqVar9, aqVar10, aqVar11, aqVar12, aqVar13, aqVar14, aqVar15, aqVar16, aqVar17, aqVar18, aqVar19, aqVar20, aqVar21, aqVar22, aqVar23, aqVar24, aqVar25, aqVar26, aqVar27, aqVar28, aqVar29};
        EnumMap enumMap = new EnumMap(com.google.android.libraries.navigation.internal.adi.bo.class);
        for (aq aqVar30 : values()) {
            enumMap.put(aqVar30.E, aqVar30);
        }
        H = kc.b(enumMap);
        int length = values().length;
    }

    private aq(String str, int i2, int i3, com.google.android.libraries.navigation.internal.adi.bo boVar, boolean z2, boolean z3) {
        super(str, i2);
        this.D = i3;
        this.E = boVar;
        this.F = z2;
        this.G = z3;
    }

    public static aq a(com.google.android.libraries.navigation.internal.adi.bo boVar) {
        aq aqVar = (aq) H.get(boVar);
        if (aqVar != null) {
            return aqVar;
        }
        throw new UnsupportedOperationException("Can not convert VersatileMapStyle: ".concat(String.valueOf(String.valueOf(boVar))));
    }

    public static aq[] values() {
        return (aq[]) I.clone();
    }
}
