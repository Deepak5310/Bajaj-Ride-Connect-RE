package com.google.android.libraries.navigation.internal.li;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.internal.view.SupportMenu;
import java.util.ArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public static byte a(Parcel parcel, int i) {
        y(parcel, i, 4);
        return (byte) parcel.readInt();
    }

    public static double b(Parcel parcel, int i) {
        y(parcel, i, 8);
        return parcel.readDouble();
    }

    public static float c(Parcel parcel, int i) {
        y(parcel, i, 4);
        return parcel.readFloat();
    }

    public static int d(int i) {
        return (char) i;
    }

    public static int e(Parcel parcel, int i) {
        y(parcel, i, 4);
        return parcel.readInt();
    }

    public static int f(Parcel parcel, int i) {
        return (i & SupportMenu.CATEGORY_MASK) != -65536 ? (char) (i >> 16) : parcel.readInt();
    }

    public static int g(Parcel parcel) {
        int i = parcel.readInt();
        int iF = f(parcel, i);
        int iD = d(i);
        int iDataPosition = parcel.dataPosition();
        if (iD != 20293) {
            throw new b("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(i))), parcel);
        }
        int i2 = iF + iDataPosition;
        if (i2 < iDataPosition || i2 > parcel.dataSize()) {
            throw new b(com.google.android.libraries.navigation.internal.b.b.l(i2, iDataPosition, "Size read is invalid start=", " end="), parcel);
        }
        return i2;
    }

    public static long h(Parcel parcel, int i) {
        y(parcel, i, 8);
        return parcel.readLong();
    }

    public static Bundle i(Parcel parcel, int i) {
        int iF = f(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iF == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iF);
        return bundle;
    }

    public static IBinder j(Parcel parcel, int i) {
        int iF = f(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iF == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iDataPosition + iF);
        return strongBinder;
    }

    public static Parcelable k(Parcel parcel, int i, Parcelable.Creator creator) {
        int iF = f(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iF == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iF);
        return parcelable;
    }

    public static Float l(Parcel parcel, int i) {
        int iF = f(parcel, i);
        if (iF == 0) {
            return null;
        }
        z(parcel, iF);
        return Float.valueOf(parcel.readFloat());
    }

    public static Integer m(Parcel parcel, int i) {
        int iF = f(parcel, i);
        if (iF == 0) {
            return null;
        }
        z(parcel, iF);
        return Integer.valueOf(parcel.readInt());
    }

    public static String n(Parcel parcel, int i) {
        int iF = f(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iF == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iF);
        return string;
    }

    public static ArrayList o(Parcel parcel, int i) {
        int iF = f(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iF == 0) {
            return null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(iDataPosition + iF);
        return arrayListCreateStringArrayList;
    }

    public static ArrayList p(Parcel parcel, int i, Parcelable.Creator creator) {
        int iF = f(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iF == 0) {
            return null;
        }
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + iF);
        return arrayListCreateTypedArrayList;
    }

    public static void q(Parcel parcel, int i) {
        if (parcel.dataPosition() != i) {
            throw new b(com.google.android.libraries.navigation.internal.b.b.b(i, "Overread allowed size end="), parcel);
        }
    }

    public static void r(Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + f(parcel, i));
    }

    public static boolean s(Parcel parcel, int i) {
        y(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static byte[] t(Parcel parcel, int i) {
        int iF = f(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iF == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + iF);
        return bArrCreateByteArray;
    }

    public static int[] u(Parcel parcel, int i) {
        int iF = f(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iF == 0) {
            return null;
        }
        int[] iArrCreateIntArray = parcel.createIntArray();
        parcel.setDataPosition(iDataPosition + iF);
        return iArrCreateIntArray;
    }

    public static Object[] v(Parcel parcel, int i, Parcelable.Creator creator) {
        int iF = f(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iF == 0) {
            return null;
        }
        Object[] objArrCreateTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iF);
        return objArrCreateTypedArray;
    }

    public static String[] w(Parcel parcel, int i) {
        int iF = f(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iF == 0) {
            return null;
        }
        String[] strArrCreateStringArray = parcel.createStringArray();
        parcel.setDataPosition(iDataPosition + iF);
        return strArrCreateStringArray;
    }

    public static byte[][] x(Parcel parcel, int i) {
        int iF = f(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iF == 0) {
            return null;
        }
        int i2 = parcel.readInt();
        byte[][] bArr = new byte[i2][];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = parcel.createByteArray();
        }
        parcel.setDataPosition(iDataPosition + iF);
        return bArr;
    }

    private static void y(Parcel parcel, int i, int i2) {
        int iF = f(parcel, i);
        if (iF == i2) {
            return;
        }
        throw new b("Expected size " + i2 + " got " + iF + " (0x" + Integer.toHexString(iF) + ")", parcel);
    }

    private static void z(Parcel parcel, int i) {
        if (i == 4) {
            return;
        }
        throw new b("Expected size 4 got " + i + " (0x" + Integer.toHexString(i) + ")", parcel);
    }
}
