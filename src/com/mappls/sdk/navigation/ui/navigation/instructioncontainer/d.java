package com.mappls.sdk.navigation.ui.navigation.instructioncontainer;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements Observer {
    public final /* synthetic */ InstructionContainrPIPView a;

    public d(InstructionContainrPIPView instructionContainrPIPView) {
        this.a = instructionContainrPIPView;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        this.a.setAdviseInfo((e) obj);
    }
}
