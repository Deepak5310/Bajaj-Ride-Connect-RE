package com.google.android.libraries.navigation.internal.aga;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bc implements et {
    private Method b;
    private Method c;
    private Method d;

    @Override // com.google.android.libraries.navigation.internal.aga.et
    public final long a() {
        try {
            Object objInvoke = this.b.invoke(null, null);
            return com.google.android.libraries.navigation.internal.zw.g.e(TimeUnit.SECONDS.toNanos(((Long) this.d.invoke(objInvoke, null)).longValue()), ((Integer) this.c.invoke(objInvoke, null)).intValue());
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public bc(Class cls) {
        try {
            this.b = cls.getMethod("now", null);
            this.c = cls.getMethod("getNano", null);
            this.d = cls.getMethod("getEpochSecond", null);
        } catch (NoSuchMethodException e) {
            throw new AssertionError(e);
        }
    }
}
