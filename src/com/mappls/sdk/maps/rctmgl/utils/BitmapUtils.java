package com.mappls.sdk.maps.rctmgl.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import android.util.LruCache;
import android.view.View;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/* JADX INFO: loaded from: classes4.dex */
public class BitmapUtils {
    public static final String LOG_TAG = "BitmapUtils";
    private static int CACHE_SIZE = 1048576;
    private static LruCache<String, Bitmap> mCache = new LruCache<String, Bitmap>(CACHE_SIZE) { // from class: com.mappls.sdk.maps.rctmgl.utils.BitmapUtils.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        public int sizeOf(String str, Bitmap bitmap) {
            return bitmap.getByteCount();
        }
    };

    public static Bitmap getBitmapFromURL(String str) {
        return getBitmapFromURL(str, null);
    }

    public static Bitmap getBitmapFromURL(String str, BitmapFactory.Options options) {
        Bitmap image = getImage(str);
        if (image != null) {
            return image;
        }
        try {
            InputStream inputStreamOpenStream = FirebasePerfUrlConnection.openStream(new URL(str));
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenStream, null, options);
            inputStreamOpenStream.close();
            addImage(str, bitmapDecodeStream);
            return bitmapDecodeStream;
        } catch (Exception e) {
            Log.w(LOG_TAG, e.getLocalizedMessage());
            return Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
        }
    }

    public static Bitmap getBitmapFromResource(Context context, String str, BitmapFactory.Options options) {
        Resources resources = context.getResources();
        return BitmapFactory.decodeResource(resources, resources.getIdentifier(str, "drawable", context.getPackageName()), options);
    }

    public static String createTempFile(Context context, Bitmap bitmap) {
        File fileCreateTempFile;
        FileOutputStream fileOutputStream;
        try {
            fileCreateTempFile = File.createTempFile(LOG_TAG, ".png", context.getCacheDir());
            try {
                fileOutputStream = new FileOutputStream(fileCreateTempFile);
            } catch (IOException e) {
                e = e;
                Log.w(LOG_TAG, e.getLocalizedMessage());
                fileOutputStream = null;
            }
        } catch (IOException e2) {
            e = e2;
            fileCreateTempFile = null;
        }
        if (fileCreateTempFile == null) {
            return null;
        }
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        closeSnapshotOutputStream(fileOutputStream);
        return Uri.fromFile(fileCreateTempFile).toString();
    }

    public static String createBase64(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        closeSnapshotOutputStream(byteArrayOutputStream);
        return "data:image/png;base64," + Base64.encodeToString(byteArray, 2);
    }

    public static Bitmap viewToBitmap(View view, int i, int i2, int i3, int i4) {
        if (view != null) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (i5 > 0 && i6 > 0) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
                bitmapCreateBitmap.eraseColor(0);
                view.draw(new Canvas(bitmapCreateBitmap));
                return bitmapCreateBitmap;
            }
        }
        return null;
    }

    private static void addImage(String str, Bitmap bitmap) {
        mCache.put(str, bitmap);
    }

    private static Bitmap getImage(String str) {
        return mCache.get(str);
    }

    private static void closeSnapshotOutputStream(OutputStream outputStream) {
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            Log.w(LOG_TAG, e.getLocalizedMessage());
        }
    }
}
