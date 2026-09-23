package com.google.android.libraries.navigation.internal.zl;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
enum s implements q {
    UNSAFE_LITTLE_ENDIAN,
    UNSAFE_BIG_ENDIAN;

    private static final Unsafe c;
    private static final int d;

    static {
        Unsafe unsafeB = b();
        c = unsafeB;
        d = unsafeB.arrayBaseOffset(byte[].class);
        if (unsafeB.arrayIndexScale(byte[].class) != 1) {
            throw new AssertionError();
        }
    }

    private static Unsafe b() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (PrivilegedActionException e2) {
                throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
            }
        } catch (SecurityException unused) {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction() { // from class: com.google.android.libraries.navigation.internal.zl.r
                @Override // java.security.PrivilegedExceptionAction
                public final Object run() throws IllegalAccessException {
                    s sVar = s.UNSAFE_LITTLE_ENDIAN;
                    for (Field field : Unsafe.class.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get(null);
                        if (Unsafe.class.isInstance(obj)) {
                            return (Unsafe) Unsafe.class.cast(obj);
                        }
                    }
                    throw new NoSuchFieldError("the Unsafe");
                }
            });
        }
    }

    @Override // com.google.android.libraries.navigation.internal.zl.q
    public final /* synthetic */ long a(byte[] bArr, int i) {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            return c.getLong(bArr, ((long) i) + ((long) d));
        }
        if (iOrdinal != 1) {
            throw null;
        }
        return Long.reverseBytes(c.getLong(bArr, ((long) i) + ((long) d)));
    }
}
