package com.mappls.sdk.maps;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import com.mappls.sdk.maps.attribution.Attribution;
import com.mappls.sdk.maps.attribution.AttributionParser;
import com.mappls.sdk.maps.camera.CameraPosition;
import com.spotify.sdk.android.auth.AccountsQueryParameters;
import com.spotify.sdk.android.auth.AuthorizationClient;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public class AttributionDialogManager implements View.OnClickListener, DialogInterface.OnClickListener {
    private static final String MAP_FEEDBACK_STYLE_URI_REGEX = "^(.*://[^:^/]*)/(.*)/(.*)";
    private static final String MAP_FEEDBACK_URL = "https://apps.mappls.com/feedback";
    private static final String MAP_FEEDBACK_URL_LOCATION_FRAGMENT_FORMAT = "/%f/%f/%f/%f/%d";
    private static final String MAP_FEEDBACK_URL_OLD = "https://www.mappls.com/map-feedback";
    private Set<Attribution> attributionSet;
    private final Context context;
    private AlertDialog dialog;
    private final MapplsMap mapplsMap;

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
    }

    public AttributionDialogManager(Context context, MapplsMap mapplsMap) {
        this.context = context;
        this.mapplsMap = mapplsMap;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.attributionSet = new AttributionBuilder(this.mapplsMap, view.getContext()).build();
        Context context = this.context;
        if (context instanceof Activity ? ((Activity) context).isFinishing() : false) {
            return;
        }
        showAttributionDialog(getAttributionTitles());
    }

    protected void showAttributionDialog(String[] strArr) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setCustomTitle(LayoutInflater.from(this.context).inflate(R.layout.mappls_maps_attribution_title, (ViewGroup) null, false));
        builder.setAdapter(new ArrayAdapter(this.context, R.layout.mappls_maps_attribution_list_item, strArr), this);
        this.dialog = builder.show();
    }

    private String[] getAttributionTitles() {
        ArrayList arrayList = new ArrayList();
        Iterator<Attribution> it2 = this.attributionSet.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().getTitle());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public void onStop() {
        AlertDialog alertDialog = this.dialog;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        this.dialog.dismiss();
    }

    private boolean isLatestEntry(int i) {
        return i == getAttributionTitles().length - 1;
    }

    private void showMapAttributionWebPage(int i) {
        Set<Attribution> set = this.attributionSet;
        String url = ((Attribution[]) set.toArray(new Attribution[set.size()]))[i].getUrl();
        if (url.contains(MAP_FEEDBACK_URL_OLD) || url.contains(MAP_FEEDBACK_URL)) {
            url = buildMapFeedbackMapUrl(Mappls.getAccessToken());
        }
        showWebPage(url);
    }

    String buildMapFeedbackMapUrl(String str) {
        Uri.Builder builderBuildUpon = Uri.parse(MAP_FEEDBACK_URL).buildUpon();
        CameraPosition cameraPosition = this.mapplsMap.getCameraPosition();
        if (cameraPosition != null) {
            builderBuildUpon.encodedFragment(String.format(Locale.getDefault(), MAP_FEEDBACK_URL_LOCATION_FRAGMENT_FORMAT, Double.valueOf(cameraPosition.target.getLongitude()), Double.valueOf(cameraPosition.target.getLatitude()), Double.valueOf(cameraPosition.zoom), Double.valueOf(cameraPosition.bearing), Integer.valueOf((int) cameraPosition.tilt)));
        }
        String packageName = this.context.getApplicationContext().getPackageName();
        if (packageName != null) {
            builderBuildUpon.appendQueryParameter(AuthorizationClient.PlayStoreParams.REFERRER, packageName);
        }
        if (str != null) {
            builderBuildUpon.appendQueryParameter(AccountsQueryParameters.ACCESS_TOKEN, str);
        }
        Style style = this.mapplsMap.getStyle();
        if (style != null) {
            Matcher matcher = Pattern.compile(MAP_FEEDBACK_STYLE_URI_REGEX).matcher(style.getMapplsStyle());
            if (matcher.find()) {
                String strGroup = matcher.group(2);
                builderBuildUpon.appendQueryParameter("owner", strGroup).appendQueryParameter("id", matcher.group(3));
            }
        }
        return builderBuildUpon.build().toString();
    }

    private void showWebPage(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            this.context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this.context, R.string.mappls_maps_attributionErrorNoBrowser, 1).show();
            MapStrictMode.strictModeViolation(e);
        }
    }

    private static class AttributionBuilder {
        private final WeakReference<Context> context;
        private final MapplsMap mapplsMap;

        AttributionBuilder(MapplsMap mapplsMap, Context context) {
            this.mapplsMap = mapplsMap;
            this.context = new WeakReference<>(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Set<Attribution> build() {
            Context context = this.context.get();
            if (context == null) {
                return Collections.emptySet();
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add("@OpenStreetMap");
            return new AttributionParser.Options(context).withCopyrightSign(true).withImproveMap(true).withAttributionData((String[]) arrayList.toArray(new String[arrayList.size()])).build().getAttributions();
        }
    }
}
