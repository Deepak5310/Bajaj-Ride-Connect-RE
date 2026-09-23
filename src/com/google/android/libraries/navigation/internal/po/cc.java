package com.google.android.libraries.navigation.internal.po;

import android.view.KeyEvent;
import android.view.View;
import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cc implements View.OnKeyListener {
    private final Map a = new HashMap();
    private final com.google.android.libraries.navigation.internal.pn.u b;

    public cc(com.google.android.libraries.navigation.internal.pn.u uVar) {
        this.b = uVar;
        a(cb.PAN_UP, 19);
        a(cb.PAN_DOWN, 20);
        a(cb.PAN_RIGHT, 22);
        a(cb.PAN_LEFT, 21);
        a(cb.ZOOM_IN, 157, 70, 81);
        a(cb.ZOOM_OUT, NikonType2MakernoteDirectory.TAG_SCENE_ASSIST, 69);
    }

    private final void a(cb cbVar, int... iArr) {
        for (int i : iArr) {
            this.a.put(Integer.valueOf(i), cbVar);
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        this.b.b();
        return false;
    }
}
