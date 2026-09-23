package com.google.android.libraries.navigation.internal.lu;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.WorkSource;
import com.google.android.libraries.navigation.internal.lh.az;
import com.google.android.libraries.navigation.internal.lh.be;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class z extends com.google.android.libraries.navigation.internal.li.a implements Parcelable {
    public static final Parcelable.Creator<z> CREATOR = new aa();
    public int a;
    public long b;
    public long c;
    public long d;
    public long e;
    public int f;
    public float g;
    public boolean h;
    public long i;
    public final int j;
    public final int k;
    public final boolean l;
    public final WorkSource m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.google.android.libraries.navigation.internal.lr.a f484n;

    @Deprecated
    public z() {
        this(102, DateUtils.MILLIS_PER_HOUR, 600000L, 0L, Long.MAX_VALUE, Long.MAX_VALUE, Integer.MAX_VALUE, 0.0f, true, DateUtils.MILLIS_PER_HOUR, 0, 0, false, new WorkSource(), null);
    }

    private static String d(long j) {
        String string;
        if (j == Long.MAX_VALUE) {
            return "∞";
        }
        synchronized (com.google.android.libraries.navigation.internal.lw.a.b) {
            com.google.android.libraries.navigation.internal.lw.a.b.setLength(0);
            StringBuilder sb = com.google.android.libraries.navigation.internal.lw.a.b;
            com.google.android.libraries.navigation.internal.lw.a.a(j, sb);
            string = sb.toString();
        }
        return string;
    }

    public final boolean a() {
        long j = this.d;
        return j > 0 && (j >> 1) >= this.b;
    }

    public final boolean b() {
        return this.a == 105;
    }

    @Deprecated
    public final void c(int i) {
        ae.b(i);
        this.a = i;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof z) {
            z zVar = (z) obj;
            boolean zA = a();
            if (this.a == zVar.a && ((b() || this.b == zVar.b) && this.c == zVar.c && zA == zVar.a() && ((!zA || this.d == zVar.d) && this.e == zVar.e && this.f == zVar.f && this.g == zVar.g && this.h == zVar.h && this.j == zVar.j && this.k == zVar.k && this.l == zVar.l && this.m.equals(zVar.m) && az.a(this.f484n, zVar.f484n)))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), Long.valueOf(this.b), Long.valueOf(this.c), this.m});
    }

    /* JADX WARN: Code duplicated, block: B:73:0x0150  */
    /* JADX WARN: Code duplicated, block: B:83:0x0141 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final String toString() {
        Method method;
        Object objInvoke;
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        if (b()) {
            sb.append(ae.a(this.a));
            if (this.d > 0) {
                sb.append(RemoteSettings.FORWARD_SLASH_STRING);
                com.google.android.libraries.navigation.internal.lw.a.a(this.d, sb);
            }
        } else {
            sb.append("@");
            if (a()) {
                com.google.android.libraries.navigation.internal.lw.a.a(this.b, sb);
                sb.append(RemoteSettings.FORWARD_SLASH_STRING);
                com.google.android.libraries.navigation.internal.lw.a.a(this.d, sb);
            } else {
                com.google.android.libraries.navigation.internal.lw.a.a(this.b, sb);
            }
            sb.append(StringUtils.SPACE);
            sb.append(ae.a(this.a));
        }
        if (b() || this.c != this.b) {
            sb.append(", minUpdateInterval=");
            sb.append(d(this.c));
        }
        if (this.g > 0.0d) {
            sb.append(", minUpdateDistance=");
            sb.append(this.g);
        }
        if (!b() ? this.i != this.b : this.i != Long.MAX_VALUE) {
            sb.append(", maxUpdateAge=");
            sb.append(d(this.i));
        }
        if (this.e != Long.MAX_VALUE) {
            sb.append(", duration=");
            com.google.android.libraries.navigation.internal.lw.a.a(this.e, sb);
        }
        if (this.f != Integer.MAX_VALUE) {
            sb.append(", maxUpdates=");
            sb.append(this.f);
        }
        if (this.k != 0) {
            sb.append(", ");
            int i = this.k;
            if (i == 0) {
                str2 = "THROTTLE_BACKGROUND";
            } else if (i == 1) {
                str2 = "THROTTLE_ALWAYS";
            } else {
                if (i != 2) {
                    throw new IllegalArgumentException();
                }
                str2 = "THROTTLE_NEVER";
            }
            sb.append(str2);
        }
        if (this.j != 0) {
            sb.append(", ");
            int i2 = this.j;
            if (i2 == 0) {
                str = "GRANULARITY_PERMISSION_LEVEL";
            } else if (i2 == 1) {
                str = "GRANULARITY_COARSE";
            } else {
                if (i2 != 2) {
                    throw new IllegalArgumentException();
                }
                str = "GRANULARITY_FINE";
            }
            sb.append(str);
        }
        if (this.h) {
            sb.append(", waitForAccurateLocation");
        }
        if (this.l) {
            sb.append(", bypass");
        }
        WorkSource workSource = this.m;
        Method method2 = com.google.android.libraries.navigation.internal.ll.k.d;
        if (method2 != null) {
            try {
                Object objInvoke2 = method2.invoke(workSource, null);
                be.j(objInvoke2);
                if (!((Boolean) objInvoke2).booleanValue()) {
                    sb.append(", ");
                    sb.append(this.m);
                }
            } catch (Exception unused) {
                method = com.google.android.libraries.navigation.internal.ll.k.c;
                if (method != null) {
                    try {
                        objInvoke = method.invoke(workSource, null);
                        be.j(objInvoke);
                        if (((Integer) objInvoke).intValue() != 0) {
                            sb.append(", ");
                            sb.append(this.m);
                        }
                    } catch (Exception unused2) {
                    }
                }
            }
        } else {
            method = com.google.android.libraries.navigation.internal.ll.k.c;
            if (method != null) {
                objInvoke = method.invoke(workSource, null);
                be.j(objInvoke);
                if (((Integer) objInvoke).intValue() != 0) {
                    sb.append(", ");
                    sb.append(this.m);
                }
            }
        }
        if (this.f484n != null) {
            sb.append(", impersonation=");
            sb.append(this.f484n);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 1, this.a);
        com.google.android.libraries.navigation.internal.li.d.i(parcel, 2, this.b);
        com.google.android.libraries.navigation.internal.li.d.i(parcel, 3, this.c);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 6, this.f);
        com.google.android.libraries.navigation.internal.li.d.g(parcel, 7, this.g);
        com.google.android.libraries.navigation.internal.li.d.i(parcel, 8, this.d);
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 9, this.h);
        com.google.android.libraries.navigation.internal.li.d.i(parcel, 10, this.e);
        com.google.android.libraries.navigation.internal.li.d.i(parcel, 11, this.i);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 12, this.j);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 13, this.k);
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 15, this.l);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 16, this.m, i);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 17, this.f484n, i);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }

    public z(int i, long j, long j2, long j3, long j4, long j5, int i2, float f, boolean z, long j6, int i3, int i4, boolean z2, WorkSource workSource, com.google.android.libraries.navigation.internal.lr.a aVar) {
        long j7;
        this.a = i;
        if (i == 105) {
            this.b = Long.MAX_VALUE;
            j7 = j;
        } else {
            j7 = j;
            this.b = j7;
        }
        this.c = j2;
        this.d = j3;
        this.e = j4 == Long.MAX_VALUE ? j5 : Math.min(Math.max(1L, j4 - SystemClock.elapsedRealtime()), j5);
        this.f = i2;
        this.g = f;
        this.h = z;
        this.i = j6 != -1 ? j6 : j7;
        this.j = i3;
        this.k = i4;
        this.l = z2;
        this.m = workSource;
        this.f484n = aVar;
    }
}
