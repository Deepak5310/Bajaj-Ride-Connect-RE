package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.ArrivalEvent;
import com.google.android.libraries.navigation.Navigator;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class gp implements Navigator.ArrivalListener, Navigator.NavigationSessionListener, Navigator.ReroutingListener, Navigator.RemainingTimeOrDistanceChangedListener, Navigator.TrafficUpdatedListener, fa {
    private static final com.google.android.libraries.navigation.internal.zb.j d = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.xe.gp");
    public final fi a;
    public final gv b;
    public final ExecutorService c;
    private final Executor e;
    private final com.google.android.libraries.navigation.internal.aac.al f = new com.google.android.libraries.navigation.internal.aac.al();

    public gp(fi fiVar, gv gvVar, Executor executor, ExecutorService executorService) {
        this.a = fiVar;
        this.b = gvVar;
        this.e = executor;
        this.c = executorService;
    }

    @Override // com.google.android.libraries.navigation.internal.xe.fa
    public final void a(com.google.android.libraries.navigation.internal.bp.bg bgVar) {
        this.b.h(bgVar);
    }

    @Override // com.google.android.libraries.navigation.Navigator.ArrivalListener
    public final void onArrival(ArrivalEvent arrivalEvent) {
        if (arrivalEvent.isFinalDestination()) {
            this.b.f(true);
        }
    }

    @Override // com.google.android.libraries.navigation.Navigator.NavigationSessionListener
    public final void onNewNavigationSession() {
        this.b.f(false);
    }

    @Override // com.google.android.libraries.navigation.Navigator.RemainingTimeOrDistanceChangedListener
    public final void onRemainingTimeOrDistanceChanged() {
        com.google.android.libraries.navigation.internal.aac.az.o(this.f.a(new com.google.android.libraries.navigation.internal.aac.s() { // from class: com.google.android.libraries.navigation.internal.xe.gm
            /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.libraries.navigation.internal.aac.bm, java.util.concurrent.ExecutorService] */
            @Override // com.google.android.libraries.navigation.internal.aac.s
            public final com.google.android.libraries.navigation.internal.aac.bj a() {
                gp gpVar = this.a;
                final fi fiVar = gpVar.a;
                Objects.requireNonNull(fiVar);
                return gpVar.c.submit(new Callable() { // from class: com.google.android.libraries.navigation.internal.xe.gn
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return fiVar.getTimeAndDistanceList();
                    }
                });
            }
        }, this.c), new go(this), this.e);
    }

    @Override // com.google.android.libraries.navigation.Navigator.ReroutingListener
    public final void onReroutingRequestedByOffRoute() {
        this.b.h(this.a.c().e);
    }

    @Override // com.google.android.libraries.navigation.Navigator.TrafficUpdatedListener
    public final void onTrafficUpdated() {
        this.b.h(this.a.c().e);
    }
}
