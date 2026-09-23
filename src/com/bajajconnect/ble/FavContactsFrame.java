package com.bajajconnect.ble;

import android.content.Context;
import android.util.Log;
import com.bajajconnect.variables.GlobalVar;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class FavContactsFrame {
    public static void sendFavContacts(Context context) {
        int i;
        int i2;
        try {
            List<StarredContactsHelper.Entry> listQueryStarredContacts = StarredContactsHelper.queryStarredContacts(context, 5);
            ArrayList arrayList = new ArrayList();
            for (StarredContactsHelper.Entry entry : listQueryStarredContacts) {
                arrayList.add(new FavContact(entry.name, lastTenDigits(entry.number)));
            }
            byte[] bArr = new byte[151];
            bArr[0] = -64;
            bArr[1] = (byte) ((Math.min(arrayList.size(), 5) & 15) << 4);
            int i3 = 2;
            for (int i4 = 0; i4 < 5; i4++) {
                if (i4 < arrayList.size()) {
                    FavContact favContact = (FavContact) arrayList.get(i4);
                    byte[] bytes = favContact.name.getBytes(StandardCharsets.US_ASCII);
                    byte[] bytes2 = favContact.number.getBytes(StandardCharsets.US_ASCII);
                    int iMin = Math.min(bytes.length, 10);
                    int iMin2 = Math.min(bytes2.length, 15);
                    int i5 = i3 + 1;
                    bArr[i3] = (byte) iMin;
                    for (int i6 = 0; i6 < 10; i6++) {
                        if (i6 < iMin) {
                            i2 = i5 + 1;
                            bArr[i5] = bytes[i6];
                        } else {
                            i2 = i5 + 1;
                            bArr[i5] = 0;
                        }
                        i5 = i2;
                    }
                    i3 = i5 + 1;
                    bArr[i5] = (byte) iMin2;
                    for (int i7 = 0; i7 < 15; i7++) {
                        if (i7 < iMin2) {
                            i = i3 + 1;
                            bArr[i3] = bytes2[i7];
                        } else {
                            i = i3 + 1;
                            bArr[i3] = 0;
                        }
                        i3 = i;
                    }
                } else {
                    int i8 = i3 + 1;
                    bArr[i3] = 0;
                    int i9 = 0;
                    while (i9 < 10) {
                        bArr[i8] = 0;
                        i9++;
                        i8++;
                    }
                    i3 = i8 + 1;
                    bArr[i8] = 0;
                    int i10 = 0;
                    while (i10 < 15) {
                        bArr[i3] = 0;
                        i10++;
                        i3++;
                    }
                }
            }
            while (i3 < 150) {
                bArr[i3] = 0;
                i3++;
            }
            byte b = 0;
            for (int i11 = 0; i11 < 150; i11++) {
                b = (byte) (b + bArr[i11]);
            }
            bArr[150] = b;
            if (GlobalVar.FAV_CONTACTS_CHAR == null) {
                Log.i("BLE_FAV_RC", "FAV_CONTACTS_CHAR not discovered — packet built & logged above but NOT written to BLE");
            } else {
                BleService.prepareCharAndWrite(GlobalVar.FAV_CONTACTS_CHAR, bArr);
            }
        } catch (Exception e) {
            Log.e("BLE_FAV_RC", "FavContacts send failed building packet", e);
        }
    }

    private static String lastTenDigits(String str) {
        if (str == null) {
            return "";
        }
        String strReplaceAll = str.replaceAll("[^0-9]", "");
        if (strReplaceAll.isEmpty()) {
            return "";
        }
        return strReplaceAll.length() <= 10 ? strReplaceAll : strReplaceAll.substring(strReplaceAll.length() - 10);
    }

    private static class FavContact {
        String name;
        String number;

        FavContact(String str, String str2) {
            this.name = str;
            this.number = str2;
        }
    }
}
