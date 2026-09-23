package com.google.android.libraries.places.internal;

import com.facebook.react.animated.InterpolationAnimatedNode;
import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzasq implements zzasr {
    public static final zzasr zza = new zzasq();

    private zzasq() {
    }

    @Override // com.google.android.libraries.places.internal.zzate
    public final InputStream zza(InputStream inputStream) {
        return inputStream;
    }

    @Override // com.google.android.libraries.places.internal.zzass, com.google.android.libraries.places.internal.zzate
    public final String zzb() {
        return InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY;
    }
}
