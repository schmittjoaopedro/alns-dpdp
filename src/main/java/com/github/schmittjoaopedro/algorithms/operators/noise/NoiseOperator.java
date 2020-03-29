package com.github.schmittjoaopedro.algorithms.operators.noise;

import com.github.schmittjoaopedro.algorithms.Operator;

public class NoiseOperator extends Operator {

    private int useNoise;

    public NoiseOperator(int useNoise) {
        this.useNoise = useNoise;
    }

    public int getUseNoise() {
        return useNoise;
    }
}
