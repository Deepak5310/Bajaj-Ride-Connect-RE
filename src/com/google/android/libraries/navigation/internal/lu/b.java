package com.google.android.libraries.navigation.internal.lu;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.navigation.internal.lh.az;
import com.google.android.libraries.navigation.internal.lh.be;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends com.google.android.libraries.navigation.internal.li.a implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new c();
    public final List a;
    final long b;
    public final long c;
    public final int d;
    final Bundle e;

    public b(List list, long j, long j2, int i, Bundle bundle) {
        be.b((list == null || list.isEmpty()) ? false : true, "Must have at least 1 detected activity");
        be.b(j > 0 && j2 > 0, "Must set times");
        this.a = list;
        this.b = j;
        this.c = j2;
        this.d = i;
        this.e = bundle;
    }

    private static boolean a(Bundle bundle, Bundle bundle2) {
        int length;
        if (bundle == null) {
            return bundle2 == null;
        }
        if (bundle2 == null || bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            if (!bundle2.containsKey(str)) {
                return false;
            }
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if (obj == null) {
                if (obj2 != null) {
                    return false;
                }
            } else if (obj instanceof Bundle) {
                if (!a(bundle.getBundle(str), bundle2.getBundle(str))) {
                    return false;
                }
            } else {
                if (obj.getClass().isArray()) {
                    if (obj2 != null && obj2.getClass().isArray() && (length = Array.getLength(obj)) == Array.getLength(obj2)) {
                        for (int i = 0; i < length; i++) {
                            if (az.a(Array.get(obj, i), Array.get(obj2, i))) {
                            }
                        }
                    }
                    return false;
                }
                if (!obj.equals(obj2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            if (this.b == bVar.b && this.c == bVar.c && this.d == bVar.d && az.a(this.a, bVar.a) && a(this.e, bVar.e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.b), Long.valueOf(this.c), Integer.valueOf(this.d), this.a, this.e});
    }

    public final String toString() {
        return "ActivityRecognitionResult [probableActivities=" + String.valueOf(this.a) + ", timeMillis=" + this.b + ", elapsedRealtimeMillis=" + this.c + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.v(parcel, 1, this.a);
        com.google.android.libraries.navigation.internal.li.d.i(parcel, 2, this.b);
        com.google.android.libraries.navigation.internal.li.d.i(parcel, 3, this.c);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 4, this.d);
        com.google.android.libraries.navigation.internal.li.d.j(parcel, 5, this.e);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
