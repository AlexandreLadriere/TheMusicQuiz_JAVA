/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-17 17:35:21 
 * @Last Modified by:   Alexandre Ladrière 
 * @Last Modified time: 2019-07-17 17:35:21 
 */
package com.themusicquiz.enumerations;

public enum MusicGenres {
    US_hiphop("Hip-hop", "hiphop", "US hip-hop", "US_hiphop"), 
    FR_hiphop("Hip-hop", "hiphop", "FR hip-hop", "FR_hiphop");

    protected String musicGenre_toDisplay = "";
    protected String musicGenre_name = "";
    protected String musicGenreLanguage_toDisplay = "";
    protected String musicGenreLanguage_name = "";

    MusicGenres(String pMusicGenre_toDisplay, String pMusicGenre_name, String pMusicGenreLanguage_toDisplay, String pMusicGenreLanguage_name) {
        this.musicGenre_toDisplay = pMusicGenre_toDisplay;
        this.musicGenre_name = pMusicGenre_name;
        this.musicGenreLanguage_toDisplay = pMusicGenreLanguage_toDisplay;
        this.musicGenreLanguage_name = pMusicGenreLanguage_name;
    }
    
    public String toString() {
        return "musicGenre_toDisplay: "+this.musicGenre_toDisplay+"\nmusicGenre_name: "+this.musicGenre_name+"\nmusicGenreLanguage_toDisplay: "+this.musicGenreLanguage_toDisplay+"\nmusicGenreLanguage_name: "+this.musicGenreLanguage_name;
    }

    public String getMusicGenre_toDisplay() {
        return this.musicGenre_toDisplay;
    }

    public String getMusicGenre_name() {
        return this.musicGenre_name;
    }

    public String getMusicGenreLanguage_toDisplay() {
        return this.musicGenreLanguage_toDisplay;
    }

    public String getMusicGenreLanguage_name() {
        return this.musicGenreLanguage_name;
    }
}
