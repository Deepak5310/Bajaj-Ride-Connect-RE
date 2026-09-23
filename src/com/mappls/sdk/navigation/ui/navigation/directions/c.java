package com.mappls.sdk.navigation.ui.navigation.directions;

import android.content.Context;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.mappls.sdk.navigation.ui.R;
import com.mappls.sdk.navigation.ui.databinding.LayoutDirectionAdapterHeaderBinding;

/* JADX INFO: loaded from: classes4.dex */
public final class c extends RecyclerView.ViewHolder {
    public final LayoutDirectionAdapterHeaderBinding a;

    public c(LayoutDirectionAdapterHeaderBinding layoutDirectionAdapterHeaderBinding) {
        super(layoutDirectionAdapterHeaderBinding.getRoot());
        this.a = layoutDirectionAdapterHeaderBinding;
        ImageView imageView = layoutDirectionAdapterHeaderBinding.directionImage;
        Context context = layoutDirectionAdapterHeaderBinding.getRoot().getContext();
        imageView.setImageDrawable(ContextCompat.getDrawable(context, com.mappls.sdk.navigation.ui.theme.a.a(context, R.attr.navigationViewdirectionListSourceDrawable).resourceId));
        layoutDirectionAdapterHeaderBinding.navigationListDesc.setText(layoutDirectionAdapterHeaderBinding.getRoot().getContext().getResources().getString(R.string.mappls_navigation_starting_text));
        layoutDirectionAdapterHeaderBinding.navigationDirectionPlaceName.setText(layoutDirectionAdapterHeaderBinding.getRoot().getContext().getResources().getString(R.string.mappls_navigation_your_current_location));
    }
}
