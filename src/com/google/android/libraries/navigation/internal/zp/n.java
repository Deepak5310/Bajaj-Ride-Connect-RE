package com.google.android.libraries.navigation.internal.zp;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n implements Serializable, o, p, ce {
    private static final HashMap aX = new HashMap();
    private static final HashMap aY = new HashMap();
    private static boolean aZ = false;
    public static final /* synthetic */ int b = 0;
    public final int a;

    public n(int i) {
        this.a = i;
    }

    @Override // com.google.android.libraries.navigation.internal.zp.cf
    public final int a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof n) && this.a == ((n) obj).a;
    }

    public final int hashCode() {
        return this.a * 31;
    }

    public final String toString() {
        synchronized (aX) {
            if (!aZ) {
                for (Field field : n.class.getFields()) {
                    int modifiers = field.getModifiers();
                    if (n.class.equals(field.getType()) && Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers)) {
                        try {
                            n nVar = (n) field.get(null);
                            aX.put(Integer.valueOf(nVar.a), nVar);
                            aY.put(nVar, field);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                aZ = true;
            }
        }
        return ((Field) Objects.requireNonNull((Field) aY.get(this))).getName();
    }
}
