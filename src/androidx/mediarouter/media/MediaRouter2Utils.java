package androidx.mediarouter.media;

import android.content.IntentFilter;
import android.media.MediaRoute2Info;
import android.media.RouteDiscoveryPreference;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArraySet;
import androidx.media.AudioFocusRequestCompat$$ExternalSyntheticApiModelOutline0;
import androidx.preference.PreferenceCategory$$ExternalSyntheticApiModelOutline0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class MediaRouter2Utils {
    static final String FEATURE_EMPTY = "android.media.route.feature.EMPTY";
    static final String FEATURE_REMOTE_GROUP_PLAYBACK = "android.media.route.feature.REMOTE_GROUP_PLAYBACK";
    static final String KEY_CONTROL_FILTERS = "androidx.mediarouter.media.KEY_CONTROL_FILTERS";
    static final String KEY_DEVICE_TYPE = "androidx.mediarouter.media.KEY_DEVICE_TYPE";
    static final String KEY_EXTRAS = "androidx.mediarouter.media.KEY_EXTRAS";
    static final String KEY_GROUP_ROUTE = "androidx.mediarouter.media.KEY_GROUP_ROUTE";
    static final String KEY_MESSENGER = "androidx.mediarouter.media.KEY_MESSENGER";
    static final String KEY_ORIGINAL_ROUTE_ID = "androidx.mediarouter.media.KEY_ORIGINAL_ROUTE_ID";
    static final String KEY_PLAYBACK_TYPE = "androidx.mediarouter.media.KEY_PLAYBACK_TYPE";
    static final String KEY_SESSION_NAME = "androidx.mediarouter.media.KEY_SESSION_NAME";

    private MediaRouter2Utils() {
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0084  */
    /* JADX WARN: Code duplicated, block: B:22:0x00cd  */
    public static MediaRoute2Info toFwkMediaRoute2Info(MediaRouteDescriptor mediaRouteDescriptor) {
        if (mediaRouteDescriptor == null || TextUtils.isEmpty(mediaRouteDescriptor.getId()) || TextUtils.isEmpty(mediaRouteDescriptor.getName())) {
            return null;
        }
        AudioFocusRequestCompat$$ExternalSyntheticApiModelOutline0.m384m();
        MediaRoute2Info.Builder iconUri = PreferenceCategory$$ExternalSyntheticApiModelOutline0.m(mediaRouteDescriptor.getId(), mediaRouteDescriptor.getName()).setDescription(mediaRouteDescriptor.getDescription()).setConnectionState(mediaRouteDescriptor.getConnectionState()).setVolumeHandling(mediaRouteDescriptor.getVolumeHandling()).setVolume(mediaRouteDescriptor.getVolume()).setVolumeMax(mediaRouteDescriptor.getVolumeMax()).addFeatures(toFeatures(mediaRouteDescriptor.getControlFilters())).setIconUri(mediaRouteDescriptor.getIconUri());
        int deviceType = mediaRouteDescriptor.getDeviceType();
        if (deviceType == 1) {
            iconUri.addFeature("android.media.route.feature.REMOTE_VIDEO_PLAYBACK");
        } else {
            if (deviceType == 2) {
            }
            if (!mediaRouteDescriptor.getGroupMemberIds().isEmpty()) {
                iconUri.addFeature(FEATURE_REMOTE_GROUP_PLAYBACK);
            }
            Bundle bundle = new Bundle();
            bundle.putBundle(KEY_EXTRAS, mediaRouteDescriptor.getExtras());
            bundle.putParcelableArrayList(KEY_CONTROL_FILTERS, new ArrayList<>(mediaRouteDescriptor.getControlFilters()));
            bundle.putInt(KEY_DEVICE_TYPE, mediaRouteDescriptor.getDeviceType());
            bundle.putInt(KEY_PLAYBACK_TYPE, mediaRouteDescriptor.getPlaybackType());
            bundle.putString(KEY_ORIGINAL_ROUTE_ID, mediaRouteDescriptor.getId());
            iconUri.setExtras(bundle);
            if (mediaRouteDescriptor.getControlFilters().isEmpty()) {
                iconUri.addFeature(FEATURE_EMPTY);
            }
            return iconUri.build();
        }
        iconUri.addFeature("android.media.route.feature.REMOTE_AUDIO_PLAYBACK");
        if (!mediaRouteDescriptor.getGroupMemberIds().isEmpty()) {
            iconUri.addFeature(FEATURE_REMOTE_GROUP_PLAYBACK);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(KEY_EXTRAS, mediaRouteDescriptor.getExtras());
        bundle2.putParcelableArrayList(KEY_CONTROL_FILTERS, new ArrayList<>(mediaRouteDescriptor.getControlFilters()));
        bundle2.putInt(KEY_DEVICE_TYPE, mediaRouteDescriptor.getDeviceType());
        bundle2.putInt(KEY_PLAYBACK_TYPE, mediaRouteDescriptor.getPlaybackType());
        bundle2.putString(KEY_ORIGINAL_ROUTE_ID, mediaRouteDescriptor.getId());
        iconUri.setExtras(bundle2);
        if (mediaRouteDescriptor.getControlFilters().isEmpty()) {
            iconUri.addFeature(FEATURE_EMPTY);
        }
        return iconUri.build();
    }

    public static MediaRouteDescriptor toMediaRouteDescriptor(MediaRoute2Info mediaRoute2Info) {
        if (mediaRoute2Info == null) {
            return null;
        }
        MediaRouteDescriptor.Builder canDisconnect = new MediaRouteDescriptor.Builder(mediaRoute2Info.getId(), mediaRoute2Info.getName().toString()).setConnectionState(mediaRoute2Info.getConnectionState()).setVolumeHandling(mediaRoute2Info.getVolumeHandling()).setVolumeMax(mediaRoute2Info.getVolumeMax()).setVolume(mediaRoute2Info.getVolume()).setExtras(mediaRoute2Info.getExtras()).setEnabled(true).setCanDisconnect(false);
        CharSequence description = mediaRoute2Info.getDescription();
        if (description != null) {
            canDisconnect.setDescription(description.toString());
        }
        Uri iconUri = mediaRoute2Info.getIconUri();
        if (iconUri != null) {
            canDisconnect.setIconUri(iconUri);
        }
        Bundle extras = mediaRoute2Info.getExtras();
        if (extras == null || !extras.containsKey(KEY_EXTRAS) || !extras.containsKey(KEY_DEVICE_TYPE) || !extras.containsKey(KEY_CONTROL_FILTERS)) {
            return null;
        }
        canDisconnect.setExtras(extras.getBundle(KEY_EXTRAS));
        canDisconnect.setDeviceType(extras.getInt(KEY_DEVICE_TYPE, 0));
        canDisconnect.setPlaybackType(extras.getInt(KEY_PLAYBACK_TYPE, 1));
        ArrayList parcelableArrayList = extras.getParcelableArrayList(KEY_CONTROL_FILTERS);
        if (parcelableArrayList != null) {
            canDisconnect.addControlFilters(parcelableArrayList);
        }
        return canDisconnect.build();
    }

    static Collection<String> toFeatures(List<IntentFilter> list) {
        HashSet hashSet = new HashSet();
        for (IntentFilter intentFilter : list) {
            int iCountCategories = intentFilter.countCategories();
            for (int i = 0; i < iCountCategories; i++) {
                hashSet.add(toRouteFeature(intentFilter.getCategory(i)));
            }
        }
        return hashSet;
    }

    static List<IntentFilter> toControlFilters(Collection<String> collection) {
        if (collection == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        ArraySet arraySet = new ArraySet();
        for (String str : collection) {
            if (!arraySet.contains(str)) {
                arraySet.add(str);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addCategory(toControlCategory(str));
                arrayList.add(intentFilter);
            }
        }
        return arrayList;
    }

    static List<String> getRouteIds(List<MediaRoute2Info> list) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<MediaRoute2Info> it2 = list.iterator();
        while (it2.hasNext()) {
            MediaRoute2Info mediaRoute2InfoM368m = AudioFocusRequestCompat$$ExternalSyntheticApiModelOutline0.m368m((Object) it2.next());
            if (mediaRoute2InfoM368m != null) {
                arrayList.add(mediaRoute2InfoM368m.getId());
            }
        }
        return arrayList;
    }

    static MediaRouteDiscoveryRequest toMediaRouteDiscoveryRequest(RouteDiscoveryPreference routeDiscoveryPreference) {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = routeDiscoveryPreference.getPreferredFeatures().iterator();
        while (it2.hasNext()) {
            arrayList.add(toControlCategory((String) it2.next()));
        }
        return new MediaRouteDiscoveryRequest(new MediaRouteSelector.Builder().addControlCategories(arrayList).build(), routeDiscoveryPreference.shouldPerformActiveScan());
    }

    static RouteDiscoveryPreference toDiscoveryPreference(MediaRouteDiscoveryRequest mediaRouteDiscoveryRequest) {
        if (mediaRouteDiscoveryRequest == null || !mediaRouteDiscoveryRequest.isValid()) {
            AudioFocusRequestCompat$$ExternalSyntheticApiModelOutline0.m390m$1();
            return AudioFocusRequestCompat$$ExternalSyntheticApiModelOutline0.m((List) new ArrayList(), false).build();
        }
        boolean zIsActiveScan = mediaRouteDiscoveryRequest.isActiveScan();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it2 = mediaRouteDiscoveryRequest.getSelector().getControlCategories().iterator();
        while (it2.hasNext()) {
            arrayList.add(toRouteFeature(it2.next()));
        }
        return AudioFocusRequestCompat$$ExternalSyntheticApiModelOutline0.m(arrayList, zIsActiveScan).build();
    }

    static String toRouteFeature(String str) {
        str.hashCode();
        switch (str) {
            case "android.media.intent.category.REMOTE_PLAYBACK":
                return "android.media.route.feature.REMOTE_PLAYBACK";
            case "android.media.intent.category.LIVE_AUDIO":
                return "android.media.route.feature.LIVE_AUDIO";
            case "android.media.intent.category.LIVE_VIDEO":
                return "android.media.route.feature.LIVE_VIDEO";
            default:
                return str;
        }
    }

    static String toControlCategory(String str) {
        str.hashCode();
        switch (str) {
            case "android.media.route.feature.REMOTE_PLAYBACK":
                return MediaControlIntent.CATEGORY_REMOTE_PLAYBACK;
            case "android.media.route.feature.LIVE_AUDIO":
                return MediaControlIntent.CATEGORY_LIVE_AUDIO;
            case "android.media.route.feature.LIVE_VIDEO":
                return MediaControlIntent.CATEGORY_LIVE_VIDEO;
            default:
                return str;
        }
    }
}
