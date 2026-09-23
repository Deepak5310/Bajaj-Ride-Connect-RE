package com.mappls.sdk.plugins.places.autocomplete.data.entity;

import com.mappls.sdk.services.api.autosuggest.model.ELocation;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private final String a;
    private final ELocation b;
    private Long c;
    private final String d;
    private final String e;
    private final String f;

    public a(String str, ELocation eLocation, String str2, String str3, String str4, long j) {
        this.a = str;
        this.b = eLocation;
        this.c = Long.valueOf(j);
        this.f = str4;
        this.d = str2;
        this.e = str3;
    }

    public final String a() {
        return this.f;
    }

    public final ELocation b() {
        return this.b;
    }

    public final String c() {
        return this.e;
    }

    public final String d() {
        return this.a;
    }

    public final String e() {
        return this.d;
    }

    public final Long f() {
        return this.c;
    }
}
