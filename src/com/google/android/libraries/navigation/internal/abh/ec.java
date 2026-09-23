package com.google.android.libraries.navigation.internal.abh;

import android.os.RemoteException;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ec {
    public static final String a = "ec";
    public boolean b = false;
    public com.google.android.libraries.navigation.internal.ly.ax c = null;
    public com.google.android.libraries.navigation.internal.ly.ax d = null;
    private final Executor e;

    public ec(Executor executor) {
        this.e = executor;
    }

    public final void a() {
        synchronized (this) {
            if (!this.b || (this.d == null && this.c == null)) {
                return;
            }
            this.e.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.eb
                @Override // java.lang.Runnable
                public final void run() {
                    ec ecVar = this.a;
                    synchronized (ecVar) {
                        if (ecVar.b && (ecVar.d != null || ecVar.c != null)) {
                            ArrayList arrayList = new ArrayList(2);
                            com.google.android.libraries.navigation.internal.ly.ax axVar = ecVar.d;
                            if (axVar != null) {
                                arrayList.add(axVar);
                                ecVar.d = null;
                            }
                            com.google.android.libraries.navigation.internal.ly.ax axVar2 = ecVar.c;
                            if (axVar2 != null) {
                                arrayList.add(axVar2);
                                ecVar.c = null;
                            }
                            com.google.android.libraries.navigation.internal.abf.p.f(ec.a, 2);
                            int size = arrayList.size();
                            for (int i = 0; i < size; i++) {
                                try {
                                    ((com.google.android.libraries.navigation.internal.ly.ax) arrayList.get(i)).a();
                                } catch (RemoteException e) {
                                    throw new RuntimeRemoteException(e);
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    public final void b(boolean z) {
        synchronized (this) {
            this.b = z;
        }
        a();
    }
}
