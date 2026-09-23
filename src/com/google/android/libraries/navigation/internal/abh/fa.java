package com.google.android.libraries.navigation.internal.abh;

import android.graphics.Path;
import com.mappls.sdk.services.api.weather.WeatherCriteria;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fa {
    static final Path a(String str, float f) {
        Path path = new Path();
        ArrayList<List> arrayList = new ArrayList();
        Iterable iterableG = com.google.android.libraries.navigation.internal.yx.bj.b(' ').g(str.replaceAll("([A-Za-z])", "\n$1").replaceAll("[\\t\\n\\r]+", StringUtils.SPACE));
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = iterableG.iterator();
        while (it2.hasNext()) {
            String strTrim = ((String) it2.next()).trim();
            if (!strTrim.isEmpty()) {
                arrayList2.add(strTrim);
            }
        }
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            String str2 = (String) arrayList2.get(i);
            if (Character.isLetter(str2.charAt(0))) {
                arrayList.add(new ArrayList());
            }
            ((List) com.google.android.libraries.navigation.internal.yz.gs.d(arrayList)).add(str2);
        }
        for (List<String> list : arrayList) {
            for (String str3 : list) {
                ArrayList arrayList3 = new ArrayList();
                int i2 = 0;
                while (i2 < list.size()) {
                    String strReplaceAll = (String) list.get(i2);
                    if (i2 == 0) {
                        strReplaceAll = strReplaceAll.replaceAll("[A-Za-z]+", "");
                        i2 = 0;
                    }
                    if (!strReplaceAll.isEmpty()) {
                        arrayList3.add(Float.valueOf(Float.parseFloat(strReplaceAll) * f));
                    }
                    i2++;
                }
                if (str3.startsWith("M") || str3.startsWith("m")) {
                    path.moveTo(((Float) arrayList3.get(0)).floatValue(), ((Float) arrayList3.get(1)).floatValue());
                } else if (str3.startsWith(WeatherCriteria.UNIT_CELSIUS) || str3.startsWith("c")) {
                    path.cubicTo(((Float) arrayList3.get(0)).floatValue(), ((Float) arrayList3.get(1)).floatValue(), ((Float) arrayList3.get(2)).floatValue(), ((Float) arrayList3.get(3)).floatValue(), ((Float) arrayList3.get(4)).floatValue(), ((Float) arrayList3.get(5)).floatValue());
                }
            }
        }
        path.close();
        return path;
    }
}
