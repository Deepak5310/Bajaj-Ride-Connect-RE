package com.google.android.libraries.navigation.internal.abh;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class by {
    public final ht a;
    private final be b;
    private String c;
    private boolean d;
    private boolean e;

    public by(be beVar, ht htVar) {
        com.google.android.libraries.navigation.internal.abf.s.k(beVar, "contextManager");
        this.b = beVar;
        this.a = htVar;
        this.c = null;
        this.d = false;
        this.e = false;
    }

    private static boolean d(String str, PackageManager packageManager) {
        try {
            packageManager.getPackageInfo(str, 1);
            int applicationEnabledSetting = packageManager.getApplicationEnabledSetting(str);
            if (applicationEnabledSetting == 1) {
                return true;
            }
            if (applicationEnabledSetting != 2 && applicationEnabledSetting != 3 && applicationEnabledSetting != 4) {
                try {
                    return packageManager.getApplicationInfo(str, 0).enabled;
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused2) {
            return false;
        }
    }

    public final void a(CameraPosition cameraPosition, es esVar, boolean z) {
        String str;
        LatLng latLngG;
        c();
        if (z) {
            if (esVar == null) {
                this.a.c(com.google.android.libraries.navigation.internal.abx.b.INTENT_VIEW_MULTIPLE_MARKERS_NONE_SELECTED);
            } else {
                this.a.c(com.google.android.libraries.navigation.internal.abx.b.INTENT_VIEW_MULTIPLE_MARKERS_ONE_SELECTED);
            }
        } else if (esVar != null) {
            this.a.c(com.google.android.libraries.navigation.internal.abx.b.INTENT_VIEW_ONE_MARKER);
        } else {
            this.a.c(com.google.android.libraries.navigation.internal.abx.b.INTENT_VIEW_NO_MARKERS);
        }
        LatLng latLng = cameraPosition.target;
        String str2 = "geo:" + latLng.latitude + "," + latLng.longitude + "?z=";
        if (this.d) {
            str = str2 + cameraPosition.zoom;
        } else {
            str = str2 + ((int) Math.floor(cameraPosition.zoom));
        }
        if (esVar != null && (latLngG = esVar.g()) != null) {
            str = str + "&q=" + latLngG.latitude + "," + latLngG.longitude;
            String strJ = esVar.j();
            if (!com.google.android.libraries.navigation.internal.abf.x.a(strJ) && this.e) {
                str = str + "(" + strJ + ")";
            }
        }
        b(str);
    }

    public final void b(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.addFlags(268435456);
        be beVar = this.b;
        Context context = beVar.a;
        String str2 = this.c;
        if (str2 == null) {
            Toast.makeText(context, beVar.n(com.google.android.gms.maps.am.g), 0).show();
        } else {
            intent.setPackage(str2);
            context.startActivity(intent);
        }
    }

    public final void c() {
        PackageManager packageManager = this.b.a.getPackageManager();
        if (d("com.google.android.apps.gmm", packageManager)) {
            this.c = "com.google.android.apps.gmm";
        } else if (d("com.google.android.apps.maps", packageManager)) {
            this.c = "com.google.android.apps.maps";
        } else {
            this.c = d("com.google.android.apps.mapslite", packageManager) ? "com.google.android.apps.mapslite" : null;
        }
        String str = this.c;
        if (str != null) {
            boolean z = true;
            try {
                int i = packageManager.getPackageInfo(str, 1).versionCode;
                this.d = i > 700000000;
                if (i <= 703000000) {
                    z = false;
                }
                this.e = z;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
    }
}
