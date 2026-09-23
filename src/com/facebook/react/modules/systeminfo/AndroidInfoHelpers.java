package com.facebook.react.modules.systeminfo;

import android.content.Context;
import android.os.Build;
import com.facebook.common.logging.FLog;
import com.facebook.react.R;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class AndroidInfoHelpers {
    public static final String DEVICE_LOCALHOST = "localhost";
    public static final String EMULATOR_LOCALHOST = "10.0.2.2";
    public static final String GENYMOTION_LOCALHOST = "10.0.3.2";
    public static final String METRO_HOST_PROP_NAME = "metro.host";
    private static final String TAG = "AndroidInfoHelpers";
    private static String metroHostPropValue;

    private static boolean isRunningOnGenymotion() {
        return Build.FINGERPRINT.contains("vbox");
    }

    private static boolean isRunningOnStockEmulator() {
        return Build.FINGERPRINT.contains("generic") || Build.FINGERPRINT.startsWith("google/sdk_gphone");
    }

    public static String getServerHost(Integer num) {
        return getServerIpAddress(num.intValue());
    }

    public static String getServerHost(Context context) {
        return getServerIpAddress(getDevServerPort(context).intValue());
    }

    public static String getAdbReverseTcpCommand(Integer num) {
        return "adb reverse tcp:" + num + " tcp:" + num;
    }

    public static String getAdbReverseTcpCommand(Context context) {
        return getAdbReverseTcpCommand(getDevServerPort(context));
    }

    public static String getFriendlyDeviceName() {
        if (isRunningOnGenymotion()) {
            return Build.MODEL;
        }
        return Build.MODEL + " - " + Build.VERSION.RELEASE + " - API " + Build.VERSION.SDK_INT;
    }

    private static Integer getDevServerPort(Context context) {
        return Integer.valueOf(context.getResources().getInteger(R.integer.react_native_dev_server_port));
    }

    private static String getServerIpAddress(int i) {
        String metroHostPropValue2 = getMetroHostPropValue();
        if (metroHostPropValue2.equals("")) {
            if (isRunningOnGenymotion()) {
                metroHostPropValue2 = GENYMOTION_LOCALHOST;
            } else if (isRunningOnStockEmulator()) {
                metroHostPropValue2 = EMULATOR_LOCALHOST;
            } else {
                metroHostPropValue2 = DEVICE_LOCALHOST;
            }
        }
        return String.format(Locale.US, "%s:%d", metroHostPropValue2, Integer.valueOf(i));
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0077 A[Catch: all -> 0x007b, TRY_ENTER, TryCatch #5 {, blocks: (B:4:0x0003, B:16:0x003a, B:18:0x003f, B:35:0x006b, B:32:0x0065, B:40:0x0072, B:42:0x0077, B:43:0x007a), top: B:56:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:? A[Catch: all -> 0x007b, SYNTHETIC, TryCatch #5 {, blocks: (B:4:0x0003, B:16:0x003a, B:18:0x003f, B:35:0x006b, B:32:0x0065, B:40:0x0072, B:42:0x0077, B:43:0x007a), top: B:56:0x0003 }] */
    private static synchronized String getMetroHostPropValue() {
        BufferedReader bufferedReader;
        Throwable th;
        Process processExec;
        Exception e;
        String str = metroHostPropValue;
        if (str != null) {
            return str;
        }
        try {
            processExec = Runtime.getRuntime().exec(new String[]{"/system/bin/getprop", METRO_HOST_PROP_NAME});
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream(), Charset.forName("UTF-8")));
                String str2 = "";
                while (true) {
                    try {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            str2 = line;
                        } catch (Exception e2) {
                            e = e2;
                            FLog.w(TAG, "Failed to query for metro.host prop:", e);
                            metroHostPropValue = "";
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused) {
                                }
                            }
                            if (processExec != null) {
                            }
                            return metroHostPropValue;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception unused2) {
                            }
                        }
                        if (processExec != null) {
                            processExec.destroy();
                            throw th;
                        }
                        throw th;
                    }
                }
                metroHostPropValue = str2;
                try {
                    bufferedReader.close();
                } catch (Exception unused3) {
                }
                if (processExec != null) {
                    processExec.destroy();
                }
            } catch (Exception e3) {
                bufferedReader = null;
                e = e3;
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (processExec != null) {
                    processExec.destroy();
                    throw th;
                }
                throw th;
            }
        } catch (Exception e4) {
            bufferedReader = null;
            e = e4;
            processExec = null;
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            processExec = null;
        }
        return metroHostPropValue;
    }
}
