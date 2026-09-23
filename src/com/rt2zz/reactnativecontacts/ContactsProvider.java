package com.rt2zz.reactnativecontacts;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import androidx.autofill.HintConstants;
import androidx.core.app.NotificationCompat;
import com.facebook.hermes.intl.Constants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.mappls.sdk.services.api.geocoding.GeoCodingCriteria;
import com.mappls.sdk.services.api.weather.WeatherCriteria;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class ContactsProvider {
    public static final int ID_FOR_PROFILE_CONTACT = -1;
    private final ContentResolver contentResolver;
    private static final List<String> JUST_ME_PROJECTION = new ArrayList<String>() { // from class: com.rt2zz.reactnativecontacts.ContactsProvider.1
        {
            add("_id");
            add("contact_id");
            add("raw_contact_id");
            add(Constants.LOCALEMATCHER_LOOKUP);
            add("starred");
            add("mimetype");
            add("display_name");
            add("photo_uri");
            add("data1");
            add("data2");
            add("data5");
            add("data3");
            add("data4");
            add("data6");
            add("data1");
            add("data4");
            add("data2");
            add("data3");
            add("data1");
            add("data1");
            add("data2");
            add("data3");
            add("data1");
            add("data4");
            add("data5");
            add("data1");
            add("data2");
            add("data3");
            add("data4");
            add("data5");
            add("data6");
            add("data7");
            add("data8");
            add("data9");
            add("data10");
            add("data1");
            add("data1");
            add("data1");
            add("data1");
            add("data2");
        }
    };
    private static final List<String> FULL_PROJECTION = new ArrayList<String>() { // from class: com.rt2zz.reactnativecontacts.ContactsProvider.2
        {
            addAll(ContactsProvider.JUST_ME_PROJECTION);
        }
    };
    private static final List<String> PHOTO_PROJECTION = new ArrayList<String>() { // from class: com.rt2zz.reactnativecontacts.ContactsProvider.3
        {
            add("photo_uri");
        }
    };

    public ContactsProvider(ContentResolver contentResolver) {
        this.contentResolver = contentResolver;
    }

    public WritableArray getContactsMatchingString(String str) {
        ContentResolver contentResolver = this.contentResolver;
        Uri uri = ContactsContract.Data.CONTENT_URI;
        List<String> list = FULL_PROJECTION;
        Cursor cursorQuery = contentResolver.query(uri, (String[]) list.toArray(new String[list.size()]), "display_name LIKE ? OR data1 LIKE ?", new String[]{"%" + str + "%", "%" + str + "%"}, null);
        try {
            Map<String, Contact> mapLoadContactsFrom = loadContactsFrom(cursorQuery);
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            WritableArray writableArrayCreateArray = Arguments.createArray();
            Iterator<Contact> it2 = mapLoadContactsFrom.values().iterator();
            while (it2.hasNext()) {
                writableArrayCreateArray.pushMap(it2.next().toMap());
            }
            return writableArrayCreateArray;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public WritableArray getContactsByPhoneNumber(String str) {
        ContentResolver contentResolver = this.contentResolver;
        Uri uri = ContactsContract.Data.CONTENT_URI;
        List<String> list = FULL_PROJECTION;
        Cursor cursorQuery = contentResolver.query(uri, (String[]) list.toArray(new String[list.size()]), "data1 LIKE ? OR data4 LIKE ?", new String[]{"%" + str + "%", "%" + str + "%"}, null);
        try {
            Map<String, Contact> mapLoadContactsFrom = loadContactsFrom(cursorQuery);
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            WritableArray writableArrayCreateArray = Arguments.createArray();
            Iterator<Contact> it2 = mapLoadContactsFrom.values().iterator();
            while (it2.hasNext()) {
                writableArrayCreateArray.pushMap(it2.next().toMap());
            }
            return writableArrayCreateArray;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public WritableArray getContactsByEmailAddress(String str) {
        ContentResolver contentResolver = this.contentResolver;
        Uri uri = ContactsContract.Data.CONTENT_URI;
        List<String> list = FULL_PROJECTION;
        Cursor cursorQuery = contentResolver.query(uri, (String[]) list.toArray(new String[list.size()]), "data1 LIKE ?", new String[]{"%" + str + "%"}, null);
        try {
            Map<String, Contact> mapLoadContactsFrom = loadContactsFrom(cursorQuery);
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            WritableArray writableArrayCreateArray = Arguments.createArray();
            Iterator<Contact> it2 = mapLoadContactsFrom.values().iterator();
            while (it2.hasNext()) {
                writableArrayCreateArray.pushMap(it2.next().toMap());
            }
            return writableArrayCreateArray;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public WritableMap getContactByRawId(String str) {
        int columnIndex;
        Cursor cursorQuery = this.contentResolver.query(ContactsContract.RawContacts.CONTENT_URI, new String[]{"contact_id"}, "_id= ?", new String[]{str}, null);
        cursorQuery.getCount();
        String string = (!cursorMoveToNext(cursorQuery).booleanValue() || (columnIndex = cursorQuery.getColumnIndex("contact_id")) == -1) ? null : cursorQuery.getString(columnIndex);
        cursorQuery.close();
        return getContactById(string);
    }

    public WritableMap getContactById(String str) {
        ContentResolver contentResolver = this.contentResolver;
        Uri uri = ContactsContract.Data.CONTENT_URI;
        List<String> list = FULL_PROJECTION;
        Cursor cursorQuery = contentResolver.query(uri, (String[]) list.toArray(new String[list.size()]), "contact_id = ?", new String[]{str}, null);
        try {
            Map<String, Contact> mapLoadContactsFrom = loadContactsFrom(cursorQuery);
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            if (mapLoadContactsFrom.values().size() > 0) {
                return mapLoadContactsFrom.values().iterator().next().toMap();
            }
            return null;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public Integer getContactsCount() {
        return Integer.valueOf(this.contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null).getCount());
    }

    public WritableArray getContacts() {
        ContentResolver contentResolver = this.contentResolver;
        Uri uriWithAppendedPath = Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI, "data");
        List<String> list = JUST_ME_PROJECTION;
        Cursor cursorQuery = contentResolver.query(uriWithAppendedPath, (String[]) list.toArray(new String[list.size()]), null, null, null);
        try {
            Map<String, Contact> mapLoadContactsFrom = loadContactsFrom(cursorQuery);
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            ContentResolver contentResolver2 = this.contentResolver;
            Uri uri = ContactsContract.Data.CONTENT_URI;
            List<String> list2 = FULL_PROJECTION;
            Cursor cursorQuery2 = contentResolver2.query(uri, (String[]) list2.toArray(new String[list2.size()]), "mimetype=? OR mimetype=? OR mimetype=? OR mimetype=? OR mimetype=? OR mimetype=? OR mimetype=? OR mimetype=? OR mimetype=?", new String[]{"vnd.android.cursor.item/email_v2", "vnd.android.cursor.item/phone_v2", "vnd.android.cursor.item/name", "vnd.android.cursor.item/organization", "vnd.android.cursor.item/postal-address_v2", "vnd.android.cursor.item/note", "vnd.android.cursor.item/website", "vnd.android.cursor.item/im", "vnd.android.cursor.item/contact_event"}, null);
            try {
                Map<String, Contact> mapLoadContactsFrom2 = loadContactsFrom(cursorQuery2);
                if (cursorQuery2 != null) {
                    cursorQuery2.close();
                }
                WritableArray writableArrayCreateArray = Arguments.createArray();
                Iterator<Contact> it2 = mapLoadContactsFrom.values().iterator();
                while (it2.hasNext()) {
                    writableArrayCreateArray.pushMap(it2.next().toMap());
                }
                Iterator<Contact> it3 = mapLoadContactsFrom2.values().iterator();
                while (it3.hasNext()) {
                    writableArrayCreateArray.pushMap(it3.next().toMap());
                }
                return writableArrayCreateArray;
            } catch (Throwable th) {
                if (cursorQuery2 != null) {
                    cursorQuery2.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th2;
        }
    }

    private Boolean cursorMoveToNext(Cursor cursor) {
        try {
            return Boolean.valueOf(cursor.moveToNext());
        } catch (RuntimeException unused) {
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private Map<String, Contact> loadContactsFrom(Cursor cursor) {
        String strValueOf;
        String strValueOf2;
        String strValueOf3;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (cursor != null && cursorMoveToNext(cursor).booleanValue()) {
            int columnIndex = cursor.getColumnIndex("contact_id");
            int columnIndex2 = cursor.getColumnIndex("_id");
            int columnIndex3 = cursor.getColumnIndex("raw_contact_id");
            byte b = -1;
            if (columnIndex != -1) {
                strValueOf = cursor.getString(columnIndex);
            } else {
                strValueOf = String.valueOf(-1);
            }
            if (columnIndex2 != -1) {
                strValueOf2 = cursor.getString(columnIndex2);
            } else {
                strValueOf2 = String.valueOf(-1);
            }
            if (columnIndex3 != -1) {
                strValueOf3 = cursor.getString(columnIndex3);
            } else {
                strValueOf3 = String.valueOf(-1);
            }
            if (!linkedHashMap.containsKey(strValueOf)) {
                linkedHashMap.put(strValueOf, new Contact(strValueOf));
            }
            Contact contact = (Contact) linkedHashMap.get(strValueOf);
            String string = cursor.getString(cursor.getColumnIndex("mimetype"));
            String string2 = cursor.getString(cursor.getColumnIndex("display_name"));
            boolean z = cursor.getInt(cursor.getColumnIndex("starred")) == 1;
            Boolean boolValueOf = Boolean.valueOf(z);
            contact.rawContactId = strValueOf3;
            if (!TextUtils.isEmpty(string2) && TextUtils.isEmpty(contact.displayName)) {
                contact.displayName = string2;
            }
            boolValueOf.getClass();
            contact.isStarred = z;
            if (TextUtils.isEmpty(contact.photoUri)) {
                String string3 = cursor.getString(cursor.getColumnIndex("photo_uri"));
                if (!TextUtils.isEmpty(string3)) {
                    contact.photoUri = string3;
                    contact.hasPhoto = true;
                }
            }
            string.hashCode();
            switch (string.hashCode()) {
                case -1569536764:
                    if (string.equals("vnd.android.cursor.item/email_v2")) {
                        b = 0;
                    }
                    break;
                case -1328682538:
                    if (string.equals("vnd.android.cursor.item/contact_event")) {
                        b = 1;
                    }
                    break;
                case -1079224304:
                    if (string.equals("vnd.android.cursor.item/name")) {
                        b = 2;
                    }
                    break;
                case -1079210633:
                    if (string.equals("vnd.android.cursor.item/note")) {
                        b = 3;
                    }
                    break;
                case -601229436:
                    if (string.equals("vnd.android.cursor.item/postal-address_v2")) {
                        b = 4;
                    }
                    break;
                case 456415478:
                    if (string.equals("vnd.android.cursor.item/website")) {
                        b = 5;
                    }
                    break;
                case 684173810:
                    if (string.equals("vnd.android.cursor.item/phone_v2")) {
                        b = 6;
                    }
                    break;
                case 689862072:
                    if (string.equals("vnd.android.cursor.item/organization")) {
                        b = 7;
                    }
                    break;
                case 950831081:
                    if (string.equals("vnd.android.cursor.item/im")) {
                        b = 8;
                    }
                    break;
            }
            String lowerCase = "mobile";
            String lowerCase2 = "work";
            String string4 = "other";
            String str = "";
            switch (b) {
                case 0:
                    String string5 = cursor.getString(cursor.getColumnIndex("data1"));
                    int i = cursor.getInt(cursor.getColumnIndex("data2"));
                    if (!TextUtils.isEmpty(string5)) {
                        if (i == 0) {
                            lowerCase = cursor.getString(cursor.getColumnIndex("data3")) != null ? cursor.getString(cursor.getColumnIndex("data3")).toLowerCase() : "";
                        } else if (i == 1) {
                            lowerCase = "home";
                        } else if (i == 2) {
                            lowerCase = "work";
                        } else if (i == 3 || i != 4) {
                            lowerCase = "other";
                        }
                        contact.emails.add(new Contact.Item(lowerCase, string5, strValueOf2));
                    }
                    break;
                case 1:
                    if (cursor.getInt(cursor.getColumnIndex("data2")) == 3) {
                        try {
                            List listAsList = Arrays.asList(cursor.getString(cursor.getColumnIndex("data1")).replace("--", "").split("-"));
                            if (listAsList.size() == 2) {
                                int i2 = Integer.parseInt((String) listAsList.get(0));
                                int i3 = Integer.parseInt((String) listAsList.get(1));
                                if (i2 >= 1 && i2 <= 12 && i3 >= 1 && i3 <= 31) {
                                    contact.birthday = new Contact.Birthday(i2, i3);
                                }
                            } else if (listAsList.size() == 3) {
                                int i4 = Integer.parseInt((String) listAsList.get(0));
                                int i5 = Integer.parseInt((String) listAsList.get(1));
                                int i6 = Integer.parseInt((String) listAsList.get(2));
                                if (i4 > 0 && i5 >= 1 && i5 <= 12 && i6 >= 1 && i6 <= 31) {
                                    contact.birthday = new Contact.Birthday(i4, i5, i6);
                                }
                            }
                        } catch (ArrayIndexOutOfBoundsException | NullPointerException | NumberFormatException e) {
                            Log.w("ContactsProvider", e.toString());
                        }
                    }
                    break;
                case 2:
                    contact.givenName = cursor.getString(cursor.getColumnIndex("data2"));
                    if (cursor.getString(cursor.getColumnIndex("data5")) != null) {
                        contact.middleName = cursor.getString(cursor.getColumnIndex("data5"));
                    } else {
                        contact.middleName = "";
                    }
                    if (cursor.getString(cursor.getColumnIndex("data3")) != null) {
                        contact.familyName = cursor.getString(cursor.getColumnIndex("data3"));
                    } else {
                        contact.familyName = "";
                    }
                    contact.prefix = cursor.getString(cursor.getColumnIndex("data4"));
                    contact.suffix = cursor.getString(cursor.getColumnIndex("data6"));
                    break;
                case 3:
                    contact.note = cursor.getString(cursor.getColumnIndex("data1"));
                    break;
                case 4:
                    contact.postalAddresses.add(new Contact.PostalAddressItem(cursor));
                    break;
                case 5:
                    String string6 = cursor.getString(cursor.getColumnIndex("data1"));
                    int i7 = cursor.getInt(cursor.getColumnIndex("data2"));
                    if (!TextUtils.isEmpty(string6)) {
                        switch (i7) {
                            case 0:
                                lowerCase2 = cursor.getString(cursor.getColumnIndex("data3")) == null ? "" : cursor.getString(cursor.getColumnIndex("data3")).toLowerCase();
                                break;
                            case 1:
                                lowerCase2 = "homepage";
                                break;
                            case 2:
                                lowerCase2 = "blog";
                                break;
                            case 3:
                                lowerCase2 = Scopes.PROFILE;
                                break;
                            case 4:
                                lowerCase2 = "home";
                                break;
                            case 5:
                                break;
                            case 6:
                                lowerCase2 = "ftp";
                                break;
                            default:
                                lowerCase2 = "other";
                                break;
                        }
                        contact.urls.add(new Contact.Item(lowerCase2, string6, strValueOf2));
                    }
                    break;
                case 6:
                    String string7 = cursor.getString(cursor.getColumnIndex("data1"));
                    int i8 = cursor.getInt(cursor.getColumnIndex("data2"));
                    if (!TextUtils.isEmpty(string7)) {
                        if (i8 == 1) {
                            lowerCase = "home";
                        } else if (i8 != 2) {
                            lowerCase = i8 != 3 ? "other" : "work";
                        }
                        contact.phones.add(new Contact.Item(lowerCase, string7, strValueOf2));
                    }
                    break;
                case 7:
                    contact.company = cursor.getString(cursor.getColumnIndex("data1"));
                    contact.jobTitle = cursor.getString(cursor.getColumnIndex("data4"));
                    contact.department = cursor.getString(cursor.getColumnIndex("data5"));
                    break;
                case 8:
                    String string8 = cursor.getString(cursor.getColumnIndex("data1"));
                    int i9 = cursor.getInt(cursor.getColumnIndex("data5"));
                    if (!TextUtils.isEmpty(string8)) {
                        switch (i9) {
                            case -1:
                                if (cursor.getString(cursor.getColumnIndex("data6")) != null) {
                                    string4 = cursor.getString(cursor.getColumnIndex("data6"));
                                    str = string4;
                                }
                                break;
                            case 0:
                                string4 = "AIM";
                                str = string4;
                                break;
                            case 1:
                                string4 = "MSN";
                                str = string4;
                                break;
                            case 2:
                                string4 = "Yahoo";
                                str = string4;
                                break;
                            case 3:
                                string4 = "Skype";
                                str = string4;
                                break;
                            case 4:
                                string4 = "QQ";
                                str = string4;
                                break;
                            case 5:
                                string4 = "Google Talk";
                                str = string4;
                                break;
                            case 6:
                                string4 = "ICQ";
                                str = string4;
                                break;
                            case 7:
                                string4 = "Jabber";
                                str = string4;
                                break;
                            case 8:
                                string4 = "NetMeeting";
                                str = string4;
                                break;
                            default:
                                str = string4;
                                break;
                        }
                        contact.instantMessengers.add(new Contact.Item(str, string8, strValueOf2));
                    }
                    break;
            }
        }
        return linkedHashMap;
    }

    public String getPhotoUriFromContactId(String str) {
        ContentResolver contentResolver = this.contentResolver;
        Uri uri = ContactsContract.Data.CONTENT_URI;
        List<String> list = PHOTO_PROJECTION;
        Cursor cursorQuery = contentResolver.query(uri, (String[]) list.toArray(new String[list.size()]), "contact_id = ?", new String[]{str}, null);
        if (cursorQuery != null) {
            try {
                if (cursorMoveToNext(cursorQuery).booleanValue()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("photo_uri"));
                    if (!TextUtils.isEmpty(string)) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return string;
                    }
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
    }

    private static class Contact {
        private Birthday birthday;
        private String contactId;
        private String displayName;
        private String photoUri;
        private String rawContactId;
        private String givenName = "";
        private String middleName = "";
        private String familyName = "";
        private String prefix = "";
        private String suffix = "";
        private String company = "";
        private String jobTitle = "";
        private String department = "";
        private String note = "";
        private List<Item> urls = new ArrayList();
        private List<Item> instantMessengers = new ArrayList();
        private boolean hasPhoto = false;
        private boolean isStarred = false;
        private List<Item> emails = new ArrayList();
        private List<Item> phones = new ArrayList();
        private List<PostalAddressItem> postalAddresses = new ArrayList();

        public Contact(String str) {
            this.contactId = str;
        }

        public WritableMap toMap() {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("recordID", this.contactId);
            writableMapCreateMap.putString("rawContactId", this.rawContactId);
            writableMapCreateMap.putString("givenName", TextUtils.isEmpty(this.givenName) ? this.displayName : this.givenName);
            writableMapCreateMap.putString("displayName", this.displayName);
            writableMapCreateMap.putString("middleName", this.middleName);
            writableMapCreateMap.putString("familyName", this.familyName);
            writableMapCreateMap.putString("prefix", this.prefix);
            writableMapCreateMap.putString("suffix", this.suffix);
            writableMapCreateMap.putString("company", this.company);
            writableMapCreateMap.putString("jobTitle", this.jobTitle);
            writableMapCreateMap.putString("department", this.department);
            writableMapCreateMap.putString("note", this.note);
            writableMapCreateMap.putBoolean("hasThumbnail", this.hasPhoto);
            String str = this.photoUri;
            if (str == null) {
                str = "";
            }
            writableMapCreateMap.putString("thumbnailPath", str);
            writableMapCreateMap.putBoolean("isStarred", this.isStarred);
            WritableArray writableArrayCreateArray = Arguments.createArray();
            for (Item item : this.phones) {
                WritableMap writableMapCreateMap2 = Arguments.createMap();
                writableMapCreateMap2.putString("number", item.value);
                writableMapCreateMap2.putString(com.google.firebase.messaging.Constants.ScionAnalytics.PARAM_LABEL, item.label);
                writableMapCreateMap2.putString("id", item.id);
                writableArrayCreateArray.pushMap(writableMapCreateMap2);
            }
            writableMapCreateMap.putArray("phoneNumbers", writableArrayCreateArray);
            WritableArray writableArrayCreateArray2 = Arguments.createArray();
            for (Item item2 : this.urls) {
                WritableMap writableMapCreateMap3 = Arguments.createMap();
                writableMapCreateMap3.putString(ImagesContract.URL, item2.value);
                writableMapCreateMap3.putString("id", item2.id);
                writableArrayCreateArray2.pushMap(writableMapCreateMap3);
            }
            writableMapCreateMap.putArray("urlAddresses", writableArrayCreateArray2);
            WritableArray writableArrayCreateArray3 = Arguments.createArray();
            for (Item item3 : this.instantMessengers) {
                WritableMap writableMapCreateMap4 = Arguments.createMap();
                writableMapCreateMap4.putString(HintConstants.AUTOFILL_HINT_USERNAME, item3.value);
                writableMapCreateMap4.putString(NotificationCompat.CATEGORY_SERVICE, item3.label);
                writableArrayCreateArray3.pushMap(writableMapCreateMap4);
            }
            writableMapCreateMap.putArray("imAddresses", writableArrayCreateArray3);
            WritableArray writableArrayCreateArray4 = Arguments.createArray();
            for (Item item4 : this.emails) {
                WritableMap writableMapCreateMap5 = Arguments.createMap();
                writableMapCreateMap5.putString("email", item4.value);
                writableMapCreateMap5.putString(com.google.firebase.messaging.Constants.ScionAnalytics.PARAM_LABEL, item4.label);
                writableMapCreateMap5.putString("id", item4.id);
                writableArrayCreateArray4.pushMap(writableMapCreateMap5);
            }
            writableMapCreateMap.putArray("emailAddresses", writableArrayCreateArray4);
            WritableArray writableArrayCreateArray5 = Arguments.createArray();
            Iterator<PostalAddressItem> it2 = this.postalAddresses.iterator();
            while (it2.hasNext()) {
                writableArrayCreateArray5.pushMap(it2.next().map);
            }
            writableMapCreateMap.putArray("postalAddresses", writableArrayCreateArray5);
            WritableMap writableMapCreateMap6 = Arguments.createMap();
            Birthday birthday = this.birthday;
            if (birthday != null) {
                if (birthday.year > 0) {
                    writableMapCreateMap6.putInt("year", this.birthday.year);
                }
                writableMapCreateMap6.putInt("month", this.birthday.month);
                writableMapCreateMap6.putInt(WeatherCriteria.UNIT_TYPE_DAY, this.birthday.day);
                writableMapCreateMap.putMap("birthday", writableMapCreateMap6);
            }
            return writableMapCreateMap;
        }

        public static class Item {
            public String id;
            public String label;
            public String value;

            public Item(String str, String str2, String str3) {
                this.id = str3;
                this.label = str;
                this.value = str2;
            }

            public Item(String str, String str2) {
                this.label = str;
                this.value = str2;
            }
        }

        public static class Birthday {
            public int day;
            public int month;
            public int year;

            public Birthday(int i, int i2, int i3) {
                this.year = i;
                this.month = i2;
                this.day = i3;
            }

            public Birthday(int i, int i2) {
                this.year = 0;
                this.month = i;
                this.day = i2;
            }
        }

        public static class PostalAddressItem {
            public final WritableMap map;

            public PostalAddressItem(Cursor cursor) {
                WritableMap writableMapCreateMap = Arguments.createMap();
                this.map = writableMapCreateMap;
                writableMapCreateMap.putString(com.google.firebase.messaging.Constants.ScionAnalytics.PARAM_LABEL, getLabel(cursor));
                putString(cursor, "formattedAddress", "data1");
                putString(cursor, GeoCodingCriteria.POD_STREET, "data4");
                putString(cursor, "pobox", "data5");
                putString(cursor, PlaceTypes.NEIGHBORHOOD, "data6");
                putString(cursor, GeoCodingCriteria.POD_CITY, "data7");
                putString(cursor, "region", "data8");
                putString(cursor, "state", "data8");
                putString(cursor, "postCode", "data9");
                putString(cursor, PlaceTypes.COUNTRY, "data10");
            }

            private void putString(Cursor cursor, String str, String str2) {
                String string = cursor.getString(cursor.getColumnIndex(str2));
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                this.map.putString(str, string);
            }

            static String getLabel(Cursor cursor) {
                int i = cursor.getInt(cursor.getColumnIndex("data2"));
                if (i == 0) {
                    String string = cursor.getString(cursor.getColumnIndex("data3"));
                    return string != null ? string : "";
                }
                if (i == 1) {
                    return "home";
                }
                if (i == 2) {
                    return "work";
                }
                return "other";
            }
        }
    }
}
