package com.mappls.sdk.maps.utils;

import android.content.Context;
import android.os.Bundle;
import com.mappls.sdk.maps.MapplsMapOptions;
import com.mappls.sdk.maps.constants.MapplsConstants;

/* JADX INFO: loaded from: classes4.dex */
public class MapFragmentUtils {
    public static Bundle createFragmentArgs(MapplsMapOptions mapplsMapOptions) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(MapplsConstants.FRAG_ARG_MAPPLSMAPOPTIONS, mapplsMapOptions);
        return bundle;
    }

    public static MapplsMapOptions resolveArgs(Context context, Bundle bundle) {
        if (bundle != null && bundle.containsKey(MapplsConstants.FRAG_ARG_MAPPLSMAPOPTIONS)) {
            return (MapplsMapOptions) bundle.getParcelable(MapplsConstants.FRAG_ARG_MAPPLSMAPOPTIONS);
        }
        return MapplsMapOptions.createFromAttributes(context);
    }
}
