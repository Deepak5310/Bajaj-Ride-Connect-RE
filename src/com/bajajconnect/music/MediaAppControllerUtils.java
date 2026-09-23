package com.bajajconnect.music;

import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.media.session.MediaController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class MediaAppControllerUtils {
    public static List<MediaAppDetails> getMediaAppsFromControllers(Collection<MediaController> collection, PackageManager packageManager, Resources resources) {
        ArrayList arrayList = new ArrayList();
        for (MediaController mediaController : collection) {
            try {
                arrayList.add(new MediaAppDetails(packageManager.getApplicationInfo(mediaController.getPackageName(), 0), packageManager, resources, mediaController.getSessionToken()));
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return arrayList;
    }
}
