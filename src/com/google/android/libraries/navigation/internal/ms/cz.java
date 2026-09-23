package com.google.android.libraries.navigation.internal.ms;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cz implements View.OnTouchListener {
    public final Map a = new LinkedHashMap();

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        ev evVarO = ev.o(this.a.values());
        boolean zOnTouch = false;
        for (int i = 0; i < evVarO.size(); i++) {
            zOnTouch |= ((View.OnTouchListener) evVarO.get(i)).onTouch(view, motionEvent);
        }
        return zOnTouch;
    }
}
