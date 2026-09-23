package com.reactnativekeyboardcontroller.listeners;

import android.text.TextWatcher;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.view.ReactViewGroup;
import com.reactnativekeyboardcontroller.events.FocusedInputLayoutChangedEvent;
import com.reactnativekeyboardcontroller.events.FocusedInputLayoutChangedEventData;
import com.reactnativekeyboardcontroller.events.FocusedInputSelectionChangedEvent;
import com.reactnativekeyboardcontroller.events.FocusedInputSelectionChangedEventData;
import com.reactnativekeyboardcontroller.events.FocusedInputTextChangedEvent;
import com.reactnativekeyboardcontroller.extensions.EditTextKt;
import com.reactnativekeyboardcontroller.extensions.FloatKt;
import com.reactnativekeyboardcontroller.extensions.ReactContextKt;
import com.reactnativekeyboardcontroller.extensions.ThemedReactContextKt;
import com.reactnativekeyboardcontroller.extensions.ViewKt;
import com.reactnativekeyboardcontroller.traversal.FocusedInputHolder;
import com.reactnativekeyboardcontroller.traversal.ViewHierarchyNavigator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FocusedInputObserver.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010(\u001a\u00020\u001dJ\u0010\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\fH\u0002J\u0006\u0010+\u001a\u00020\u001dR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0093\u0001\u0010\u0011\u001a\u0086\u0001\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001d0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u0006,"}, d2 = {"Lcom/reactnativekeyboardcontroller/listeners/FocusedInputObserver;", "", "view", "Landroid/view/View;", "eventPropagationView", "Lcom/facebook/react/views/view/ReactViewGroup;", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "(Landroid/view/View;Lcom/facebook/react/views/view/ReactViewGroup;Lcom/facebook/react/uimanager/ThemedReactContext;)V", "focusListener", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "lastEventDispatched", "Lcom/reactnativekeyboardcontroller/events/FocusedInputLayoutChangedEventData;", "lastFocusedInput", "Landroid/widget/EditText;", "layoutListener", "Landroid/view/View$OnLayoutChangeListener;", "selectionListener", "Lkotlin/Function6;", "", "Lkotlin/ParameterName;", "name", ViewProps.START, ViewProps.END, "", "startX", "startY", "endX", "endY", "", "selectionSubscription", "Lkotlin/Function0;", "surfaceId", "textListener", "Lkotlin/Function1;", "", "textWatcher", "Landroid/text/TextWatcher;", "getView", "()Landroid/view/View;", "destroy", "dispatchEventToJS", NotificationCompat.CATEGORY_EVENT, "syncUpLayout", "react-native-keyboard-controller_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FocusedInputObserver {
    private final ThemedReactContext context;
    private final ReactViewGroup eventPropagationView;
    private final ViewTreeObserver.OnGlobalFocusChangeListener focusListener;
    private FocusedInputLayoutChangedEventData lastEventDispatched;
    private EditText lastFocusedInput;
    private final View.OnLayoutChangeListener layoutListener;
    private final Function6<Integer, Integer, Double, Double, Double, Double, Unit> selectionListener;
    private Function0<Unit> selectionSubscription;
    private final int surfaceId;
    private final Function1<String, Unit> textListener;
    private TextWatcher textWatcher;
    private final View view;

    public FocusedInputObserver(View view, ReactViewGroup eventPropagationView, ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(eventPropagationView, "eventPropagationView");
        this.view = view;
        this.eventPropagationView = eventPropagationView;
        this.context = themedReactContext;
        this.surfaceId = UIManagerHelper.getSurfaceId(view);
        this.lastEventDispatched = FocusedInputObserverKt.getNoFocusedInputEvent();
        this.layoutListener = new View.OnLayoutChangeListener() { // from class: com.reactnativekeyboardcontroller.listeners.FocusedInputObserver$$ExternalSyntheticLambda1
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                FocusedInputObserver.layoutListener$lambda$0(this.f$0, view2, i, i2, i3, i4, i5, i6, i7, i8);
            }
        };
        this.textListener = new Function1<String, Unit>() { // from class: com.reactnativekeyboardcontroller.listeners.FocusedInputObserver$textListener$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String text) {
                Intrinsics.checkNotNullParameter(text, "text");
                this.this$0.syncUpLayout();
                ThemedReactContextKt.dispatchEvent(this.this$0.context, this.this$0.eventPropagationView.getId(), new FocusedInputTextChangedEvent(this.this$0.surfaceId, this.this$0.eventPropagationView.getId(), text));
            }
        };
        this.selectionListener = new Function6<Integer, Integer, Double, Double, Double, Double, Unit>() { // from class: com.reactnativekeyboardcontroller.listeners.FocusedInputObserver$selectionListener$1
            {
                super(6);
            }

            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, Double d, Double d2, Double d3, Double d4) {
                invoke(num.intValue(), num2.intValue(), d.doubleValue(), d2.doubleValue(), d3.doubleValue(), d4.doubleValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i, int i2, double d, double d2, double d3, double d4) {
                EditText editText = this.this$0.lastFocusedInput;
                if (editText == null) {
                    return;
                }
                this.this$0.syncUpLayout();
                ThemedReactContextKt.dispatchEvent(this.this$0.context, this.this$0.eventPropagationView.getId(), new FocusedInputSelectionChangedEvent(this.this$0.surfaceId, this.this$0.eventPropagationView.getId(), new FocusedInputSelectionChangedEventData(editText.getId(), d, d2, d3, d4, i, i2)));
            }
        };
        ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener = new ViewTreeObserver.OnGlobalFocusChangeListener() { // from class: com.reactnativekeyboardcontroller.listeners.FocusedInputObserver$$ExternalSyntheticLambda2
            @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
            public final void onGlobalFocusChanged(View view2, View view3) {
                FocusedInputObserver.focusListener$lambda$4(this.f$0, view2, view3);
            }
        };
        this.focusListener = onGlobalFocusChangeListener;
        view.getViewTreeObserver().addOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
    }

    public final View getView() {
        return this.view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void layoutListener$lambda$0(FocusedInputObserver this$0, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.syncUpLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void focusListener$lambda$4(FocusedInputObserver this$0, View view, View view2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (view2 == null || view != null) {
            EditText editText = this$0.lastFocusedInput;
            if (editText != null) {
                editText.removeOnLayoutChangeListener(this$0.layoutListener);
            }
            final EditText editText2 = this$0.lastFocusedInput;
            if (editText2 != null) {
                final TextWatcher textWatcher = this$0.textWatcher;
                editText2.post(new Runnable() { // from class: com.reactnativekeyboardcontroller.listeners.FocusedInputObserver$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        FocusedInputObserver.focusListener$lambda$4$lambda$2$lambda$1(editText2, textWatcher);
                    }
                });
            }
            Function0<Unit> function0 = this$0.selectionSubscription;
            if (function0 != null) {
                function0.invoke();
            }
            this$0.lastFocusedInput = null;
        }
        if (view2 instanceof EditText) {
            EditText editText3 = (EditText) view2;
            this$0.lastFocusedInput = editText3;
            view2.addOnLayoutChangeListener(this$0.layoutListener);
            this$0.syncUpLayout();
            this$0.textWatcher = EditTextKt.addOnTextChangedListener(editText3, this$0.textListener);
            this$0.selectionSubscription = EditTextKt.addOnSelectionChangedListener(editText3, this$0.selectionListener);
            FocusedInputHolder.INSTANCE.set(editText3);
            ViewHierarchyNavigator viewHierarchyNavigator = ViewHierarchyNavigator.INSTANCE;
            ThemedReactContext themedReactContext = this$0.context;
            List<EditText> allInputFields = viewHierarchyNavigator.getAllInputFields(themedReactContext != null ? ReactContextKt.getRootView(themedReactContext) : null);
            int iIndexOf = allInputFields.indexOf(view2);
            ThemedReactContext themedReactContext2 = this$0.context;
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putInt("current", iIndexOf);
            writableMapCreateMap.putInt("count", allInputFields.size());
            Unit unit = Unit.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "apply(...)");
            ThemedReactContextKt.emitEvent(themedReactContext2, "KeyboardController::focusDidSet", writableMapCreateMap);
        }
        if (view2 == null) {
            this$0.dispatchEventToJS(FocusedInputObserverKt.getNoFocusedInputEvent());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void focusListener$lambda$4$lambda$2$lambda$1(EditText input, TextWatcher textWatcher) {
        Intrinsics.checkNotNullParameter(input, "$input");
        input.removeTextChangedListener(textWatcher);
    }

    public final void syncUpLayout() {
        EditText editText = this.lastFocusedInput;
        if (editText == null) {
            return;
        }
        int[] screenLocation = ViewKt.getScreenLocation(editText);
        dispatchEventToJS(new FocusedInputLayoutChangedEventData(FloatKt.getDp(editText.getX()), FloatKt.getDp(editText.getY()), FloatKt.getDp(editText.getWidth()), FloatKt.getDp(editText.getHeight()), FloatKt.getDp(screenLocation[0]), FloatKt.getDp(screenLocation[1]), editText.getId(), EditTextKt.getParentScrollViewTarget(editText)));
    }

    public final void destroy() {
        this.view.getViewTreeObserver().removeOnGlobalFocusChangeListener(this.focusListener);
    }

    private final void dispatchEventToJS(FocusedInputLayoutChangedEventData event) {
        if (Intrinsics.areEqual(event, this.lastEventDispatched)) {
            return;
        }
        this.lastEventDispatched = event;
        ThemedReactContextKt.dispatchEvent(this.context, this.eventPropagationView.getId(), new FocusedInputLayoutChangedEvent(this.surfaceId, this.eventPropagationView.getId(), event));
    }
}
