package com.mappls.sdk.maps.utils;

import java.text.Normalizer;

/* JADX INFO: loaded from: classes4.dex */
class StringUtils {
    StringUtils() {
    }

    static String unaccent(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("(\\p{InCombiningDiacriticalMarks}|\\p{InCombiningDiacriticalMarksForSymbols}|\\p{InCombiningDiacriticalMarksSupplement})+", "");
    }
}
