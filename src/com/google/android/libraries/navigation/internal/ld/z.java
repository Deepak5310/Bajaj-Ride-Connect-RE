package com.google.android.libraries.navigation.internal.ld;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.navigation.internal.lh.be;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class z extends com.google.android.libraries.navigation.internal.li.a implements Parcelable {
    public static final Parcelable.Creator<z> CREATOR = new aa();
    final int a;
    public final String b;

    public z(int i, String str) {
        be.i(str, "scopeUri must not be null or empty");
        this.a = i;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof z) {
            return this.b.equals(((z) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 1, this.a);
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 2, this.b);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }

    public z(String str) {
        this(1, str);
    }
}
