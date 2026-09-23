package com.google.android.libraries.navigation;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.libraries.navigation.environment.NavApiEnvironmentManager;
import com.google.android.libraries.navigation.internal.xe.ds;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class SupportNavigationFragment extends Fragment {
    private NavigationView g;
    private com.google.android.libraries.navigation.internal.xd.a h;
    private GoogleMapOptions i;
    private Boolean j;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Boolean f92n;
    private final com.google.android.libraries.navigation.internal.xe.ai c = new com.google.android.libraries.navigation.internal.xe.ai();
    private final ds d = new ds();
    private final com.google.android.libraries.navigation.internal.wb.t e = new com.google.android.libraries.navigation.internal.wb.t();
    private final com.google.android.libraries.navigation.internal.wb.s f = new com.google.android.libraries.navigation.internal.wb.s(com.google.android.libraries.navigation.internal.vq.c.a);
    private final Map k = new HashMap();
    private final Collection l = new ArrayList();
    public final List a = new ArrayList();
    public final List b = new ArrayList();
    private final List m = new ArrayList();

    private final void a(com.google.android.libraries.navigation.internal.zp.n nVar, Boolean bool) {
        com.google.android.libraries.navigation.internal.xd.a aVar = this.h;
        if (aVar != null) {
            aVar.c(nVar, bool);
        } else {
            this.k.put(nVar, bool);
        }
    }

    public static SupportNavigationFragment newInstance() {
        try {
            return new SupportNavigationFragment();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void addOnNightModeChangedListener(NavigationView.OnNightModeChangedListener onNightModeChangedListener) {
        try {
            com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
            a(com.google.android.libraries.navigation.internal.zp.n.Dg, null);
            if (this.a.isEmpty() && onNightModeChangedListener != null) {
                this.f.c(new com.google.android.libraries.navigation.internal.xe.y(new NavigationView.OnNightModeChangedListener() { // from class: com.google.android.libraries.navigation.aw
                    @Override // com.google.android.libraries.navigation.NavigationView.OnNightModeChangedListener
                    public final void onNightModeChanged(NightModeChangedEvent nightModeChangedEvent) {
                        Iterator it2 = this.a.a.iterator();
                        while (it2.hasNext()) {
                            ((NavigationView.OnNightModeChangedListener) it2.next()).onNightModeChanged(nightModeChangedEvent);
                        }
                    }
                }));
            }
            this.a.add(onNightModeChangedListener);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void addOnRecenterButtonClickedListener(NavigationView.OnRecenterButtonClickedListener onRecenterButtonClickedListener) {
        try {
            com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
            a(com.google.android.libraries.navigation.internal.zp.n.Dh, null);
            if (this.b.isEmpty() && onRecenterButtonClickedListener != null) {
                this.d.P(new NavigationView.OnRecenterButtonClickedListener() { // from class: com.google.android.libraries.navigation.ax
                    @Override // com.google.android.libraries.navigation.NavigationView.OnRecenterButtonClickedListener
                    public final void onRecenterButtonClick() {
                        Iterator it2 = this.a.b.iterator();
                        while (it2.hasNext()) {
                            ((NavigationView.OnRecenterButtonClickedListener) it2.next()).onRecenterButtonClick();
                        }
                    }
                });
            }
            this.b.add(onRecenterButtonClickedListener);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        try {
            a(com.google.android.libraries.navigation.internal.zp.n.G, null);
            NavigationView navigationView = this.g;
            if (navigationView != null) {
                navigationView.getMapAsync(onMapReadyCallback);
            } else {
                this.l.add(onMapReadyCallback);
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public boolean isNavigationUiEnabled() {
        try {
            NavigationView navigationView = this.g;
            return navigationView != null && navigationView.isNavigationUiEnabled();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        try {
            super.onConfigurationChanged(configuration);
            this.g.onConfigurationChanged(configuration);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            super.onCreateView(layoutInflater, viewGroup, bundle);
            if (this.h == null) {
                this.h = NavApiEnvironmentManager.getOrCreate(getActivity().getApplication()).bw();
                for (Map.Entry entry : this.k.entrySet()) {
                    a((com.google.android.libraries.navigation.internal.zp.n) entry.getKey(), (Boolean) entry.getValue());
                }
                this.k.clear();
            }
            this.h.b(com.google.android.libraries.navigation.internal.zp.n.aS);
            Bundle arguments = getArguments();
            if (arguments != null && arguments.getParcelable("MapOptions") != null) {
                this.i = (GoogleMapOptions) arguments.getParcelable("MapOptions");
            }
            if (this.g == null) {
                NavigationView navigationView = new NavigationView(getActivity(), null, 0, this.c, this.d, this.e, this.f, this.i);
                this.g = navigationView;
                navigationView.onCreate(bundle);
                Boolean bool = this.j;
                if (bool != null) {
                    setTripProgressBarEnabled(bool.booleanValue());
                }
                Iterator it2 = this.l.iterator();
                while (it2.hasNext()) {
                    this.g.getMapAsync((OnMapReadyCallback) it2.next());
                }
                this.l.clear();
                Iterator it3 = this.m.iterator();
                while (it3.hasNext()) {
                    this.g.addOnNavigationUiChangedListener((OnNavigationUiChangedListener) it3.next());
                }
                this.m.clear();
                Boolean bool2 = this.f92n;
                if (bool2 != null) {
                    this.g.setNavigationUiEnabled(bool2.booleanValue());
                    this.f92n = null;
                }
            }
            return this.g;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        try {
            super.onDestroy();
            NavigationView navigationView = this.g;
            if (navigationView != null) {
                navigationView.onDestroy();
                this.g = null;
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        try {
            super.onDestroyView();
            GoogleMapOptions googleMapOptions = this.i;
            if (googleMapOptions == null || googleMapOptions.getUseViewLifecycleInFragment() == null || !this.i.getUseViewLifecycleInFragment().booleanValue()) {
                return;
            }
            this.g.onDestroy();
            this.g = null;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        try {
            StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
            try {
                super.onInflate(activity, attributeSet, bundle);
                this.i = GoogleMapOptions.createFromAttributes(activity, attributeSet);
            } finally {
                StrictMode.setThreadPolicy(threadPolicy);
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        try {
            super.onLowMemory();
            NavigationView navigationView = this.g;
            if (navigationView != null) {
                navigationView.onTrimMemory(80);
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        try {
            super.onPause();
            this.g.onPause();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        try {
            super.onResume();
            this.g.onResume();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
            NavigationView navigationView = this.g;
            if (navigationView != null) {
                navigationView.onSaveInstanceState(bundle);
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        try {
            super.onStart();
            this.g.onStart();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        try {
            super.onStop();
            this.g.onStop();
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void removeOnNightModeChangedListener(NavigationView.OnNightModeChangedListener onNightModeChangedListener) {
        try {
            com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
            a(com.google.android.libraries.navigation.internal.zp.n.Q, null);
            this.a.remove(onNightModeChangedListener);
            if (this.a.isEmpty()) {
                this.f.c(null);
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void removeOnRecenterButtonClickedListener(NavigationView.OnRecenterButtonClickedListener onRecenterButtonClickedListener) {
        try {
            com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
            a(com.google.android.libraries.navigation.internal.zp.n.R, null);
            this.b.remove(onRecenterButtonClickedListener);
            if (this.b.isEmpty()) {
                this.d.P(null);
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void setCalloutInfoDisplayModeOverride(NavigationCalloutDisplayMode navigationCalloutDisplayMode) {
        try {
            NavigationView navigationView = this.g;
            if (navigationView != null) {
                navigationView.setCalloutInfoDisplayModeOverride(navigationCalloutDisplayMode);
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void setCalloutInfoFormatOverride(RouteCalloutInfoFormat routeCalloutInfoFormat) {
        try {
            NavigationView navigationView = this.g;
            if (navigationView != null) {
                navigationView.setCalloutInfoFormatOverride(routeCalloutInfoFormat);
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void setCustomControl(View view, CustomControlPosition customControlPosition) {
        try {
            NavigationView navigationView = this.g;
            if (navigationView != null) {
                navigationView.setCustomControl(view, customControlPosition);
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void setEtaCardEnabled(boolean z) {
        try {
            a(com.google.android.libraries.navigation.internal.zp.n.U, Boolean.valueOf(z));
            this.d.N(z);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void setHeaderEnabled(boolean z) {
        try {
            a(com.google.android.libraries.navigation.internal.zp.n.W, Boolean.valueOf(z));
            this.d.O(z);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void setNavigationUiEnabled(boolean z) {
        try {
            com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
            NavigationView navigationView = this.g;
            if (navigationView == null) {
                this.f92n = Boolean.valueOf(z);
            } else {
                navigationView.setNavigationUiEnabled(z);
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void setRecenterButtonEnabled(boolean z) {
        try {
            a(com.google.android.libraries.navigation.internal.zp.n.X, Boolean.valueOf(z));
            this.d.R(z);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void setSpeedLimitIconEnabled(boolean z) {
        try {
            a(com.google.android.libraries.navigation.internal.zp.n.Y, Boolean.valueOf(z));
            this.d.T(z);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void setSpeedometerEnabled(boolean z) {
        try {
            a(com.google.android.libraries.navigation.internal.zp.n.Z, Boolean.valueOf(z));
            this.d.U(z);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void setSpeedometerUiOptions(SpeedometerUiOptions speedometerUiOptions) {
        try {
            a(com.google.android.libraries.navigation.internal.zp.n.aa, null);
            this.d.V(speedometerUiOptions);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void setStylingOptions(StylingOptions stylingOptions) {
        try {
            a(com.google.android.libraries.navigation.internal.zp.n.ab, null);
            this.d.W(stylingOptions.a);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void setTrafficIncidentCardsEnabled(boolean z) {
        try {
            a(com.google.android.libraries.navigation.internal.zp.n.ac, Boolean.valueOf(z));
            this.e.a(z);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void setTrafficPromptsEnabled(boolean z) {
        try {
            a(com.google.android.libraries.navigation.internal.zp.n.ad, Boolean.valueOf(z));
            this.d.Y(z);
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void setTripProgressBarEnabled(boolean z) {
        try {
            com.google.android.libraries.navigation.internal.zp.n nVar = com.google.android.libraries.navigation.internal.zp.n.ae;
            Boolean boolValueOf = Boolean.valueOf(z);
            a(nVar, boolValueOf);
            NavigationView navigationView = this.g;
            if (navigationView == null) {
                this.j = boolValueOf;
            } else {
                navigationView.setTripProgressBarEnabled(z);
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void showRouteOverview() {
        try {
            NavigationView navigationView = this.g;
            if (navigationView != null) {
                navigationView.showRouteOverview();
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void addOnNavigationUiChangedListener(OnNavigationUiChangedListener onNavigationUiChangedListener) {
        try {
            NavigationView navigationView = this.g;
            if (navigationView == null) {
                this.m.add(onNavigationUiChangedListener);
            } else {
                navigationView.addOnNavigationUiChangedListener(onNavigationUiChangedListener);
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void removeOnNavigationUiChangedListener(OnNavigationUiChangedListener onNavigationUiChangedListener) {
        try {
            NavigationView navigationView = this.g;
            if (navigationView == null) {
                this.m.remove(onNavigationUiChangedListener);
            } else {
                navigationView.removeOnNavigationUiChangedListener(onNavigationUiChangedListener);
            }
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public void setForceNightMode(int i) {
        try {
            this.f.b(com.google.android.libraries.navigation.internal.xe.z.a(i));
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public static SupportNavigationFragment newInstance(GoogleMapOptions googleMapOptions) {
        try {
            SupportNavigationFragment supportNavigationFragment = new SupportNavigationFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("MapOptions", googleMapOptions);
            supportNavigationFragment.setArguments(bundle);
            return supportNavigationFragment;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }
}
