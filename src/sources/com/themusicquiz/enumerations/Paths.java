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
