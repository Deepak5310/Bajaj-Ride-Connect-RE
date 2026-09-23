package com.google.android.libraries.navigation.internal.yk;

import android.net.Uri;
import com.google.android.libraries.navigation.internal.aac.ac;
import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.be;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.j;
import com.google.android.libraries.navigation.internal.aac.t;
import com.google.android.libraries.navigation.internal.ael.cc;
import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.yh.ad;
import com.google.android.libraries.navigation.internal.yh.ae;
import com.google.android.libraries.navigation.internal.yh.c;
import com.google.android.libraries.navigation.internal.yr.am;
import java.io.IOException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends c {
    private final cy a;

    public b(cy cyVar) {
        this.a = cyVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yh.c
    public final bj a(final IOException iOException, ad adVar) {
        if (!(iOException.getCause() instanceof cc)) {
            return az.g(iOException);
        }
        cy cyVar = this.a;
        final ae aeVar = adVar.a;
        return com.google.android.libraries.navigation.internal.aac.c.i(j.i(az.h(cyVar), am.d(new t() { // from class: com.google.android.libraries.navigation.internal.yh.t
            @Override // com.google.android.libraries.navigation.internal.aac.t
            public final bj a(Object obj) throws IOException {
                ae aeVar2 = aeVar;
                aeVar2.c((Uri) az.n(aeVar2.b), obj);
                return be.a;
            }
        }), aeVar.c), IOException.class, new t() { // from class: com.google.android.libraries.navigation.internal.yk.a
            @Override // com.google.android.libraries.navigation.internal.aac.t
            public final bj a(Object obj) throws IOException {
                IOException iOException2 = iOException;
                iOException2.addSuppressed((IOException) obj);
                throw iOException2;
            }
        }, ac.INSTANCE);
    }
}
