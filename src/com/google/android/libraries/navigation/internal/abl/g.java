package com.google.android.libraries.navigation.internal.abl;

import android.graphics.Bitmap;
import com.google.common.net.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class g extends com.google.android.libraries.navigation.internal.c.m {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f129n;

    public g(String str, com.google.android.libraries.navigation.internal.b.y yVar, String str2) {
        super(str, yVar, Bitmap.Config.ARGB_8888, i.b);
        this.f129n = str2;
    }

    @Override // com.google.android.libraries.navigation.internal.b.t
    public final Map e() throws com.google.android.libraries.navigation.internal.b.a {
        HashMap map = new HashMap();
        map.put(HttpHeaders.USER_AGENT, this.f129n);
        return map;
    }
}
