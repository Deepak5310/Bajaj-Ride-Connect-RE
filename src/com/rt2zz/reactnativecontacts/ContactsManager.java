package com.rt2zz.reactnativecontacts;

import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.ContactsContract;
import androidx.autofill.HintConstants;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.firebase.messaging.Constants;
import com.mappls.sdk.services.api.geocoding.GeoCodingCriteria;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes4.dex */
public class ContactsManager extends ReactContextBaseJavaModule implements ActivityEventListener {
    private static final String PERMISSION_AUTHORIZED = "authorized";
    private static final String PERMISSION_DENIED = "denied";
    private static final String PERMISSION_READ_CONTACTS = "android.permission.READ_CONTACTS";
    private static final int PERMISSION_REQUEST_CODE = 888;
    private static final int REQUEST_OPEN_CONTACT_FORM = 52941;
    private static final int REQUEST_OPEN_EXISTING_CONTACT = 52942;
    private static Promise requestPromise;
    private static Promise updateContactPromise;

    @ReactMethod
    public void iosEnableNotesUsage(boolean z) {
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onNewIntent(Intent intent) {
    }

    public ContactsManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(this);
    }

    @ReactMethod
    public void getAll(Promise promise) {
        getAllContacts(promise);
    }

    @ReactMethod
    public void getAllWithoutPhotos(Promise promise) {
        getAllContacts(promise);
    }

    private void getAllContacts(final Promise promise) {
        new AsyncTask<Void, Void, Void>() { // from class: com.rt2zz.reactnativecontacts.ContactsManager.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Void doInBackground(Void... voidArr) {
                promise.resolve(new ContactsProvider(ContactsManager.this.getReactApplicationContext().getContentResolver()).getContacts());
                return null;
            }
        }.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void getCount(final Promise promise) {
        new AsyncTask<Void, Void, Void>() { // from class: com.rt2zz.reactnativecontacts.ContactsManager.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Void doInBackground(Void... voidArr) {
                try {
                    promise.resolve(new ContactsProvider(ContactsManager.this.getReactApplicationContext().getContentResolver()).getContactsCount());
                    return null;
                } catch (Exception e) {
                    promise.reject(e);
                    return null;
                }
            }
        }.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void getContactsMatchingString(final String str, final Promise promise) {
        new AsyncTask<Void, Void, Void>() { // from class: com.rt2zz.reactnativecontacts.ContactsManager.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Void doInBackground(Void... voidArr) {
                promise.resolve(new ContactsProvider(ContactsManager.this.getReactApplicationContext().getContentResolver()).getContactsMatchingString(str));
                return null;
            }
        }.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void getContactsByPhoneNumber(final String str, final Promise promise) {
        new AsyncTask<Void, Void, Void>() { // from class: com.rt2zz.reactnativecontacts.ContactsManager.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Void doInBackground(Void... voidArr) {
                promise.resolve(new ContactsProvider(ContactsManager.this.getReactApplicationContext().getContentResolver()).getContactsByPhoneNumber(str));
                return null;
            }
        }.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void getContactsByEmailAddress(final String str, final Promise promise) {
        new AsyncTask<Void, Void, Void>() { // from class: com.rt2zz.reactnativecontacts.ContactsManager.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Void doInBackground(Void... voidArr) {
                promise.resolve(new ContactsProvider(ContactsManager.this.getReactApplicationContext().getContentResolver()).getContactsByEmailAddress(str));
                return null;
            }
        }.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void getPhotoForId(final String str, final Promise promise) {
        new AsyncTask<Void, Void, Void>() { // from class: com.rt2zz.reactnativecontacts.ContactsManager.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Void doInBackground(Void... voidArr) {
                promise.resolve(new ContactsProvider(ContactsManager.this.getReactApplicationContext().getContentResolver()).getPhotoUriFromContactId(str));
                return null;
            }
        }.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void getContactById(final String str, final Promise promise) {
        new AsyncTask<Void, Void, Void>() { // from class: com.rt2zz.reactnativecontacts.ContactsManager.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Void doInBackground(Void... voidArr) {
                promise.resolve(new ContactsProvider(ContactsManager.this.getReactApplicationContext().getContentResolver()).getContactById(str));
                return null;
            }
        }.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void writePhotoToPath(final String str, final String str2, final Promise promise) {
        new AsyncTask<Void, Void, Void>() { // from class: com.rt2zz.reactnativecontacts.ContactsManager.8
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v2 */
            /* JADX WARN: Type inference failed for: r0v3, types: [java.io.OutputStream] */
            /* JADX WARN: Type inference failed for: r0v5 */
            /* JADX WARN: Type inference failed for: r1v1, types: [long] */
            /* JADX WARN: Type inference failed for: r1v10 */
            /* JADX WARN: Type inference failed for: r1v3 */
            /* JADX WARN: Type inference failed for: r1v4 */
            /* JADX WARN: Type inference failed for: r1v8 */
            /* JADX WARN: Type inference failed for: r1v9 */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x004f -> B:30:0x0052). Please report as a decompilation issue!!! */
            @Override // android.os.AsyncTask
            public Void doInBackground(Void... voidArr) throws Throwable {
                Throwable th;
                FileOutputStream fileOutputStream;
                ContentResolver contentResolver = ContactsManager.this.getReactApplicationContext().getContentResolver();
                Uri uri = ContactsContract.Contacts.CONTENT_URI;
                ?? r1 = Long.parseLong(str);
                InputStream inputStreamOpenContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, ContentUris.withAppendedId(uri, r1));
                ?? r0 = 0;
                try {
                    try {
                        try {
                            fileOutputStream = new FileOutputStream(str2);
                            try {
                                BitmapFactory.decodeStream(inputStreamOpenContactPhotoInputStream).compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                                promise.resolve(true);
                                fileOutputStream.close();
                                r1 = fileOutputStream;
                            } catch (FileNotFoundException e) {
                                e = e;
                                promise.reject(e.toString());
                                fileOutputStream.close();
                                r1 = fileOutputStream;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            r0 = r1;
                            try {
                                r0.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        fileOutputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        r0.close();
                        throw th;
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                    r1 = e4;
                }
                try {
                    inputStreamOpenContactPhotoInputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                return null;
            }
        }.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    private Bitmap getThumbnailBitmap(String str) {
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
        if (bitmapDecodeFile != null) {
            return bitmapDecodeFile;
        }
        try {
            InputStream inputStreamOpen = getReactApplicationContext().getAssets().open(str);
            bitmapDecodeFile = BitmapFactory.decodeStream(inputStreamOpen);
            inputStreamOpen.close();
            return bitmapDecodeFile;
        } catch (IOException e) {
            e.printStackTrace();
            return bitmapDecodeFile;
        }
    }

    @ReactMethod
    public void openContactForm(ReadableMap readableMap, Promise promise) {
        String str;
        int size;
        String[] strArr;
        Integer[] numArr;
        String[] strArr2;
        int size2;
        String[] strArr3;
        String[] strArr4;
        int size3;
        Integer[] numArr2;
        String[] strArr5;
        String str2;
        int size4;
        Integer[] numArr3;
        String[] strArr6;
        String[] strArr7;
        String[] strArr8;
        String[] strArr9;
        String[] strArr10;
        String[] strArr11;
        String[] strArr12;
        int size5;
        String[] strArr13;
        String[] strArr14;
        String str3;
        String string = readableMap.hasKey("givenName") ? readableMap.getString("givenName") : null;
        String string2 = readableMap.hasKey("middleName") ? readableMap.getString("middleName") : null;
        String string3 = readableMap.hasKey("displayName") ? readableMap.getString("displayName") : null;
        String string4 = readableMap.hasKey("familyName") ? readableMap.getString("familyName") : null;
        String string5 = readableMap.hasKey("prefix") ? readableMap.getString("prefix") : null;
        String string6 = readableMap.hasKey("suffix") ? readableMap.getString("suffix") : null;
        String string7 = readableMap.hasKey("company") ? readableMap.getString("company") : null;
        String string8 = readableMap.hasKey("jobTitle") ? readableMap.getString("jobTitle") : null;
        String string9 = readableMap.hasKey("department") ? readableMap.getString("department") : null;
        String string10 = readableMap.hasKey("note") ? readableMap.getString("note") : null;
        String string11 = readableMap.hasKey("thumbnailPath") ? readableMap.getString("thumbnailPath") : null;
        ReadableArray array = readableMap.hasKey("phoneNumbers") ? readableMap.getArray("phoneNumbers") : null;
        if (array != null) {
            size = array.size();
            strArr = new String[size];
            strArr2 = new String[size];
            numArr = new Integer[size];
            int i = 0;
            while (true) {
                int i2 = size;
                if (i >= size) {
                    break;
                }
                strArr[i] = array.getMap(i).getString("number");
                String string12 = array.getMap(i).getString(Constants.ScionAnalytics.PARAM_LABEL);
                strArr2[i] = string12;
                numArr[i] = Integer.valueOf(mapStringToPhoneType(string12));
                i++;
                size = i2;
                string8 = string8;
            }
            str = string8;
        } else {
            str = string8;
            size = 0;
            strArr = null;
            numArr = null;
            strArr2 = null;
        }
        ReadableArray array2 = readableMap.hasKey("urlAddresses") ? readableMap.getArray("urlAddresses") : null;
        if (array2 != null) {
            size2 = array2.size();
            strArr3 = new String[size2];
            int i3 = 0;
            while (true) {
                int i4 = size2;
                if (i3 >= size2) {
                    break;
                }
                strArr3[i3] = array2.getMap(i3).getString(ImagesContract.URL);
                i3++;
                size2 = i4;
                array2 = array2;
            }
        } else {
            size2 = 0;
            strArr3 = null;
        }
        ReadableArray array3 = readableMap.hasKey("emailAddresses") ? readableMap.getArray("emailAddresses") : null;
        if (array3 != null) {
            size3 = array3.size();
            strArr5 = new String[size3];
            numArr2 = new Integer[size3];
            int i5 = 0;
            while (true) {
                int i6 = size3;
                if (i5 >= size3) {
                    break;
                }
                strArr5[i5] = array3.getMap(i5).getString("email");
                numArr2[i5] = Integer.valueOf(mapStringToEmailType(array3.getMap(i5).getString(Constants.ScionAnalytics.PARAM_LABEL)));
                i5++;
                size3 = i6;
                strArr3 = strArr3;
            }
            strArr4 = strArr3;
        } else {
            strArr4 = strArr3;
            size3 = 0;
            numArr2 = null;
            strArr5 = null;
        }
        ReadableArray array4 = readableMap.hasKey("postalAddresses") ? readableMap.getArray("postalAddresses") : null;
        if (array4 != null) {
            size4 = array4.size();
            strArr12 = new String[size4];
            strArr11 = new String[size4];
            String[] strArr15 = new String[size4];
            strArr9 = new String[size4];
            strArr10 = new String[size4];
            strArr8 = new String[size4];
            strArr7 = new String[size4];
            strArr6 = new String[size4];
            numArr3 = new Integer[size4];
            int i7 = 0;
            while (i7 < size4) {
                strArr12[i7] = array4.getMap(i7).getString(GeoCodingCriteria.POD_STREET);
                strArr11[i7] = array4.getMap(i7).getString(GeoCodingCriteria.POD_CITY);
                strArr15[i7] = array4.getMap(i7).getString("state");
                strArr9[i7] = array4.getMap(i7).getString("region");
                strArr10[i7] = array4.getMap(i7).getString("postCode");
                strArr8[i7] = array4.getMap(i7).getString(PlaceTypes.COUNTRY);
                strArr7[i7] = array4.getMap(i7).getString("formattedAddress");
                strArr6[i7] = array4.getMap(i7).getString(Constants.ScionAnalytics.PARAM_LABEL);
                numArr3[i7] = Integer.valueOf(mapStringToPostalAddressType(array4.getMap(i7).getString(Constants.ScionAnalytics.PARAM_LABEL)));
                i7++;
                size4 = size4;
                string = string;
            }
            str2 = string;
        } else {
            str2 = string;
            size4 = 0;
            numArr3 = null;
            strArr6 = null;
            strArr7 = null;
            strArr8 = null;
            strArr9 = null;
            strArr10 = null;
            strArr11 = null;
            strArr12 = null;
        }
        ReadableArray array5 = readableMap.hasKey("imAddresses") ? readableMap.getArray("imAddresses") : null;
        if (array5 != null) {
            size5 = array5.size();
            strArr13 = new String[size5];
            String[] strArr16 = new String[size5];
            int i8 = 0;
            while (i8 < size5) {
                strArr13[i8] = array5.getMap(i8).getString(HintConstants.AUTOFILL_HINT_USERNAME);
                strArr16[i8] = array5.getMap(i8).getString(NotificationCompat.CATEGORY_SERVICE);
                i8++;
                size5 = size5;
            }
            strArr14 = strArr16;
        } else {
            size5 = 0;
            strArr13 = null;
            strArr14 = null;
        }
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/identity");
        contentValues.put("data2", str2);
        String[] strArr17 = strArr13;
        contentValues.put("data3", string4);
        String str4 = "data5";
        int i9 = size5;
        contentValues.put("data5", string2);
        String str5 = "data4";
        Integer[] numArr4 = numArr3;
        contentValues.put("data4", string5);
        String[] strArr18 = strArr6;
        contentValues.put("data6", string6);
        arrayList.add(contentValues);
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("mimetype", "vnd.android.cursor.item/organization");
        contentValues2.put("data1", string7);
        contentValues2.put("data4", str);
        contentValues2.put("data5", string9);
        arrayList.add(contentValues2);
        int i10 = 0;
        while (true) {
            int i11 = size2;
            if (i10 >= i11) {
                break;
            }
            size2 = i11;
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("mimetype", "vnd.android.cursor.item/website");
            contentValues3.put("data1", strArr4[i10]);
            arrayList.add(contentValues3);
            i10++;
            str4 = str4;
        }
        String str6 = str4;
        int i12 = 0;
        while (true) {
            int i13 = size3;
            if (i12 >= i13) {
                break;
            }
            ContentValues contentValues4 = new ContentValues();
            size3 = i13;
            contentValues4.put("mimetype", "vnd.android.cursor.item/email_v2");
            contentValues4.put("data2", numArr2[i12]);
            contentValues4.put("data1", strArr5[i12]);
            arrayList.add(contentValues4);
            i12++;
        }
        int i14 = 0;
        while (true) {
            int i15 = size;
            if (i14 >= i15) {
                break;
            }
            ContentValues contentValues5 = new ContentValues();
            size = i15;
            contentValues5.put("mimetype", "vnd.android.cursor.item/phone_v2");
            contentValues5.put("data2", numArr[i14]);
            contentValues5.put("data3", strArr2[i14]);
            contentValues5.put("data1", strArr[i14]);
            arrayList.add(contentValues5);
            i14++;
        }
        int i16 = 0;
        while (i16 < size4) {
            ContentValues contentValues6 = new ContentValues();
            contentValues6.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
            contentValues6.put(str5, strArr12[i16]);
            contentValues6.put("data7", strArr11[i16]);
            contentValues6.put("data8", strArr9[i16]);
            contentValues6.put("data10", strArr8[i16]);
            contentValues6.put("data9", strArr10[i16]);
            contentValues6.put("data1", strArr7[i16]);
            contentValues6.put("data3", strArr18[i16]);
            contentValues6.put("data2", numArr4[i16]);
            arrayList.add(contentValues6);
            i16++;
            str5 = str5;
        }
        int i17 = 0;
        while (true) {
            int i18 = i9;
            if (i17 >= i18) {
                break;
            }
            ContentValues contentValues7 = new ContentValues();
            contentValues7.put("mimetype", "vnd.android.cursor.item/im");
            contentValues7.put("data1", strArr17[i17]);
            contentValues7.put("data2", (Integer) 1);
            contentValues7.put(str6, (Integer) (-1));
            contentValues7.put("data6", strArr14[i17]);
            arrayList.add(contentValues7);
            i17++;
            i9 = i18;
        }
        if (string10 != 0) {
            ContentValues contentValues8 = new ContentValues();
            contentValues8.put("mimetype", "vnd.android.cursor.item/note");
            contentValues8.put("data1", string10);
            arrayList.add(contentValues8);
        }
        if (string11 != 0 && !string11.isEmpty()) {
            Bitmap thumbnailBitmap = getThumbnailBitmap(str3);
            if (thumbnailBitmap != null) {
                str3 = string11;
                ContentValues contentValues9 = new ContentValues();
                contentValues9.put("raw_contact_id", (Integer) 0);
                contentValues9.put("is_super_primary", (Integer) 1);
                contentValues9.put("data15", toByteArray(thumbnailBitmap));
                contentValues9.put("mimetype", "vnd.android.cursor.item/photo");
                arrayList.add(contentValues9);
            }
        }
        str3 = string11;
        Intent intent = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
        intent.putExtra("name", string3);
        intent.putExtra("finishActivityOnSaveCompleted", true);
        intent.putParcelableArrayListExtra("data", arrayList);
        updateContactPromise = promise;
        getReactApplicationContext().startActivityForResult(intent, REQUEST_OPEN_CONTACT_FORM, Bundle.EMPTY);
    }

    @ReactMethod
    public void openExistingContact(ReadableMap readableMap, Promise promise) {
        try {
            Uri uriWithAppendedPath = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, readableMap.hasKey("recordID") ? readableMap.getString("recordID") : null);
            Intent intent = new Intent("android.intent.action.EDIT");
            intent.setDataAndType(uriWithAppendedPath, "vnd.android.cursor.item/contact");
            intent.putExtra("finishActivityOnSaveCompleted", true);
            updateContactPromise = promise;
            getReactApplicationContext().startActivityForResult(intent, REQUEST_OPEN_EXISTING_CONTACT, Bundle.EMPTY);
        } catch (Exception e) {
            promise.reject(e.toString());
        }
    }

    @ReactMethod
    public void viewExistingContact(ReadableMap readableMap, Promise promise) {
        try {
            Uri uriWithAppendedPath = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, readableMap.hasKey("recordID") ? readableMap.getString("recordID") : null);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(uriWithAppendedPath, "vnd.android.cursor.item/contact");
            intent.putExtra("finishActivityOnSaveCompleted", true);
            updateContactPromise = promise;
            getReactApplicationContext().startActivityForResult(intent, REQUEST_OPEN_EXISTING_CONTACT, Bundle.EMPTY);
        } catch (Exception e) {
            promise.reject(e.toString());
        }
    }

    @ReactMethod
    public void editExistingContact(ReadableMap readableMap, Promise promise) {
        int size;
        Integer[] numArr;
        String[] strArr = null;
        try {
            Uri uriWithAppendedPath = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, readableMap.hasKey("recordID") ? readableMap.getString("recordID") : null);
            ReadableArray array = readableMap.hasKey("phoneNumbers") ? readableMap.getArray("phoneNumbers") : null;
            if (array != null) {
                size = array.size();
                strArr = new String[size];
                numArr = new Integer[size];
                for (int i = 0; i < size; i++) {
                    strArr[i] = array.getMap(i).getString("number");
                    numArr[i] = Integer.valueOf(mapStringToPhoneType(array.getMap(i).getString(Constants.ScionAnalytics.PARAM_LABEL)));
                }
            } else {
                size = 0;
                numArr = null;
            }
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < size; i2++) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
                contentValues.put("data2", numArr[i2]);
                contentValues.put("data1", strArr[i2]);
                arrayList.add(contentValues);
            }
            Intent intent = new Intent("android.intent.action.EDIT");
            intent.setDataAndType(uriWithAppendedPath, "vnd.android.cursor.item/contact");
            intent.putExtra("finishActivityOnSaveCompleted", true);
            intent.putParcelableArrayListExtra("data", arrayList);
            updateContactPromise = promise;
            getReactApplicationContext().startActivityForResult(intent, REQUEST_OPEN_EXISTING_CONTACT, Bundle.EMPTY);
        } catch (Exception e) {
            promise.reject(e.toString());
        }
    }

    @ReactMethod
    public void addContact(ReadableMap readableMap, Promise promise) {
        String str;
        String[] strArr;
        int size;
        String[] strArr2;
        Integer[] numArr;
        int i;
        String[] strArr3;
        int i2;
        int i3;
        Integer[] numArr2;
        String[] strArr4;
        String[] strArr5;
        int size2;
        String[] strArr6;
        String[] strArr7;
        ContactsManager contactsManager;
        Promise promise2;
        String str2;
        int i4;
        if (readableMap == null) {
            promise.reject("New contact cannot be null.");
            return;
        }
        String string = readableMap.hasKey("givenName") ? readableMap.getString("givenName") : null;
        String string2 = readableMap.hasKey("middleName") ? readableMap.getString("middleName") : null;
        String string3 = readableMap.hasKey("familyName") ? readableMap.getString("familyName") : null;
        String string4 = readableMap.hasKey("prefix") ? readableMap.getString("prefix") : null;
        String string5 = readableMap.hasKey("suffix") ? readableMap.getString("suffix") : null;
        String string6 = readableMap.hasKey("company") ? readableMap.getString("company") : null;
        String string7 = readableMap.hasKey("jobTitle") ? readableMap.getString("jobTitle") : null;
        String string8 = readableMap.hasKey("department") ? readableMap.getString("department") : null;
        String string9 = readableMap.hasKey("note") ? readableMap.getString("note") : null;
        String string10 = readableMap.hasKey("thumbnailPath") ? readableMap.getString("thumbnailPath") : null;
        ReadableArray array = readableMap.hasKey("phoneNumbers") ? readableMap.getArray("phoneNumbers") : null;
        if (array != null) {
            size = array.size();
            strArr = new String[size];
            numArr = new Integer[size];
            strArr2 = new String[size];
            int i5 = 0;
            while (true) {
                int i6 = size;
                if (i5 >= size) {
                    break;
                }
                strArr[i5] = array.getMap(i5).getString("number");
                String string11 = array.getMap(i5).getString(Constants.ScionAnalytics.PARAM_LABEL);
                numArr[i5] = Integer.valueOf(mapStringToPhoneType(string11));
                strArr2[i5] = string11;
                i5++;
                size = i6;
                string6 = string6;
            }
            str = string6;
        } else {
            str = string6;
            strArr = null;
            size = 0;
            strArr2 = null;
            numArr = null;
        }
        ReadableArray array2 = readableMap.hasKey("urlAddresses") ? readableMap.getArray("urlAddresses") : null;
        if (array2 != null) {
            int size3 = array2.size();
            strArr3 = new String[size3];
            int i7 = 0;
            while (true) {
                i4 = size3;
                if (i7 >= size3) {
                    break;
                }
                strArr3[i7] = array2.getMap(i7).getString(ImagesContract.URL);
                i7++;
                size3 = i4;
                array2 = array2;
            }
            i = i4;
        } else {
            i = 0;
            strArr3 = null;
        }
        ReadableArray array3 = readableMap.hasKey("emailAddresses") ? readableMap.getArray("emailAddresses") : null;
        if (array3 != null) {
            int size4 = array3.size();
            strArr5 = new String[size4];
            numArr2 = new Integer[size4];
            strArr4 = new String[size4];
            int i8 = 0;
            while (i8 < size4) {
                int i9 = size;
                strArr5[i8] = array3.getMap(i8).getString("email");
                String string12 = array3.getMap(i8).getString(Constants.ScionAnalytics.PARAM_LABEL);
                numArr2[i8] = Integer.valueOf(mapStringToEmailType(string12));
                strArr4[i8] = string12;
                i8++;
                size4 = size4;
                size = i9;
            }
            i2 = size;
            i3 = size4;
        } else {
            i2 = size;
            i3 = 0;
            numArr2 = null;
            strArr4 = null;
            strArr5 = null;
        }
        ReadableArray array4 = readableMap.hasKey("imAddresses") ? readableMap.getArray("imAddresses") : null;
        if (array4 != null) {
            size2 = array4.size();
            strArr6 = new String[size2];
            strArr7 = new String[size2];
            int i10 = 0;
            while (true) {
                int i11 = size2;
                if (i10 >= size2) {
                    break;
                }
                strArr6[i10] = array4.getMap(i10).getString(HintConstants.AUTOFILL_HINT_USERNAME);
                strArr7[i10] = array4.getMap(i10).getString(NotificationCompat.CATEGORY_SERVICE);
                i10++;
                size2 = i11;
            }
        } else {
            size2 = 0;
            strArr6 = null;
            strArr7 = null;
        }
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        String[] strArr8 = strArr7;
        arrayList.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI).withValue("account_type", null).withValue("account_name", null).build());
        String[] strArr9 = strArr6;
        arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/name").withValue("data2", string).withValue("data5", string2).withValue("data3", string3).withValue("data4", string4).withValue("data6", string5).build());
        arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/note").withValue("data1", string9).build());
        ContentProviderOperation.Builder builderWithValue = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/organization").withValue("data1", str).withValue("data4", string7).withValue("data5", string8);
        arrayList.add(builderWithValue.build());
        builderWithValue.withYieldAllowed(true);
        int i12 = 0;
        for (int i13 = i2; i12 < i13; i13 = i13) {
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/phone_v2").withValue("data1", strArr[i12]).withValue("data2", numArr[i12]).withValue("data3", strArr2[i12]).build());
            i12++;
        }
        int i14 = 0;
        for (int i15 = i; i14 < i15; i15 = i15) {
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/website").withValue("data1", strArr3[i14]).build());
            i14++;
        }
        for (int i16 = 0; i16 < i3; i16++) {
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/email_v2").withValue("data1", strArr5[i16]).withValue("data2", numArr2[i16]).withValue("data3", strArr4[i16]).build());
        }
        if (string10 == 0 || string10.isEmpty()) {
            contactsManager = this;
        } else {
            contactsManager = this;
            Bitmap thumbnailBitmap = contactsManager.getThumbnailBitmap(str2);
            if (thumbnailBitmap != null) {
                str2 = string10;
                arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/photo").withValue("data15", contactsManager.toByteArray(thumbnailBitmap)).build());
            }
        }
        str2 = string10;
        ReadableArray array5 = readableMap.hasKey("postalAddresses") ? readableMap.getArray("postalAddresses") : null;
        if (array5 != null) {
            int i17 = 0;
            while (i17 < array5.size()) {
                ReadableMap map = array5.getMap(i17);
                arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/postal-address_v2").withValue("data2", Integer.valueOf(contactsManager.mapStringToPostalAddressType(map.getString(Constants.ScionAnalytics.PARAM_LABEL)))).withValue("data3", map.getString(Constants.ScionAnalytics.PARAM_LABEL)).withValue("data4", map.getString(GeoCodingCriteria.POD_STREET)).withValue("data7", map.getString(GeoCodingCriteria.POD_CITY)).withValue("data8", map.getString("state")).withValue("data9", map.getString("postCode")).withValue("data10", map.getString(PlaceTypes.COUNTRY)).build());
                i17++;
                contactsManager = this;
            }
        }
        for (int i18 = 0; i18 < size2; i18++) {
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/im").withValue("data1", strArr9[i18]).withValue("data2", 1).withValue("data5", -1).withValue("data6", strArr8[i18]).build());
        }
        try {
            ContentResolver contentResolver = getReactApplicationContext().getContentResolver();
            ContentProviderResult[] contentProviderResultArrApplyBatch = contentResolver.applyBatch("com.android.contacts", arrayList);
            if (contentProviderResultArrApplyBatch == null || contentProviderResultArrApplyBatch.length <= 0) {
                return;
            }
            WritableMap contactByRawId = new ContactsProvider(contentResolver).getContactByRawId(String.valueOf(ContentUris.parseId(contentProviderResultArrApplyBatch[0].uri)));
            promise2 = promise;
            try {
                promise2.resolve(contactByRawId);
                return;
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
            promise2 = promise;
        }
        promise2.reject(e.toString());
    }

    public byte[] toByteArray(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @ReactMethod
    public void updateContact(ReadableMap readableMap, Promise promise) {
        ReadableArray readableArray;
        String str;
        String[] strArr;
        String[] strArr2;
        Integer[] numArr;
        int size;
        int size2;
        Object[] objArr;
        String[] strArr3;
        ReadableArray readableArray2;
        Integer[] numArr2;
        String[] strArr4;
        int size3;
        String[] strArr5;
        String str2;
        int size4;
        String[] strArr6;
        Integer[] numArr3;
        String[] strArr7;
        String[] strArr8;
        String[] strArr9;
        String[] strArr10;
        String[] strArr11;
        ReadableArray readableArray3;
        int size5;
        String[] strArr12;
        String[] strArr13;
        int i;
        Promise promise2;
        Bitmap thumbnailBitmap;
        ContentProviderOperation.Builder builderWithValue;
        String string = readableMap.hasKey("recordID") ? readableMap.getString("recordID") : null;
        String string2 = readableMap.hasKey("rawContactId") ? readableMap.getString("rawContactId") : null;
        if (string2 == null || string == null) {
            promise.reject("Invalid recordId or rawContactId");
            return;
        }
        String string3 = readableMap.hasKey("givenName") ? readableMap.getString("givenName") : null;
        String string4 = readableMap.hasKey("middleName") ? readableMap.getString("middleName") : null;
        String string5 = readableMap.hasKey("familyName") ? readableMap.getString("familyName") : null;
        String string6 = readableMap.hasKey("prefix") ? readableMap.getString("prefix") : null;
        String string7 = readableMap.hasKey("suffix") ? readableMap.getString("suffix") : null;
        String string8 = readableMap.hasKey("company") ? readableMap.getString("company") : null;
        String string9 = readableMap.hasKey("jobTitle") ? readableMap.getString("jobTitle") : null;
        String string10 = readableMap.hasKey("department") ? readableMap.getString("department") : null;
        String string11 = readableMap.hasKey("note") ? readableMap.getString("note") : null;
        String string12 = readableMap.hasKey("thumbnailPath") ? readableMap.getString("thumbnailPath") : null;
        ReadableArray array = readableMap.hasKey("phoneNumbers") ? readableMap.getArray("phoneNumbers") : null;
        String str3 = Constants.ScionAnalytics.PARAM_LABEL;
        String str4 = string12;
        String str5 = string11;
        if (array != null) {
            size = array.size();
            strArr = new String[size];
            numArr = new Integer[size];
            strArr2 = new String[size];
            String[] strArr14 = new String[size];
            int i2 = 0;
            while (i2 < size) {
                int i3 = size;
                ReadableMap map = array.getMap(i2);
                ReadableArray readableArray4 = array;
                String string13 = map.getString("number");
                String str6 = string6;
                String string14 = map.getString(Constants.ScionAnalytics.PARAM_LABEL);
                String string15 = map.hasKey("id") ? map.getString("id") : null;
                strArr[i2] = string13;
                numArr[i2] = Integer.valueOf(mapStringToPhoneType(string14));
                strArr2[i2] = string14;
                strArr14[i2] = string15;
                i2++;
                size = i3;
                array = readableArray4;
                string6 = str6;
            }
            readableArray = array;
            str = string6;
        } else {
            readableArray = array;
            str = string6;
            strArr = null;
            strArr2 = null;
            numArr = null;
            size = 0;
        }
        ReadableArray array2 = readableMap.hasKey("urlAddresses") ? readableMap.getArray("urlAddresses") : null;
        if (array2 != null) {
            size2 = array2.size();
            objArr = new String[size2];
            strArr3 = new String[size2];
            int i4 = 0;
            while (true) {
                int i5 = size2;
                if (i4 >= size2) {
                    break;
                }
                ReadableMap map2 = array2.getMap(i4);
                ReadableArray readableArray5 = array2;
                objArr[i4] = map2.getString(ImagesContract.URL);
                strArr3[i4] = map2.hasKey("id") ? map2.getString("id") : null;
                i4++;
                size2 = i5;
                array2 = readableArray5;
            }
        } else {
            size2 = 0;
            objArr = null;
            strArr3 = null;
        }
        ReadableArray array3 = readableMap.hasKey("emailAddresses") ? readableMap.getArray("emailAddresses") : null;
        if (array3 != null) {
            size3 = array3.size();
            strArr4 = new String[size3];
            String[] strArr15 = new String[size3];
            numArr2 = new Integer[size3];
            strArr5 = new String[size3];
            int i6 = 0;
            while (i6 < size3) {
                int i7 = size3;
                ReadableMap map3 = array3.getMap(i6);
                ReadableArray readableArray6 = array3;
                strArr4[i6] = map3.getString("email");
                String string16 = map3.getString(Constants.ScionAnalytics.PARAM_LABEL);
                numArr2[i6] = Integer.valueOf(mapStringToEmailType(string16));
                strArr5[i6] = string16;
                strArr15[i6] = map3.hasKey("id") ? map3.getString("id") : null;
                i6++;
                size3 = i7;
                array3 = readableArray6;
            }
            readableArray2 = array3;
        } else {
            readableArray2 = array3;
            numArr2 = null;
            strArr4 = null;
            size3 = 0;
            strArr5 = null;
        }
        ReadableArray array4 = readableMap.hasKey("postalAddresses") ? readableMap.getArray("postalAddresses") : null;
        if (array4 != null) {
            size4 = array4.size();
            strArr8 = new String[size4];
            strArr10 = new String[size4];
            strArr7 = new String[size4];
            String[] strArr16 = new String[size4];
            strArr9 = new String[size4];
            strArr11 = new String[size4];
            numArr3 = new Integer[size4];
            strArr6 = new String[size4];
            int i8 = 0;
            while (i8 < size4) {
                int i9 = size4;
                String valueFromKey = getValueFromKey(array4.getMap(i8), str3);
                strArr8[i8] = getValueFromKey(array4.getMap(i8), GeoCodingCriteria.POD_STREET);
                strArr10[i8] = getValueFromKey(array4.getMap(i8), GeoCodingCriteria.POD_CITY);
                strArr7[i8] = getValueFromKey(array4.getMap(i8), "state");
                strArr16[i8] = getValueFromKey(array4.getMap(i8), "region");
                strArr9[i8] = getValueFromKey(array4.getMap(i8), "postCode");
                strArr11[i8] = getValueFromKey(array4.getMap(i8), PlaceTypes.COUNTRY);
                numArr3[i8] = Integer.valueOf(mapStringToPostalAddressType(valueFromKey));
                strArr6[i8] = valueFromKey;
                i8++;
                size4 = i9;
                str3 = str3;
                string = string;
            }
            str2 = string;
        } else {
            str2 = string;
            size4 = 0;
            strArr6 = null;
            numArr3 = null;
            strArr7 = null;
            strArr8 = null;
            strArr9 = null;
            strArr10 = null;
            strArr11 = null;
        }
        ReadableArray array5 = readableMap.hasKey("imAddresses") ? readableMap.getArray("imAddresses") : null;
        if (array5 != null) {
            size5 = array5.size();
            String[] strArr17 = new String[size5];
            strArr12 = new String[size5];
            String[] strArr18 = new String[size5];
            int i10 = 0;
            while (i10 < size5) {
                int i11 = size5;
                ReadableMap map4 = array5.getMap(i10);
                ReadableArray readableArray7 = array5;
                strArr17[i10] = map4.getString(HintConstants.AUTOFILL_HINT_USERNAME);
                strArr12[i10] = map4.getString(NotificationCompat.CATEGORY_SERVICE);
                strArr18[i10] = map4.hasKey("id") ? map4.getString("id") : null;
                i10++;
                size5 = i11;
                array5 = readableArray7;
            }
            readableArray3 = array5;
            strArr13 = strArr17;
        } else {
            readableArray3 = array5;
            size5 = 0;
            strArr12 = null;
            strArr13 = null;
        }
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        String[] strArr19 = strArr12;
        int i12 = size5;
        String[] strArr20 = strArr9;
        ContentProviderOperation.Builder builderWithValue2 = ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI).withSelection("contact_id=?", new String[]{String.valueOf(str2)}).withValue("mimetype", "vnd.android.cursor.item/name").withValue("data2", string3).withValue("data5", string4).withValue("data3", string5).withValue("data4", str);
        String[] strArr21 = strArr7;
        arrayList.add(builderWithValue2.withValue("data6", string7).build());
        ContentProviderOperation.Builder builderWithValue3 = ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI).withSelection("contact_id=? AND mimetype = ?", new String[]{String.valueOf(str2), "vnd.android.cursor.item/organization"}).withValue("data1", string8).withValue("data4", string9).withValue("data5", string10);
        arrayList.add(builderWithValue3.build());
        builderWithValue3.withYieldAllowed(true);
        if (readableArray != null) {
            arrayList.add(ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI).withSelection("mimetype=? AND raw_contact_id = ?", new String[]{"vnd.android.cursor.item/phone_v2", String.valueOf(string2)}).build());
            int i13 = 0;
            for (int i14 = size; i13 < i14; i14 = i14) {
                arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValue("raw_contact_id", String.valueOf(string2)).withValue("mimetype", "vnd.android.cursor.item/phone_v2").withValue("data1", strArr[i13]).withValue("data2", numArr[i13]).withValue("data3", strArr2[i13]).build());
                i13++;
            }
        }
        int i15 = 0;
        for (int i16 = size2; i15 < i16; i16 = i16) {
            if (strArr3[i15] == 0) {
                builderWithValue = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValue("raw_contact_id", String.valueOf(string2)).withValue("mimetype", "vnd.android.cursor.item/website").withValue("data1", objArr[i15]);
            } else {
                builderWithValue = ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI).withSelection("_id=?", new String[]{String.valueOf(strArr3[i15])}).withValue("data1", objArr[i15]);
            }
            arrayList.add(builderWithValue.build());
            i15++;
            strArr8 = strArr8;
        }
        String[] strArr22 = strArr8;
        if (readableArray2 != null) {
            arrayList.add(ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI).withSelection("mimetype=? AND raw_contact_id = ?", new String[]{"vnd.android.cursor.item/email_v2", String.valueOf(string2)}).build());
            int i17 = size3;
            for (int i18 = 0; i18 < i17; i18++) {
                arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValue("raw_contact_id", String.valueOf(string2)).withValue("mimetype", "vnd.android.cursor.item/email_v2").withValue("data1", strArr4[i18]).withValue("data2", numArr2[i18]).withValue("data3", strArr5[i18]).build());
            }
        }
        arrayList.add(ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI).withSelection("mimetype=? AND raw_contact_id = ?", new String[]{"vnd.android.cursor.item/note", String.valueOf(string2)}).build());
        if (str5 != null) {
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValue("raw_contact_id", String.valueOf(string2)).withValue("mimetype", "vnd.android.cursor.item/note").withValue("data1", str5).build());
        }
        if (str4 == null || str4.isEmpty() || (thumbnailBitmap = getThumbnailBitmap(str4)) == null) {
            i = 0;
        } else {
            i = 0;
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/photo").withValue("data15", toByteArray(thumbnailBitmap)).build());
        }
        if (array4 != null) {
            arrayList.add(ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI).withSelection("mimetype=? AND raw_contact_id = ?", new String[]{"vnd.android.cursor.item/postal-address_v2", String.valueOf(string2)}).build());
            for (int i19 = i; i19 < size4; i19++) {
                arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValue("raw_contact_id", String.valueOf(string2)).withValue("mimetype", "vnd.android.cursor.item/postal-address_v2").withValue("data2", numArr3[i19]).withValue("data3", strArr6[i19]).withValue("data4", strArr22[i19]).withValue("data7", strArr10[i19]).withValue("data8", strArr21[i19]).withValue("data9", strArr20[i19]).withValue("data10", strArr11[i19]).build());
            }
        }
        if (readableArray3 != null) {
            arrayList.add(ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI).withSelection("mimetype=? AND raw_contact_id = ?", new String[]{"vnd.android.cursor.item/im", String.valueOf(string2)}).build());
            for (int i20 = 0; i20 < i12; i20++) {
                arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValue("raw_contact_id", String.valueOf(string2)).withValue("mimetype", "vnd.android.cursor.item/im").withValue("data1", strArr13[i20]).withValue("data2", 1).withValue("data5", -1).withValue("data6", strArr19[i20]).build());
            }
        }
        try {
            ContentResolver contentResolver = getReactApplicationContext().getContentResolver();
            ContentProviderResult[] contentProviderResultArrApplyBatch = contentResolver.applyBatch("com.android.contacts", arrayList);
            if (contentProviderResultArrApplyBatch == null || contentProviderResultArrApplyBatch.length <= 0) {
                return;
            }
            WritableMap contactById = new ContactsProvider(contentResolver).getContactById(str2);
            promise2 = promise;
            try {
                promise2.resolve(contactById);
                return;
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
            promise2 = promise;
        }
        promise2.reject(e.toString());
    }

    @ReactMethod
    public void deleteContact(ReadableMap readableMap, Promise promise) {
        String string = readableMap.hasKey("recordID") ? readableMap.getString("recordID") : null;
        try {
            if (getReactApplicationContext().getContentResolver().delete(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, string), null, null) > 0) {
                promise.resolve(string);
            } else {
                promise.resolve(null);
            }
        } catch (Exception e) {
            promise.reject(e.toString());
        }
    }

    @ReactMethod
    public void checkPermission(Promise promise) {
        promise.resolve(isPermissionGranted());
    }

    @ReactMethod
    public void requestPermission(Promise promise) {
        requestReadContactsPermission(promise);
    }

    private void requestReadContactsPermission(Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject(PERMISSION_DENIED);
        } else if (isPermissionGranted().equals(PERMISSION_AUTHORIZED)) {
            promise.resolve(PERMISSION_AUTHORIZED);
        } else {
            requestPromise = promise;
            ActivityCompat.requestPermissions(currentActivity, new String[]{PERMISSION_READ_CONTACTS}, PERMISSION_REQUEST_CODE);
        }
    }

    protected static void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Promise promise = requestPromise;
        if (promise == null) {
            return;
        }
        if (i != PERMISSION_REQUEST_CODE) {
            promise.resolve(PERMISSION_DENIED);
            return;
        }
        Hashtable hashtable = new Hashtable();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            hashtable.put(strArr[i2], Boolean.valueOf(iArr[i2] == 0));
        }
        if (!hashtable.containsKey(PERMISSION_READ_CONTACTS) || !((Boolean) hashtable.get(PERMISSION_READ_CONTACTS)).booleanValue()) {
            requestPromise.resolve(PERMISSION_DENIED);
        } else {
            requestPromise.resolve(PERMISSION_AUTHORIZED);
        }
        requestPromise = null;
    }

    private String getValueFromKey(ReadableMap readableMap, String str) {
        return readableMap.hasKey(str) ? readableMap.getString(str) : "";
    }

    private String isPermissionGranted() {
        return getReactApplicationContext().checkSelfPermission(PERMISSION_READ_CONTACTS) == 0 ? PERMISSION_AUTHORIZED : PERMISSION_DENIED;
    }

    private int mapStringToPhoneType(String str) {
        str.hashCode();
        switch (str) {
            case "mobile":
            case "cell":
                return 2;
            case "work_pager":
                return 18;
            case "home fax":
                return 5;
            case "work_mobile":
                return 17;
            case "home":
                return 1;
            case "main":
                return 12;
            case "work":
                return 3;
            case "work fax":
                return 4;
            case "other":
                return 7;
            case "pager":
                return 6;
            default:
                return 0;
        }
    }

    private int mapStringToEmailType(String str) {
        str.hashCode();
        switch (str) {
            case "mobile":
                return 4;
            case "home":
            case "personal":
                return 1;
            case "work":
                return 2;
            case "other":
                return 3;
            default:
                return 0;
        }
    }

    private int mapStringToPostalAddressType(String str) {
        str.hashCode();
        if (str.equals("home")) {
            return 1;
        }
        return !str.equals("work") ? 0 : 2;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "Contacts";
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        Promise promise;
        if ((i != REQUEST_OPEN_CONTACT_FORM && i != REQUEST_OPEN_EXISTING_CONTACT) || (promise = updateContactPromise) == null) {
            return;
        }
        if (i2 != -1) {
            promise.resolve(null);
            updateContactPromise = null;
            return;
        }
        if (intent == null) {
            promise.reject("Error received activity result with no data!");
            updateContactPromise = null;
            return;
        }
        try {
            Uri data = intent.getData();
            if (data == null) {
                updateContactPromise.reject("Error wrong data. No content uri found!");
                updateContactPromise = null;
            } else {
                updateContactPromise.resolve(new ContactsProvider(getReactApplicationContext().getContentResolver()).getContactById(data.getLastPathSegment()));
                updateContactPromise = null;
            }
        } catch (Exception e) {
            updateContactPromise.reject(e.getMessage());
        }
    }
}
