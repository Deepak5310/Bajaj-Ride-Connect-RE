package com.facebook.react.views.text;

import android.content.Context;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;

/* JADX INFO: loaded from: classes3.dex */
public class FontMetricsUtil {
    private static final float AMPLIFICATION_FACTOR = 100.0f;
    private static final String CAP_HEIGHT_MEASUREMENT_TEXT = "T";
    private static final String X_HEIGHT_MEASUREMENT_TEXT = "x";

    public static WritableArray getFontMetrics(CharSequence charSequence, Layout layout, TextPaint textPaint, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        WritableArray writableArrayCreateArray = Arguments.createArray();
        TextPaint textPaint2 = new TextPaint(textPaint);
        textPaint2.setTextSize(textPaint2.getTextSize() * AMPLIFICATION_FACTOR);
        Rect rect = new Rect();
        int i = 0;
        int i2 = 1;
        textPaint2.getTextBounds("T", 0, 1, rect);
        double dHeight = (rect.height() / AMPLIFICATION_FACTOR) / displayMetrics.density;
        Rect rect2 = new Rect();
        textPaint2.getTextBounds(X_HEIGHT_MEASUREMENT_TEXT, 0, 1, rect2);
        double dHeight2 = (rect2.height() / AMPLIFICATION_FACTOR) / displayMetrics.density;
        while (i < layout.getLineCount()) {
            float lineWidth = (charSequence.length() <= 0 || charSequence.charAt(layout.getLineEnd(i) - i2) != '\n') ? layout.getLineWidth(i) : layout.getLineMax(i);
            Rect rect3 = new Rect();
            layout.getLineBounds(i, rect3);
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putDouble(X_HEIGHT_MEASUREMENT_TEXT, layout.getLineLeft(i) / displayMetrics.density);
            writableMapCreateMap.putDouble("y", rect3.top / displayMetrics.density);
            writableMapCreateMap.putDouble("width", lineWidth / displayMetrics.density);
            writableMapCreateMap.putDouble("height", rect3.height() / displayMetrics.density);
            writableMapCreateMap.putDouble("descender", layout.getLineDescent(i) / displayMetrics.density);
            writableMapCreateMap.putDouble("ascender", (-layout.getLineAscent(i)) / displayMetrics.density);
            writableMapCreateMap.putDouble("baseline", layout.getLineBaseline(i) / displayMetrics.density);
            writableMapCreateMap.putDouble("capHeight", dHeight);
            writableMapCreateMap.putDouble("xHeight", dHeight2);
            writableMapCreateMap.putString("text", charSequence.subSequence(layout.getLineStart(i), layout.getLineEnd(i)).toString());
            writableArrayCreateArray.pushMap(writableMapCreateMap);
            i++;
            i2 = 1;
        }
        return writableArrayCreateArray;
    }
}
