package com.google.android.libraries.navigation.internal.abl;

import com.google.common.net.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class h extends com.google.android.libraries.navigation.internal.c.q {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f130n;

    public h(String str, com.google.android.libraries.navigation.internal.b.y yVar, String str2) {
        super(str, yVar, i.b);
        this.f130n = str2;
    }

    @Override // com.google.android.libraries.navigation.internal.b.t
    public final Map e() throws com.google.android.libraries.navigation.internal.b.a {
        HashMap map = new HashMap();
        map.put(HttpHeaders.USER_AGENT, this.f130n);
        return map;
    }
}
