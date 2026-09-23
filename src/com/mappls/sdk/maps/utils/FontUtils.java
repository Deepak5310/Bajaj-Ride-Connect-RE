package com.mappls.sdk.maps.utils;

import android.graphics.Typeface;
import com.mappls.sdk.maps.MapStrictMode;
import com.mappls.sdk.maps.constants.MapplsConstants;
import com.mappls.sdk.maps.log.Logger;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class FontUtils {
    private static final List<String> DEFAULT_FONT_STACKS;
    private static final String TAG = "Mbgl-FontUtils";
    private static final String TYPEFACE_FONTMAP_FIELD_NAME = "sSystemFontMap";

    static {
        ArrayList arrayList = new ArrayList();
        DEFAULT_FONT_STACKS = arrayList;
        arrayList.add(MapplsConstants.DEFAULT_FONT);
        arrayList.add("serif");
        arrayList.add("monospace");
    }

    private FontUtils() {
    }

    public static String extractValidFont(String... strArr) {
        if (strArr == null) {
            return null;
        }
        List<String> deviceFonts = getDeviceFonts();
        for (String str : strArr) {
            if (deviceFonts.contains(str)) {
                return str;
            }
        }
        Logger.i(TAG, String.format("Couldn't map font family for local ideograph, using %s instead", MapplsConstants.DEFAULT_FONT));
        return MapplsConstants.DEFAULT_FONT;
    }

    private static List<String> getDeviceFonts() {
        ArrayList arrayList = new ArrayList();
        try {
            Typeface typefaceCreate = Typeface.create(Typeface.DEFAULT, 0);
            Field declaredField = Typeface.class.getDeclaredField(TYPEFACE_FONTMAP_FIELD_NAME);
            declaredField.setAccessible(true);
            arrayList.addAll(((Map) declaredField.get(typefaceCreate)).keySet());
        } catch (Exception e) {
            Logger.e(TAG, "Couldn't load fonts from Typeface", e);
            MapStrictMode.strictModeViolation("Couldn't load fonts from Typeface", e);
        }
        return arrayList;
    }
}
