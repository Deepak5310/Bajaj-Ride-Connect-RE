package com.google.android.libraries.navigation.internal.dk;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.navigation.internal.acd.lx;
import com.google.android.libraries.navigation.internal.ael.ar;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cc;
import com.google.android.libraries.navigation.internal.ael.di;
import com.google.android.libraries.navigation.internal.dl.d;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        byte[] bArrCreateByteArray;
        com.google.android.libraries.navigation.internal.dl.b bVar = null;
        if (parcel.dataAvail() != 0 && (bArrCreateByteArray = parcel.createByteArray()) != null) {
            try {
                com.google.android.libraries.navigation.internal.dl.b bVar2 = com.google.android.libraries.navigation.internal.dl.b.a;
                int length = bArrCreateByteArray.length;
                ar arVar = ar.a;
                di diVar = di.a;
                bi biVarV = bi.v(bVar2, bArrCreateByteArray, 0, length, ar.a);
                bi.I(biVarV);
                bVar = (com.google.android.libraries.navigation.internal.dl.b) biVarV;
            } catch (cc unused) {
            }
        }
        if (bVar == null) {
            bVar = com.google.android.libraries.navigation.internal.dl.b.a;
        }
        int iA = d.a(bVar.c);
        if (iA == 0) {
            iA = d.a;
        }
        lx lxVar = bVar.d;
        if (lxVar == null) {
            lxVar = lx.a;
        }
        if ((lxVar.b & 1) != 0 && iA == d.a) {
            iA = d.b;
        }
        lx lxVar2 = bVar.d;
        if (lxVar2 == null) {
            lxVar2 = lx.a;
        }
        return new b(iA, lxVar2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new b[i];
    }
}
