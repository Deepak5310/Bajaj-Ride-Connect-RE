package com.google.android.libraries.navigation.internal.dx;

import com.google.android.libraries.navigation.internal.ace.nx;
import com.google.android.libraries.navigation.internal.nc.ah;
import com.google.android.libraries.navigation.internal.nc.aj;
import com.google.android.libraries.navigation.internal.nc.x;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements com.google.android.libraries.navigation.internal.bn.b {
    public ah a;
    private final i b;
    private final com.google.android.libraries.navigation.internal.vg.b c;
    private final n d;
    private com.google.android.libraries.navigation.internal.bn.b e;

    public c(final i reportIncidentUtil, com.google.android.libraries.navigation.internal.vg.b iconUrl, n severityWrapper) {
        ah ahVarF;
        Intrinsics.checkNotNullParameter(reportIncidentUtil, "reportIncidentUtil");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(severityWrapper, "severityWrapper");
        this.b = reportIncidentUtil;
        this.c = iconUrl;
        this.d = severityWrapper;
        ah ahVarC = aj.c();
        Intrinsics.checkNotNullExpressionValue(ahVarC, "emptyDrawable(...)");
        this.a = ahVarC;
        if (severityWrapper instanceof m) {
            ahVarF = reportIncidentUtil.e(iconUrl, ((m) severityWrapper).a, this);
        } else {
            if (!(severityWrapper instanceof l)) {
                throw new NoWhenBranchMatchedException();
            }
            nx nxVar = ((l) severityWrapper).a;
            final x xVarB = reportIncidentUtil.b(nxVar);
            final x xVarD = reportIncidentUtil.d(nxVar);
            com.google.android.libraries.navigation.internal.vg.a aVar = (com.google.android.libraries.navigation.internal.vg.a) iconUrl;
            ah ahVarA = com.google.android.libraries.navigation.internal.ca.d.a(aVar.a, aVar.b, reportIncidentUtil.a, new com.google.android.libraries.navigation.internal.bn.b() { // from class: com.google.android.libraries.navigation.internal.dx.g
                @Override // com.google.android.libraries.navigation.internal.bn.b
                public final void a(ah ahVar) {
                    this.a(reportIncidentUtil.f(ahVar, xVarB, xVarD));
                }
            });
            ahVarF = ahVarA == null ? null : reportIncidentUtil.f(ahVarA, xVarB, xVarD);
        }
        if (ahVarF == null) {
            ahVarF = aj.c();
            Intrinsics.checkNotNullExpressionValue(ahVarF, "emptyDrawable(...)");
        }
        this.a = ahVarF;
    }

    @Override // com.google.android.libraries.navigation.internal.bn.b
    public final void a(ah icon) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.a = icon;
        com.google.android.libraries.navigation.internal.bn.b bVar = this.e;
        if (bVar != null) {
            bVar.a(icon);
        }
    }

    public final void b(com.google.android.libraries.navigation.internal.bn.b iconListener) {
        Intrinsics.checkNotNullParameter(iconListener, "iconListener");
        this.e = iconListener;
    }
}
