package com.google.android.libraries.navigation.internal.my;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends f {
    @Override // com.google.android.libraries.navigation.internal.my.f
    protected final Reference a(Object obj, ReferenceQueue referenceQueue) {
        return new SoftReference(obj, referenceQueue);
    }
}
