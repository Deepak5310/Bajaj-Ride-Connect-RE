package com.google.android.libraries.mapsplatform.turnbyturn;

import android.os.Bundle;
import com.google.android.libraries.mapsplatform.turnbyturn.model.NavInfo;
import com.google.android.libraries.navigation.internal.wy.d;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public abstract class TurnByTurnManager {
    public static final int MSG_NAV_INFO = 7200;

    public static TurnByTurnManager createInstance() {
        return new d();
    }

    public abstract NavInfo readNavInfoFromBundle(Bundle bundle);

    public abstract Bundle writeNavInfoToBundle(NavInfo navInfo);
}
