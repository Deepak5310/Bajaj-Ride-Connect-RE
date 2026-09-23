package com.google.android.libraries.navigation.internal.md;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.navigation.internal.ld.ab;
import com.google.android.libraries.navigation.internal.ld.y;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h extends com.google.android.libraries.navigation.internal.li.a implements y {
    public static final Parcelable.Creator<h> CREATOR = new i();
    public final List a;
    public final String b;

    public h(List list, String str) {
        this.a = list;
        this.b = str;
    }

    @Override // com.google.android.libraries.navigation.internal.ld.y
    public final ab a() {
        throw null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        List list = this.a;
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.t(parcel, 1, list);
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 2, this.b);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
