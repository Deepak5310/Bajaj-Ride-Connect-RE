package com.google.android.libraries.navigation.internal.ma;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.maps.android.BuildConfig;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<c> CREATOR = new d();
    public final String a;
    public final byte[] b;
    public final String c;
    public final a[] d;
    public final Map e = new TreeMap();
    public final boolean f;
    public final long g;

    public c(String str, String str2, a[] aVarArr, boolean z, byte[] bArr, long j) {
        this.a = str;
        this.c = str2;
        this.d = aVarArr;
        this.f = z;
        this.b = bArr;
        this.g = j;
        for (a aVar : aVarArr) {
            this.e.put(Integer.valueOf(aVar.a), aVar);
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (am.a(this.a, cVar.a) && am.a(this.c, cVar.c) && this.e.equals(cVar.e) && this.f == cVar.f && Arrays.equals(this.b, cVar.b) && this.g == cVar.g) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.c, this.e, Boolean.valueOf(this.f), this.b, Long.valueOf(this.g)});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Configurations('");
        sb.append(this.a);
        sb.append("', '");
        sb.append(this.c);
        sb.append("', (");
        Iterator it2 = this.e.values().iterator();
        while (it2.hasNext()) {
            sb.append((a) it2.next());
            sb.append(", ");
        }
        sb.append("), ");
        sb.append(this.f);
        sb.append(", ");
        byte[] bArr = this.b;
        sb.append(bArr == null ? BuildConfig.TRAVIS : Base64.encodeToString(bArr, 3));
        sb.append(", ");
        sb.append(this.g);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 2, this.a);
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 3, this.c);
        com.google.android.libraries.navigation.internal.li.d.u(parcel, 4, this.d, i);
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 5, this.f);
        com.google.android.libraries.navigation.internal.li.d.k(parcel, 6, this.b);
        com.google.android.libraries.navigation.internal.li.d.i(parcel, 7, this.g);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
