cd ./src/classes
#java com/themusicquiz/composants/Test
#export your javafx path
export PATH_TO_FX=/usr/share/java/openjfx-12.0.1_linux-x64_bin-sdk/javafx-sdk-12.0.1/lib
java --module-path $PATH_TO_FX --add-modules javafx.controls com.themusicquiz.GUI.Main
