package com.mappls.sdk.navigation.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.OnMapReadyCallback;
import com.mappls.sdk.navigation.R;
import com.mappls.sdk.navigation.apis.NavigationLogger;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MapActivity extends AppCompatActivity implements OnMapReadyCallback {
    public MapView mapView;

    private void initMapView(Bundle bundle) {
        MapView mapView = (MapView) findViewById(R.id.vector_map_view);
        this.mapView = mapView;
        mapView.onCreate(bundle);
        this.mapView.getMapAsync(this);
    }

    private void setupUI() {
        getWindow().setSoftInputMode(3);
    }

    public MapView getMapView() {
        return this.mapView;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.activity_map);
            initMapView(bundle);
            getWindow().addFlags(128);
            setupUI();
        } catch (Exception e) {
            NavigationLogger.d(e);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mapView.onDestroy();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.mapView.onLowMemory();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mapView.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mapView.onResume();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.mapView.onSaveInstanceState(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        this.mapView.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        this.mapView.onStop();
    }
}
