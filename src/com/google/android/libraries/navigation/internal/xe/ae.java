package com.google.android.libraries.navigation.internal.xe;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.google.android.libraries.mapsplatform.turnbyturn.TurnByTurnManager;
import com.google.android.libraries.mapsplatform.turnbyturn.model.NavInfo;
import com.google.android.libraries.mapsplatform.turnbyturn.model.StepInfo;
import com.google.android.libraries.navigation.NavigationUpdatesOptions;
import com.google.android.libraries.navigation.Navigator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ae {
    public final Navigator a;
    public final Context b;
    public final com.google.android.libraries.navigation.internal.vp.d c;
    public final gf d;
    public Messenger e;
    public NavigationUpdatesOptions g;
    public StepInfo[] j;
    public int k;
    private TurnByTurnManager m;
    public final Navigator.ReroutingListener h = new Navigator.ReroutingListener() { // from class: com.google.android.libraries.navigation.internal.xe.aa
        @Override // com.google.android.libraries.navigation.Navigator.ReroutingListener
        public final void onReroutingRequestedByOffRoute() {
            ae aeVar = this.a;
            if (aeVar.f) {
                NavInfo.Builder builder = NavInfo.builder();
                builder.setNavState(2);
                aeVar.b(builder.build());
            }
        }
    };
    public final Navigator.RouteChangedListener i = new Navigator.RouteChangedListener() { // from class: com.google.android.libraries.navigation.internal.xe.ab
        @Override // com.google.android.libraries.navigation.Navigator.RouteChangedListener
        public final void onRouteChanged() {
            this.a.j = null;
        }
    };
    public final ServiceConnection l = new ad(this);
    public boolean f = false;

    public ae(Navigator navigator, Context context, com.google.android.libraries.navigation.internal.vp.d dVar, gf gfVar) {
        this.a = navigator;
        this.b = context;
        this.c = dVar;
        this.d = gfVar;
    }

    final void a() {
        this.e = null;
        this.f = false;
        this.k = 0;
        this.j = null;
        ((com.google.android.libraries.navigation.internal.vw.j) this.c).l = null;
        this.a.removeReroutingListener(this.h);
        this.a.removeRouteChangedListener(this.i);
        this.g = null;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void b(NavInfo navInfo) {
        if (this.e == null || !this.f) {
            return;
        }
        if (this.m == null) {
            this.m = TurnByTurnManager.createInstance();
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = TurnByTurnManager.MSG_NAV_INFO;
        Bundle bundle = new Bundle();
        com.google.android.libraries.navigation.internal.wy.a aVarA = com.google.android.libraries.navigation.internal.wy.a.a();
        bundle.putIntegerArrayList("ni_0", aVarA.c.a(navInfo.getNavState()));
        if (navInfo.getCurrentStep() != null) {
            bundle.putBundle("ni_1", com.google.android.libraries.navigation.internal.wy.d.a(navInfo.getCurrentStep()));
        }
        Bundle[] bundleArr = new Bundle[navInfo.getRemainingSteps().length];
        for (int i = 0; i < navInfo.getRemainingSteps().length; i++) {
            bundleArr[i] = com.google.android.libraries.navigation.internal.wy.d.a(navInfo.getRemainingSteps()[i]);
        }
        bundle.putParcelableArray("ni_2", bundleArr);
        bundle.putBoolean("ni_3", navInfo.getRouteChanged());
        com.google.android.libraries.navigation.internal.wy.d.c(bundle, "ni_4", navInfo.getTimeToCurrentStepSeconds());
        com.google.android.libraries.navigation.internal.wy.d.c(bundle, "ni_5", navInfo.getDistanceToCurrentStepMeters());
        com.google.android.libraries.navigation.internal.wy.d.c(bundle, "ni_8", navInfo.getTimeToNextDestinationSeconds());
        com.google.android.libraries.navigation.internal.wy.d.c(bundle, "ni_9", navInfo.getDistanceToNextDestinationMeters());
        com.google.android.libraries.navigation.internal.wy.d.c(bundle, "ni_6", navInfo.getTimeToFinalDestinationSeconds());
        com.google.android.libraries.navigation.internal.wy.d.c(bundle, "ni_7", navInfo.getDistanceToFinalDestinationMeters());
        messageObtain.setData(bundle);
        try {
            this.e.send(messageObtain);
        } catch (RemoteException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 2001)).p("Could not send nav info to the service.");
        }
    }

    final void c() {
        if (this.f) {
            NavInfo.Builder builder = NavInfo.builder();
            builder.setNavState(3);
            b(builder.build());
        }
    }
}
