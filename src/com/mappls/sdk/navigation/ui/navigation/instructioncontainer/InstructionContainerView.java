package com.mappls.sdk.navigation.ui.navigation.instructioncontainer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.NavigationApplication;
import com.mappls.sdk.navigation.model.AdviseInfo;
import com.mappls.sdk.navigation.ui.R;
import com.mappls.sdk.navigation.ui.databinding.LayoutInstructionContainerBinding;
import com.mappls.sdk.navigation.ui.navigation.q;

/* JADX INFO: loaded from: classes4.dex */
public class InstructionContainerView extends BaseInstructionContainerView implements LifecycleObserver {

    /* JADX INFO: renamed from: app, reason: collision with root package name */
    private NavigationApplication f718app;
    private LayoutInstructionContainerBinding binding;
    private int currentPageLocation;
    private LifecycleOwner lifecycleOwner;
    private f navigationPagerAdapter;
    private q navigationViewModel;

    public InstructionContainerView(Context context) {
        this(context, null);
    }

    public int getCurrentItem() {
        return this.currentPageLocation;
    }

    public int getSelectedItem() {
        return this.binding.navigationInfoLayoutNew.getCurrentItem();
    }

    public void onPictureInPictureModeChange(boolean z) {
        ViewGroup.LayoutParams layoutParams = this.binding.navigationInfoLayoutNew.getLayoutParams();
        if (z) {
            layoutParams.height = (int) getResources().getDimension(R.dimen.pictureInpictureModeInfobar);
            this.binding.navigationInfoLayoutNew.setLayoutParams(layoutParams);
            this.binding.navigationStripRightImageButton.setVisibility(8);
            this.binding.navigationStripLeftImageButton.setVisibility(8);
            return;
        }
        layoutParams.height = (int) getResources().getDimension(R.dimen.infobar_height);
        this.binding.navigationInfoLayoutNew.setLayoutParams(layoutParams);
        this.binding.navigationStripRightImageButton.setVisibility(0);
        this.binding.navigationStripLeftImageButton.setVisibility(0);
    }

    public void setAdviseInfo(AdviseInfo adviseInfo) {
        if (adviseInfo.isRouteBeingRecalculated() && !adviseInfo.isOnRoute()) {
            this.binding.otherInfoTextView.setVisibility(0);
            this.binding.navigationInfoLayoutNew.setVisibility(8);
            return;
        }
        this.binding.otherInfoTextView.setVisibility(8);
        this.binding.navigationInfoLayoutNew.setVisibility(0);
        if (this.binding.navigationInfoLayoutNew.getAdapter() != null) {
            ((f) this.binding.navigationInfoLayoutNew.getAdapter()).e = adviseInfo.getDistanceToNextAdvise();
            f fVar = (f) this.binding.navigationInfoLayoutNew.getAdapter();
            fVar.d = adviseInfo.getPosition() < 1 ? 1 : adviseInfo.getPosition();
            fVar.notifyDataSetChanged();
        }
        if (adviseInfo.isOnRoute()) {
            this.binding.otherInfoTextView.setVisibility(8);
            this.binding.navigationInfoLayoutNew.setVisibility(0);
        }
        this.currentPageLocation = adviseInfo.getPosition() != 0 ? adviseInfo.getPosition() : 1;
    }

    public void setCurrentItem(int i) {
        if (i >= this.currentPageLocation) {
            this.binding.navigationInfoLayoutNew.setCurrentItem(i);
        }
    }

    public void setDataContainer(boolean z) {
        this.binding.otherInfoTextView.setVisibility(8);
        this.binding.navigationInfoLayoutNew.setVisibility(0);
        if (this.binding.navigationInfoLayoutNew.getAdapter() == null || z) {
            f fVar = new f(getContext(), MapplsNavigationHelper.getInstance().getNavigationSteps());
            this.binding.navigationInfoLayoutNew.setAdapter(fVar);
            fVar.d = 1;
            fVar.notifyDataSetChanged();
            this.binding.navigationInfoLayoutNew.setCurrentItem(1);
        }
    }

    public void setFollowMe() {
        this.binding.navigationInfoLayoutNew.setCurrentItem(this.currentPageLocation);
    }

    @Override // com.mappls.sdk.navigation.ui.navigation.instructioncontainer.BaseInstructionContainerView
    public void setLeftButtonIcon(int i) {
        if (i != 0) {
            this.binding.navigationStripLeftImageButton.setImageResource(i);
        }
    }

    public void setNextPreviousIconClickListener(g gVar) {
        this.binding.navigationStripLeftImageButton.setOnClickListener(new a(this, gVar));
        this.binding.navigationStripRightImageButton.setOnClickListener(new b(this, gVar));
    }

    @Override // com.mappls.sdk.navigation.ui.navigation.instructioncontainer.BaseInstructionContainerView
    public void setRightButtonIcon(int i) {
        if (i != 0) {
            this.binding.navigationStripRightImageButton.setImageResource(i);
        }
    }

    public void subscribe(LifecycleOwner lifecycleOwner, q qVar) {
        this.lifecycleOwner = lifecycleOwner;
        lifecycleOwner.getLifecycle().addObserver(this);
        this.navigationViewModel = qVar;
        qVar.b.observe(this.lifecycleOwner, new c(this));
    }

    public void toggleTheme() {
        this.navigationPagerAdapter.notifyDataSetChanged();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void unsubscribe() {
        q qVar = this.navigationViewModel;
        if (qVar != null) {
            qVar.b.removeObservers(this.lifecycleOwner);
        }
    }

    public InstructionContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.instructionContainerStyle);
    }

    public InstructionContainerView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, R.style.InstructionContainerStyle);
    }

    public InstructionContainerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.binding = LayoutInstructionContainerBinding.inflate(LayoutInflater.from(getContext()), this, true);
        this.currentPageLocation = 1;
        context.obtainStyledAttributes(attributeSet, R.styleable.InstructionContainer, i, i2);
    }
}
