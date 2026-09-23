package com.reactnativekeyboardcontroller.traversal;

import android.widget.EditText;
import com.reactnativekeyboardcontroller.extensions.EditTextKt;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FocusedInputHolder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005R\u0018\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/reactnativekeyboardcontroller/traversal/FocusedInputHolder;", "", "()V", "input", "Ljava/lang/ref/WeakReference;", "Landroid/widget/EditText;", "focus", "", "get", "set", "textInput", "react-native-keyboard-controller_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FocusedInputHolder {
    public static final FocusedInputHolder INSTANCE = new FocusedInputHolder();
    private static WeakReference<EditText> input;

    private FocusedInputHolder() {
    }

    public final void set(EditText textInput) {
        Intrinsics.checkNotNullParameter(textInput, "textInput");
        input = new WeakReference<>(textInput);
    }

    public final EditText get() {
        WeakReference<EditText> weakReference = input;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void focus() {
        EditText editText;
        WeakReference<EditText> weakReference = input;
        if (weakReference == null || (editText = weakReference.get()) == null) {
            return;
        }
        EditTextKt.focus(editText);
    }
}
