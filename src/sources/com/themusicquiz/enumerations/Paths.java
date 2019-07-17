/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-17 17:35:16 
 * @Last Modified by:   Alexandre Ladrière 
 * @Last Modified time: 2019-07-17 17:35:16 
 */
package com.themusicquiz.enumerations;

public enum Paths {
    DBPath("../../DB/");

    protected String path = "";

    Paths(String pPath) {
        this.path = pPath;
    }

    public String getPath() {
        return this.path;
    }
}
