package com.mappls.sdk.navigation.ui.views.maneuver;

import android.text.TextUtils;
import com.drew.metadata.exif.makernotes.PanasonicMakernoteDirectory;
import com.drew.metadata.exif.makernotes.ReconyxHyperFireMakernoteDirectory;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.mappls.sdk.navigation.R;
import com.mappls.sdk.navigation.n;
import com.mappls.sdk.services.api.directions.models.LegStep;
import com.mappls.sdk.services.api.directions.models.StepManeuver;
import kotlin.io.encoding.Base64;
import okio.Utf8;

/* JADX INFO: loaded from: classes4.dex */
public class ManeuverUtils {
    public static int getManeuverResource(LegStep legStep) {
        StepManeuver stepManeuverManeuver = legStep.maneuver();
        String strType = stepManeuverManeuver.type();
        String strModifier = stepManeuverManeuver.modifier();
        String strDrivingSide = legStep.drivingSide();
        if (strType != null && strType.equalsIgnoreCase("roundabout")) {
            return (strDrivingSide == null || strDrivingSide.equalsIgnoreCase("left")) ? obtainManeuverRoundaboutResourceFrom(stepManeuverManeuver.degree(), true) : obtainManeuverRoundaboutResourceFrom(stepManeuverManeuver.degree(), false);
        }
        if (strType != null && strType.equalsIgnoreCase("rotary")) {
            return R.drawable.ic_maneuver_roundabout;
        }
        if (TextUtils.isEmpty(strModifier)) {
            return obtainManeuverResourceFrom(strType);
        }
        if (!isLeftDrivingSideAndRoundaboutOrRotaryOrUturn(strType, strModifier, strDrivingSide)) {
            return obtainManeuverResourceFrom(n.a(strType, strModifier));
        }
        return obtainManeuverResourceFrom(strType + strModifier + strDrivingSide);
    }

    private static boolean isLeftDrivingSideAndRoundaboutOrRotaryOrUturn(String str, String str2, String str3) {
        return "left".equals(str3) && ("roundabout".equals(str) || "rotary".equals(str) || "uturn".equals(str2));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:281:0x0448  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static int obtainManeuverResourceFrom(String str) {
        byte b;
        switch (str.hashCode()) {
            case -2069353886:
                if (!str.equals("end of roadsharp right")) {
                    b = -1;
                } else {
                    b = Ascii.FF;
                }
                break;
            case -2058784777:
                if (!str.equals("rotaryslight rightleft")) {
                    b = -1;
                } else {
                    b = 85;
                }
                break;
            case -2015176631:
                if (!str.equals("on rampright")) {
                    b = -1;
                } else {
                    b = 17;
                }
                break;
            case -1995357345:
                if (!str.equals("continuesharp right")) {
                    b = -1;
                } else {
                    b = Ascii.CR;
                }
                break;
            case -1928466355:
                if (!str.equals("roundaboutleftleft")) {
                    b = -1;
                } else {
                    b = 74;
                }
                break;
            case -1924264237:
                if (!str.equals("on rampsharp right")) {
                    b = -1;
                } else {
                    b = Ascii.VT;
                }
                break;
            case -1860475435:
                if (!str.equals("continueright")) {
                    b = -1;
                } else {
                    b = Ascii.DC4;
                }
                break;
            case -1860127047:
                if (!str.equals("roundaboutstraight")) {
                    b = -1;
                } else {
                    b = 70;
                }
                break;
            case -1857363413:
                if (!str.equals("continueuturn")) {
                    b = -1;
                } else {
                    b = 1;
                }
                break;
            case -1826064786:
                if (!str.equals("rotarysharp left")) {
                    b = -1;
                } else {
                    b = Base64.padSymbol;
                }
                break;
            case -1801004622:
                if (!str.equals("rotarystraightleft")) {
                    b = -1;
                } else {
                    b = 87;
                }
                break;
            case -1797885270:
                if (!str.equals("off rampleft")) {
                    b = -1;
                } else {
                    b = 46;
                }
                break;
            case -1695915194:
                if (!str.equals("roundaboutleft")) {
                    b = -1;
                } else {
                    b = 58;
                }
                break;
            case -1654896656:
                if (!str.equals("rotaryslight right")) {
                    b = -1;
                } else {
                    b = 69;
                }
                break;
            case -1626763293:
                if (!str.equals("exit roundaboutslight left")) {
                    b = -1;
                } else {
                    b = 40;
                }
                break;
            case -1554705391:
                if (!str.equals("notificationright")) {
                    b = -1;
                } else {
                    b = Ascii.NAK;
                }
                break;
            case -1550211583:
                if (!str.equals("forkslight right")) {
                    b = -1;
                } else {
                    b = 53;
                }
                break;
            case -1516205288:
                if (!str.equals("end of roadright")) {
                    b = -1;
                } else {
                    b = 57;
                }
                break;
            case -1471737444:
                if (!str.equals("turnuturnleft")) {
                    b = -1;
                } else {
                    b = 2;
                }
                break;
            case -1450022300:
                if (!str.equals("continuesharp left")) {
                    b = -1;
                } else {
                    b = Ascii.ESC;
                }
                break;
            case -1409157417:
                if (!str.equals("arrive")) {
                    b = -1;
                } else {
                    b = 6;
                }
                break;
            case -1335343116:
                if (!str.equals("depart")) {
                    b = -1;
                } else {
                    b = 9;
                }
                break;
            case -1300492365:
                if (!str.equals("rotaryslight left")) {
                    b = -1;
                } else {
                    b = Utf8.REPLACEMENT_BYTE;
                }
                break;
            case -1094043451:
                if (!str.equals("exit roundaboutsharp right")) {
                    b = -1;
                } else {
                    b = Ascii.SO;
                }
                break;
            case -1073872668:
                if (!str.equals("mergeright")) {
                    b = -1;
                } else {
                    b = 44;
                }
                break;
            case -1055320474:
                if (!str.equals("continueslight right")) {
                    b = -1;
                } else {
                    b = Ascii.ETB;
                }
                break;
            case -1028102467:
                if (!str.equals("roundaboutright")) {
                    b = -1;
                } else {
                    b = SignedBytes.MAX_POWER_OF_TWO;
                }
                break;
            case -925180623:
                if (!str.equals("rotary")) {
                    b = -1;
                } else {
                    b = 73;
                }
                break;
            case -875899460:
                if (!str.equals("forkstraight")) {
                    b = -1;
                } else {
                    b = 54;
                }
                break;
            case -826008882:
                if (!str.equals("roundaboutsharp rightleft")) {
                    b = -1;
                } else {
                    b = 82;
                }
                break;
            case -771347286:
                if (!str.equals("notificationslight right")) {
                    b = -1;
                } else {
                    b = Ascii.EM;
                }
                break;
            case -767772523:
                if (!str.equals("rotarysharp right")) {
                    b = -1;
                } else {
                    b = 67;
                }
                break;
            case -752934610:
                if (!str.equals("continueleft")) {
                    b = -1;
                } else {
                    b = 34;
                }
                break;
            case -729533179:
                if (!str.equals("new namestraight")) {
                    b = -1;
                } else {
                    b = 91;
                }
                break;
            case -598492041:
                if (!str.equals("mergeslight right")) {
                    b = -1;
                } else {
                    b = 45;
                }
                break;
            case -532588228:
                if (!str.equals("turnslight right")) {
                    b = -1;
                } else {
                    b = Ascii.SYN;
                }
                break;
            case -435130804:
                if (!str.equals("mergeslight left")) {
                    b = -1;
                } else {
                    b = 43;
                }
                break;
            case -372303643:
                if (!str.equals("notificationstraight")) {
                    b = -1;
                } else {
                    b = 89;
                }
                break;
            case -366904923:
                if (!str.equals("arriveright")) {
                    b = -1;
                } else {
                    b = 5;
                }
                break;
            case -327557189:
                if (!str.equals("exit roundaboutright")) {
                    b = -1;
                } else {
                    b = 19;
                }
                break;
            case -326187125:
                if (!str.equals("end of roadleft")) {
                    b = -1;
                } else {
                    b = 56;
                }
                break;
            case -236347846:
                if (!str.equals("rotaryslight leftleft")) {
                    b = -1;
                } else {
                    b = 79;
                }
                break;
            case -144622913:
                if (!str.equals("roundabout")) {
                    b = -1;
                } else {
                    b = 72;
                }
                break;
            case -116818760:
                if (!str.equals("rotaryleft")) {
                    b = -1;
                } else {
                    b = 59;
                }
                break;
            case -107018305:
                if (!str.equals("turnright")) {
                    b = -1;
                } else {
                    b = Ascii.DLE;
                }
                break;
            case -103906283:
                if (!str.equals("turnuturn")) {
                    b = -1;
                } else {
                    b = 0;
                }
                break;
            case -50189438:
                if (!str.equals("forkslight left")) {
                    b = -1;
                } else {
                    b = 51;
                }
                break;
            case 3148994:
                if (!str.equals("fork")) {
                    b = -1;
                } else {
                    b = 55;
                }
                break;
            case 57950369:
                if (!str.equals("continuestraight")) {
                    b = -1;
                } else {
                    b = 90;
                }
                break;
            case 105792473:
                if (!str.equals("off rampright")) {
                    b = -1;
                } else {
                    b = 48;
                }
                break;
            case 134912516:
                if (!str.equals("turnleft")) {
                    b = -1;
                } else {
                    b = Ascii.RS;
                }
                break;
            case 252029881:
                if (!str.equals("notificationslight left")) {
                    b = -1;
                } else {
                    b = 41;
                }
                break;
            case 272060992:
                if (!str.equals("roundaboutstraightleft")) {
                    b = -1;
                } else {
                    b = 86;
                }
                break;
            case 399415090:
                if (!str.equals("mergestraight")) {
                    b = -1;
                } else {
                    b = 88;
                }
                break;
            case 418168958:
                if (!str.equals("roundaboutslight right")) {
                    b = -1;
                } else {
                    b = 68;
                }
                break;
            case 472546249:
                if (!str.equals("forkleft")) {
                    b = -1;
                } else {
                    b = 50;
                }
                break;
            case 489001018:
                if (!str.equals("on rampleft")) {
                    b = -1;
                } else {
                    b = Ascii.US;
                }
                break;
            case 496155779:
                if (!str.equals("roundaboutsharp leftleft")) {
                    b = -1;
                } else {
                    b = 76;
                }
                break;
            case 528634536:
                if (!str.equals("departright")) {
                    b = -1;
                } else {
                    b = 8;
                }
                break;
            case 567496037:
                if (!str.equals("roundaboutslight left")) {
                    b = -1;
                } else {
                    b = 62;
                }
                break;
            case 630481008:
                if (!str.equals("on rampsharp left")) {
                    b = -1;
                } else {
                    b = Ascii.FS;
                }
                break;
            case 679246731:
                if (!str.equals("rotaryright")) {
                    b = -1;
                } else {
                    b = 65;
                }
                break;
            case 708772031:
                if (!str.equals("rotaryleftleft")) {
                    b = -1;
                } else {
                    b = 75;
                }
                break;
            case 738059649:
                if (!str.equals("off rampslight left")) {
                    b = -1;
                } else {
                    b = 47;
                }
                break;
            case 777111339:
                if (!str.equals("rotarystraight")) {
                    b = -1;
                } else {
                    b = 71;
                }
                break;
            case 784749723:
                if (!str.equals("notificationsharp right")) {
                    b = -1;
                } else {
                    b = Ascii.SI;
                }
                break;
            case 848154107:
                if (!str.equals("departleft")) {
                    b = -1;
                } else {
                    b = 7;
                }
                break;
            case 962845946:
                if (!str.equals("exit rotaryleft")) {
                    b = -1;
                } else {
                    b = 35;
                }
                break;
            case 1019471429:
                if (!str.equals("roundabout turnleft")) {
                    b = -1;
                } else {
                    b = 36;
                }
                break;
            case 1100215879:
                if (!str.equals("roundaboutsharp right")) {
                    b = -1;
                } else {
                    b = 66;
                }
                break;
            case 1126609644:
                if (!str.equals("roundaboutslight leftleft")) {
                    b = -1;
                } else {
                    b = 78;
                }
                break;
            case 1144926069:
                if (!str.equals("rotarysharp leftleft")) {
                    b = -1;
                } else {
                    b = 77;
                }
                break;
            case 1148565874:
                if (!str.equals("on rampslight right")) {
                    b = -1;
                } else {
                    b = Ascii.CAN;
                }
                break;
            case 1229563111:
                if (!str.equals("turnslight left")) {
                    b = -1;
                } else {
                    b = 37;
                }
                break;
            case 1320116292:
                if (!str.equals("roundaboutrightleft")) {
                    b = -1;
                } else {
                    b = 80;
                }
                break;
            case 1335522482:
                if (!str.equals("continueuturnleft")) {
                    b = -1;
                } else {
                    b = 3;
                }
                break;
            case 1410673634:
                if (!str.equals("off rampslight right")) {
                    b = -1;
                } else {
                    b = 49;
                }
                break;
            case 1470127634:
                if (!str.equals("rotaryrightleft")) {
                    b = -1;
                } else {
                    b = 81;
                }
                break;
            case 1512002398:
                if (!str.equals("arriveleft")) {
                    b = -1;
                } else {
                    b = 4;
                }
                break;
            case 1538191749:
                if (!str.equals("roundaboutslight rightleft")) {
                    b = -1;
                } else {
                    b = 84;
                }
                break;
            case 1544504222:
                if (!str.equals("roundabout turnright")) {
                    b = -1;
                } else {
                    b = Ascii.DC2;
                }
                break;
            case 1612233586:
                if (!str.equals("notificationleft")) {
                    b = -1;
                } else {
                    b = 32;
                }
                break;
            case 1627744319:
                if (!str.equals("mergeleft")) {
                    b = -1;
                } else {
                    b = 42;
                }
                break;
            case 1687699880:
                if (!str.equals("notificationsharp left")) {
                    b = -1;
                } else {
                    b = Ascii.GS;
                }
                break;
            case 1719233210:
                if (!str.equals("turnsharp left")) {
                    b = -1;
                } else {
                    b = Ascii.SUB;
                }
                break;
            case 1762282953:
                if (!str.equals("turnsharp right")) {
                    b = -1;
                } else {
                    b = 10;
                }
                break;
            case 1766890109:
                if (!str.equals("continueslight left")) {
                    b = -1;
                } else {
                    b = 39;
                }
                break;
            case 1769692826:
                if (!str.equals("forkright")) {
                    b = -1;
                } else {
                    b = 52;
                }
                break;
            case 1790366344:
                if (!str.equals("exit roundaboutleft")) {
                    b = -1;
                } else {
                    b = 33;
                }
                break;
            case 1837983217:
                if (!str.equals("on rampslight left")) {
                    b = -1;
                } else {
                    b = 38;
                }
                break;
            case 2106000924:
                if (!str.equals("rotarysharp rightleft")) {
                    b = -1;
                } else {
                    b = 83;
                }
                break;
            case 2113518204:
                if (!str.equals("roundaboutsharp left")) {
                    b = -1;
                } else {
                    b = 60;
                }
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
            case 1:
                return R.drawable.ic_maneuver_turn_180;
            case 2:
            case 3:
                return R.drawable.ic_maneuver_turn_180_left_driving_side;
            case 4:
                return R.drawable.ic_maneuver_arrive_left;
            case 5:
                return R.drawable.ic_maneuver_arrive_right;
            case 6:
                return R.drawable.ic_maneuver_arrive;
            case 7:
                return R.drawable.ic_maneuver_depart_left;
            case 8:
                return R.drawable.ic_maneuver_depart_right;
            case 9:
                return R.drawable.ic_maneuver_depart;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return R.drawable.ic_maneuver_turn_75;
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                return R.drawable.ic_maneuver_turn_45;
            case 22:
            case 23:
            case 24:
            case 25:
                return R.drawable.ic_maneuver_turn_30;
            case 26:
            case 27:
            case 28:
            case 29:
                return R.drawable.ic_maneuver_turn_75_left;
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
                return R.drawable.ic_maneuver_turn_45_left;
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
                return R.drawable.ic_maneuver_turn_30_left;
            case 42:
            case 43:
                return R.drawable.ic_maneuver_merge_left;
            case 44:
            case 45:
                return R.drawable.ic_maneuver_merge_right;
            case 46:
                return R.drawable.ic_maneuver_off_ramp_left;
            case 47:
                return R.drawable.ic_maneuver_off_ramp_slight_left;
            case 48:
                return R.drawable.ic_maneuver_off_ramp_right;
            case 49:
                return R.drawable.ic_maneuver_off_ramp_slight_right;
            case 50:
                return R.drawable.ic_maneuver_fork_left;
            case 51:
                return R.drawable.ic_maneuver_fork_slight_left;
            case 52:
                return R.drawable.ic_maneuver_fork_right;
            case 53:
                return R.drawable.ic_maneuver_fork_slight_right;
            case 54:
                return R.drawable.ic_maneuver_fork_straight;
            case 55:
                return R.drawable.ic_maneuver_fork;
            case 56:
                return R.drawable.ic_maneuver_end_of_road_left;
            case 57:
                return R.drawable.ic_maneuver_end_of_road_right;
            case 58:
            case 59:
                return R.drawable.ic_maneuver_roundabout_left;
            case 60:
            case 61:
                return R.drawable.ic_maneuver_roundabout_sharp_left;
            case 62:
            case 63:
                return R.drawable.ic_maneuver_roundabout_slight_left;
            case 64:
            case 65:
                return R.drawable.ic_maneuver_roundabout_right;
            case 66:
            case 67:
                return R.drawable.ic_maneuver_roundabout_sharp_right;
            case 68:
            case 69:
                return R.drawable.ic_maneuver_roundabout_slight_right;
            case 70:
            case PanasonicMakernoteDirectory.TAG_WB_ADJUST_GM /* 71 */:
                return R.drawable.ic_maneuver_roundabout_straight;
            case 72:
            case 73:
                return R.drawable.ic_maneuver_roundabout;
            case ReconyxHyperFireMakernoteDirectory.TAG_BRIGHTNESS /* 74 */:
            case 75:
                return R.drawable.ic_maneuver_roundabout_left_left_driving_side;
            case 76:
            case PanasonicMakernoteDirectory.TAG_AF_POINT_POSITION /* 77 */:
                return R.drawable.ic_maneuver_roundabout_sharp_left_left_driving_side;
            case 78:
            case 79:
                return R.drawable.ic_maneuver_roundabout_slight_left_left_driving_side;
            case 80:
            case PanasonicMakernoteDirectory.TAG_LENS_TYPE /* 81 */:
                return R.drawable.ic_maneuver_roundabout_right_left_driving_side;
            case 82:
            case PanasonicMakernoteDirectory.TAG_ACCESSORY_TYPE /* 83 */:
                return R.drawable.ic_maneuver_roundabout_sharp_right_left_driving_side;
            case 84:
            case JpegTranscoderUtils.DEFAULT_JPEG_QUALITY /* 85 */:
                return R.drawable.ic_maneuver_roundabout_slight_right_left_driving_side;
            case ReconyxHyperFireMakernoteDirectory.TAG_USER_LABEL /* 86 */:
            case 87:
                return R.drawable.ic_maneuver_roundabout_straight_left_driving_side;
            default:
                return R.drawable.ic_maneuver_turn_0;
        }
    }

    private static int obtainManeuverRoundaboutResourceFrom(Double d, boolean z) {
        if (d == null) {
            return z ? R.drawable.ic_maneuver_roundabout_straight_left_driving_side : R.drawable.ic_maneuver_roundabout_straight;
        }
        if (d.doubleValue() <= 45.0d) {
            return z ? R.drawable.ic_maneuver_roundabout_sharp_right_left_driving_side : R.drawable.ic_maneuver_roundabout_sharp_right;
        }
        if (d.doubleValue() <= 90.0d) {
            return z ? R.drawable.ic_maneuver_roundabout_right_left_driving_side : R.drawable.ic_maneuver_roundabout_right;
        }
        if (d.doubleValue() <= 135.0d) {
            return z ? R.drawable.ic_maneuver_roundabout_slight_right_left_driving_side : R.drawable.ic_maneuver_roundabout_slight_right;
        }
        if (d.doubleValue() <= 180.0d) {
            return z ? R.drawable.ic_maneuver_roundabout_straight_left_driving_side : R.drawable.ic_maneuver_roundabout_straight;
        }
        if (d.doubleValue() <= 225.0d) {
            return z ? R.drawable.ic_maneuver_roundabout_slight_left_left_driving_side : R.drawable.ic_maneuver_roundabout_slight_left;
        }
        if (d.doubleValue() <= 270.0d) {
            return z ? R.drawable.ic_maneuver_roundabout_left_left_driving_side : R.drawable.ic_maneuver_roundabout_left;
        }
        if (d.doubleValue() <= 360.0d) {
            return z ? R.drawable.ic_maneuver_roundabout_sharp_left_left_driving_side : R.drawable.ic_maneuver_roundabout_sharp_left;
        }
        return z ? R.drawable.ic_maneuver_roundabout_straight_left_driving_side : R.drawable.ic_maneuver_roundabout_straight;
    }
}
