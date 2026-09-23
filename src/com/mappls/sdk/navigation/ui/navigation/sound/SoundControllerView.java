package com.mappls.sdk.navigation.ui.navigation.sound;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.ui.R;
import com.mappls.sdk.navigation.ui.databinding.LayoutSoundViewBinding;
import com.mappls.sdk.navigation.ui.navigation.h;

/* JADX INFO: loaded from: classes4.dex */
public class SoundControllerView extends BaseSoundView {
    private LayoutSoundViewBinding binding;
    private AnimationSet fadeInSlowOut;
    private a soundControllerCallback;

    public SoundControllerView(Context context) {
        this(context, null);
    }

    private void initAnimations() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        alphaAnimation.setDuration(300L);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setInterpolator(new AccelerateInterpolator());
        alphaAnimation2.setStartOffset(1000L);
        alphaAnimation2.setDuration(1000L);
        AnimationSet animationSet = new AnimationSet(false);
        this.fadeInSlowOut = animationSet;
        animationSet.addAnimation(alphaAnimation);
        this.fadeInSlowOut.addAnimation(alphaAnimation2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mute() {
        setSoundChipText(getContext().getResources().getString(R.string.muted));
        showSoundChip();
        soundFabOff();
        a aVar = this.soundControllerCallback;
        if (aVar != null) {
            ((h) aVar).a(true);
        }
    }

    private void setSoundChipText(String str) {
        this.binding.soundText.setText(str);
    }

    private void showSoundChip() {
        this.binding.soundText.startAnimation(this.fadeInSlowOut);
    }

    private void soundFabOff() {
        ImageView imageView = this.binding.soundBtn;
        Context context = getContext();
        imageView.setImageDrawable(AppCompatResources.getDrawable(context, com.mappls.sdk.navigation.ui.theme.a.a(context, R.attr.navigationViewSoundOff).resourceId));
    }

    private void soundFabOn() {
        ImageView imageView = this.binding.soundBtn;
        Context context = getContext();
        imageView.setImageDrawable(AppCompatResources.getDrawable(context, com.mappls.sdk.navigation.ui.theme.a.a(context, R.attr.navigationViewSoundOn).resourceId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unmute() {
        setSoundChipText(getContext().getResources().getString(R.string.unmuted));
        showSoundChip();
        soundFabOn();
        a aVar = this.soundControllerCallback;
        if (aVar != null) {
            ((h) aVar).a(false);
        }
    }

    @Override // com.mappls.sdk.navigation.ui.navigation.sound.BaseSoundView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        toggleTheme();
    }

    public void setSoundControll() {
        this.binding.soundBtn.setOnClickListener(new b(this));
    }

    public void setSoundControllerCallback(a aVar) {
        this.soundControllerCallback = aVar;
    }

    public void toggleTheme() {
        ImageView imageView = this.binding.soundBtn;
        Context context = getContext();
        imageView.setBackground(AppCompatResources.getDrawable(context, com.mappls.sdk.navigation.ui.theme.a.a(context, R.attr.navigationViewSoundBackground).resourceId));
        if (MapplsNavigationHelper.getInstance().isMute()) {
            soundFabOff();
        } else {
            soundFabOn();
        }
    }

    public SoundControllerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.soundController);
    }

    public SoundControllerView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, R.style.SoundControllerStyle);
    }

    public SoundControllerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.binding = LayoutSoundViewBinding.inflate(LayoutInflater.from(getContext()), this, true);
        initAnimations();
    }
}
