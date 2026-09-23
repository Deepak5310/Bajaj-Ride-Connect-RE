package com.google.android.libraries.navigation.internal.my;

import com.google.android.libraries.navigation.internal.yx.aa;
import java.util.Collection;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements aa {
    final /* synthetic */ Collection a;

    public c(Collection collection) {
        this.a = collection;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.aa
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Boolean ak(Object obj) {
        return Boolean.valueOf(this.a.add(obj));
    }
}
