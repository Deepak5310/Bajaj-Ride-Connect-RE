package com.mappls.sdk.navigation.ui.navigation.instructioncontainer;

import android.view.View;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.ui.common.NonSwipeableViewPager;
import com.mappls.sdk.navigation.ui.navigation.o;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ g a;
    public final /* synthetic */ InstructionContainerView b;

    public b(InstructionContainerView instructionContainerView, g gVar) {
        this.b = instructionContainerView;
        this.a = gVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.b.binding.navigationInfoLayoutNew.getCurrentItem() < MapplsNavigationHelper.getInstance().getNavigationSteps().size()) {
            NonSwipeableViewPager nonSwipeableViewPager = this.b.binding.navigationInfoLayoutNew;
            nonSwipeableViewPager.setCurrentItem(nonSwipeableViewPager.getCurrentItem() + 1);
            g gVar = this.a;
            if (gVar != null) {
                ((o) gVar).a();
            }
        }
    }
}
