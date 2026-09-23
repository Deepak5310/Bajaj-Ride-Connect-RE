package com.facebook.react;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import cl.json.RNSharePackage;
import com.BV.LinearGradient.LinearGradientPackage;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilPackage;
import com.agontuk.RNFusedLocation.RNFusedLocationPackage;
import com.airbnb.android.react.lottie.LottiePackage;
import com.ammarahmed.mmkv.RNMMKVPackage;
import com.facebook.react.shell.MainPackageConfig;
import com.facebook.react.shell.MainReactPackage;
import com.henninghall.date_picker.DatePickerPackage;
import com.horcrux.svg.SvgPackage;
import com.learnium.RNDeviceInfo.RNDeviceInfo;
import com.lugg.RNCConfig.RNCConfigPackage;
import com.mappls.sdk.maps.rctmgl.RCTMGLPackage;
import com.oblador.vectoricons.VectorIconsPackage;
import com.ocetnik.timer.BackgroundTimerPackage;
import com.reactnative.ivpusic.imagepicker.PickerPackage;
import com.reactnativecommunity.checkbox.ReactCheckBoxPackage;
import com.reactnativecommunity.cookies.CookieManagerPackage;
import com.reactnativecommunity.geolocation.GeolocationPackage;
import com.reactnativecommunity.netinfo.NetInfoPackage;
import com.reactnativecommunity.slider.ReactSliderPackage;
import com.reactnativekeyboardcontroller.KeyboardControllerPackage;
import com.reactnativerestart.RestartPackage;
import com.rncamerakit.RNCameraKitPackage;
import com.rnfs.RNFSPackage;
import com.rnmaps.maps.MapsPackage;
import com.rt2zz.reactnativecontacts.ReactNativeContacts;
import com.supersami.foregroundservice.ForegroundServicePackage;
import com.swmansion.gesturehandler.RNGestureHandlerPackage;
import com.swmansion.reanimated.ReanimatedPackage;
import com.swmansion.rnscreens.RNScreensPackage;
import com.th3rdwave.safeareacontext.SafeAreaContextPackage;
import com.zoontek.rnbootsplash.RNBootSplashPackage;
import com.zoontek.rnpermissions.RNPermissionsPackage;
import de.patwoz.rn.bluetoothstatemanager.RNBluetoothStateManagerPackage;
import fr.greweb.reactnativeviewshot.RNViewShotPackage;
import io.invertase.firebase.analytics.ReactNativeFirebaseAnalyticsPackage;
import io.invertase.firebase.app.ReactNativeFirebaseAppPackage;
import io.invertase.firebase.config.ReactNativeFirebaseConfigPackage;
import io.invertase.firebase.crashlytics.ReactNativeFirebaseCrashlyticsPackage;
import io.invertase.firebase.fiam.ReactNativeFirebaseFiamPackage;
import io.invertase.firebase.firestore.ReactNativeFirebaseFirestorePackage;
import io.invertase.firebase.messaging.ReactNativeFirebaseMessagingPackage;
import io.invertase.firebase.perf.ReactNativeFirebasePerfPackage;
import io.invertase.notifee.NotifeePackage;
import it.innove.BleManagerPackage;
import java.util.ArrayList;
import java.util.Arrays;
import org.reactnative.maskedview.RNCMaskedViewPackage;
import org.wonday.pdf.RNPDFPackage;

/* JADX INFO: loaded from: classes3.dex */
public class PackageList {
    private Application application;
    private MainPackageConfig mConfig;
    private ReactNativeHost reactNativeHost;

    public PackageList(ReactNativeHost reactNativeHost) {
        this(reactNativeHost, (MainPackageConfig) null);
    }

    public PackageList(Application application) {
        this(application, (MainPackageConfig) null);
    }

    public PackageList(ReactNativeHost reactNativeHost, MainPackageConfig mainPackageConfig) {
        this.reactNativeHost = reactNativeHost;
        this.mConfig = mainPackageConfig;
    }

    public PackageList(Application application, MainPackageConfig mainPackageConfig) {
        this.reactNativeHost = null;
        this.application = application;
        this.mConfig = mainPackageConfig;
    }

    private ReactNativeHost getReactNativeHost() {
        return this.reactNativeHost;
    }

    private Resources getResources() {
        return getApplication().getResources();
    }

    private Application getApplication() {
        ReactNativeHost reactNativeHost = this.reactNativeHost;
        return reactNativeHost == null ? this.application : reactNativeHost.getApplication();
    }

    private Context getApplicationContext() {
        return getApplication().getApplicationContext();
    }

    public ArrayList<ReactPackage> getPackages() {
        return new ArrayList<>(Arrays.asList(new MainReactPackage(this.mConfig), new NotifeePackage(), new ReactCheckBoxPackage(), new GeolocationPackage(), new NetInfoPackage(), new ReactSliderPackage(), new CookieManagerPackage(), new ReactNativeFirebaseAnalyticsPackage(), new ReactNativeFirebaseAppPackage(), new ReactNativeFirebaseCrashlyticsPackage(), new ReactNativeFirebaseFirestorePackage(), new ReactNativeFirebaseFiamPackage(), new ReactNativeFirebaseMessagingPackage(), new ReactNativeFirebasePerfPackage(), new ReactNativeFirebaseConfigPackage(), new RNCMaskedViewPackage(), new ForegroundServicePackage(), new LottiePackage(), new RCTMGLPackage(), new BackgroundTimerPackage(), new BleManagerPackage(), new ReactNativeBlobUtilPackage(), new RNBluetoothStateManagerPackage(), new RNBootSplashPackage(), new RNCameraKitPackage(), new RNCConfigPackage(), new ReactNativeContacts(), new DatePickerPackage(), new RNDeviceInfo(), new RNFSPackage(), new RNFusedLocationPackage(), new RNGestureHandlerPackage(), new PickerPackage(), new KeyboardControllerPackage(), new LinearGradientPackage(), new MapsPackage(), new RNMMKVPackage(), new RNPDFPackage(), new RNPermissionsPackage(), new ReanimatedPackage(), new RestartPackage(), new SafeAreaContextPackage(), new RNScreensPackage(), new RNSharePackage(), new SvgPackage(), new VectorIconsPackage(), new RNViewShotPackage()));
    }
}
