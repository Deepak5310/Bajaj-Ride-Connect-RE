package com.google.android.libraries.navigation.internal.abh;

import android.content.ComponentCallbacks2;
import android.content.SharedPreferences;
import android.content.res.Configuration;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class h implements ComponentCallbacks2 {
    final /* synthetic */ l a;

    public h(l lVar) {
        this.a = lVar;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        com.google.android.libraries.navigation.internal.afu.d.a.a().H();
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        if (i == 20) {
            l lVar = this.a;
            synchronized (lVar) {
                lVar.b = 0;
            }
            lVar.a();
            if (lVar.c.a() != null) {
                final com.google.android.libraries.navigation.internal.ny.e eVar = (com.google.android.libraries.navigation.internal.ny.e) lVar.c.a();
                if (eVar.h != -1 && eVar.g != null) {
                    eVar.d.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.ny.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            e eVar2 = eVar;
                            SharedPreferences.Editor editorEdit = eVar2.g.edit();
                            editorEdit.putLong("InitializedEventPreviousEventMsPrefKey", eVar2.h);
                            editorEdit.apply();
                        }
                    });
                }
                ((com.google.android.libraries.navigation.internal.ny.e) lVar.c.a()).a();
            }
            com.google.android.libraries.navigation.internal.wd.g gVar = lVar.d;
            if (gVar != null) {
                gVar.d();
            }
        }
    }
}
