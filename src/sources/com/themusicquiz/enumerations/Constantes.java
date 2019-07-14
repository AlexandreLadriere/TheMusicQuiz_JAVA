package com.themusicquiz.enumerations;

public enum Constantes {
    NUMBER_OF_DB_PARAMETERS(4),
    NUMBER_OF_PROPOSITIONS(4),
    NUMBER_OF_QUESTIONS(3);

    protected int value = 0;

    Constantes(int pValue) {
        this.value = pValue;
    }

    public String toString() {
        return Integer.toString(this.value);
    }

    public int getValue() {
        return value;
    }
}
