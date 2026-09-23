package com.google.android.libraries.navigation.internal.bp;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.navigation.internal.adr.dv;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class at implements Parcelable {
    public static final Parcelable.Creator<at> CREATOR = new as();
    public final dv a;
    public final boolean b;

    public at(Parcel parcel) {
        this.a = dv.b(parcel.readInt());
        this.b = parcel.readInt() != 0;
    }

    public at(dv dvVar, boolean z) {
        this.a = dvVar;
        this.b = z;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        int iOrdinal = this.a.ordinal();
        if (iOrdinal == 0) {
            return "↑";
        }
        if (iOrdinal == 1) {
            return this.b ? "↗" : "↖";
        }
        if (iOrdinal == 2) {
            return this.b ? "↱" : "↰";
        }
        if (iOrdinal == 3) {
            return this.b ? "↘" : "↙";
        }
        if (iOrdinal == 4) {
            return this.b ? "↷" : "↶";
        }
        if (iOrdinal != 5) {
            return StringUtils.SPACE;
        }
        return this.b ? "↿" : "↾";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        dv dvVar = this.a;
        parcel.writeInt(dvVar == null ? -1 : dvVar.g);
        parcel.writeInt(this.b ? 1 : 0);
    }
}
