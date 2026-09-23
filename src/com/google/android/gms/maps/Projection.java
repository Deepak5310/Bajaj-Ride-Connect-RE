package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.VisibleRegion;
import com.google.android.libraries.navigation.internal.abh.bi;
import com.google.android.libraries.navigation.internal.abh.gb;
import com.google.android.libraries.navigation.internal.ly.cf;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class Projection {
    private final cf a;

    public Projection(cf cfVar) {
        this.a = cfVar;
    }

    public LatLng fromScreenLocation(Point point) {
        try {
            cf cfVar = this.a;
            com.google.android.libraries.navigation.internal.lo.n nVar = new com.google.android.libraries.navigation.internal.lo.n(point);
            try {
                ((gb) cfVar).a.c(com.google.android.libraries.navigation.internal.abx.b.PROJECTION_FROM_SCREEN_LOCATION);
                return ((gb) cfVar).b.b((Point) com.google.android.libraries.navigation.internal.lo.n.b(nVar));
            } catch (Throwable th) {
                bi.a(th);
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                if (th instanceof Error) {
                    throw ((Error) th);
                }
                throw new RuntimeException(th);
            }
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public VisibleRegion getVisibleRegion() {
        try {
            cf cfVar = this.a;
            try {
                ((gb) cfVar).a.c(com.google.android.libraries.navigation.internal.abx.b.PROJECTION_GET_FRUSTUM);
                return ((gb) cfVar).b.c();
            } catch (Throwable th) {
                bi.a(th);
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                if (th instanceof Error) {
                    throw ((Error) th);
                }
                throw new RuntimeException(th);
            }
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public Point toScreenLocation(LatLng latLng) {
        try {
            cf cfVar = this.a;
            try {
                ((gb) cfVar).a.c(com.google.android.libraries.navigation.internal.abx.b.PROJECTION_TO_SCREEN_LOCATION);
                return (Point) com.google.android.libraries.navigation.internal.lo.n.b(new com.google.android.libraries.navigation.internal.lo.n(((gb) cfVar).b.a(latLng)));
            } catch (Throwable th) {
                bi.a(th);
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                if (th instanceof Error) {
                    throw ((Error) th);
                }
                throw new RuntimeException(th);
            }
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
