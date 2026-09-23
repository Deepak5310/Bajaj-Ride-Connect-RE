package com.bajajconnect.ble;

import android.content.Context;
import android.database.Cursor;
import android.provider.CallLog;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import com.bajajconnect.utils.ContactsUtil;
import com.bajajconnect.variables.GlobalVar;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class RecentCallsFrame {
    private static final int NAME_FIELD_MAX = 10;
    private static final int PACKET_LEN = 151;
    public static final int STATUS_INCOMING = 1;
    public static final int STATUS_MISSED = 3;
    private static final int STATUS_OFFSET = 137;
    public static final int STATUS_OUTGOING = 2;
    public static final int STATUS_UNKNOWN = 0;

    public static void sendRecentCalls(Context context) {
        sendRecentCalls(context, null, 0);
    }

    public static void sendRecentCalls(Context context, String str, int i) {
        int i2;
        int i3;
        try {
            List<RecentCall> listQueryRecentCalls = queryRecentCalls(context, 5, str, i);
            byte[] bArr = new byte[151];
            bArr[0] = -128;
            bArr[1] = (byte) ((Math.min(listQueryRecentCalls.size(), 5) & 15) << 4);
            int i4 = 2;
            for (int i5 = 0; i5 < 5; i5++) {
                if (i5 < listQueryRecentCalls.size()) {
                    RecentCall recentCall = listQueryRecentCalls.get(i5);
                    byte[] nameFieldBytes = toNameFieldBytes(recentCall.name);
                    if (nameFieldBytes.length == 0) {
                        nameFieldBytes = toNameFieldBytes(recentCall.number);
                    }
                    byte[] bytes = recentCall.number.getBytes(StandardCharsets.US_ASCII);
                    int iMin = Math.min(nameFieldBytes.length, 10);
                    int iMin2 = Math.min(bytes.length, 15);
                    int i6 = i4 + 1;
                    bArr[i4] = (byte) iMin;
                    for (int i7 = 0; i7 < 10; i7++) {
                        if (i7 < iMin) {
                            i3 = i6 + 1;
                            bArr[i6] = nameFieldBytes[i7];
                        } else {
                            i3 = i6 + 1;
                            bArr[i6] = 0;
                        }
                        i6 = i3;
                    }
                    int i8 = i6 + 1;
                    bArr[i6] = (byte) iMin2;
                    for (int i9 = 0; i9 < 15; i9++) {
                        if (i9 < iMin2) {
                            i2 = i8 + 1;
                            bArr[i8] = bytes[i9];
                        } else {
                            i2 = i8 + 1;
                            bArr[i8] = 0;
                        }
                        i8 = i2;
                    }
                    i4 = i8;
                } else {
                    int i10 = i4 + 1;
                    bArr[i4] = 0;
                    int i11 = 0;
                    while (i11 < 10) {
                        bArr[i10] = 0;
                        i11++;
                        i10++;
                    }
                    i4 = i10 + 1;
                    bArr[i10] = 0;
                    int i12 = 0;
                    while (i12 < 15) {
                        int i13 = i4 + 1;
                        bArr[i4] = 0;
                        i12++;
                        i4 = i13;
                    }
                }
            }
            if (i4 != 137) {
                Log.w("BLE_FAV_RC", "RecentCalls layout drift: after 5xRC offset=" + i4 + " (expected 137)");
            }
            for (int i14 = 0; i14 < 5; i14++) {
                int i15 = i14 + 137;
                if (i14 < listQueryRecentCalls.size()) {
                    bArr[i15] = (byte) listQueryRecentCalls.get(i14).status;
                } else {
                    bArr[i15] = 0;
                }
            }
            for (int i16 = 142; i16 < 150; i16++) {
                bArr[i16] = 0;
            }
            byte b = 0;
            for (int i17 = 0; i17 < 150; i17++) {
                b = (byte) (b + bArr[i17]);
            }
            bArr[150] = b;
            Log.i("BLE_PACKET", "RECENT_CALLS packet (151 bytes): " + BleService.bytesToHex(bArr));
            for (int i18 = 0; i18 < listQueryRecentCalls.size(); i18++) {
                RecentCall recentCall2 = listQueryRecentCalls.get(i18);
                StringBuilder sb = new StringBuilder();
                sb.append("  recent[");
                sb.append(i18);
                sb.append("] name=\"");
                sb.append(recentCall2.name);
                sb.append("\" number=\"");
                sb.append(recentCall2.number);
                sb.append("\" status=");
                sb.append(recentCall2.status);
                sb.append(" (");
                sb.append(statusName(recentCall2.status));
                sb.append(")");
                sb.append(recentCall2.seeded ? " [seeded]" : "");
                Log.i("BLE_PACKET", sb.toString());
            }
            if (GlobalVar.RECENT_CALLS_CHAR == null) {
                Log.i("BLE_FAV_RC", "RECENT_CALLS_CHAR not discovered — packet built & logged above but NOT written to BLE");
            } else {
                BleService.prepareCharAndWrite(GlobalVar.RECENT_CALLS_CHAR, bArr);
            }
        } catch (Exception e) {
            Log.e("BLE_FAV_RC", "RecentCalls send failed building packet", e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x0104 A[DONT_GENERATE, PHI: r10
      0x0104: PHI (r10v3 android.database.Cursor) = (r10v2 android.database.Cursor), (r10v4 android.database.Cursor) binds: [B:45:0x0102, B:39:0x00f7] A[DONT_GENERATE, DONT_INLINE]] */
    private static List<RecentCall> queryRecentCalls(Context context, int i, String str, int i2) {
        int i3 = i2;
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        String strLastTenDigits = lastTenDigits(str);
        Cursor cursorQuery = null;
        if (!strLastTenDigits.isEmpty()) {
            if (i3 < 1 || i3 > 3) {
                i3 = 2;
            }
            String strResolveDisplayName = resolveDisplayName(context, null, str, strLastTenDigits);
            arrayList.add(new RecentCall(strResolveDisplayName, strLastTenDigits, i3, true));
            hashSet.add(strLastTenDigits);
            Log.i("BLE_FAV_RC", "seeded recent call name=\"" + strResolveDisplayName + "\" number=" + strLastTenDigits + " status=" + i3 + " (" + statusName(i3) + ")");
        }
        try {
            try {
                cursorQuery = context.getContentResolver().query(CallLog.Calls.CONTENT_URI, new String[]{"name", "number", "type"}, null, null, "date DESC");
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(0);
                        String string2 = cursorQuery.getString(1);
                        int i4 = cursorQuery.getInt(2);
                        if (string2 != null && !string2.trim().isEmpty()) {
                            String strLastTenDigits2 = lastTenDigits(string2);
                            if (!strLastTenDigits2.isEmpty()) {
                                if (hashSet.contains(strLastTenDigits2)) {
                                    if (entryNeedsNameUpgrade(arrayList, strLastTenDigits2)) {
                                        maybeUpgradeExisting(arrayList, strLastTenDigits2, resolveDisplayName(context, string, string2, strLastTenDigits2), mapCallType(i4));
                                    }
                                    if (arrayList.size() >= i && !anySeededNeedsNameUpgrade(arrayList)) {
                                        break;
                                    }
                                } else if (arrayList.size() >= i) {
                                    if (!anySeededNeedsNameUpgrade(arrayList)) {
                                        break;
                                    }
                                } else {
                                    String strResolveDisplayName2 = resolveDisplayName(context, string, string2, strLastTenDigits2);
                                    hashSet.add(strLastTenDigits2);
                                    arrayList.add(new RecentCall(strResolveDisplayName2, strLastTenDigits2, mapCallType(i4), false));
                                }
                                return arrayList;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                Log.e("BLE_FAV_RC", "Error querying recent calls", e);
            }
            return arrayList;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    private static String resolveDisplayName(Context context, String str, String str2, String str3) {
        String contactNameByPhoneNumber;
        String contactNameByPhoneNumber2;
        String contactNameByPhoneNumber3;
        String contactNameByPhoneNumber4;
        if (str != null) {
            String strTrim = str.trim();
            if (!strTrim.isEmpty() && !isSameAsNumber(strTrim, str3, str2)) {
                return strTrim;
            }
        }
        if (str2 != null) {
            try {
                if (!str2.trim().isEmpty() && (contactNameByPhoneNumber = ContactsUtil.getContactNameByPhoneNumber(context, str2.trim())) != null && !contactNameByPhoneNumber.trim().isEmpty()) {
                    return contactNameByPhoneNumber.trim();
                }
                if (str3 != null && !str3.isEmpty()) {
                    contactNameByPhoneNumber2 = ContactsUtil.getContactNameByPhoneNumber(context, str3);
                    if (contactNameByPhoneNumber2 == null && !contactNameByPhoneNumber2.trim().isEmpty()) {
                        return contactNameByPhoneNumber2.trim();
                    }
                    contactNameByPhoneNumber3 = ContactsUtil.getContactNameByPhoneNumber(context, "+91" + str3);
                    if (contactNameByPhoneNumber3 == null && !contactNameByPhoneNumber3.trim().isEmpty()) {
                        return contactNameByPhoneNumber3.trim();
                    }
                    contactNameByPhoneNumber4 = ContactsUtil.getContactNameByPhoneNumber(context, "0" + str3);
                    if (contactNameByPhoneNumber4 != null && !contactNameByPhoneNumber4.trim().isEmpty()) {
                        return contactNameByPhoneNumber4.trim();
                    }
                }
            } catch (Exception e) {
                Log.w("BLE_FAV_RC", "resolveDisplayName contacts lookup failed: " + e.getMessage());
            }
        } else if (str3 != null) {
            contactNameByPhoneNumber2 = ContactsUtil.getContactNameByPhoneNumber(context, str3);
            if (contactNameByPhoneNumber2 == null) {
            }
            contactNameByPhoneNumber3 = ContactsUtil.getContactNameByPhoneNumber(context, "+91" + str3);
            if (contactNameByPhoneNumber3 == null) {
            }
            contactNameByPhoneNumber4 = ContactsUtil.getContactNameByPhoneNumber(context, "0" + str3);
            if (contactNameByPhoneNumber4 != null) {
                return contactNameByPhoneNumber4.trim();
            }
        }
        return str3 != null ? str3 : "";
    }

    private static boolean isSameAsNumber(String str, String str2, String str3) {
        String strReplaceAll = str.replaceAll("\\D", "");
        if (strReplaceAll.isEmpty()) {
            return false;
        }
        if (str2 != null && !str2.isEmpty()) {
            if ((strReplaceAll.length() > 10 ? strReplaceAll.substring(strReplaceAll.length() - 10) : strReplaceAll).equals(str2)) {
                return true;
            }
        }
        if (str3 == null) {
            return false;
        }
        String strReplaceAll2 = str3.replaceAll("\\D", "");
        return !strReplaceAll2.isEmpty() && strReplaceAll.equals(strReplaceAll2);
    }

    private static void maybeUpgradeExisting(List<RecentCall> list, String str, String str2, int i) {
        if (str2 == null || str2.isEmpty()) {
            return;
        }
        for (RecentCall recentCall : list) {
            if (str.equals(recentCall.number)) {
                if (isSameAsNumber(recentCall.name, str, null) && !isSameAsNumber(str2, str, null)) {
                    Log.i("BLE_FAV_RC", "upgraded recent name for " + str + " \"" + recentCall.name + "\" → \"" + str2 + "\"");
                    recentCall.name = str2;
                    recentCall.seeded = false;
                    return;
                }
                if (recentCall.status != 0 || i == 0) {
                    return;
                }
                recentCall.status = i;
                return;
            }
        }
    }

    private static boolean entryNeedsNameUpgrade(List<RecentCall> list, String str) {
        for (RecentCall recentCall : list) {
            if (str.equals(recentCall.number) && isSameAsNumber(recentCall.name, str, null)) {
                return true;
            }
        }
        return false;
    }

    private static boolean anySeededNeedsNameUpgrade(List<RecentCall> list) {
        for (RecentCall recentCall : list) {
            if (recentCall.seeded && isSameAsNumber(recentCall.name, recentCall.number, null)) {
                return true;
            }
        }
        return false;
    }

    private static byte[] toNameFieldBytes(String str) {
        if (str == null) {
            return new byte[0];
        }
        String strTrim = str.replaceAll("[^\\p{ASCII}]", "").replaceAll("[\\p{Cntrl}]", "").trim();
        if (strTrim.isEmpty()) {
            strTrim = str.replaceAll("\\D", "");
            if (strTrim.length() > 10) {
                strTrim = strTrim.substring(strTrim.length() - 10);
            }
        }
        byte[] bytes = strTrim.getBytes(StandardCharsets.US_ASCII);
        if (bytes.length <= 10) {
            return bytes;
        }
        byte[] bArr = new byte[10];
        System.arraycopy(bytes, 0, bArr, 0, 10);
        return bArr;
    }

    private static int mapCallType(int i) {
        switch (i) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
            case 4:
            case 5:
            case 6:
                return 3;
            case 7:
                return 1;
            default:
                Log.w("BLE_FAV_RC", "mapCallType: unknown Android call type=" + i);
                return 0;
        }
    }

    private static String statusName(int i) {
        if (i == 1) {
            return "incoming";
        }
        if (i == 2) {
            return "outgoing";
        }
        if (i == 3) {
            return "missed";
        }
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    static String lastTenDigits(String str) {
        if (str == null) {
            return "";
        }
        String strReplaceAll = str.replaceAll("[^0-9]", "");
        if (strReplaceAll.isEmpty()) {
            return "";
        }
        return strReplaceAll.length() <= 10 ? strReplaceAll : strReplaceAll.substring(strReplaceAll.length() - 10);
    }

    private static class RecentCall {
        String name;
        String number;
        boolean seeded;
        int status;

        RecentCall(String str, String str2, int i, boolean z) {
            this.name = str;
            this.number = str2;
            this.status = i;
            this.seeded = z;
        }
    }
}
