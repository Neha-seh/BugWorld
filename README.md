# BugWorld
For JAVAFX GUI, We will need to download and add the JavaFX library to the project directory, and then add vm arguments for each module included in the library in the build path.

First, we have to install eclipse plugins for JavaFX called e(fx)clipse or efxclipse. Help -- Eclipse MarketPlace -- and search e(fx)clipse and click Install. Now, we have our eclipse set up and the plugins we need. And now we have a new option in Eclipse -- File -- New -- Other -- JavaFX project

Now, we have to download JAVAFX on our computer by following the instructions- 1-Open this page: https://gluonhq.com/products/javafx/​ . 2- Find the latest version and click download, once it has downloaded you want to extract it to a folder, it can be any folder, and remember its location.

Next thing we’ll be doing is creating an user library.

Window -- Preferences -- User Libraries -- New -- Call it JavaFX
or
Right Click on the project-- Build path-- Configure biuld path-- Classpath---Add library-- User Librarries -- next --javafx

Next, we need tu set up the run configuration by adding: --module-path "D:\javafx\javafx-sdk-14.0.1\lib" --add-modules javafx.controls,javafx.fxml to our VM arguments.
