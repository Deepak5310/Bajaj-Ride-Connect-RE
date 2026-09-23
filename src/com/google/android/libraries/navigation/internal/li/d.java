package com.google.android.libraries.navigation.internal.li;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.internal.view.SupportMenu;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    public static int a(Parcel parcel) {
        return b(parcel, 20293);
    }

    public static int b(Parcel parcel, int i) {
        parcel.writeInt(i | SupportMenu.CATEGORY_MASK);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void c(Parcel parcel, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(iDataPosition - i);
        parcel.setDataPosition(iDataPosition);
    }

    public static void d(Parcel parcel, int i, boolean z) {
        w(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void e(Parcel parcel, int i, byte b) {
        w(parcel, i, 4);
        parcel.writeInt(b);
    }

    public static void f(Parcel parcel, int i, double d) {
        w(parcel, i, 8);
        parcel.writeDouble(d);
    }

    public static void g(Parcel parcel, int i, float f) {
        w(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void h(Parcel parcel, int i, int i2) {
        w(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void i(Parcel parcel, int i, long j) {
        w(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void j(Parcel parcel, int i, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        int iB = b(parcel, i);
        parcel.writeBundle(bundle);
        c(parcel, iB);
    }

    public static void k(Parcel parcel, int i, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        int iB = b(parcel, i);
        parcel.writeByteArray(bArr);
        c(parcel, iB);
    }

    public static void l(Parcel parcel, int i, byte[][] bArr) {
        if (bArr == null) {
            return;
        }
        int iB = b(parcel, i);
        parcel.writeInt(bArr.length);
        for (byte[] bArr2 : bArr) {
            parcel.writeByteArray(bArr2);
        }
        c(parcel, iB);
    }

    public static void m(Parcel parcel, int i, Float f) {
        if (f == null) {
            return;
        }
        w(parcel, i, 4);
        parcel.writeFloat(f.floatValue());
    }

    public static void n(Parcel parcel, int i, IBinder iBinder) {
        if (iBinder == null) {
            return;
        }
        int iB = b(parcel, i);
        parcel.writeStrongBinder(iBinder);
        c(parcel, iB);
    }

    public static void o(Parcel parcel, int i, int[] iArr) {
        if (iArr == null) {
            return;
        }
        int iB = b(parcel, i);
        parcel.writeIntArray(iArr);
        c(parcel, iB);
    }

    public static void p(Parcel parcel, int i, Integer num) {
        if (num == null) {
            return;
        }
        w(parcel, i, 4);
        parcel.writeInt(num.intValue());
    }

    public static void q(Parcel parcel, int i, Parcelable parcelable, int i2) {
        if (parcelable == null) {
            return;
        }
        int iB = b(parcel, i);
        parcelable.writeToParcel(parcel, i2);
        c(parcel, iB);
    }

    public static void r(Parcel parcel, int i, String str) {
        if (str == null) {
            return;
        }
        int iB = b(parcel, i);
        parcel.writeString(str);
        c(parcel, iB);
    }

    public static void s(Parcel parcel, int i, String[] strArr) {
        if (strArr == null) {
            return;
        }
        int iB = b(parcel, i);
        parcel.writeStringArray(strArr);
        c(parcel, iB);
    }

    public static void t(Parcel parcel, int i, List list) {
        if (list == null) {
            return;
        }
        int iB = b(parcel, i);
        parcel.writeStringList(list);
        c(parcel, iB);
    }

    public static void u(Parcel parcel, int i, Parcelable[] parcelableArr, int i2) {
        if (parcelableArr == null) {
            return;
        }
        int iB = b(parcel, i);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                x(parcel, parcelable, i2);
            }
        }
        c(parcel, iB);
    }

    public static void v(Parcel parcel, int i, List list) {
        if (list == null) {
            return;
        }
        int iB = b(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            Parcelable parcelable = (Parcelable) list.get(i2);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                x(parcel, parcelable, 0);
            }
        }
        c(parcel, iB);
    }

    private static void w(Parcel parcel, int i, int i2) {
        parcel.writeInt(i | (i2 << 16));
    }

    private static void x(Parcel parcel, Parcelable parcelable, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int iDataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i);
        int iDataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(iDataPosition);
        parcel.writeInt(iDataPosition3 - iDataPosition2);
        parcel.setDataPosition(iDataPosition3);
    }
}
