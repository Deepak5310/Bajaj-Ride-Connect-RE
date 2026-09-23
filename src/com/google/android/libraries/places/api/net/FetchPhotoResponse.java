package com.google.android.libraries.places.api.net;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class FetchPhotoResponse {
    public static FetchPhotoResponse newInstance(Bitmap bitmap) {
        return new zzd(bitmap);
    }

    public abstract Bitmap getBitmap();
}
