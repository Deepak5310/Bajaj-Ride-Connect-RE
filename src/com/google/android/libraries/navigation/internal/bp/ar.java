package com.google.android.libraries.navigation.internal.bp;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.navigation.internal.adr.dr;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.maps.android.BuildConfig;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ar implements Parcelable {
    public static final Parcelable.Creator<ar> CREATOR = new aq();
    public final List a;
    public final int b;

    public ar(int i, List list) {
        this.b = i;
        this.a = list;
    }

    public ar(Parcel parcel) {
        this.b = dr.a(parcel.readInt());
        Parcelable[] parcelableArray = parcel.readParcelableArray(at.class.getClassLoader());
        this.a = ev.p((at[]) Arrays.copyOf(parcelableArray, parcelableArray.length, at[].class));
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        int i = this.b;
        String string$ar$edu$9cfe165a_0 = i != 0 ? dr.toString$ar$edu$9cfe165a_0(i) : BuildConfig.TRAVIS;
        List list = this.a;
        String strE = com.google.android.libraries.navigation.internal.b.b.e(string$ar$edu$9cfe165a_0, "[guidance: ", " laneTurns(");
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            strE = strE + StringUtils.SPACE + String.valueOf((at) it2.next());
        }
        return String.valueOf(strE).concat(" )]");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.b;
        parcel.writeInt(i2 == 0 ? -1 : i2 - 1);
        parcel.writeParcelableArray((at[]) this.a.toArray(new at[0]), i);
    }
}
