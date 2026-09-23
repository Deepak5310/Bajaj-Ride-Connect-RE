package com.google.android.libraries.navigation.internal.yz;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class at extends ae implements mh {
    private static final long serialVersionUID = 7431625294878419160L;

    protected at(Map map) {
        super(map);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.mh
    public final Set D(Object obj) {
        return (Set) super.d(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ae
    public /* bridge */ /* synthetic */ Collection a() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ae
    public final /* synthetic */ Collection b() {
        return Collections.emptySet();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ae, com.google.android.libraries.navigation.internal.yz.kd
    public final /* bridge */ /* synthetic */ Collection d(Object obj) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ae
    public Collection e(Collection collection) {
        return Collections.unmodifiableSet((Set) collection);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ae
    public Collection f(Object obj, Collection collection) {
        return new ac(this, obj, (Set) collection);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.an, com.google.android.libraries.navigation.internal.yz.kd
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final Set u() {
        return (Set) super.u();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ae, com.google.android.libraries.navigation.internal.yz.kd
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Set c(Object obj) {
        return (Set) super.c(obj);
    }
}
