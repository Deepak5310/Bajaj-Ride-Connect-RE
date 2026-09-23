package com.bajajconnect.util;

import android.R;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class ScreenshotUtil {
    public static Bitmap takeS(Activity activity) {
        View viewFindViewById;
        try {
            Window window = activity.getWindow();
            if (window != null && window.getDecorView() != null && (viewFindViewById = activity.getWindow().getDecorView().findViewById(R.id.content)) != null) {
                viewFindViewById.setDrawingCacheEnabled(true);
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(viewFindViewById.getDrawingCache(), viewFindViewById.getWidth(), viewFindViewById.getHeight(), true);
                viewFindViewById.setDrawingCacheEnabled(false);
                return bitmapCreateScaledBitmap;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static File store(Context context, Bitmap bitmap, String str) {
        File file = new File(context.getExternalFilesDir(""), "screenshot.jpeg");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void shareImage(File file, Activity activity) {
        Uri uriForFile = FileProvider.getUriForFile(activity, activity.getApplicationContext().getPackageName() + ".provider", file);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType("image/*");
        intent.putExtra("android.intent.extra.SUBJECT", "");
        intent.putExtra("android.intent.extra.TEXT", "");
        intent.putExtra("android.intent.extra.STREAM", uriForFile);
        intent.addFlags(1);
        try {
            activity.startActivity(Intent.createChooser(intent, "Share Screenshot"));
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(activity, "No App Available", 0).show();
        }
    }
}
