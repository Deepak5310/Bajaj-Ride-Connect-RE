package com.google.android.libraries.navigation.internal.ee;

import com.google.android.libraries.navigation.internal.iv.ab;
import com.google.android.libraries.navigation.internal.iv.ad;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.Objects;

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
public final class j {
    public static final j A;
    public static final j B;
    public static final j C;
    public static final j D;
    public static final j E;
    public static final j F;
    private static final /* synthetic */ j[] H;
    public static final j a;
    public static final j b;
    public static final j c;
    public static final j d;
    public static final j e;
    public static final j f;
    public static final j g;
    public static final j h;
    public static final j i;
    public static final j j;
    public static final j k;
    public static final j l;
    public static final j m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final j f421n;
    public static final j o;
    public static final j p;
    public static final j q;
    public static final j r;
    public static final j s;
    public static final j t;
    public static final j u;
    public static final j v;
    public static final j w;
    public static final j x;
    public static final j y;
    public static final j z;
    public final ev G;
    private final s I;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        i iVar = i.GETTING_AROUND;
        final com.google.android.libraries.navigation.internal.afd.a aVar = com.google.android.libraries.navigation.internal.afe.m.f257n;
        final com.google.android.libraries.navigation.internal.afd.a aVar2 = com.google.android.libraries.navigation.internal.afe.m.m;
        final com.google.android.libraries.navigation.internal.afd.a aVar3 = com.google.android.libraries.navigation.internal.afe.m.k;
        final com.google.android.libraries.navigation.internal.afd.a aVar4 = com.google.android.libraries.navigation.internal.afe.m.l;
        new r(aVar, aVar2, aVar3, aVar4) { // from class: com.google.android.libraries.navigation.internal.ee.f
            private final com.google.android.libraries.navigation.internal.afd.a a;
            private final com.google.android.libraries.navigation.internal.afd.a b;
            private final com.google.android.libraries.navigation.internal.afd.a c;
            private final com.google.android.libraries.navigation.internal.afd.a d;

            {
                Objects.requireNonNull(aVar);
                this.a = aVar;
                Objects.requireNonNull(aVar2);
                this.b = aVar2;
                Objects.requireNonNull(aVar3);
                this.c = aVar3;
                Objects.requireNonNull(aVar4);
                this.d = aVar4;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a a() {
                return this.d;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a b() {
                return this.a;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a c() {
                return this.b;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a d() {
                return this.c;
            }

            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof r) {
                    r rVar = (r) obj;
                    if (this.a.equals(rVar.b()) && this.b.equals(rVar.c()) && this.c.equals(rVar.d()) && this.d.equals(rVar.a())) {
                        return true;
                    }
                }
                return false;
            }

            public final int hashCode() {
                return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
            }

            public final String toString() {
                com.google.android.libraries.navigation.internal.afd.a aVar5 = this.d;
                com.google.android.libraries.navigation.internal.afd.a aVar6 = this.c;
                com.google.android.libraries.navigation.internal.afd.a aVar7 = this.b;
                return "{" + this.a.b() + ", " + aVar7.b() + ", " + aVar6.b() + ", " + aVar5.b() + "}";
            }
        };
        ad adVar = ab.c;
        int i2 = com.google.android.libraries.navigation.internal.em.a.a;
        s sVar = new s();
        n nVarH = p.h(1);
        nVarH.b(Integer.toString(com.google.android.libraries.navigation.internal.adu.m.AREA_TRAFFIC.eU));
        nVarH.d(com.google.android.libraries.navigation.internal.em.a.ar);
        nVarH.c(com.google.android.libraries.navigation.internal.em.a.aq);
        j jVar = new j("TRAFFIC_IN_YOUR_AREA", 0, sVar, nVarH.a());
        a = jVar;
        final com.google.android.libraries.navigation.internal.afd.a aVar5 = com.google.android.libraries.navigation.internal.afe.m.j;
        final com.google.android.libraries.navigation.internal.afd.a aVar6 = com.google.android.libraries.navigation.internal.afe.m.i;
        final com.google.android.libraries.navigation.internal.afd.a aVar7 = com.google.android.libraries.navigation.internal.afe.m.g;
        final com.google.android.libraries.navigation.internal.afd.a aVar8 = com.google.android.libraries.navigation.internal.afe.m.h;
        new r(aVar5, aVar6, aVar7, aVar8) { // from class: com.google.android.libraries.navigation.internal.ee.f
            private final com.google.android.libraries.navigation.internal.afd.a a;
            private final com.google.android.libraries.navigation.internal.afd.a b;
            private final com.google.android.libraries.navigation.internal.afd.a c;
            private final com.google.android.libraries.navigation.internal.afd.a d;

            {
                Objects.requireNonNull(aVar5);
                this.a = aVar5;
                Objects.requireNonNull(aVar6);
                this.b = aVar6;
                Objects.requireNonNull(aVar7);
                this.c = aVar7;
                Objects.requireNonNull(aVar8);
                this.d = aVar8;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a a() {
                return this.d;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a b() {
                return this.a;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a c() {
                return this.b;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a d() {
                return this.c;
            }

            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof r) {
                    r rVar = (r) obj;
                    if (this.a.equals(rVar.b()) && this.b.equals(rVar.c()) && this.c.equals(rVar.d()) && this.d.equals(rVar.a())) {
                        return true;
                    }
                }
                return false;
            }

            public final int hashCode() {
                return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
            }

            public final String toString() {
                com.google.android.libraries.navigation.internal.afd.a aVar9 = this.d;
                com.google.android.libraries.navigation.internal.afd.a aVar10 = this.c;
                com.google.android.libraries.navigation.internal.afd.a aVar11 = this.b;
                return "{" + this.a.b() + ", " + aVar11.b() + ", " + aVar10.b() + ", " + aVar9.b() + "}";
            }
        };
        s sVar2 = new s();
        n nVarH2 = p.h(2);
        nVarH2.b(Integer.toString(com.google.android.libraries.navigation.internal.adu.m.LOCAL_EVENT.eU));
        nVarH2.d(com.google.android.libraries.navigation.internal.em.a.au);
        nVarH2.c(com.google.android.libraries.navigation.internal.em.a.at);
        j jVar2 = new j("TRAFFIC_FROM_NEARBY_EVENTS", 1, sVar2, nVarH2.a());
        b = jVar2;
        final com.google.android.libraries.navigation.internal.afd.a aVar9 = com.google.android.libraries.navigation.internal.afe.m.e;
        final com.google.android.libraries.navigation.internal.afd.a aVar10 = com.google.android.libraries.navigation.internal.afe.m.d;
        final com.google.android.libraries.navigation.internal.afd.a aVar11 = com.google.android.libraries.navigation.internal.afe.m.b;
        final com.google.android.libraries.navigation.internal.afd.a aVar12 = com.google.android.libraries.navigation.internal.afe.m.c;
        new r(aVar9, aVar10, aVar11, aVar12) { // from class: com.google.android.libraries.navigation.internal.ee.f
            private final com.google.android.libraries.navigation.internal.afd.a a;
            private final com.google.android.libraries.navigation.internal.afd.a b;
            private final com.google.android.libraries.navigation.internal.afd.a c;
            private final com.google.android.libraries.navigation.internal.afd.a d;

            {
                Objects.requireNonNull(aVar9);
                this.a = aVar9;
                Objects.requireNonNull(aVar10);
                this.b = aVar10;
                Objects.requireNonNull(aVar11);
                this.c = aVar11;
                Objects.requireNonNull(aVar12);
                this.d = aVar12;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a a() {
                return this.d;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a b() {
                return this.a;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a c() {
                return this.b;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a d() {
                return this.c;
            }

            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof r) {
                    r rVar = (r) obj;
                    if (this.a.equals(rVar.b()) && this.b.equals(rVar.c()) && this.c.equals(rVar.d()) && this.d.equals(rVar.a())) {
                        return true;
                    }
                }
                return false;
            }

            public final int hashCode() {
                return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
            }

            public final String toString() {
                com.google.android.libraries.navigation.internal.afd.a aVar13 = this.d;
                com.google.android.libraries.navigation.internal.afd.a aVar14 = this.c;
                com.google.android.libraries.navigation.internal.afd.a aVar15 = this.b;
                return "{" + this.a.b() + ", " + aVar15.b() + ", " + aVar14.b() + ", " + aVar13.b() + "}";
            }
        };
        s sVar3 = new s();
        n nVarH3 = p.h(2);
        nVarH3.b(l.d(com.google.android.libraries.navigation.internal.adu.m.TIME_TO_LEAVE_V2, "_1"));
        nVarH3.d(com.google.android.libraries.navigation.internal.em.a.ao);
        nVarH3.c(com.google.android.libraries.navigation.internal.em.a.an);
        j jVar3 = new j("TIME_TO_LEAVE", 2, sVar3, nVarH3.a());
        c = jVar3;
        final com.google.android.libraries.navigation.internal.afd.a aVar13 = com.google.android.libraries.navigation.internal.afe.m.z;
        final com.google.android.libraries.navigation.internal.afd.a aVar14 = com.google.android.libraries.navigation.internal.afe.m.y;
        final com.google.android.libraries.navigation.internal.afd.a aVar15 = com.google.android.libraries.navigation.internal.afe.m.w;
        final com.google.android.libraries.navigation.internal.afd.a aVar16 = com.google.android.libraries.navigation.internal.afe.m.x;
        new r(aVar13, aVar14, aVar15, aVar16) { // from class: com.google.android.libraries.navigation.internal.ee.f
            private final com.google.android.libraries.navigation.internal.afd.a a;
            private final com.google.android.libraries.navigation.internal.afd.a b;
            private final com.google.android.libraries.navigation.internal.afd.a c;
            private final com.google.android.libraries.navigation.internal.afd.a d;

            {
                Objects.requireNonNull(aVar13);
                this.a = aVar13;
                Objects.requireNonNull(aVar14);
                this.b = aVar14;
                Objects.requireNonNull(aVar15);
                this.c = aVar15;
                Objects.requireNonNull(aVar16);
                this.d = aVar16;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a a() {
                return this.d;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a b() {
                return this.a;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a c() {
                return this.b;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a d() {
                return this.c;
            }

            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof r) {
                    r rVar = (r) obj;
                    if (this.a.equals(rVar.b()) && this.b.equals(rVar.c()) && this.c.equals(rVar.d()) && this.d.equals(rVar.a())) {
                        return true;
                    }
                }
                return false;
            }

            public final int hashCode() {
                return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
            }

            public final String toString() {
                com.google.android.libraries.navigation.internal.afd.a aVar17 = this.d;
                com.google.android.libraries.navigation.internal.afd.a aVar18 = this.c;
                com.google.android.libraries.navigation.internal.afd.a aVar19 = this.b;
                return "{" + this.a.b() + ", " + aVar19.b() + ", " + aVar18.b() + ", " + aVar17.b() + "}";
            }
        };
        s sVar4 = new s();
        n nVarH4 = p.h(2);
        nVarH4.b(l.d(com.google.android.libraries.navigation.internal.adu.m.TRANSIT_STATION, "_1"));
        nVarH4.d(com.google.android.libraries.navigation.internal.em.a.ax);
        nVarH4.c(com.google.android.libraries.navigation.internal.em.a.aw);
        j jVar4 = new j("TRANSIT_INFO_MAPS", 3, sVar4, nVarH4.a());
        d = jVar4;
        final com.google.android.libraries.navigation.internal.afd.a aVar17 = com.google.android.libraries.navigation.internal.afe.k.e;
        final com.google.android.libraries.navigation.internal.afd.a aVar18 = com.google.android.libraries.navigation.internal.afe.k.d;
        final com.google.android.libraries.navigation.internal.afd.a aVar19 = com.google.android.libraries.navigation.internal.afe.k.b;
        final com.google.android.libraries.navigation.internal.afd.a aVar20 = com.google.android.libraries.navigation.internal.afe.k.c;
        new r(aVar17, aVar18, aVar19, aVar20) { // from class: com.google.android.libraries.navigation.internal.ee.f
            private final com.google.android.libraries.navigation.internal.afd.a a;
            private final com.google.android.libraries.navigation.internal.afd.a b;
            private final com.google.android.libraries.navigation.internal.afd.a c;
            private final com.google.android.libraries.navigation.internal.afd.a d;

            {
                Objects.requireNonNull(aVar17);
                this.a = aVar17;
                Objects.requireNonNull(aVar18);
                this.b = aVar18;
                Objects.requireNonNull(aVar19);
                this.c = aVar19;
                Objects.requireNonNull(aVar20);
                this.d = aVar20;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a a() {
                return this.d;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a b() {
                return this.a;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a c() {
                return this.b;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a d() {
                return this.c;
            }

            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof r) {
                    r rVar = (r) obj;
                    if (this.a.equals(rVar.b()) && this.b.equals(rVar.c()) && this.c.equals(rVar.d()) && this.d.equals(rVar.a())) {
                        return true;
                    }
                }
                return false;
            }

            public final int hashCode() {
                return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
            }

            public final String toString() {
                com.google.android.libraries.navigation.internal.afd.a aVar110 = this.d;
                com.google.android.libraries.navigation.internal.afd.a aVar111 = this.c;
                com.google.android.libraries.navigation.internal.afd.a aVar112 = this.b;
                return "{" + this.a.b() + ", " + aVar112.b() + ", " + aVar111.b() + ", " + aVar110.b() + "}";
            }
        };
        s sVar5 = new s();
        n nVarH5 = p.h(2);
        nVarH5.b(l.d(com.google.android.libraries.navigation.internal.adu.m.SAVED_PARKING_LOCATION, "_1"));
        nVarH5.d(com.google.android.libraries.navigation.internal.em.a.W);
        nVarH5.c(com.google.android.libraries.navigation.internal.em.a.V);
        j jVar5 = new j("PARKING_LOCATION", 4, sVar5, nVarH5.a());
        e = jVar5;
        final com.google.android.libraries.navigation.internal.afd.a aVar21 = com.google.android.libraries.navigation.internal.afe.j.d;
        final com.google.android.libraries.navigation.internal.afd.a aVar22 = com.google.android.libraries.navigation.internal.afe.j.c;
        final com.google.android.libraries.navigation.internal.afd.a aVar23 = com.google.android.libraries.navigation.internal.afe.j.a;
        final com.google.android.libraries.navigation.internal.afd.a aVar24 = com.google.android.libraries.navigation.internal.afe.j.b;
        new r(aVar21, aVar22, aVar23, aVar24) { // from class: com.google.android.libraries.navigation.internal.ee.f
            private final com.google.android.libraries.navigation.internal.afd.a a;
            private final com.google.android.libraries.navigation.internal.afd.a b;
            private final com.google.android.libraries.navigation.internal.afd.a c;
            private final com.google.android.libraries.navigation.internal.afd.a d;

            {
                Objects.requireNonNull(aVar21);
                this.a = aVar21;
                Objects.requireNonNull(aVar22);
                this.b = aVar22;
                Objects.requireNonNull(aVar23);
                this.c = aVar23;
                Objects.requireNonNull(aVar24);
                this.d = aVar24;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a a() {
                return this.d;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a b() {
                return this.a;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a c() {
                return this.b;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a d() {
                return this.c;
            }

            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof r) {
                    r rVar = (r) obj;
                    if (this.a.equals(rVar.b()) && this.b.equals(rVar.c()) && this.c.equals(rVar.d()) && this.d.equals(rVar.a())) {
                        return true;
                    }
                }
                return false;
            }

            public final int hashCode() {
                return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
            }

            public final String toString() {
                com.google.android.libraries.navigation.internal.afd.a aVar110 = this.d;
                com.google.android.libraries.navigation.internal.afd.a aVar111 = this.c;
                com.google.android.libraries.navigation.internal.afd.a aVar112 = this.b;
                return "{" + this.a.b() + ", " + aVar112.b() + ", " + aVar111.b() + ", " + aVar110.b() + "}";
            }
        };
        s sVar6 = new s();
        n nVarH6 = p.h(2);
        nVarH6.b(l.d(com.google.android.libraries.navigation.internal.adu.m.OFFLINE_MAP_EXPIRED, "_1"));
        nVarH6.d(com.google.android.libraries.navigation.internal.em.a.S);
        nVarH6.c(com.google.android.libraries.navigation.internal.em.a.R);
        j jVar6 = new j("OFFLINE_MAPS", 5, sVar6, nVarH6.a());
        f = jVar6;
        n nVarH7 = p.h(3);
        nVarH7.b(l.d(com.google.android.libraries.navigation.internal.adu.m.OFFLINE_DOWNLOAD, "_1"));
        nVarH7.d(com.google.android.libraries.navigation.internal.em.a.P);
        j jVar7 = new j("OFFLINE_MAPS_DOWNLOAD_EMBEDDED", 6, null, nVarH7.a());
        g = jVar7;
        final com.google.android.libraries.navigation.internal.afd.a aVar25 = com.google.android.libraries.navigation.internal.afe.k.l;
        final com.google.android.libraries.navigation.internal.afd.a aVar26 = com.google.android.libraries.navigation.internal.afe.k.k;
        final com.google.android.libraries.navigation.internal.afd.a aVar27 = com.google.android.libraries.navigation.internal.afe.k.i;
        final com.google.android.libraries.navigation.internal.afd.a aVar28 = com.google.android.libraries.navigation.internal.afe.k.j;
        new r(aVar25, aVar26, aVar27, aVar28) { // from class: com.google.android.libraries.navigation.internal.ee.f
            private final com.google.android.libraries.navigation.internal.afd.a a;
            private final com.google.android.libraries.navigation.internal.afd.a b;
            private final com.google.android.libraries.navigation.internal.afd.a c;
            private final com.google.android.libraries.navigation.internal.afd.a d;

            {
                Objects.requireNonNull(aVar25);
                this.a = aVar25;
                Objects.requireNonNull(aVar26);
                this.b = aVar26;
                Objects.requireNonNull(aVar27);
                this.c = aVar27;
                Objects.requireNonNull(aVar28);
                this.d = aVar28;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a a() {
                return this.d;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a b() {
                return this.a;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a c() {
                return this.b;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a d() {
                return this.c;
            }

            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof r) {
                    r rVar = (r) obj;
                    if (this.a.equals(rVar.b()) && this.b.equals(rVar.c()) && this.c.equals(rVar.d()) && this.d.equals(rVar.a())) {
                        return true;
                    }
                }
                return false;
            }

            public final int hashCode() {
                return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
            }

            public final String toString() {
                com.google.android.libraries.navigation.internal.afd.a aVar110 = this.d;
                com.google.android.libraries.navigation.internal.afd.a aVar111 = this.c;
                com.google.android.libraries.navigation.internal.afd.a aVar112 = this.b;
                return "{" + this.a.b() + ", " + aVar112.b() + ", " + aVar111.b() + ", " + aVar110.b() + "}";
            }
        };
        s sVar7 = new s();
        n nVarH8 = p.h(4);
        nVarH8.b(l.d(com.google.android.libraries.navigation.internal.adu.m.ADD_YOUR_PICKUP_ORDER, ":4"));
        nVarH8.d(com.google.android.libraries.navigation.internal.em.a.ac);
        nVarH8.c(com.google.android.libraries.navigation.internal.em.a.ab);
        nVarH8.e(new e(k.h, 3));
        j jVar8 = new j("ORDER_PICKUP", 7, sVar7, nVarH8.a());
        h = jVar8;
        final com.google.android.libraries.navigation.internal.afd.a aVar29 = com.google.android.libraries.navigation.internal.afe.i.W;
        final com.google.android.libraries.navigation.internal.afd.a aVar30 = com.google.android.libraries.navigation.internal.afe.i.V;
        final com.google.android.libraries.navigation.internal.afd.a aVar31 = com.google.android.libraries.navigation.internal.afe.i.T;
        final com.google.android.libraries.navigation.internal.afd.a aVar32 = com.google.android.libraries.navigation.internal.afe.i.U;
        new r(aVar29, aVar30, aVar31, aVar32) { // from class: com.google.android.libraries.navigation.internal.ee.f
            private final com.google.android.libraries.navigation.internal.afd.a a;
            private final com.google.android.libraries.navigation.internal.afd.a b;
            private final com.google.android.libraries.navigation.internal.afd.a c;
            private final com.google.android.libraries.navigation.internal.afd.a d;

            {
                Objects.requireNonNull(aVar29);
                this.a = aVar29;
                Objects.requireNonNull(aVar30);
                this.b = aVar30;
                Objects.requireNonNull(aVar31);
                this.c = aVar31;
                Objects.requireNonNull(aVar32);
                this.d = aVar32;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a a() {
                return this.d;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a b() {
                return this.a;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a c() {
                return this.b;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a d() {
                return this.c;
            }

            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof r) {
                    r rVar = (r) obj;
                    if (this.a.equals(rVar.b()) && this.b.equals(rVar.c()) && this.c.equals(rVar.d()) && this.d.equals(rVar.a())) {
                        return true;
                    }
                }
                return false;
            }

            public final int hashCode() {
                return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
            }

            public final String toString() {
                com.google.android.libraries.navigation.internal.afd.a aVar110 = this.d;
                com.google.android.libraries.navigation.internal.afd.a aVar111 = this.c;
                com.google.android.libraries.navigation.internal.afd.a aVar112 = this.b;
                return "{" + this.a.b() + ", " + aVar112.b() + ", " + aVar111.b() + ", " + aVar110.b() + "}";
            }
        };
        s sVar8 = new s();
        n nVarH9 = p.h(3);
        nVarH9.b(l.d(com.google.android.libraries.navigation.internal.adu.m.LOCAL_DISCOVERY_NEWLY_OPENED_PLACES, ":4"));
        nVarH9.d(com.google.android.libraries.navigation.internal.em.a.L);
        nVarH9.c(com.google.android.libraries.navigation.internal.em.a.J);
        j jVar9 = new j("NEARBY_PLACES_EVENTS", 8, sVar8, nVarH9.a());
        i = jVar9;
        final com.google.android.libraries.navigation.internal.afd.a aVar33 = com.google.android.libraries.navigation.internal.afe.i.ae;
        final com.google.android.libraries.navigation.internal.afd.a aVar34 = com.google.android.libraries.navigation.internal.afe.i.ad;
        final com.google.android.libraries.navigation.internal.afd.a aVar35 = com.google.android.libraries.navigation.internal.afe.i.ab;
        final com.google.android.libraries.navigation.internal.afd.a aVar36 = com.google.android.libraries.navigation.internal.afe.i.ac;
        new r(aVar33, aVar34, aVar35, aVar36) { // from class: com.google.android.libraries.navigation.internal.ee.f
            private final com.google.android.libraries.navigation.internal.afd.a a;
            private final com.google.android.libraries.navigation.internal.afd.a b;
            private final com.google.android.libraries.navigation.internal.afd.a c;
            private final com.google.android.libraries.navigation.internal.afd.a d;

            {
                Objects.requireNonNull(aVar33);
                this.a = aVar33;
                Objects.requireNonNull(aVar34);
                this.b = aVar34;
                Objects.requireNonNull(aVar35);
                this.c = aVar35;
                Objects.requireNonNull(aVar36);
                this.d = aVar36;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a a() {
                return this.d;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a b() {
                return this.a;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a c() {
                return this.b;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a d() {
                return this.c;
            }

            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof r) {
                    r rVar = (r) obj;
                    if (this.a.equals(rVar.b()) && this.b.equals(rVar.c()) && this.c.equals(rVar.d()) && this.d.equals(rVar.a())) {
                        return true;
                    }
                }
                return false;
            }

            public final int hashCode() {
                return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
            }

            public final String toString() {
                com.google.android.libraries.navigation.internal.afd.a aVar110 = this.d;
                com.google.android.libraries.navigation.internal.afd.a aVar111 = this.c;
                com.google.android.libraries.navigation.internal.afd.a aVar112 = this.b;
                return "{" + this.a.b() + ", " + aVar112.b() + ", " + aVar111.b() + ", " + aVar110.b() + "}";
            }
        };
        s sVar9 = new s();
        n nVarH10 = p.h(2);
        nVarH10.b(l.d(com.google.android.libraries.navigation.internal.adu.m.LOCAL_DISCOVERY_NEWLY_OPENED_PLACES, ":2"));
        nVarH10.d(com.google.android.libraries.navigation.internal.em.a.e);
        nVarH10.c(com.google.android.libraries.navigation.internal.em.a.d);
        j jVar10 = new j("NEW_TRENDING_PLACES", 9, sVar9, nVarH10.a());
        j = jVar10;
        final com.google.android.libraries.navigation.internal.afd.a aVar37 = com.google.android.libraries.navigation.internal.afe.g.o;
        final com.google.android.libraries.navigation.internal.afd.a aVar38 = com.google.android.libraries.navigation.internal.afe.g.f252n;
        final com.google.android.libraries.navigation.internal.afd.a aVar39 = com.google.android.libraries.navigation.internal.afe.g.l;
        final com.google.android.libraries.navigation.internal.afd.a aVar40 = com.google.android.libraries.navigation.internal.afe.g.m;
        new r(aVar37, aVar38, aVar39, aVar40) { // from class: com.google.android.libraries.navigation.internal.ee.f
            private final com.google.android.libraries.navigation.internal.afd.a a;
            private final com.google.android.libraries.navigation.internal.afd.a b;
            private final com.google.android.libraries.navigation.internal.afd.a c;
            private final com.google.android.libraries.navigation.internal.afd.a d;

            {
                Objects.requireNonNull(aVar37);
                this.a = aVar37;
                Objects.requireNonNull(aVar38);
                this.b = aVar38;
                Objects.requireNonNull(aVar39);
                this.c = aVar39;
                Objects.requireNonNull(aVar40);
                this.d = aVar40;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a a() {
                return this.d;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a b() {
                return this.a;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a c() {
                return this.b;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a d() {
                return this.c;
            }

            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof r) {
                    r rVar = (r) obj;
                    if (this.a.equals(rVar.b()) && this.b.equals(rVar.c()) && this.c.equals(rVar.d()) && this.d.equals(rVar.a())) {
                        return true;
                    }
                }
                return false;
            }

            public final int hashCode() {
                return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
            }

            public final String toString() {
                com.google.android.libraries.navigation.internal.afd.a aVar110 = this.d;
                com.google.android.libraries.navigation.internal.afd.a aVar111 = this.c;
                com.google.android.libraries.navigation.internal.afd.a aVar112 = this.b;
                return "{" + this.a.b() + ", " + aVar112.b() + ", " + aVar111.b() + ", " + aVar110.b() + "}";
            }
        };
        s sVar10 = new s();
        n nVarH11 = p.h(3);
        nVarH11.b(l.d(com.google.android.libraries.navigation.internal.adu.m.POST_CONTRIBUTION_IMPACT, "_1"));
        nVarH11.d(com.google.android.libraries.navigation.internal.em.a.aA);
        nVarH11.c(com.google.android.libraries.navigation.internal.em.a.az);
        nVarH11.e(new e(k.g, 2));
        j jVar11 = new j("LIKES_MILESTONES_BADGES", 10, sVar10, nVarH11.a());
        k = jVar11;
        final com.google.android.libraries.navigation.internal.afd.a aVar41 = com.google.android.libraries.navigation.internal.afe.l.j;
        final com.google.android.libraries.navigation.internal.afd.a aVar42 = com.google.android.libraries.navigation.internal.afe.l.i;
        final com.google.android.libraries.navigation.internal.afd.a aVar43 = com.google.android.libraries.navigation.internal.afe.l.g;
        final com.google.android.libraries.navigation.internal.afd.a aVar44 = com.google.android.libraries.navigation.internal.afe.l.h;
        new r(aVar41, aVar42, aVar43, aVar44) { // from class: com.google.android.libraries.navigation.internal.ee.f
            private final com.google.android.libraries.navigation.internal.afd.a a;
            private final com.google.android.libraries.navigation.internal.afd.a b;
            private final com.google.android.libraries.navigation.internal.afd.a c;
            private final com.google.android.libraries.navigation.internal.afd.a d;

            {
                Objects.requireNonNull(aVar41);
                this.a = aVar41;
                Objects.requireNonNull(aVar42);
                this.b = aVar42;
                Objects.requireNonNull(aVar43);
                this.c = aVar43;
                Objects.requireNonNull(aVar44);
                this.d = aVar44;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a a() {
                return this.d;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a b() {
                return this.a;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a c() {
                return this.b;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a d() {
                return this.c;
            }

            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof r) {
                    r rVar = (r) obj;
                    if (this.a.equals(rVar.b()) && this.b.equals(rVar.c()) && this.c.equals(rVar.d()) && this.d.equals(rVar.a())) {
                        return true;
                    }
                }
                return false;
            }

            public final int hashCode() {
                return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
            }

            public final String toString() {
                com.google.android.libraries.navigation.internal.afd.a aVar110 = this.d;
                com.google.android.libraries.navigation.internal.afd.a aVar111 = this.c;
                com.google.android.libraries.navigation.internal.afd.a aVar112 = this.b;
                return "{" + this.a.b() + ", " + aVar112.b() + ", " + aVar111.b() + ", " + aVar110.b() + "}";
            }
        };
        s sVar11 = new s();
        n nVarH12 = p.h(3);
        nVarH12.b(String.valueOf(k.e).concat("_1"));
        nVarH12.d(com.google.android.libraries.navigation.internal.em.a.al);
        nVarH12.c(com.google.android.libraries.navigation.internal.em.a.ak);
        nVarH12.e(new e(k.e, 2));
        j jVar12 = new j("SUGGESTION_WRITE_REVIEW", 11, sVar11, nVarH12.a());
        l = jVar12;
        final com.google.android.libraries.navigation.internal.afd.a aVar45 = com.google.android.libraries.navigation.internal.afe.l.e;
        final com.google.android.libraries.navigation.internal.afd.a aVar46 = com.google.android.libraries.navigation.internal.afe.l.d;
        final com.google.android.libraries.navigation.internal.afd.a aVar47 = com.google.android.libraries.navigation.internal.afe.l.b;
        final com.google.android.libraries.navigation.internal.afd.a aVar48 = com.google.android.libraries.navigation.internal.afe.l.c;
        new r(aVar45, aVar46, aVar47, aVar48) { // from class: com.google.android.libraries.navigation.internal.ee.f
            private final com.google.android.libraries.navigation.internal.afd.a a;
            private final com.google.android.libraries.navigation.internal.afd.a b;
            private final com.google.android.libraries.navigation.internal.afd.a c;
            private final com.google.android.libraries.navigation.internal.afd.a d;

            {
                Objects.requireNonNull(aVar45);
                this.a = aVar45;
                Objects.requireNonNull(aVar46);
                this.b = aVar46;
                Objects.requireNonNull(aVar47);
                this.c = aVar47;
                Objects.requireNonNull(aVar48);
                this.d = aVar48;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a a() {
                return this.d;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a b() {
                return this.a;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a c() {
                return this.b;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a d() {
                return this.c;
            }

            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof r) {
                    r rVar = (r) obj;
                    if (this.a.equals(rVar.b()) && this.b.equals(rVar.c()) && this.c.equals(rVar.d()) && this.d.equals(rVar.a())) {
                        return true;
                    }
                }
                return false;
            }

            public final int hashCode() {
                return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
            }

            public final String toString() {
                com.google.android.libraries.navigation.internal.afd.a aVar110 = this.d;
                com.google.android.libraries.navigation.internal.afd.a aVar111 = this.c;
                com.google.android.libraries.navigation.internal.afd.a aVar112 = this.b;
                return "{" + this.a.b() + ", " + aVar112.b() + ", " + aVar111.b() + ", " + aVar110.b() + "}";
            }
        };
        s sVar12 = new s();
        n nVarH13 = p.h(3);
        nVarH13.b(String.valueOf(k.f).concat("_1"));
        nVarH13.d(com.google.android.libraries.navigation.internal.em.a.Z);
        nVarH13.c(com.google.android.libraries.navigation.internal.em.a.Y);
        nVarH13.e(new e(k.f, 2));
        j jVar13 = new j("SHARE_TAG_PHOTOS", 12, sVar12, nVarH13.a());
        m = jVar13;
        final com.google.android.libraries.navigation.internal.afd.a aVar49 = com.google.android.libraries.navigation.internal.afe.k.q;
        final com.google.android.libraries.navigation.internal.afd.a aVar50 = com.google.android.libraries.navigation.internal.afe.k.p;
        final com.google.android.libraries.navigation.internal.afd.a aVar51 = com.google.android.libraries.navigation.internal.afe.k.f256n;
        final com.google.android.libraries.navigation.internal.afd.a aVar52 = com.google.android.libraries.navigation.internal.afe.k.o;
        new r(aVar49, aVar50, aVar51, aVar52) { // from class: com.google.android.libraries.navigation.internal.ee.f
            private final com.google.android.libraries.navigation.internal.afd.a a;
            private final com.google.android.libraries.navigation.internal.afd.a b;
            private final com.google.android.libraries.navigation.internal.afd.a c;
            private final com.google.android.libraries.navigation.internal.afd.a d;

            {
                Objects.requireNonNull(aVar49);
                this.a = aVar49;
                Objects.requireNonNull(aVar50);
                this.b = aVar50;
                Objects.requireNonNull(aVar51);
                this.c = aVar51;
                Objects.requireNonNull(aVar52);
                this.d = aVar52;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a a() {
                return this.d;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a b() {
                return this.a;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a c() {
                return this.b;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a d() {
                return this.c;
            }

            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof r) {
                    r rVar = (r) obj;
                    if (this.a.equals(rVar.b()) && this.b.equals(rVar.c()) && this.c.equals(rVar.d()) && this.d.equals(rVar.a())) {
                        return true;
                    }
                }
                return false;
            }

            public final int hashCode() {
                return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
            }

            public final String toString() {
                com.google.android.libraries.navigation.internal.afd.a aVar110 = this.d;
                com.google.android.libraries.navigation.internal.afd.a aVar111 = this.c;
                com.google.android.libraries.navigation.internal.afd.a aVar112 = this.b;
                return "{" + this.a.b() + ", " + aVar112.b() + ", " + aVar111.b() + ", " + aVar110.b() + "}";
            }
        };
        s sVar13 = new s();
        n nVarH14 = p.h(2);
        nVarH14.b(l.d(com.google.android.libraries.navigation.internal.adu.m.RIDDLER, "_1"));
        nVarH14.d(com.google.android.libraries.navigation.internal.em.a.af);
        nVarH14.c(com.google.android.libraries.navigation.internal.em.a.ae);
        j jVar14 = new j("PLACES_YOU_VISITED", 13, sVar13, nVarH14.a());
        f421n = jVar14;
        final com.google.android.libraries.navigation.internal.afd.a aVar53 = com.google.android.libraries.navigation.internal.afe.n.d;
        final com.google.android.libraries.navigation.internal.afd.a aVar54 = com.google.android.libraries.navigation.internal.afe.n.c;
        final com.google.android.libraries.navigation.internal.afd.a aVar55 = com.google.android.libraries.navigation.internal.afe.n.a;
        final com.google.android.libraries.navigation.internal.afd.a aVar56 = com.google.android.libraries.navigation.internal.afe.n.b;
        new r(aVar53, aVar54, aVar55, aVar56) { // from class: com.google.android.libraries.navigation.internal.ee.f
            private final com.google.android.libraries.navigation.internal.afd.a a;
            private final com.google.android.libraries.navigation.internal.afd.a b;
            private final com.google.android.libraries.navigation.internal.afd.a c;
            private final com.google.android.libraries.navigation.internal.afd.a d;

            {
                Objects.requireNonNull(aVar53);
                this.a = aVar53;
                Objects.requireNonNull(aVar54);
                this.b = aVar54;
                Objects.requireNonNull(aVar55);
                this.c = aVar55;
                Objects.requireNonNull(aVar56);
                this.d = aVar56;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a a() {
                return this.d;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a b() {
                return this.a;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a c() {
                return this.b;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a d() {
                return this.c;
            }

            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof r) {
                    r rVar = (r) obj;
                    if (this.a.equals(rVar.b()) && this.b.equals(rVar.c()) && this.c.equals(rVar.d()) && this.d.equals(rVar.a())) {
                        return true;
                    }
                }
                return false;
            }

            public final int hashCode() {
                return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
            }

            public final String toString() {
                com.google.android.libraries.navigation.internal.afd.a aVar110 = this.d;
                com.google.android.libraries.navigation.internal.afd.a aVar111 = this.c;
                com.google.android.libraries.navigation.internal.afd.a aVar112 = this.b;
                return "{" + this.a.b() + ", " + aVar112.b() + ", " + aVar111.b() + ", " + aVar110.b() + "}";
            }
        };
        s sVar14 = new s();
        n nVarH15 = p.h(2);
        nVarH15.b(l.d(com.google.android.libraries.navigation.internal.adu.m.UGC_POST_TRIP_QUESTIONS, "_1"));
        nVarH15.d(com.google.android.libraries.navigation.internal.em.a.aD);
        nVarH15.c(com.google.android.libraries.navigation.internal.em.a.aC);
        j jVar15 = new j("YOUR_AREA_ROADS_TRIPS", 14, sVar14, nVarH15.a());
        o = jVar15;
        final com.google.android.libraries.navigation.internal.afd.a aVar57 = com.google.android.libraries.navigation.internal.afe.h.h;
        final com.google.android.libraries.navigation.internal.afd.a aVar58 = com.google.android.libraries.navigation.internal.afe.h.g;
        final com.google.android.libraries.navigation.internal.afd.a aVar59 = com.google.android.libraries.navigation.internal.afe.h.e;
        final com.google.android.libraries.navigation.internal.afd.a aVar60 = com.google.android.libraries.navigation.internal.afe.h.f;
        new r(aVar57, aVar58, aVar59, aVar60) { // from class: com.google.android.libraries.navigation.internal.ee.f
            private final com.google.android.libraries.navigation.internal.afd.a a;
            private final com.google.android.libraries.navigation.internal.afd.a b;
            private final com.google.android.libraries.navigation.internal.afd.a c;
            private final com.google.android.libraries.navigation.internal.afd.a d;

            {
                Objects.requireNonNull(aVar57);
                this.a = aVar57;
                Objects.requireNonNull(aVar58);
                this.b = aVar58;
                Objects.requireNonNull(aVar59);
                this.c = aVar59;
                Objects.requireNonNull(aVar60);
                this.d = aVar60;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a a() {
                return this.d;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a b() {
                return this.a;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a c() {
                return this.b;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a d() {
                return this.c;
            }

            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof r) {
                    r rVar = (r) obj;
                    if (this.a.equals(rVar.b()) && this.b.equals(rVar.c()) && this.c.equals(rVar.d()) && this.d.equals(rVar.a())) {
                        return true;
                    }
                }
                return false;
            }

            public final int hashCode() {
                return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
            }

            public final String toString() {
                com.google.android.libraries.navigation.internal.afd.a aVar110 = this.d;
                com.google.android.libraries.navigation.internal.afd.a aVar111 = this.c;
                com.google.android.libraries.navigation.internal.afd.a aVar112 = this.b;
                return "{" + this.a.b() + ", " + aVar112.b() + ", " + aVar111.b() + ", " + aVar110.b() + "}";
            }
        };
        s sVar15 = new s();
        n nVarH16 = p.h(4);
        nVarH16.b(l.d(com.google.android.libraries.navigation.internal.adu.m.BUSINESS_MESSAGE_FROM_MERCHANT, "_1"));
        nVarH16.d(com.google.android.libraries.navigation.internal.em.a.h);
        nVarH16.c(com.google.android.libraries.navigation.internal.em.a.g);
        j jVar16 = new j("MESSAGES_FROM_MERCHANT", 15, sVar15, nVarH16.a());
        p = jVar16;
        final com.google.android.libraries.navigation.internal.afd.a aVar61 = com.google.android.libraries.navigation.internal.afe.h.d;
        final com.google.android.libraries.navigation.internal.afd.a aVar62 = com.google.android.libraries.navigation.internal.afe.h.c;
        final com.google.android.libraries.navigation.internal.afd.a aVar63 = com.google.android.libraries.navigation.internal.afe.h.a;
        final com.google.android.libraries.navigation.internal.afd.a aVar64 = com.google.android.libraries.navigation.internal.afe.h.b;
        new r(aVar61, aVar62, aVar63, aVar64) { // from class: com.google.android.libraries.navigation.internal.ee.f
            private final com.google.android.libraries.navigation.internal.afd.a a;
            private final com.google.android.libraries.navigation.internal.afd.a b;
            private final com.google.android.libraries.navigation.internal.afd.a c;
            private final com.google.android.libraries.navigation.internal.afd.a d;

            {
                Objects.requireNonNull(aVar61);
                this.a = aVar61;
                Objects.requireNonNull(aVar62);
                this.b = aVar62;
                Objects.requireNonNull(aVar63);
                this.c = aVar63;
                Objects.requireNonNull(aVar64);
                this.d = aVar64;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a a() {
                return this.d;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a b() {
                return this.a;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a c() {
                return this.b;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a d() {
                return this.c;
            }

            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof r) {
                    r rVar = (r) obj;
                    if (this.a.equals(rVar.b()) && this.b.equals(rVar.c()) && this.c.equals(rVar.d()) && this.d.equals(rVar.a())) {
                        return true;
                    }
                }
                return false;
            }

            public final int hashCode() {
                return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
            }

            public final String toString() {
                com.google.android.libraries.navigation.internal.afd.a aVar110 = this.d;
                com.google.android.libraries.navigation.internal.afd.a aVar111 = this.c;
                com.google.android.libraries.navigation.internal.afd.a aVar112 = this.b;
                return "{" + this.a.b() + ", " + aVar112.b() + ", " + aVar111.b() + ", " + aVar110.b() + "}";
            }
        };
        j jVar17 = new j("MESSAGES_FROM_CUSTOMER", 16, jVar16.I, (p) jVar16.G.get(0));
        q = jVar17;
        final com.google.android.libraries.navigation.internal.afd.a aVar65 = com.google.android.libraries.navigation.internal.afe.e.p;
        final com.google.android.libraries.navigation.internal.afd.a aVar66 = com.google.android.libraries.navigation.internal.afe.e.o;
        final com.google.android.libraries.navigation.internal.afd.a aVar67 = com.google.android.libraries.navigation.internal.afe.e.m;
        final com.google.android.libraries.navigation.internal.afd.a aVar68 = com.google.android.libraries.navigation.internal.afe.e.f251n;
        new r(aVar65, aVar66, aVar67, aVar68) { // from class: com.google.android.libraries.navigation.internal.ee.f
            private final com.google.android.libraries.navigation.internal.afd.a a;
            private final com.google.android.libraries.navigation.internal.afd.a b;
            private final com.google.android.libraries.navigation.internal.afd.a c;
            private final com.google.android.libraries.navigation.internal.afd.a d;

            {
                Objects.requireNonNull(aVar65);
                this.a = aVar65;
                Objects.requireNonNull(aVar66);
                this.b = aVar66;
                Objects.requireNonNull(aVar67);
                this.c = aVar67;
                Objects.requireNonNull(aVar68);
                this.d = aVar68;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a a() {
                return this.d;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a b() {
                return this.a;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a c() {
                return this.b;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a d() {
                return this.c;
            }

            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof r) {
                    r rVar = (r) obj;
                    if (this.a.equals(rVar.b()) && this.b.equals(rVar.c()) && this.c.equals(rVar.d()) && this.d.equals(rVar.a())) {
                        return true;
                    }
                }
                return false;
            }

            public final int hashCode() {
                return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
            }

            public final String toString() {
                com.google.android.libraries.navigation.internal.afd.a aVar110 = this.d;
                com.google.android.libraries.navigation.internal.afd.a aVar111 = this.c;
                com.google.android.libraries.navigation.internal.afd.a aVar112 = this.b;
                return "{" + this.a.b() + ", " + aVar112.b() + ", " + aVar111.b() + ", " + aVar110.b() + "}";
            }
        };
        s sVar16 = new s();
        n nVarH17 = p.h(4);
        nVarH17.b(l.d(com.google.android.libraries.navigation.internal.adu.m.SOCIAL_PLANNING_PLACE_ADDED, "_1"));
        nVarH17.d(com.google.android.libraries.navigation.internal.em.a.k);
        nVarH17.c(com.google.android.libraries.navigation.internal.em.a.j);
        j jVar18 = new j("GROUP_PLANNING", 17, sVar16, nVarH17.a());
        r = jVar18;
        final com.google.android.libraries.navigation.internal.afd.a aVar69 = com.google.android.libraries.navigation.internal.afe.e.l;
        final com.google.android.libraries.navigation.internal.afd.a aVar70 = com.google.android.libraries.navigation.internal.afe.e.k;
        final com.google.android.libraries.navigation.internal.afd.a aVar71 = com.google.android.libraries.navigation.internal.afe.e.i;
        final com.google.android.libraries.navigation.internal.afd.a aVar72 = com.google.android.libraries.navigation.internal.afe.e.j;
        new r(aVar69, aVar70, aVar71, aVar72) { // from class: com.google.android.libraries.navigation.internal.ee.f
            private final com.google.android.libraries.navigation.internal.afd.a a;
            private final com.google.android.libraries.navigation.internal.afd.a b;
            private final com.google.android.libraries.navigation.internal.afd.a c;
            private final com.google.android.libraries.navigation.internal.afd.a d;

            {
                Objects.requireNonNull(aVar69);
                this.a = aVar69;
                Objects.requireNonNull(aVar70);
                this.b = aVar70;
                Objects.requireNonNull(aVar71);
                this.c = aVar71;
                Objects.requireNonNull(aVar72);
                this.d = aVar72;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a a() {
                return this.d;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a b() {
                return this.a;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a c() {
                return this.b;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a d() {
                return this.c;
            }

            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof r) {
                    r rVar = (r) obj;
                    if (this.a.equals(rVar.b()) && this.b.equals(rVar.c()) && this.c.equals(rVar.d()) && this.d.equals(rVar.a())) {
                        return true;
                    }
                }
                return false;
            }

            public final int hashCode() {
                return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
            }

            public final String toString() {
                com.google.android.libraries.navigation.internal.afd.a aVar110 = this.d;
                com.google.android.libraries.navigation.internal.afd.a aVar111 = this.c;
                com.google.android.libraries.navigation.internal.afd.a aVar112 = this.b;
                return "{" + this.a.b() + ", " + aVar112.b() + ", " + aVar111.b() + ", " + aVar110.b() + "}";
            }
        };
        s sVar17 = new s();
        n nVarH18 = p.h(2);
        nVarH18.b(Integer.toString(com.google.android.libraries.navigation.internal.adu.m.TIMELINE_VISIT_CONFIRMATION.eU));
        nVarH18.d(com.google.android.libraries.navigation.internal.em.a.s);
        nVarH18.c(com.google.android.libraries.navigation.internal.em.a.r);
        j jVar19 = new j("GOOGLE_MAPS_TIMELINE", 18, sVar17, nVarH18.a());
        s = jVar19;
        final com.google.android.libraries.navigation.internal.afd.a aVar73 = com.google.android.libraries.navigation.internal.afe.e.d;
        final com.google.android.libraries.navigation.internal.afd.a aVar74 = com.google.android.libraries.navigation.internal.afe.e.c;
        final com.google.android.libraries.navigation.internal.afd.a aVar75 = com.google.android.libraries.navigation.internal.afe.e.a;
        final com.google.android.libraries.navigation.internal.afd.a aVar76 = com.google.android.libraries.navigation.internal.afe.e.b;
        new r(aVar73, aVar74, aVar75, aVar76) { // from class: com.google.android.libraries.navigation.internal.ee.f
            private final com.google.android.libraries.navigation.internal.afd.a a;
            private final com.google.android.libraries.navigation.internal.afd.a b;
            private final com.google.android.libraries.navigation.internal.afd.a c;
            private final com.google.android.libraries.navigation.internal.afd.a d;

            {
                Objects.requireNonNull(aVar73);
                this.a = aVar73;
                Objects.requireNonNull(aVar74);
                this.b = aVar74;
                Objects.requireNonNull(aVar75);
                this.c = aVar75;
                Objects.requireNonNull(aVar76);
                this.d = aVar76;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a a() {
                return this.d;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a b() {
                return this.a;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a c() {
                return this.b;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a d() {
                return this.c;
            }

            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof r) {
                    r rVar = (r) obj;
                    if (this.a.equals(rVar.b()) && this.b.equals(rVar.c()) && this.c.equals(rVar.d()) && this.d.equals(rVar.a())) {
                        return true;
                    }
                }
                return false;
            }

            public final int hashCode() {
                return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
            }

            public final String toString() {
                com.google.android.libraries.navigation.internal.afd.a aVar110 = this.d;
                com.google.android.libraries.navigation.internal.afd.a aVar111 = this.c;
                com.google.android.libraries.navigation.internal.afd.a aVar112 = this.b;
                return "{" + this.a.b() + ", " + aVar112.b() + ", " + aVar111.b() + ", " + aVar110.b() + "}";
            }
        };
        s sVar18 = new s();
        n nVarH19 = p.h(4);
        nVarH19.b(Integer.toString(com.google.android.libraries.navigation.internal.adu.m.SHARED_LOCATION_RECEIVED.eU));
        nVarH19.d(com.google.android.libraries.navigation.internal.em.a.y);
        nVarH19.c(com.google.android.libraries.navigation.internal.em.a.x);
        j jVar20 = new j("GOOGLE_LOCATION_SHARING_FRIENDS", 19, sVar18, nVarH19.a());
        t = jVar20;
        final com.google.android.libraries.navigation.internal.afd.a aVar77 = com.google.android.libraries.navigation.internal.afe.e.h;
        final com.google.android.libraries.navigation.internal.afd.a aVar78 = com.google.android.libraries.navigation.internal.afe.e.g;
        final com.google.android.libraries.navigation.internal.afd.a aVar79 = com.google.android.libraries.navigation.internal.afe.e.e;
        final com.google.android.libraries.navigation.internal.afd.a aVar80 = com.google.android.libraries.navigation.internal.afe.e.f;
        new r(aVar77, aVar78, aVar79, aVar80) { // from class: com.google.android.libraries.navigation.internal.ee.f
            private final com.google.android.libraries.navigation.internal.afd.a a;
            private final com.google.android.libraries.navigation.internal.afd.a b;
            private final com.google.android.libraries.navigation.internal.afd.a c;
            private final com.google.android.libraries.navigation.internal.afd.a d;

            {
                Objects.requireNonNull(aVar77);
                this.a = aVar77;
                Objects.requireNonNull(aVar78);
                this.b = aVar78;
                Objects.requireNonNull(aVar79);
                this.c = aVar79;
                Objects.requireNonNull(aVar80);
                this.d = aVar80;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a a() {
                return this.d;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a b() {
                return this.a;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a c() {
                return this.b;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a d() {
                return this.c;
            }

            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof r) {
                    r rVar = (r) obj;
                    if (this.a.equals(rVar.b()) && this.b.equals(rVar.c()) && this.c.equals(rVar.d()) && this.d.equals(rVar.a())) {
                        return true;
                    }
                }
                return false;
            }

            public final int hashCode() {
                return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
            }

            public final String toString() {
                com.google.android.libraries.navigation.internal.afd.a aVar110 = this.d;
                com.google.android.libraries.navigation.internal.afd.a aVar111 = this.c;
                com.google.android.libraries.navigation.internal.afd.a aVar112 = this.b;
                return "{" + this.a.b() + ", " + aVar112.b() + ", " + aVar111.b() + ", " + aVar110.b() + "}";
            }
        };
        s sVar19 = new s();
        n nVarH20 = p.h(4);
        nVarH20.b(Integer.toString(com.google.android.libraries.navigation.internal.adu.m.SHARED_LOCATION_REQUEST.eU));
        nVarH20.d(com.google.android.libraries.navigation.internal.em.a.D);
        nVarH20.c(com.google.android.libraries.navigation.internal.em.a.C);
        j jVar21 = new j("GOOGLE_LOCATION_SHARING_YOU", 20, sVar19, nVarH20.a());
        u = jVar21;
        final com.google.android.libraries.navigation.internal.afd.a aVar81 = com.google.android.libraries.navigation.internal.afe.b.d;
        final com.google.android.libraries.navigation.internal.afd.a aVar82 = com.google.android.libraries.navigation.internal.afe.b.c;
        final com.google.android.libraries.navigation.internal.afd.a aVar83 = com.google.android.libraries.navigation.internal.afe.b.a;
        final com.google.android.libraries.navigation.internal.afd.a aVar84 = com.google.android.libraries.navigation.internal.afe.b.b;
        new r(aVar81, aVar82, aVar83, aVar84) { // from class: com.google.android.libraries.navigation.internal.ee.f
            private final com.google.android.libraries.navigation.internal.afd.a a;
            private final com.google.android.libraries.navigation.internal.afd.a b;
            private final com.google.android.libraries.navigation.internal.afd.a c;
            private final com.google.android.libraries.navigation.internal.afd.a d;

            {
                Objects.requireNonNull(aVar81);
                this.a = aVar81;
                Objects.requireNonNull(aVar82);
                this.b = aVar82;
                Objects.requireNonNull(aVar83);
                this.c = aVar83;
                Objects.requireNonNull(aVar84);
                this.d = aVar84;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a a() {
                return this.d;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a b() {
                return this.a;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a c() {
                return this.b;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a d() {
                return this.c;
            }

            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof r) {
                    r rVar = (r) obj;
                    if (this.a.equals(rVar.b()) && this.b.equals(rVar.c()) && this.c.equals(rVar.d()) && this.d.equals(rVar.a())) {
                        return true;
                    }
                }
                return false;
            }

            public final int hashCode() {
                return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
            }

            public final String toString() {
                com.google.android.libraries.navigation.internal.afd.a aVar110 = this.d;
                com.google.android.libraries.navigation.internal.afd.a aVar111 = this.c;
                com.google.android.libraries.navigation.internal.afd.a aVar112 = this.b;
                return "{" + this.a.b() + ", " + aVar112.b() + ", " + aVar111.b() + ", " + aVar110.b() + "}";
            }
        };
        s sVar20 = new s();
        n nVarH21 = p.h(2);
        nVarH21.b(l.d(com.google.android.libraries.navigation.internal.adu.m.COMMUTE_SETUP, "_1"));
        nVarH21.d(com.google.android.libraries.navigation.internal.em.a.f423n);
        nVarH21.c(com.google.android.libraries.navigation.internal.em.a.m);
        n nVarH22 = p.h(4);
        nVarH22.b(l.d(com.google.android.libraries.navigation.internal.adu.m.COMMUTE_SETUP, "_2"));
        nVarH22.d(com.google.android.libraries.navigation.internal.em.a.u);
        nVarH22.c(com.google.android.libraries.navigation.internal.em.a.t);
        j jVar22 = new j("COMMUTE_PROFILE", 21, sVar20, nVarH21.a(), nVarH22.a());
        v = jVar22;
        final com.google.android.libraries.navigation.internal.afd.a aVar85 = com.google.android.libraries.navigation.internal.afe.i.aa;
        final com.google.android.libraries.navigation.internal.afd.a aVar86 = com.google.android.libraries.navigation.internal.afe.i.Z;
        final com.google.android.libraries.navigation.internal.afd.a aVar87 = com.google.android.libraries.navigation.internal.afe.i.X;
        final com.google.android.libraries.navigation.internal.afd.a aVar88 = com.google.android.libraries.navigation.internal.afe.i.Y;
        new r(aVar85, aVar86, aVar87, aVar88) { // from class: com.google.android.libraries.navigation.internal.ee.f
            private final com.google.android.libraries.navigation.internal.afd.a a;
            private final com.google.android.libraries.navigation.internal.afd.a b;
            private final com.google.android.libraries.navigation.internal.afd.a c;
            private final com.google.android.libraries.navigation.internal.afd.a d;

            {
                Objects.requireNonNull(aVar85);
                this.a = aVar85;
                Objects.requireNonNull(aVar86);
                this.b = aVar86;
                Objects.requireNonNull(aVar87);
                this.c = aVar87;
                Objects.requireNonNull(aVar88);
                this.d = aVar88;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a a() {
                return this.d;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a b() {
                return this.a;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a c() {
                return this.b;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a d() {
                return this.c;
            }

            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof r) {
                    r rVar = (r) obj;
                    if (this.a.equals(rVar.b()) && this.b.equals(rVar.c()) && this.c.equals(rVar.d()) && this.d.equals(rVar.a())) {
                        return true;
                    }
                }
                return false;
            }

            public final int hashCode() {
                return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
            }

            public final String toString() {
                com.google.android.libraries.navigation.internal.afd.a aVar110 = this.d;
                com.google.android.libraries.navigation.internal.afd.a aVar111 = this.c;
                com.google.android.libraries.navigation.internal.afd.a aVar112 = this.b;
                return "{" + this.a.b() + ", " + aVar112.b() + ", " + aVar111.b() + ", " + aVar110.b() + "}";
            }
        };
        s sVar21 = new s();
        n nVarH23 = p.h(2);
        nVarH23.b(l.d(com.google.android.libraries.navigation.internal.adu.m.ANNOUNCEMENTS, "_1"));
        nVarH23.d(com.google.android.libraries.navigation.internal.em.a.M);
        nVarH23.c(com.google.android.libraries.navigation.internal.em.a.O);
        j jVar23 = new j("NEW_ON_MAPS", 22, sVar21, nVarH23.a());
        w = jVar23;
        n nVarH24 = p.h(2);
        nVarH24.b(Integer.toString(com.google.android.libraries.navigation.internal.adu.m.LOCATION_SHARING_ONGOING_BURSTING.eU));
        nVarH24.d(com.google.android.libraries.navigation.internal.em.a.A);
        nVarH24.c(com.google.android.libraries.navigation.internal.em.a.z);
        j jVar24 = new j("GOOGLE_LOCATION_SHARING_UPDATES", 23, null, nVarH24.a());
        x = jVar24;
        final com.google.android.libraries.navigation.internal.afd.a aVar89 = com.google.android.libraries.navigation.internal.afe.n.m;
        final com.google.android.libraries.navigation.internal.afd.a aVar90 = com.google.android.libraries.navigation.internal.afe.n.l;
        final com.google.android.libraries.navigation.internal.afd.a aVar91 = com.google.android.libraries.navigation.internal.afe.n.j;
        final com.google.android.libraries.navigation.internal.afd.a aVar92 = com.google.android.libraries.navigation.internal.afe.n.k;
        new r(aVar89, aVar90, aVar91, aVar92) { // from class: com.google.android.libraries.navigation.internal.ee.f
            private final com.google.android.libraries.navigation.internal.afd.a a;
            private final com.google.android.libraries.navigation.internal.afd.a b;
            private final com.google.android.libraries.navigation.internal.afd.a c;
            private final com.google.android.libraries.navigation.internal.afd.a d;

            {
                Objects.requireNonNull(aVar89);
                this.a = aVar89;
                Objects.requireNonNull(aVar90);
                this.b = aVar90;
                Objects.requireNonNull(aVar91);
                this.c = aVar91;
                Objects.requireNonNull(aVar92);
                this.d = aVar92;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a a() {
                return this.d;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a b() {
                return this.a;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a c() {
                return this.b;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a d() {
                return this.c;
            }

            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof r) {
                    r rVar = (r) obj;
                    if (this.a.equals(rVar.b()) && this.b.equals(rVar.c()) && this.c.equals(rVar.d()) && this.d.equals(rVar.a())) {
                        return true;
                    }
                }
                return false;
            }

            public final int hashCode() {
                return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
            }

            public final String toString() {
                com.google.android.libraries.navigation.internal.afd.a aVar110 = this.d;
                com.google.android.libraries.navigation.internal.afd.a aVar111 = this.c;
                com.google.android.libraries.navigation.internal.afd.a aVar112 = this.b;
                return "{" + this.a.b() + ", " + aVar112.b() + ", " + aVar111.b() + ", " + aVar110.b() + "}";
            }
        };
        s sVar22 = new s();
        n nVarH25 = p.h(2);
        nVarH25.b(l.d(com.google.android.libraries.navigation.internal.adu.m.PEOPLE_FOLLOW_NEW_FOLLOWER, "_1"));
        nVarH25.d(com.google.android.libraries.navigation.internal.em.a.aJ);
        nVarH25.c(com.google.android.libraries.navigation.internal.em.a.aI);
        j jVar25 = new j("YOUR_PROFILE_AND_FOLLOWING", 24, sVar22, nVarH25.a());
        y = jVar25;
        s sVar23 = new s();
        n nVarH26 = p.h(2);
        nVarH26.b(l.d(com.google.android.libraries.navigation.internal.adu.m.ACCOUNT_SETTINGS, "_LOW"));
        nVarH26.d(com.google.android.libraries.navigation.internal.em.a.b);
        nVarH26.c(com.google.android.libraries.navigation.internal.em.a.a);
        n nVarH27 = p.h(4);
        nVarH27.b(l.d(com.google.android.libraries.navigation.internal.adu.m.ACCOUNT_SETTINGS, "_HIGH"));
        nVarH27.d(com.google.android.libraries.navigation.internal.em.a.b);
        nVarH27.c(com.google.android.libraries.navigation.internal.em.a.a);
        j jVar26 = new j("ACCOUNT_SETTINGS", 25, sVar23, nVarH26.a(), nVarH27.a());
        z = jVar26;
        final com.google.android.libraries.navigation.internal.afd.a aVar93 = com.google.android.libraries.navigation.internal.afe.n.h;
        final com.google.android.libraries.navigation.internal.afd.a aVar94 = com.google.android.libraries.navigation.internal.afe.n.g;
        final com.google.android.libraries.navigation.internal.afd.a aVar95 = com.google.android.libraries.navigation.internal.afe.n.e;
        final com.google.android.libraries.navigation.internal.afd.a aVar96 = com.google.android.libraries.navigation.internal.afe.n.f;
        new r(aVar93, aVar94, aVar95, aVar96) { // from class: com.google.android.libraries.navigation.internal.ee.f
            private final com.google.android.libraries.navigation.internal.afd.a a;
            private final com.google.android.libraries.navigation.internal.afd.a b;
            private final com.google.android.libraries.navigation.internal.afd.a c;
            private final com.google.android.libraries.navigation.internal.afd.a d;

            {
                Objects.requireNonNull(aVar93);
                this.a = aVar93;
                Objects.requireNonNull(aVar94);
                this.b = aVar94;
                Objects.requireNonNull(aVar95);
                this.c = aVar95;
                Objects.requireNonNull(aVar96);
                this.d = aVar96;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a a() {
                return this.d;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a b() {
                return this.a;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a c() {
                return this.b;
            }

            @Override // com.google.android.libraries.navigation.internal.ee.r
            public final com.google.android.libraries.navigation.internal.afd.a d() {
                return this.c;
            }

            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof r) {
                    r rVar = (r) obj;
                    if (this.a.equals(rVar.b()) && this.b.equals(rVar.c()) && this.c.equals(rVar.d()) && this.d.equals(rVar.a())) {
                        return true;
                    }
                }
                return false;
            }

            public final int hashCode() {
                return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
            }

            public final String toString() {
                com.google.android.libraries.navigation.internal.afd.a aVar110 = this.d;
                com.google.android.libraries.navigation.internal.afd.a aVar111 = this.c;
                com.google.android.libraries.navigation.internal.afd.a aVar112 = this.b;
                return "{" + this.a.b() + ", " + aVar112.b() + ", " + aVar111.b() + ", " + aVar110.b() + "}";
            }
        };
        s sVar24 = new s();
        n nVarH28 = p.h(3);
        nVarH28.b(l.d(com.google.android.libraries.navigation.internal.adu.m.BUSINESS_LISTINGS, "_1"));
        nVarH28.d(com.google.android.libraries.navigation.internal.em.a.aE);
        nVarH28.c(com.google.android.libraries.navigation.internal.em.a.aG);
        j jVar27 = new j("YOUR_BUSINESS", 26, sVar24, nVarH28.a());
        A = jVar27;
        p pVar = k.k;
        j jVar28 = new j("NAVIGATION_PRIORITY_BASED", 27, null, k.j, pVar);
        B = jVar28;
        j jVar29 = new j("NAVIGATION_URGENT", 28, null, pVar);
        C = jVar29;
        n nVarH29 = p.h(4);
        nVarH29.b(k.i);
        nVarH29.d(com.google.android.libraries.navigation.internal.em.a.F);
        j jVar30 = new j("MAPS_FEATURES_URGENT", 29, null, nVarH29.a());
        D = jVar30;
        n nVarH30 = p.h(2);
        nVarH30.b(Integer.toString(com.google.android.libraries.navigation.internal.adu.m.NAVIGATION_DONATE_SESSION.eU));
        nVarH30.d(com.google.android.libraries.navigation.internal.em.a.o);
        j jVar31 = new j("MAPS_FEATURES_DEBUG", 30, null, nVarH30.a());
        E = jVar31;
        j jVar32 = new j("OTHER", 31, null, com.google.android.libraries.navigation.internal.eg.a.a);
        F = jVar32;
        H = new j[]{jVar, jVar2, jVar3, jVar4, jVar5, jVar6, jVar7, jVar8, jVar9, jVar10, jVar11, jVar12, jVar13, jVar14, jVar15, jVar16, jVar17, jVar18, jVar19, jVar20, jVar21, jVar22, jVar23, jVar24, jVar25, jVar26, jVar27, jVar28, jVar29, jVar30, jVar31, jVar32};
    }

    private j(String str, int i2, s sVar, p... pVarArr) {
        super(str, i2);
        this.I = sVar;
        this.G = ev.p(pVarArr);
    }

    public static j[] values() {
        return (j[]) H.clone();
    }
}
