package com.mappls.sdk.navigation.ui.navigation.nextinstruction;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import com.mappls.sdk.navigation.ui.R;
import com.mappls.sdk.navigation.ui.databinding.LayoutNextInstructionViewBinding;
import com.mappls.sdk.plugin.directions.DirectionsUtils;
import com.mappls.sdk.services.api.directions.models.LegStep;

/* JADX INFO: loaded from: classes4.dex */
public class NextInstructionView extends a {
    LayoutNextInstructionViewBinding binding;

    public NextInstructionView(Context context) {
        this(context, null);
    }

    @Override // com.mappls.sdk.navigation.ui.navigation.nextinstruction.a, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        toggleTheme();
    }

    public void setDurationText(String str) {
        this.binding.nextAdviceDuration.setText(str);
    }

    public void setNextLegStep(LegStep legStep) {
        Context applicationContext = getContext().getApplicationContext();
        int iIntValue = DirectionsUtils.getManeuverId(legStep).intValue();
        getContext();
        Pair pairA = com.mappls.sdk.navigation.ui.utils.a.a(applicationContext, iIntValue, com.mappls.sdk.navigation.ui.theme.a.a());
        if (pairA != null) {
            this.binding.nextInstructionImageView.setVisibility(8);
            this.binding.nextInstructionImageViewIcon.setVisibility(0);
            this.binding.nextInstructionImageViewIcon.setImageResource(((Integer) pairA.first).intValue());
        } else {
            this.binding.nextInstructionImageView.setVisibility(0);
            this.binding.nextInstructionImageViewIcon.setVisibility(8);
            this.binding.nextInstructionImageView.setManeuverTypeAndModifier(legStep.maneuver().type(), legStep.maneuver().modifier());
        }
        this.binding.nextInstructionImageView.setManeuverTypeAndModifier(legStep.maneuver().type(), legStep.maneuver().modifier());
        if (legStep.maneuver().type() != null) {
            if (legStep.maneuver().type().equalsIgnoreCase("roundabout") || legStep.maneuver().type().equalsIgnoreCase("rotary")) {
                if (legStep.maneuver().degree() != null) {
                    this.binding.nextInstructionImageView.setRoundaboutAngle(legStep.maneuver().degree().floatValue());
                } else {
                    this.binding.nextInstructionImageView.setRoundaboutAngle(180.0f);
                }
            }
        }
    }

    public void setNextManeuverTypeAndModifier(String str, String str2) {
        this.binding.nextInstructionImageView.setManeuverTypeAndModifier(str, str2);
    }

    public void setRoundaboutAngle(float f) {
        this.binding.nextInstructionImageView.setRoundaboutAngle(f);
    }

    public void toggleTheme() {
        this.binding.nextAdviseContainer.setBackgroundResource(com.mappls.sdk.navigation.ui.theme.a.a(getContext(), R.attr.navigationViewNextBannerBackground).resourceId);
        this.binding.nextInstructionImageView.setPrimaryColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationViewNextBannerManeuverPrimary));
        this.binding.nextInstructionImageView.setSecondaryColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationViewNextBannerManeuverSecondary));
        this.binding.tvThen.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationViewNextBannerTextColor));
        this.binding.nextAdviceDuration.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationViewNextBannerTextColor));
    }

    public NextInstructionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.soundController);
    }

    public NextInstructionView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, R.style.SoundControllerStyle);
    }

    public NextInstructionView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.binding = LayoutNextInstructionViewBinding.inflate(LayoutInflater.from(getContext()), this, true);
    }
}
