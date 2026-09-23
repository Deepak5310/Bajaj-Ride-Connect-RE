package com.google.android.libraries.navigation.internal.lh;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import androidx.core.os.EnvironmentCompat;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class af implements Handler.Callback {
    final /* synthetic */ ag a;

    public af(ag agVar) {
        this.a = agVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.a.f) {
                ac acVar = (ac) message.obj;
                ae aeVar = (ae) this.a.f.get(acVar);
                if (aeVar != null && aeVar.b()) {
                    if (aeVar.c) {
                        aeVar.g.h.removeMessages(1, aeVar.e);
                        ag agVar = aeVar.g;
                        agVar.i.a(agVar.g, aeVar);
                        aeVar.c = false;
                        aeVar.b = 2;
                    }
                    this.a.f.remove(acVar);
                }
            }
            return true;
        }
        if (i != 1) {
            return false;
        }
        synchronized (this.a.f) {
            ac acVar2 = (ac) message.obj;
            ae aeVar2 = (ae) this.a.f.get(acVar2);
            if (aeVar2 != null && aeVar2.b == 3) {
                new Exception();
                ComponentName componentName = aeVar2.f;
                if (componentName == null) {
                    componentName = null;
                }
                if (componentName == null) {
                    String str = acVar2.c;
                    be.j(str);
                    componentName = new ComponentName(str, EnvironmentCompat.MEDIA_UNKNOWN);
                }
                aeVar2.onServiceDisconnected(componentName);
            }
        }
        return true;
    }
}
