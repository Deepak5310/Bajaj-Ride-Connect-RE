package com.google.android.libraries.navigation.internal.zp;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k implements Serializable, l, m, cf {
    public static final /* synthetic */ int b = 0;
    private static final HashMap e = new HashMap();
    private static final HashMap f = new HashMap();
    private static boolean g = false;
    public final int a;

    public k(int i) {
        this.a = i;
    }

    @Override // com.google.android.libraries.navigation.internal.zp.cf
    public final int a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof k) && this.a == ((k) obj).a;
    }

    public final int hashCode() {
        return this.a * 31;
    }

    public final String toString() {
        synchronized (e) {
            if (!g) {
                for (Field field : k.class.getFields()) {
                    int modifiers = field.getModifiers();
                    if (k.class.equals(field.getType()) && Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers)) {
                        try {
                            k kVar = (k) field.get(null);
                            e.put(Integer.valueOf(kVar.a), kVar);
                            f.put(kVar, field);
                        } catch (IllegalAccessException e2) {
                            throw new RuntimeException(e2);
                        }
                    }
                }
                g = true;
            }
        }
        return ((Field) Objects.requireNonNull((Field) f.get(this))).getName();
    }
}
