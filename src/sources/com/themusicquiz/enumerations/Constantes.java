/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-17 17:34:07 
 * @Last Modified by:   Alexandre Ladrière 
 * @Last Modified time: 2019-07-17 17:34:07 
 */
package com.themusicquiz.enumerations;

public enum Constantes {
    NUMBER_OF_DB_PARAMETERS(4),
    NUMBER_OF_PROPOSITIONS(4),
    NUMBER_OF_QUESTIONS(10);

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
