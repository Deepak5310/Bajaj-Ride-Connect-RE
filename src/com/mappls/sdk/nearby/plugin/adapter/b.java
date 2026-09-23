package com.mappls.sdk.nearby.plugin.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.mappls.sdk.nearby.plugin.fragment.NearbyResultCallback;
import com.mappls.sdk.nearby.plugin.view.NearbyResultViewOption;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends FragmentStateAdapter {
    private final NearbyResultViewOption a;
    private final NearbyResultCallback b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(FragmentActivity activity, NearbyResultViewOption viewOption, NearbyResultCallback callback) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(viewOption, "viewOption");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.a = viewOption;
        this.b = callback;
    }

    public static void a(NearbyResultCallback callback, Fragment fragment) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (fragment != null) {
            if (fragment instanceof com.mappls.sdk.nearby.plugin.fragment.a) {
                ((com.mappls.sdk.nearby.plugin.fragment.a) fragment).a(callback);
            } else if (fragment instanceof com.mappls.sdk.nearby.plugin.fragment.b) {
                ((com.mappls.sdk.nearby.plugin.fragment.b) fragment).a(callback);
            }
        }
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public final Fragment createFragment(int i) {
        if (i == 0) {
            com.mappls.sdk.nearby.plugin.fragment.a aVar = new com.mappls.sdk.nearby.plugin.fragment.a();
            aVar.a(this.b);
            return aVar;
        }
        int i2 = com.mappls.sdk.nearby.plugin.fragment.b.f;
        com.mappls.sdk.nearby.plugin.fragment.b bVarA = com.mappls.sdk.nearby.plugin.fragment.b.a.a(this.a);
        bVarA.a(this.b);
        return bVarA;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return 2;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int i) {
        return i;
    }
}
