package com.google.android.libraries.navigation.internal.la;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.navigation.internal.lh.az;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class y extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<y> CREATOR = new z();
    public final String a;
    public final int b;
    public final int c;
    public final String d;
    public final boolean e;
    public final String f;
    public final boolean g;
    public final int h;
    public final Integer i;
    public final boolean j;
    public final int k;

    public y(String str, int i, int i2, String str2, boolean z, String str3, boolean z2, int i3, Integer num, boolean z3, int i4) {
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = str2;
        this.e = z;
        this.f = str3;
        this.g = z2;
        this.h = i3;
        this.i = num;
        this.j = z3;
        this.k = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof y) {
            y yVar = (y) obj;
            if (az.a(this.a, yVar.a) && this.b == yVar.b && this.c == yVar.c && az.a(this.f, yVar.f) && az.a(this.d, yVar.d) && this.e == yVar.e && this.g == yVar.g && this.h == yVar.h && az.a(this.i, yVar.i) && this.j == yVar.j && this.k == yVar.k) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Integer.valueOf(this.b), Integer.valueOf(this.c), this.f, this.d, Boolean.valueOf(this.e), Boolean.valueOf(this.g), Integer.valueOf(this.h), this.i, Boolean.valueOf(this.j), Integer.valueOf(this.k)});
    }

    public final String toString() {
        return "PlayLoggerContext[package=" + this.a + ",packageVersionCode=" + this.b + ",logSource=" + this.c + ",logSourceName=" + this.f + ",uploadAccount=" + this.d + ",logAndroidId=" + this.e + ",isAnonymous=" + this.g + ",qosTier=" + this.h + ",appMobilespecId=" + this.i + ",scrubMccMnc=" + this.j + "piiLevelset=" + this.k + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 2, this.a);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 3, this.b);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 4, this.c);
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 5, this.d);
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 7, this.e);
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 8, this.f);
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 9, this.g);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 10, this.h);
        com.google.android.libraries.navigation.internal.li.d.p(parcel, 11, this.i);
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 12, this.j);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 13, this.k);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
