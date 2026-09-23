package com.mappls.sdk.plugin.directions;

import com.mappls.sdk.services.api.directions.models.LegStep;

/* JADX INFO: loaded from: classes4.dex */
public class DirectionsUtils {
    static e textInstructions = new e("mappls-directions-en", "v5");
    static e shortTextInstructions = new e("mappls-directions-en_short_instructions", "v5");
    static e textInstructionsEn = new e("mappls-directions-en", "v5");
    static e shortTextInstructionsEn = new e("mappls-directions-en_short_instructions", "v5");
    static e shortTextInstructionsForManeuverId = new e("mappls-directions-en_short_instructions", "v5");
    static e shortTextInstructionsLegacy = new e("mappls-directions-en_short_instructions-legacy", "v5");

    private DirectionsUtils() {
    }

    public static String getEnShortInstruction(LegStep legStep) {
        return shortTextInstructionsEn.a(legStep, true).split("\\$")[0];
    }

    public static Integer getManeuverId(LegStep legStep) {
        int iA;
        String strDrivingSide;
        float fFloatValue;
        String[] strArrSplit = shortTextInstructionsForManeuverId.a(legStep, true).split("\\$");
        String strType = legStep.maneuver().type();
        if (strType != null && (strType.equalsIgnoreCase("roundabout") || strType.equalsIgnoreCase("roundabout turn"))) {
            if (legStep.maneuver().degree() != null) {
                fFloatValue = legStep.maneuver().degree().floatValue();
                strDrivingSide = legStep.drivingSide();
            } else {
                strDrivingSide = legStep.drivingSide();
                fFloatValue = 180.0f;
            }
            iA = c.a(fFloatValue, strDrivingSide);
        } else {
            if (strArrSplit.length > 1) {
                int i = Integer.parseInt(strArrSplit[1]);
                return (legStep.drivingSide() == null || legStep.drivingSide().equalsIgnoreCase("left")) ? Integer.valueOf(i) : c.a(i);
            }
            iA = 0;
        }
        return Integer.valueOf(iA);
    }

    @Deprecated
    public static Integer getManeuverIdLegacy(LegStep legStep) {
        int iA;
        String strDrivingSide;
        float fFloatValue;
        String[] strArrSplit = shortTextInstructionsLegacy.a(legStep, true).split("\\$");
        String strType = legStep.maneuver().type();
        if (strType != null && (strType.equalsIgnoreCase("roundabout") || strType.equalsIgnoreCase("roundabout turn"))) {
            if (legStep.maneuver().degree() != null) {
                fFloatValue = legStep.maneuver().degree().floatValue();
                strDrivingSide = legStep.drivingSide();
            } else {
                strDrivingSide = legStep.drivingSide();
                fFloatValue = 180.0f;
            }
            iA = c.a(fFloatValue, strDrivingSide);
        } else {
            if (strArrSplit.length > 1) {
                int i = Integer.parseInt(strArrSplit[1]);
                return (legStep.drivingSide() == null || legStep.drivingSide().equalsIgnoreCase("left")) ? Integer.valueOf(i) : c.a(i);
            }
            iA = 0;
        }
        return Integer.valueOf(iA);
    }

    public static String getShortInstruction(LegStep legStep) {
        return shortTextInstructions.a(legStep, true).split("\\$")[0];
    }

    public static String getTextEnInstructions(LegStep legStep) {
        return textInstructionsEn.a(legStep, false);
    }

    public static String getTextInstructions(LegStep legStep) {
        return textInstructions.a(legStep, false);
    }

    public static void setFileName(String str) {
        textInstructions = new e(str, "v5");
    }

    public static void setLanguage(String str) {
        textInstructions = new e(b.a(str), "v5");
        shortTextInstructions = new e(b.b(str), "v5");
    }
}
