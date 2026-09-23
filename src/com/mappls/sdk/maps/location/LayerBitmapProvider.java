package com.mappls.sdk.maps.location;

import android.content.Context;
import android.graphics.Bitmap;
import com.mappls.sdk.maps.R;
import com.mappls.sdk.maps.utils.BitmapUtils;

/* JADX INFO: loaded from: classes4.dex */
class LayerBitmapProvider {
    private final Context context;

    LayerBitmapProvider(Context context) {
        this.context = context;
    }

    Bitmap generateBitmap(int i, Integer num) {
        return BitmapUtils.getBitmapFromDrawable(BitmapUtils.getDrawableFromRes(this.context, i, num));
    }

    Bitmap generateShadowBitmap(LocationComponentOptions locationComponentOptions) {
        return Utils.generateShadow(BitmapUtils.getDrawableFromRes(this.context, R.drawable.mappls_maps_user_icon_shadow), locationComponentOptions.elevation());
    }
}
