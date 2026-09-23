package com.google.android.libraries.navigation.internal.qz;

import android.graphics.Bitmap;
import com.google.android.libraries.navigation.internal.yx.aa;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class c extends f {
    final /* synthetic */ k a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(k kVar) {
        super(kVar);
        this.a = kVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qz.f
    protected final /* synthetic */ aa a(Object obj) {
        final Bitmap bitmap = (Bitmap) obj;
        return new aa() { // from class: com.google.android.libraries.navigation.internal.qz.a
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj2) {
                return new b(new Object[]{this.a.a.f}, bitmap);
            }
        };
    }
}
