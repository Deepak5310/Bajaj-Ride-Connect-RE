package com.google.android.libraries.navigation.internal.tt;

import com.google.android.libraries.navigation.internal.adr.Cdo;
import com.google.android.libraries.navigation.internal.adr.eu;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;
import com.google.maps.android.BuildConfig;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends d {
    public final com.google.android.libraries.navigation.internal.hc.a A;
    public final com.google.android.libraries.navigation.internal.hc.a B;
    public final com.google.android.libraries.navigation.internal.hc.a C;
    public final com.google.android.libraries.navigation.internal.hc.a D;
    public final ev E;
    public final int F;
    public final long a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final Cdo h;
    public final Integer i;
    public final String j;
    public final String k;
    public final boolean l;
    public final boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f603n;
    public final Long o;
    public final Long p;
    public final String q;
    public final String r;
    public final String s;
    public final com.google.android.libraries.navigation.internal.hc.a t;
    public final com.google.android.libraries.navigation.internal.hc.a u;
    public final com.google.android.libraries.navigation.internal.hc.a v;
    public final com.google.android.libraries.navigation.internal.hc.a w;
    public final com.google.android.libraries.navigation.internal.hc.a x;
    public final float y;
    public final boolean z;

    public b(long j, String str, String str2, String str3, String str4, String str5, String str6, Cdo cdo, Integer num, String str7, String str8, boolean z, boolean z2, String str9, Long l, Long l2, String str10, String str11, String str12, int i, com.google.android.libraries.navigation.internal.hc.a aVar, com.google.android.libraries.navigation.internal.hc.a aVar2, com.google.android.libraries.navigation.internal.hc.a aVar3, com.google.android.libraries.navigation.internal.hc.a aVar4, com.google.android.libraries.navigation.internal.hc.a aVar5, float f, boolean z3, com.google.android.libraries.navigation.internal.hc.a aVar6, com.google.android.libraries.navigation.internal.hc.a aVar7, com.google.android.libraries.navigation.internal.hc.a aVar8, com.google.android.libraries.navigation.internal.hc.a aVar9, ev evVar) {
        this.a = j;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = cdo;
        this.i = num;
        this.j = str7;
        this.k = str8;
        this.l = z;
        this.m = z2;
        this.f603n = str9;
        this.o = l;
        this.p = l2;
        this.q = str10;
        this.r = str11;
        this.s = str12;
        this.F = i;
        this.t = aVar;
        this.u = aVar2;
        this.v = aVar3;
        this.w = aVar4;
        this.x = aVar5;
        this.y = f;
        this.z = z3;
        this.A = aVar6;
        this.B = aVar7;
        this.C = aVar8;
        this.D = aVar9;
        this.E = evVar;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.d
    public final String A() {
        return this.q;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.d
    public final String B() {
        return this.k;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.d
    public final boolean C() {
        return this.m;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.d
    public final boolean D() {
        return this.l;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.d
    public final boolean E() {
        return this.z;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.d
    public final int F() {
        return this.F;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.d
    public final float a() {
        return this.y;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.d
    public final long b() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.d
    public final com.google.android.libraries.navigation.internal.hc.a c() {
        return this.u;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.d
    public final com.google.android.libraries.navigation.internal.hc.a d() {
        return this.B;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.d
    public final com.google.android.libraries.navigation.internal.hc.a e() {
        return this.C;
    }

    public final boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Cdo cdo;
        Integer num;
        String str6;
        String str7;
        String str8;
        Long l;
        Long l2;
        String str9;
        String str10;
        String str11;
        int i;
        com.google.android.libraries.navigation.internal.hc.a aVar;
        com.google.android.libraries.navigation.internal.hc.a aVar2;
        com.google.android.libraries.navigation.internal.hc.a aVar3;
        com.google.android.libraries.navigation.internal.hc.a aVar4;
        com.google.android.libraries.navigation.internal.hc.a aVar5;
        com.google.android.libraries.navigation.internal.hc.a aVar6;
        com.google.android.libraries.navigation.internal.hc.a aVar7;
        com.google.android.libraries.navigation.internal.hc.a aVar8;
        com.google.android.libraries.navigation.internal.hc.a aVar9;
        ev evVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.a == dVar.b() && this.b.equals(dVar.q()) && ((str = this.c) != null ? str.equals(dVar.z()) : dVar.z() == null) && ((str2 = this.d) != null ? str2.equals(dVar.t()) : dVar.t() == null) && ((str3 = this.e) != null ? str3.equals(dVar.y()) : dVar.y() == null) && ((str4 = this.f) != null ? str4.equals(dVar.s()) : dVar.s() == null) && ((str5 = this.g) != null ? str5.equals(dVar.v()) : dVar.v() == null) && ((cdo = this.h) != null ? cdo.equals(dVar.m()) : dVar.m() == null) && ((num = this.i) != null ? num.equals(dVar.n()) : dVar.n() == null) && ((str6 = this.j) != null ? str6.equals(dVar.r()) : dVar.r() == null) && ((str7 = this.k) != null ? str7.equals(dVar.B()) : dVar.B() == null) && this.l == dVar.D() && this.m == dVar.C() && ((str8 = this.f603n) != null ? str8.equals(dVar.w()) : dVar.w() == null) && ((l = this.o) != null ? l.equals(dVar.o()) : dVar.o() == null) && ((l2 = this.p) != null ? l2.equals(dVar.p()) : dVar.p() == null) && ((str9 = this.q) != null ? str9.equals(dVar.A()) : dVar.A() == null) && ((str10 = this.r) != null ? str10.equals(dVar.u()) : dVar.u() == null) && ((str11 = this.s) != null ? str11.equals(dVar.x()) : dVar.x() == null) && ((i = this.F) != 0 ? i == dVar.F() : dVar.F() == 0) && ((aVar = this.t) != null ? aVar.equals(dVar.f()) : dVar.f() == null) && ((aVar2 = this.u) != null ? aVar2.equals(dVar.c()) : dVar.c() == null) && ((aVar3 = this.v) != null ? aVar3.equals(dVar.j()) : dVar.j() == null) && ((aVar4 = this.w) != null ? aVar4.equals(dVar.i()) : dVar.i() == null) && ((aVar5 = this.x) != null ? aVar5.equals(dVar.h()) : dVar.h() == null) && Float.floatToIntBits(this.y) == Float.floatToIntBits(dVar.a()) && this.z == dVar.E() && ((aVar6 = this.A) != null ? aVar6.equals(dVar.g()) : dVar.g() == null) && ((aVar7 = this.B) != null ? aVar7.equals(dVar.d()) : dVar.d() == null) && ((aVar8 = this.C) != null ? aVar8.equals(dVar.e()) : dVar.e() == null) && ((aVar9 = this.D) != null ? aVar9.equals(dVar.k()) : dVar.k() == null) && ((evVar = this.E) != null ? hx.i(evVar, dVar.l()) : dVar.l() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.d
    public final com.google.android.libraries.navigation.internal.hc.a f() {
        return this.t;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.d
    public final com.google.android.libraries.navigation.internal.hc.a g() {
        return this.A;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.d
    public final com.google.android.libraries.navigation.internal.hc.a h() {
        return this.x;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.d
    public final com.google.android.libraries.navigation.internal.hc.a i() {
        return this.w;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.d
    public final com.google.android.libraries.navigation.internal.hc.a j() {
        return this.v;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.d
    public final com.google.android.libraries.navigation.internal.hc.a k() {
        return this.D;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.d
    public final ev l() {
        return this.E;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.d
    public final Cdo m() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.d
    public final Integer n() {
        return this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.d
    public final Long o() {
        return this.o;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.d
    public final Long p() {
        return this.p;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.d
    public final String q() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.d
    public final String r() {
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.d
    public final String s() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.d
    public final String t() {
        return this.d;
    }

    public final String toString() {
        int i = this.F;
        String strValueOf = String.valueOf(this.h);
        String string$ar$edu$f90caec3_0 = i != 0 ? eu.toString$ar$edu$f90caec3_0(i) : BuildConfig.TRAVIS;
        com.google.android.libraries.navigation.internal.hc.a aVar = this.t;
        com.google.android.libraries.navigation.internal.hc.a aVar2 = this.u;
        com.google.android.libraries.navigation.internal.hc.a aVar3 = this.v;
        com.google.android.libraries.navigation.internal.hc.a aVar4 = this.w;
        com.google.android.libraries.navigation.internal.hc.a aVar5 = this.x;
        com.google.android.libraries.navigation.internal.hc.a aVar6 = this.A;
        com.google.android.libraries.navigation.internal.hc.a aVar7 = this.B;
        com.google.android.libraries.navigation.internal.hc.a aVar8 = this.C;
        com.google.android.libraries.navigation.internal.hc.a aVar9 = this.D;
        ev evVar = this.E;
        String strValueOf2 = String.valueOf(string$ar$edu$f90caec3_0);
        String strValueOf3 = String.valueOf(aVar);
        String strValueOf4 = String.valueOf(aVar2);
        String strValueOf5 = String.valueOf(aVar3);
        String strValueOf6 = String.valueOf(aVar4);
        String strValueOf7 = String.valueOf(aVar5);
        String strValueOf8 = String.valueOf(aVar6);
        String strValueOf9 = String.valueOf(aVar7);
        String strValueOf10 = String.valueOf(aVar8);
        String strValueOf11 = String.valueOf(aVar9);
        String strValueOf12 = String.valueOf(evVar);
        StringBuilder sb = new StringBuilder("{");
        sb.append(this.a);
        sb.append(", ");
        sb.append(this.b);
        sb.append(", ");
        sb.append(this.c);
        sb.append(", ");
        sb.append(this.d);
        sb.append(", ");
        sb.append(this.e);
        sb.append(", ");
        sb.append(this.f);
        sb.append(", ");
        sb.append(this.g);
        sb.append(", ");
        sb.append(strValueOf);
        sb.append(", ");
        sb.append(this.i);
        sb.append(", ");
        sb.append(this.j);
        sb.append(", ");
        sb.append(this.k);
        sb.append(", ");
        sb.append(this.l);
        sb.append(", ");
        sb.append(this.m);
        sb.append(", ");
        sb.append(this.f603n);
        sb.append(", ");
        sb.append(this.o);
        sb.append(", ");
        sb.append(this.p);
        sb.append(", ");
        sb.append(this.q);
        sb.append(", ");
        sb.append(this.r);
        String str = this.s;
        float f = this.y;
        boolean z = this.z;
        sb.append(", ");
        sb.append(str);
        sb.append(", ");
        sb.append(strValueOf2);
        sb.append(", ");
        sb.append(strValueOf3);
        sb.append(", ");
        sb.append(strValueOf4);
        sb.append(", ");
        sb.append(strValueOf5);
        sb.append(", ");
        sb.append(strValueOf6);
        sb.append(", ");
        sb.append(strValueOf7);
        sb.append(", ");
        sb.append(f);
        sb.append(", ");
        sb.append(z);
        sb.append(", ");
        sb.append(strValueOf8);
        sb.append(", ");
        sb.append(strValueOf9);
        sb.append(", ");
        sb.append(strValueOf10);
        sb.append(", ");
        sb.append(strValueOf11);
        sb.append(", ");
        sb.append(strValueOf12);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.libraries.navigation.internal.tt.d
    public final String u() {
        return this.r;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.d
    public final String v() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.d
    public final String w() {
        return this.f603n;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.d
    public final String x() {
        return this.s;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.d
    public final String y() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.tt.d
    public final String z() {
        return this.c;
    }

    public final int hashCode() {
        long j = this.a;
        int iHashCode = ((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.b.hashCode();
        String str = this.c;
        int iHashCode2 = ((iHashCode * 1000003) ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.d;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.e;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f;
        int iHashCode5 = (iHashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.g;
        int iHashCode6 = (iHashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        Cdo cdo = this.h;
        int iHashCode7 = (iHashCode6 ^ (cdo == null ? 0 : cdo.hashCode())) * 1000003;
        Integer num = this.i;
        int iHashCode8 = (iHashCode7 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str6 = this.j;
        int iHashCode9 = (iHashCode8 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.k;
        int iHashCode10 = (((((iHashCode9 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003) ^ (true != this.l ? 1237 : 1231)) * 1000003) ^ (true != this.m ? 1237 : 1231)) * 1000003;
        String str8 = this.f603n;
        int iHashCode11 = (iHashCode10 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        Long l = this.o;
        int iHashCode12 = (iHashCode11 ^ (l == null ? 0 : l.hashCode())) * 1000003;
        Long l2 = this.p;
        int iHashCode13 = (iHashCode12 ^ (l2 == null ? 0 : l2.hashCode())) * 1000003;
        String str9 = this.q;
        int iHashCode14 = (iHashCode13 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.r;
        int iHashCode15 = (iHashCode14 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.s;
        int iHashCode16 = (iHashCode15 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        int i = this.F;
        int iA = (iHashCode16 ^ (i == 0 ? 0 : eu.a(i))) * 1000003;
        com.google.android.libraries.navigation.internal.hc.a aVar = this.t;
        int iHashCode17 = (iA ^ (aVar == null ? 0 : aVar.hashCode())) * 1000003;
        com.google.android.libraries.navigation.internal.hc.a aVar2 = this.u;
        int iHashCode18 = (iHashCode17 ^ (aVar2 == null ? 0 : aVar2.hashCode())) * 1000003;
        com.google.android.libraries.navigation.internal.hc.a aVar3 = this.v;
        int iHashCode19 = (iHashCode18 ^ (aVar3 == null ? 0 : aVar3.hashCode())) * 1000003;
        com.google.android.libraries.navigation.internal.hc.a aVar4 = this.w;
        int iHashCode20 = (iHashCode19 ^ (aVar4 == null ? 0 : aVar4.hashCode())) * 1000003;
        com.google.android.libraries.navigation.internal.hc.a aVar5 = this.x;
        int iHashCode21 = (((((iHashCode20 ^ (aVar5 == null ? 0 : aVar5.hashCode())) * 1000003) ^ Float.floatToIntBits(this.y)) * 1000003) ^ (true == this.z ? 1231 : 1237)) * 1000003;
        com.google.android.libraries.navigation.internal.hc.a aVar6 = this.A;
        int iHashCode22 = (iHashCode21 ^ (aVar6 == null ? 0 : aVar6.hashCode())) * 1000003;
        com.google.android.libraries.navigation.internal.hc.a aVar7 = this.B;
        int iHashCode23 = (iHashCode22 ^ (aVar7 == null ? 0 : aVar7.hashCode())) * 1000003;
        com.google.android.libraries.navigation.internal.hc.a aVar8 = this.C;
        int iHashCode24 = (iHashCode23 ^ (aVar8 == null ? 0 : aVar8.hashCode())) * 1000003;
        com.google.android.libraries.navigation.internal.hc.a aVar9 = this.D;
        int iHashCode25 = (iHashCode24 ^ (aVar9 == null ? 0 : aVar9.hashCode())) * 1000003;
        ev evVar = this.E;
        return iHashCode25 ^ (evVar != null ? evVar.hashCode() : 0);
    }
}
