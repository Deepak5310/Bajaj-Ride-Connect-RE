package com.google.android.libraries.navigation.internal.mf;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.navigation.internal.lh.az;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<c> CREATOR;
    public final boolean a;
    public final boolean b;
    private final List c;

    static {
        new c(null, false, false);
        CREATOR = new d();
    }

    public c(List list, boolean z, boolean z2) {
        this.c = list == null ? new ArrayList(0) : new ArrayList(list);
        this.a = z;
        this.b = z2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return az.a(this.c, cVar.c) && az.a(Boolean.valueOf(this.a), Boolean.valueOf(cVar.a));
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.c, Boolean.valueOf(this.a)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.v(parcel, 1, new ArrayList(this.c));
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 2, this.a);
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 3, this.b);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
