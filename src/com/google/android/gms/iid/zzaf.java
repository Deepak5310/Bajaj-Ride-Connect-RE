package com.google.android.gms.iid;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.work.WorkRequest;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Tasks;
import com.spotify.android.appremote.internal.SdkRemoteClientConnector;
import java.io.IOException;
import java.security.KeyPair;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class zzaf {
    private PendingIntent zzaf;
    private Messenger zzaj;
    private Map<String, Object> zzcz = new ArrayMap();
    private Messenger zzda;
    private MessengerCompat zzdb;
    private Context zzl;
    private static final zzaj<Boolean> zzct = zzai.zzy().zzd("gcm_iid_use_messenger_ipc", true);
    private static String zzcu = null;
    private static boolean zzcv = false;
    private static int zzcw = 0;
    private static int zzcx = 0;
    private static int zzcp = 0;
    private static BroadcastReceiver zzcy = null;

    public zzaf(Context context) {
        this.zzl = context;
    }

    public static boolean zzk(Context context) {
        if (zzcu != null) {
            zzl(context);
        }
        return zzcv;
    }

    public static String zzl(Context context) {
        String str = zzcu;
        if (str != null) {
            return str;
        }
        zzcw = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        if (!PlatformVersion.isAtLeastO()) {
            Iterator<ResolveInfo> it2 = packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0).iterator();
            while (it2.hasNext()) {
                if (zzd(packageManager, it2.next().serviceInfo.packageName, "com.google.android.c2dm.intent.REGISTER")) {
                    zzcv = false;
                    return zzcu;
                }
            }
        }
        Iterator<ResolveInfo> it3 = packageManager.queryBroadcastReceivers(new Intent("com.google.iid.TOKEN_REQUEST"), 0).iterator();
        while (it3.hasNext()) {
            if (zzd(packageManager, it3.next().activityInfo.packageName, "com.google.iid.TOKEN_REQUEST")) {
                zzcv = true;
                return zzcu;
            }
        }
        Log.w("InstanceID", "Failed to resolve IID implementation package, falling back");
        if (zzd(packageManager, "com.google.android.gms")) {
            zzcv = PlatformVersion.isAtLeastO();
            return zzcu;
        }
        if (!PlatformVersion.isAtLeastLollipop() && zzd(packageManager, GooglePlayServicesUtilLight.GOOGLE_SERVICES_FRAMEWORK_PACKAGE)) {
            zzcv = false;
            return zzcu;
        }
        Log.w("InstanceID", "Google Play services is missing, unable to get tokens");
        return null;
    }

    private static boolean zzd(PackageManager packageManager, String str, String str2) {
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", str) == 0) {
            return zzd(packageManager, str);
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 56 + String.valueOf(str2).length());
        sb.append("Possible malicious package ");
        sb.append(str);
        sb.append(" declares ");
        sb.append(str2);
        sb.append(" without permission");
        Log.w("InstanceID", sb.toString());
        return false;
    }

    private static boolean zzd(PackageManager packageManager, String str) {
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
            zzcu = applicationInfo.packageName;
            zzcx = applicationInfo.uid;
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    private static int zzm(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(zzl(context), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    public final void zze(Message message) {
        if (message == null) {
            return;
        }
        if (message.obj instanceof Intent) {
            Intent intent = (Intent) message.obj;
            intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
            if (intent.hasExtra("google.messenger")) {
                Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                if (parcelableExtra instanceof MessengerCompat) {
                    this.zzdb = (MessengerCompat) parcelableExtra;
                }
                if (parcelableExtra instanceof Messenger) {
                    this.zzda = (Messenger) parcelableExtra;
                }
            }
            zzh((Intent) message.obj);
            return;
        }
        Log.w("InstanceID", "Dropping invalid message");
    }

    private final synchronized void zzg(Intent intent) {
        if (this.zzaf == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.zzaf = PendingIntent.getBroadcast(this.zzl, 0, intent2, 0);
        }
        intent.putExtra(SdkRemoteClientConnector.CATEGORY, this.zzaf);
    }

    static String zzi(Bundle bundle) throws IOException {
        if (bundle == null) {
            throw new IOException(InstanceID.ERROR_SERVICE_NOT_AVAILABLE);
        }
        String string = bundle.getString("registration_id");
        if (string == null) {
            string = bundle.getString("unregistered");
        }
        if (string != null) {
            return string;
        }
        String string2 = bundle.getString("error");
        if (string2 != null) {
            throw new IOException(string2);
        }
        String strValueOf = String.valueOf(bundle);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 29);
        sb.append("Unexpected response from GCM ");
        sb.append(strValueOf);
        Log.w("InstanceID", sb.toString(), new Throwable());
        throw new IOException(InstanceID.ERROR_SERVICE_NOT_AVAILABLE);
    }

    private final void zzd(String str, Object obj) {
        synchronized (getClass()) {
            Object obj2 = this.zzcz.get(str);
            this.zzcz.put(str, obj);
            zzd(obj2, obj);
        }
    }

    private static void zzd(Object obj, Object obj2) {
        if (obj instanceof ConditionVariable) {
            ((ConditionVariable) obj).open();
        }
        if (obj instanceof Messenger) {
            Messenger messenger = (Messenger) obj;
            Message messageObtain = Message.obtain();
            messageObtain.obj = obj2;
            try {
                messenger.send(messageObtain);
            } catch (RemoteException e) {
                String strValueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 24);
                sb.append("Failed to send response ");
                sb.append(strValueOf);
                Log.w("InstanceID", sb.toString());
            }
        }
    }

    public final void zzh(Intent intent) {
        String strSubstring;
        if (intent == null) {
            if (Log.isLoggable("InstanceID", 3)) {
                Log.d("InstanceID", "Unexpected response: null");
                return;
            }
            return;
        }
        String action = intent.getAction();
        if (!"com.google.android.c2dm.intent.REGISTRATION".equals(action) && !"com.google.android.gms.iid.InstanceID".equals(action)) {
            if (Log.isLoggable("InstanceID", 3)) {
                String strValueOf = String.valueOf(intent.getAction());
                Log.d("InstanceID", strValueOf.length() != 0 ? "Unexpected response ".concat(strValueOf) : new String("Unexpected response "));
                return;
            }
            return;
        }
        String stringExtra = intent.getStringExtra("registration_id");
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra("unregistered");
        }
        if (stringExtra == null) {
            String stringExtra2 = intent.getStringExtra("error");
            if (stringExtra2 == null) {
                String strValueOf2 = String.valueOf(intent.getExtras());
                StringBuilder sb = new StringBuilder(String.valueOf(strValueOf2).length() + 49);
                sb.append("Unexpected response, no error or registration id ");
                sb.append(strValueOf2);
                Log.w("InstanceID", sb.toString());
                return;
            }
            if (Log.isLoggable("InstanceID", 3)) {
                String strValueOf3 = String.valueOf(stringExtra2);
                Log.d("InstanceID", strValueOf3.length() != 0 ? "Received InstanceID error ".concat(strValueOf3) : new String("Received InstanceID error "));
            }
            String str = null;
            if (stringExtra2.startsWith("|")) {
                String[] strArrSplit = stringExtra2.split("\\|");
                if (!"ID".equals(strArrSplit[1])) {
                    String strValueOf4 = String.valueOf(stringExtra2);
                    Log.w("InstanceID", strValueOf4.length() != 0 ? "Unexpected structured response ".concat(strValueOf4) : new String("Unexpected structured response "));
                }
                if (strArrSplit.length > 2) {
                    String str2 = strArrSplit[2];
                    strSubstring = strArrSplit[3];
                    if (strSubstring.startsWith(":")) {
                        strSubstring = strSubstring.substring(1);
                    }
                    str = str2;
                } else {
                    strSubstring = "UNKNOWN";
                }
                stringExtra2 = strSubstring;
                intent.putExtra("error", stringExtra2);
            }
            if (str == null) {
                synchronized (getClass()) {
                    for (String str3 : this.zzcz.keySet()) {
                        Object obj = this.zzcz.get(str3);
                        this.zzcz.put(str3, stringExtra2);
                        zzd(obj, stringExtra2);
                    }
                }
                return;
            }
            zzd(str, (Object) stringExtra2);
            return;
        }
        Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
        if (!matcher.matches()) {
            if (Log.isLoggable("InstanceID", 3)) {
                String strValueOf5 = String.valueOf(stringExtra);
                Log.d("InstanceID", strValueOf5.length() != 0 ? "Unexpected response string: ".concat(strValueOf5) : new String("Unexpected response string: "));
                return;
            }
            return;
        }
        String strGroup = matcher.group(1);
        String strGroup2 = matcher.group(2);
        Bundle extras = intent.getExtras();
        extras.putString("registration_id", strGroup2);
        zzd(strGroup, (Object) extras);
    }

    final Bundle zzd(Bundle bundle, KeyPair keyPair) throws IOException {
        int iZzm = zzm(this.zzl);
        bundle.putString("gmsv", Integer.toString(iZzm));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", Integer.toString(InstanceID.zzg(this.zzl)));
        bundle.putString("app_ver_name", InstanceID.zzh(this.zzl));
        bundle.putString("cliv", "iid-12451000");
        bundle.putString(SdkRemoteClientConnector.APP_ID_AUTH, InstanceID.zzd(keyPair));
        if (iZzm >= 12000000 && zzct.get().booleanValue()) {
            try {
                return (Bundle) Tasks.await(new zzr(this.zzl).zzd(1, bundle));
            } catch (InterruptedException | ExecutionException e) {
                if (Log.isLoggable("InstanceID", 3)) {
                    String strValueOf = String.valueOf(e);
                    StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 22);
                    sb.append("Error making request: ");
                    sb.append(strValueOf);
                    Log.d("InstanceID", sb.toString());
                }
                if ((e.getCause() instanceof zzaa) && ((zzaa) e.getCause()).getErrorCode() == 4) {
                    return zzj(bundle);
                }
                return null;
            }
        }
        return zzj(bundle);
    }

    private final Bundle zzj(Bundle bundle) throws IOException {
        Bundle bundleZzk = zzk(bundle);
        if (bundleZzk == null || !bundleZzk.containsKey("google.messenger")) {
            return bundleZzk;
        }
        Bundle bundleZzk2 = zzk(bundle);
        if (bundleZzk2 == null || !bundleZzk2.containsKey("google.messenger")) {
            return bundleZzk2;
        }
        return null;
    }

    private static synchronized String zzx() {
        int i;
        i = zzcp;
        zzcp = i + 1;
        return Integer.toString(i);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0109  */
    /* JADX WARN: Code duplicated, block: B:34:0x0110 A[Catch: all -> 0x0147, TryCatch #2 {, blocks: (B:32:0x010c, B:34:0x0110, B:36:0x011f, B:37:0x0126, B:38:0x0140), top: B:79:0x010c }] */
    /* JADX WARN: Code duplicated, block: B:36:0x011f A[Catch: all -> 0x0147, TryCatch #2 {, blocks: (B:32:0x010c, B:34:0x0110, B:36:0x011f, B:37:0x0126, B:38:0x0140), top: B:79:0x010c }] */
    /* JADX WARN: Code duplicated, block: B:43:0x014a  */
    /* JADX WARN: Code duplicated, block: B:45:0x015c  */
    /* JADX WARN: Code duplicated, block: B:51:0x0177  */
    /* JADX WARN: Code duplicated, block: B:53:0x017b  */
    /* JADX WARN: Code duplicated, block: B:54:0x0181  */
    /* JADX WARN: Code duplicated, block: B:79:0x010c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private final Bundle zzk(Bundle bundle) throws IOException {
        Bundle bundle2;
        ConditionVariable conditionVariable = new ConditionVariable();
        String strZzx = zzx();
        synchronized (getClass()) {
            this.zzcz.put(strZzx, conditionVariable);
        }
        if (this.zzaj == null) {
            zzl(this.zzl);
            this.zzaj = new Messenger(new zzag(this, Looper.getMainLooper()));
        }
        if (zzcu == null) {
            throw new IOException(InstanceID.ERROR_MISSING_INSTANCEID_SERVICE);
        }
        Intent intent = new Intent(zzcv ? "com.google.iid.TOKEN_REQUEST" : "com.google.android.c2dm.intent.REGISTER");
        intent.setPackage(zzcu);
        intent.putExtras(bundle);
        zzg(intent);
        StringBuilder sb = new StringBuilder(String.valueOf(strZzx).length() + 5);
        sb.append("|ID|");
        sb.append(strZzx);
        sb.append("|");
        intent.putExtra("kid", sb.toString());
        StringBuilder sb2 = new StringBuilder(String.valueOf(strZzx).length() + 5);
        sb2.append("|ID|");
        sb2.append(strZzx);
        sb2.append("|");
        intent.putExtra("X-kid", sb2.toString());
        boolean zEquals = GooglePlayServicesUtilLight.GOOGLE_SERVICES_FRAMEWORK_PACKAGE.equals(zzcu);
        String stringExtra = intent.getStringExtra("useGsf");
        if (stringExtra != null) {
            zEquals = "1".equals(stringExtra);
        }
        if (Log.isLoggable("InstanceID", 3)) {
            String strValueOf = String.valueOf(intent.getExtras());
            StringBuilder sb3 = new StringBuilder(String.valueOf(strValueOf).length() + 8);
            sb3.append("Sending ");
            sb3.append(strValueOf);
            Log.d("InstanceID", sb3.toString());
        }
        if (this.zzda != null) {
            intent.putExtra("google.messenger", this.zzaj);
            Message messageObtain = Message.obtain();
            messageObtain.obj = intent;
            try {
                this.zzda.send(messageObtain);
            } catch (RemoteException unused) {
                if (Log.isLoggable("InstanceID", 3)) {
                    Log.d("InstanceID", "Messenger failed, fallback to startService");
                }
                if (zEquals) {
                    synchronized (zzaf.class) {
                        if (zzcy == null) {
                            zzcy = new zzah(this);
                            if (Log.isLoggable("InstanceID", 3)) {
                                Log.d("InstanceID", "Registered GSF callback receiver");
                            }
                            IntentFilter intentFilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
                            intentFilter.addCategory(this.zzl.getPackageName());
                            this.zzl.registerReceiver(zzcy, intentFilter, "com.google.android.c2dm.permission.SEND", null);
                        }
                        this.zzl.sendBroadcast(intent);
                    }
                } else {
                    intent.putExtra("google.messenger", this.zzaj);
                    intent.putExtra("messenger2", "1");
                    if (this.zzdb != null) {
                        Message messageObtain2 = Message.obtain();
                        messageObtain2.obj = intent;
                        try {
                            this.zzdb.send(messageObtain2);
                        } catch (RemoteException unused2) {
                            if (Log.isLoggable("InstanceID", 3)) {
                                Log.d("InstanceID", "Messenger failed, fallback to startService");
                            }
                            if (zzcv) {
                                this.zzl.sendBroadcast(intent);
                            } else {
                                this.zzl.startService(intent);
                            }
                        }
                    } else if (zzcv) {
                        this.zzl.sendBroadcast(intent);
                    } else {
                        this.zzl.startService(intent);
                    }
                }
            }
        } else if (zEquals) {
            synchronized (zzaf.class) {
                if (zzcy == null) {
                    zzcy = new zzah(this);
                    if (Log.isLoggable("InstanceID", 3)) {
                        Log.d("InstanceID", "Registered GSF callback receiver");
                    }
                    IntentFilter intentFilter2 = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
                    intentFilter2.addCategory(this.zzl.getPackageName());
                    this.zzl.registerReceiver(zzcy, intentFilter2, "com.google.android.c2dm.permission.SEND", null);
                }
            }
            this.zzl.sendBroadcast(intent);
        } else {
            intent.putExtra("google.messenger", this.zzaj);
            intent.putExtra("messenger2", "1");
            if (this.zzdb != null) {
                Message messageObtain3 = Message.obtain();
                messageObtain3.obj = intent;
                this.zzdb.send(messageObtain3);
            } else if (zzcv) {
                this.zzl.sendBroadcast(intent);
            } else {
                this.zzl.startService(intent);
            }
        }
        conditionVariable.block(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
        synchronized (getClass()) {
            Object objRemove = this.zzcz.remove(strZzx);
            if (objRemove instanceof Bundle) {
                bundle2 = (Bundle) objRemove;
            } else {
                if (objRemove instanceof String) {
                    throw new IOException((String) objRemove);
                }
                String strValueOf2 = String.valueOf(objRemove);
                StringBuilder sb4 = new StringBuilder(String.valueOf(strValueOf2).length() + 12);
                sb4.append("No response ");
                sb4.append(strValueOf2);
                Log.w("InstanceID", sb4.toString());
                throw new IOException(InstanceID.ERROR_TIMEOUT);
            }
        }
        return bundle2;
    }
}
