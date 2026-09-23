package com.google.android.libraries.navigation.internal.sl;

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
public final class h {
    public static final h a;
    public static final h b;
    public static final h c;
    public static final h d;
    public static final h e;
    public static final h f;
    public static final h g;
    public static final h h;
    public static final h i;
    public static final h j;
    public static final h k;
    private static final /* synthetic */ h[] m;
    public final g l;

    static {
        f fVarC = g.c();
        fVarC.e(i.PLAYING_UNPROMPTED);
        fVarC.h(m.UNMUTED);
        fVarC.f(e.NAVIGATION);
        fVarC.b(true);
        fVarC.i(d.t);
        h hVar = new h("GUIDANCE", 0, fVarC.a());
        a = hVar;
        f fVarC2 = g.c();
        fVarC2.e(i.PLAYING_UNPROMPTED);
        fVarC2.h(m.MINIMAL);
        fVarC2.f(e.NAVIGATION);
        fVarC2.b(true);
        fVarC2.i(d.t);
        h hVar2 = new h("LANE_ADVICE", 1, fVarC2.a());
        b = hVar2;
        f fVarC3 = g.c();
        fVarC3.e(i.PLAYING_UNPROMPTED);
        fVarC3.h(m.UNMUTED);
        fVarC3.f(e.NAVIGATION);
        fVarC3.b(true);
        fVarC3.c(true);
        int i2 = d.t;
        fVarC3.i(i2 + i2);
        h hVar3 = new h("PULL_GUIDANCE", 2, fVarC3.a());
        c = hVar3;
        f fVarC4 = g.c();
        fVarC4.e(i.PLAYING_UNPROMPTED);
        fVarC4.h(m.MUTED);
        fVarC4.f(e.NAVIGATION);
        fVarC4.b(true);
        fVarC4.c(true);
        int i3 = d.t;
        fVarC4.i(i3 + i3);
        h hVar4 = new h("TEST_AUDIO", 3, fVarC4.a());
        d = hVar4;
        f fVarC5 = g.c();
        fVarC5.e(i.PLAYING_UNPROMPTED);
        fVarC5.h(m.MINIMAL);
        fVarC5.f(e.NOTIFICATION);
        fVarC5.b(true);
        fVarC5.i(d.t);
        h hVar5 = new h("CONNECTIVITY", 4, fVarC5.a());
        e = hVar5;
        f fVarC6 = g.c();
        fVarC6.e(i.PLAYING_UNPROMPTED);
        fVarC6.h(m.MINIMAL);
        fVarC6.f(e.NAVIGATION);
        fVarC6.b(true);
        fVarC6.i(d.t);
        h hVar6 = new h("NAVIGATION_STATE_UPDATE", 5, fVarC6.a());
        f = hVar6;
        f fVarC7 = g.c();
        fVarC7.e(i.PLAYING_UNPROMPTED);
        fVarC7.h(m.MINIMAL);
        fVarC7.f(e.NAVIGATION);
        fVarC7.b(true);
        int i4 = d.t;
        fVarC7.i(i4 + i4);
        h hVar7 = new h("TRAFFIC_REPORT", 6, fVarC7.a());
        g = hVar7;
        f fVarC8 = g.c();
        fVarC8.e(i.PLAYING_PROMPTED);
        fVarC8.h(m.MUTED);
        fVarC8.f(e.ASSISTANT);
        fVarC8.d(true);
        fVarC8.c(true);
        int i5 = d.t;
        fVarC8.i(i5 + i5);
        h hVar8 = new h("RESPONSE", 7, fVarC8.a());
        h = hVar8;
        f fVarC9 = g.c();
        fVarC9.e(i.PLAYING_UNPROMPTED);
        fVarC9.h(m.UNMUTED);
        fVarC9.f(e.NAVIGATION);
        fVarC9.b(true);
        fVarC9.i(d.t * 4);
        h hVar9 = new h("TRANSIT_GUIDANCE", 8, fVarC9.a());
        i = hVar9;
        f fVarC10 = g.c();
        fVarC10.e(i.PLAYING_PROMPTED);
        fVarC10.h(m.MUTED);
        fVarC10.f(e.ASSISTANT);
        fVarC10.d(true);
        fVarC10.c(true);
        int i6 = d.t;
        fVarC10.i(i6 + i6);
        fVarC10.g(true);
        h hVar10 = new h("RESPONSE_KEEP_PLAYING_ON_STOP_NAVIGATION", 9, fVarC10.a());
        j = hVar10;
        f fVarC11 = g.c();
        fVarC11.e(i.PLAYING_UNPROMPTED);
        fVarC11.h(m.UNMUTED);
        fVarC11.f(e.UNKNOWN);
        fVarC11.b(true);
        fVarC11.i(d.t);
        fVarC11.g(true);
        h hVar11 = new h("NON_GUIDANCE_AUDIO_SNIPPET", 10, fVarC11.a());
        k = hVar11;
        m = new h[]{hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, hVar8, hVar9, hVar10, hVar11};
    }

    private h(String str, int i2, g gVar) {
        super(str, i2);
        this.l = gVar;
    }

    public static h[] values() {
        return (h[]) m.clone();
    }

    public final i a() {
        return ((k) this.l).a;
    }

    public final boolean b() {
        return ((k) this.l).g;
    }
}
