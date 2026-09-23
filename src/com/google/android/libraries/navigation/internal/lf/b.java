package com.google.android.libraries.navigation.internal.lf;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.navigation.internal.li.d;
import java.io.Closeable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends com.google.android.libraries.navigation.internal.li.a implements Closeable {
    public static final Parcelable.Creator<b> CREATOR = new c();
    final int a;
    public final String[] b;
    Bundle c;
    public final CursorWindow[] d;
    public final int e;
    public final Bundle f;
    int[] g;
    boolean h = false;
    private final boolean i = true;

    static {
        new a();
    }

    public b(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.a = i;
        this.b = strArr;
        this.d = cursorWindowArr;
        this.e = i2;
        this.f = bundle;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            if (!this.h) {
                this.h = true;
                int i = 0;
                while (true) {
                    CursorWindow[] cursorWindowArr = this.d;
                    if (i >= cursorWindowArr.length) {
                        break;
                    }
                    cursorWindowArr[i].close();
                    i++;
                }
            }
        }
    }

    protected final void finalize() throws Throwable {
        boolean z;
        try {
            if (this.i && this.d.length > 0) {
                synchronized (this) {
                    z = this.h;
                }
                if (!z) {
                    close();
                    toString();
                }
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String[] strArr = this.b;
        int iA = d.a(parcel);
        d.s(parcel, 1, strArr);
        d.u(parcel, 2, this.d, i);
        d.h(parcel, 3, this.e);
        d.j(parcel, 4, this.f);
        d.h(parcel, 1000, this.a);
        d.c(parcel, iA);
        if ((i & 1) != 0) {
            close();
        }
    }
}
