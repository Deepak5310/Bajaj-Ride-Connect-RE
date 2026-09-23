package com.bajajconnect;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class MusicFilesManager extends ReactContextBaseJavaModule {
    private String[] STAR;
    private final ReactApplicationContext reactContext;
    private int version;

    MusicFilesManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.version = Build.VERSION.SDK_INT;
        this.STAR = new String[]{"*"};
        this.reactContext = reactApplicationContext;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNMusicFilesManager";
    }

    @ReactMethod
    public void getMusicOnDevice(final Promise promise) {
        if (this.version <= 19) {
            lambda$getMusicOnDevice$0(promise);
        } else {
            new Thread(null, new Runnable() { // from class: com.bajajconnect.MusicFilesManager$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getMusicOnDevice$0(promise);
                }
            }, "asyncTask", 1024L).start();
        }
    }

    private String saveImageToStorageAndGetPath(String str, Bitmap bitmap) throws Throwable {
        if (bitmap != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 60, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byte[] bArrDecode = Base64.decode(Base64.encodeToString(byteArray, 0), 0);
                if (byteArray != null) {
                    saveToStorage(str, bArrDecode);
                    return str;
                }
                return "";
            } catch (IOException e) {
                Log.e("Error savingImageAfter", e.getMessage());
                return "";
            }
        }
        return "";
    }

    private void saveToStorage(String str, byte[] bArr) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str), true);
                try {
                    fileOutputStream2.write(bArr);
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                } catch (IOException e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    Log.e("Error saving image => ", e.getMessage());
                    if (fileOutputStream != null) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getAllSongs, reason: merged with bridge method [inline-methods] */
    public void lambda$getMusicOnDevice$0(Promise promise) {
        String str;
        String str2;
        String string;
        Cursor cursorQuery = getCurrentActivity().getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, "is_music!= 0", null, "title ASC");
        String str3 = "ERR";
        if (cursorQuery == null || !cursorQuery.moveToFirst()) {
            Log.i("com.tests", "Something is wrong with the music musicCursor");
            promise.reject("ERR", "An error occured while retrieving the music.");
            return;
        }
        if (cursorQuery.getCount() > 0) {
            WritableNativeArray writableNativeArray = new WritableNativeArray();
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            int columnIndex = cursorQuery.getColumnIndex("_id");
            while (true) {
                try {
                    try {
                        try {
                            WritableNativeMap writableNativeMap = new WritableNativeMap();
                            long j = cursorQuery.getLong(columnIndex);
                            writableNativeMap.putString("id", String.valueOf(j));
                            String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                            if (string2 == null || string2 == "") {
                                str = str3;
                                columnIndex = columnIndex;
                            } else {
                                try {
                                    try {
                                        mediaMetadataRetriever.setDataSource(string2);
                                    } catch (Exception e) {
                                        Log.e("Music err...", e.toString(), e);
                                    }
                                    try {
                                        String strSubstring = string2.substring(string2.lastIndexOf(RemoteSettings.FORWARD_SLASH_STRING) + 1);
                                        writableNativeMap.putString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, "file://" + string2);
                                        writableNativeMap.putString("fileName", strSubstring);
                                        String strExtractMetadata = mediaMetadataRetriever.extractMetadata(7);
                                        if (strExtractMetadata == null || strExtractMetadata.isEmpty()) {
                                            writableNativeMap.putString("title", strSubstring);
                                        } else {
                                            writableNativeMap.putString("title", strExtractMetadata);
                                        }
                                        String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(9);
                                        writableNativeMap.putString("duration", "" + strExtractMetadata2);
                                        writableNativeMap.putString("artist", mediaMetadataRetriever.extractMetadata(2));
                                        try {
                                            byte[] embeddedPicture = mediaMetadataRetriever.getEmbeddedPicture();
                                            if (embeddedPicture != null) {
                                                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(embeddedPicture, 0, embeddedPicture.length);
                                                try {
                                                    getReactApplicationContext().getExternalFilesDir(null);
                                                    if (this.version >= 29) {
                                                        StringBuilder sb = new StringBuilder();
                                                        str = str3;
                                                        try {
                                                            try {
                                                                sb.append(getReactApplicationContext().getExternalFilesDir(null));
                                                                sb.append(RemoteSettings.FORWARD_SLASH_STRING);
                                                                sb.append(j);
                                                                sb.append(".jpg");
                                                                string = sb.toString();
                                                            } catch (Exception e2) {
                                                                e = e2;
                                                                try {
                                                                    Log.e("error in image", e.getMessage());
                                                                } catch (Exception unused) {
                                                                    Log.e("embedImage", "No embed image");
                                                                }
                                                            }
                                                        } catch (RuntimeException e3) {
                                                            e = e3;
                                                            str2 = str;
                                                            promise.reject(str2, e.toString());
                                                            promise.resolve(writableNativeArray);
                                                            mediaMetadataRetriever.release();
                                                        }
                                                    } else {
                                                        str = str3;
                                                        string = Environment.getExternalStorageDirectory() + RemoteSettings.FORWARD_SLASH_STRING + j + ".jpg";
                                                    }
                                                    writableNativeMap.putString("cover", "file://" + saveImageToStorageAndGetPath(string, bitmapDecodeByteArray));
                                                } catch (Exception e4) {
                                                    e = e4;
                                                    str = str3;
                                                }
                                            } else {
                                                str = str3;
                                            }
                                        } catch (Exception unused2) {
                                            str = str3;
                                        }
                                        try {
                                            if (Integer.parseInt(strExtractMetadata2) > 0) {
                                                writableNativeArray.pushMap(writableNativeMap);
                                            }
                                            Log.e("Music JSON", writableNativeArray.toString());
                                        } catch (Exception e5) {
                                            e = e5;
                                            Log.e("Music Error", e.toString());
                                        }
                                    } catch (Exception e6) {
                                        e = e6;
                                        str = str3;
                                    }
                                } catch (RuntimeException e7) {
                                    e = e7;
                                    str2 = str3;
                                    promise.reject(str2, e.toString());
                                    promise.resolve(writableNativeArray);
                                    mediaMetadataRetriever.release();
                                }
                            }
                        } catch (RuntimeException e8) {
                            e = e8;
                            str = str3;
                        }
                    } catch (Exception e9) {
                        e = e9;
                        str = str3;
                        columnIndex = columnIndex;
                    }
                    try {
                        try {
                            if (!cursorQuery.moveToNext()) {
                                break;
                            }
                            columnIndex = columnIndex;
                            str3 = str;
                        } catch (Exception e10) {
                            promise.reject(str, e10.getMessage());
                            promise.resolve(writableNativeArray);
                            mediaMetadataRetriever.release();
                        }
                    } catch (IOException e11) {
                        e11.printStackTrace();
                        return;
                    }
                } catch (Throwable th) {
                    try {
                        promise.resolve(writableNativeArray);
                        mediaMetadataRetriever.release();
                        throw th;
                    } catch (IOException e12) {
                        e12.printStackTrace();
                        throw th;
                    }
                }
            }
            promise.resolve(writableNativeArray);
            mediaMetadataRetriever.release();
        }
    }
}
