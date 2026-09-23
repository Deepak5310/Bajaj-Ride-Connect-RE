package com.google.android.libraries.navigation.internal.lv;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.libraries.navigation.internal.lh.az;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class ak extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<ak> CREATOR = new al();
    com.google.android.libraries.navigation.internal.lu.z a;

    public ak(com.google.android.libraries.navigation.internal.lu.z zVar, List list, boolean z, boolean z2, boolean z3, boolean z4, long j) {
        long jMin;
        WorkSource workSource;
        com.google.android.libraries.navigation.internal.lu.y yVar = new com.google.android.libraries.navigation.internal.lu.y(zVar);
        if (list != null) {
            if (list.isEmpty()) {
                workSource = null;
            } else {
                workSource = new WorkSource();
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    com.google.android.libraries.navigation.internal.lh.l lVar = (com.google.android.libraries.navigation.internal.lh.l) it2.next();
                    int i = lVar.a;
                    String str = lVar.b;
                    Method method = com.google.android.libraries.navigation.internal.ll.k.b;
                    if (method != null) {
                        try {
                            method.invoke(workSource, Integer.valueOf(i), str == null ? "" : str);
                        } catch (Exception unused) {
                        }
                    } else {
                        Method method2 = com.google.android.libraries.navigation.internal.ll.k.a;
                        if (method2 != null) {
                            method2.invoke(workSource, Integer.valueOf(i));
                        }
                    }
                }
            }
            yVar.m = workSource;
        }
        if (z) {
            yVar.a(1);
        }
        if (z2) {
            yVar.c(2);
        }
        if (z3) {
            yVar.l = true;
        }
        if (z4) {
            yVar.h = true;
        }
        if (j != Long.MAX_VALUE) {
            yVar.b(j);
        }
        int i2 = yVar.a;
        long j2 = yVar.b;
        long j3 = yVar.c;
        if (j3 == -1) {
            jMin = j2;
        } else {
            jMin = i2 != 105 ? Math.min(j3, j2) : j3;
        }
        long jMax = Math.max(yVar.d, j2);
        long j4 = yVar.e;
        int i3 = yVar.f;
        float f = yVar.g;
        boolean z5 = yVar.h;
        long j5 = yVar.i;
        this.a = new com.google.android.libraries.navigation.internal.lu.z(i2, j2, jMin, jMax, Long.MAX_VALUE, j4, i3, f, z5, j5 == -1 ? j2 : j5, yVar.j, yVar.k, yVar.l, new WorkSource(yVar.m), yVar.f483n);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ak) {
            return az.a(this.a, ((ak) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 1, this.a, i);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
