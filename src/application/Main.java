package application;

import java.io.FileInputStream;
import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Main extends Application {

	private ArrayList<Thing> things = new ArrayList<>();

	private Pane root = new Pane(); // Group contain all the objects of Group and can show on the screen
										// with add method
	private Timeline timeline = new Timeline(); // to play the animation and hold all the keyframes

	private static final int WINDOW_WIDTH = 600;
	private static final int WINDOW_HEIGHT = 600;
	private static final int IMAGE_WIDTH = 40;
	private static final int IMAGE_HEIGHT = 40;

	public void start(Stage primaryStage) {

		primaryStage.setTitle("Bug World");

		try {

			BorderPane border = new BorderPane();
			HBox hbox = new HBox();
			hbox.setPadding(new Insets(15, 12, 15, 12));
			hbox.setSpacing(10);
			hbox.setStyle("-fx-background-color: #336699;");
			border.setTop(hbox);
//			GridPane grid = new GridPane();
//			this.grid = addGridPane();

			Button thingButton = new Button("AddThings");
			thingButton.setPrefSize(100, 20);
			thingButton.setOnAction(event -> {
				addThingsToWorld();
			});

			Button playButton = new Button("Start Moving");
			playButton.setPrefSize(100, 20);
			playButton.setOnAction(event -> {
				animate();
			});

			Button stopButton = new Button(" Stop Moving");
			stopButton.setPrefSize(100, 20);
			stopButton.setOnAction(event -> {
				pauseAnimation();
			});

			Button exit = new Button("Exit");
			playButton.setPrefSize(100, 20);
			exit.setOnAction(action -> Platform.exit());

			hbox.getChildren().addAll(thingButton, playButton, stopButton, exit);
			hbox.setPrefWidth(600);

			Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT); // scene build the main screen/window it contain
																		// all the objects

			root.getChildren().addAll(hbox);
			root.setStyle("-fx-background-color:#228B22;");
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private void pauseAnimation() {
		// TODO Auto-generated method stub
		timeline.pause();
	}

	private void animate() {
		// TODO Auto-generated method stub
		timeline.play();
	}

	public void addThingsToWorld() {

		for (int i = 0; i < 3; i++) {
			double x = (Math.random() * (WINDOW_WIDTH - IMAGE_WIDTH));
			double y = (Math.random() * (WINDOW_HEIGHT - IMAGE_HEIGHT));
			things.add(new Ant(x, y, "BugImages_ant.jpg"));
		}

		for (int i = 0; i < 3; i++) {
			double x = (Math.random() * (WINDOW_WIDTH - IMAGE_WIDTH));
			double y = (Math.random() * (WINDOW_HEIGHT - IMAGE_HEIGHT));
			things.add(new Bee(x, y, "bee.gif"));
		}

		for (int i = 0; i < 3; i++) {
			double x = (Math.random() * (WINDOW_WIDTH - IMAGE_WIDTH));
			double y = (Math.random() * (WINDOW_HEIGHT - IMAGE_HEIGHT));
			things.add(new Dragonfly(x, y, "BugImages_Dragonfly.jpg"));
		}

		for (int i = 0; i < 5; i++) {
			double x = (Math.random() * (WINDOW_WIDTH - IMAGE_WIDTH));
			double y = (Math.random() * (WINDOW_HEIGHT - IMAGE_HEIGHT));
			things.add(new Grass(x, y, "PlantImage_Grass.jpg"));
		}

		for (int i = 0; i < 5; i++) {
			double x = (Math.random() * (WINDOW_WIDTH - IMAGE_WIDTH));
			double y = (Math.random() * (WINDOW_HEIGHT - IMAGE_HEIGHT));
			things.add(new Tree(x, y, "Tree.jpg"));
		}

		for (int i = 0; i < 5; i++) {
			double x = (Math.random() * (WINDOW_WIDTH - IMAGE_WIDTH));
			double y = (Math.random() * (WINDOW_HEIGHT - IMAGE_HEIGHT));
			things.add(new Obstacle(x, y, "obstcle_jpg.jpg"));
		}

		for (Thing obj : things) {

			// add bugs, plants and obstacle to your view groups
			ImageView i = displayImage(obj);
			root.getChildren().add(i);

			// Build the animation for Bugs
			if (obj instanceof Bug) {
				KeyFrame frame = getFrame(i, (Bug) obj); // cast Bug to object so only Bugs move

				// add all keyframe to Timeline
				timeline.getKeyFrames().add(frame);
			}

		}

		timeline.setCycleCount(javafx.animation.Animation.INDEFINITE); // to continue animation

	}

	// this will create the image at the bug position and bug image path
	private ImageView displayImage(Thing obj) {
		try {

			FileInputStream input = new FileInputStream(obj.getImagePath());
			Image image = new Image(input);
			ImageView imageView = new ImageView(image); // display image
			imageView.setX(obj.getX());
			imageView.setY(obj.getY()); // set initial X Y position of the images
			imageView.setFitHeight(IMAGE_HEIGHT);
			imageView.setFitWidth(IMAGE_WIDTH);

			return imageView;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// Created a method to move the image on the screen -animation
	private KeyFrame getFrame(ImageView iv, Bug bug) { // Building keyframe for the animation, inside keyframe animate
														// image

		KeyFrame frame = new KeyFrame(Duration.millis(20), e -> { // giving a no. in millisecond to move my bug, its a
																	// unit-separator or gap between your frames.

			Bounds boundsInScene = iv.localToScene(iv.getBoundsInLocal()); // absolute position of each image(current
																			// time position)
			int dy = 0;
			int dx = 0;
			int r = bug.getRandomDirection();

			if (r == 1) { // Bug will move in 8 direction
				dy = -1;
				dx = 0;

			} else if (r == 2) {
				dy = -1;
				dx = 1;

			} else if (r == 3) {
				dx = 1;
				dy = 0;

			} else if (r == 4) {
				dy = 1;
				dx = 1;

			} else if (r == 5) {
				dx = 0;
				dy = 1;

			} else if (r == 6) {
				dx = -1;
				dy = 1;

			} else if (r == 7) {
				dy = 0;
				dx = -1;

			} else if (r == 8) {
				dy = -1;
				dx = -1;

			}

			// Preventing bug moving outside of the world
			// Top, Right, Bottom , Left
			if (boundsInScene.getMinY() <= 40 && (r == 8 || r == 1 || r == 2)) {
				bug.setRandomDirection((int) (Math.random() * 7) + 1);

			} else if (boundsInScene.getMinX() >= 560 && (r == 2 || r == 3 || r == 4)) {

				bug.setRandomDirection((int) (Math.random() * 7) + 1);

			} else if (boundsInScene.getMaxY() >= 560 && (r == 4 || r == 5 || r == 6)) {

				bug.setRandomDirection((int) (Math.random() * 7) + 1);

			} else if (boundsInScene.getMaxX() <= 40 && (r == 6 || r == 7 || r == 8)) {

				bug.setRandomDirection((int) (Math.random() * 7) + 1);

			}

			bug.setY(boundsInScene.getMinY());
			bug.setX(boundsInScene.getMinX());

			// getTranslate is gives the current position of the bug
			iv.setTranslateX(iv.getTranslateX() + dx);
			iv.setTranslateY(iv.getTranslateY() + dy);

		});

		return frame;

	}


	public static void main(String[] args) {
		launch(args);
	}
}
