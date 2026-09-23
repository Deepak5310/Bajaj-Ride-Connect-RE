package com.google.android.libraries.navigation.internal.abh;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class be {
    public final Context a;
    public final bd b;
    private Context c;
    private final Resources d;
    private final com.google.android.libraries.navigation.internal.abf.y e;

    public be(Context context, Resources resources) {
        com.google.android.libraries.navigation.internal.abf.y yVar = com.google.android.libraries.navigation.internal.abf.y.b;
        bd bdVar = bd.a;
        synchronized (this) {
            com.google.android.libraries.navigation.internal.abf.s.k(context, "clientRawContext");
            this.c = context;
        }
        Context applicationContext = context.getApplicationContext();
        com.google.android.libraries.navigation.internal.abf.s.k(applicationContext, "getApplicationContext");
        this.a = applicationContext;
        com.google.android.libraries.navigation.internal.abf.s.k(resources, "mapsApiContainerResources");
        this.d = resources;
        com.google.android.libraries.navigation.internal.abf.s.k(yVar, "systemUtil");
        this.e = yVar;
        this.b = bdVar;
        bp.a(context);
    }

    static float r(float f) {
        return Math.max(0.125f, Math.min(4.0f, f));
    }

    public final synchronized float a(int i) {
        float dimension;
        Configuration configuration = new Configuration(this.d.getConfiguration());
        Configuration configuration2 = new Configuration(h().getResources().getConfiguration());
        try {
            Resources resources = this.d;
            resources.updateConfiguration(configuration2, resources.getDisplayMetrics());
            dimension = this.d.getDimension(i);
            Resources resources2 = this.d;
            resources2.updateConfiguration(configuration, resources2.getDisplayMetrics());
        } catch (Throwable th) {
            Resources resources3 = this.d;
            resources3.updateConfiguration(configuration, resources3.getDisplayMetrics());
            throw th;
        }
        return dimension;
    }

    public final float b() {
        return r(m().density);
    }

    public final float c() {
        return r(m().scaledDensity);
    }

    public final synchronized int d(int i) {
        return this.d.getColor(i);
    }

    public final synchronized int e(int i) {
        int dimensionPixelSize;
        Configuration configuration = new Configuration(this.d.getConfiguration());
        Configuration configuration2 = new Configuration(h().getResources().getConfiguration());
        try {
            Resources resources = this.d;
            resources.updateConfiguration(configuration2, resources.getDisplayMetrics());
            dimensionPixelSize = this.d.getDimensionPixelSize(i);
            Resources resources2 = this.d;
            resources2.updateConfiguration(configuration, resources2.getDisplayMetrics());
        } catch (Throwable th) {
            Resources resources3 = this.d;
            resources3.updateConfiguration(configuration, resources3.getDisplayMetrics());
            throw th;
        }
        return dimensionPixelSize;
    }

    public final int f() {
        return m().heightPixels;
    }

    public final int g() {
        return m().widthPixels;
    }

    public final synchronized Context h() {
        Context context = this.c;
        if (context != null) {
            return context;
        }
        return this.a;
    }

    public final synchronized Context i() {
        return h();
    }

    @Deprecated
    public final synchronized Resources j() {
        return this.d;
    }

    public final synchronized Bitmap k(int i) {
        Bitmap bitmapDecodeResource;
        Configuration configuration = new Configuration(this.d.getConfiguration());
        Configuration configuration2 = new Configuration(h().getResources().getConfiguration());
        try {
            Resources resources = this.d;
            resources.updateConfiguration(configuration2, resources.getDisplayMetrics());
            bitmapDecodeResource = BitmapFactory.decodeResource(this.d, i);
            Resources resources2 = this.d;
            resources2.updateConfiguration(configuration, resources2.getDisplayMetrics());
        } catch (Throwable th) {
            Resources resources3 = this.d;
            resources3.updateConfiguration(configuration, resources3.getDisplayMetrics());
            throw th;
        }
        return bitmapDecodeResource;
    }

    public final synchronized Drawable l(int i) {
        Drawable drawable;
        Configuration configuration = new Configuration(this.d.getConfiguration());
        Configuration configuration2 = new Configuration(h().getResources().getConfiguration());
        try {
            Resources resources = this.d;
            resources.updateConfiguration(configuration2, resources.getDisplayMetrics());
            drawable = this.d.getDrawable(i);
            Resources resources2 = this.d;
            resources2.updateConfiguration(configuration, resources2.getDisplayMetrics());
        } catch (Throwable th) {
            Resources resources3 = this.d;
            resources3.updateConfiguration(configuration, resources3.getDisplayMetrics());
            throw th;
        }
        return drawable;
    }

    final DisplayMetrics m() {
        return h().getResources().getDisplayMetrics();
    }

    public final synchronized String n(int i) {
        return this.d.getString(i);
    }

    public final synchronized void o() {
        this.c = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:
    
        if ((r0.getPackageManager().getActivityInfo(r0.getComponentName(), 128).flags & 512) == 0) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized boolean p() {
        Context context = this.c;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            com.google.android.libraries.navigation.internal.afu.d.a.a().G();
            if ((activity.getWindow().getAttributes().flags & 16777216) == 0) {
                try {
                } catch (PackageManager.NameNotFoundException unused) {
                    com.google.android.libraries.navigation.internal.abf.p.f(com.google.android.libraries.navigation.internal.abf.y.a, 3);
                }
            }
            return true;
        }
        return false;
    }

    public final synchronized CharSequence[] q(int i) {
        return this.d.getTextArray(i);
    }
}
