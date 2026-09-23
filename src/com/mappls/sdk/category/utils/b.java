package com.mappls.sdk.category.utils;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class b {
    public static void a(FragmentActivity ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Object systemService = ctx.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        View currentFocus = ctx.getCurrentFocus();
        if (currentFocus == null) {
            currentFocus = new View(ctx);
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
    }

    public static String a(Object[] tokens) {
        Intrinsics.checkNotNullParameter(";", "deliminator");
        Intrinsics.checkNotNullParameter(tokens, "tokens");
        StringBuilder sb = new StringBuilder();
        int length = tokens.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append((CharSequence) ";");
            }
            sb.append(tokens[i]);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "builder.toString()");
        return string;
    }
}
