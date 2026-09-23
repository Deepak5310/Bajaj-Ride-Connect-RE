package com.mappls.sdk.navigation.tracks;

import android.app.Application;
import android.content.Context;
import com.mappls.sdk.navigation.NavigationContext;
import com.mappls.sdk.navigation.NavigationService;
import com.mappls.sdk.navigation.d;
import com.mappls.sdk.navigation.iface.ISaveTrackListener;
import com.mappls.sdk.navigation.q;
import com.mappls.sdk.navigation.s;
import com.mappls.sdk.navigation.t;
import com.mappls.sdk.navigation.util.SavingTrackHelper;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends q {
    private s c;
    private Context d;

    public a(Context context) {
        this.d = context;
        ArrayList arrayListB = d.b();
        d.a((d[]) arrayListB.toArray(new d[arrayListB.size()]));
        this.c = NavigationContext.getNavigationContext().k();
    }

    public final void a(Application application) {
        Integer num = this.c.y.get();
        Boolean bool = this.c.z.get();
        if (bool.booleanValue() || application == null) {
            NavigationContext.getNavigationContext().j().startNewSegment();
            this.c.y.set(num);
            this.c.x.set(Boolean.TRUE);
            this.c.z.set(bool);
            int iIntValue = this.c.y.get().intValue();
            NavigationContext navigationContext = NavigationContext.getNavigationContext();
            int i = NavigationService.o;
            if (iIntValue < 30000) {
                iIntValue = 0;
            }
            navigationContext.a(2, iIntValue);
        }
    }

    public final void a(String str, ISaveTrackListener iSaveTrackListener) {
        NavigationContext.getNavigationContext().n().getClass();
        t.a(new C0103a(str, iSaveTrackListener), null);
    }

    @Override // com.mappls.sdk.navigation.q
    public final void c() {
    }

    @Override // com.mappls.sdk.navigation.q
    public final void d() {
    }

    public final void e() {
        this.c.x.set(Boolean.FALSE);
        NavigationService navigationServiceF = NavigationContext.getNavigationContext().f();
        if (navigationServiceF != null) {
            Context context = this.d;
            int i = NavigationService.o;
            navigationServiceF.a(context, 2);
        }
    }

    /* JADX INFO: renamed from: com.mappls.sdk.navigation.tracks.a$a, reason: collision with other inner class name */
    final class C0103a extends t.b<Void, Object, Object> {
        final /* synthetic */ String a;
        final /* synthetic */ ISaveTrackListener b;

        C0103a(String str, ISaveTrackListener iSaveTrackListener) {
            this.a = str;
            this.b = iSaveTrackListener;
        }

        @Override // com.mappls.sdk.navigation.t.b
        protected final Object a(Void[] voidArr) {
            try {
                SavingTrackHelper savingTrackHelperJ = NavigationContext.getNavigationContext().j();
                String str = this.a;
                if (str == null) {
                    str = "";
                }
                NavigationContext.getNavigationContext().c().getClass();
                savingTrackHelperJ.saveDataToGpx(str, NavigationContext.getNavigationContext().d());
                savingTrackHelperJ.close();
                return null;
            } finally {
                NavigationContext.getNavigationContext().getNotificationHelper().showNotifications();
            }
        }

        @Override // com.mappls.sdk.navigation.t.b
        protected final void a(Object obj) {
            a.this.getClass();
            a.this.getClass();
            ISaveTrackListener iSaveTrackListener = this.b;
            if (iSaveTrackListener != null) {
                iSaveTrackListener.onSuccess();
            }
        }

        @Override // com.mappls.sdk.navigation.t.b
        protected final void a() {
            a.this.getClass();
            a.this.getClass();
        }
    }
}
