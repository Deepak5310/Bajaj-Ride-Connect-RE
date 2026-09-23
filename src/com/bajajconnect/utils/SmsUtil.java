package com.bajajconnect.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class SmsUtil {
    private static final long AUTO_REPLY_DEBOUNCE_MS = 5000;
    private static String lastAutoReplyNumber = "";
    private static long lastAutoReplySentAtMs;

    public static int getSmsCount(Context context) {
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://sms"), null, null, null, null);
        cursorQuery.moveToFirst();
        return cursorQuery.getCount();
    }

    public static void sendSMS(Context context, String str, String str2) {
        String strTrim;
        if (str == null) {
            strTrim = "";
        } else {
            try {
                strTrim = str.trim();
            } catch (Exception e) {
                Log.w("Smsutil", "sendSMS failed", e);
                return;
            }
        }
        if (strTrim.isEmpty()) {
            Log.w("Smsutil", "sendSMS skipped — empty number");
            return;
        }
        Log.i("Smsutil", "send sms numberLen=" + strTrim.length());
        String strTrim2 = "i will call later.";
        if (str2 != null && !Objects.equals(str2.trim(), "")) {
            strTrim2 = str2.trim();
        }
        SmsManager.getDefault().sendTextMessage(strTrim, null, strTrim2, null, null);
        Toast.makeText(context.getApplicationContext(), "Message Sent", 1).show();
    }

    public static void sendAutoReplyIfConfigured(Context context, String str, String str2, String str3) {
        String strTrim;
        String strTrim2 = "";
        if (str == null) {
            strTrim = "";
        } else {
            try {
                strTrim = str.trim();
            } catch (Exception e) {
                Log.w("Smsutil", "sendAutoReplyIfConfigured failed", e);
                return;
            }
        }
        if (str2 != null) {
            strTrim2 = str2.trim();
        }
        if (!strTrim.isEmpty() && !strTrim2.isEmpty()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (strTrim.equals(lastAutoReplyNumber) && jCurrentTimeMillis - lastAutoReplySentAtMs < AUTO_REPLY_DEBOUNCE_MS) {
                Log.d("Smsutil", "skip duplicate auto-reply reason=" + str3);
                return;
            }
            sendSMS(context, strTrim, strTrim2);
            lastAutoReplyNumber = strTrim;
            lastAutoReplySentAtMs = jCurrentTimeMillis;
            Log.i("Smsutil", "auto-reply sent reason=" + str3 + " numberLen=" + strTrim.length());
            return;
        }
        Log.d("Smsutil", "skip auto-reply reason=" + str3 + " numberEmpty=" + strTrim.isEmpty() + " messageEmpty=" + strTrim2.isEmpty());
    }
}
