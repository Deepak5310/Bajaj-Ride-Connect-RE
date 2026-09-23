package com.google.android.libraries.navigation.internal.lv;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.navigation.internal.lh.az;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class b extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<b> CREATOR = new c();
    static final com.google.android.libraries.navigation.internal.lu.j a = new com.google.android.libraries.navigation.internal.lu.i().a();
    final com.google.android.libraries.navigation.internal.lu.j b;

    public b(com.google.android.libraries.navigation.internal.lu.j jVar) {
        this.b = jVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            return az.a(this.b, ((b) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return this.b.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 1, this.b, i);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
