package com.bajajconnect.wifi;

import android.net.Network;
import com.bajajconnect.wifi.model.SearchResultModel;
import com.bajajconnect.wifi.tftEnums.TftAddress;
import com.mappls.sdk.navigation.NavLocation;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class MirroringGlobarVar {
    public static String connectedWifiName = "";
    public static Double currentLat = null;
    public static Double currentLng = null;
    public static byte[] documentImageData = null;
    public static byte[] encryptionIV = null;
    public static byte[] encryptionKey = null;
    public static TftAddress favAddress = null;
    public static TftAddress homeAddress = null;
    public static byte[] insuranceImageData = null;
    public static long insuranceImageTimestamp = 0;
    public static boolean isBikeStationary = true;
    public static boolean isKeyboardOpen = false;
    public static boolean isSearchProcessing = false;
    public static boolean isWifiConnected = false;
    public static byte[] licenseImageData = null;
    public static long licenseImageTimestamp = 0;
    public static Network network = null;
    public static byte[] registrationImageData = null;
    public static long registrationImageTimestamp = 0;
    public static String searchText = "Search Place";
    public static SearchResultModel selectedSearchResultModel = null;
    public static boolean showSearchResult = false;
    public static NavLocation startNavigationLocationMirroring;
    public static TftAddress workAddress;
    public static Screens currentScreen = Screens.NONE;
    public static String ACTION_NAV_TO_NAVIGATION = "com.bajaj.rideconnect.nav_toTbt";
    public static String ACTION_STOP_NAVIGATION = "com.bajaj.rideconnect.stop_nav";
    public static String ACTION_SOFTAP_RECONNECTED = "com.bajaj.rideconnect.softap_reconnected";
    public static volatile boolean pendingSoftApMirrorResume = false;
    public static CurrentTFTScreenInfo currentTFTScreenInfo = CurrentTFTScreenInfo.NONE;
    public static CurrentNavigationScreen currentNavigationScreen = CurrentNavigationScreen.NONE;
    public static boolean isOnMirroringPage = true;

    public enum CurrentNavigationScreen {
        NONE,
        ROUTE_INFO,
        NAVIGATION
    }

    public enum CurrentTFTScreenInfo {
        NONE,
        TFT_SEARCH,
        TFT_ROUTE,
        TFT_NAVIGATION
    }

    public static synchronized void setLicenseImageData(byte[] bArr) {
        try {
            if (bArr == null) {
                licenseImageData = null;
                licenseImageTimestamp = System.currentTimeMillis();
            } else {
                licenseImageData = Arrays.copyOf(bArr, bArr.length);
                licenseImageTimestamp = System.currentTimeMillis();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized void setRegistrationImageData(byte[] bArr) {
        try {
            if (bArr == null) {
                registrationImageData = null;
                registrationImageTimestamp = System.currentTimeMillis();
            } else {
                registrationImageData = Arrays.copyOf(bArr, bArr.length);
                registrationImageTimestamp = System.currentTimeMillis();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized void setInsuranceImageData(byte[] bArr) {
        try {
            if (bArr == null) {
                insuranceImageData = null;
                insuranceImageTimestamp = System.currentTimeMillis();
            } else {
                insuranceImageData = Arrays.copyOf(bArr, bArr.length);
                insuranceImageTimestamp = System.currentTimeMillis();
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
