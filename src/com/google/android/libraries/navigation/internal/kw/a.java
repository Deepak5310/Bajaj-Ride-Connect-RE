package com.google.android.libraries.navigation.internal.kw;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.navigation.internal.li.d;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class a extends com.google.android.libraries.navigation.internal.li.a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new b();
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final Uri e;
    public String f;
    public final long g;
    public final String h;
    final List i;
    public final String j;
    public final String k;
    private final Set l = new HashSet();

    public a(String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List list, String str7, String str8) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = uri;
        this.f = str5;
        this.g = j;
        this.h = str6;
        this.i = list;
        this.j = str7;
        this.k = str8;
    }

    public final Set a() {
        HashSet hashSet = new HashSet(this.i);
        hashSet.addAll(this.l);
        return hashSet;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return aVar.h.equals(this.h) && aVar.a().equals(a());
    }

    public final int hashCode() {
        return ((this.h.hashCode() + 527) * 31) + a().hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.a;
        int iA = d.a(parcel);
        d.r(parcel, 2, str);
        d.r(parcel, 3, this.b);
        d.r(parcel, 4, this.c);
        d.r(parcel, 5, this.d);
        d.q(parcel, 6, this.e, i);
        d.r(parcel, 7, this.f);
        d.i(parcel, 8, this.g);
        d.r(parcel, 9, this.h);
        d.v(parcel, 10, this.i);
        d.r(parcel, 11, this.j);
        d.r(parcel, 12, this.k);
        d.c(parcel, iA);
    }
}
