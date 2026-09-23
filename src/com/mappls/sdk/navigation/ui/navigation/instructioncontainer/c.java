package com.mappls.sdk.navigation.ui.navigation.instructioncontainer;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements Observer {
    public final /* synthetic */ InstructionContainerView a;

    public c(InstructionContainerView instructionContainerView) {
        this.a = instructionContainerView;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        this.a.setAdviseInfo(((e) obj).a);
    }
}
