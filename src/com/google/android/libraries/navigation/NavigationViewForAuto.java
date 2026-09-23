package com.google.android.libraries.navigation;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.libraries.navigation.environment.NavApiEnvironmentManager;
import com.google.android.libraries.navigation.internal.xe.ds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class NavigationViewForAuto extends FrameLayout {
    private final NavigationView a;
    private Boolean b;
    private com.google.android.libraries.navigation.internal.xd.a c;
    private final List d;

    public NavigationViewForAuto(Context context) {
        this(context, (AttributeSet) null, (GoogleMapOptions) null);
    }

    private final synchronized void b(com.google.android.libraries.navigation.internal.zp.n nVar) {
        com.google.android.libraries.navigation.internal.xd.a aVar = this.c;
        if (aVar != null) {
            aVar.a(nVar);
        } else {
            this.d.add(nVar);
        }
    }

    final synchronized void a(com.google.android.libraries.navigation.internal.xd.a aVar) {
        if (this.c == null && aVar != null) {
            this.c = aVar;
            Iterator it2 = this.d.iterator();
            while (it2.hasNext()) {
                aVar.a((com.google.android.libraries.navigation.internal.zp.n) it2.next());
            }
            this.d.clear();
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        try {
            if (!this.b.booleanValue()) {
                throw new UnsupportedOperationException("Adding child views is not supported.");
            }
            super.addView(view);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        try {
            b(com.google.android.libraries.navigation.internal.zp.n.Di);
            this.a.onConfigurationChanged(configuration);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void onCreate(Bundle bundle) {
        try {
            a(NavApiEnvironmentManager.getOrCreate(com.google.android.libraries.navigation.internal.abf.b.a(getContext())).bw());
            b(com.google.android.libraries.navigation.internal.zp.n.Dj);
            this.a.onCreate(bundle);
            this.a.setHeaderEnabled(false);
            this.a.setRecenterButtonEnabled(false);
            this.a.setEtaCardEnabled(false);
            this.a.setSpeedometerEnabled(false);
            NavigationView navigationView = this.a;
            try {
                this.b = true;
                addView(navigationView);
            } finally {
                this.b = false;
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void onDestroy() {
        try {
            b(com.google.android.libraries.navigation.internal.zp.n.Dk);
            this.a.onDestroy();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void onPause() {
        try {
            b(com.google.android.libraries.navigation.internal.zp.n.Dl);
            this.a.onPause();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void onResume() {
        try {
            b(com.google.android.libraries.navigation.internal.zp.n.Dm);
            this.a.onResume();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        try {
            b(com.google.android.libraries.navigation.internal.zp.n.Dn);
            this.a.onSaveInstanceState(bundle);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void onStart() {
        try {
            b(com.google.android.libraries.navigation.internal.zp.n.Do);
            this.a.onStart();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void onStop() {
        try {
            b(com.google.android.libraries.navigation.internal.zp.n.E);
            this.a.onStop();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void onTrimMemory(int i) {
        try {
            b(com.google.android.libraries.navigation.internal.zp.n.F);
            this.a.onTrimMemory(i);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public NavigationViewForAuto(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        try {
            this.a.getMapAsync(onMapReadyCallback);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public NavigationViewForAuto(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public NavigationViewForAuto(Context context, AttributeSet attributeSet, int i, GoogleMapOptions googleMapOptions) {
        super(context, attributeSet, i);
        this.b = false;
        this.d = new ArrayList();
        ds dsVar = new ds(true);
        GoogleMapOptions googleMapOptions2 = googleMapOptions == null ? new GoogleMapOptions() : googleMapOptions;
        googleMapOptions2.compassEnabled(false);
        this.a = new NavigationView(context, attributeSet, i, new com.google.android.libraries.navigation.internal.xe.ai(), dsVar, new com.google.android.libraries.navigation.internal.wb.t(), new com.google.android.libraries.navigation.internal.wb.s(com.google.android.libraries.navigation.internal.vq.c.a), googleMapOptions2);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        try {
            if (this.b.booleanValue()) {
                super.addView(view, i);
                return;
            }
            throw new UnsupportedOperationException("Adding child views is not supported.");
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, int i2) {
        try {
            if (this.b.booleanValue()) {
                super.addView(view, i, i2);
                return;
            }
            throw new UnsupportedOperationException("Adding child views is not supported.");
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public NavigationViewForAuto(Context context, AttributeSet attributeSet, GoogleMapOptions googleMapOptions) {
        this(context, attributeSet, 0, googleMapOptions);
    }

    public NavigationViewForAuto(Context context, GoogleMapOptions googleMapOptions) {
        this(context, (AttributeSet) null, googleMapOptions);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        try {
            if (this.b.booleanValue()) {
                super.addView(view, i, layoutParams);
                return;
            }
            throw new UnsupportedOperationException("Adding child views is not supported.");
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        try {
            if (this.b.booleanValue()) {
                super.addView(view, layoutParams);
                return;
            }
            throw new UnsupportedOperationException("Adding child views is not supported.");
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }
}
