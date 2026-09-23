package com.mappls.sdk.plugins.places.autocomplete.model;

import com.mappls.sdk.services.api.autosuggest.model.ELocation;
import com.mappls.sdk.services.api.autosuggest.model.SuggestedSearchAtlas;

/* JADX INFO: loaded from: classes4.dex */
public final class d {
    private ELocation a;
    private SuggestedSearchAtlas b;
    private final int c;
    private MapplsFavoritePlace d;

    public d(MapplsFavoritePlace mapplsFavoritePlace) {
        this.d = mapplsFavoritePlace;
        this.c = 3;
    }

    public d(ELocation eLocation, int i) {
        this.a = eLocation;
        this.c = i;
    }

    public d(SuggestedSearchAtlas suggestedSearchAtlas) {
        this.b = suggestedSearchAtlas;
        this.c = 4;
    }

    public final MapplsFavoritePlace a() {
        return this.d;
    }

    public final SuggestedSearchAtlas b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    public final ELocation d() {
        return this.a;
    }
}
