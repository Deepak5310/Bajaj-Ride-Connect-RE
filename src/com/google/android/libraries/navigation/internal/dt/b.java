package com.google.android.libraries.navigation.internal.dt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'q' uses external variables
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
public final class b {
    private static final /* synthetic */ b[] C;
    public static final b a;
    public static final b b;
    public static final b c;
    public static final b d;
    public static final b e;
    public static final b f;
    public static final b g;
    public static final b h;
    public static final b i;
    public static final b j;
    public static final b k;
    public static final b l;
    public static final b m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final b f411n;
    public static final b o;
    public static final b p;
    public static final b q;
    public static final b r;
    public static final b s;
    public final int A;
    public final int B;
    public final c t;
    public final int u;
    public final String v;
    public final int w;
    public final String x;
    public final a y;
    public final int z;

    static {
        b bVar = new b("DEFAULT_BLUE_DOT", 0, c.MAP, com.google.android.libraries.navigation.internal.du.c.ad, "MyLocation blue dot", com.google.android.libraries.navigation.internal.du.c.ah, "MyLocation stale grey dot", a.a, com.google.android.libraries.navigation.internal.du.c.ae, com.google.android.libraries.navigation.internal.du.a.c, com.google.android.libraries.navigation.internal.du.a.d);
        a = bVar;
        b bVar2 = new b("DEFAULT_BLUE_DOT_MAP_COLORS2", 1, c.MAP, com.google.android.libraries.navigation.internal.du.c.ad, "MyLocation blue dot", com.google.android.libraries.navigation.internal.du.c.ah, "MyLocation stale grey dot", a.b, com.google.android.libraries.navigation.internal.du.c.af, com.google.android.libraries.navigation.internal.du.a.c, com.google.android.libraries.navigation.internal.du.a.d);
        b = bVar2;
        b bVar3 = new b("DEFAULT_WHITE_DOT", 2, c.MAP, com.google.android.libraries.navigation.internal.du.c.aB, "MyLocation white dot", com.google.android.libraries.navigation.internal.du.c.ah, "MyLocation stale grey dot", a.a, com.google.android.libraries.navigation.internal.du.c.ae, com.google.android.libraries.navigation.internal.du.a.c, com.google.android.libraries.navigation.internal.du.a.d);
        c = bVar3;
        b bVar4 = new b("DEFAULT_WHITE_DOT_MAP_COLORS2", 3, c.MAP, com.google.android.libraries.navigation.internal.du.c.aB, "MyLocation white dot", com.google.android.libraries.navigation.internal.du.c.ah, "MyLocation stale grey dot", a.b, com.google.android.libraries.navigation.internal.du.c.af, com.google.android.libraries.navigation.internal.du.a.c, com.google.android.libraries.navigation.internal.du.a.d);
        d = bVar4;
        b bVar5 = new b("TWO_WHEELER_DOT", 4, c.DIRECTIONS_TWO_WHEELER, com.google.android.libraries.navigation.internal.du.c.ax, "Two wheeler MyLocation blue dot", com.google.android.libraries.navigation.internal.du.c.ay, "Two wheeler MyLocation stale grey dot", a.c, com.google.android.libraries.navigation.internal.du.c.ae, com.google.android.libraries.navigation.internal.du.a.c, com.google.android.libraries.navigation.internal.du.a.d);
        e = bVar5;
        b bVar6 = new b("TWO_WHEELER_DOT_MAP_COLORS2", 5, c.DIRECTIONS_TWO_WHEELER, com.google.android.libraries.navigation.internal.du.c.ax, "Two wheeler MyLocation blue dot", com.google.android.libraries.navigation.internal.du.c.ay, "Two wheeler MyLocation stale grey dot", a.b, com.google.android.libraries.navigation.internal.du.c.af, com.google.android.libraries.navigation.internal.du.a.c, com.google.android.libraries.navigation.internal.du.a.d);
        f = bVar6;
        b bVar7 = new b("DRIVING_DOT", 6, c.DIRECTIONS_DRIVE, com.google.android.libraries.navigation.internal.du.c.M, "Driving MyLocation blue dot", com.google.android.libraries.navigation.internal.du.c.N, "Driving MyLocation stale grey dot", a.c, com.google.android.libraries.navigation.internal.du.c.ae, com.google.android.libraries.navigation.internal.du.a.c, com.google.android.libraries.navigation.internal.du.a.d);
        g = bVar7;
        b bVar8 = new b("DRIVING_DOT_MAP_COLORS2", 7, c.DIRECTIONS_DRIVE, com.google.android.libraries.navigation.internal.du.c.M, "Driving MyLocation blue dot", com.google.android.libraries.navigation.internal.du.c.N, "Driving MyLocation stale grey dot", a.b, com.google.android.libraries.navigation.internal.du.c.af, com.google.android.libraries.navigation.internal.du.a.c, com.google.android.libraries.navigation.internal.du.a.d);
        h = bVar8;
        b bVar9 = new b("WALKING_DOT", 8, c.DIRECTIONS_WALK, com.google.android.libraries.navigation.internal.du.c.az, "Walking MyLocation blue dot", com.google.android.libraries.navigation.internal.du.c.aA, "Walking MyLocation stale grey dot", a.c, com.google.android.libraries.navigation.internal.du.c.ae, com.google.android.libraries.navigation.internal.du.a.c, com.google.android.libraries.navigation.internal.du.a.d);
        i = bVar9;
        b bVar10 = new b("WALKING_DOT_MAP_COLORS2", 9, c.DIRECTIONS_WALK, com.google.android.libraries.navigation.internal.du.c.az, "Walking MyLocation blue dot", com.google.android.libraries.navigation.internal.du.c.aA, "Walking MyLocation stale grey dot", a.b, com.google.android.libraries.navigation.internal.du.c.af, com.google.android.libraries.navigation.internal.du.a.c, com.google.android.libraries.navigation.internal.du.a.d);
        j = bVar10;
        b bVar11 = new b("TAXI_DOT", 10, c.DIRECTIONS_TAXI, com.google.android.libraries.navigation.internal.du.c.am, "Taxi MyLocation blue dot", com.google.android.libraries.navigation.internal.du.c.an, "Taxi MyLocation stale grey dot", a.c, com.google.android.libraries.navigation.internal.du.c.ae, com.google.android.libraries.navigation.internal.du.a.c, com.google.android.libraries.navigation.internal.du.a.d);
        k = bVar11;
        b bVar12 = new b("TAXI_DOT_MAP_COLORS2", 11, c.DIRECTIONS_TAXI, com.google.android.libraries.navigation.internal.du.c.am, "Taxi MyLocation blue dot", com.google.android.libraries.navigation.internal.du.c.an, "Taxi MyLocation stale grey dot", a.b, com.google.android.libraries.navigation.internal.du.c.af, com.google.android.libraries.navigation.internal.du.a.c, com.google.android.libraries.navigation.internal.du.a.d);
        l = bVar12;
        b bVar13 = new b("BIKING_DOT", 12, c.DIRECTIONS_BICYCLE, com.google.android.libraries.navigation.internal.du.c.f, "Biking MyLocation blue dot", com.google.android.libraries.navigation.internal.du.c.g, "Biking MyLocation stale grey dot", a.c, com.google.android.libraries.navigation.internal.du.c.ae, com.google.android.libraries.navigation.internal.du.a.c, com.google.android.libraries.navigation.internal.du.a.d);
        m = bVar13;
        b bVar14 = new b("BIKING_DOT_MAP_COLORS2", 13, c.DIRECTIONS_BICYCLE, com.google.android.libraries.navigation.internal.du.c.f, "Biking MyLocation blue dot", com.google.android.libraries.navigation.internal.du.c.g, "Biking MyLocation stale grey dot", a.b, com.google.android.libraries.navigation.internal.du.c.af, com.google.android.libraries.navigation.internal.du.a.c, com.google.android.libraries.navigation.internal.du.a.d);
        f411n = bVar14;
        b bVar15 = new b("OFF_ROUTE_DRIVING_DOT", 14, c.SAFETY_OFF_ROUTE_DRIVE, com.google.android.libraries.navigation.internal.du.c.O, "Off route driving MyLocation red dot", com.google.android.libraries.navigation.internal.du.c.N, "Off route driving MyLocation stale grey dot", a.c, com.google.android.libraries.navigation.internal.du.c.ae, com.google.android.libraries.navigation.internal.du.a.c, com.google.android.libraries.navigation.internal.du.a.d);
        o = bVar15;
        b bVar16 = new b("OFF_ROUTE_DRIVING_DOT_MAP_COLORS2", 15, c.SAFETY_OFF_ROUTE_DRIVE, com.google.android.libraries.navigation.internal.du.c.O, "Off route driving MyLocation red dot", com.google.android.libraries.navigation.internal.du.c.N, "Off route driving MyLocation stale grey dot", a.b, com.google.android.libraries.navigation.internal.du.c.af, com.google.android.libraries.navigation.internal.du.a.c, com.google.android.libraries.navigation.internal.du.a.d);
        p = bVar16;
        c cVar = c.INCOGNITO;
        int i2 = com.google.android.libraries.navigation.internal.du.c.Y;
        b bVar17 = new b("INCOGNITO", 16, cVar, i2, "MyLocation incognito mode dot", i2, "MyLocation stale grey dot", a.d, com.google.android.libraries.navigation.internal.du.c.Z, com.google.android.libraries.navigation.internal.du.a.a, com.google.android.libraries.navigation.internal.du.a.b);
        q = bVar17;
        b bVar18 = new b("LITE_NAV", 17, c.LITE_NAV, com.google.android.libraries.navigation.internal.du.c.aa, "Lite Nav MyLocation chevron", com.google.android.libraries.navigation.internal.du.c.ac, "Lite Nav MyLocation stale chevron", a.a, com.google.android.libraries.navigation.internal.du.c.ab, com.google.android.libraries.navigation.internal.du.a.c, com.google.android.libraries.navigation.internal.du.a.d);
        r = bVar18;
        b bVar19 = new b("LITE_NAV_MAP_COLORS2", 18, c.LITE_NAV, com.google.android.libraries.navigation.internal.du.c.ai, "Lite Nav MyLocation chevron", com.google.android.libraries.navigation.internal.du.c.ac, "Lite Nav MyLocation stale chevron", a.b, com.google.android.libraries.navigation.internal.du.c.aj, com.google.android.libraries.navigation.internal.du.a.c, com.google.android.libraries.navigation.internal.du.a.d);
        s = bVar19;
        C = new b[]{bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, bVar9, bVar10, bVar11, bVar12, bVar13, bVar14, bVar15, bVar16, bVar17, bVar18, bVar19};
    }

    private b(String str, int i2, c cVar, int i3, String str2, int i4, String str3, a aVar, int i5, int i6, int i7) {
        super(str, i2);
        this.t = cVar;
        this.u = i3;
        this.v = str2;
        this.w = i4;
        this.x = str3;
        this.y = aVar;
        this.z = i5;
        this.A = i6;
        this.B = i7;
    }

    public static b[] values() {
        return (b[]) C.clone();
    }
}
