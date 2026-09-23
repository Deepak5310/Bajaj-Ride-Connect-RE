package com.google.android.libraries.navigation.internal.lc;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import com.bajajconnect.rideapp.R;
import com.drew.metadata.exif.makernotes.OlympusMakernoteDirectory;
import com.google.android.libraries.navigation.internal.lh.av;
import com.google.android.libraries.navigation.internal.lh.be;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class ak {
    private static boolean a = false;
    static boolean b = false;
    public static final /* synthetic */ int d = 0;

    @Deprecated
    static final AtomicBoolean c = new AtomicBoolean();
    private static final AtomicBoolean e = new AtomicBoolean();

    @Deprecated
    public static int a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:49:0x009d  */
    /* JADX WARN: Code duplicated, block: B:72:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:79:0x0107  */
    /* JADX WARN: Code duplicated, block: B:80:0x010b  */
    /* JADX WARN: Code duplicated, block: B:82:0x010f A[Catch: NameNotFoundException -> 0x011c, TRY_ENTER, TRY_LEAVE, TryCatch #3 {NameNotFoundException -> 0x011c, blocks: (B:60:0x00c2, B:64:0x00cc, B:82:0x010f), top: B:97:0x00c2 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0119 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x011b A[RETURN] */
    @Deprecated
    public static int b(Context context, int i) {
        boolean z;
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        try {
            context.getResources().getString(R.id.MinSpeedup);
        } catch (Throwable unused) {
        }
        if (!"com.google.android.gms".equals(context.getPackageName()) && !e.get()) {
            synchronized (av.a) {
                if (!av.b) {
                    av.b = true;
                    try {
                        Bundle bundle = com.google.android.libraries.navigation.internal.ln.d.b(context).a(context.getPackageName(), 128).metaData;
                        if (bundle != null) {
                            bundle.getString("com.google.app.id");
                            av.c = bundle.getInt("com.google.android.gms.version");
                        }
                    } catch (PackageManager.NameNotFoundException unused2) {
                    }
                }
            }
            int i2 = av.c;
            if (i2 == 0) {
                throw new ag();
            }
            if (i2 != 245125000) {
                throw new ae(i2);
            }
        }
        if (com.google.android.libraries.navigation.internal.ll.e.c(context)) {
            z = false;
        } else {
            if (com.google.android.libraries.navigation.internal.ll.e.a == null) {
                com.google.android.libraries.navigation.internal.ll.e.a = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
            }
            if (com.google.android.libraries.navigation.internal.ll.e.a.booleanValue()) {
                z = false;
            } else {
                z = true;
            }
        }
        be.a(true);
        context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        if (z) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", Build.VERSION.SDK_INT >= 28 ? 134225984 : OlympusMakernoteDirectory.TAG_IMAGE_PROCESSING);
            } catch (PackageManager.NameNotFoundException unused3) {
            }
        } else {
            packageInfo = null;
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", Build.VERSION.SDK_INT >= 28 ? 134217792 : 64);
            al.a(context);
            if (al.c(packageInfo2, true)) {
                if (!z) {
                    if (z) {
                    }
                    if (com.google.android.libraries.navigation.internal.ll.f.a(packageInfo2.versionCode) < com.google.android.libraries.navigation.internal.ll.f.a(i)) {
                        int i3 = packageInfo2.versionCode;
                        return 2;
                    }
                    applicationInfo = packageInfo2.applicationInfo;
                    if (applicationInfo == null) {
                        applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                    }
                    if (applicationInfo.enabled) {
                        return 0;
                    }
                    return 3;
                }
                be.j(packageInfo);
                if (al.c(packageInfo, true)) {
                    if (z || packageInfo == null || packageInfo.signatures[0].equals(packageInfo2.signatures[0])) {
                        if (com.google.android.libraries.navigation.internal.ll.f.a(packageInfo2.versionCode) < com.google.android.libraries.navigation.internal.ll.f.a(i)) {
                            int i4 = packageInfo2.versionCode;
                            return 2;
                        }
                        applicationInfo = packageInfo2.applicationInfo;
                        if (applicationInfo == null) {
                            applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                        }
                        if (applicationInfo.enabled) {
                            return 3;
                        }
                        return 0;
                    }
                }
            }
            return 9;
        } catch (PackageManager.NameNotFoundException unused4) {
            return 1;
        }
    }

    public static void c() {
        e.set(true);
    }

    public static boolean d(Context context) {
        if (!b) {
            try {
                PackageInfo packageInfoB = com.google.android.libraries.navigation.internal.ln.d.b(context).b("com.google.android.gms", Build.VERSION.SDK_INT >= 28 ? 134217792 : 64);
                al.a(context);
                if (packageInfoB == null || al.c(packageInfoB, false) || !al.c(packageInfoB, true)) {
                    a = false;
                } else {
                    a = true;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            } finally {
                b = true;
            }
        }
        return a || !"user".equals(Build.TYPE);
    }
}
