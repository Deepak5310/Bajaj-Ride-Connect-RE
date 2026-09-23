package com.mappls.sdk.navigation;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.location.Location;
import com.mappls.sdk.navigation.model.NavigationPath;
import com.mappls.sdk.navigation.routing.NavigationStep;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class NavigationApplication extends Application {
    @Deprecated
    public static boolean isLocationEnabled(Context context) {
        return NavigationContext.isLocationEnabled(context);
    }

    @Deprecated
    public NavigationPath getCalculatedRoute() {
        return NavigationContext.getNavigationContext().getCalculatedRoute();
    }

    @Deprecated
    public Location getCurrentLocation() {
        return NavigationContext.getNavigationContext().getCurrentLocation();
    }

    @Deprecated
    public NavigationLocationProvider getLocationProvider() {
        return NavigationContext.getNavigationContext().getLocationProvider();
    }

    @Deprecated
    public List<NavigationStep> getRouteDirections() {
        return MapplsNavigationHelper.getInstance().getNavigationSteps();
    }

    @Deprecated
    public void onAutoDriveEnabled() {
        NavigationContext.getNavigationContext().onAutoDriveEnabled();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        NavigationContext.getNavigationContext().onConfigurationChanged(configuration);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        NavigationContext.init(this);
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        NavigationContext.terminate();
    }

    @Deprecated
    public void setCurrentLocation(Location location) {
        NavigationContext.getNavigationContext().setCurrentLocation(location);
    }

    @Deprecated
    public void stopNavigation() {
        MapplsNavigationHelper.getInstance().stopNavigation();
    }
}
