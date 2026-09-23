package com.mappls.sdk.navigation.ui.navigation.instructioncontainer;

import android.view.View;
import com.mappls.sdk.navigation.ui.common.NonSwipeableViewPager;
import com.mappls.sdk.navigation.ui.navigation.o;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ g a;
    public final /* synthetic */ InstructionContainerView b;

    public a(InstructionContainerView instructionContainerView, g gVar) {
        this.b = instructionContainerView;
        this.a = gVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int currentItem = this.b.binding.navigationInfoLayoutNew.getCurrentItem();
        InstructionContainerView instructionContainerView = this.b;
        if (currentItem > instructionContainerView.currentPageLocation) {
            NonSwipeableViewPager nonSwipeableViewPager = instructionContainerView.binding.navigationInfoLayoutNew;
            nonSwipeableViewPager.setCurrentItem(nonSwipeableViewPager.getCurrentItem() - 1);
            g gVar = this.a;
            if (gVar != null) {
                ((o) gVar).b();
            }
        }
    }
}
