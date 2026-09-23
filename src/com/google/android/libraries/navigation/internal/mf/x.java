package com.google.android.libraries.navigation.internal.mf;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class x extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<x> CREATOR = new y();
    public final int a;
    public final boolean b;
    public final List c;
    public final int d;
    public final String e;
    public final boolean f;

    public x(int i, boolean z, List list, int i2, String str, boolean z2) {
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        this.a = i;
        this.b = z;
        if (list != null) {
            arrayList.addAll(list);
        }
        this.d = i2;
        this.e = str;
        this.f = z2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 2, this.a);
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 3, this.b);
        com.google.android.libraries.navigation.internal.li.d.t(parcel, 4, this.c);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 5, this.d);
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 6, this.e);
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 7, this.f);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
