package app.notifee.core;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.TypedValue;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import androidx.core.app.NotificationManagerCompat;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.mappls.sdk.navigation.util.SavingTrackHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import n.o.t.i.f.e.e.d;
import n.o.t.i.f.e.e.e;
import n.o.t.i.f.e.e.l;
import n.o.t.i.f.e.e.n;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static ExecutorService a = Executors.newCachedThreadPool();

    public static Task<Void> a(final n.o.t.i.f.e.e.c cVar) {
        return Tasks.call(a, new Callable() { // from class: app.notifee.core.a$$ExternalSyntheticLambda35
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return a.b(cVar);
            }
        });
    }

    public static Void b(n.o.t.i.f.e.e.c cVar) throws Exception {
        long[] jArr;
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        a$$ExternalSyntheticApiModelOutline0.m502m$1();
        NotificationChannel notificationChannelM = ComponentDialog$$ExternalSyntheticApiModelOutline0.m((String) Objects.requireNonNull(cVar.a.getString("id")), (String) Objects.requireNonNull(cVar.a.getString("name")), (cVar.a.containsKey("importance") ? Integer.valueOf(l.a(cVar.a.get("importance"))) : 3).intValue());
        boolean z = cVar.a.getBoolean("badge", true);
        Boolean.valueOf(z).getClass();
        notificationChannelM.setShowBadge(z);
        boolean z2 = cVar.a.getBoolean("bypassDnd", false);
        Boolean.valueOf(z2).getClass();
        notificationChannelM.setBypassDnd(z2);
        notificationChannelM.setDescription(cVar.a.getString(SavingTrackHelper.POINT_COL_DESCRIPTION));
        notificationChannelM.setGroup(cVar.a.getString("groupId"));
        boolean z3 = cVar.a.getBoolean("lights", true);
        Boolean.valueOf(z3).getClass();
        notificationChannelM.enableLights(z3);
        if (cVar.a() != null) {
            notificationChannelM.setLightColor(cVar.a().intValue());
        }
        notificationChannelM.setLockscreenVisibility(cVar.a.containsKey("visibility") ? l.a(cVar.a.get("visibility")) : 0);
        boolean z4 = cVar.a.getBoolean("vibration", true);
        Boolean.valueOf(z4).getClass();
        notificationChannelM.enableVibration(z4);
        if (cVar.a.containsKey("vibrationPattern")) {
            ArrayList arrayList = (ArrayList) Objects.requireNonNull(cVar.a.getParcelableArrayList("vibrationPattern"));
            long[] jArr2 = new long[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                jArr2[i] = ((Integer) arrayList.get(i)).longValue();
            }
            jArr = jArr2;
        } else {
            jArr = new long[0];
        }
        if (jArr.length > 0) {
            notificationChannelM.setVibrationPattern(jArr);
        }
        if ((!cVar.a.containsKey("sound") ? null : cVar.a.getString("sound")) != null) {
            Uri uriC = n.c(!cVar.a.containsKey("sound") ? null : cVar.a.getString("sound"));
            if (uriC != null) {
                notificationChannelM.setSound(uriC, new AudioAttributes.Builder().setUsage(5).setContentType(4).build());
            } else {
                Logger.w("ChannelManager", "Unable to retrieve sound for channel, sound was specified as: " + notificationChannelM.getSound());
            }
        } else {
            notificationChannelM.setSound(null, null);
        }
        NotificationManagerCompat.from(e.a).createNotificationChannel(notificationChannelM);
        return null;
    }

    public static List c() throws Exception {
        List<NotificationChannelGroup> notificationChannelGroups = NotificationManagerCompat.from(e.a).getNotificationChannelGroups();
        if (notificationChannelGroups.size() == 0 || Build.VERSION.SDK_INT < 26) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(notificationChannelGroups.size());
        Iterator<NotificationChannelGroup> it2 = notificationChannelGroups.iterator();
        while (it2.hasNext()) {
            arrayList.add(a(ComponentDialog$$ExternalSyntheticApiModelOutline0.m16m((Object) it2.next())));
        }
        return arrayList;
    }

    public static List d() throws Exception {
        List<NotificationChannel> notificationChannels = NotificationManagerCompat.from(e.a).getNotificationChannels();
        if (notificationChannels.size() == 0 || Build.VERSION.SDK_INT < 26) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(notificationChannels.size());
        Iterator<NotificationChannel> it2 = notificationChannels.iterator();
        while (it2.hasNext()) {
            arrayList.add(a(ComponentDialog$$ExternalSyntheticApiModelOutline0.m((Object) it2.next())));
        }
        return arrayList;
    }

    public static Bundle e(String str) throws Exception {
        return a(NotificationManagerCompat.from(e.a).getNotificationChannel(str));
    }

    public static Bundle f(String str) throws Exception {
        return a(NotificationManagerCompat.from(e.a).getNotificationChannelGroup(str));
    }

    public static Boolean g(String str) throws Exception {
        if (Build.VERSION.SDK_INT < 26) {
            return Boolean.FALSE;
        }
        NotificationChannel notificationChannel = NotificationManagerCompat.from(e.a).getNotificationChannel(str);
        if (notificationChannel == null) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(notificationChannel.getImportance() == 0);
    }

    public static Boolean h(String str) throws Exception {
        if (Build.VERSION.SDK_INT < 26) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(NotificationManagerCompat.from(e.a).getNotificationChannel(str) != null);
    }

    public static Task<Void> a(final n.o.t.i.f.e.e.b bVar) {
        return Tasks.call(a, new Callable() { // from class: app.notifee.core.a$$ExternalSyntheticLambda31
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return a.b(bVar);
            }
        });
    }

    public static Task<Void> a(final List<n.o.t.i.f.e.e.b> list) {
        return Tasks.call(a, new Callable() { // from class: app.notifee.core.a$$ExternalSyntheticLambda38
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return a.c(list);
            }
        });
    }

    public static Task<Bundle> a(final String str) {
        return Tasks.call(a, new Callable() { // from class: app.notifee.core.a$$ExternalSyntheticLambda32
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return a.e(str);
            }
        });
    }

    public static Task<List<Bundle>> a() {
        return Tasks.call(a, new Callable() { // from class: app.notifee.core.a$$ExternalSyntheticLambda37
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return a.c();
            }
        });
    }

    public static Bundle a(NotificationChannel notificationChannel) {
        String strReplace = null;
        if (notificationChannel == null || Build.VERSION.SDK_INT < 26) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("id", notificationChannel.getId());
        bundle.putString("name", notificationChannel.getName().toString());
        bundle.putBoolean("badge", notificationChannel.canShowBadge());
        bundle.putBoolean("bypassDnd", notificationChannel.canBypassDnd());
        if (notificationChannel.getDescription() != null) {
            bundle.putString(SavingTrackHelper.POINT_COL_DESCRIPTION, notificationChannel.getDescription());
        }
        if (notificationChannel.getGroup() != null) {
            bundle.putString("groupId", notificationChannel.getGroup());
        }
        bundle.putInt("importance", notificationChannel.getImportance());
        bundle.putBoolean("lights", notificationChannel.shouldShowLights());
        bundle.putBoolean("vibration", notificationChannel.shouldVibrate());
        bundle.putBoolean("blocked", notificationChannel.getImportance() == 0);
        if (notificationChannel.getSound() != null) {
            bundle.putString("soundURI", notificationChannel.getSound().toString());
            Uri sound = notificationChannel.getSound();
            if (sound != null && sound.toString().contains(UriUtil.QUALIFIED_RESOURCE_SCHEME)) {
                String lastPathSegment = sound.getLastPathSegment();
                try {
                    int iIntValue = Integer.valueOf(lastPathSegment).intValue();
                    Logger.e("ResourceUtils", "Loaded sound by resource id. New app builds will fail to play sound. Create a new channel to resolve. Issue #341");
                    if (iIntValue != 0) {
                        TypedValue typedValue = new TypedValue();
                        e.a.getResources().getValue(iIntValue, typedValue, true);
                        CharSequence charSequence = typedValue.string;
                        if (charSequence != null || charSequence.length() > 0) {
                            strReplace = charSequence.toString().replace("res/raw/", "");
                        }
                    }
                } catch (NumberFormatException unused) {
                    strReplace = lastPathSegment;
                }
            }
            if (strReplace != null) {
                bundle.putString("sound", strReplace);
            }
        }
        if (notificationChannel.getLightColor() != 0) {
            int lightColor = notificationChannel.getLightColor();
            String str = d.a.get(Integer.valueOf(lightColor));
            if (str == null) {
                str = "#" + Integer.toHexString(lightColor).substring(2);
            }
            bundle.putString("lightColor", str);
        }
        long[] vibrationPattern = notificationChannel.getVibrationPattern();
        if (vibrationPattern != null && vibrationPattern.length > 0) {
            try {
                int[] iArr = new int[vibrationPattern.length];
                for (int i = 0; i < vibrationPattern.length; i++) {
                    iArr[i] = (int) vibrationPattern[i];
                }
                bundle.putIntArray("vibrationPattern", iArr);
            } catch (Exception e) {
                Logger.e("ChannelManager", "Unable to convert Vibration Pattern to Channel Bundle", e);
            }
        }
        int lockscreenVisibility = notificationChannel.getLockscreenVisibility();
        if (lockscreenVisibility != -1000) {
            bundle.putInt("visibility", lockscreenVisibility);
        }
        return bundle;
    }

    public static /* synthetic */ Void c(List list) throws Exception {
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            Tasks.await(a((n.o.t.i.f.e.e.b) it2.next()));
        }
        return null;
    }

    public static /* synthetic */ Void d(List list) throws Exception {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            Tasks.await(a((n.o.t.i.f.e.e.c) it2.next()));
        }
        return null;
    }

    public static Task<Boolean> d(final String str) {
        return Tasks.call(a, new Callable() { // from class: app.notifee.core.a$$ExternalSyntheticLambda36
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return a.h(str);
            }
        });
    }

    public static Task<Boolean> c(final String str) {
        return Tasks.call(a, new Callable() { // from class: app.notifee.core.a$$ExternalSyntheticLambda39
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return a.g(str);
            }
        });
    }

    public static Task<Void> b(final List<n.o.t.i.f.e.e.c> list) {
        return Tasks.call(a, new Callable() { // from class: app.notifee.core.a$$ExternalSyntheticLambda34
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return a.d(list);
            }
        });
    }

    public static Void b(n.o.t.i.f.e.e.b bVar) throws Exception {
        int i = Build.VERSION.SDK_INT;
        if (i < 26) {
            return null;
        }
        a$$ExternalSyntheticApiModelOutline0.m491m();
        NotificationChannelGroup notificationChannelGroupM = a$$ExternalSyntheticApiModelOutline0.m((String) Objects.requireNonNull(bVar.a.getString("id")), (String) Objects.requireNonNull(bVar.a.getString("name")));
        if (i >= 28 && bVar.a.getString(SavingTrackHelper.POINT_COL_DESCRIPTION) != null) {
            notificationChannelGroupM.setDescription(bVar.a.getString(SavingTrackHelper.POINT_COL_DESCRIPTION));
        }
        NotificationManagerCompat.from(e.a).createNotificationChannelGroup(notificationChannelGroupM);
        return null;
    }

    public static Bundle a(NotificationChannelGroup notificationChannelGroup) {
        if (notificationChannelGroup == null || Build.VERSION.SDK_INT < 26) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("id", notificationChannelGroup.getId());
        bundle.putString("name", notificationChannelGroup.getName().toString());
        List channels = notificationChannelGroup.getChannels();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(channels.size());
        Iterator it2 = channels.iterator();
        while (it2.hasNext()) {
            arrayList.add(a(ComponentDialog$$ExternalSyntheticApiModelOutline0.m(it2.next())));
        }
        bundle.putParcelableArrayList("channels", arrayList);
        if (Build.VERSION.SDK_INT >= 28) {
            bundle.putBoolean("blocked", notificationChannelGroup.isBlocked());
            bundle.putString(SavingTrackHelper.POINT_COL_DESCRIPTION, notificationChannelGroup.getDescription());
        } else {
            bundle.putBoolean("blocked", false);
        }
        return bundle;
    }

    public static Task<List<Bundle>> b() {
        return Tasks.call(a, new Callable() { // from class: app.notifee.core.a$$ExternalSyntheticLambda33
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return a.d();
            }
        });
    }

    public static Task<Bundle> b(final String str) {
        return Tasks.call(a, new Callable() { // from class: app.notifee.core.a$$ExternalSyntheticLambda40
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return a.f(str);
            }
        });
    }
}
