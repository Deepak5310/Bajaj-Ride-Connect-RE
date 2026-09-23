package com.mappls.sdk.traffic;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import androidx.work.PeriodicWorkRequest;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.NavigationContext;
import com.mappls.sdk.traffic.db.BeaconDatabase;
import com.mappls.sdk.traffic.db.ProbeLocation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static a h;
    private final ArrayList a = new ArrayList();
    private String b;
    private Context c;
    private long d;
    private long e;
    private final Handler f;
    private final Runnable g;

    /* JADX INFO: renamed from: com.mappls.sdk.traffic.a$a, reason: collision with other inner class name */
    @DebugMetadata(c = "com.mappls.sdk.traffic.LocationStorage$addLocation$1$1", f = "LocationStorage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C0116a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.mappls.sdk.traffic.db.dao.a a;
        final /* synthetic */ List<ProbeLocation> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0116a(com.mappls.sdk.traffic.db.dao.a aVar, List<ProbeLocation> list, Continuation<? super C0116a> continuation) {
            super(2, continuation);
            this.a = aVar;
            this.b = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C0116a(this.a, this.b, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C0116a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            this.a.b(this.b);
            return Unit.INSTANCE;
        }
    }

    public a() {
        Looper looperMyLooper = Looper.myLooper();
        Intrinsics.checkNotNull(looperMyLooper);
        this.f = new Handler(looperMyLooper);
        this.g = new Runnable() { // from class: com.mappls.sdk.traffic.a$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                a.f(this.f$0);
            }
        };
    }

    public static final void a(a aVar, List list) {
        com.mappls.sdk.traffic.db.dao.a aVarA;
        BeaconDatabase beaconDatabaseE = NavigationContext.getNavigationContext().e();
        if (beaconDatabaseE == null || (aVarA = beaconDatabaseE.a()) == null) {
            return;
        }
        aVarA.a(list);
    }

    public static final void b(a aVar) {
        aVar.f.removeCallbacksAndMessages(null);
        aVar.f.postDelayed(aVar.g, PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
    }

    public static final void c(a aVar) {
        aVar.f.removeCallbacksAndMessages(null);
        aVar.f.postDelayed(aVar.g, PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
    }

    public static final void d(a aVar) {
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new b(aVar, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(a this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getClass();
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new b(this$0, null), 2, null);
    }

    public final void a(Context context) {
        this.c = context;
        this.b = "odlsdnhdgtropfns78bDSQLP";
    }

    public final String c() {
        return this.b;
    }

    public static final a b() {
        if (h == null) {
            h = new a();
        }
        return h;
    }

    public final void a(Location pLocation) {
        com.mappls.sdk.traffic.db.dao.a aVarA;
        Intrinsics.checkNotNullParameter(pLocation, "pLocation");
        if (MapplsNavigationHelper.getInstance().isTrafficProbeEnabled()) {
            this.a.add(pLocation);
            if (System.currentTimeMillis() - this.e >= 120000 || this.a.size() >= 20) {
                ArrayList arrayList = new ArrayList(this.a.size());
                Iterator it2 = this.a.iterator();
                while (it2.hasNext()) {
                    arrayList.add(new ProbeLocation((Location) it2.next()));
                }
                BeaconDatabase beaconDatabaseE = NavigationContext.getNavigationContext().e();
                if (beaconDatabaseE == null || (aVarA = beaconDatabaseE.a()) == null) {
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new C0116a(aVarA, arrayList, null), 2, null);
                this.a.clear();
                this.e = System.currentTimeMillis();
                if (System.currentTimeMillis() - this.d >= PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
                    BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new b(this, null), 2, null);
                }
            }
        }
    }
}
