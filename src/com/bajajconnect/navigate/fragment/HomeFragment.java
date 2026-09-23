package com.bajajconnect.navigate.fragment;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.bajajconnect.NavApplication;
import com.bajajconnect.R;
import com.bajajconnect.navigate.HomeActivity;
import com.bajajconnect.variables.GlobalVar;
import com.bajajconnect.wifi.MirroringGlobarVar;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.gson.Gson;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.services.api.OnResponseCallback;
import com.mappls.sdk.services.api.Place;
import com.mappls.sdk.services.api.PlaceResponse;
import com.mappls.sdk.services.api.autosuggest.model.ELocation;
import com.mappls.sdk.services.api.reversegeocode.MapplsReverseGeoCode;
import com.mappls.sdk.services.api.reversegeocode.MapplsReverseGeoCodeManager;
import timber.log.Timber;

/* JADX INFO: loaded from: classes3.dex */
public class HomeFragment extends Fragment {
    private static String ARG_E_LOCATION = "eLocation";

    /* JADX INFO: renamed from: app, reason: collision with root package name */
    private NavApplication f32app;
    private String eLoc;
    private ELocation eLocation;
    private String fromLocation;
    private boolean handedOffToRouteFragment = false;
    private EditText searchEditText;
    private BottomSheetBehavior sheetBehavior;
    private TextView textViewPutRouteName;

    public static HomeFragment newInstance(String str) {
        HomeFragment homeFragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_E_LOCATION, new Gson().toJson(str));
        homeFragment.setArguments(bundle);
        return homeFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f32app = getMyApplication();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_home, viewGroup, false);
    }

    public NavApplication getMyApplication() {
        return NavApplication.forFragments();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        NavApplication navApplication = this.f32app;
        if (navApplication != null && navApplication.getELocation() != null) {
            view.setVisibility(8);
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.bottom_sheet);
        TextView textView = (TextView) view.findViewById(R.id.text_view_get_route);
        this.textViewPutRouteName = (TextView) view.findViewById(R.id.text_view_route_name);
        this.sheetBehavior = BottomSheetBehavior.from(linearLayout);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bajajconnect.navigate.fragment.HomeFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.onClick2(view2);
            }
        });
        if (this.f32app.getELocation() != null) {
            lambda$getDirections$0(this.f32app.getELocation());
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.navigate.fragment.HomeFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    HomeFragment homeFragment = HomeFragment.this;
                    homeFragment.lambda$getDirections$0(homeFragment.f32app.getELocation());
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getDirections, reason: merged with bridge method [inline-methods] */
    public void lambda$getDirections$0(final ELocation eLocation) {
        Location lastKnownLocation;
        NavApplication navApplication;
        if (getActivity() == null || eLocation == null || this.handedOffToRouteFragment) {
            return;
        }
        try {
            MapplsMap mapboxMap = ((HomeActivity) getActivity()).getMapboxMap();
            if (mapboxMap != null) {
                try {
                    lastKnownLocation = mapboxMap.getLocationComponent().getLastKnownLocation();
                } catch (Exception unused) {
                    lastKnownLocation = null;
                }
            } else {
                lastKnownLocation = null;
            }
            if (lastKnownLocation == null && (navApplication = this.f32app) != null && navApplication.getCurrentLocation() != null) {
                lastKnownLocation = this.f32app.getCurrentLocation();
            }
            if (lastKnownLocation == null && GlobalVar.lat != null && GlobalVar.lng != null && GlobalVar.lat.doubleValue() != 0.0d && GlobalVar.lng.doubleValue() != 0.0d) {
                lastKnownLocation = new Location("seed");
                lastKnownLocation.setLatitude(GlobalVar.lat.doubleValue());
                lastKnownLocation.setLongitude(GlobalVar.lng.doubleValue());
                NavApplication navApplication2 = this.f32app;
                if (navApplication2 != null) {
                    navApplication2.setCurrentLocation(lastKnownLocation);
                }
            }
            if (lastKnownLocation == null && MirroringGlobarVar.currentLat == null) {
                Log.e("HomeFrg", "location is null");
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.navigate.fragment.HomeFragment.2
                    @Override // java.lang.Runnable
                    public void run() {
                        HomeFragment.this.lambda$getDirections$0(eLocation);
                    }
                }, 1000L);
                return;
            }
            if (this.fromLocation == null) {
                Log.e("HomeFrg", "from location is null");
                if (MirroringGlobarVar.currentLat != null) {
                    getReverseGeoCode(MirroringGlobarVar.currentLat, MirroringGlobarVar.currentLng);
                    return;
                } else if (lastKnownLocation != null) {
                    getReverseGeoCode(Double.valueOf(lastKnownLocation.getLatitude()), Double.valueOf(lastKnownLocation.getLongitude()));
                    return;
                } else {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.navigate.fragment.HomeFragment$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$getDirections$0(eLocation);
                        }
                    }, 1000L);
                    return;
                }
            }
            this.handedOffToRouteFragment = true;
            ((HomeActivity) getActivity()).navigateTo(RouteFragment.newInstance(eLocation, this.fromLocation), true);
        } catch (Exception e) {
            Timber.e(e);
            e.printStackTrace();
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bajajconnect.navigate.fragment.HomeFragment.3
                @Override // java.lang.Runnable
                public void run() {
                    HomeFragment homeFragment = HomeFragment.this;
                    homeFragment.lambda$getDirections$0(homeFragment.f32app.getELocation());
                }
            }, 1000L);
        }
    }

    public void getReverseGeoCode(Double d, Double d2) {
        if (this.handedOffToRouteFragment) {
            return;
        }
        MapplsReverseGeoCodeManager.newInstance(MapplsReverseGeoCode.builder().setLocation(d.doubleValue(), d2.doubleValue()).build()).call(new OnResponseCallback<PlaceResponse>() { // from class: com.bajajconnect.navigate.fragment.HomeFragment.4
            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onSuccess(PlaceResponse placeResponse) {
                if (HomeFragment.this.handedOffToRouteFragment || HomeFragment.this.getActivity() == null || placeResponse == null) {
                    return;
                }
                Place place = placeResponse.getPlaces().get(0);
                HomeFragment.this.fromLocation = place.getFormattedAddress();
                Log.e("Homefrg", "getReverseCode");
                HomeFragment homeFragment = HomeFragment.this;
                homeFragment.lambda$getDirections$0(homeFragment.f32app.getELocation());
            }

            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onError(int i, String str) {
                Log.e("HomeFragment", "Fragment error");
                if (!HomeFragment.this.handedOffToRouteFragment && HomeFragment.this.fromLocation == null) {
                    HomeFragment.this.fromLocation = "Current location";
                    HomeFragment homeFragment = HomeFragment.this;
                    homeFragment.lambda$getDirections$0(homeFragment.f32app != null ? HomeFragment.this.f32app.getELocation() : null);
                } else {
                    if (HomeFragment.this.getContext() != null) {
                        Toast.makeText(HomeFragment.this.getContext(), str, 1).show();
                    }
                    GlobalVar.isIsTakeMeHomeNavStarting = false;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClick2(View view) {
        this.handedOffToRouteFragment = false;
        lambda$getDirections$0(this.eLocation);
    }
}
