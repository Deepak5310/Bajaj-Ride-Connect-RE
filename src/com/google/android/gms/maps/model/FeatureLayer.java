package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.libraries.navigation.internal.lh.be;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class FeatureLayer {
    private final com.google.android.libraries.navigation.internal.lz.f a;
    private StyleFactory b;
    private final Map c = new HashMap();

    /* JADX INFO: compiled from: PG */
    public interface OnFeatureClickListener {
        void onFeatureClick(FeatureClickEvent featureClickEvent);
    }

    /* JADX INFO: compiled from: PG */
    public interface StyleFactory {
        FeatureStyle getStyle(Feature feature);
    }

    public FeatureLayer(com.google.android.libraries.navigation.internal.lz.f fVar) {
        be.j(fVar);
        this.a = fVar;
    }

    public String getDatasetId() {
        try {
            return this.a.a();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public StyleFactory getFeatureStyle() {
        return this.b;
    }

    @FeatureType
    public String getFeatureType() {
        try {
            return this.a.b();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isAvailable() {
        try {
            return this.a.f();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void removeOnFeatureClickListener(OnFeatureClickListener onFeatureClickListener) {
        try {
            if (this.c.containsKey(onFeatureClickListener)) {
                this.a.d((com.google.android.libraries.navigation.internal.lz.r) this.c.get(onFeatureClickListener));
                this.c.remove(onFeatureClickListener);
            }
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setFeatureStyle(StyleFactory styleFactory) {
        this.b = styleFactory;
        if (styleFactory == null) {
            try {
                this.a.e(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            try {
                this.a.e(new d());
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }

    public final void addOnFeatureClickListener(OnFeatureClickListener onFeatureClickListener) {
        try {
            e eVar = new e();
            this.c.put(onFeatureClickListener, eVar);
            this.a.c(eVar);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
