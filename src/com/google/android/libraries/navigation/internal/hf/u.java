package com.google.android.libraries.navigation.internal.hf;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spanned;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Duration;
import org.joda.time.format.DateTimeFormat;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    public static final com.google.android.libraries.navigation.internal.zb.j a;
    private static final AtomicReference b;
    private static final ThreadLocal c;

    static {
        new SimpleDateFormat("MMM d, y h:mm:ss a z", Locale.ENGLISH);
        new SimpleDateFormat("h:mm:ss a z", Locale.ENGLISH);
        b = new AtomicReference();
        a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.hf.u");
        TimeUnit.MINUTES.toSeconds(5L);
        c = new q();
    }

    public static String a(long j, DateTimeZone dateTimeZone) {
        DateTime dateTime = new DateTime(Duration.standardSeconds(j).getMillis(), dateTimeZone);
        try {
            return DateTimeFormat.shortTime().print(dateTime);
        } catch (IllegalArgumentException unused) {
            return DateTimeFormat.forPattern("H:mm").print(dateTime);
        }
    }

    public static String b(Context context, long j) {
        return c(context, j, TimeZone.getDefault());
    }

    @Deprecated
    public static String c(Context context, long j, TimeZone timeZone) {
        AtomicReference atomicReference = b;
        p pVar = (p) atomicReference.get();
        if (pVar == null || !pVar.a(context)) {
            pVar = new p(context);
            atomicReference.set(pVar);
        }
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        DateFormat dateFormat = pVar.b;
        dateFormat.setTimeZone(timeZone);
        String str = dateFormat.format(Long.valueOf(j * 1000));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static boolean d(int i, int i2) {
        r rVar = new r(i, 2);
        r rVar2 = new r(i2, 2);
        int i3 = rVar.a;
        if (i3 != rVar2.a) {
            return false;
        }
        if (i3 > 0) {
            return rVar.b == rVar2.b;
        }
        return rVar.b == rVar2.b && rVar.c == rVar2.c;
    }

    public static Spanned e(Resources resources, int i, int i2) {
        return f(resources, i, i2, null);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004c  */
    public static Spanned f(Resources resources, int i, int i2, n.a aVar) {
        int i3;
        int i4;
        int i5;
        int i6;
        m mVarJ;
        if (aVar == null) {
            aVar = new n.a();
            aVar.c();
        }
        n.a aVar2 = aVar;
        r rVar = new r(i, i2);
        n nVar = new n(resources);
        new m("");
        int i7 = com.google.android.libraries.navigation.internal.f.g.a;
        int i8 = com.google.android.libraries.navigation.internal.f.g.a;
        int i9 = com.google.android.libraries.navigation.internal.f.g.e;
        int i10 = com.google.android.libraries.navigation.internal.f.g.h;
        Locale locale = resources.getConfiguration().locale;
        int i11 = rVar.a;
        int i12 = rVar.b;
        int i13 = rVar.c;
        int i14 = i2 - 1;
        if (i14 == 1) {
            i7 = com.google.android.libraries.navigation.internal.f.g.b;
            i3 = com.google.android.libraries.navigation.internal.f.g.f;
            i4 = com.google.android.libraries.navigation.internal.f.g.i;
            i5 = i7;
            i6 = i4;
        } else if (i14 == 2) {
            i7 = com.google.android.libraries.navigation.internal.f.g.c;
            i3 = com.google.android.libraries.navigation.internal.f.g.g;
            i4 = com.google.android.libraries.navigation.internal.f.g.j;
            i5 = i7;
            i6 = i4;
        } else if (i14 == 3 || i14 == 4 || i14 == 5) {
            i7 = com.google.android.libraries.navigation.internal.f.g.b;
            i3 = com.google.android.libraries.navigation.internal.f.g.f;
            i4 = com.google.android.libraries.navigation.internal.f.g.i;
            i5 = i7;
            i6 = i4;
        } else {
            i3 = i9;
            i6 = i10;
            i5 = i8;
        }
        if (i11 > 0) {
            if (i12 == 0) {
                mVarJ = j(nVar, aVar2, locale, i7, i11);
            } else {
                mVarJ = i(nVar, aVar2, locale, com.google.android.libraries.navigation.internal.f.h.B, i5, rVar.a, i3, rVar.b);
            }
        } else if (i12 <= 0) {
            mVarJ = j(nVar, aVar2, locale, i6, i13);
        } else if (i13 == 0) {
            mVarJ = j(nVar, aVar2, locale, i3, i12);
        } else {
            mVarJ = i(nVar, aVar2, locale, com.google.android.libraries.navigation.internal.f.h.C, i3, rVar.b, i6, rVar.c);
        }
        return mVarJ.b();
    }

    public static int g(int i, boolean z) {
        if (Math.abs(i) < 60) {
            return 2;
        }
        if (z) {
            return i < 0 ? 1 : 3;
        }
        if (i < -179) {
            return 1;
        }
        return i > 0 ? 3 : 2;
    }

    private static m h(n nVar, n.a aVar, Locale locale, int i) {
        t tVar = (t) c.get();
        if (!locale.equals(tVar.b)) {
            tVar.b = locale;
            tVar.a = NumberFormat.getInstance(locale);
        }
        m mVar = new m(tVar.a.format(i));
        mVar.d(aVar);
        return mVar;
    }

    private static m i(n nVar, n.a aVar, Locale locale, int i, int i2, int i3, int i4, int i5) {
        m mVarH = h(nVar, aVar, locale, i3);
        m mVarH2 = h(nVar, aVar, locale, i5);
        l lVarF = nVar.f(i2, i3);
        lVarF.a(mVarH);
        l lVarF2 = nVar.f(i4, i5);
        lVarF2.a(mVarH2);
        l lVarE = nVar.e(i);
        lVarE.a(lVarF, lVarF2);
        return lVarE;
    }

    private static m j(n nVar, n.a aVar, Locale locale, int i, int i2) {
        m mVarH = h(nVar, aVar, locale, i2);
        String string = nVar.f(i, i2).b().toString();
        if (string.startsWith("%s ")) {
            mVarH.f(string.substring(2));
            return mVarH;
        }
        l lVar = new l(nVar, string);
        lVar.a(mVarH);
        return lVar;
    }
}
