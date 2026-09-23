package com.google.android.libraries.navigation.internal.aga;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class em {
    private em() {
    }

    public static Set a(Map map, String str) {
        com.google.android.libraries.navigation.internal.afx.ci ciVar;
        List listF = bw.f(map, str);
        if (listF == null) {
            return null;
        }
        EnumSet enumSetNoneOf = EnumSet.noneOf(com.google.android.libraries.navigation.internal.afx.ci.class);
        for (Object obj : listF) {
            if (obj instanceof Double) {
                Double d = (Double) obj;
                int iIntValue = d.intValue();
                com.google.android.libraries.navigation.internal.yx.ca.b(((double) iIntValue) == d.doubleValue(), "Status code %s is not integral", obj);
                ciVar = ((iIntValue < 0 || iIntValue >= com.google.android.libraries.navigation.internal.afx.cl.a.size()) ? com.google.android.libraries.navigation.internal.afx.cl.c.b("Unknown code " + iIntValue) : (com.google.android.libraries.navigation.internal.afx.cl) com.google.android.libraries.navigation.internal.afx.cl.a.get(iIntValue)).g;
                com.google.android.libraries.navigation.internal.yx.ca.b(ciVar.r == d.intValue(), "Status code %s is not valid", obj);
            } else {
                if (!(obj instanceof String)) {
                    throw new com.google.android.libraries.navigation.internal.yx.cb("Can not convert status code " + String.valueOf(obj) + " to Status.Code, because its type is " + String.valueOf(obj.getClass()));
                }
                try {
                    com.google.android.libraries.navigation.internal.afx.ci ciVar2 = com.google.android.libraries.navigation.internal.afx.ci.OK;
                    ciVar = (com.google.android.libraries.navigation.internal.afx.ci) Enum.valueOf(com.google.android.libraries.navigation.internal.afx.ci.class, (String) obj);
                } catch (IllegalArgumentException e) {
                    throw new com.google.android.libraries.navigation.internal.yx.cb(com.google.android.libraries.navigation.internal.b.b.e(obj, "Status code ", " is not valid"), e);
                }
            }
            enumSetNoneOf.add(ciVar);
        }
        return Collections.unmodifiableSet(enumSetNoneOf);
    }
}
