package com.bajajconnect;

import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class MyViewManager extends ViewGroupManager<FrameLayout> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String REACT_CLASS = "MyViewManager";
    public final int COMMAND_CREATE = 1;
    public final int COMMAND_CREATE_DARK = 2;
    private final String TAG = REACT_CLASS;
    private final ReactApplicationContext appContext;
    private MyFragment localFragment;
    private int propHeight;
    private int propWidth;
    private int reactNativeViewIdFromJs;
    private ThemedReactContext themedReactContext;

    public MyViewManager(ReactApplicationContext reactApplicationContext) {
        this.appContext = reactApplicationContext;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public FrameLayout createViewInstance(ThemedReactContext themedReactContext) {
        this.themedReactContext = themedReactContext;
        return new FrameLayout(themedReactContext);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("create", 1, "create_dark", 2);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder().put("onUpdate", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onUpdate"))).put("onError", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onError"))).build();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(FrameLayout frameLayout, String str, ReadableArray readableArray) {
        super.receiveCommand(frameLayout, str, readableArray);
        int i = readableArray.getInt(0);
        this.reactNativeViewIdFromJs = readableArray.getInt(0);
        int i2 = Integer.parseInt(str);
        if (i2 == 1) {
            createFragment(frameLayout, i);
        } else if (i2 == 2) {
            createDarkFragment(frameLayout, i);
        }
    }

    @ReactPropGroup(customType = "Style", names = {"width", "height"})
    public void setStyle(FrameLayout frameLayout, int i, Integer num) {
        if (i == 0) {
            this.propWidth = num.intValue();
        }
        if (i == 1) {
            this.propHeight = num.intValue();
        }
    }

    public void createFragment(FrameLayout frameLayout, int i) {
        setupLayout((ViewGroup) frameLayout.findViewById(i));
        MyFragment myFragment = new MyFragment(this.appContext, this, false);
        this.localFragment = myFragment;
        ((FragmentActivity) this.appContext.getCurrentActivity()).getSupportFragmentManager().beginTransaction().replace(i, myFragment, String.valueOf(i)).commit();
    }

    public void createDarkFragment(FrameLayout frameLayout, int i) {
        setupLayout((ViewGroup) frameLayout.findViewById(i));
        MyFragment myFragment = new MyFragment(this.appContext, this, true);
        this.localFragment = myFragment;
        ((FragmentActivity) this.appContext.getCurrentActivity()).getSupportFragmentManager().beginTransaction().replace(i, myFragment, String.valueOf(i)).commit();
    }

    public void removeFragment(FrameLayout frameLayout, int i) {
        FragmentActivity fragmentActivity = (FragmentActivity) this.appContext.getCurrentActivity();
        MyFragment myFragment = (MyFragment) fragmentActivity.getSupportFragmentManager().findFragmentById(i);
        if (myFragment != null) {
            fragmentActivity.getSupportFragmentManager().beginTransaction().remove(myFragment).commit();
        }
    }

    public void setupLayout(final View view) {
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: com.bajajconnect.MyViewManager.1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                MyViewManager.this.manuallyLayoutChildren(view);
                view.getViewTreeObserver().dispatchOnGlobalLayout();
                Choreographer.getInstance().postFrameCallback(this);
            }
        });
    }

    public void manuallyLayoutChildren(View view) {
        int systemWindowInsetTop;
        int i = this.propWidth;
        int iMax = this.propHeight;
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets != null) {
            systemWindowInsetTop = rootWindowInsets.getSystemWindowInsetTop();
            iMax = Math.max((iMax - systemWindowInsetTop) - rootWindowInsets.getSystemWindowInsetBottom(), 0);
        } else {
            systemWindowInsetTop = 0;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(iMax, 1073741824));
        view.layout(0, systemWindowInsetTop, i, iMax + systemWindowInsetTop);
    }

    void pushEvent(View view, String str, WritableMap writableMap) {
        ((RCTEventEmitter) this.themedReactContext.getJSModule(RCTEventEmitter.class)).receiveEvent(this.reactNativeViewIdFromJs, "onUpdate", writableMap);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(FrameLayout frameLayout) {
        super.onDropViewInstance(frameLayout);
        MapplsNavigationHelper.getInstance().stopNavigation();
        MyFragment myFragment = this.localFragment;
        if (myFragment != null) {
            myFragment.onDestroy();
        }
        this.localFragment = null;
    }
}
