package com.mappls.sdk.direction.ui.event;

import com.mappls.sdk.services.api.event.route.model.ReportDetails;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public final class c implements d {
    private final String a;
    private final String b;
    private final int c;
    private final boolean d;
    private final ArrayList<ReportDetails> e;

    public c(String str, ArrayList<ReportDetails> arrayList, String str2, int i, boolean z) {
        this.a = str;
        this.b = str2;
        this.d = z;
        this.c = i;
        this.e = arrayList;
    }

    @Override // com.mappls.sdk.direction.ui.event.d
    public final int a() {
        return 1;
    }

    public final String b() {
        return this.a;
    }

    public final String c() {
        return this.b;
    }

    public final ArrayList<ReportDetails> d() {
        return this.e;
    }

    public final int e() {
        return this.c;
    }

    public final boolean f() {
        return this.d;
    }
}
