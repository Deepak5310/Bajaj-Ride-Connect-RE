package com.google.android.libraries.navigation.internal.mb;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.libraries.navigation.internal.ld.ab;
import com.google.android.libraries.navigation.internal.ma.l;
import com.google.android.libraries.navigation.internal.ma.o;
import com.google.android.libraries.navigation.internal.ma.s;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class e extends com.google.android.libraries.navigation.internal.d.b implements f {
    public e() {
        super("com.google.android.gms.phenotype.internal.IPhenotypeCallbacks");
    }

    @Override // com.google.android.libraries.navigation.internal.d.b
    protected final boolean y(int i, Parcel parcel, Parcel parcel2) throws RemoteException {
        switch (i) {
            case 1:
                ab abVar = (ab) com.google.android.libraries.navigation.internal.d.c.a(parcel, ab.CREATOR);
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                k(abVar);
                return true;
            case 2:
                ab abVar2 = (ab) com.google.android.libraries.navigation.internal.d.c.a(parcel, ab.CREATOR);
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                p(abVar2);
                return true;
            case 3:
                ab abVar3 = (ab) com.google.android.libraries.navigation.internal.d.c.a(parcel, ab.CREATOR);
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                o(abVar3);
                return true;
            case 4:
                ab abVar4 = (ab) com.google.android.libraries.navigation.internal.d.c.a(parcel, ab.CREATOR);
                com.google.android.libraries.navigation.internal.ma.c cVar = (com.google.android.libraries.navigation.internal.ma.c) com.google.android.libraries.navigation.internal.d.c.a(parcel, com.google.android.libraries.navigation.internal.ma.c.CREATOR);
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                g(abVar4, cVar);
                return true;
            case 5:
                ab abVar5 = (ab) com.google.android.libraries.navigation.internal.d.c.a(parcel, ab.CREATOR);
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                b(abVar5);
                return true;
            case 6:
                ab abVar6 = (ab) com.google.android.libraries.navigation.internal.d.c.a(parcel, ab.CREATOR);
                l lVar = (l) com.google.android.libraries.navigation.internal.d.c.a(parcel, l.CREATOR);
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                e(abVar6, lVar);
                return true;
            case 7:
                ab abVar7 = (ab) com.google.android.libraries.navigation.internal.d.c.a(parcel, ab.CREATOR);
                com.google.android.libraries.navigation.internal.ma.e eVar = (com.google.android.libraries.navigation.internal.ma.e) com.google.android.libraries.navigation.internal.d.c.a(parcel, com.google.android.libraries.navigation.internal.ma.e.CREATOR);
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                c(abVar7, eVar);
                return true;
            case 8:
                ab abVar8 = (ab) com.google.android.libraries.navigation.internal.d.c.a(parcel, ab.CREATOR);
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                d(abVar8);
                return true;
            case 9:
                ab abVar9 = (ab) com.google.android.libraries.navigation.internal.d.c.a(parcel, ab.CREATOR);
                o oVar = (o) com.google.android.libraries.navigation.internal.d.c.a(parcel, o.CREATOR);
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                h(abVar9, oVar);
                return true;
            case 10:
                ab abVar10 = (ab) com.google.android.libraries.navigation.internal.d.c.a(parcel, ab.CREATOR);
                com.google.android.libraries.navigation.internal.ma.c cVar2 = (com.google.android.libraries.navigation.internal.ma.c) com.google.android.libraries.navigation.internal.d.c.a(parcel, com.google.android.libraries.navigation.internal.ma.c.CREATOR);
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                f(abVar10, cVar2);
                return true;
            case 11:
                ab abVar11 = (ab) com.google.android.libraries.navigation.internal.d.c.a(parcel, ab.CREATOR);
                parcel.readLong();
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                q(abVar11);
                return true;
            case 12:
                ab abVar12 = (ab) com.google.android.libraries.navigation.internal.d.c.a(parcel, ab.CREATOR);
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                n(abVar12);
                return true;
            case 13:
                ab abVar13 = (ab) com.google.android.libraries.navigation.internal.d.c.a(parcel, ab.CREATOR);
                s sVar = (s) com.google.android.libraries.navigation.internal.d.c.a(parcel, s.CREATOR);
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                j(abVar13, sVar);
                return true;
            case 14:
                ab abVar14 = (ab) com.google.android.libraries.navigation.internal.d.c.a(parcel, ab.CREATOR);
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                l(abVar14);
                return true;
            case 15:
                ab abVar15 = (ab) com.google.android.libraries.navigation.internal.d.c.a(parcel, ab.CREATOR);
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                m(abVar15);
                return true;
            case 16:
                ab abVar16 = (ab) com.google.android.libraries.navigation.internal.d.c.a(parcel, ab.CREATOR);
                long j = parcel.readLong();
                com.google.android.libraries.navigation.internal.d.c.b(parcel);
                i(abVar16, j);
                return true;
            default:
                return false;
        }
    }
}
