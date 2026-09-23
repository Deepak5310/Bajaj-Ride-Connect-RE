package com.google.android.libraries.navigation.internal.lu;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.navigation.internal.lh.be;
import java.util.Arrays;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<d> CREATOR = new e();
    final int a;
    public final int b;

    public d(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public final int a() {
        int i = this.a;
        if (i > 22 || i < 0) {
            return 4;
        }
        return i;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.a == dVar.a && this.b == dVar.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), Integer.valueOf(this.b)});
    }

    public final String toString() {
        String string;
        int iA = a();
        if (iA == 0) {
            string = "IN_VEHICLE";
        } else if (iA == 1) {
            string = "ON_BICYCLE";
        } else if (iA == 2) {
            string = "ON_FOOT";
        } else if (iA == 3) {
            string = "STILL";
        } else if (iA == 4) {
            string = "UNKNOWN";
        } else if (iA == 5) {
            string = "TILTING";
        } else if (iA == 7) {
            string = "WALKING";
        } else if (iA == 8) {
            string = DebugCoroutineInfoImplKt.RUNNING;
        } else if (iA != 16) {
            string = iA != 17 ? Integer.toString(iA) : "IN_RAIL_VEHICLE";
        } else {
            string = "IN_ROAD_VEHICLE";
        }
        return "DetectedActivity [type=" + string + ", confidence=" + this.b + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        be.j(parcel);
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 1, this.a);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 2, this.b);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
