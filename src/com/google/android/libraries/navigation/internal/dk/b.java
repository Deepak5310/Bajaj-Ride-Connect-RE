package com.google.android.libraries.navigation.internal.dk;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.navigation.internal.acd.lu;
import com.google.android.libraries.navigation.internal.acd.lv;
import com.google.android.libraries.navigation.internal.acd.lw;
import com.google.android.libraries.navigation.internal.acd.lx;
import com.google.android.libraries.navigation.internal.ael.bb;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();
    public final lx a;
    private final int b;

    public b(int i, lx lxVar) {
        this.b = i;
        lv lvVar = lxVar.c;
        lvVar = lvVar == null ? lv.a : lvVar;
        bb bbVar = (bb) lvVar.aH(5, null);
        bbVar.x(lvVar);
        lu luVar = (lu) bbVar;
        if (!luVar.b.H()) {
            luVar.v();
        }
        lv lvVar2 = (lv) luVar.b;
        lvVar2.b &= -3;
        lvVar2.c = lv.a.c;
        lv lvVar3 = (lv) luVar.t();
        if (lv.a.equals(lvVar3)) {
            bb bbVar2 = (bb) lxVar.aH(5, null);
            bbVar2.x(lxVar);
            lw lwVar = (lw) bbVar2;
            if (!lwVar.b.H()) {
                lwVar.v();
            }
            lx lxVar2 = (lx) lwVar.b;
            lxVar2.c = null;
            lxVar2.b &= -5;
            this.a = (lx) lwVar.t();
            return;
        }
        bb bbVar3 = (bb) lxVar.aH(5, null);
        bbVar3.x(lxVar);
        lw lwVar2 = (lw) bbVar3;
        if (!lwVar2.b.H()) {
            lwVar2.v();
        }
        lx lxVar3 = (lx) lwVar2.b;
        lvVar3.getClass();
        lxVar3.c = lvVar3;
        lxVar3.b |= 4;
        this.a = (lx) lwVar2.t();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.b == bVar.b && this.a.equals(bVar.a);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), this.a});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        com.google.android.libraries.navigation.internal.dl.a aVar = (com.google.android.libraries.navigation.internal.dl.a) com.google.android.libraries.navigation.internal.dl.b.a.q();
        if (!aVar.b.H()) {
            aVar.v();
        }
        int i2 = this.b;
        com.google.android.libraries.navigation.internal.dl.b bVar = (com.google.android.libraries.navigation.internal.dl.b) aVar.b;
        if (i2 == 0) {
            throw null;
        }
        bVar.c = i2 - 1;
        bVar.b |= 1;
        lx lxVar = this.a;
        if (!aVar.b.H()) {
            aVar.v();
        }
        com.google.android.libraries.navigation.internal.dl.b bVar2 = (com.google.android.libraries.navigation.internal.dl.b) aVar.b;
        lxVar.getClass();
        bVar2.d = lxVar;
        bVar2.b |= 2;
        parcel.writeByteArray(((com.google.android.libraries.navigation.internal.dl.b) aVar.t()).m());
    }
}
