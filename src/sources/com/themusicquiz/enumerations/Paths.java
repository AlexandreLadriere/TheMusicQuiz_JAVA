/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-17 17:35:16 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-07-26 18:32:00
 */
package com.themusicquiz.enumerations;

public enum Paths {
    DBPath("../../DB/"),
    CSS_THEME_PATH("../css/Theme.css"),
    ALBUM_ICON("../../resources/icons/baseline-album-android-white/res/drawable-xxxhdpi/baseline_album_white_48.png"),
    ADD_ICON("../../resources/icons/baseline-add-android-white/res/drawable-xxxhdpi/baseline_add_white_48.png"),
    HOME_ICON("../../resources/icons/outline-home-android-white/res/drawable-xxxhdpi/outline_home_white_48.png"),
    OPEN_IN_BROWSER_ICON("../../resources/icons/baseline-open_in_browser-android-black/res/drawable-xxxhdpi/baseline_open_in_browser_black_48.png"),
    SKIP_NEXT_ICON("../../resources/icons/baseline-skip_next-android-white/res/drawable-xxxhdpi/baseline_skip_next_white_48.png"),
    SHUFFLE_ICON("../../resources/icons/baseline-shuffle-android-white/res/drawable-xxxhdpi/baseline_shuffle_white_48.png"),
    SEARCH_ICON("../../resources/icons/baseline-search-android-white/res/drawable-xxxhdpi/baseline_search_white_48.png"),
    REPLAY_ICON("../../resources/icons/baseline-replay-android-white/res/drawable-xxxhdpi/baseline_replay_white_48.png"),
    EVENT_ICON("../../resources/icons/baseline-event-android-white/res/drawable-xxxhdpi/baseline_event_white_48.png"),
    HELP_ICON("../../resources/icons/baseline-help-android-white/res/drawable-xxxhdpi/baseline_help_white_48.png"),
    IMAGE_ICON("../../resources/icons/baseline-image-android-white/res/drawable-xxxhdpi/baseline_image_white_48.png"),
    PERSON_ICON("../../resources/icons/baseline-person-android-white/res/drawable-xxxhdpi/baseline_person_white_48.png"),
    CLOSE_ICON("../../resources/icons/baseline-close-android-white/res/drawable-xxxhdpi/baseline_close_white_48.png");

    protected String path = "";

    Paths(String pPath) {
        this.path = pPath;
    }

    public String getPath() {
        return this.path;
    }
}
