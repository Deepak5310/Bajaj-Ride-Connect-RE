package com.bajajconnect;

import android.content.Context;
import android.location.Location;
import com.bajajconnect.gMaps.NavigationActivity;
import com.bajajconnect.navigate.utils.MapplsSessionHelper;
import com.bajajconnect.navigation.NavigationManagerPackage;
import com.bajajconnect.wifi.CustomProjection;
import com.bajajconnect.wifi.StreamingHandler;
import com.facebook.react.PackageList;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactHost;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.defaults.DefaultReactHost;
import com.facebook.react.defaults.DefaultReactNativeHost;
import com.facebook.soloader.SoLoader;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mappls.sdk.maps.Mappls;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.NavLocation;
import com.mappls.sdk.navigation.NavigationApplication;
import com.mappls.sdk.navigation.ui.navigation.MapplsNavigationViewHelper;
import com.mappls.sdk.services.api.autosuggest.model.ELocation;
import com.mappls.sdk.services.api.directions.models.DirectionsResponse;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainApplication.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bajajconnect/MainApplication;", "Lcom/mappls/sdk/navigation/NavigationApplication;", "Lcom/facebook/react/ReactApplication;", "()V", "currentLocation", "Landroid/location/Location;", "eLocation", "Lcom/mappls/sdk/services/api/autosuggest/model/ELocation;", "reactHost", "Lcom/facebook/react/ReactHost;", "getReactHost", "()Lcom/facebook/react/ReactHost;", "reactNativeHost", "Lcom/facebook/react/ReactNativeHost;", "getReactNativeHost", "()Lcom/facebook/react/ReactNativeHost;", "startNavigationLocation", "Lcom/mappls/sdk/navigation/NavLocation;", "trip", "Lcom/mappls/sdk/services/api/directions/models/DirectionsResponse;", "onCreate", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MainApplication extends NavigationApplication implements ReactApplication {
    private Location currentLocation;
    private ELocation eLocation;
    private final ReactNativeHost reactNativeHost = new DefaultReactNativeHost(this) { // from class: com.bajajconnect.MainApplication$reactNativeHost$1
        private final boolean isHermesEnabled;
        private final boolean isNewArchEnabled;

        @Override // com.facebook.react.ReactNativeHost
        public boolean getUseDeveloperSupport() {
            return false;
        }

        {
            super(this);
            this.isHermesEnabled = true;
        }

        @Override // com.facebook.react.ReactNativeHost
        protected List<ReactPackage> getPackages() {
            ArrayList<ReactPackage> packages = new PackageList(this).getPackages();
            packages.add(new CustomModulePackage());
            packages.add(new NavigationManagerPackage());
            Intrinsics.checkNotNullExpressionValue(packages, "apply(...)");
            return packages;
        }

        @Override // com.facebook.react.ReactNativeHost
        protected String getJSMainModuleName() {
            return FirebaseAnalytics.Param.INDEX;
        }

        @Override // com.facebook.react.defaults.DefaultReactNativeHost
        /* JADX INFO: renamed from: isNewArchEnabled, reason: from getter */
        protected boolean getIsNewArchEnabled() {
            return this.isNewArchEnabled;
        }

        @Override // com.facebook.react.defaults.DefaultReactNativeHost
        protected Boolean isHermesEnabled() {
            return Boolean.valueOf(this.isHermesEnabled);
        }
    };
    private NavLocation startNavigationLocation;
    private DirectionsResponse trip;

    @Override // com.facebook.react.ReactApplication
    public ReactNativeHost getReactNativeHost() {
        return this.reactNativeHost;
    }

    @Override // com.facebook.react.ReactApplication
    public ReactHost getReactHost() {
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return DefaultReactHost.getDefaultReactHost(applicationContext, getReactNativeHost());
    }

    @Override // com.mappls.sdk.navigation.NavigationApplication, android.app.Application
    public void onCreate() {
        super.onCreate();
        MainApplication mainApplication = this;
        SoLoader.init((Context) mainApplication, false);
        MainApplication mainApplication2 = this;
        NavApplication.application = mainApplication2;
        NavApplication.customProjection = new CustomProjection(mainApplication);
        NavApplication.streamingHandler = new StreamingHandler(mainApplication);
        MapplsSessionHelper.applyBuildConfigCredentials();
        MapplsNavigationHelper.getInstance().setNavigationActivityClass(NavigationActivity.class);
        MapplsNavigationHelper.getInstance().setJunctionViewEnabled(true);
        MapplsNavigationHelper.getInstance().setNavigationEventEnabled(true);
        Mappls.getInstance(getApplicationContext());
        MapplsNavigationViewHelper.getInstance().init(mainApplication2);
    }
}
