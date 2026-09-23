package com.google.android.libraries.navigation.internal.zz;

import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessControlException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ab implements InvocationHandler {
    public static final /* synthetic */ int b = 0;
    private static final fd c;
    public final aa a;

    static {
        ez ezVar = new ez();
        for (Method method : aa.class.getMethods()) {
            if (method.getDeclaringClass().equals(aa.class)) {
                try {
                    method.setAccessible(true);
                } catch (AccessControlException unused) {
                }
                ezVar.f(method.getName(), method);
            }
        }
        c = ezVar.c();
    }

    public ab(aa aaVar) {
        this.a = aaVar;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        String name = method.getName();
        Method method2 = (Method) c.get(name);
        if (method2 == null) {
            throw new UnsupportedOperationException(name);
        }
        try {
            return method2.invoke(this.a, objArr);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }
}
