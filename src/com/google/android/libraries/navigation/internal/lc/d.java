package com.google.android.libraries.navigation.internal.lc;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.navigation.internal.lh.ay;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<d> CREATOR = new e();
    public final String a;

    @Deprecated
    public final int b;
    private final long c;

    public d(String str, int i, long j) {
        this.a = str;
        this.b = i;
        this.c = j;
    }

    public d(String str, long j) {
        this.a = str;
        this.c = j;
        this.b = -1;
    }

    public final long a() {
        long j = this.c;
        return j == -1 ? this.b : j;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            String str = this.a;
            if (((str != null && str.equals(dVar.a)) || (str == null && dVar.a == null)) && a() == dVar.a()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Long.valueOf(a())});
    }

    public final String toString() {
        ay ayVar = new ay(this);
        ayVar.a("name", this.a);
        ayVar.a("version", Long.valueOf(a()));
        return ayVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.a;
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 1, str);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 2, this.b);
        com.google.android.libraries.navigation.internal.li.d.i(parcel, 3, a());
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
