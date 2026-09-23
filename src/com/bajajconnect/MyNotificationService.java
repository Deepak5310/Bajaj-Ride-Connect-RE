package com.bajajconnect;

import android.app.Notification;
import android.app.Person;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import androidx.autofill.HintConstants;
import androidx.core.app.NotificationCompat;
import com.bajajconnect.ble.BleFeatures;
import com.bajajconnect.ble.BleService;
import com.bajajconnect.models.SongInfo;
import com.bajajconnect.recievers.DialerCallGate;
import com.bajajconnect.variables.GlobalVar;
import it.innove.Peripheral$$ExternalSyntheticApiModelOutline0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class MyNotificationService extends NotificationListenerService {
    private static final String TAG = "NOTIF_LISTENER";
    private static final String WHATSAPP_BUSINESS_PACKAGE = "com.whatsapp.w4b";
    private static final String WHATSAPP_PACKAGE = "com.whatsapp";
    private static final String WHATSAPP_VOIP_CHANNEL_PREFIX = "voip_notification";
    private static volatile MyNotificationService sInstance;
    private static final Set<String> SMS_APP_PACKAGES = new HashSet(Arrays.asList("com.samsung.android.messaging", "com.google.android.apps.messaging", "com.android.mms", "com.android.messaging"));
    private static final Set<String> CELLULAR_CALL_PACKAGES = new HashSet(Arrays.asList("com.android.server.telecom", "com.android.phone", "com.android.dialer", "com.google.android.dialer", "com.samsung.android.dialer", "com.samsung.android.incallui", "com.google.android.apps.dialer"));

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    @Override // android.service.notification.NotificationListenerService, android.app.Service
    public void onDestroy() {
        if (sInstance == this) {
            sInstance = null;
        }
        super.onDestroy();
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationPosted(StatusBarNotification statusBarNotification) {
        super.onNotificationPosted(statusBarNotification);
        try {
            String packageName = statusBarNotification.getPackageName();
            Log.d(TAG, "Notification from: " + packageName);
            if (isCellularDialerPackage(packageName) && isConnectedCellularCallNotification(statusBarNotification.getNotification())) {
                Notification notification = statusBarNotification.getNotification();
                long j = notification != null ? notification.when : -1L;
                int i = -1;
                if (notification != null && notification.extras != null) {
                    i = notification.extras.getInt(NotificationCompat.EXTRA_CALL_TYPE, -1);
                }
                Log.i(TAG, "Cellular call CONNECTED notif from " + packageName + " when=" + j + " callType=" + i);
                String strExtractCallerIdentity = extractCallerIdentity(notification);
                StringBuilder sb = new StringBuilder("notifConnected:");
                sb.append(packageName);
                BleService.maybeUpgradeOutgoingCallerFromDialer(strExtractCallerIdentity, sb.toString());
                BleService.markOutgoingCallActive("notif:" + packageName);
            } else if (isCellularDialerPackage(packageName)) {
                Notification notification2 = statusBarNotification.getNotification();
                String strExtractCallerIdentity2 = extractCallerIdentity(notification2);
                CharSequence charSequence = (notification2 == null || notification2.extras == null) ? null : notification2.extras.getCharSequence(NotificationCompat.EXTRA_TEXT);
                StringBuilder sb2 = new StringBuilder("Cellular call notif (not connected yet) from ");
                sb2.append(packageName);
                sb2.append(" identity=\"");
                sb2.append(strExtractCallerIdentity2);
                sb2.append("\" text=\"");
                sb2.append((Object) charSequence);
                sb2.append("\" when=");
                sb2.append(notification2 != null ? notification2.when : -1L);
                Log.d(TAG, sb2.toString());
                if (!strExtractCallerIdentity2.isEmpty()) {
                    BleService.maybeUpgradeOutgoingCallerFromDialer(strExtractCallerIdentity2, "notifDialing:" + packageName);
                }
            }
            if (isWhatsAppPackage(packageName)) {
                handleWhatsAppNotification(statusBarNotification);
                refreshWhatsAppVoipActiveFromNotifications();
            } else if (SMS_APP_PACKAGES.contains(packageName)) {
                handleSmsNotification(statusBarNotification);
            }
        } catch (Exception e) {
            Log.d(TAG, "Error processing notification: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static boolean isCellularCallChronometerActive() {
        MyNotificationService myNotificationService = sInstance;
        if (myNotificationService == null) {
            return false;
        }
        try {
            StatusBarNotification[] activeNotifications = myNotificationService.getActiveNotifications();
            if (activeNotifications == null) {
                return false;
            }
            for (StatusBarNotification statusBarNotification : activeNotifications) {
                if (statusBarNotification != null && isCellularDialerPackage(statusBarNotification.getPackageName()) && isConnectedCellularCallNotification(statusBarNotification.getNotification())) {
                    return true;
                }
            }
        } catch (Exception e) {
            Log.d(TAG, "isCellularCallChronometerActive failed: " + e.getMessage());
        }
        return false;
    }

    private static boolean isCellularDialerPackage(String str) {
        if (str == null) {
            return false;
        }
        if (CELLULAR_CALL_PACKAGES.contains(str)) {
            return true;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("dialer") || lowerCase.contains("incallui") || lowerCase.contains("telecom");
    }

    private static boolean isConnectedCellularCallNotification(Notification notification) {
        Bundle bundle;
        if (notification == null || (bundle = notification.extras) == null) {
            return false;
        }
        CharSequence charSequence = bundle.getCharSequence(NotificationCompat.EXTRA_TITLE);
        CharSequence charSequence2 = bundle.getCharSequence(NotificationCompat.EXTRA_TEXT);
        CharSequence charSequence3 = bundle.getCharSequence(NotificationCompat.EXTRA_SUB_TEXT);
        CharSequence charSequence4 = bundle.getCharSequence(NotificationCompat.EXTRA_BIG_TEXT);
        if (looksLikeDialingOrRinging(charSequence) || looksLikeDialingOrRinging(charSequence2) || looksLikeDialingOrRinging(charSequence3) || looksLikeDialingOrRinging(charSequence4)) {
            return false;
        }
        if (bundle.getBoolean(NotificationCompat.EXTRA_SHOW_CHRONOMETER, false) || looksLikeCallTimer(charSequence) || looksLikeCallTimer(charSequence2) || looksLikeCallTimer(charSequence3) || looksLikeCallTimer(charSequence4)) {
            return true;
        }
        long outgoingDialStartedAtMs = BleService.getOutgoingDialStartedAtMs();
        return outgoingDialStartedAtMs > 0 && notification.when > 0 && notification.when >= outgoingDialStartedAtMs + 1500 && (notification.flags & 2) != 0 && NotificationCompat.CATEGORY_CALL.equals(notification.category);
    }

    public static String peekCellularCallDisplayName() {
        MyNotificationService myNotificationService = sInstance;
        if (myNotificationService == null) {
            return "";
        }
        try {
            StatusBarNotification[] activeNotifications = myNotificationService.getActiveNotifications();
            if (activeNotifications == null) {
                return "";
            }
            for (StatusBarNotification statusBarNotification : activeNotifications) {
                if (statusBarNotification != null && statusBarNotification.getNotification() != null && isCellularDialerPackage(statusBarNotification.getPackageName())) {
                    String strExtractCallerIdentity = extractCallerIdentity(statusBarNotification.getNotification());
                    if (!strExtractCallerIdentity.isEmpty()) {
                        return strExtractCallerIdentity;
                    }
                }
            }
        } catch (Exception e) {
            Log.d(TAG, "peekCellularCallDisplayName failed: " + e.getMessage());
        }
        return "";
    }

    static String extractCallerIdentity(Notification notification) {
        if (notification != null && notification.extras != null) {
            Bundle bundle = notification.extras;
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    ArrayList parcelableArrayList = bundle.getParcelableArrayList(NotificationCompat.EXTRA_PEOPLE_LIST);
                    if (parcelableArrayList != null) {
                        Iterator it2 = parcelableArrayList.iterator();
                        while (it2.hasNext()) {
                            Person personM = Peripheral$$ExternalSyntheticApiModelOutline0.m(it2.next());
                            if (personM != null && personM.getName() != null) {
                                String strTrim = personM.getName().toString().trim();
                                if (looksLikeCallerIdentity(strTrim)) {
                                    return strTrim;
                                }
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
            CharSequence charSequence = bundle.getCharSequence(NotificationCompat.EXTRA_TITLE);
            CharSequence charSequence2 = bundle.getCharSequence(NotificationCompat.EXTRA_TEXT);
            CharSequence charSequence3 = bundle.getCharSequence(NotificationCompat.EXTRA_BIG_TEXT);
            CharSequence charSequence4 = bundle.getCharSequence(NotificationCompat.EXTRA_SUB_TEXT);
            CharSequence charSequence5 = bundle.getCharSequence(NotificationCompat.EXTRA_INFO_TEXT);
            if (looksLikeCallerIdentity(charSequence)) {
                return charSequence.toString().trim();
            }
            if (looksLikeCallerIdentity(charSequence2)) {
                return charSequence2.toString().trim();
            }
            if (looksLikeCallerIdentity(charSequence3)) {
                return charSequence3.toString().trim();
            }
            if (looksLikeCallerIdentity(charSequence4)) {
                return charSequence4.toString().trim();
            }
            if (looksLikeCallerIdentity(charSequence5)) {
                return charSequence5.toString().trim();
            }
        }
        return "";
    }

    private static boolean looksLikeCallerIdentity(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        String strTrim = charSequence.toString().trim();
        if (!strTrim.isEmpty() && !looksLikeDialingOrRinging(strTrim) && !looksLikeCallTimer(strTrim)) {
            String lowerCase = strTrim.toLowerCase();
            if (!lowerCase.equals(NotificationCompat.CATEGORY_CALL) && !lowerCase.equals(HintConstants.AUTOFILL_HINT_PHONE) && !lowerCase.equals("mobile") && !lowerCase.equals("ongoing call") && !lowerCase.equals("in call") && !lowerCase.equals("in-call") && !lowerCase.startsWith("call with")) {
                return true;
            }
        }
        return false;
    }

    public static long getCellularCallNotificationWhen() {
        MyNotificationService myNotificationService = sInstance;
        if (myNotificationService == null) {
            return 0L;
        }
        try {
            StatusBarNotification[] activeNotifications = myNotificationService.getActiveNotifications();
            if (activeNotifications == null) {
                return 0L;
            }
            for (StatusBarNotification statusBarNotification : activeNotifications) {
                if (statusBarNotification != null && statusBarNotification.getNotification() != null && isCellularDialerPackage(statusBarNotification.getPackageName())) {
                    Notification notification = statusBarNotification.getNotification();
                    if ((NotificationCompat.CATEGORY_CALL.equals(notification.category) || (notification.flags & 2) != 0) && notification.when > 0) {
                        return notification.when;
                    }
                }
            }
        } catch (Exception e) {
            Log.d(TAG, "getCellularCallNotificationWhen failed: " + e.getMessage());
        }
        return 0L;
    }

    private static boolean looksLikeDialingOrRinging(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        String lowerCase = charSequence.toString().trim().toLowerCase();
        if (lowerCase.isEmpty()) {
            return false;
        }
        return lowerCase.contains("calling") || lowerCase.contains("dialing") || lowerCase.contains("dialling") || lowerCase.contains("ringing") || lowerCase.contains("connecting") || lowerCase.contains("incoming call") || lowerCase.contains("outgoing call") || lowerCase.equals("incoming") || lowerCase.equals("outgoing");
    }

    private static boolean looksLikeCallTimer(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        return charSequence.toString().trim().matches("^\\d{1,2}:\\d{2}(:\\d{2})?$");
    }

    private void handleWhatsAppNotification(StatusBarNotification statusBarNotification) {
        Notification notification = statusBarNotification.getNotification();
        if (isWhatsAppCallNotification(notification)) {
            Log.d(TAG, "Ignoring WhatsApp call notification");
            DialerCallGate.setWhatsAppVoipNotificationActive(true);
            return;
        }
        Bundle bundle = notification.extras;
        String string = bundle.getString(NotificationCompat.EXTRA_TITLE);
        CharSequence charSequence = bundle.getCharSequence(NotificationCompat.EXTRA_TEXT);
        String string2 = charSequence != null ? charSequence.toString() : "";
        if (Objects.equals(string, "WhatsApp")) {
            return;
        }
        if (isWhatsAppMissedCallMessage(notification, string, string2)) {
            Log.d(TAG, "Ignoring WhatsApp missed-call message: title=\"" + string + "\" text=\"" + string2 + "\"");
            return;
        }
        if (Objects.equals(string, GlobalVar.lastWAPPName) && string2.equals(GlobalVar.lastMessage)) {
            return;
        }
        GlobalVar.lastWAPPName = string;
        GlobalVar.lastMessage = string2;
        String strNormalizeAlertIdentity = normalizeAlertIdentity(string);
        Log.d(TAG, "WhatsApp notification: from=" + string + " display=" + strNormalizeAlertIdentity + " text=" + string2);
        if (BleFeatures.iphoneState != null) {
            BleFeatures.iphoneState.onNotificationRecieved(this, strNormalizeAlertIdentity);
        }
    }

    private boolean isWhatsAppCallNotification(Notification notification) {
        String channelId;
        if (notification == null) {
            return false;
        }
        if (NotificationCompat.CATEGORY_CALL.equals(notification.category)) {
            return true;
        }
        return Build.VERSION.SDK_INT >= 26 && (channelId = notification.getChannelId()) != null && channelId.startsWith(WHATSAPP_VOIP_CHANNEL_PREFIX);
    }

    private static boolean isWhatsAppMissedCallMessage(Notification notification, String str, String str2) {
        if ((notification != null && NotificationCompat.CATEGORY_MISSED_CALL.equals(notification.category)) || isMissedCallBoilerplate(str2)) {
            return true;
        }
        if (notification != null && notification.extras != null) {
            Bundle bundle = notification.extras;
            if (isMissedCallBoilerplate(bundle.getCharSequence(NotificationCompat.EXTRA_BIG_TEXT)) || isMissedCallBoilerplate(bundle.getCharSequence(NotificationCompat.EXTRA_SUB_TEXT)) || isMissedCallBoilerplate(bundle.getCharSequence(NotificationCompat.EXTRA_INFO_TEXT))) {
                return true;
            }
            CharSequence[] charSequenceArray = bundle.getCharSequenceArray(NotificationCompat.EXTRA_TEXT_LINES);
            if (charSequenceArray != null) {
                for (CharSequence charSequence : charSequenceArray) {
                    if (isMissedCallBoilerplate(charSequence)) {
                        return true;
                    }
                }
            }
        }
        return isMissedCallBoilerplate(str);
    }

    private static boolean isMissedCallBoilerplate(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        String strTrim = charSequence.toString().trim().toLowerCase().replaceAll("^[^\\p{L}\\p{N}]+", "").trim();
        if (strTrim.isEmpty()) {
            return false;
        }
        if (strTrim.equals("missed call") || strTrim.equals("missed voice call") || strTrim.equals("missed video call") || strTrim.equals("missed group voice call") || strTrim.equals("missed group video call") || strTrim.equals("missed voice call · tap to call back") || strTrim.equals("missed video call · tap to call back") || strTrim.matches("\\d+\\s+missed\\s+(group\\s+)?(voice|video)\\s+calls?") || strTrim.matches("missed\\s+(group\\s+)?(voice|video)\\s+call(\\s*[·•\\-]\\s*.*)?") || strTrim.matches("missed\\s+call(\\s*[·•\\-]\\s*.*)?")) {
            return true;
        }
        return strTrim.length() <= 48 && strTrim.contains("missed") && strTrim.contains(NotificationCompat.CATEGORY_CALL) && (strTrim.contains("voice") || strTrim.contains("video") || strTrim.startsWith("missed call"));
    }

    private void handleSmsNotification(StatusBarNotification statusBarNotification) {
        Bundle bundle = statusBarNotification.getNotification().extras;
        if (bundle == null) {
            return;
        }
        String string = bundle.getString(NotificationCompat.EXTRA_TITLE);
        CharSequence charSequence = bundle.getCharSequence(NotificationCompat.EXTRA_TEXT);
        String string2 = charSequence != null ? charSequence.toString() : "";
        if (string == null || string.isEmpty()) {
            return;
        }
        if (isGenericSmsTitle(string)) {
            Log.d(TAG, "SMS notification generic title ignored: " + string);
            return;
        }
        String strNormalizeAlertIdentity = normalizeAlertIdentity(string);
        String str = "sms_" + strNormalizeAlertIdentity + "_" + string2;
        if (Objects.equals(str, GlobalVar.lastSmsKey)) {
            Log.d(TAG, "Duplicate SMS notification, ignoring");
            return;
        }
        GlobalVar.lastSmsKey = str;
        StringBuilder sb = new StringBuilder("SMS notification: fromLen=");
        sb.append(string != null ? string.length() : 0);
        sb.append(" displayLen=");
        sb.append(strNormalizeAlertIdentity != null ? strNormalizeAlertIdentity.length() : 0);
        sb.append(" textLen=");
        sb.append(string2 != null ? string2.length() : 0);
        Log.d(TAG, sb.toString());
        if (BleFeatures.iphoneState != null) {
            BleFeatures.iphoneState.onSmsReceived(this, strNormalizeAlertIdentity);
        } else {
            Log.d(TAG, "iphoneState is null, cannot dispatch SMS");
        }
    }

    private static boolean isGenericSmsTitle(String str) {
        if (str == null) {
            return true;
        }
        String strTrim = str.trim();
        return strTrim.equalsIgnoreCase("Message") || strTrim.equalsIgnoreCase("Messages") || strTrim.equalsIgnoreCase("SMS") || strTrim.equalsIgnoreCase("SMS Message") || strTrim.equalsIgnoreCase("SMS: Message") || strTrim.equalsIgnoreCase("New message") || strTrim.equalsIgnoreCase("Text message");
    }

    private static String normalizeAlertIdentity(String str) {
        if (str == null) {
            return "";
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return "";
        }
        String strReplaceAll = strTrim.replaceAll("[^0-9]", "");
        if (strReplaceAll.length() < 10 || strReplaceAll.length() < strTrim.replaceAll("[\\s+\\-()]", "").length() - 1) {
            return strTrim;
        }
        return strReplaceAll.length() > 10 ? strReplaceAll.substring(strReplaceAll.length() - 10) : strReplaceAll;
    }

    public void notifyPlaylistUpdate(List<SongInfo> list, int i) {
        BleFeatures.getInstance().sendPlaylistToCluster(list, i);
    }

    public void notifyResetPlaylist() {
        BleFeatures.getInstance().sendResetPlaylistToCluster();
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationRemoved(StatusBarNotification statusBarNotification) {
        super.onNotificationRemoved(statusBarNotification);
        if (statusBarNotification == null || !isWhatsAppPackage(statusBarNotification.getPackageName())) {
            return;
        }
        refreshWhatsAppVoipActiveFromNotifications();
    }

    private boolean isWhatsAppPackage(String str) {
        return Objects.equals(str, WHATSAPP_PACKAGE) || Objects.equals(str, WHATSAPP_BUSINESS_PACKAGE);
    }

    private void refreshWhatsAppVoipActiveFromNotifications() {
        boolean zIsWhatsAppVoipNotificationActive;
        try {
            StatusBarNotification[] activeNotifications = getActiveNotifications();
            zIsWhatsAppVoipNotificationActive = false;
            if (activeNotifications != null) {
                for (StatusBarNotification statusBarNotification : activeNotifications) {
                    if (statusBarNotification != null && isWhatsAppPackage(statusBarNotification.getPackageName()) && isWhatsAppCallNotification(statusBarNotification.getNotification())) {
                        zIsWhatsAppVoipNotificationActive = true;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            Log.d(TAG, "refreshWhatsAppVoipActive failed: " + e.getMessage());
            zIsWhatsAppVoipNotificationActive = DialerCallGate.isWhatsAppVoipNotificationActive();
        }
        DialerCallGate.setWhatsAppVoipNotificationActive(zIsWhatsAppVoipNotificationActive);
    }
}
