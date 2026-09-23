package com.mappls.sdk.nearby.plugin.util;

import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.geometry.LatLng;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class c {
    public static ArrayList a(List points) {
        Intrinsics.checkNotNullParameter(points, "points");
        ArrayList arrayList = new ArrayList();
        Iterator it2 = points.iterator();
        while (it2.hasNext()) {
            Point point = (Point) it2.next();
            arrayList.add(new LatLng(point.latitude(), point.longitude()));
        }
        return arrayList;
    }

    public static String a(Object[] tokens) {
        Intrinsics.checkNotNullParameter(";", "deliminator");
        Intrinsics.checkNotNullParameter(tokens, "tokens");
        StringBuilder sb = new StringBuilder();
        int length = tokens.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append((CharSequence) ";");
            }
            sb.append(tokens[i]);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "builder.toString()");
        return string;
    }
}
