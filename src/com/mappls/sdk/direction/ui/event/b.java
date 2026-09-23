package com.mappls.sdk.direction.ui.event;

import com.mappls.sdk.services.api.event.route.model.ReportDetails;

/* JADX INFO: loaded from: classes6.dex */
public final class b implements d {
    private final ReportDetails a;

    public b(ReportDetails reportDetails) {
        this.a = reportDetails;
    }

    @Override // com.mappls.sdk.direction.ui.event.d
    public final int a() {
        return 2;
    }

    public final ReportDetails b() {
        return this.a;
    }
}
