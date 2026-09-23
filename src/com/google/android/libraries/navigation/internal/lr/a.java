package com.google.android.libraries.navigation.internal.lr;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.google.android.libraries.navigation.internal.li.d;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<a> CREATOR = new b();
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final List e;
    public final a f;

    static {
        Process.myUid();
        Process.myPid();
    }

    public a(int i, String str, String str2, String str3, List list, a aVar) {
        if (aVar != null && aVar.a()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this.a = i;
        this.b = str;
        this.c = str2;
        if (str3 == null) {
            str3 = aVar != null ? aVar.d : null;
        }
        this.d = str3;
        if (list == null) {
            list = aVar != null ? aVar.e : null;
            if (list == null) {
                int i2 = ev.d;
                list = lv.a;
                Intrinsics.checkNotNullExpressionValue(list, "of(...)");
            }
        }
        Intrinsics.checkNotNullParameter(list, "<this>");
        ev evVarO = ev.o(list);
        Intrinsics.checkNotNullExpressionValue(evVarO, "copyOf(...)");
        this.e = evVarO;
        this.f = aVar;
    }

    public final boolean a() {
        return this.f != null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.a == aVar.a && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c) && Intrinsics.areEqual(this.d, aVar.d) && Intrinsics.areEqual(this.f, aVar.f) && Intrinsics.areEqual(this.e, aVar.e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), this.b, this.c, this.d, this.f});
    }

    public final String toString() {
        int length = this.b.length() + 18;
        String str = this.c;
        StringBuilder sb = new StringBuilder(length + (str != null ? str.length() : 0));
        sb.append(this.a);
        sb.append(RemoteSettings.FORWARD_SLASH_STRING);
        sb.append(this.b);
        String str2 = this.c;
        if (str2 != null) {
            sb.append("[");
            if (StringsKt.startsWith$default(str2, this.b, false, 2, (Object) null)) {
                sb.append((CharSequence) str2, this.b.length(), str2.length());
            } else {
                sb.append(str2);
            }
            sb.append("]");
        }
        if (this.d != null) {
            sb.append(RemoteSettings.FORWARD_SLASH_STRING);
            sb.append(Integer.toHexString(this.d.hashCode()));
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        int i2 = this.a;
        int iA = d.a(dest);
        d.h(dest, 1, i2);
        d.r(dest, 3, this.b);
        d.r(dest, 4, this.c);
        d.r(dest, 6, this.d);
        d.q(dest, 7, this.f, i);
        d.v(dest, 8, this.e);
        d.c(dest, iA);
    }
}
