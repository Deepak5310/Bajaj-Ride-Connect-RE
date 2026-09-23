package com.reactnativekeyboardcontroller.traversal;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import com.facebook.react.bridge.UiThreadUtil;
import com.reactnativekeyboardcontroller.extensions.EditTextKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ViewHierarchyNavigator.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u0002J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0006¨\u0006\u0018"}, d2 = {"Lcom/reactnativekeyboardcontroller/traversal/ViewHierarchyNavigator;", "", "()V", "findEditTextInDirection", "Landroid/widget/EditText;", "currentFocus", "Landroid/view/View;", "direction", "", "findEditTextInHierarchy", "viewGroup", "Landroid/view/ViewGroup;", "findEditTextOrGoDeeper", "child", "findNextEditText", "findPreviousEditText", "getAllInputFields", "", "isValidTextInput", "", "view", "setFocusTo", "", "", "react-native-keyboard-controller_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ViewHierarchyNavigator {
    public static final ViewHierarchyNavigator INSTANCE = new ViewHierarchyNavigator();

    private ViewHierarchyNavigator() {
    }

    public final void setFocusTo(String direction, View view) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(view, "view");
        final EditText editTextFindNextEditText = Intrinsics.areEqual(direction, "next") ? findNextEditText(view) : findPreviousEditText(view);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativekeyboardcontroller.traversal.ViewHierarchyNavigator$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                EditTextKt.focus(editTextFindNextEditText);
            }
        });
    }

    public final List<EditText> getAllInputFields(View viewGroup) {
        ArrayList arrayList = new ArrayList();
        getAllInputFields$findEditTexts(arrayList, viewGroup);
        return arrayList;
    }

    private static final void getAllInputFields$findEditTexts(List<EditText> list, View view) {
        if (INSTANCE.isValidTextInput(view)) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.EditText");
            list.add((EditText) view);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                getAllInputFields$findEditTexts(list, viewGroup.getChildAt(i));
            }
        }
    }

    private final EditText findNextEditText(View currentFocus) {
        return findEditTextInDirection(currentFocus, 1);
    }

    private final EditText findPreviousEditText(View currentFocus) {
        return findEditTextInDirection(currentFocus, -1);
    }

    private final EditText findEditTextInDirection(View currentFocus, int direction) {
        ViewParent parent = currentFocus.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return null;
        }
        int iIndexOfChild = viewGroup.indexOfChild(currentFocus);
        int i = direction > 0 ? iIndexOfChild + 1 : iIndexOfChild - 1;
        int childCount = direction > 0 ? viewGroup.getChildCount() : -1;
        while (i != childCount) {
            View childAt = viewGroup.getChildAt(i);
            Intrinsics.checkNotNull(childAt);
            EditText editTextFindEditTextOrGoDeeper = findEditTextOrGoDeeper(childAt, direction);
            if (editTextFindEditTextOrGoDeeper != null) {
                return editTextFindEditTextOrGoDeeper;
            }
            i += direction;
        }
        return findEditTextInDirection(viewGroup, direction);
    }

    private final EditText findEditTextInHierarchy(ViewGroup viewGroup, int direction) {
        int childCount = viewGroup.getChildCount();
        IntRange intRangeUntil = direction > 0 ? RangesKt.until(0, childCount) : RangesKt.downTo(childCount - 1, 0);
        int first = intRangeUntil.getFirst();
        int last = intRangeUntil.getLast();
        int step = intRangeUntil.getStep();
        if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
            return null;
        }
        while (true) {
            View childAt = viewGroup.getChildAt(first);
            Intrinsics.checkNotNull(childAt);
            EditText editTextFindEditTextOrGoDeeper = findEditTextOrGoDeeper(childAt, direction);
            if (editTextFindEditTextOrGoDeeper != null) {
                return editTextFindEditTextOrGoDeeper;
            }
            if (first == last) {
                return null;
            }
            first += step;
        }
    }

    private final EditText findEditTextOrGoDeeper(View child, int direction) {
        if (isValidTextInput(child)) {
            Intrinsics.checkNotNull(child, "null cannot be cast to non-null type android.widget.EditText");
            return (EditText) child;
        }
        if (child instanceof ViewGroup) {
            return findEditTextInHierarchy((ViewGroup) child, direction);
        }
        return null;
    }

    private final boolean isValidTextInput(View view) {
        return (view instanceof EditText) && ((EditText) view).isEnabled();
    }
}
