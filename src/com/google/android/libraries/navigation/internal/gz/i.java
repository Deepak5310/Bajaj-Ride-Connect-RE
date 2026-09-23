package com.google.android.libraries.navigation.internal.gz;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import com.facebook.imageutils.JfifUtil;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i {
    public static final boolean a(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        return c(resources);
    }

    public static final boolean b(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "<this>");
        return (configuration.screenLayout & JfifUtil.MARKER_SOFn) == 128;
    }

    public static final boolean c(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "<this>");
        Configuration configuration = resources.getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "getConfiguration(...)");
        return b(configuration);
    }

    public static final boolean d(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return a(context);
    }
}
