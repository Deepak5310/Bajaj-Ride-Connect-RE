package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.NavigationTransactionRecorder;
import com.google.android.libraries.navigation.Waypoint;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bf implements bd {
    private final Waypoint a;
    private final List b;
    private final NavigationTransactionRecorder c;

    public bf(NavigationTransactionRecorder navigationTransactionRecorder, Waypoint waypoint, List list) {
        this.c = navigationTransactionRecorder;
        this.a = waypoint;
        this.b = list;
    }

    @Override // com.google.android.libraries.navigation.internal.xe.bd
    public final void a() throws NavigationTransactionRecorder.TransactionException {
        this.c.pickup(this.a, this.b);
    }
}
