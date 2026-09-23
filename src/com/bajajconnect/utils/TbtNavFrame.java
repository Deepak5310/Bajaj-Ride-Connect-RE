package com.bajajconnect.utils;

import com.bajajconnect.enums.PrimaryTurns;
import com.bajajconnect.variables.GlobalVar;
import com.google.android.libraries.mapsplatform.turnbyturn.model.NavInfo;
import com.google.android.libraries.mapsplatform.turnbyturn.model.StepInfo;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class TbtNavFrame {
    public static final int GOOGLE_DESTINATION_REACHED_THRESHOLD_METERS = 80;
    public static final int GOOGLE_POST_ARRIVAL_RESUME_METERS = 80;
    private static int lastGoogleRoundaboutAngleExit;
    private static Boolean lastGoogleRoundaboutClockwiseBand;
    private static int lastGoogleRoundaboutExit;

    public static int googleRoundaboutSeverityToExitAngle(int i, int i2) {
        switch (i) {
            case 43:
            case 44:
                if (i2 < 1 || i2 > 7) {
                    return 4;
                }
                return i2;
            case 45:
            case 46:
                return 4;
            case 47:
            case 48:
                return 2;
            case 49:
            case 50:
                return 6;
            case 51:
            case 52:
                return 1;
            case 53:
            case 54:
                return 5;
            case 55:
            case 56:
                return 3;
            case 57:
            case 58:
            case 59:
            case 60:
                return 7;
            default:
                if (i2 < 1 || i2 > 7) {
                    return 0;
                }
                return i2;
        }
    }

    private TbtNavFrame() {
    }

    public static void resetGoogleRoundaboutStickyState() {
        lastGoogleRoundaboutExit = 0;
        lastGoogleRoundaboutAngleExit = 0;
        lastGoogleRoundaboutClockwiseBand = null;
    }

    public static byte[] buildNavHelperFrame(int i, int i2, boolean z, int i3, int i4, int i5, int i6, int i7, String str) {
        byte[] distance = NavigationHelper.formatDistance(i3);
        byte[] distance2 = NavigationHelper.formatDistance(i4);
        String strTrim = str == null ? "" : str.replaceAll("[^0-9a-zA-Z.]", StringUtils.SPACE).trim();
        if (strTrim.length() > 31) {
            strTrim = strTrim.substring(0, 31) + ".";
        }
        byte[] bArr = new byte[48];
        byte b = (byte) i;
        bArr[0] = b;
        byte b2 = (byte) (b | ((byte) (distance[0] << 4)));
        bArr[0] = b2;
        bArr[0] = (byte) (b2 | ((byte) ((!z ? 1 : 0) << 7)));
        bArr[1] = (byte) i2;
        bArr[2] = distance[4];
        bArr[3] = distance[3];
        bArr[4] = distance[2];
        bArr[5] = distance[1];
        bArr[6] = (byte) i6;
        byte b3 = (byte) i5;
        bArr[7] = b3;
        bArr[7] = (byte) (b3 | ((byte) (i7 << 4)));
        bArr[8] = distance2[4];
        bArr[9] = distance2[3];
        bArr[10] = distance2[2];
        bArr[11] = distance2[1];
        byte b4 = distance2[0];
        bArr[12] = b4;
        bArr[12] = (byte) (b4 | ((byte) (GlobalVar.gpsStatus.getValue() << 2)));
        bArr[13] = (byte) GlobalVar.takeMeHomeAck;
        if (strTrim.length() > 0) {
            bArr[14] = (byte) strTrim.length();
            System.arraycopy(strTrim.getBytes(), 0, bArr, 15, strTrim.length());
        }
        int i8 = 0;
        for (int i9 = 0; i9 < 47; i9++) {
            i8 = (i8 + bArr[i9]) & 255;
        }
        bArr[47] = (byte) i8;
        return bArr;
    }

    public static int googleManeuverToMmiRoundaboutId(int i, int i2, Boolean bool) {
        Boolean boolGoogleRoundaboutIsClockwiseBand;
        if (i == 61 || i == 62 || (boolGoogleRoundaboutIsClockwiseBand = googleRoundaboutIsClockwiseBand(i)) == null) {
            return -1;
        }
        if (i2 < 1 || i2 > 7) {
            i2 = 1;
        }
        return boolGoogleRoundaboutIsClockwiseBand.booleanValue() ? i2 + 64 : i2 + 57;
    }

    public static int googleManeuverToMmiRoundaboutId(int i, int i2) {
        return googleManeuverToMmiRoundaboutId(i, i2, null);
    }

    private static Boolean googleRoundaboutIsClockwiseBand(int i) {
        switch (i) {
            case 43:
            case 45:
            case 47:
            case 49:
            case 51:
            case 53:
            case 55:
            case 57:
            case 59:
            case 61:
                return Boolean.TRUE;
            case 44:
            case 46:
            case 48:
            case 50:
            case 52:
            case 54:
            case 56:
            case 58:
            case 60:
            case 62:
                return Boolean.FALSE;
            default:
                return null;
        }
    }

    public static int parseRoundaboutExitFromInstruction(String str) {
        if (str != null && !str.isEmpty()) {
            String lowerCase = str.toLowerCase();
            Pattern[] patternArr = {Pattern.compile("take the (\\d+)(?:st|nd|rd|th) exit"), Pattern.compile("(\\d+)(?:st|nd|rd|th) exit"), Pattern.compile("exit\\s+(\\d+)")};
            for (int i = 0; i < 3; i++) {
                Matcher matcher = patternArr[i].matcher(lowerCase);
                if (matcher.find()) {
                    try {
                        int i2 = Integer.parseInt(matcher.group(1));
                        if (i2 >= 1 && i2 <= 7) {
                            return i2;
                        }
                    } catch (NumberFormatException unused) {
                        continue;
                    }
                }
            }
        }
        return 0;
    }

    private static String resolveClusterStreetName(StepInfo stepInfo) {
        try {
            String simpleRoadName = stepInfo.getSimpleRoadName();
            if (simpleRoadName != null && !simpleRoadName.trim().isEmpty()) {
                return simpleRoadName.trim();
            }
        } catch (Exception unused) {
        }
        try {
            String fullRoadName = stepInfo.getFullRoadName();
            if (fullRoadName != null && !fullRoadName.trim().isEmpty()) {
                return fullRoadName.trim();
            }
        } catch (Exception unused2) {
        }
        String fullInstructionText = stepInfo.getFullInstructionText();
        return fullInstructionText != null ? fullInstructionText : "";
    }

    public static byte[] fromGoogleNavInfo(NavInfo navInfo) {
        int iGoogleRoundaboutSeverityToExitAngle;
        int value;
        int i;
        int hexValueInDecimal;
        Boolean boolGoogleRoundaboutIsClockwiseBand;
        if (navInfo == null) {
            resetGoogleRoundaboutStickyState();
            return null;
        }
        try {
            int iMax = Math.max(0, navInfo.getDistanceToFinalDestinationMeters().intValue());
            int iMax2 = Math.max(0, navInfo.getTimeToFinalDestinationSeconds().intValue());
            if (iMax <= 80) {
                Calendar calendar = Calendar.getInstance();
                calendar.add(13, iMax2);
                boolean z = calendar.get(9) == 0;
                int i2 = calendar.get(10);
                if (i2 == 0) {
                    i2 = 12;
                }
                int i3 = calendar.get(12);
                resetGoogleRoundaboutStickyState();
                return buildNavHelperFrame(1, PrimaryTurns.DESTINATION_REACHED.getValue(), z, 0, iMax, i2, i3, 0, "Destination reached");
            }
            StepInfo currentStep = navInfo.getCurrentStep();
            if (currentStep == null) {
                Calendar calendar2 = Calendar.getInstance();
                calendar2.add(13, iMax2);
                boolean z2 = calendar2.get(9) == 0;
                int i4 = calendar2.get(10);
                if (i4 == 0) {
                    i4 = 12;
                }
                return buildNavHelperFrame(1, PrimaryTurns.STRAIGHT.getValue(), z2, iMax, iMax, i4, calendar2.get(12), 0, "Continue");
            }
            int iMax3 = Math.max(0, navInfo.getDistanceToCurrentStepMeters().intValue());
            String fullInstructionText = currentStep.getFullInstructionText();
            if (fullInstructionText == null) {
                fullInstructionText = "";
            }
            String strResolveClusterStreetName = resolveClusterStreetName(currentStep);
            Calendar calendar3 = Calendar.getInstance();
            calendar3.add(13, iMax2);
            boolean z3 = calendar3.get(9) == 0;
            int i5 = calendar3.get(10);
            if (i5 == 0) {
                i5 = 12;
            }
            int i6 = calendar3.get(12);
            int maneuver = currentStep.getManeuver();
            boolean z4 = googleRoundaboutIsClockwiseBand(maneuver) != null;
            boolean z5 = maneuver == 61 || maneuver == 62;
            int iIntValue = -1;
            try {
                Integer roundaboutTurnNumber = currentStep.getRoundaboutTurnNumber();
                if (roundaboutTurnNumber != null) {
                    iIntValue = roundaboutTurnNumber.intValue();
                }
            } catch (Throwable unused) {
            }
            int roundaboutExitFromInstruction = parseRoundaboutExitFromInstruction(fullInstructionText);
            if (iIntValue < 1 || iIntValue > 7) {
                if (roundaboutExitFromInstruction >= 1 && roundaboutExitFromInstruction <= 7) {
                    iIntValue = roundaboutExitFromInstruction;
                } else if (!z4 || z5 || (iIntValue = lastGoogleRoundaboutExit) < 1 || iIntValue > 7) {
                    iIntValue = 0;
                }
            }
            if (z5) {
                iGoogleRoundaboutSeverityToExitAngle = lastGoogleRoundaboutAngleExit;
                if ((iGoogleRoundaboutSeverityToExitAngle < 1 || iGoogleRoundaboutSeverityToExitAngle > 7) && ((iGoogleRoundaboutSeverityToExitAngle = lastGoogleRoundaboutExit) < 1 || iGoogleRoundaboutSeverityToExitAngle > 7)) {
                    iGoogleRoundaboutSeverityToExitAngle = 4;
                }
            } else {
                iGoogleRoundaboutSeverityToExitAngle = googleRoundaboutSeverityToExitAngle(maneuver, iIntValue);
            }
            if (iIntValue >= 1 && iIntValue <= 7) {
                lastGoogleRoundaboutExit = iIntValue;
            }
            if (z4 && !z5 && iGoogleRoundaboutSeverityToExitAngle >= 1 && iGoogleRoundaboutSeverityToExitAngle <= 7) {
                lastGoogleRoundaboutAngleExit = iGoogleRoundaboutSeverityToExitAngle;
            }
            if (z4 && !z5 && (boolGoogleRoundaboutIsClockwiseBand = googleRoundaboutIsClockwiseBand(maneuver)) != null) {
                lastGoogleRoundaboutClockwiseBand = boolGoogleRoundaboutIsClockwiseBand;
            }
            if (z5) {
                Boolean boolGoogleRoundaboutIsClockwiseBand2 = lastGoogleRoundaboutClockwiseBand;
                if (boolGoogleRoundaboutIsClockwiseBand2 == null) {
                    boolGoogleRoundaboutIsClockwiseBand2 = googleRoundaboutIsClockwiseBand(maneuver);
                }
                if (iGoogleRoundaboutSeverityToExitAngle < 1 || iGoogleRoundaboutSeverityToExitAngle > 7) {
                    iGoogleRoundaboutSeverityToExitAngle = 4;
                }
                int i7 = (boolGoogleRoundaboutIsClockwiseBand2 == null || !boolGoogleRoundaboutIsClockwiseBand2.booleanValue()) ? iGoogleRoundaboutSeverityToExitAngle + 57 : iGoogleRoundaboutSeverityToExitAngle + 64;
                if (NavigationHelper.maneuverIDMap.containsKey(Integer.valueOf(i7))) {
                    NavigationHelper.Maneuver maneuver2 = NavigationHelper.maneuverIDMap.get(Integer.valueOf(i7));
                    if (iMax3 < 100) {
                        hexValueInDecimal = maneuver2.getHexValueInDecimalBlinking();
                    } else {
                        hexValueInDecimal = maneuver2.getHexValueInDecimal();
                    }
                } else if (boolGoogleRoundaboutIsClockwiseBand2 != null && boolGoogleRoundaboutIsClockwiseBand2.booleanValue()) {
                    hexValueInDecimal = PrimaryTurns.ROUNDABOUT_LEFT.getValue();
                } else {
                    hexValueInDecimal = PrimaryTurns.ROUNDABOUT_RIGHT.getValue();
                }
            } else {
                int iGoogleManeuverToMmiRoundaboutId = googleManeuverToMmiRoundaboutId(maneuver, iGoogleRoundaboutSeverityToExitAngle, lastGoogleRoundaboutClockwiseBand);
                if (iGoogleManeuverToMmiRoundaboutId > 0 && NavigationHelper.maneuverIDMap.containsKey(Integer.valueOf(iGoogleManeuverToMmiRoundaboutId))) {
                    NavigationHelper.Maneuver maneuver3 = NavigationHelper.maneuverIDMap.get(Integer.valueOf(iGoogleManeuverToMmiRoundaboutId));
                    if (iMax3 < 100) {
                        hexValueInDecimal = maneuver3.getHexValueInDecimalBlinking();
                    } else {
                        hexValueInDecimal = maneuver3.getHexValueInDecimal();
                    }
                    if (iGoogleRoundaboutSeverityToExitAngle < 1 || iGoogleRoundaboutSeverityToExitAngle > 7) {
                        iGoogleRoundaboutSeverityToExitAngle = 0;
                    } else if (NavigationHelper.roundAboutExitMap.containsKey(Integer.valueOf(iGoogleManeuverToMmiRoundaboutId))) {
                        iGoogleRoundaboutSeverityToExitAngle = NavigationHelper.roundAboutExitMap.get(Integer.valueOf(iGoogleManeuverToMmiRoundaboutId)).id;
                    }
                } else {
                    PrimaryTurns primaryTurnsMapGoogleManeuver = mapGoogleManeuver(maneuver);
                    if (primaryTurnsMapGoogleManeuver == PrimaryTurns.DESTINATION_REACHED && iMax > 80) {
                        primaryTurnsMapGoogleManeuver = PrimaryTurns.STRAIGHT;
                        if (strResolveClusterStreetName.isEmpty()) {
                            strResolveClusterStreetName = "Continue";
                        }
                    } else if (primaryTurnsMapGoogleManeuver == PrimaryTurns.DESTINATION_REACHED) {
                        strResolveClusterStreetName = "Destination reached";
                        resetGoogleRoundaboutStickyState();
                    }
                    value = primaryTurnsMapGoogleManeuver.getValue();
                    i = 0;
                }
                return buildNavHelperFrame(1, value, z3, iMax3, iMax, i5, i6, i, strResolveClusterStreetName);
            }
            i = iGoogleRoundaboutSeverityToExitAngle;
            value = hexValueInDecimal;
            return buildNavHelperFrame(1, value, z3, iMax3, iMax, i5, i6, i, strResolveClusterStreetName);
        } catch (Exception unused2) {
            return null;
        }
    }

    private static PrimaryTurns mapGoogleManeuver(int i) {
        PrimaryTurns primaryTurns = PrimaryTurns.WRONG_WAY;
        switch (i) {
            case 0:
                return PrimaryTurns.WRONG_WAY;
            case 1:
            case 5:
            case 65:
                return PrimaryTurns.STRAIGHT;
            case 2:
            case 3:
            case 4:
                return PrimaryTurns.DESTINATION_REACHED;
            case 6:
                return PrimaryTurns.TURN_LEFT;
            case 7:
                return PrimaryTurns.TURN_RIGHT;
            case 8:
                return PrimaryTurns.KEEP_LEFT;
            case 9:
                return PrimaryTurns.KEEP_RIGHT;
            case 10:
                return PrimaryTurns.TURN_SLIGHT_LEFT;
            case 11:
                return PrimaryTurns.TURN_SLIGHT_RIGHT;
            case 12:
                return PrimaryTurns.TURN_SHARP_LEFT;
            case 13:
                return PrimaryTurns.TURN_SHARP_RIGHT;
            case 14:
                return PrimaryTurns.U_TURN_RIGHT;
            case 15:
                return PrimaryTurns.U_TURN_LEFT;
            case 16:
            case 17:
            case 18:
                return PrimaryTurns.MERGE;
            case 19:
                return PrimaryTurns.FORK_LEFT;
            case 20:
                return PrimaryTurns.FORK_RIGHT;
            case 21:
            case 32:
                return PrimaryTurns.STRAIGHT;
            case 22:
            case 33:
                return PrimaryTurns.TURN_LEFT;
            case 23:
            case 34:
                return PrimaryTurns.TURN_RIGHT;
            case 24:
            case 25:
            case 30:
            case 31:
            case 35:
            case 36:
            case 41:
            case 42:
            default:
                return primaryTurns;
            case 26:
            case 37:
                return PrimaryTurns.TURN_SLIGHT_LEFT;
            case 27:
            case 38:
                return PrimaryTurns.TURN_SLIGHT_RIGHT;
            case 28:
            case 39:
                return PrimaryTurns.TURN_SHARP_LEFT;
            case 29:
            case 40:
                return PrimaryTurns.TURN_SHARP_RIGHT;
            case 43:
            case 45:
            case 47:
            case 49:
            case 51:
            case 53:
            case 55:
            case 57:
            case 59:
            case 61:
                return PrimaryTurns.ROUNDABOUT_LEFT;
            case 44:
            case 46:
            case 48:
            case 50:
            case 52:
            case 54:
            case 56:
            case 58:
            case 60:
            case 62:
                return PrimaryTurns.ROUNDABOUT_RIGHT;
            case 63:
                return PrimaryTurns.FERRY;
            case 64:
                return PrimaryTurns.FERRY_TRAIN;
        }
    }
}
