package com.zoontek.rnbootsplash;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RNBootSplash.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/zoontek/rnbootsplash/RNBootSplash;", "", "()V", "init", "", "activity", "Landroid/app/Activity;", "themeResId", "", "react-native-bootsplash_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RNBootSplash {
    public static final RNBootSplash INSTANCE = new RNBootSplash();

    private RNBootSplash() {
    }

    @JvmStatic
    public static final void init(Activity activity, int themeResId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        RNBootSplashModuleImpl.INSTANCE.init$react_native_bootsplash_release(activity, themeResId);
    }
}
