package com.mappls.sdk.navigation.ui.theme;

import android.content.Context;
import android.util.TypedValue;
import androidx.core.content.ContextCompat;
import com.mappls.sdk.navigation.ui.NavigationOptions;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    public static int a = 1;

    public static void a(Context context, NavigationOptions navigationOptions) {
        if (navigationOptions.navigationTheme().intValue() == 0) {
            a = (context.getResources().getConfiguration().uiMode & 48) == 32 ? 2 : 1;
        } else {
            a = navigationOptions.navigationTheme().intValue();
        }
        context.setTheme((a() ? navigationOptions.navigationDarkTheme() : navigationOptions.navigationLightTheme()).intValue());
    }

    public static int b(Context context, int i) {
        TypedValue typedValueA = a(context, i);
        int i2 = typedValueA.type;
        return (i2 < 28 || i2 > 31) ? ContextCompat.getColor(context, typedValueA.resourceId) : typedValueA.data;
    }

    public static TypedValue a(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue;
    }

    public static boolean a() {
        return a == 2;
    }
}
