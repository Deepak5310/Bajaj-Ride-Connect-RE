package com.google.android.libraries.navigation.internal.yz;

import java.lang.reflect.Field;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class mf {
    private final Field a;

    public mf(Field field) {
        this.a = field;
        field.setAccessible(true);
    }

    final void a(Object obj, int i) {
        try {
            this.a.set(obj, Integer.valueOf(i));
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }

    final void b(Object obj, Object obj2) {
        try {
            this.a.set(obj, obj2);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
