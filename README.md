# Getting started

---

## Requirements

1. JDK 14 14 ([download & install](https://www.oracle.com/java/technologies/javase-jdk14-downloads.html))
3. Code editor (preferably [IntelliJ IDEA](https://www.jetbrains.com/idea/))

## Get started

Clone repo from GitHub: [github.com/vweltje/proftaak-oo-beheer-avd-java-devopment](https://github.com/vweltje/proftaak-oo-beheer-avd-java-devopment) and open project with IntelliJ.

#### Create a library
Go to `File -> Project Structure -> Libraries` and add the JavaFX 14 SDK as a library to the project. Point to the `lib` folder of the JavaFX SDK.
Once the library is applied, the JavaFX classes will be recognized by the IDE.

####  Add VM options
Click on Run -> Edit Configurations... and add these VM options:

Mac/Linux: `--module-path /path/to/javafx-sdk-14/lib --add-modules javafx.controls,javafx.fxml`

Windows: `--module-path "\path\to\javafx-sdk-14\lib" --add-modules javafx.controls,javafx.fxml`

#### Run the project
Click `Run -> Run...` to run the project, now it should work fine.

Alternatively check out the official JavaFX getting started: [https://openjfx.io/openjfx-docs/#IDE-Intellij](https://openjfx.io/openjfx-docs/#IDE-Intellij) 