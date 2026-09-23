package com.mappls.sdk.maps.annotations;

import android.R;
import android.content.Context;
import android.widget.PopupWindow;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
class BubblePopupHelper {
    BubblePopupHelper() {
    }

    static PopupWindow create(Context context, BubbleLayout bubbleLayout) {
        PopupWindow popupWindow = new PopupWindow(context);
        popupWindow.setContentView(bubbleLayout);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setWidth(-2);
        popupWindow.setHeight(-2);
        popupWindow.setAnimationStyle(R.style.Animation.Dialog);
        popupWindow.setBackgroundDrawable(context.getDrawable(com.mappls.sdk.maps.R.drawable.mappls_maps_popup_window_transparent));
        return popupWindow;
    }
}
