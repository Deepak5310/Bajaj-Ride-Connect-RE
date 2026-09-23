package com.google.android.libraries.navigation.internal.ma;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<q> CREATOR = new r();
    public final String a;
    public final String b;
    public final o c;
    public final boolean d;

    public q(String str, String str2, o oVar, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = oVar;
        this.d = z;
    }

    final void a(StringBuilder sb) {
        sb.append("FlagOverride(");
        sb.append(this.a);
        sb.append(", ");
        sb.append(this.b);
        sb.append(", ");
        this.c.a(sb);
        sb.append(", ");
        sb.append(this.d);
        sb.append(")");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return am.a(this.a, qVar.a) && am.a(this.b, qVar.b) && am.a(this.c, qVar.c) && this.d == qVar.d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        a(sb);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 2, this.a);
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 3, this.b);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 4, this.c, i);
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 5, this.d);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
