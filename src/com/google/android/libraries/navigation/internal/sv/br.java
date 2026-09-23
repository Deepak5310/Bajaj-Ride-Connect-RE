package com.google.android.libraries.navigation.internal.sv;

import com.google.android.libraries.navigation.internal.ace.mk;
import com.google.android.libraries.navigation.internal.ace.ml;
import com.google.android.libraries.navigation.internal.ace.mw;
import com.google.android.libraries.navigation.internal.adr.Cdo;
import com.google.android.libraries.navigation.internal.yz.fd;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class br {
    private final List a;
    private final fd b;
    private final fd c;
    private final com.google.android.libraries.navigation.internal.dx.a d;

    public br(com.google.android.libraries.navigation.internal.hn.r rVar, com.google.android.libraries.navigation.internal.dx.a aVar) {
        this.d = aVar;
        ml mlVar = ((mw) rVar.b()).d;
        this.b = (fd) (mlVar == null ? ml.a : mlVar).b.stream().collect(com.google.android.libraries.navigation.internal.yz.br.a(new Function() { // from class: com.google.android.libraries.navigation.internal.sv.bn
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Cdo cdoB = Cdo.b(((mk) obj).b);
                return cdoB == null ? Cdo.INCIDENT_ROAD_CLOSED : cdoB;
            }
        }, new Function() { // from class: com.google.android.libraries.navigation.internal.sv.bo
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((mk) obj).c);
            }
        }));
        ml mlVar2 = ((mw) rVar.b()).e;
        this.c = (fd) (mlVar2 == null ? ml.a : mlVar2).b.stream().collect(com.google.android.libraries.navigation.internal.yz.br.a(new Function() { // from class: com.google.android.libraries.navigation.internal.sv.bp
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Cdo cdoB = Cdo.b(((mk) obj).b);
                return cdoB == null ? Cdo.INCIDENT_ROAD_CLOSED : cdoB;
            }
        }, new Function() { // from class: com.google.android.libraries.navigation.internal.sv.bq
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((mk) obj).c);
            }
        }));
        this.a = new ArrayList();
    }
}
