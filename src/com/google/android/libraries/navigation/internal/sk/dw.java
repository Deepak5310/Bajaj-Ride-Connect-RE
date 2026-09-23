package com.google.android.libraries.navigation.internal.sk;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import com.reactnativekeyboardcontroller.views.background.ImePackages;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dw {
    public static final TextToSpeech a(Context context, TextToSpeech.OnInitListener onInitListener) {
        return new TextToSpeech(context, onInitListener, ImePackages.GOOGLE_TTS);
    }
}
