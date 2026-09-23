package com.google.android.libraries.navigation.internal.hn;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.afl.fd;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.no;
import java.util.ArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class n implements br {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.yx.br
    public final /* synthetic */ Object a() {
        int i = p.b;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("NavigationParameters.getDefaultCameraParameters");
        try {
            ArrayList arrayList = new ArrayList();
            no it2 = ev.r(fd.CAMERA_2D_NORTH_UP, fd.CAMERA_2D_HEADING_UP).iterator();
            while (it2.hasNext()) {
                fd fdVar = (fd) it2.next();
                p.l(arrayList, fdVar, false, false, 14.5f, 15.0f, 15.75f, 18.5f, 15.75f, 15.75f);
                p.l(arrayList, fdVar, true, false, 15.5f, 16.0f, 16.75f, 16.75f, 15.75f, 16.75f);
                p.l(arrayList, fdVar, false, true, 14.75f, 16.0f, 16.0f, 16.0f, 17.75f, 16.0f);
                p.l(arrayList, fdVar, true, true, 15.5f, 16.25f, 17.5f, 17.5f, 17.75f, 17.5f);
            }
            p.l(arrayList, fd.CAMERA_3D, false, false, 15.0f, 16.25f, 17.25f, 18.5f, 17.25f, 17.25f);
            p.l(arrayList, fd.CAMERA_3D, true, false, 15.0f, 16.5f, 17.75f, 17.75f, 17.25f, 17.75f);
            p.l(arrayList, fd.CAMERA_3D, false, true, 15.0f, 17.75f, 17.75f, 17.75f, 17.75f, 17.75f);
            p.l(arrayList, fd.CAMERA_3D, true, true, 15.0f, 18.0f, 18.0f, 18.0f, 17.75f, 18.0f);
            if (dVarB != null) {
                Trace.endSection();
            }
            return arrayList;
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
