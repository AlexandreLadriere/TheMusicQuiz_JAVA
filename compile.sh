cd ./src/sources/

javac -d ../classes com/themusicquiz/enumerations/QuestionType.java
javac -d ../classes com/themusicquiz/enumerations/Paths.java
javac -d ../classes com/themusicquiz/enumerations/MusicGenres.java
javac -d ../classes com/themusicquiz/enumerations/Constantes.java

javac -d ../classes com/themusicquiz/composants/RandGenerator.java
javac -d ../classes com/themusicquiz/composants/FileHandler.java
javac -d ../classes com/themusicquiz/composants/Item.java
javac -d ../classes com/themusicquiz/composants/Question.java
javac -d ../classes com/themusicquiz/composants/QuestionSerie.java 
javac -d ../classes com/themusicquiz/composants/Test.java
javac -d ../classes com/themusicquiz/composants/Quiz.java
javac -d ../classes com/themusicquiz/composants/URLBrowser.java

#export your javafx path
export PATH_TO_FX=/usr/share/java/openjfx-12.0.1_linux-x64_bin-sdk/javafx-sdk-12.0.1/lib
#compile
javac --module-path $PATH_TO_FX --add-modules javafx.controls -d ../classes com/themusicquiz/GUI/NodeGetter.java
javac --module-path $PATH_TO_FX --add-modules javafx.controls -d ../classes com/themusicquiz/GUI/WelcomeScene.java
javac --module-path $PATH_TO_FX --add-modules javafx.controls -d ../classes com/themusicquiz/GUI/SceneApp.java
javac --module-path $PATH_TO_FX --add-modules javafx.controls -d ../classes com/themusicquiz/GUI/HomeScene.java
javac --module-path $PATH_TO_FX --add-modules javafx.controls -d ../classes com/themusicquiz/GUI/ModeSelectionScene.java
javac --module-path $PATH_TO_FX --add-modules javafx.controls -d ../classes com/themusicquiz/GUI/GenreSelectionScene.java
javac --module-path $PATH_TO_FX --add-modules javafx.controls -d ../classes com/themusicquiz/GUI/HiphopLanguageScene.java
javac --module-path $PATH_TO_FX --add-modules javafx.controls -d ../classes com/themusicquiz/GUI/QuestionScene.java
javac --module-path $PATH_TO_FX --add-modules javafx.controls -d ../classes com/themusicquiz/GUI/ResultsScene.java
javac --module-path $PATH_TO_FX --add-modules javafx.controls -d ../classes com/themusicquiz/GUI/Gui.java
javac --module-path $PATH_TO_FX --add-modules javafx.controls -d ../classes com/themusicquiz/GUI/Controller.java
javac --module-path $PATH_TO_FX --add-modules javafx.controls -d ../classes com/themusicquiz/GUI/Main.java
