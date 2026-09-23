package com.bajajconnect;

import android.os.Bundle;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.navigation.data.WayPoint;
import com.mappls.sdk.navigation.model.AdviseInfo;
import com.mappls.sdk.navigation.ui.navigation.NavigationCallback;
import com.mappls.sdk.navigation.ui.navigation.NavigationView;
import com.mappls.sdk.navigation.ui.navigation.NavigationViewCallback;
import timber.log.Timber;

/* JADX INFO: loaded from: classes3.dex */
public class NavigationUiActivity extends AppCompatActivity implements NavigationCallback, NavigationViewCallback {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private NavigationView navigationView;

    @Override // com.mappls.sdk.navigation.ui.navigation.NavigationCallback
    public void onNavigationFinished() {
    }

    @Override // com.mappls.sdk.navigation.ui.navigation.NavigationCallback
    public void onNewRoute(String str) {
    }

    @Override // com.mappls.sdk.navigation.ui.navigation.NavigationCallback
    public void onRouteProgress(AdviseInfo adviseInfo) {
    }

    @Override // com.mappls.sdk.navigation.ui.navigation.NavigationViewCallback
    public void searchAlongRoute() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws SecurityException {
        super.onCreate(bundle);
        if (getIntent().getBooleanExtra("isDarkTheme", false)) {
            setContentView(R.layout.activity_navigation_ui_dark);
        } else {
            setContentView(R.layout.activity_navigation_ui);
        }
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        this.navigationView = navigationView;
        if (navigationView != null) {
            navigationView.onCreate(bundle);
            this.navigationView.setNavigationViewCallback(this);
            this.navigationView.setOnNavigationCallback(this);
        }
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) { // from class: com.bajajconnect.NavigationUiActivity.1
            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                if (NavigationUiActivity.this.navigationView != null) {
                    NavigationUiActivity.this.navigationView.onBackPressed(true);
                }
            }
        });
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // com.mappls.sdk.navigation.ui.navigation.NavigationCallback
    public void onNavigationStarted() {
        Timber.e("onNavigationStarted", new Object[0]);
    }

    @Override // com.mappls.sdk.navigation.ui.navigation.NavigationCallback
    public void onNavigationCancelled() {
        Timber.e("onNavigationCancelled", new Object[0]);
        finish();
    }

    @Override // com.mappls.sdk.navigation.ui.navigation.NavigationCallback
    public void onWayPointReached(WayPoint wayPoint) {
        Toast.makeText(this, "Reached to " + wayPoint.getVisualName(), 0).show();
    }

    @Override // com.mappls.sdk.navigation.ui.navigation.NavigationViewCallback
    public void onNavigationMapReady(MapplsMap mapplsMap) {
        mapplsMap.getUiSettings().setLogoGravity(83);
        mapplsMap.getUiSettings().setLogoMargins(500, 0, 0, 700);
    }

    @Override // com.mappls.sdk.navigation.ui.navigation.NavigationViewCallback
    public void onNavigationEnd() {
        finish();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        NavigationView navigationView = this.navigationView;
        if (navigationView != null) {
            navigationView.onLowMemory();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        NavigationView navigationView = this.navigationView;
        if (navigationView != null) {
            navigationView.onResume();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        NavigationView navigationView = this.navigationView;
        if (navigationView != null) {
            navigationView.onStart();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        NavigationView navigationView = this.navigationView;
        if (navigationView != null) {
            navigationView.onStop();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        NavigationView navigationView = this.navigationView;
        if (navigationView != null) {
            navigationView.onDestroy();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }
}
