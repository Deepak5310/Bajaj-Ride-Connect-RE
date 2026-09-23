package com.mappls.sdk.navigation.routing;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.mappls.sdk.navigation.R;
import com.mappls.sdk.navigation.data.LocationPoint;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements LocationPoint {
    protected final int a = -1;
    private EnumC0099a b;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: renamed from: com.mappls.sdk.navigation.routing.a$a, reason: collision with other inner class name */
    public static final class EnumC0099a {
        public static final EnumC0099a b = new EnumC0099a("SPEED_CAMERA", 0, R.string.mappls_traffic_warning_speed_camera);
        public static final EnumC0099a c = new EnumC0099a("SPEED_LIMIT", 1, R.string.mappls_traffic_warning_speed_limit);
        public static final EnumC0099a d = new EnumC0099a("TOLL_BOOTH", 5, R.string.mappls_traffic_warning_payment);
        public static final EnumC0099a e = new EnumC0099a("PEDESTRIAN", 7, R.string.mappls_traffic_warning_pedestrian);
        private int a;

        private EnumC0099a(String str, int i, int i2) {
            super(str, i);
            this.a = i2;
        }

        public final String a(Context context) {
            return context.getString(this.a);
        }
    }

    public a(EnumC0099a enumC0099a) {
        this.b = enumC0099a;
    }

    public final int a() {
        return this.a;
    }

    public final EnumC0099a b() {
        return this.b;
    }

    @Override // com.mappls.sdk.navigation.data.LocationPoint
    public final double getLatitude() {
        return 0.0d;
    }

    @Override // com.mappls.sdk.navigation.data.LocationPoint
    public final double getLongitude() {
        return 0.0d;
    }

    @Override // com.mappls.sdk.navigation.data.LocationPoint
    public final com.mappls.sdk.navigation.data.a getPointDescription(Context context) {
        return new com.mappls.sdk.navigation.data.a(NotificationCompat.CATEGORY_ALARM, this.b.a(context));
    }
}
