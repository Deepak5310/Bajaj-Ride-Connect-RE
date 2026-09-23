package com.google.android.libraries.navigation.internal.mf;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.navigation.internal.lh.az;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<b> CREATOR = new a();
    public final String a;
    public final byte[] b;
    public final List c;

    public b(String str, byte[] bArr, List list) {
        this.a = str;
        this.b = bArr;
        this.c = list == null ? new ArrayList(0) : new ArrayList(list);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return az.a(this.a, bVar.a) && az.a(this.b, bVar.b) && az.a(this.c, bVar.c);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, this.c});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.a;
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 1, str);
        com.google.android.libraries.navigation.internal.li.d.k(parcel, 2, this.b);
        ArrayList arrayList = new ArrayList(this.c);
        int iB = com.google.android.libraries.navigation.internal.li.d.b(parcel, 3);
        int size = arrayList.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeInt(((Integer) arrayList.get(i2)).intValue());
        }
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iB);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
