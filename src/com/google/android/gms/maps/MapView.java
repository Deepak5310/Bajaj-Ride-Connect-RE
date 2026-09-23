package com.google.android.gms.maps;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class MapView extends FrameLayout {
    private final ah a;

    public MapView(Context context) {
        super(context);
        this.a = new ah(this, context, null);
        a();
    }

    private final void a() {
        setClickable(true);
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        com.google.android.libraries.navigation.internal.lh.be.e("getMapAsync() must be called on the main thread");
        ah ahVar = this.a;
        com.google.android.libraries.navigation.internal.lo.m mVar = ahVar.a;
        if (mVar != null) {
            ((ag) mVar).l(onMapReadyCallback);
        } else {
            ahVar.d.add(onMapReadyCallback);
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

    public final void onDestroy() {
        this.a.c();
    }

    public final void onEnterAmbient(Bundle bundle) {
    }

    public final void onExitAmbient() {
    }

    public final void onLowMemory() {
        this.a.f();
    }

    public final void onPause() {
        this.a.g();
    }

    public final void onResume() {
        this.a.h();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        this.a.i(bundle);
    }

    public final void onStart() {
        this.a.j();
    }

    public final void onStop() {
        this.a.k();
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new ah(this, context, GoogleMapOptions.createFromAttributes(context, attributeSet));
        a();
    }

    public MapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new ah(this, context, GoogleMapOptions.createFromAttributes(context, attributeSet));
        a();
    }

    public MapView(Context context, GoogleMapOptions googleMapOptions) {
        super(context);
        this.a = new ah(this, context, googleMapOptions);
        a();
    }
}
