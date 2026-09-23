package com.mappls.sdk.traffic;

import android.content.Context;
import android.provider.Settings;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.NavigationContext;
import com.mappls.sdk.traffic.api.MapplsBeacon;
import com.mappls.sdk.traffic.db.BeaconDatabase;
import com.mappls.sdk.traffic.model.BeaconPacket;
import com.mappls.sdk.traffic.model.ProbeWrapper;
import java.util.ArrayList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.ResponseBody;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
@DebugMetadata(c = "com.mappls.sdk.traffic.LocationStorage$sendLocation$1", f = "LocationStorage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ a a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    b(a aVar, Continuation<? super b> continuation) {
        super(2, continuation);
        this.a = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new b(this.a, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        com.mappls.sdk.traffic.db.dao.a aVarA;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        BeaconDatabase beaconDatabaseE = NavigationContext.getNavigationContext().e();
        if (beaconDatabaseE != null && (aVarA = beaconDatabaseE.a()) != null) {
            a aVar = this.a;
            ArrayList arrayListA = aVarA.a();
            if (arrayListA.size() <= 0) {
                a.c(aVar);
            } else {
                if (aVar.c() == null) {
                    return Unit.INSTANCE;
                }
                BeaconPacket beaconPacket = new BeaconPacket();
                ArrayList arrayList = new ArrayList();
                ProbeWrapper probeWrapper = new ProbeWrapper();
                Context context = aVar.c;
                Intrinsics.checkNotNull(context);
                probeWrapper.setDeviceId(Settings.Secure.getString(context.getContentResolver(), "android_id"));
                arrayList.add(probeWrapper);
                probeWrapper.setGps(arrayListA);
                beaconPacket.setProbes(arrayList);
                MapplsBeacon.Builder builderC = MapplsBeacon.c();
                if (MapplsNavigationHelper.getInstance().getBaseRes() != null) {
                    builderC.baseUrl(MapplsNavigationHelper.getInstance().getBaseRes());
                }
                try {
                    Response<ResponseBody> responseExecuteCall = builderC.beaconKey(aVar.c()).beaconPacket(beaconPacket).build().executeCall();
                    Intrinsics.checkNotNullExpressionValue(responseExecuteCall, "executeCall(...)");
                    int iCode = responseExecuteCall.code();
                    if (200 > iCode || iCode >= 404) {
                        a.b(aVar);
                    } else {
                        aVar.d = System.currentTimeMillis();
                        Intrinsics.checkNotNull(arrayListA);
                        a.a(aVar, arrayListA);
                        a.d(aVar);
                    }
                } catch (Exception unused) {
                    a.b(aVar);
                }
            }
        }
        return Unit.INSTANCE;
    }
}
