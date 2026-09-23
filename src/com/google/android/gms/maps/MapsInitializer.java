package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.libraries.navigation.internal.ly.cr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class MapsInitializer {
    private static boolean a = false;

    /* JADX INFO: compiled from: PG */
    public enum Renderer {
        LEGACY,
        LATEST
    }

    private MapsInitializer() {
    }

    public static void a(com.google.android.libraries.navigation.internal.ly.i iVar) {
        try {
            CameraUpdateFactory.a = iVar.a();
            com.google.android.libraries.navigation.internal.lz.b bVarF = iVar.f();
            if (BitmapDescriptorFactory.a != null) {
                return;
            }
            BitmapDescriptorFactory.a = bVarF;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static synchronized int initialize(Context context) {
        com.google.android.libraries.navigation.internal.lh.be.k(context, "Context is null");
        if (a) {
            return 0;
        }
        try {
            a(cr.a(context));
            a = true;
            return 0;
        } catch (com.google.android.libraries.navigation.internal.lc.ah e) {
            return e.a;
        }
    }

    public static synchronized int initialize(Context context, Renderer renderer, OnMapsSdkInitializedCallback onMapsSdkInitializedCallback) {
        int iInitialize;
        com.google.android.libraries.navigation.internal.lh.be.k(context, "Context is null");
        iInitialize = initialize(context);
        if (onMapsSdkInitializedCallback != null) {
            onMapsSdkInitializedCallback.onMapsSdkInitialized(Renderer.LATEST);
        }
        return iInitialize;
    }
}
