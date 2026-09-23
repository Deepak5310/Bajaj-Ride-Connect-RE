package com.google.android.libraries.navigation.internal.abf;

import java.lang.reflect.Field;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n {
    private static Boolean a;
    private static Exception b;

    public static boolean a() throws Exception {
        Boolean bool = a;
        if (bool != null) {
            return bool.booleanValue();
        }
        Exception exc = b;
        if (exc != null) {
            throw exc;
        }
        try {
            Class<?> cls = Class.forName("android.os.Build");
            Field field = cls.getField("HARDWARE");
            field.setAccessible(true);
            Boolean boolValueOf = Boolean.valueOf(Objects.equals((String) field.get(cls), "goldfish"));
            a = boolValueOf;
            return boolValueOf.booleanValue();
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | RuntimeException e) {
            b = e;
            throw e;
        }
    }
}
