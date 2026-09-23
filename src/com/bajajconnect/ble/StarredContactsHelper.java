package com.bajajconnect.ble;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class StarredContactsHelper {
    private static final String TAG = "BLE_FAV_RC";

    private StarredContactsHelper() {
    }

    public static final class Entry {
        public final String name;
        public final String number;

        Entry(String str, String str2) {
            this.name = str;
            this.number = str2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0070 A[PHI: r3
      0x0070: PHI (r3v3 android.database.Cursor) = (r3v0 android.database.Cursor), (r3v4 android.database.Cursor) binds: [B:29:0x006e, B:25:0x0063] A[DONT_GENERATE, DONT_INLINE]] */
    public static List<Entry> queryStarredContacts(Context context, int i) {
        ArrayList arrayList = new ArrayList();
        if (context == null || i <= 0) {
            return arrayList;
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, new String[]{"_id", "display_name"}, "starred=1", null, "display_name ASC");
                if (cursorQuery == null) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return arrayList;
                }
                int columnIndex = cursorQuery.getColumnIndex("_id");
                int columnIndex2 = cursorQuery.getColumnIndex("display_name");
                while (cursorQuery.moveToNext() && arrayList.size() < i) {
                    String string = cursorQuery.getString(columnIndex);
                    String string2 = cursorQuery.getString(columnIndex2);
                    if (string2 == null) {
                        string2 = "";
                    }
                    String strBestPhoneForContact = bestPhoneForContact(context, string);
                    if (!strBestPhoneForContact.isEmpty()) {
                        arrayList.add(new Entry(string2.trim(), strBestPhoneForContact));
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return arrayList;
            } catch (Exception e) {
                Log.e(TAG, "Error querying starred contacts", e);
                if (0 != 0) {
                    cursorQuery.close();
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public static Entry getStarredContactAt(Context context, int i) {
        if (context == null || i < 0 || i > 4) {
            return null;
        }
        List<Entry> listQueryStarredContacts = queryStarredContacts(context, i + 1);
        if (i < listQueryStarredContacts.size()) {
            return listQueryStarredContacts.get(i);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0088  */
    private static String bestPhoneForContact(Context context, String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"data1", "data2"}, "contact_id=?", new String[]{str}, null);
                if (cursorQuery == null) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return "";
                }
                String str2 = "";
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(0);
                    if (string != null && !string.trim().isEmpty()) {
                        String strTrim = string.trim();
                        if (cursorQuery.getInt(1) == 2) {
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return strTrim;
                        }
                        if (str2.isEmpty()) {
                            str2 = strTrim;
                        }
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return str2;
            } catch (Exception e) {
                Log.e(TAG, "Error looking up phone for contact " + str, e);
                if (0 != 0) {
                    cursor.close();
                }
                return "";
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
        if (0 != 0) {
            cursor.close();
        }
        throw th;
    }
}
