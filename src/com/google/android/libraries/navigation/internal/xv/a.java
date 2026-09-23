package com.google.android.libraries.navigation.internal.xv;

import android.app.PendingIntent;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static final int a = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
    public static final ClipData b = ClipData.newIntent("", new Intent());

    public static Intent a(Intent intent, int i) {
        ar.b((i & 88) == 0, "Cannot set any dangerous parts of intent to be mutable.");
        ar.b((i & 1) == 0 || c(0, 3), "Cannot use Intent.FILL_IN_ACTION unless the action is marked as mutable.");
        ar.b((i & 2) == 0 || c(0, 5), "Cannot use Intent.FILL_IN_DATA unless the data is marked as mutable.");
        ar.b((i & 4) == 0 || c(0, 9), "Cannot use Intent.FILL_IN_CATEGORIES unless the category is marked as mutable.");
        ar.b((i & 128) == 0 || c(0, 17), "Cannot use Intent.FILL_IN_CLIP_DATA unless the clip data is marked as mutable.");
        ar.b(intent.getComponent() != null, "Must set component on Intent.");
        if (c(0, 1)) {
            ar.b(!c(i, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL), "Cannot set mutability flags if PendingIntent.FLAG_IMMUTABLE is set.");
        } else {
            ar.b(c(i, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL), "Must set PendingIntent.FLAG_IMMUTABLE for SDK >= 23 if no parts of intent are mutable.");
        }
        Intent intent2 = new Intent(intent);
        if (!c(i, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL)) {
            if (intent2.getPackage() == null) {
                intent2.setPackage(intent2.getComponent().getPackageName());
            }
            if (!c(0, 3) && intent2.getAction() == null) {
                intent2.setAction("");
            }
            if (!c(0, 9) && intent2.getCategories() == null) {
                intent2.addCategory("");
            }
            if (!c(0, 5) && intent2.getData() == null) {
                intent2.setDataAndType(Uri.EMPTY, "*/*");
            }
            if (!c(0, 17) && intent2.getClipData() == null) {
                intent2.setClipData(b);
            }
        }
        return intent2;
    }

    public static PendingIntent b(Context context, Intent intent, int i) {
        return PendingIntent.getService(context, 0, a(intent, i), i);
    }

    private static boolean c(int i, int i2) {
        return (i & i2) == i2;
    }
}
