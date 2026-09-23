package com.google.android.libraries.navigation.internal.lv;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f extends com.google.android.libraries.navigation.internal.li.a implements com.google.android.libraries.navigation.internal.ld.y {
    public static final Parcelable.Creator<f> CREATOR = new g();
    public final com.google.android.libraries.navigation.internal.ld.ab a;

    public f(com.google.android.libraries.navigation.internal.ld.ab abVar) {
        this.a = abVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ld.y
    public final com.google.android.libraries.navigation.internal.ld.ab a() {
        throw null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        com.google.android.libraries.navigation.internal.ld.ab abVar = this.a;
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 1, abVar, i);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
