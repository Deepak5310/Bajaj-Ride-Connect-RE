package com.mappls.sdk.navigation;

import android.content.Context;
import com.mappls.sdk.navigation.apis.NavigationLogger;
import com.mappls.sdk.navigation.gpx.GpxSelectionHelper;
import com.mappls.sdk.navigation.util.SavingTrackHelper;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements g {
    private Context a;
    private long c;
    private boolean b = false;
    private ArrayList d = new ArrayList();
    private ArrayList e = new ArrayList();
    private boolean f = false;

    final class a implements Runnable {
        a(d dVar) {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator it2 = c.this.e.iterator();
            while (it2.hasNext()) {
                ((InterfaceC0094c) it2.next()).b();
            }
        }
    }

    final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                c.b(c.this);
            } finally {
                c.this.f = false;
            }
        }
    }

    /* JADX INFO: renamed from: com.mappls.sdk.navigation.c$c, reason: collision with other inner class name */
    interface InterfaceC0094c {
        void a();

        void b();
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class d {
        public static final d a = new d("TASK_CHANGED", 0);
        public static final d b = new d("SAVE_GPX_TRACKS", 1);
        public static final d c = new d("LOAD_GPX_TRACKS", 2);

        private d(String str, int i) {
            super(str, i);
        }
    }

    c(Context context) {
        this.a = context;
    }

    static void b(c cVar) {
        NavigationContext navigationContext;
        boolean zIsEmpty;
        cVar.getClass();
        boolean z = true;
        try {
            cVar.c = System.currentTimeMillis();
            cVar.a(d.c);
            cVar.d();
            cVar.a(d.b);
            cVar.getClass();
            NavigationContext.getNavigationContext().g.post(new com.mappls.sdk.navigation.b(cVar));
            if (cVar.d != null) {
                if (zIsEmpty) {
                    return;
                }
                navigationContext = NavigationContext.getNavigationContext();
                Iterator it2 = cVar.d.iterator();
                while (zHasNext) {
                    if (z) {
                        z = false;
                    }
                }
            }
        } catch (RuntimeException e) {
            NavigationLogger.d(e);
            cVar.d.add(e.getMessage());
            cVar.getClass();
            NavigationContext.getNavigationContext().g.post(new com.mappls.sdk.navigation.b(cVar));
            if (cVar.d == null) {
            }
        } finally {
            cVar.getClass();
            NavigationContext.getNavigationContext().g.post(new com.mappls.sdk.navigation.b(cVar));
            ArrayList arrayList = cVar.d;
            if (arrayList != null && !arrayList.isEmpty()) {
                navigationContext = NavigationContext.getNavigationContext();
                for (String str : cVar.d) {
                    if (z) {
                        z = false;
                    }
                }
                navigationContext.q();
            }
        }
    }

    private void d() {
        if (NavigationContext.getNavigationContext().h.hasDataToSave()) {
            if (System.currentTimeMillis() - NavigationContext.getNavigationContext().h.getLastTrackPointTime() >= 1800000) {
                this.a.getString(R.string.mappls_saving_gpx_tracks);
                a(d.a);
                try {
                    ArrayList arrayList = this.d;
                    SavingTrackHelper savingTrackHelper = NavigationContext.getNavigationContext().h;
                    NavigationContext.getNavigationContext().f.getClass();
                    arrayList.addAll(savingTrackHelper.saveDataToGpx(NavigationContext.getNavigationContext().d()));
                } catch (RuntimeException e) {
                    NavigationLogger.d(e);
                    this.d.add(e.getMessage());
                }
            } else {
                NavigationContext.getNavigationContext().h.loadGpxFromDatabase();
            }
        }
        if (!NavigationContext.getNavigationContext().k().x.get().booleanValue() || q.a() == null) {
            return;
        }
        int iIntValue = NavigationContext.getNavigationContext().k().y.get().intValue();
        NavigationContext navigationContext = NavigationContext.getNavigationContext();
        int i = NavigationService.o;
        if (iIntValue < 30000) {
            iIntValue = 0;
        }
        navigationContext.a(2, iIntValue);
    }

    final void a() {
        if (this.b) {
            return;
        }
        this.b = true;
    }

    final synchronized void a(Context context, String str) {
        new Thread(new com.mappls.sdk.navigation.a(str, context, null)).start();
    }

    public final void a(d dVar) {
        if (dVar != d.a) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            NavigationLogger.d("Initialized " + dVar + " in " + (jCurrentTimeMillis - this.c) + " ms", new Object[0]);
            this.c = jCurrentTimeMillis;
        }
        NavigationContext.getNavigationContext().g.post(new a(dVar));
    }

    final void c() {
        s sVarK = NavigationContext.getNavigationContext().k();
        if (!((Boolean) sVarK.s0.get()).booleanValue()) {
            s.t<com.mappls.sdk.navigation.d> tVar = sVarK.I0;
            com.mappls.sdk.navigation.d dVar = com.mappls.sdk.navigation.d.i;
            s.g gVar = (s.g) tVar;
            gVar.getClass();
            gVar.set(dVar);
        }
        NavigationContext navigationContext = NavigationContext.getNavigationContext();
        com.mappls.sdk.navigation.routing.d dVar2 = new com.mappls.sdk.navigation.routing.d(this.a);
        System.currentTimeMillis();
        navigationContext.l = dVar2;
        NavigationContext navigationContext2 = NavigationContext.getNavigationContext();
        com.mappls.sdk.navigation.session.a aVar = new com.mappls.sdk.navigation.session.a(this.a);
        System.currentTimeMillis();
        navigationContext2.m = aVar;
        NavigationContext navigationContext3 = NavigationContext.getNavigationContext();
        com.mappls.sdk.navigation.util.b bVar = new com.mappls.sdk.navigation.util.b();
        System.currentTimeMillis();
        navigationContext3.k = bVar;
        NavigationContext navigationContext4 = NavigationContext.getNavigationContext();
        NavigationLocationProvider navigationLocationProvider = new NavigationLocationProvider(this.a);
        System.currentTimeMillis();
        navigationContext4.j = navigationLocationProvider;
        NavigationContext navigationContext5 = NavigationContext.getNavigationContext();
        SavingTrackHelper savingTrackHelper = new SavingTrackHelper(this.a);
        System.currentTimeMillis();
        navigationContext5.h = savingTrackHelper;
        NavigationContext navigationContext6 = NavigationContext.getNavigationContext();
        new GpxSelectionHelper(this.a, NavigationContext.getNavigationContext().h);
        System.currentTimeMillis();
        navigationContext6.getClass();
        NavigationContext navigationContext7 = NavigationContext.getNavigationContext();
        NotificationHelper notificationHelper = new NotificationHelper(this.a);
        System.currentTimeMillis();
        navigationContext7.o = notificationHelper;
        NavigationContext navigationContext8 = NavigationContext.getNavigationContext();
        com.mappls.sdk.navigation.helpers.b bVar2 = new com.mappls.sdk.navigation.helpers.b();
        System.currentTimeMillis();
        navigationContext8.r = bVar2;
        NavigationContext navigationContext9 = NavigationContext.getNavigationContext();
        w wVar = new w(this.a);
        System.currentTimeMillis();
        navigationContext9.p = wVar;
        NavigationContext navigationContext10 = NavigationContext.getNavigationContext();
        com.mappls.sdk.navigation.refresh.i iVar = new com.mappls.sdk.navigation.refresh.i();
        System.currentTimeMillis();
        navigationContext10.q = iVar;
    }

    final synchronized void e() {
        if (this.f) {
            return;
        }
        this.f = true;
        new Thread(new b(), "Initializing app").start();
    }

    public final void b() {
        NavigationContext navigationContext = NavigationContext.getNavigationContext();
        Context context = this.a;
        String str = (String) navigationContext.e.x0.get();
        if (navigationContext.f705n == null || !com.mappls.sdk.navigation.util.a.a(str, (Object) null)) {
            navigationContext.b.a(context, str);
        }
    }
}
