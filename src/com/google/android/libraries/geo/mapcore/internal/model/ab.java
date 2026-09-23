package com.google.android.libraries.geo.mapcore.internal.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.ViewCompat;
import com.drew.metadata.photoshop.PhotoshopDirectory;
import com.google.android.libraries.geo.mapcore.renderer.eg;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class ab implements Serializable {
    public final String b;
    public final ev c;
    public final eg d;
    public final int e;
    public transient Bitmap f;
    public final eg g;
    private static final com.google.android.libraries.navigation.internal.zb.j h = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.geo.mapcore.internal.model.ab");
    public static final eg a = new com.google.android.libraries.geo.mapcore.renderer.g(0, 0);

    public ab(Bitmap bitmap) {
        this.b = null;
        this.e = 1;
        this.c = null;
        this.f = bitmap;
        this.d = a;
        this.g = null;
    }

    public ab(ev evVar, int i) {
        this(evVar, i, (eg) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ab a(Collection collection) {
        eg gVar = a;
        eq eqVarJ = ev.j(collection.size());
        Iterator it2 = collection.iterator();
        int i = -1;
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            com.google.android.libraries.navigation.internal.adg.cr crVar = (com.google.android.libraries.navigation.internal.adg.cr) it2.next();
            y yVarH = z.h();
            yVarH.f(crVar.c);
            yVarH.g(crVar.d);
            yVarH.d((crVar.b & 1024) != 0 ? crVar.m : ViewCompat.MEASURED_STATE_MASK);
            yVarH.c(crVar.f183n);
            yVarH.b((crVar.b & 4096) != 0 ? crVar.o : 0);
            yVarH.e(new j(crVar.k, crVar.i, crVar.l, crVar.j));
            eqVarJ.h(yVarH.a());
            if (i == -1) {
                i = (crVar.b & 8) != 0 ? crVar.f : -1;
            }
            if (!gVar.c()) {
                int i2 = crVar.b;
                if ((i2 & 16) != 0 && (i2 & 32) != 0) {
                    gVar = new com.google.android.libraries.geo.mapcore.renderer.g(crVar.g, crVar.h);
                }
            }
        }
        int iMax = Math.max(i, 1);
        ev evVarG = eqVarJ.g();
        if (((lv) evVarG).c == 1) {
            String strF = ((z) evVarG.get(0)).f();
            if (strF.endsWith(".svg")) {
                return new ab(strF, gVar, iMax);
            }
        }
        return new ab(evVarG, iMax);
    }

    public static ab b(List list, Collection collection, com.google.android.libraries.navigation.internal.agg.bj bjVar, com.google.android.libraries.navigation.internal.adh.b bVar) throws com.google.android.libraries.navigation.internal.ael.cc {
        eq eqVarJ = ev.j(collection.size() + list.size());
        int i = 0;
        int i2 = -1;
        while (true) {
            int size = list.size();
            int i3 = ViewCompat.MEASURED_STATE_MASK;
            if (i >= size) {
                break;
            }
            int iIntValue = ((Integer) list.get(i)).intValue();
            com.google.android.libraries.navigation.internal.adg.cr crVar = (com.google.android.libraries.navigation.internal.adg.cr) ((dg) com.google.android.libraries.navigation.internal.adg.cr.a.aH(7, null)).j(bVar.t, bVar.j.b(iIntValue), bVar.j.a(iIntValue), bVar.a);
            if (bjVar.c(iIntValue)) {
                eqVarJ.h((z) bjVar.p(iIntValue));
            } else {
                String strA = cm.a(crVar.c, (crVar.b & 4) != 0, crVar.e, bVar);
                y yVarH = z.h();
                yVarH.f(strA);
                yVarH.g(crVar.d);
                if ((crVar.b & 1024) != 0) {
                    i3 = crVar.m;
                }
                yVarH.d(i3);
                yVarH.c(crVar.f183n);
                yVarH.b((crVar.b & 4096) != 0 ? crVar.o : 0);
                yVarH.e(new j(crVar.k, crVar.i, crVar.l, crVar.j));
                z zVarA = yVarH.a();
                bjVar.a(iIntValue, zVarA);
                eqVarJ.h(zVarA);
            }
            if (i2 == -1) {
                i2 = (crVar.b & 8) != 0 ? crVar.f : -1;
            }
            i++;
        }
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            com.google.android.libraries.navigation.internal.adg.cr crVar2 = (com.google.android.libraries.navigation.internal.adg.cr) it2.next();
            String strA2 = cm.a(crVar2.c, (crVar2.b & 4) != 0, crVar2.e, bVar);
            y yVarH2 = z.h();
            yVarH2.f(strA2);
            yVarH2.g(crVar2.d);
            yVarH2.d((crVar2.b & 1024) != 0 ? crVar2.m : -16777216);
            yVarH2.c(crVar2.f183n);
            yVarH2.b((crVar2.b & 4096) != 0 ? crVar2.o : 0);
            yVarH2.e(new j(crVar2.k, crVar2.i, crVar2.l, crVar2.j));
            eqVarJ.h(yVarH2.a());
            if (i2 == -1) {
                i2 = (crVar2.b & 8) != 0 ? crVar2.f : -1;
            }
        }
        return new ab(eqVarJ.g(), Math.max(i2, 1));
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i = objectInputStream.readInt();
        if (i == 0) {
            this.f = null;
            return;
        }
        byte[] bArr = new byte[i];
        objectInputStream.readFully(bArr);
        ClassLoader classLoader = getClass().getClassLoader();
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, i);
        parcelObtain.setDataPosition(0);
        Parcelable parcelable = parcelObtain.readParcelable(classLoader);
        parcelObtain.recycle();
        this.f = (Bitmap) parcelable;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Bitmap bitmap = this.f;
        if (bitmap == null) {
            objectOutputStream.writeInt(0);
            return;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeParcelable(bitmap, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        objectOutputStream.writeInt(bArrMarshall.length);
        objectOutputStream.write(bArrMarshall);
    }

    public final boolean c() {
        return this.f != null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ab)) {
            return false;
        }
        ab abVar = (ab) obj;
        return com.google.android.libraries.navigation.internal.yx.am.a(this.b, abVar.b) && com.google.android.libraries.navigation.internal.yx.am.a(this.c, abVar.c) && com.google.android.libraries.navigation.internal.yx.am.a(this.f, abVar.f) && this.e == abVar.e && com.google.android.libraries.navigation.internal.yx.am.a(this.d, abVar.d);
    }

    public final int hashCode() {
        String str = this.b;
        int iHashCode = str != null ? str.hashCode() + 31 : 1;
        ev evVar = this.c;
        if (evVar != null) {
            iHashCode = (iHashCode * 31) + evVar.hashCode();
        }
        Bitmap bitmap = this.f;
        if (bitmap != null) {
            iHashCode = (iHashCode * 31) + bitmap.hashCode();
        }
        return (((iHashCode * 31) + this.e) * 31) + this.d.hashCode();
    }

    public ab(ev evVar, int i, eg egVar) {
        if (i <= 0) {
            ((com.google.android.libraries.navigation.internal.zb.h) h.d(com.google.android.libraries.navigation.internal.nl.a.a).F(PhotoshopDirectory.TAG_PRINT_INFO)).q("superSampleRatio must be greater than or equal to %s.", 1);
        }
        this.c = evVar;
        this.e = Math.max(i, 1);
        this.b = null;
        this.f = null;
        this.d = a;
        this.g = null;
    }

    public ab(String str, eg egVar, int i) {
        if (i <= 0) {
            ((com.google.android.libraries.navigation.internal.zb.h) h.d(com.google.android.libraries.navigation.internal.nl.a.a).F(PhotoshopDirectory.TAG_LAYER_GROUPS_ENABLED_ID)).q("superSampleRatio must be greater than or equal to %s.", 1);
        }
        this.b = str;
        this.e = Math.max(i, 1);
        this.c = null;
        this.f = null;
        this.d = egVar;
        this.g = null;
    }
}
