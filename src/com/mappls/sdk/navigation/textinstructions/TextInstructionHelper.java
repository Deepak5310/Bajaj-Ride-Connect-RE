package com.mappls.sdk.navigation.textinstructions;

import android.text.TextUtils;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.plugin.directions.DirectionsUtils;
import com.mappls.sdk.services.api.directions.models.LegStep;

/* JADX INFO: loaded from: classes4.dex */
public class TextInstructionHelper {
    static TextInstructionHelper instance;

    TextInstructionHelper() {
    }

    public static TextInstructionHelper getInstance() {
        if (instance == null) {
            instance = new TextInstructionHelper();
        }
        return instance;
    }

    public String getInstruction(LegStep legStep) {
        return (TextUtils.isEmpty(legStep.maneuver().instruction()) || !MapplsNavigationHelper.getInstance().isEnableInstructionsFromAPI()) ? DirectionsUtils.getTextInstructions(legStep) : legStep.maneuver().instruction();
    }

    public String getInstruction(LegStep legStep, boolean z) {
        return (TextUtils.isEmpty(legStep.maneuver().instruction()) || !MapplsNavigationHelper.getInstance().isEnableInstructionsFromAPI()) ? DirectionsUtils.getTextInstructions(legStep) : legStep.maneuver().instruction();
    }

    public Integer getManeuverId(LegStep legStep) {
        return (legStep.maneuver().maneuverId() == null || !MapplsNavigationHelper.getInstance().isEnableInstructionsFromAPI()) ? DirectionsUtils.getManeuverId(legStep) : legStep.maneuver().maneuverId();
    }

    public Integer getManeuverIdLegacy(LegStep legStep) {
        return (legStep.maneuver().maneuverId() == null || !MapplsNavigationHelper.getInstance().isEnableInstructionsFromAPI()) ? DirectionsUtils.getManeuverIdLegacy(legStep) : legStep.maneuver().maneuverId();
    }

    public String getShortInstruction(LegStep legStep) {
        return (TextUtils.isEmpty(legStep.maneuver().shortInstruction()) || !MapplsNavigationHelper.getInstance().isEnableInstructionsFromAPI()) ? DirectionsUtils.getShortInstruction(legStep) : legStep.maneuver().shortInstruction();
    }
}
