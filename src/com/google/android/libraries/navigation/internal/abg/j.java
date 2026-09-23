package com.google.android.libraries.navigation.internal.abg;

import android.graphics.Bitmap;
import androidx.collection.LruCache;
import com.google.android.libraries.navigation.internal.b.z;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j extends LruCache {
    public j(int i) {
        super(i);
    }

    @Override // androidx.collection.LruCache
    protected final /* bridge */ /* synthetic */ int sizeOf(Object obj, Object obj2) {
        Object obj3 = ((z) obj2).a;
        if (obj3 instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj3;
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
        if (obj3 instanceof String) {
            return ((String) obj3).getBytes().length;
        }
        if (obj3 instanceof byte[]) {
            return ((byte[]) obj3).length;
        }
        throw new IllegalStateException("LruCache does not have a sizeOf implementation for: ".concat(String.valueOf(String.valueOf(obj3))));
    }
}
