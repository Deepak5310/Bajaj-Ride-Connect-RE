package com.google.android.libraries.navigation.internal.xd;

import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bw;
import java.util.UUID;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ab {
    private final br a = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.xd.aa
        @Override // com.google.android.libraries.navigation.internal.yx.br
        public final Object a() {
            return String.format("NAVSDK_SESSION_%s", UUID.randomUUID());
        }
    });

    public final String a() {
        return (String) this.a.a();
    }
}
