package com.mappls.sdk.navigation.refresh;

import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.NavigationContext;
import com.mappls.sdk.navigation.apis.NavigationLogger;
import com.mappls.sdk.navigation.apis.junction.MapplsGetJunction;
import com.mappls.sdk.navigation.apis.junction.MapplsGetJunctionName;
import com.mappls.sdk.navigation.model.Junction;
import com.mappls.sdk.navigation.model.JunctionApiResponse;
import com.mappls.sdk.services.api.directions.models.RouteOptions;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private MapplsGetJunction a;
    private int c = 5;
    private boolean d = false;
    private int e = 0;
    private boolean b = ((Boolean) NavigationContext.getNavigationContext().k().J.get()).booleanValue();

    final class a implements Callback<JunctionApiResponse> {
        a() {
        }

        @Override // retrofit2.Callback
        public final void onFailure(Call<JunctionApiResponse> call, Throwable th) {
            NavigationLogger.e(th);
        }

        @Override // retrofit2.Callback
        public final void onResponse(Call<JunctionApiResponse> call, Response<JunctionApiResponse> response) {
            if (!response.isSuccessful() || response.body() == null) {
                return;
            }
            JunctionApiResponse junctionApiResponseBody = response.body();
            NavigationContext.getNavigationContext().h().k().setJunctionViews(junctionApiResponseBody);
            NavigationContext.getNavigationContext().o().a(5);
            try {
                c.a(c.this, junctionApiResponseBody.data);
                c cVar = c.this;
                c.b(cVar, junctionApiResponseBody.data.subList(cVar.e, c.this.c));
            } catch (Exception e) {
                NavigationLogger.e(e);
            }
        }
    }

    private class b extends AsyncTask<List<Junction>, Void, List<Junction>> {
        private b() {
        }

        /* synthetic */ b(c cVar, int i) {
            this();
        }

        @Override // android.os.AsyncTask
        protected final List<Junction> doInBackground(List<Junction>[] listArr) {
            List<Junction>[] listArr2 = listArr;
            if (listArr2.length <= 0) {
                return null;
            }
            c.this.d = true;
            List<Junction> list = listArr2[0];
            HashMap map = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(list.get(i).image);
                map.put(list.get(i).image, list.get(i));
            }
            try {
                MapplsGetJunctionName.Builder builder = MapplsGetJunctionName.builder();
                if (MapplsNavigationHelper.getInstance().getBaseRes() != null) {
                    builder.baseUrl(MapplsNavigationHelper.getInstance().getBaseRes() + "apis/O2O/");
                }
                Response<Map<String, String>> responseExecuteCall = builder.imageName(arrayList).junctionViewMode(MapplsNavigationHelper.getInstance().getJunctionViewMode()).size(MapplsNavigationHelper.getInstance().getJunctionViewImageSize()).build().executeCall();
                if (!responseExecuteCall.isSuccessful() || responseExecuteCall.body() == null) {
                    return null;
                }
                for (Map.Entry<String, String> entry : responseExecuteCall.body().entrySet()) {
                    Response<ResponseBody> responseExecute = com.mappls.sdk.navigation.apis.web.b.a().b().a(entry.getValue()).execute();
                    if (responseExecute.isSuccessful()) {
                        InputStream inputStreamByteStream = responseExecute.body().byteStream();
                        if (map.get(entry.getKey()) != null) {
                            ((Junction) map.get(entry.getKey())).setBitmap(BitmapFactory.decodeStream(inputStreamByteStream));
                        }
                    } else if (responseExecute.code() == 403) {
                        new ArrayList().add(entry.getKey());
                        for (Map.Entry<String, String> entry2 : MapplsGetJunctionName.builder().imageName(arrayList).junctionViewMode(MapplsNavigationHelper.getInstance().getJunctionViewMode()).size(MapplsNavigationHelper.getInstance().getJunctionViewImageSize()).build().executeCall().body().entrySet()) {
                            if (com.mappls.sdk.navigation.apis.web.b.a().b().a(entry2.getValue()).execute().isSuccessful()) {
                                InputStream inputStreamByteStream2 = responseExecute.body().byteStream();
                                if (map.get(entry2.getKey()) != null) {
                                    ((Junction) map.get(entry2.getKey())).setBitmap(BitmapFactory.decodeStream(inputStreamByteStream2));
                                }
                            }
                        }
                    }
                }
                return null;
            } catch (Exception e) {
                NavigationLogger.e(e);
                return null;
            }
        }

        @Override // android.os.AsyncTask
        protected final void onPostExecute(List<Junction> list) {
            c.this.d = false;
            c.this.e += c.this.c;
        }
    }

    private void a() {
        RouteOptions routeOptionsFromJson;
        MapplsGetJunction mapplsGetJunction = this.a;
        if (mapplsGetJunction != null && mapplsGetJunction.isExecuted()) {
            this.a.cancelCall();
        }
        this.a = null;
        try {
            if (NavigationContext.getNavigationContext().h().k() != null) {
                NavigationContext.getNavigationContext().h().k().setJunctionViews(null);
            }
            NavigationContext.getNavigationContext().o().a(5);
        } catch (Exception e) {
            NavigationLogger.e(e);
        }
        this.d = false;
        this.c = 5;
        this.e = 0;
        if (!this.b || !MapplsNavigationHelper.getInstance().isNavigating() || (routeOptionsFromJson = RouteOptions.fromJson((String) NavigationContext.getNavigationContext().k().a.get())) == null || routeOptionsFromJson.requestUuid() == null || MapplsNavigationHelper.getInstance().getCurrentRoute() == null) {
            return;
        }
        int routeIndex = MapplsNavigationHelper.getInstance().getRouteIndex();
        if (MapplsNavigationHelper.getInstance().getCurrentRoute().routeIndex() != null) {
            routeIndex = MapplsNavigationHelper.getInstance().getCurrentRoute().routeIndex().intValue();
        }
        MapplsGetJunction.Builder size = MapplsGetJunction.builder().routeId(routeOptionsFromJson.requestUuid()).junctionViewMode(MapplsNavigationHelper.getInstance().getJunctionViewMode()).routeIdx(Integer.valueOf(routeIndex)).size(MapplsNavigationHelper.getInstance().getJunctionViewImageSize());
        if (MapplsNavigationHelper.getInstance().getBaseRes() != null) {
            size.baseUrl(MapplsNavigationHelper.getInstance().getBaseRes() + "apis/O2O/");
        }
        MapplsGetJunction mapplsGetJunctionBuild = size.build();
        this.a = mapplsGetJunctionBuild;
        mapplsGetJunctionBuild.enqueueCall(new a());
    }

    static void a(c cVar, List list) {
        cVar.getClass();
        if (list.size() - cVar.e >= 5) {
            cVar.c = 5;
        } else {
            if (list.size() - cVar.e <= 0 || list.size() - cVar.e >= 5) {
                return;
            }
            cVar.c = list.size() - cVar.e;
        }
    }

    static void b(c cVar, List list) {
        cVar.getClass();
        new b(cVar, 0).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, list);
    }

    public final void c() {
        a();
    }

    public final void d() {
        a();
    }

    public final void a(boolean z) {
        if (this.b == z) {
            return;
        }
        this.b = z;
        a();
    }

    final void b() {
        int i;
        if (this.d || NavigationContext.getNavigationContext().h().s()) {
            return;
        }
        List<Junction> junctionViews = NavigationContext.getNavigationContext().h().k().getJunctionViews();
        if (junctionViews.size() > 5 && (i = this.e - 3) >= 0 && i <= junctionViews.size() - 1) {
            if (MapplsNavigationHelper.getInstance().getNodeIndex() > junctionViews.get(i).nodeIdx) {
                if (junctionViews.size() - this.e >= 5) {
                    this.c = 5;
                } else if (junctionViews.size() - this.e > 0 && junctionViews.size() - this.e < 5) {
                    this.c = junctionViews.size() - this.e;
                }
                if (this.e >= junctionViews.size()) {
                    return;
                }
                int i2 = this.e;
                new b(this, 0).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, junctionViews.subList(i2, this.c + i2));
            }
        }
    }
}
