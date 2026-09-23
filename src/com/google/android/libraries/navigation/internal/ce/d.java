package com.google.android.libraries.navigation.internal.ce;

import android.view.View;
import com.google.android.libraries.navigation.internal.jy.p;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.ms.dd;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.zb.j;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class d {
    @JvmStatic
    public static dd a(final h callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        return new dd() { // from class: com.google.android.libraries.navigation.internal.ce.e
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(final cs vm) {
                Intrinsics.checkNotNullParameter(vm, "vm");
                final h hVar = callback;
                return new View.OnClickListener() { // from class: com.google.android.libraries.navigation.internal.ce.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Intrinsics.checkNotNull(view);
                        j jVar = i.a;
                        com.google.android.libraries.navigation.internal.jx.a aVar = com.google.android.libraries.navigation.internal.jx.a.I_AM_THE_FRAMEWORK;
                        int i = com.google.android.libraries.navigation.internal.jw.e.a;
                        ar.q(aVar);
                        p pVar = (p) view.getTag(com.google.android.libraries.navigation.internal.jw.e.d);
                        if (pVar == null) {
                            pVar = p.a;
                            com.google.android.libraries.navigation.internal.nl.a aVar2 = com.google.android.libraries.navigation.internal.nl.a.a;
                            ((com.google.android.libraries.navigation.internal.zb.h) i.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(108)).p("Attempting to invoke a LoggedInteraction callback on a View with no LoggedInteraction. Defaulting to LoggedInteraction.NONE.");
                            Intrinsics.checkNotNullExpressionValue(pVar, "also(...)");
                        }
                        hVar.a(vm, pVar);
                    }
                };
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        };
    }
}
