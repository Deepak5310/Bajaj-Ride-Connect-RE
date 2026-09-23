package com.mappls.android.lms;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.autofill.HintConstants;
import com.mappls.android.util.MPLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes6.dex */
class SystemInformation {
    private static final String LOGTAG = "MapplsAnalyticsAPI.SysInfo";
    private static SystemInformation sInstance;
    private static final Object sInstanceLock = new Object();
    private final String mAppName;
    private final Integer mAppVersionCode;
    private final String mAppVersionName;
    private final Context mContext;
    private final DisplayMetrics mDisplayMetrics;
    private final Boolean mHasNFC;
    private final Boolean mHasTelephony;

    private SystemInformation(Context context) {
        String str;
        Integer numValueOf;
        String string;
        Method method;
        Boolean bool;
        this.mContext = context;
        PackageManager packageManager = context.getPackageManager();
        Boolean bool2 = null;
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            str = packageInfo.versionName;
            try {
                numValueOf = Integer.valueOf(packageInfo.versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
                MPLog.w(LOGTAG, "System information constructed with a context that apparently doesn't exist.");
                numValueOf = null;
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            str = null;
        }
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i = applicationInfo.labelRes;
        this.mAppVersionName = str;
        this.mAppVersionCode = numValueOf;
        if (i == 0) {
            CharSequence charSequence = applicationInfo.nonLocalizedLabel;
            string = charSequence == null ? "Misc" : charSequence.toString();
        } else {
            string = context.getString(i);
        }
        this.mAppName = string;
        try {
            method = packageManager.getClass().getMethod("hasSystemFeature", String.class);
        } catch (NoSuchMethodException unused3) {
            method = null;
        }
        if (method != null) {
            try {
                bool = (Boolean) method.invoke(packageManager, "android.hardware.nfc");
                try {
                    bool2 = (Boolean) method.invoke(packageManager, "android.hardware.telephony");
                } catch (IllegalAccessException | InvocationTargetException unused4) {
                    MPLog.w(LOGTAG, "System version appeared to support PackageManager.hasSystemFeature, but we were unable to call it.");
                }
            } catch (IllegalAccessException | InvocationTargetException unused5) {
                bool = null;
            }
        } else {
            bool = null;
        }
        this.mHasNFC = bool;
        this.mHasTelephony = bool2;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.mDisplayMetrics = displayMetrics;
        ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
    }

    static SystemInformation getInstance(Context context) {
        synchronized (sInstanceLock) {
            if (sInstance == null) {
                sInstance = new SystemInformation(context.getApplicationContext());
            }
        }
        return sInstance;
    }

    public String getAppName() {
        return this.mAppName;
    }

    public Integer getAppVersionCode() {
        return this.mAppVersionCode;
    }

    public String getAppVersionName() {
        return this.mAppVersionName;
    }

    public String getBluetoothVersion() {
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            return "ble";
        }
        return this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth") ? "classic" : "none";
    }

    public String getCurrentNetworkOperator() {
        TelephonyManager telephonyManager = (TelephonyManager) this.mContext.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        if (telephonyManager != null) {
            return telephonyManager.getNetworkOperatorName();
        }
        return null;
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.mDisplayMetrics;
    }

    public boolean hasNFC() {
        return this.mHasNFC.booleanValue();
    }

    public boolean hasTelephony() {
        return this.mHasTelephony.booleanValue();
    }

    public Boolean isBluetoothEnabled() {
        BluetoothAdapter defaultAdapter;
        try {
            if (this.mContext.getPackageManager().checkPermission("android.permission.BLUETOOTH", this.mContext.getPackageName()) == 0 && (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) != null) {
                return Boolean.valueOf(defaultAdapter.isEnabled());
            }
        } catch (NoClassDefFoundError | SecurityException unused) {
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0028  */
    public Boolean isWifiConnected() {
        boolean z;
        if (this.mContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return null;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            z = activeNetworkInfo.getType() == 1 && activeNetworkInfo.isConnected();
        }
        return Boolean.valueOf(z);
    }
}
