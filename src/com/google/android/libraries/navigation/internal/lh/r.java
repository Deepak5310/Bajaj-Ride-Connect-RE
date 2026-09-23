package com.google.android.libraries.navigation.internal.lh;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class r extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<r> CREATOR = new s();
    Bundle a;
    com.google.android.libraries.navigation.internal.lc.d[] b;
    int c;
    public t d;

    public r() {
    }

    public r(Bundle bundle, com.google.android.libraries.navigation.internal.lc.d[] dVarArr, int i, t tVar) {
        this.a = bundle;
        this.b = dVarArr;
        this.c = i;
        this.d = tVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.j(parcel, 1, this.a);
        com.google.android.libraries.navigation.internal.li.d.u(parcel, 2, this.b, i);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 3, this.c);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 4, this.d, i);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
