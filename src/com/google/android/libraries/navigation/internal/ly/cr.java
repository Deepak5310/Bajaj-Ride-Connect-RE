package com.google.android.libraries.navigation.internal.ly;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cr {
    private static Context a;
    private static i b;

    public static i a(Context context) throws com.google.android.libraries.navigation.internal.lc.ah {
        com.google.android.libraries.navigation.internal.lh.be.j(context);
        i iVar = b;
        if (iVar != null) {
            return iVar;
        }
        int i = com.google.android.libraries.navigation.internal.lc.aj.a;
        com.google.android.libraries.navigation.internal.lc.ak.c();
        int iB = com.google.android.libraries.navigation.internal.lc.ak.b(context, 12451000);
        if (iB != 0) {
            throw new com.google.android.libraries.navigation.internal.lc.ah(iB);
        }
        try {
            i iVar2 = (i) b(Class.forName("com.google.android.libraries.navigation.internal.ly.c"));
            b = iVar2;
            try {
                Context applicationContext = a;
                if (applicationContext == null) {
                    applicationContext = context.getApplicationContext();
                    a = applicationContext;
                }
                iVar2.g(new com.google.android.libraries.navigation.internal.lo.n(applicationContext.getResources()), 0);
                return b;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static Object b(Class cls) {
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Unable to call the default constructor of ".concat(String.valueOf(cls.getName())), e);
        } catch (InstantiationException e2) {
            throw new IllegalStateException("Unable to instantiate the dynamic class ".concat(String.valueOf(cls.getName())), e2);
        }
    }
}
