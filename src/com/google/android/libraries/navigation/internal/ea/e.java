package com.google.android.libraries.navigation.internal.ea;

import com.google.android.libraries.navigation.internal.tj.u;
import com.google.android.libraries.navigation.internal.uc.k;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.al;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class e {
    public final boolean a;
    public final u b;
    public final k c;
    public final g d;
    public final d e;
    public final com.google.android.libraries.navigation.internal.si.g f;
    public final boolean g;

    protected e(c cVar) {
        this.a = cVar.a;
        this.b = cVar.b;
        this.c = cVar.c;
        this.d = cVar.d;
        this.e = cVar.f;
        this.f = cVar.g;
        this.g = cVar.h;
    }

    protected final ak a() {
        ak akVarE = al.b(this).e("uiIsRestricted", this.a);
        akVarE.g("prompt", this.b);
        akVarE.g("cameraParameters", this.c);
        akVarE.g("polylineOverride", this.d);
        akVarE.g("searchQuery", null);
        akVarE.g("searchState", this.e);
        akVarE.g("selectedSearchResult", this.f);
        akVarE.g("visibleSearchResults", null);
        return akVarE.e("showUserRatingAlongRoute", false).e("shouldRefreshSearch", false).e("inMiniMode", this.g);
    }
}
