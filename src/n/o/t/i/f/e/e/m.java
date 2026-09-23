package n.o.t.i.f.e.e;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class m {
    public static volatile Intent a;

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static Intent a(Context context) {
        String lowerCase = Build.BRAND.toLowerCase(Locale.US);
        List arrayList = new ArrayList();
        lowerCase.getClass();
        lowerCase.hashCode();
        byte b = -1;
        switch (lowerCase.hashCode()) {
            case -1320380160:
                if (lowerCase.equals("oneplus")) {
                    b = 0;
                }
                break;
            case -1206476313:
                if (lowerCase.equals("huawei")) {
                    b = 1;
                }
                break;
            case -759499589:
                if (lowerCase.equals("xiaomi")) {
                    b = 2;
                }
                break;
            case 103639:
                if (lowerCase.equals("htc")) {
                    b = 3;
                }
                break;
            case 3003984:
                if (lowerCase.equals("asus")) {
                    b = 4;
                }
                break;
            case 3318203:
                if (lowerCase.equals("letv")) {
                    b = 5;
                }
                break;
            case 3418016:
                if (lowerCase.equals("oppo")) {
                    b = 6;
                }
                break;
            case 3620012:
                if (lowerCase.equals("vivo")) {
                    b = 7;
                }
                break;
            case 99462250:
                if (lowerCase.equals("honor")) {
                    b = 8;
                }
                break;
            case 103777484:
                if (lowerCase.equals("meizu")) {
                    b = 9;
                }
                break;
            case 105000290:
                if (lowerCase.equals("nokia")) {
                    b = 10;
                }
                break;
            case 108389869:
                if (lowerCase.equals("redmi")) {
                    b = Ascii.VT;
                }
                break;
            case 949547143:
                if (lowerCase.equals("coloros")) {
                    b = Ascii.FF;
                }
                break;
            case 1864941562:
                if (lowerCase.equals("samsung")) {
                    b = Ascii.CR;
                }
                break;
        }
        switch (b) {
            case 0:
                arrayList = Arrays.asList(a("com.oneplus.security", "com.oneplus.security.chainlaunch.view.ChainLaunchAppListActivity"));
                break;
            case 1:
                arrayList = Arrays.asList(a("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity"), a("com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity"), a("com.huawei.systemmanager", "com.huawei.systemmanager.appcontrol.activity.StartupAppControlActivity"));
                break;
            case 2:
            case 11:
                arrayList = Arrays.asList(a("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"));
                break;
            case 3:
                arrayList = Arrays.asList(a("com.htc.pitroad", "com.htc.pitroad.landingpage.activity.LandingPageActivity"));
                break;
            case 4:
                arrayList = Arrays.asList(a("com.asus.mobilemanager", "com.asus.mobilemanager.powersaver.PowerSaverSettings"), a("com.asus.mobilemanager", "com.asus.mobilemanager.autostart.AutoStartActivity"), a("com.asus.mobilemanager", "com.asus.mobilemanager.entry.FunctionActivity").setData(Uri.parse("mobilemanager://function/entry/AutoStart")));
                break;
            case 5:
                arrayList = Arrays.asList(a("com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity").setData(Uri.parse("mobilemanager://function/entry/AutoStart")));
                break;
            case 6:
            case 12:
                arrayList = Arrays.asList(a("com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity"), a("com.oppo.safe", "com.oppo.safe.permission.startup.StartupAppListActivity"), a("com.coloros.safecenter", "com.coloros.safecenter.startupapp.StartupAppListActivity").setAction("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS"), a("com.coloros.oppoguardelf", "com.coloros.powermanager.fuelgaue.PowerUsageModelActivity"), a("com.coloros.oppoguardelf", "com.coloros.powermanager.fuelgaue.PowerSaverModeActivity"), a("com.coloros.oppoguardelf", "com.coloros.powermanager.fuelgaue.PowerConsumptionActivity"));
                break;
            case 7:
                arrayList = Arrays.asList(a("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity"), a("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity"), a("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.BgStartUpManager"));
                break;
            case 8:
                arrayList = Arrays.asList(a("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity"));
                break;
            case 9:
                arrayList = Arrays.asList(a("com.meizu.safe", "com.meizu.safe.security.SHOW_APPSEC").addCategory("android.intent.category.DEFAULT"));
                break;
            case 10:
                arrayList = Arrays.asList(a("com.evenwell.powersaving.g3", "com.evenwell.powersaving.g3.exception.PowerSaverExceptionActivity"));
                break;
            case 13:
                arrayList = Arrays.asList(a("com.samsung.android.lool", "com.samsung.android.sm.ui.battery.BatteryActivity"), a("com.samsung.android.sm", "com.samsung.android.sm.ui.battery.BatteryActivity"), a("com.samsung.android.lool", "com.samsung.android.sm.battery.ui.BatteryActivity"));
                break;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            Intent intent = (Intent) arrayList.get(i);
            boolean zA = h.a(context, intent);
            Boolean.valueOf(zA).getClass();
            if (zA) {
                synchronized (m.class) {
                    a = intent;
                }
                return intent;
            }
        }
        return null;
    }

    public static Intent a(String str, String str2) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        return intent;
    }
}
