package com.google.android.libraries.navigation.internal.px;

import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cx implements Comparator {
    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        ai aiVar = (ai) obj;
        ai aiVar2 = (ai) obj2;
        com.google.android.libraries.navigation.internal.adg.ef efVar = ((b) aiVar.A()).a;
        int i = efVar.v;
        int i2 = efVar.f186n;
        int i3 = efVar.o;
        com.google.android.libraries.navigation.internal.adg.ef efVar2 = ((b) aiVar2.A()).a;
        int i4 = efVar2.v;
        int i5 = efVar2.f186n;
        int i6 = efVar2.o;
        int iCompare = Integer.compare(i, i4);
        if (iCompare != 0) {
            return iCompare;
        }
        int iCompare2 = Integer.compare(i2, i5);
        if (iCompare2 != 0) {
            return iCompare2;
        }
        int iCompare3 = Integer.compare(i3, i6);
        if (iCompare3 != 0) {
            return iCompare3;
        }
        int iCompare4 = Float.compare(aiVar.d(), aiVar2.d());
        if (iCompare4 != 0) {
            return iCompare4;
        }
        com.google.android.libraries.navigation.internal.adg.ef efVar3 = ((b) aiVar.A()).a;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.d);
        efVar3.h(bhVarS);
        Object objK = efVar3.w.k(bhVarS.d);
        int iIntValue = ((Integer) (objK == null ? bhVarS.b : bhVarS.c(objK))).intValue();
        com.google.android.libraries.navigation.internal.adg.ef efVar4 = ((b) aiVar2.A()).a;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.d);
        efVar4.h(bhVarS2);
        Object objK2 = efVar4.w.k(bhVarS2.d);
        int iCompare5 = Integer.compare(iIntValue, ((Integer) (objK2 == null ? bhVarS2.b : bhVarS2.c(objK2))).intValue());
        if (iCompare5 != 0) {
            return iCompare5;
        }
        int iCompare6 = Integer.compare(aiVar.z(), aiVar2.z());
        return iCompare6 == 0 ? Integer.compare(aiVar.hashCode(), aiVar2.hashCode()) : iCompare6;
    }
}
