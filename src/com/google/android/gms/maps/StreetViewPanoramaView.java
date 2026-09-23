package com.google.android.gms.maps;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class StreetViewPanoramaView extends FrameLayout {
    private final ay a;

    public StreetViewPanoramaView(Context context) {
        super(context);
        this.a = new ay(this, context, null);
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        com.google.android.libraries.navigation.internal.lh.be.e("getStreetViewPanoramaAsync() must be called on the main thread");
        ay ayVar = this.a;
        com.google.android.libraries.navigation.internal.lo.m mVar = ayVar.a;
        if (mVar != null) {
            ((ax) mVar).l(onStreetViewPanoramaReadyCallback);
        } else {
            ayVar.d.add(onStreetViewPanoramaReadyCallback);
        }
    }

    public final void onCreate(Bundle bundle) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            this.a.b(bundle);
            if (this.a.a == null) {
                com.google.android.libraries.navigation.internal.lo.i.l(this);
            }
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public void onDestroy() {
        this.a.c();
    }

    public final void onLowMemory() {
        this.a.f();
    }

    public final void onPause() {
        this.a.g();
    }

    public void onResume() {
        this.a.h();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        this.a.i(bundle);
    }

    public void onStart() {
        this.a.j();
    }

    public void onStop() {
        this.a.k();
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new ay(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new ay(this, context, null);
    }

    public StreetViewPanoramaView(Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
        super(context);
        this.a = new ay(this, context, streetViewPanoramaOptions);
    }
}
