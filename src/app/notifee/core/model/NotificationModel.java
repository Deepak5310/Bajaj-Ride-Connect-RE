package app.notifee.core.model;

import android.os.Bundle;
import androidx.mediarouter.media.SystemMediaRouteProvider;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class NotificationModel {
    public Bundle a;

    public NotificationModel(Bundle bundle) {
        this.a = bundle;
    }

    public NotificationAndroidModel a() {
        return NotificationAndroidModel.fromBundle(this.a.getBundle(SystemMediaRouteProvider.PACKAGE_NAME));
    }

    public Integer b() {
        return Integer.valueOf(c().hashCode());
    }

    public String c() {
        return (String) Objects.requireNonNull(this.a.getString("id"));
    }

    public Bundle toBundle() {
        return (Bundle) this.a.clone();
    }
}
