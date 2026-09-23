package com.mappls.sdk.services.api.predictive.directions.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class PredictiveDirectionSign {

    @SerializedName("exit_branch_elements")
    @Expose
    private List<PredictiveDirectionExitBranch> exitBranchElements;

    public List<PredictiveDirectionExitBranch> getExitBranchElements() {
        return this.exitBranchElements;
    }

    public void setExitBranchElements(List<PredictiveDirectionExitBranch> list) {
        this.exitBranchElements = list;
    }
}
