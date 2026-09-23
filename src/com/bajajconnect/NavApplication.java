package com.bajajconnect;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.bajajconnect.navigate.NavigationActivity;
import com.bajajconnect.navigation.NavigationManagerPackage;
import com.bajajconnect.wifi.CustomProjection;
import com.bajajconnect.wifi.StreamingHandler;
import com.facebook.react.PackageList;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.soloader.SoLoader;
import com.mappls.sdk.maps.Mappls;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.NavLocation;
import com.mappls.sdk.navigation.NavigationApplication;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.autosuggest.model.ELocation;
import com.mappls.sdk.services.api.directions.models.DirectionsResponse;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class NavApplication extends NavigationApplication implements ReactApplication, Application.ActivityLifecycleCallbacks {
    public static Typeface SAIRA_BOLD;
    public static Typeface SAIRA_MEDIUM;
    public static Typeface SAIRA_REGULAR;
    public static Activity activity;
    public static NavigationApplication application;
    private static Location currentLocation;
    public static CustomProjection customProjection;
    public static ELocation eLocation;
    private static NavLocation startNavigationLocation;
    public static StreamingHandler streamingHandler;
    private static DirectionsResponse trip;
    private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) { // from class: com.bajajconnect.NavApplication.2
        @Override // com.facebook.react.ReactNativeHost
        public boolean getUseDeveloperSupport() {
            return false;
        }

        @Override // com.facebook.react.ReactNativeHost
        protected String getJSBundleFile() {
            return super.getJSBundleFile();
        }

        @Override // com.facebook.react.ReactNativeHost
        protected List<ReactPackage> getPackages() {
            ArrayList<ReactPackage> packages = new PackageList(this).getPackages();
            packages.add(new MusicFilesManagerPackage());
            packages.add(new CallManagerPackage());
            packages.add(new NavigationManagerPackage());
            return packages;
        }

        @Override // com.facebook.react.ReactNativeHost
        protected String getJSMainModuleName() {
            return "apps/bajaj/ride-connect/src/main";
        }
    };
    private static final NavApplication FRAGMENT_NAV_BRIDGE = new NavApplication() { // from class: com.bajajconnect.NavApplication.1
        @Override // com.bajajconnect.NavApplication, com.mappls.sdk.navigation.NavigationApplication, android.app.Application
        public void onCreate() {
        }
    };
    public static boolean isForeground = true;

    private static void initializeFlipper(Context context, ReactInstanceManager reactInstanceManager) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity2, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity2) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity2, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity2) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity2) {
    }

    private static void ensureBridgeContext() {
        if (application != null) {
            NavApplication navApplication = FRAGMENT_NAV_BRIDGE;
            if (navApplication.getBaseContext() == null) {
                navApplication.attachBaseContext(application);
            }
        }
    }

    public static NavApplication forFragments() {
        NavigationApplication navigationApplication = application;
        if (navigationApplication instanceof NavApplication) {
            return (NavApplication) navigationApplication;
        }
        ensureBridgeContext();
        return FRAGMENT_NAV_BRIDGE;
    }

    public static NavigationApplication navigationApplication() {
        return application;
    }

    public static NavigationApplication navigationContext() {
        NavigationApplication navigationApplication = application;
        if (navigationApplication != null) {
            return navigationApplication;
        }
        ensureBridgeContext();
        return FRAGMENT_NAV_BRIDGE;
    }

    @Override // com.facebook.react.ReactApplication
    public ReactNativeHost getReactNativeHost() {
        return this.mReactNativeHost;
    }

    @Override // com.mappls.sdk.navigation.NavigationApplication, android.app.Application
    public void onCreate() {
        super.onCreate();
        SoLoader.init((Context) this, false);
        initializeFlipper(this, getReactNativeHost().getReactInstanceManager());
        customProjection = new CustomProjection(this);
        streamingHandler = new StreamingHandler(this);
        MapplsNavigationHelper.getInstance().init(this);
        MapplsAccountManager.getInstance().setRestAPIKey(getRestAPIKey());
        MapplsAccountManager.getInstance().setMapSDKKey(getMapSDKKey());
        MapplsAccountManager.getInstance().setAtlasClientId(getAtlasClientId());
        MapplsAccountManager.getInstance().setAtlasClientSecret(getAtlasClientSecret());
        MapplsNavigationHelper.getInstance().setNavigationActivityClass(NavigationActivity.class);
        MapplsNavigationHelper.getInstance().setJunctionViewEnabled(true);
        MapplsNavigationHelper.getInstance().setNavigationEventEnabled(true);
        MapplsNavigationHelper.getInstance().showRoadConditionsEvents(true);
        MapplsNavigationHelper.getInstance().showSafetyEvents(true);
        MapplsNavigationHelper.getInstance().setNavigationEventAudioPromptEnabled(true);
        MapplsNavigationHelper.getInstance().speakRoadConditionsEvents(true);
        MapplsNavigationHelper.getInstance().speakSafetyEvents(true);
        MapplsNavigationHelper.getInstance().speakTrafficEvents(true);
        Mappls.getInstance(this);
        application = this;
        registerActivityLifecycleCallbacks(this);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (Build.VERSION.SDK_INT >= 34) {
            return super.registerReceiver(broadcastReceiver, intentFilter, 4);
        }
        return super.registerReceiver(broadcastReceiver, intentFilter);
    }

    private String getAtlasClientId() {
        return "96dHZVzsAusdFSRGu047EP1OFqsfrwiJ19XJyUx0RRyUz35b0PgtCrbotg-HXvqrPZrmnvVYanbgDngvVX3S_w==";
    }

    private String getAtlasClientSecret() {
        return "lrFxI-iSEg8ktludBF9Ct_cKzeK5YAIgJuuvNwpTKIpmZZAMy7EwOfCSwYTOrEJwt78FT46APVqk-_mEDwVhMG2AeSda1vxG";
    }

    private String getMapSDKKey() {
        return "4987143528819d02c77104f5ed70f3b3";
    }

    private String getRestAPIKey() {
        return "4987143528819d02c77104f5ed70f3b3";
    }

    public ELocation getELocation() {
        return eLocation;
    }

    public void setELocation(ELocation eLocation2) {
        eLocation = eLocation2;
    }

    @Override // com.mappls.sdk.navigation.NavigationApplication
    public Location getCurrentLocation() {
        return currentLocation;
    }

    @Override // com.mappls.sdk.navigation.NavigationApplication
    public void setCurrentLocation(Location location) {
        currentLocation = location;
    }

    public NavLocation getStartNavigationLocation() {
        return startNavigationLocation;
    }

    public void setStartNavigationLocation(NavLocation navLocation) {
        startNavigationLocation = navLocation;
    }

    public DirectionsResponse getTrip() {
        return trip;
    }

    public void setTrip(DirectionsResponse directionsResponse) {
        trip = directionsResponse;
    }

    @Override // com.mappls.sdk.navigation.NavigationApplication, android.app.Application
    public void onTerminate() {
        super.onTerminate();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity2) {
        Log.e("NavApplication", "activity resumed");
        isForeground = true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity2) {
        Log.e("NavApplication", "activity paused");
        isForeground = false;
    }
}
