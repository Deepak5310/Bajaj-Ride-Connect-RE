package com.google.android.libraries.navigation.internal.yz;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class j extends ae implements ho {
    private static final long serialVersionUID = 6588350623831699109L;

    protected j(Map map) {
        super(map);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ae
    public /* bridge */ /* synthetic */ Collection a() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ae
    public final /* synthetic */ Collection b() {
        return Collections.emptyList();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ae, com.google.android.libraries.navigation.internal.yz.kd
    public final /* bridge */ /* synthetic */ Collection d(Object obj) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ae
    public final Collection e(Collection collection) {
        return Collections.unmodifiableList((List) collection);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ae
    public final Collection f(Object obj, Collection collection) {
        return n(obj, (List) collection, null);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ae, com.google.android.libraries.navigation.internal.yz.kd
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final List c(Object obj) {
        return (List) super.c(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ho
    public final List h(Object obj) {
        return (List) super.d(obj);
    }
}
