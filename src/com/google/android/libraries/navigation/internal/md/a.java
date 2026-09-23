package com.google.android.libraries.navigation.internal.md;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.navigation.internal.ld.ab;
import com.google.android.libraries.navigation.internal.ld.y;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends com.google.android.libraries.navigation.internal.li.a implements y {
    public static final Parcelable.Creator<a> CREATOR = new b();
    final int a;
    public int b;
    public Intent c;

    public a() {
        this(2, 0, null);
    }

    public a(int i, int i2, Intent intent) {
        this.a = i;
        this.b = i2;
        this.c = intent;
    }

    @Override // com.google.android.libraries.navigation.internal.ld.y
    public final ab a() {
        throw null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 1, this.a);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 2, this.b);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 3, this.c, i);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
