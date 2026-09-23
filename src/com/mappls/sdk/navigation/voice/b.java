package com.mappls.sdk.navigation.voice;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.mappls.sdk.navigation.apis.NavigationLogger;
import com.mappls.sdk.navigation.h;
import com.mappls.sdk.navigation.n;
import com.mappls.sdk.navigation.routing.NavigationStep;
import com.mappls.sdk.navigation.textinstructions.TextInstructionHelper;
import com.mappls.sdk.navigation.util.NavigationUtils;
import com.mappls.sdk.plugin.directions.DirectionFormatter;
import com.mappls.sdk.services.api.directions.models.LegStep;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private final c a;
    private ArrayList b = new ArrayList();

    public b(a aVar) {
        this.a = aVar;
    }

    private b a(String str) {
        NavigationLogger.d(str, new Object[0]);
        this.b.add(str);
        return this;
    }

    static String a(int i) {
        switch (i) {
            case 1:
                return "first ";
            case 2:
                return "second ";
            case 3:
                return "third ";
            case 4:
                return "fourth ";
            case 5:
                return "fifth ";
            case 6:
                return "sixth ";
            case 7:
                return "seventh ";
            case 8:
                return "eighth ";
            case 9:
                return "nineth ";
            case 10:
                return "tenth ";
            case 11:
                return "eleventh ";
            case 12:
                return "twelfth ";
            case 13:
                return "thirteenth ";
            case 14:
                return "fourteenth ";
            case 15:
                return "fifteenth ";
            case 16:
                return "sixteenth ";
            case 17:
                return "seventeenth ";
            default:
                return "";
        }
    }

    private static String a(NavigationStep navigationStep) {
        return TextInstructionHelper.getInstance().getInstruction((LegStep) navigationStep.getExtraInfo(), true).split("\\$")[0];
    }

    private static String b(NavigationStep navigationStep) {
        String shortInstruction = TextInstructionHelper.getInstance().getShortInstruction((LegStep) navigationStep.getExtraInfo());
        return (!((LegStep) navigationStep.getExtraInfo()).maneuver().type().equalsIgnoreCase("roundabout") || shortInstruction.contains("exit")) ? shortInstruction : n.a(shortInstruction, " exit");
    }

    private static String j(String str) {
        return (TextUtils.isEmpty(str) || !str.contains(",")) ? str : str.replace(",", "&");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static String k(String str) {
        str.hashCode();
        String str2 = "then";
        byte b = -1;
        switch (str.hashCode()) {
            case -2032923755:
                if (str.equals("take_left_at_intersection")) {
                    b = 0;
                }
                break;
            case -1995243783:
                if (str.equals("and_arrive_intermediate")) {
                    b = 1;
                }
                break;
            case -1913017095:
                if (str.equals("location_recovered")) {
                    b = 2;
                }
                break;
            case -1891021735:
                if (str.equals("speed_alarm")) {
                    b = 3;
                }
                break;
            case -1858374222:
                if (str.equals("bear_left")) {
                    b = 4;
                }
                break;
            case -1796839058:
                if (str.equals("location_lost")) {
                    b = 5;
                }
                break;
            case -1769365039:
                if (str.equals("bear_right")) {
                    b = 6;
                }
                break;
            case -1763483894:
                if (str.equals("take_right_at_end")) {
                    b = 7;
                }
                break;
            case -1748384171:
                if (str.equals("border_crossing")) {
                    b = 8;
                }
                break;
            case -1743222074:
                if (str.equals("reached_intermediate")) {
                    b = 9;
                }
                break;
            case -1605024242:
                if (str.equals("and_arrive_destination")) {
                    b = 10;
                }
                break;
            case -1436079272:
                if (str.equals("right_sh")) {
                    b = Ascii.VT;
                }
                break;
            case -1436079268:
                if (str.equals("right_sl")) {
                    b = Ascii.FF;
                }
                break;
            case -1387916344:
                if (str.equals("right_keep")) {
                    b = Ascii.CR;
                }
                break;
            case -1380797366:
                if (str.equals("and_arrive_poi")) {
                    b = Ascii.SO;
                }
                break;
            case -1363373215:
                if (str.equals("highway_exit_left_driving_road")) {
                    b = Ascii.SI;
                }
                break;
            case -1277915446:
                if (str.equals("route_new_calc")) {
                    b = Ascii.DLE;
                }
                break;
            case -1022962709:
                if (str.equals("at_fork_right")) {
                    b = 17;
                }
                break;
            case -1002275663:
                if (str.equals("keep_left_at")) {
                    b = Ascii.DC2;
                }
                break;
            case -940798574:
                if (str.equals("leave_ferry")) {
                    b = 19;
                }
                break;
            case -866040319:
                if (str.equals("and_arrive_waypoint")) {
                    b = Ascii.DC4;
                }
                break;
            case -860341416:
                if (str.equals("prepare_make_ut")) {
                    b = Ascii.NAK;
                }
                break;
            case -787359902:
                if (str.equals("take_ferry")) {
                    b = Ascii.SYN;
                }
                break;
            case -684025865:
                if (str.equals("highway_enter_left_driving_road")) {
                    b = Ascii.ETB;
                }
                break;
            case -563553990:
                if (str.equals("take_right_at_intersection")) {
                    b = Ascii.CAN;
                }
                break;
            case -515766372:
                if (str.equals("and_arrive_favorite")) {
                    b = Ascii.EM;
                }
                break;
            case -353951458:
                if (str.equals("attention")) {
                    b = Ascii.SUB;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    b = Ascii.ESC;
                }
                break;
            case 3558941:
                if (str.equals("then")) {
                    b = Ascii.FS;
                }
                break;
            case 55443853:
                if (str.equals("left_sh")) {
                    b = Ascii.GS;
                }
                break;
            case 55443857:
                if (str.equals("left_sl")) {
                    b = Ascii.RS;
                }
                break;
            case 108511772:
                if (str.equals("right")) {
                    b = Ascii.US;
                }
                break;
            case 134370480:
                if (str.equals("keep_right_at")) {
                    b = 32;
                }
                break;
            case 280388531:
                if (str.equals("take_left_at")) {
                    b = 33;
                }
                break;
            case 432844764:
                if (str.equals("event_ahead")) {
                    b = 34;
                }
                break;
            case 602516200:
                if (str.equals("make_ut_wp")) {
                    b = 35;
                }
                break;
            case 832601744:
                if (str.equals("make_ut")) {
                    b = 36;
                }
                break;
            case 846643278:
                if (str.equals("reached_waypoint")) {
                    b = 37;
                }
                break;
            case 946027997:
                if (str.equals("reached_poi")) {
                    b = 38;
                }
                break;
            case 1035504801:
                if (str.equals("reached_destination")) {
                    b = 39;
                }
                break;
            case 1121192527:
                if (str.equals("take_left_at_end")) {
                    b = 40;
                }
                break;
            case 1196917225:
                if (str.equals("reached_favorite")) {
                    b = 41;
                }
                break;
            case 1242254830:
                if (str.equals("take_right_at")) {
                    b = 42;
                }
                break;
            case 1529331777:
                if (str.equals("back_on_route")) {
                    b = 43;
                }
                break;
            case 1662048170:
                if (str.equals("go_ahead")) {
                    b = 44;
                }
                break;
            case 1741697213:
                if (str.equals("left_keep")) {
                    b = 45;
                }
                break;
            case 1773581177:
                if (str.equals("off_route")) {
                    b = 46;
                }
                break;
            case 1906481240:
                if (str.equals("at_fork_left")) {
                    b = 47;
                }
                break;
            case 1931801600:
                if (str.equals("continue_straight_at")) {
                    b = 48;
                }
                break;
        }
        switch (b) {
            case 0:
                str2 = " Keep left at next ";
                break;
            case 1:
                str2 = " and you will arrive at your intermediate destination ";
                break;
            case 2:
                str2 = " g p s mode recovered ";
                break;
            case 3:
                str2 = " you are exceeding the speed limit ";
                break;
            case 4:
            case 45:
                str2 = " keep left ";
                break;
            case 5:
                str2 = " g p s mode lost ";
                break;
            case 6:
            case 13:
                str2 = " keep right ";
                break;
            case 7:
                str2 = " At the end of the road turn right ";
                break;
            case 8:
                str2 = " Border crossing ";
                break;
            case 9:
                str2 = " you have reached your intermediate destination ";
                break;
            case 10:
                str2 = " and you will arrive at your destination ";
                break;
            case 11:
                str2 = " turn sharply right ";
                break;
            case 12:
                str2 = " turn slightly right ";
                break;
            case 14:
                str2 = "and pass POI ";
                break;
            case 15:
                str2 = " Highway exit left-driving road";
                break;
            case 16:
                str2 = " The trip is ";
                break;
            case 17:
                str2 = " At the fork bear right";
                break;
            case 18:
                str2 = " At the next intersection bear left ";
                break;
            case 19:
                str2 = " Leave ferry ";
                break;
            case 20:
                str2 = " and pass waypoint ";
                break;
            case 21:
            case 36:
                str2 = " Make a U turn ";
                break;
            case 22:
                str2 = " take ferry ";
                break;
            case 23:
                str2 = " Highway enter left-driving road ";
                break;
            case 24:
                str2 = " Keep right at next ";
                break;
            case 25:
                str2 = " and pass favorite ";
                break;
            case 26:
                str2 = " attention ";
                break;
            case 27:
                str2 = " turn left ";
                break;
            case 28:
                break;
            case 29:
                str2 = " turn sharply left ";
                break;
            case 30:
                str2 = " turn slightly left ";
                break;
            case 31:
                str2 = " turn right ";
                break;
            case 32:
                str2 = " At the next intersection bear right ";
                break;
            case 33:
                str2 = " Take the 1st left ";
                break;
            case 34:
                str2 = "";
                break;
            case 35:
                str2 = " When possible, please make a U turn ";
                break;
            case 37:
                str2 = " you are passing waypoint ";
                break;
            case 38:
                str2 = " you are passing POI ";
                break;
            case 39:
                str2 = " you have reached your destination ";
                break;
            case 40:
                str2 = " At the end of the road turn left ";
                break;
            case 41:
                str2 = " you are passing favorite ";
                break;
            case 42:
                str2 = " Take the 1st right ";
                break;
            case 43:
                str2 = " you are back on the route ";
                break;
            case 44:
                str2 = " Go straight ahead ";
                break;
            case 46:
                str2 = " you have been off the route for ";
                break;
            case 47:
                str2 = " At the fork bear left";
                break;
            case 48:
                str2 = " Continue straight at next";
                break;
            default:
                return null;
        }
        return str2;
    }

    public final b a(double d) {
        return a(k("off_route") + DirectionFormatter.getFormattedDistanceRound((float) d, NavigationUtils.getDistanceType(), true));
    }

    public final b a(double d, String str, NavigationStep navigationStep) {
        String strK;
        if (navigationStep != null && navigationStep.getExtraInfo() != null && (navigationStep.getExtraInfo() instanceof LegStep)) {
            str = "this route";
        }
        if (TextUtils.isEmpty(str)) {
            strK = k("go_ahead");
        } else {
            StringBuilder sbA = h.a(" Follow ");
            sbA.append(j(str));
            sbA.append(" for ");
            sbA.append(DirectionFormatter.getFormattedDistanceRound((float) d, NavigationUtils.getDistanceType(), true));
            strK = sbA.toString();
        }
        return a(strK);
    }

    protected final ArrayList a() {
        c cVar = this.a;
        ArrayList arrayList = this.b;
        ((a) cVar).getClass();
        return arrayList;
    }

    public final void a(String str, NavigationStep navigationStep) {
        String strK;
        if (navigationStep.getExtraInfo() != null && (navigationStep.getExtraInfo() instanceof LegStep)) {
            strK = a(navigationStep);
        } else if (TextUtils.isEmpty(str)) {
            strK = k("bear_left");
        } else {
            strK = k("bear_left") + " at " + j(str);
        }
        a(strK);
    }

    public final void a(String str, String str2, NavigationStep navigationStep) {
        String strK;
        if (navigationStep == null || navigationStep.getExtraInfo() == null || !(navigationStep.getExtraInfo() instanceof LegStep)) {
            if (TextUtils.isEmpty(str2)) {
                strK = k(str);
            } else {
                strK = k(str) + " on " + j(str2);
            }
        } else if (((LegStep) navigationStep.getExtraInfo()).maneuver().type().equalsIgnoreCase("arrive") || navigationStep.isDestination() || navigationStep.getManeuverID() == 8) {
            return;
        } else {
            strK = b(navigationStep);
        }
        a(strK);
    }

    public final b b(String str) {
        String strK;
        if (TextUtils.isEmpty(str)) {
            strK = k("and_arrive_favorite");
        } else {
            strK = k("and_arrive_favorite") + str;
        }
        return a(strK);
    }

    public final void b() {
        a(k("go_ahead"));
    }

    public final void b(String str, NavigationStep navigationStep) {
        String strK;
        if (navigationStep.getExtraInfo() != null && (navigationStep.getExtraInfo() instanceof LegStep)) {
            strK = a(navigationStep);
        } else if (TextUtils.isEmpty(str)) {
            strK = k("bear_right");
        } else {
            strK = k("bear_right") + " at " + j(str);
        }
        a(strK);
    }

    public final b c() {
        return a(k("make_ut_wp"));
    }

    public final b c(double d, String str, NavigationStep navigationStep) {
        if (navigationStep.getExtraInfo() != null && (navigationStep.getExtraInfo() instanceof LegStep)) {
            StringBuilder sbA = h.a(" after ");
            sbA.append(DirectionFormatter.getFormattedDistanceRound((float) d, NavigationUtils.getDistanceType(), true));
            sbA.append(StringUtils.SPACE);
            sbA.append(a(navigationStep));
            return a(sbA.toString());
        }
        if (TextUtils.isEmpty(str)) {
            StringBuilder sbA2 = h.a(" after ");
            sbA2.append(DirectionFormatter.getFormattedDistanceRound((float) d, NavigationUtils.getDistanceType(), true));
            sbA2.append(k("prepare_make_ut"));
            return a(sbA2.toString());
        }
        StringBuilder sbA3 = h.a(" after ");
        sbA3.append(DirectionFormatter.getFormattedDistanceRound((float) d, NavigationUtils.getDistanceType(), true));
        sbA3.append(k("prepare_make_ut"));
        sbA3.append(" On ");
        sbA3.append(j(str));
        return a(sbA3.toString());
    }

    public final b c(String str) {
        String strK;
        if (TextUtils.isEmpty(str)) {
            strK = k("and_arrive_poi");
        } else {
            strK = k("and_arrive_poi") + str;
        }
        return a(strK);
    }

    public final void c(String str, NavigationStep navigationStep) {
        String strK;
        if (navigationStep.getExtraInfo() != null && (navigationStep.getExtraInfo() instanceof LegStep)) {
            strK = b(navigationStep);
        } else if (TextUtils.isEmpty(str)) {
            strK = k("make_ut");
        } else {
            strK = k("make_ut") + " on " + j(str);
        }
        a(strK);
    }

    public final b d(String str) {
        String strK;
        if (TextUtils.isEmpty(str)) {
            strK = k("reached_destination");
        } else {
            strK = k("reached_destination") + str;
        }
        return a(strK);
    }

    public final void d() {
        ((e) this.a).a(this);
    }

    public final b e(String str) {
        String strK;
        if (TextUtils.isEmpty(str)) {
            strK = k("reached_favorite");
        } else {
            strK = k("reached_favorite") + str;
        }
        return a(strK);
    }

    public final void e() {
        ((e) this.a).a(this, true);
    }

    public final b f() {
        return a(k("speed_alarm"));
    }

    public final b f(String str) {
        String strK;
        if (TextUtils.isEmpty(str)) {
            strK = k("reached_intermediate");
        } else {
            strK = k("reached_intermediate") + str;
        }
        return a(strK);
    }

    public final b g() {
        return a(k("then"));
    }

    public final b g(String str) {
        String strK;
        if (TextUtils.isEmpty(str)) {
            strK = k("reached_poi");
        } else {
            strK = k("reached_poi") + str;
        }
        return a(strK);
    }

    public final b h(String str) {
        return a(k("attention") + ", " + str);
    }

    public final b i(String str) {
        String strK;
        if (TextUtils.isEmpty(str)) {
            strK = k("event_ahead");
        } else {
            strK = k("event_ahead") + str;
        }
        return a(strK);
    }

    public final b a(double d, int i, String str, NavigationStep navigationStep) {
        if (navigationStep.getExtraInfo() != null && (navigationStep.getExtraInfo() instanceof LegStep)) {
            return a(a(navigationStep));
        }
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sbA = h.a("after ");
            sbA.append(DirectionFormatter.getFormattedDistanceRound((float) d, NavigationUtils.getDistanceType(), true));
            sbA.append(" enter a roundabout and take the ");
            sbA.append(a(i));
            sbA.append(" Exit ");
            return a(sbA.toString());
        }
        StringBuilder sbA2 = h.a("after ");
        sbA2.append(DirectionFormatter.getFormattedDistanceRound((float) d, NavigationUtils.getDistanceType(), true));
        sbA2.append(" enter a roundabout and take the ");
        sbA2.append(a(i));
        sbA2.append(" Exit ");
        return a(sbA2.toString());
    }

    public final void b(double d, String str, NavigationStep navigationStep) {
        if (navigationStep.getExtraInfo() != null && (navigationStep.getExtraInfo() instanceof LegStep)) {
            StringBuilder sbA = h.a(" In ");
            sbA.append(DirectionFormatter.getFormattedDistanceRound((float) d, NavigationUtils.getDistanceType(), true));
            sbA.append(StringUtils.SPACE);
            sbA.append(a(navigationStep));
            a(sbA.toString());
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sbA2 = h.a(" In ");
            sbA2.append(DirectionFormatter.getFormattedDistanceRound((float) d, NavigationUtils.getDistanceType(), true));
            sbA2.append(k("make_ut"));
            sbA2.append(" On ");
            sbA2.append(j(str));
            a(sbA2.toString());
            return;
        }
        StringBuilder sbA3 = h.a(" In ");
        sbA3.append(DirectionFormatter.getFormattedDistanceRound((float) d, NavigationUtils.getDistanceType(), true));
        sbA3.append(k("make_ut"));
        a(sbA3.toString());
    }

    public final b a(String str, double d, String str2, NavigationStep navigationStep) {
        if (navigationStep.getExtraInfo() != null && (navigationStep.getExtraInfo() instanceof LegStep)) {
            StringBuilder sbA = h.a(" after ");
            sbA.append(DirectionFormatter.getFormattedDistanceRound((float) d, NavigationUtils.getDistanceType(), true));
            sbA.append(StringUtils.SPACE);
            sbA.append(a(navigationStep));
            return a(sbA.toString());
        }
        NavigationLogger.d(str, new Object[0]);
        NavigationLogger.d(str2, new Object[0]);
        if (!TextUtils.isEmpty(str2)) {
            StringBuilder sbA2 = h.a(" after ");
            sbA2.append(DirectionFormatter.getFormattedDistanceRound((float) d, NavigationUtils.getDistanceType(), true));
            sbA2.append(k(str));
            sbA2.append(" On ");
            sbA2.append(j(str2));
            return a(sbA2.toString());
        }
        StringBuilder sbA3 = h.a(" after ");
        sbA3.append(DirectionFormatter.getFormattedDistanceRound((float) d, NavigationUtils.getDistanceType(), true));
        sbA3.append(k(str));
        return a(sbA3.toString());
    }

    public final void b(double d, int i, String str, NavigationStep navigationStep) {
        if (navigationStep.getExtraInfo() != null && (navigationStep.getExtraInfo() instanceof LegStep)) {
            StringBuilder sbA = h.a(" in ");
            sbA.append(DirectionFormatter.getFormattedDistanceRound((float) d, NavigationUtils.getDistanceType(), true));
            sbA.append(StringUtils.SPACE);
            sbA.append(a(navigationStep));
            a(sbA.toString());
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sbA2 = h.a(" in ");
            sbA2.append(DirectionFormatter.getFormattedDistanceRound((float) d, NavigationUtils.getDistanceType(), true));
            sbA2.append(" enter a roundabout and take the ");
            sbA2.append(a(i));
            sbA2.append(" Exit ");
            a(sbA2.toString());
            return;
        }
        StringBuilder sbA3 = h.a(" in ");
        sbA3.append(DirectionFormatter.getFormattedDistanceRound((float) d, NavigationUtils.getDistanceType(), true));
        sbA3.append(" enter a roundabout and take the ");
        sbA3.append(a(i));
        sbA3.append(" Exit ");
        a(sbA3.toString());
    }

    public final void a(int i, String str, NavigationStep navigationStep) {
        if (navigationStep.getExtraInfo() != null && (navigationStep.getExtraInfo() instanceof LegStep)) {
            a(b(navigationStep));
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sbA = h.a(" take the ");
            sbA.append(a(i));
            sbA.append(" Exit ");
            a(sbA.toString());
            return;
        }
        StringBuilder sbA2 = h.a(" take the ");
        sbA2.append(a(i));
        sbA2.append(" Exit ");
        a(sbA2.toString());
    }

    public final void b(String str, double d, String str2, NavigationStep navigationStep) {
        if (d == 0.0d) {
            return;
        }
        if (navigationStep.getExtraInfo() != null && (navigationStep.getExtraInfo() instanceof LegStep)) {
            StringBuilder sbA = h.a(" in ");
            sbA.append(DirectionFormatter.getFormattedDistanceRound((float) d, NavigationUtils.getDistanceType(), true));
            sbA.append(StringUtils.SPACE);
            sbA.append(a(navigationStep));
            a(sbA.toString());
            return;
        }
        NavigationLogger.d(str, new Object[0]);
        NavigationLogger.d(str2, new Object[0]);
        if (!TextUtils.isEmpty(str2)) {
            StringBuilder sbA2 = h.a(" in ");
            sbA2.append(DirectionFormatter.getFormattedDistanceRound((float) d, NavigationUtils.getDistanceType(), true));
            sbA2.append(k(str));
            sbA2.append(" On ");
            sbA2.append(j(str2));
            a(sbA2.toString());
            return;
        }
        StringBuilder sbA3 = h.a(" in ");
        sbA3.append(DirectionFormatter.getFormattedDistanceRound((float) d, NavigationUtils.getDistanceType(), true));
        sbA3.append(k(str));
        a(sbA3.toString());
    }
}
