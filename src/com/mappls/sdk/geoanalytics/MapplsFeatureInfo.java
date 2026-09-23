package com.mappls.sdk.geoanalytics;

import android.graphics.PointF;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.actions.SearchIntents;
import com.mappls.sdk.maps.geometry.LatLngBounds;
import com.mappls.sdk.services.api.MapplsService;
import com.mappls.sdk.services.utils.Constants;
import com.spotify.sdk.android.auth.LoginActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;

/* JADX INFO: loaded from: classes6.dex */
abstract class MapplsFeatureInfo extends MapplsService<ResponseBody, d> {

    public static abstract class a {
        private String a(CharSequence charSequence, List<String> list) {
            if (list == null) {
                return null;
            }
            boolean z = true;
            if (list.size() < 1) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                String str = "'" + list.get(i) + "'";
                if (z) {
                    z = false;
                } else {
                    sb.append(charSequence);
                }
                sb.append(str);
            }
            return sb.toString();
        }

        public abstract a a(PointF pointF);

        public abstract a a(LatLngBounds latLngBounds);

        public abstract a a(Integer num);

        public abstract a a(String str);

        public a a(List<String> list) {
            return c(a(",", list));
        }

        public abstract MapplsFeatureInfo a();

        public abstract a b(Integer num);

        abstract a b(String str);

        abstract a c(String str);

        public abstract a d(String str);

        public abstract a e(String str);

        abstract a f(String str);

        public abstract a g(String str);
    }

    public MapplsFeatureInfo() {
        super(d.class);
    }

    public static a builder() {
        return new com.mappls.sdk.geoanalytics.a.b().h(Constants.MGIS_APIS_BASE_URL);
    }

    private HashMap<String, String> createRequest() {
        HashMap<String, String> map = new HashMap<>();
        map.put("layertype", pathApi());
        map.put("geoboundtype", geoBoundType());
        map.put("geobound", geoBound());
        if (attributes() != null) {
            map.put("attribute", attributes());
        }
        if (query() != null) {
            map.put(SearchIntents.EXTRA_QUERY, query());
        }
        map.put(LoginActivity.REQUEST_KEY, "GetFeatureInfo");
        map.put(NotificationCompat.CATEGORY_SERVICE, "WMS");
        map.put("srs", "EPSG:4326");
        map.put("bbox", getBbox());
        map.put("width", "" + width());
        map.put("height", "" + height());
        map.put("info_format", "application/json");
        map.put("propertyname", propertyName());
        map.put("x", ((int) clickedPoint().x) + "");
        map.put("y", ((int) clickedPoint().y) + "");
        return map;
    }

    private String getBbox() {
        return visibleRegion().getSouthWest().getLongitude() + "," + visibleRegion().getSouthWest().getLatitude() + "," + visibleRegion().getNorthEast().getLongitude() + "," + visibleRegion().getNorthEast().getLatitude();
    }

    abstract String api();

    abstract String attributes();

    @Override // com.mappls.sdk.services.api.MapplsService
    protected abstract String baseUrl();

    protected abstract PointF clickedPoint();

    abstract String geoBound();

    abstract String geoBoundType();

    @Override // com.mappls.sdk.services.api.MapplsService
    protected List<CallAdapter.Factory> getCallAdapterFactory() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(RxJavaCallAdapterFactory.create());
        return arrayList;
    }

    abstract Integer height();

    @Override // com.mappls.sdk.services.api.MapplsService
    protected Call<ResponseBody> initializeCall() {
        return null;
    }

    public Observable<ResponseBody> initializeObservable() {
        return getLoginService(true).a(createRequest());
    }

    abstract String pathApi();

    abstract String propertyName();

    abstract String query();

    protected abstract LatLngBounds visibleRegion();

    abstract Integer width();
}
