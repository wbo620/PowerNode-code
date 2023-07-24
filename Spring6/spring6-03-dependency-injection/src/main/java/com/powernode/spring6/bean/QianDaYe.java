package com.powernode.spring6.bean;

import java.util.Arrays;

public class QianDaYe {
    private String []aihaos;
    private Woman[] wommen;

    public void setAihaos(String[] aihaos) {
        this.aihaos = aihaos;
    }

    public void setWommens(Woman[] wommen) {
        this.wommen = wommen;
    }

    @Override
    public String toString() {
        return "QianDaYe{" +
                "aihaos=" + Arrays.toString(aihaos) +
                ", wommens=" + Arrays.toString(wommen) +
                '}';
    }
}
