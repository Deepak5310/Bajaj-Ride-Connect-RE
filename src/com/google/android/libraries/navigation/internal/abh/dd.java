package com.google.android.libraries.navigation.internal.abh;

import android.content.Context;
import android.content.pm.PackageManager;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dd {
    public static final /* synthetic */ int a = 0;
    private static boolean b = false;
    private static final ExecutorService c;

    static {
        ExecutorService executorService = com.google.android.libraries.navigation.internal.abf.ah.a;
        c = com.google.android.libraries.navigation.internal.abf.ah.a;
    }

    public static synchronized void a(be beVar, final m mVar) {
        if (!b) {
            b = true;
            Context context = beVar.a;
            id idVar = mVar.b;
            ArrayList arrayList = new ArrayList();
            PackageManager packageManager = context.getPackageManager();
            String[] strArr = id.b;
            int length = strArr.length;
            for (int i = 0; i < 2; i++) {
                String str = strArr[i];
                try {
                    packageManager.getPermissionInfo(str, 128);
                    if (context.checkCallingOrSelfPermission(str) != 0) {
                        arrayList.add(str);
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    com.google.android.libraries.navigation.internal.abf.p.f(id.a, 6);
                }
            }
            if (!arrayList.isEmpty()) {
                StringBuilder sb = new StringBuilder("The Maps SDK for Android requires the additional following permissions to be set in  the AndroidManifest.xml to ensure a correct behavior:");
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    sb.append("\n<uses-permission android:name=\"" + ((String) arrayList.get(i2)) + "\"/>");
                }
                throw new SecurityException(sb.toString());
            }
            if (com.google.android.libraries.navigation.internal.abf.y.b() || com.google.android.libraries.navigation.internal.abf.y.c(context)) {
                try {
                    context.getPackageManager().getPackageInfo("com.google.android.gms", 0);
                    c.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.dc
                        @Override // java.lang.Runnable
                        public final void run() {
                            m mVar2 = mVar;
                            final com.google.android.libraries.navigation.internal.yx.br brVar = mVar2.a.b;
                            int i3 = dd.a;
                            mVar2.g.b(new com.google.android.libraries.navigation.internal.abg.e() { // from class: com.google.android.libraries.navigation.internal.abh.db
                                @Override // com.google.android.libraries.navigation.internal.abg.e
                                public final void a(com.google.android.libraries.navigation.internal.abg.f fVar) {
                                    int i4 = dd.a;
                                    ((com.google.android.libraries.navigation.internal.abg.q) brVar.a()).u();
                                }
                            });
                        }
                    });
                } catch (PackageManager.NameNotFoundException unused2) {
                    com.google.android.libraries.navigation.internal.abf.p.c("Google Play services is not present on this device.");
                }
            } else {
                com.google.android.libraries.navigation.internal.abf.p.c("Google Maps SDK for Android only supports devices with OpenGL ES 2.0 and above");
            }
            com.google.android.libraries.navigation.internal.abf.d.a.b(context, context.getPackageName());
            if (mVar.f.g) {
                Toast.makeText(beVar.a, beVar.n(com.google.android.gms.maps.am.a), 1).show();
            }
        }
    }
}
