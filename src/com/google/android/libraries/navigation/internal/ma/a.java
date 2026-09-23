package com.google.android.libraries.navigation.internal.ma;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.maps.android.BuildConfig;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends com.google.android.libraries.navigation.internal.li.a implements Comparable<a> {
    public static final Parcelable.Creator<a> CREATOR = new b();
    public final int a;
    public final o[] b;
    public final String[] c;
    public final Map d = new TreeMap();

    public a(int i, o[] oVarArr, String[] strArr) {
        this.a = i;
        this.b = oVarArr;
        for (o oVar : oVarArr) {
            this.d.put(oVar.a, oVar);
        }
        this.c = strArr;
        if (strArr != null) {
            Arrays.sort(strArr);
        }
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(a aVar) {
        return this.a - aVar.a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.a == aVar.a && am.a(this.d, aVar.d) && Arrays.equals(this.c, aVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Configuration(");
        sb.append(this.a);
        sb.append(", (");
        Iterator it2 = this.d.values().iterator();
        while (it2.hasNext()) {
            sb.append((o) it2.next());
            sb.append(", ");
        }
        sb.append("), (");
        String[] strArr = this.c;
        if (strArr != null) {
            for (String str : strArr) {
                sb.append(str);
                sb.append(", ");
            }
        } else {
            sb.append(BuildConfig.TRAVIS);
        }
        sb.append("))");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 2, this.a);
        com.google.android.libraries.navigation.internal.li.d.u(parcel, 3, this.b, i);
        com.google.android.libraries.navigation.internal.li.d.s(parcel, 4, this.c);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
