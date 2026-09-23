package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_common.zzam;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.0.0 */
/* JADX INFO: loaded from: classes6.dex */
public class OptionalModuleUtils {
    public static final String BARCODE = "barcode";
    public static final String CUSTOM_ICA = "custom_ica";
    public static final String DEPRECATED_DYNAMITE_MODULE_ID = "com.google.android.gms.vision.dynamite";
    public static final String FACE = "face";
    public static final String ICA = "ica";
    public static final String LANGID = "langid";
    public static final String MLKIT_BARCODE_UI = "barcode_ui";
    public static final String NLCLASSIFIER = "nlclassifier";
    public static final String NLCLASSIFIER_MODULE_ID = "com.google.android.gms.mlkit.nlclassifier";
    public static final String OCR = "ocr";
    public static final String TFLITE_DYNAMITE = "tflite_dynamite";
    public static final String TFLITE_DYNAMITE_MODULE_ID = "com.google.android.gms.tflite_dynamite";

    private OptionalModuleUtils() {
    }

    public static boolean areAllRequiredModulesAvailable(Context context, List<String> list) throws Throwable {
        try {
            Iterator<String> it2 = list.iterator();
            while (it2.hasNext()) {
                DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, it2.next());
            }
            return true;
        } catch (DynamiteModule.LoadingException unused) {
            return false;
        }
    }

    public static void requestDownload(Context context, String str) {
        requestDownload(context, zzam.zzj(str));
    }

    public static void requestDownload(Context context, List<String> list) {
        Intent intent = new Intent();
        intent.setClassName("com.google.android.gms", "com.google.android.gms.vision.DependencyBroadcastReceiverProxy");
        intent.setAction("com.google.android.gms.vision.DEPENDENCY");
        intent.putExtra("com.google.android.gms.vision.DEPENDENCIES", TextUtils.join(",", list));
        intent.putExtra("requester_app_package", context.getApplicationInfo().packageName);
        context.sendBroadcast(intent);
    }
}
