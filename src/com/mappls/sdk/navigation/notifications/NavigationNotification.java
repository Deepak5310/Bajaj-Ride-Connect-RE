package com.mappls.sdk.navigation.notifications;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.app.NotificationCompat;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.NavigationContext;
import com.mappls.sdk.navigation.NavigationFormatter;
import com.mappls.sdk.navigation.NavigationService;
import com.mappls.sdk.navigation.R;
import com.mappls.sdk.navigation.apis.NavigationLogger;
import com.mappls.sdk.navigation.h;
import com.mappls.sdk.navigation.routing.NavigationRoute;
import com.mappls.sdk.navigation.routing.NavigationStep;
import com.mappls.sdk.navigation.routing.d;
import com.mappls.sdk.navigation.s;
import com.mappls.sdk.navigation.ui.views.maneuver.ManeuverUtils;
import com.mappls.sdk.navigation.w;
import com.mappls.sdk.plugin.directions.DirectionFormatter;
import com.mappls.sdk.services.api.directions.models.LegStep;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class NavigationNotification extends com.mappls.sdk.navigation.notifications.a {
    public static final String DEEP_LINK_ACTION_OPEN_ROOT_SCREEN = "com.mappls.app.navigation.car.OpenRootScreen";
    public static final String EXIT_NAVIGATION = "com.mmi.maps.navigation.EXIT";
    public static final String GROUP_NAME = "NAVIGATION";
    public static final String NAVIGATION_PAUSE_NAVIGATION_SERVICE_ACTION = "NAVIGATION_PAUSE_NAVIGATION_SERVICE_ACTION";
    public static final String NAVIGATION_RESUME_NAVIGATION_SERVICE_ACTION = "NAVIGATION_RESUME_NAVIGATION_SERVICE_ACTION";
    public static final String NAVIGATION_STOP_NAVIGATION_SERVICE_ACTION = "com.mmi.maps.navigation.EXIT";
    private boolean leftSide;
    private Bitmap turnBitmap;

    final class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            d dVarH = NavigationContext.getNavigationContext().h();
            dVarH.b(true);
            dVarH.a(false);
            dVarH.w();
        }
    }

    final class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            d dVarH = NavigationContext.getNavigationContext().h();
            dVarH.b(false);
            dVarH.a(true);
        }
    }

    final class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            NavigationContext.getNavigationContext().stopNavigation();
            NavigationContext.getNavigationContext().getNotificationHelper().removeNotifications();
        }
    }

    public NavigationNotification(Context context) {
        super(context, GROUP_NAME);
    }

    private NotificationCompat.Builder createNotification(boolean z, String str, String str2, Bitmap bitmap, int i, int i2) {
        NotificationCompat.Builder largeIcon = createBuilder(z).setContentInfo(str2).setContentTitle(str).setCategory("navigation").setContentText(str2).setLargeIcon(bitmap);
        MapplsNavigationHelper.getInstance().extendNotification(largeIcon);
        return largeIcon;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x013b  */
    @Override // com.mappls.sdk.navigation.notifications.a
    public NotificationCompat.Builder buildNotification(boolean z) {
        String string;
        String strG;
        NavigationStep navigationStep;
        int iL;
        com.mappls.sdk.navigation.router.c cVarA;
        NavigationStep navigationStep2;
        Drawable drawable;
        String string2;
        NavigationService navigationServiceF = NavigationContext.getNavigationContext().f();
        StringBuilder sb = new StringBuilder();
        this.color = 0;
        this.icon = R.drawable.ic_navigation;
        this.turnBitmap = null;
        d dVarH = NavigationContext.getNavigationContext().h();
        int iH = dVarH.h();
        int wholeDistance = dVarH.k().getWholeDistance();
        boolean z2 = dVarH.q() || NavigationContext.getNavigationContext().getLocationProvider().getLocationSimulation().a();
        if (navigationServiceF != null) {
            int iE = navigationServiceF.e();
            int i = NavigationService.o;
            if ((iE & 1) != 0) {
                this.color = this.f711app.getResources().getColor(R.color.mappls_notification_background_color);
                this.color = Color.parseColor((this.f711app.getResources().getConfiguration().uiMode & 48) == 32 ? "#FFFFFF" : "#000000");
                String formattedDistanceRound = DirectionFormatter.getFormattedDistanceRound(NavigationContext.getNavigationContext().h().h());
                String formattedDuration = NavigationFormatter.getFormattedDuration(Math.max(NavigationContext.getNavigationContext().h().j(), 60), this.f711app);
                String str = DateFormat.getTimeInstance(3).format(new Date(System.currentTimeMillis() + ((long) (NavigationContext.getNavigationContext().h().j() * 1000))));
                if (dVarH.t() && z2) {
                    if (d.p()) {
                        cVarA = com.mappls.sdk.navigation.router.c.a(12, this.leftSide);
                        iL = (int) dVarH.l();
                        navigationStep = null;
                    } else {
                        NavigationRoute.a aVar = new NavigationRoute.a();
                        NavigationRoute.a aVarA = dVarH.a(aVar, true);
                        if (aVarA == null || aVarA.b <= 0 || (navigationStep2 = aVarA.a) == null) {
                            navigationStep = null;
                            iL = 0;
                            cVarA = null;
                        } else {
                            com.mappls.sdk.navigation.router.c turnType = navigationStep2.getTurnType();
                            iL = aVarA.b;
                            int i2 = dVarH.a(aVarA, aVar).b;
                            navigationStep = navigationStep2;
                            cVarA = turnType;
                        }
                    }
                    if (navigationStep != null) {
                        try {
                            if (navigationStep.getExtraInfo() != null && (navigationStep.getExtraInfo() instanceof LegStep)) {
                                drawable = AppCompatResources.getDrawable(this.f711app, ManeuverUtils.getManeuverResource((LegStep) navigationStep.getExtraInfo()));
                                if (drawable != null) {
                                    this.turnBitmap = drawableToBitmap(drawable);
                                }
                            } else if (navigationStep != null && navigationStep.getManeuverID() >= 0) {
                                drawable = MapplsNavigationHelper.getInstance().getManeuverInfo(this.f711app, navigationStep.getManeuverID()).getIcon();
                                this.turnBitmap = drawableToBitmap(drawable);
                            }
                        } catch (Exception e) {
                            NavigationLogger.d(e);
                        }
                    } else if (navigationStep != null) {
                        drawable = MapplsNavigationHelper.getInstance().getManeuverInfo(this.f711app, navigationStep.getManeuverID()).getIcon();
                        this.turnBitmap = drawableToBitmap(drawable);
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(DirectionFormatter.getFormattedDistanceRound(iL));
                    if (cVarA == null || navigationStep == null) {
                        string2 = "";
                    } else {
                        StringBuilder sbA = h.a(" • ");
                        sbA.append(navigationStep.getDescriptionRoutePart());
                        string2 = sbA.toString();
                    }
                    sb2.append(string2);
                    string = sb2.toString();
                    if (navigationStep == null || com.mappls.sdk.navigation.util.a.a(navigationStep.getDescriptionRoutePart())) {
                        NavigationLogger.w("ri is null", new Object[0]);
                    } else {
                        string = navigationStep.getDescriptionRoutePart();
                    }
                    int i3 = dVarH.i();
                    if (i3 > 0) {
                        int nextIntermediate = dVarH.k().getNextIntermediate();
                        ArrayList arrayListC = NavigationContext.getNavigationContext().m().c();
                        if (nextIntermediate < arrayListC.size()) {
                            w.a aVar2 = (w.a) arrayListC.get(nextIntermediate);
                            sb.append(DirectionFormatter.getFormattedDistanceRound(i3));
                            sb.append(" • ");
                            sb.append(aVar2.a());
                            sb.append("\n");
                        }
                    }
                    sb.append(formattedDistanceRound);
                    sb.append(" • ");
                    sb.append(formattedDuration);
                    sb.append(" • ");
                    sb.append(str);
                    strG = " ETA";
                } else {
                    string = this.f711app.getString(R.string.mappls_shared_string_navigation);
                    strG = dVarH.g();
                    if (com.mappls.sdk.navigation.util.a.a(strG)) {
                        strG = this.f711app.getString(R.string.mappls_route_calculation);
                    }
                }
                sb.append(strG);
                String str2 = string;
                NavigationLogger.d("returned Notificatiion", new Object[0]);
                return createNotification(z, str2, sb.toString(), this.turnBitmap, wholeDistance, iH);
            }
        }
        NavigationLogger.d("returned null", new Object[0]);
        return null;
    }

    public Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) this.f711app.getResources().getDimension(android.R.dimen.notification_large_icon_width), (int) this.f711app.getResources().getDimension(android.R.dimen.notification_large_icon_height), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        if (bitmapCreateBitmap != null) {
            Paint paint = new Paint();
            paint.setColorFilter((this.f711app.getResources().getConfiguration().uiMode & 48) == 32 ? new PorterDuffColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN) : new PorterDuffColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_IN));
            new Canvas(bitmapCreateBitmap).drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, paint);
        }
        return bitmapCreateBitmap;
    }

    @Override // com.mappls.sdk.navigation.notifications.a
    public int getNavigationNotificationId() {
        return 5;
    }

    @Override // com.mappls.sdk.navigation.notifications.a
    public int getNavigationWearableNotificationId() {
        return 1005;
    }

    @Override // com.mappls.sdk.navigation.notifications.a
    public int getPriority() {
        return 1;
    }

    @Override // com.mappls.sdk.navigation.notifications.a
    public com.mappls.sdk.navigation.notifications.a.EnumC0097a getType() {
        return com.mappls.sdk.navigation.notifications.a.EnumC0097a.NAVIGATION;
    }

    @Override // com.mappls.sdk.navigation.notifications.a
    public void init() {
        this.leftSide = ((s.l) NavigationContext.getNavigationContext().k().B0.get()).a;
        a aVar = new a();
        b bVar = new b();
        c cVar = new c();
        if (Build.VERSION.SDK_INT >= 33) {
            this.f711app.registerReceiver(aVar, new IntentFilter(NAVIGATION_PAUSE_NAVIGATION_SERVICE_ACTION), 4);
            this.f711app.registerReceiver(bVar, new IntentFilter(NAVIGATION_RESUME_NAVIGATION_SERVICE_ACTION), 4);
            this.f711app.registerReceiver(cVar, new IntentFilter("com.mmi.maps.navigation.EXIT"), 4);
        } else {
            this.f711app.registerReceiver(aVar, new IntentFilter(NAVIGATION_PAUSE_NAVIGATION_SERVICE_ACTION));
            this.f711app.registerReceiver(bVar, new IntentFilter(NAVIGATION_RESUME_NAVIGATION_SERVICE_ACTION));
            this.f711app.registerReceiver(cVar, new IntentFilter("com.mmi.maps.navigation.EXIT"));
        }
    }

    @Override // com.mappls.sdk.navigation.notifications.a
    public boolean isActive() {
        return isEnabled();
    }

    @Override // com.mappls.sdk.navigation.notifications.a
    public boolean isEnabled() {
        NavigationService navigationServiceF = NavigationContext.getNavigationContext().f();
        if (navigationServiceF != null) {
            int iE = navigationServiceF.e();
            int i = NavigationService.o;
            if ((iE & 1) != 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.mappls.sdk.navigation.notifications.a
    public void setupNotification(Notification notification) {
    }
}
