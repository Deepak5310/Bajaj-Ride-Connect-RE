package com.google.android.libraries.navigation.internal.bl;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.navigation.internal.aap.l;
import com.google.android.libraries.navigation.internal.adr.en;
import com.google.android.libraries.navigation.internal.adr.hs;
import com.google.android.libraries.navigation.internal.adr.hu;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.gw.o;
import com.google.android.libraries.navigation.internal.gw.x;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    private static final a[] a;

    /* JADX INFO: compiled from: PG */
    public class a implements Parcelable {
        public static final Parcelable.Creator<a> CREATOR = new c();
        public final l a;
        protected final hs b;
        public final boolean c;
        public final int d;

        public a() {
            this.a = null;
            this.b = null;
            this.c = false;
            this.d = 0;
        }

        public a(Parcel parcel) {
            this.a = l.b(parcel.readInt());
            this.b = hs.b(parcel.readInt());
            this.c = parcel.readInt() != 0;
            this.d = parcel.readInt();
        }

        public a(l lVar, hs hsVar, boolean z, int i) {
            this.a = lVar;
            this.b = hsVar;
            this.c = z;
            this.d = i;
        }

        public boolean a(l lVar, hs hsVar, hu huVar, int i) {
            if (this.a != lVar) {
                return false;
            }
            return this.b == hs.SIDE_UNSPECIFIED || this.b == hsVar;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            l lVar = this.a;
            parcel.writeInt(lVar == null ? -1 : lVar.F);
            hs hsVar = this.b;
            parcel.writeInt(hsVar != null ? hsVar.d : -1);
            parcel.writeInt(this.c ? 1 : 0);
            parcel.writeInt(this.d);
        }
    }

    static {
        l lVar = l.ROUNDABOUT_ENTER;
        hs hsVar = hs.SIDE_UNSPECIFIED;
        hu huVar = hu.TURN_UNKNOWN;
        int i = com.google.android.libraries.navigation.internal.v.c.f;
        l lVar2 = l.ROUNDABOUT_EXIT;
        int i2 = com.google.android.libraries.navigation.internal.v.c.g;
        a = new a[]{new a(l.MANEUVER_UNKNOWN, hs.SIDE_UNSPECIFIED, false, com.google.android.libraries.navigation.internal.bx.f.b), new a(l.DEPART, hs.SIDE_UNSPECIFIED, false, com.google.android.libraries.navigation.internal.v.c.b), new a(l.DESTINATION, hs.SIDE_RIGHT, false, com.google.android.libraries.navigation.internal.v.c.a), new a(l.DESTINATION, hs.SIDE_LEFT, true, com.google.android.libraries.navigation.internal.v.c.a), new a(l.DESTINATION, hs.SIDE_UNSPECIFIED, false, com.google.android.libraries.navigation.internal.bx.f.d), new a(l.NAME_CHANGE, hs.SIDE_UNSPECIFIED, false, com.google.android.libraries.navigation.internal.v.c.p), new h(hs.SIDE_LEFT, hu.TURN_NORMAL, true, com.google.android.libraries.navigation.internal.v.c.q), new h(hs.SIDE_RIGHT, hu.TURN_NORMAL, false, com.google.android.libraries.navigation.internal.v.c.q), new h(hs.SIDE_LEFT, hu.TURN_SLIGHT, true, com.google.android.libraries.navigation.internal.v.c.s), new h(hs.SIDE_RIGHT, hu.TURN_SLIGHT, false, com.google.android.libraries.navigation.internal.v.c.s), new h(hs.SIDE_LEFT, hu.TURN_KEEP, true, com.google.android.libraries.navigation.internal.v.c.e), new h(hs.SIDE_RIGHT, hu.TURN_KEEP, false, com.google.android.libraries.navigation.internal.v.c.e), new h(hs.SIDE_UNSPECIFIED, hu.TURN_KEEP, false, com.google.android.libraries.navigation.internal.v.c.p), new h(hs.SIDE_LEFT, hu.TURN_SHARP, true, com.google.android.libraries.navigation.internal.v.c.r), new h(hs.SIDE_RIGHT, hu.TURN_SHARP, false, com.google.android.libraries.navigation.internal.v.c.r), new h(hs.SIDE_RIGHT, hu.TURN_UTURN, true, com.google.android.libraries.navigation.internal.v.c.t), new h(hs.SIDE_UNSPECIFIED, hu.TURN_UTURN, false, com.google.android.libraries.navigation.internal.v.c.t), new h(hs.SIDE_UNSPECIFIED, hu.TURN_STRAIGHT, false, com.google.android.libraries.navigation.internal.v.c.p), new a(l.TURN, hs.SIDE_LEFT, true, com.google.android.libraries.navigation.internal.v.c.q), new a(l.TURN, hs.SIDE_RIGHT, false, com.google.android.libraries.navigation.internal.v.c.q), new f(hs.SIDE_LEFT, hu.TURN_NORMAL, true, com.google.android.libraries.navigation.internal.v.c.q), new f(hs.SIDE_RIGHT, hu.TURN_NORMAL, false, com.google.android.libraries.navigation.internal.v.c.q), new f(hs.SIDE_LEFT, hu.TURN_SLIGHT, true, com.google.android.libraries.navigation.internal.v.c.s), new f(hs.SIDE_RIGHT, hu.TURN_SLIGHT, false, com.google.android.libraries.navigation.internal.v.c.s), new f(hs.SIDE_LEFT, hu.TURN_KEEP, true, com.google.android.libraries.navigation.internal.v.c.e), new f(hs.SIDE_RIGHT, hu.TURN_KEEP, false, com.google.android.libraries.navigation.internal.v.c.e), new f(hs.SIDE_LEFT, hu.TURN_SHARP, true, com.google.android.libraries.navigation.internal.v.c.r), new f(hs.SIDE_RIGHT, hu.TURN_SHARP, false, com.google.android.libraries.navigation.internal.v.c.r), new a(l.ON_RAMP, hs.SIDE_UNSPECIFIED, false, com.google.android.libraries.navigation.internal.v.c.p), new e(hs.SIDE_LEFT, hu.TURN_NORMAL, true, com.google.android.libraries.navigation.internal.v.c.d), new e(hs.SIDE_RIGHT, hu.TURN_NORMAL, false, com.google.android.libraries.navigation.internal.v.c.d), new e(hs.SIDE_LEFT, hu.TURN_SLIGHT, true, com.google.android.libraries.navigation.internal.v.c.s), new e(hs.SIDE_RIGHT, hu.TURN_SLIGHT, false, com.google.android.libraries.navigation.internal.v.c.s), new e(hs.SIDE_LEFT, hu.TURN_KEEP, true, com.google.android.libraries.navigation.internal.v.c.e), new e(hs.SIDE_RIGHT, hu.TURN_KEEP, false, com.google.android.libraries.navigation.internal.v.c.e), new e(hs.SIDE_LEFT, hu.TURN_SHARP, true, com.google.android.libraries.navigation.internal.v.c.r), new e(hs.SIDE_RIGHT, hu.TURN_SHARP, false, com.google.android.libraries.navigation.internal.v.c.r), new a(l.OFF_RAMP, hs.SIDE_UNSPECIFIED, false, com.google.android.libraries.navigation.internal.v.c.p), new a(l.UTURN, hs.SIDE_RIGHT, true, com.google.android.libraries.navigation.internal.v.c.t), new a(l.UTURN, hs.SIDE_UNSPECIFIED, false, com.google.android.libraries.navigation.internal.v.c.t), new a(l.FORK, hs.SIDE_LEFT, true, com.google.android.libraries.navigation.internal.v.c.e), new a(l.FORK, hs.SIDE_RIGHT, false, com.google.android.libraries.navigation.internal.v.c.e), new a(l.MERGE, hs.SIDE_UNSPECIFIED, false, com.google.android.libraries.navigation.internal.v.c.c), new a(l.STRAIGHT, hs.SIDE_UNSPECIFIED, false, com.google.android.libraries.navigation.internal.v.c.p), new a(l.FERRY, hs.SIDE_UNSPECIFIED, false, com.google.android.libraries.navigation.internal.bx.f.a), new g(hs.SIDE_RIGHT, hu.TURN_SHARP, false, com.google.android.libraries.navigation.internal.v.c.k), new g(hs.SIDE_RIGHT, hu.TURN_NORMAL, false, com.google.android.libraries.navigation.internal.v.c.i), new g(hs.SIDE_RIGHT, hu.TURN_SLIGHT, false, com.google.android.libraries.navigation.internal.v.c.m), new g(hs.SIDE_UNSPECIFIED, hu.TURN_STRAIGHT, false, com.google.android.libraries.navigation.internal.v.c.f633n), new g(hs.SIDE_LEFT, hu.TURN_SLIGHT, false, com.google.android.libraries.navigation.internal.v.c.l), new g(hs.SIDE_LEFT, hu.TURN_NORMAL, false, com.google.android.libraries.navigation.internal.v.c.h), new g(hs.SIDE_LEFT, hu.TURN_SHARP, false, com.google.android.libraries.navigation.internal.v.c.j), new g(hs.SIDE_UNSPECIFIED, hu.TURN_UTURN, false, com.google.android.libraries.navigation.internal.v.c.o), new g(hs.SIDE_LEFT, hu.TURN_SHARP, true, com.google.android.libraries.navigation.internal.v.c.k), new g(hs.SIDE_LEFT, hu.TURN_NORMAL, true, com.google.android.libraries.navigation.internal.v.c.i), new g(hs.SIDE_LEFT, hu.TURN_SLIGHT, true, com.google.android.libraries.navigation.internal.v.c.m), new g(hs.SIDE_UNSPECIFIED, hu.TURN_STRAIGHT, true, com.google.android.libraries.navigation.internal.v.c.f633n), new g(hs.SIDE_RIGHT, hu.TURN_SLIGHT, true, com.google.android.libraries.navigation.internal.v.c.l), new g(hs.SIDE_RIGHT, hu.TURN_NORMAL, true, com.google.android.libraries.navigation.internal.v.c.h), new g(hs.SIDE_RIGHT, hu.TURN_SHARP, true, com.google.android.libraries.navigation.internal.v.c.j), new g(hs.SIDE_UNSPECIFIED, hu.TURN_UTURN, true, com.google.android.libraries.navigation.internal.v.c.o), new g(hs.SIDE_UNSPECIFIED, hu.TURN_UNKNOWN, true, com.google.android.libraries.navigation.internal.v.c.f), new g(hs.SIDE_UNSPECIFIED, hu.TURN_UNKNOWN, false, com.google.android.libraries.navigation.internal.v.c.f), new g(lVar, hsVar, huVar, true, i), new g(lVar, hsVar, huVar, false, i), new g(lVar2, hsVar, huVar, true, i2), new g(lVar2, hsVar, huVar, false, i2)};
    }

    public static Drawable a(a aVar) {
        o oVarC = o.c();
        Drawable drawableA = oVarC.a(oVarC.a, aVar.d, x.d);
        return aVar.c ? new com.google.android.libraries.navigation.internal.mu.g(drawableA) : drawableA;
    }

    public static Drawable b(a aVar, int i) {
        Drawable drawableA = a(aVar);
        drawableA.mutate();
        drawableA.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
        return drawableA;
    }

    public static Drawable c(bq bqVar, int i) {
        return b(f(bqVar), i);
    }

    public static Drawable d(a aVar, int i) {
        if (aVar == null || aVar.equals(a[0])) {
            return null;
        }
        return b(aVar, i);
    }

    public static a e(bq bqVar) {
        a[] aVarArr = a;
        int i = 0;
        while (true) {
            int length = aVarArr.length;
            if (i >= 67) {
                return null;
            }
            a aVar = aVarArr[i];
            boolean z = aVar instanceof g;
            l lVar = bqVar.d;
            hs hsVar = bqVar.e;
            hu huVar = bqVar.f;
            if (z) {
                g gVar = (g) aVar;
                boolean z2 = gVar.a == lVar && gVar.c == (bqVar.E == en.LEFT);
                if (lVar == l.ROUNDABOUT_EXIT) {
                    if (z2) {
                        return aVarArr[i];
                    }
                } else if (z2 && gVar.e == huVar && gVar.b == hsVar) {
                    return aVarArr[i];
                }
            } else if (aVar.a(lVar, hsVar, huVar, bqVar.g)) {
                return aVarArr[i];
            }
            i++;
        }
    }

    public static a f(bq bqVar) {
        a aVarE = e(bqVar);
        return aVarE == null ? a[0] : aVarE;
    }

    public static boolean g(bq bqVar) {
        a aVarE = e(bqVar);
        return (aVarE == null || aVarE.equals(a[0])) ? false : true;
    }
}
