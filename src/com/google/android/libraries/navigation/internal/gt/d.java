package com.google.android.libraries.navigation.internal.gt;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    public static Map a(List list) {
        HashMap map = new HashMap();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            for (String str : ((String) it2.next()).trim().split("\\s*,\\s*", -1)) {
                HashMap map2 = new HashMap();
                String lowerCase = "";
                for (String str2 : str.split("\\s*;\\s*", -1)) {
                    if (str2.contains("=")) {
                        String[] strArrSplit = str2.split("\\s*=\\s*", 2);
                        if (!map2.containsKey(strArrSplit[0].toLowerCase(Locale.ROOT))) {
                            map2.put(strArrSplit[0].toLowerCase(Locale.ROOT), strArrSplit[1].replaceAll("^\"|\"$", ""));
                        }
                    } else if (lowerCase.isEmpty()) {
                        lowerCase = str2.toLowerCase(Locale.ROOT);
                    }
                }
                if (!lowerCase.isEmpty()) {
                    if (map.containsKey(lowerCase)) {
                        HashMap map3 = new HashMap();
                        map3.putAll(map2);
                        map3.putAll((Map) map.get(lowerCase));
                        map.put(lowerCase, map3);
                    } else {
                        map.put(lowerCase, map2);
                    }
                }
            }
        }
        return map;
    }
}
