package com.bajajconnect.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.util.Log;
import com.bajajconnect.interfaces.ContactCallback;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public class ContactsUtil {
    public static String getActualNumber(String str) {
        if (str == null) {
            return "";
        }
        String strReplaceAll = str.replaceAll("[^0-9]", "");
        if (strReplaceAll.isEmpty()) {
            return str.trim();
        }
        return strReplaceAll.length() <= 10 ? strReplaceAll : strReplaceAll.substring(strReplaceAll.length() - 10);
    }

    public static void getContactName(final Context context, final String str, final ContactCallback contactCallback) {
        new Thread(new Runnable() { // from class: com.bajajconnect.utils.ContactsUtil$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ContactsUtil.lambda$getContactName$0(str, contactCallback, context);
            }
        }).start();
    }

    static /* synthetic */ void lambda$getContactName$0(String str, ContactCallback contactCallback, Context context) {
        if (str != null) {
            try {
                if (!str.trim().isEmpty()) {
                    if (context != null) {
                        String contactNameByPhoneNumber = getContactNameByPhoneNumber(context, str);
                        if (contactNameByPhoneNumber == null || contactNameByPhoneNumber.equals("")) {
                            contactNameByPhoneNumber = getContactNameByPhoneNumber(context, getActualNumber(str));
                        }
                        if (contactNameByPhoneNumber == null) {
                            contactNameByPhoneNumber = "";
                        }
                        contactCallback.result(contactNameByPhoneNumber);
                        return;
                    }
                    contactCallback.result(str);
                    return;
                }
            } catch (Exception unused) {
                if (str == null) {
                    str = "";
                }
                contactCallback.result(str);
                return;
            }
        }
        contactCallback.result("");
    }

    public static String getContactNameByPhoneNumber(Context context, String str) {
        String string;
        if (str == null || str.trim().isEmpty()) {
            return "";
        }
        Cursor cursorQuery = context.getContentResolver().query(Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(str)), new String[]{"display_name"}, null, null, null);
        if (cursorQuery == null) {
            string = "";
        } else {
            if (!cursorQuery.moveToFirst()) {
                string = "";
            } else {
                string = cursorQuery.getString(0);
            }
            cursorQuery.close();
        }
        return string != null ? string : "";
    }

    public static Boolean checkFavorite(Context context, String str) {
        Cursor cursorQuery = context.getContentResolver().query(ContactsContract.Data.CONTENT_URI, null, "data1 LIKE ?", new String[]{"%" + str}, null);
        String string = "";
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                string = cursorQuery.getString(cursorQuery.getColumnIndex("starred"));
            }
        }
        return Boolean.valueOf(string.equals("1"));
    }

    private void getLastNumber(Context context) {
        Cursor cursorQuery = context.getContentResolver().query(CallLog.Calls.CONTENT_URI, null, null, null, "date DESC limit 1;");
        int columnIndex = cursorQuery.getColumnIndex("number");
        int columnIndex2 = cursorQuery.getColumnIndex("type");
        int columnIndex3 = cursorQuery.getColumnIndex("date");
        int columnIndex4 = cursorQuery.getColumnIndex("duration");
        cursorQuery.moveToNext();
        cursorQuery.getString(columnIndex);
        String string = cursorQuery.getString(columnIndex2);
        new Date(Long.valueOf(cursorQuery.getString(columnIndex3)).longValue()).toString();
        cursorQuery.getInt(columnIndex4);
        cursorQuery.close();
        Integer.parseInt(string);
    }

    public static void isMissedCall(Context context) {
        Cursor cursorQuery = context.getContentResolver().query(CallLog.Calls.CONTENT_URI, null, null, null, "date DESC limit 1;");
        int columnIndex = cursorQuery.getColumnIndex("number");
        int columnIndex2 = cursorQuery.getColumnIndex("type");
        int columnIndex3 = cursorQuery.getColumnIndex("date");
        int columnIndex4 = cursorQuery.getColumnIndex("duration");
        cursorQuery.moveToNext();
        cursorQuery.getString(columnIndex);
        String string = cursorQuery.getString(columnIndex2);
        new Date(Long.parseLong(cursorQuery.getString(columnIndex3))).toString();
        cursorQuery.getInt(columnIndex4);
        cursorQuery.close();
        Integer.parseInt(string);
    }

    public static int checkMissedCall(Context context) {
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://call_log/calls"), new String[]{"name", "number", "date", "type"}, "type=? and is_read=?", new String[]{String.valueOf(3), "0"}, "date DESC");
        cursorQuery.moveToFirst();
        Log.e("CALL", "" + cursorQuery.getCount());
        return cursorQuery.getCount();
    }
}
