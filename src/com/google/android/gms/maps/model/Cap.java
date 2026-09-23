package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.navigation.internal.lh.az;
import com.google.android.libraries.navigation.internal.lh.be;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class Cap extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<Cap> CREATOR = new b();
    public final int a;
    public final BitmapDescriptor b;
    public final Float c;

    protected Cap(int i) {
        this(i, null, null);
    }

    public static boolean b(int i) {
        return i == 0 || i == 1 || i == 2 || i == 3;
    }

    final Cap a() {
        int i = this.a;
        if (i == 0) {
            return new ButtCap();
        }
        if (i == 1) {
            return new SquareCap();
        }
        if (i != 2) {
            return i != 3 ? this : new CustomCap(this.b, this.c.floatValue());
        }
        return new RoundCap();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cap)) {
            return false;
        }
        Cap cap = (Cap) obj;
        return this.a == cap.a && az.a(this.b, cap.b) && az.a(this.c, cap.c);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), this.b, this.c});
    }

    public String toString() {
        return "[Cap: type=" + this.a + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int i2 = this.a;
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 2, i2);
        BitmapDescriptor bitmapDescriptor = this.b;
        com.google.android.libraries.navigation.internal.li.d.n(parcel, 3, bitmapDescriptor == null ? null : bitmapDescriptor.a.asBinder());
        com.google.android.libraries.navigation.internal.li.d.m(parcel, 4, this.c);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }

    public Cap(int i, BitmapDescriptor bitmapDescriptor, Float f) {
        boolean z = true;
        boolean z2 = f != null && f.floatValue() > 0.0f;
        if (i == 3) {
            z = bitmapDescriptor != null && z2;
            i = 3;
        }
        be.b(z, String.format("Invalid Cap: type=%s bitmapDescriptor=%s bitmapRefWidth=%s", Integer.valueOf(i), bitmapDescriptor, f));
        this.a = i;
        this.b = bitmapDescriptor;
        this.c = f;
    }

    protected Cap(BitmapDescriptor bitmapDescriptor, float f) {
        this(3, bitmapDescriptor, Float.valueOf(f));
    }
}
