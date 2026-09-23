package com.reactnativecommunity.slider;

import android.view.View;
import android.widget.SeekBar;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class ReactSliderManager extends SimpleViewManager<ReactSlider> {
    private static final SeekBar.OnSeekBarChangeListener ON_CHANGE_LISTENER = new SeekBar.OnSeekBarChangeListener() { // from class: com.reactnativecommunity.slider.ReactSliderManager.1
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            ReactSlider reactSlider = (ReactSlider) seekBar;
            int validProgressValue = reactSlider.getValidProgressValue(i);
            seekBar.setProgress(validProgressValue);
            ReactContext reactContext = (ReactContext) seekBar.getContext();
            if (z) {
                ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ReactSliderEvent(seekBar.getId(), reactSlider.toRealProgress(validProgressValue), true));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            ReactContext reactContext = (ReactContext) seekBar.getContext();
            ReactSlider reactSlider = (ReactSlider) seekBar;
            reactSlider.isSliding(true);
            ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ReactSlidingStartEvent(seekBar.getId(), reactSlider.toRealProgress(seekBar.getProgress())));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            ReactContext reactContext = (ReactContext) seekBar.getContext();
            ReactSlider reactSlider = (ReactSlider) seekBar;
            reactSlider.isSliding(false);
            ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ReactSlidingCompleteEvent(seekBar.getId(), reactSlider.toRealProgress(seekBar.getProgress())));
        }
    };

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return ReactSliderManagerImpl.REACT_CLASS;
    }

    static class ReactSliderShadowNode extends LayoutShadowNode implements YogaMeasureFunction {
        private int mHeight;
        private boolean mMeasured;
        private int mWidth;

        private ReactSliderShadowNode() {
            initMeasureFunction();
        }

        private void initMeasureFunction() {
            setMeasureFunction(this);
        }

        @Override // com.facebook.yoga.YogaMeasureFunction
        public long measure(YogaNode yogaNode, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2) {
            ReactSlider reactSlider = new ReactSlider(getThemedContext(), null);
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            reactSlider.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            this.mWidth = reactSlider.getMeasuredWidth();
            int measuredHeight = reactSlider.getMeasuredHeight();
            this.mHeight = measuredHeight;
            return YogaMeasureOutput.make(this.mWidth, measuredHeight);
        }
    }

    @Override // com.facebook.react.uimanager.SimpleViewManager, com.facebook.react.uimanager.ViewManager
    public LayoutShadowNode createShadowNodeInstance() {
        return new ReactSliderShadowNode();
    }

    @Override // com.facebook.react.uimanager.SimpleViewManager, com.facebook.react.uimanager.ViewManager
    public Class getShadowNodeClass() {
        return ReactSliderShadowNode.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ReactSlider createViewInstance(ThemedReactContext themedReactContext) {
        return ReactSliderManagerImpl.createViewInstance(themedReactContext);
    }

    @ReactProp(defaultBoolean = false, name = "disabled")
    public void setDisabled(ReactSlider reactSlider, boolean z) {
        ReactSliderManagerImpl.setDisabled(reactSlider, z);
    }

    @ReactProp(defaultFloat = 0.0f, name = "value")
    public void setValue(ReactSlider reactSlider, float f) {
        ReactSliderManagerImpl.setValue(reactSlider, f);
    }

    @ReactProp(defaultDouble = 0.0d, name = "minimumValue")
    public void setMinimumValue(ReactSlider reactSlider, double d) {
        ReactSliderManagerImpl.setMinimumValue(reactSlider, d);
    }

    @ReactProp(defaultDouble = 1.0d, name = "maximumValue")
    public void setMaximumValue(ReactSlider reactSlider, double d) {
        ReactSliderManagerImpl.setMaximumValue(reactSlider, d);
    }

    @ReactProp(name = "lowerLimit")
    public void setLowerLimit(ReactSlider reactSlider, double d) {
        ReactSliderManagerImpl.setLowerLimit(reactSlider, d);
    }

    @ReactProp(name = "upperLimit")
    public void setUpperLimit(ReactSlider reactSlider, float f) {
        ReactSliderManagerImpl.setUpperLimit(reactSlider, f);
    }

    @ReactProp(defaultDouble = 0.0d, name = "step")
    public void setStep(ReactSlider reactSlider, double d) {
        ReactSliderManagerImpl.setStep(reactSlider, d);
    }

    @ReactProp(customType = "Color", name = "thumbTintColor")
    public void setThumbTintColor(ReactSlider reactSlider, Integer num) {
        ReactSliderManagerImpl.setThumbTintColor(reactSlider, num);
    }

    @ReactProp(customType = "Color", name = "minimumTrackTintColor")
    public void setMinimumTrackTintColor(ReactSlider reactSlider, Integer num) {
        ReactSliderManagerImpl.setMinimumTrackTintColor(reactSlider, num);
    }

    @ReactProp(name = "thumbImage")
    public void setThumbImage(ReactSlider reactSlider, @Nullable ReadableMap readableMap) {
        ReactSliderManagerImpl.setThumbImage(reactSlider, readableMap);
    }

    @ReactProp(customType = "Color", name = "maximumTrackTintColor")
    public void setMaximumTrackTintColor(ReactSlider reactSlider, Integer num) {
        ReactSliderManagerImpl.setMaximumTrackTintColor(reactSlider, num);
    }

    @ReactProp(defaultBoolean = false, name = "inverted")
    public void setInverted(ReactSlider reactSlider, boolean z) {
        ReactSliderManagerImpl.setInverted(reactSlider, z);
    }

    @ReactProp(name = "accessibilityUnits")
    public void setAccessibilityUnits(ReactSlider reactSlider, String str) {
        ReactSliderManagerImpl.setAccessibilityUnits(reactSlider, str);
    }

    @ReactProp(name = "accessibilityIncrements")
    public void setAccessibilityIncrements(ReactSlider reactSlider, ReadableArray readableArray) {
        ReactSliderManagerImpl.setAccessibilityIncrements(reactSlider, readableArray);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(ThemedReactContext themedReactContext, ReactSlider reactSlider) {
        reactSlider.setOnSeekBarChangeListener(ON_CHANGE_LISTENER);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        return ReactSliderManagerImpl.getExportedCustomBubblingEventTypeConstants();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return ReactSliderManagerImpl.getExportedCustomDirectEventTypeConstants();
    }
}
