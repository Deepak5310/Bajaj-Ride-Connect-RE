package com.mappls.sdk.navigation.ui.navigation.instructioncontainer;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.model.AdviseInfo;
import com.mappls.sdk.navigation.routing.NavigationStep;
import com.mappls.sdk.navigation.ui.R;
import com.mappls.sdk.navigation.ui.databinding.LayoutInstructionPipBinding;
import com.mappls.sdk.navigation.ui.navigation.q;
import com.mappls.sdk.plugin.directions.DirectionFormatter;
import com.mappls.sdk.plugin.directions.DirectionsUtils;
import com.mappls.sdk.services.api.directions.models.LegStep;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class InstructionContainrPIPView extends BaseInstructionContainerView implements LifecycleObserver {
    private LayoutInstructionPipBinding binding;
    private LifecycleOwner lifecycleOwner;
    private List<NavigationStep> mAdvises;
    private q navigationViewModel;

    public InstructionContainrPIPView(Context context) {
        this(context, null);
    }

    private void toggleTheme() {
        this.binding.maneuverImageView.setPrimaryColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationViewBannerManeuverPrimary));
        this.binding.maneuverImageView.setSecondaryColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationViewBannerManeuverSecondary));
        this.binding.stripItemContainer.setBackgroundResource(com.mappls.sdk.navigation.ui.theme.a.a(getContext(), R.attr.navigationViewBannerBackgroundSelected).resourceId);
        this.binding.navigationStripDist.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationViewBannerSecondaryText));
        this.binding.navigationStripText.setTextColor(com.mappls.sdk.navigation.ui.theme.a.b(getContext(), R.attr.navigationViewBannerPrimaryText));
    }

    @Override // com.mappls.sdk.navigation.ui.navigation.instructioncontainer.BaseInstructionContainerView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        toggleTheme();
    }

    public void setAdviseInfo(e eVar) {
        AdviseInfo adviseInfo = eVar.a;
        if (adviseInfo.isRouteBeingRecalculated() && !adviseInfo.isOnRoute()) {
            this.binding.otherInfoTextView.setVisibility(0);
            this.binding.stripItemContainer.setVisibility(8);
            return;
        }
        this.binding.otherInfoTextView.setVisibility(8);
        this.binding.stripItemContainer.setVisibility(0);
        this.binding.navigationStripText.setText(adviseInfo.getText());
        this.binding.navigationStripDist.setText(DirectionFormatter.getFormattedDistanceRound(adviseInfo.getDistanceToNextAdvise(), com.mappls.sdk.navigation.ui.utils.d.a()));
        if (adviseInfo.getInfo() instanceof LegStep) {
            LegStep legStep = (LegStep) adviseInfo.getInfo();
            Pair pairA = com.mappls.sdk.navigation.ui.utils.a.a(getContext().getApplicationContext(), DirectionsUtils.getManeuverId(legStep).intValue(), true);
            if (pairA != null) {
                this.binding.maneuverImageView.setVisibility(8);
                this.binding.maneuverImageViewIcon.setVisibility(0);
                this.binding.maneuverImageViewIcon.setImageResource(((Integer) pairA.first).intValue());
            } else {
                this.binding.maneuverImageView.setVisibility(0);
                this.binding.maneuverImageViewIcon.setVisibility(8);
                this.binding.maneuverImageView.setManeuverTypeAndModifier(legStep.maneuver().type(), legStep.maneuver().modifier());
            }
            if (legStep.maneuver().type().equalsIgnoreCase("roundabout") || legStep.maneuver().type().equalsIgnoreCase("rotary")) {
                if (legStep.maneuver().degree() != null) {
                    this.binding.maneuverImageView.setRoundaboutAngle(legStep.maneuver().degree().floatValue());
                } else {
                    this.binding.maneuverImageView.setRoundaboutAngle(180.0f);
                }
            }
            if (adviseInfo.isOnRoute()) {
                this.binding.otherInfoTextView.setVisibility(8);
                this.binding.stripItemContainer.setVisibility(0);
            }
        }
    }

    public void setDataContainer() {
        this.binding.otherInfoTextView.setVisibility(8);
        this.binding.stripItemContainer.setVisibility(0);
        this.mAdvises = MapplsNavigationHelper.getInstance().getNavigationSteps();
    }

    @Override // com.mappls.sdk.navigation.ui.navigation.instructioncontainer.BaseInstructionContainerView
    public void setLeftButtonIcon(int i) {
    }

    @Override // com.mappls.sdk.navigation.ui.navigation.instructioncontainer.BaseInstructionContainerView
    public void setRightButtonIcon(int i) {
    }

    public void subscribe(LifecycleOwner lifecycleOwner, q qVar) {
        this.lifecycleOwner = lifecycleOwner;
        lifecycleOwner.getLifecycle().addObserver(this);
        this.navigationViewModel = qVar;
        qVar.b.observe(this.lifecycleOwner, new d(this));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void unsubscribe() {
        q qVar = this.navigationViewModel;
        if (qVar != null) {
            qVar.b.removeObservers(this.lifecycleOwner);
        }
    }

    public InstructionContainrPIPView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.instructionContainerStyle);
    }

    public InstructionContainrPIPView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, R.style.InstructionContainerStyle);
    }

    public InstructionContainrPIPView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.binding = LayoutInstructionPipBinding.inflate(LayoutInflater.from(getContext()), this, true);
        context.obtainStyledAttributes(attributeSet, R.styleable.InstructionContainer, i, i2);
    }
}
