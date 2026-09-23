package com.google.android.libraries.navigation.internal.j;

import android.media.audiofx.AudioEffect;
import com.google.android.libraries.navigation.internal.zb.h;
import com.google.android.libraries.navigation.internal.zb.j;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    private static final j a = j.e("com.google.android.libraries.navigation.internal.j.a");

    public static boolean a() {
        try {
            AudioEffect.Descriptor[] descriptorArrQueryEffects = AudioEffect.queryEffects();
            if (descriptorArrQueryEffects != null) {
                for (AudioEffect.Descriptor descriptor : descriptorArrQueryEffects) {
                    if (descriptor.type.equals(AudioEffect.EFFECT_TYPE_LOUDNESS_ENHANCER)) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            ((h) ((h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).g(th)).F((char) 1)).o();
        }
        return false;
    }
}
