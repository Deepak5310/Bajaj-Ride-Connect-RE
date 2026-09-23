package com.mappls.sdk.maps.style.sources;

import android.net.Uri;
import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.maps.style.expressions.Expression;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class VectorSource extends Source {
    private native Feature[] querySourceFeatures(String[] strArr, Object[] objArr);

    protected native void finalize() throws Throwable;

    protected native void initialize(String str, Object obj);

    protected native String nativeGetUrl();

    VectorSource(long j) {
        super(j);
    }

    @Deprecated
    public VectorSource(String str, URL url) {
        this(str, url.toExternalForm());
    }

    public VectorSource(String str, Uri uri) {
        this(str, uri.toString());
    }

    public VectorSource(String str, String str2) {
        initialize(str, str2);
    }

    public VectorSource(String str, TileSet tileSet) {
        initialize(str, tileSet.toValueObject());
    }

    public List<Feature> querySourceFeatures(String[] strArr, Expression expression) {
        checkThread();
        Feature[] featureArrQuerySourceFeatures = querySourceFeatures(strArr, expression != null ? expression.toArray() : null);
        return featureArrQuerySourceFeatures != null ? Arrays.asList(featureArrQuerySourceFeatures) : new ArrayList();
    }

    @Deprecated
    public String getUrl() {
        checkThread();
        return nativeGetUrl();
    }

    public String getUri() {
        checkThread();
        return nativeGetUrl();
    }
}
