package sample;


import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.print.attribute.standard.Media;
import java.io.File;

public class Main extends Application {

    public AnchorPane anchorPane;
    public final Text propertyText = new Text("Properties");
    public final Text AnimationText = new Text("Animations");
    static MediaPlayer mediaPlayer;
    boolean isPlaying = true;


    @Override
    public void start(Stage primaryStage) throws Exception {

        String bip = "src/sample/music/LostSong.mp3";
        javafx.scene.media.Media hit = new javafx.scene.media.Media(new File(bip).toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);


        BorderPane borderPane = new BorderPane();
        VBox leftVBox = new VBox();
        leftVBox.setStyle("-fx-spacing: 5;" +
                "-fx-background-color: aliceblue;");
        VBox rightVBox = new VBox();
        rightVBox.setStyle("-fx-spacing: 5;" +
                "-fx-background-color: aliceblue;");
        FlowPane shapesFlowPane = new FlowPane();
        shapesFlowPane.setPrefWrapLength(70);
        shapesFlowPane.setVgap(4);

        FlowPane animationFlowPane = new FlowPane();
        animationFlowPane.setPrefWrapLength(70);
        animationFlowPane.setVgap(4);
        animationFlowPane.setAlignment(Pos.TOP_CENTER);

        FlowPane colorFlowPane = new FlowPane();
        colorFlowPane.setPrefWrapLength(60);
        colorFlowPane.setVgap(2);
        colorFlowPane.setAlignment(Pos.TOP_CENTER);

        leftVBox.setPadding(new Insets(50, 0, 15, 0));
        //shapesFlowPane.setPadding(new Insets(0,0,10,0));
        shapesFlowPane.setAlignment(Pos.TOP_CENTER);
        rightVBox.setPadding(new Insets(50, 0, 15, 0));
        DropShadow shadow = new DropShadow();

        ToggleGroup shapes = new ToggleGroup();

        Image pencilImg = new Image("sample/img/pencil.png");
        ToggleButton pencil = new ToggleButton("pencil", new ImageView(pencilImg));
        //pencil.setText("pencil");
        pencil.setPadding(new Insets(2, 2, 2, 2));
        pencil.setStyle("-fx-content-display: top;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-min-height: 60px;" +
                "-fx-min-width: 80px;" +
                "-fx-font-size: 10px;" +
                "-fx-background-color: linear-gradient(#ffffff, #d68fe6);" +
                "-fx-border-radius: 20px;" +
                "-fx-border-color: #cbbbcc; " +
                "-fx-background-radius: 20px;" +
                "-fx-graphic: url('../sample/img/pencil.png') ;");
        pencil.setToggleGroup(shapes);
        pencil.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            pencil.setEffect(shadow);
        });
        pencil.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            pencil.setEffect(null);
        });
        pencil.setUserData(pencil);


        Image lineImg = new Image("sample/img/line.png");
        ToggleButton line = new ToggleButton("line", new ImageView(lineImg));
        line.setPadding(new Insets(2, 2, 2, 2));
        //line.setText("line");
        line.setStyle("-fx-content-display: top;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-min-height: 60px;" +
                "-fx-min-width: 80px;" +
                "-fx-font-size: 10px;" +
                "-fx-background-color: linear-gradient(#ffffff, #d68fe6);" +
                "-fx-border-radius: 20px;" +
                "-fx-border-color: #cbbbcc;" +
                "-fx-background-radius: 20px;" +
                "-fx-graphic: url('../sample/img/line.png') ;");
        line.setToggleGroup(shapes);
        line.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            line.setEffect(shadow);
        });
        line.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            line.setEffect(null);
        });
        line.setUserData(line);

        Image ovalImg = new Image("sample/img/oval.png");
        ToggleButton oval = new ToggleButton("oval", new ImageView(ovalImg));
        oval.setPadding(new Insets(2, 2, 2, 2));
        //oval.setText("oval");
        oval.setStyle("-fx-content-display: top;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-min-height: 60px;" +
                "-fx-min-width: 80px;" +
                "-fx-font-size: 10px;" +
                "-fx-background-color: linear-gradient(#ffffff, #d68fe6);" +
                "-fx-border-radius: 20px;" +
                "-fx-border-color: #cbbbcc;" +
                "-fx-background-radius: 20px;" +
                "-fx-graphic: url('../sample/img/oval.png') ;");
        oval.setToggleGroup(shapes);
        oval.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            oval.setEffect(shadow);
        });
        oval.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            oval.setEffect(null);
        });
        oval.setUserData(oval);

        Image rectImg = new Image("sample/img/rectangle.png");
        ToggleButton rectangle = new ToggleButton("rectangle", new ImageView(rectImg));
        rectangle.setPadding(new Insets(2, 2, 2, 2));
        //rectangle.setText("rectangle");
        rectangle.setStyle("-fx-content-display: top;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-min-height: 60px;" +
                "-fx-min-width: 80px;" +
                "-fx-font-size: 10px;" +
                "-fx-background-color: linear-gradient(#ffffff, #d68fe6);" +
                "-fx-border-radius: 20px;" +
                "-fx-border-color: #cbbbcc;" +
                "-fx-background-radius: 20px;" +
                "-fx-graphic: url('../sample/img/rectangle.png') ;");
        rectangle.setToggleGroup(shapes);
        rectangle.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            rectangle.setEffect(shadow);
        });
        rectangle.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            rectangle.setEffect(null);
        });
        rectangle.setUserData(rectangle);


        ToggleButton circle = new ToggleButton("circle", new ImageView(ovalImg));
        circle.setPadding(new Insets(2, 2, 2, 2));
        //circle.setText("circle");
        circle.setStyle("-fx-content-display: top;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-min-height: 60px;" +
                "-fx-min-width: 80px;" +
                "-fx-font-size: 10px;" +
                "-fx-background-color: linear-gradient(#ffffff, #d68fe6);" +
                "-fx-border-radius: 20px;" +
                "-fx-border-color: #cbbbcc;" +
                "-fx-background-radius: 20px;" +
                "-fx-graphic: url('../sample/img/oval.png') ;");
        circle.setToggleGroup(shapes);
        circle.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            circle.setEffect(shadow);
        });
        circle.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            circle.setEffect(null);
        });
        circle.setUserData(circle);

        TextField imageRatio = new TextField();
        imageRatio.setPromptText("Image Ratio %");
        imageRatio.setPadding(new Insets(2, 2, 2, 2));
        imageRatio.setAlignment(Pos.CENTER);
        imageRatio.setStyle("-fx-content-display: top;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-min-height: 40px;" +
                "-fx-min-width: 60px;" +
                "-fx-font-size: 10px;" +
                "-fx-border-radius: 20px;" +
                "-fx-border-color: #cbbbcc;" +
                "-fx-background-radius: 20px;");

        CheckBox rotateCheck = new CheckBox();
        Image rotateImg = new Image("sample/img/rotate.png");
        Button rotate = new Button("rotate", new ImageView(rotateImg));
        rotate.setPadding(new Insets(2, 2, 2, 2));
        rotate.setStyle("-fx-content-display: top;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-min-height: 60px;" +
                "-fx-min-width: 80px;" +
                "-fx-font-size: 10px;" +
                "-fx-background-color: linear-gradient(#ffffff, #d68fe6);" +
                "-fx-border-radius: 20px;" +
                "-fx-border-color: #cbbbcc; " +
                "-fx-background-radius: 20px;");

        rotate.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            rotate.setEffect(shadow);
        });
        rotate.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            rotate.setEffect(null);
        });
        rotate.setOnMouseClicked((mouseEvent) -> {
            if (rotateCheck.isSelected()) {
                rotateCheck.setSelected(false);
            } else {
                rotateCheck.setSelected(true);
            }
        });

        CheckBox RrotateCheck = new CheckBox();
        Image RrotateImg = new Image("sample/img/rotate-right.png");
        Button Rrotate = new Button("right rotate", new ImageView(RrotateImg));
        Rrotate.setPadding(new Insets(2, 2, 2, 2));
        Rrotate.setStyle("-fx-content-display: top;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-min-height: 60px;" +
                "-fx-min-width: 80px;" +
                "-fx-font-size: 10px;" +
                "-fx-background-color: linear-gradient(#ffffff, #d68fe6);" +
                "-fx-border-radius: 20px;" +
                "-fx-border-color: #cbbbcc; " +
                "-fx-background-radius: 20px;");

        Rrotate.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            Rrotate.setEffect(shadow);
        });
        Rrotate.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            Rrotate.setEffect(null);
        });
        Rrotate.setOnMouseClicked((mouseEvent) -> {
            Rrotate.setOnMouseClicked(MouseEvent -> {
                if (RrotateCheck.isSelected()) {
                    RrotateCheck.setSelected(false);
                } else {
                    RrotateCheck.setSelected(true);
                }
            });
        });

        CheckBox LrotateCheck = new CheckBox();
        Image LrotateImg = new Image("sample/img/rotate-left.png");
        Button Lrotate = new Button("left rotate", new ImageView(LrotateImg));
        Lrotate.setPadding(new Insets(2, 2, 2, 2));
        Lrotate.setStyle("-fx-content-display: top;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-min-height: 60px;" +
                "-fx-min-width: 80px;" +
                "-fx-font-size: 10px;" +
                "-fx-background-color: linear-gradient(#ffffff, #d68fe6);" +
                "-fx-border-radius: 20px;" +
                "-fx-border-color: #cbbbcc; " +
                "-fx-background-radius: 20px;");

        Lrotate.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            Lrotate.setEffect(shadow);
        });
        Lrotate.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            Lrotate.setEffect(null);
        });
        Lrotate.setOnMouseClicked((mouseEvent) -> {
            Lrotate.setOnMouseClicked(MouseEvent -> {
                if (LrotateCheck.isSelected()) {
                    LrotateCheck.setSelected(false);
                } else {
                    LrotateCheck.setSelected(true);
                }
            });
        });

        CheckBox scaleCheck = new CheckBox();
        Image scaleImg = new Image("sample/img/Scale.PNG");
        Button scale = new Button("scale", new ImageView(scaleImg));
        //pencil.setText("pencil");
        scale.setPadding(new Insets(2, 2, 2, 2));
        scale.setStyle("-fx-content-display: top;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-min-height: 60px;" +
                "-fx-min-width: 80px;" +
                "-fx-font-size: 10px;" +
                "-fx-background-color: linear-gradient(#ffffff, #d68fe6);" +
                "-fx-border-radius: 20px;" +
                "-fx-border-color: #cbbbcc; " +
                "-fx-background-radius: 20px;");

        scale.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            scale.setEffect(shadow);
        });
        scale.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            scale.setEffect(null);
        });
        scale.setOnMouseClicked((mouseEvent) -> {
            scale.setOnMouseClicked(MouseEvent -> {
                if (scaleCheck.isSelected()) {
                    scaleCheck.setSelected(false);
                } else {
                    scaleCheck.setSelected(true);
                }
            });
        });

        CheckBox moveCheck = new CheckBox();
        Image moveImg = new Image("sample/img/move.png");
        Button move = new Button("move", new ImageView(moveImg));
        move.setPadding(new Insets(2, 2, 2, 2));
        move.setStyle("-fx-content-display: top;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-min-height: 60px;" +
                "-fx-min-width: 80px;" +
                "-fx-font-size: 10px;" +
                "-fx-background-color: linear-gradient(#ffffff, #d68fe6);" +
                "-fx-border-radius: 20px;" +
                "-fx-border-color: #cbbbcc; " +
                "-fx-background-radius: 20px;");

        move.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            move.setEffect(shadow);
        });
        move.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            move.setEffect(null);
        });
        move.setOnMouseClicked((mouseEvent) -> {
            if (moveCheck.isSelected()) {
                moveCheck.setSelected(false);
            } else {
                moveCheck.setSelected(true);
            }
        });

        CheckBox moveUCheck = new CheckBox();
        Image moveUImg = new Image("sample/img/moveU.png");
        Button moveUp = new Button("move vertically", new ImageView(moveUImg));
        moveUp.setPadding(new Insets(2, 2, 2, 2));
        moveUp.setStyle("-fx-content-display: top;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-min-height: 60px;" +
                "-fx-min-width: 80px;" +
                "-fx-font-size: 10px;" +
                "-fx-background-color: linear-gradient(#ffffff, #d68fe6);" +
                "-fx-border-radius: 20px;" +
                "-fx-border-color: #cbbbcc; " +
                "-fx-background-radius: 20px;");

        moveUp.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            moveUp.setEffect(shadow);
        });
        moveUp.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            moveUp.setEffect(null);
        });
        moveUp.setOnMouseClicked((mouseEvent) -> {
            if (moveUCheck.isSelected()) {
                moveUCheck.setSelected(false);
            } else {
                moveUCheck.setSelected(true);
            }
        });

        TextField animeDuration = new TextField();
        animeDuration.setPromptText("anime duration");
        animeDuration.setPadding(new Insets(2, 2, 2, 2));
        animeDuration.setAlignment(Pos.CENTER);
        animeDuration.setStyle("-fx-content-display: top;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-min-height: 40px;" +
                "-fx-max-width: 80px;" +
                "-fx-alignment: center;" +
                "-fx-font-size: 10px;" +
                "-fx-border-radius: 20px;" +
                "-fx-border-color: #cbbbcc;" +
                "-fx-background-radius: 20px;");

        CheckBox repeatable_anime = new CheckBox("repeatable anime");
        repeatable_anime.setPadding(new Insets(2, 2, 2, 2));
        repeatable_anime.setAlignment(Pos.CENTER);
        repeatable_anime.setStyle("-fx-content-display: top;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-min-height: 40px;" +
                "-fx-max-width: 80px;" +
                "-fx-alignment: center;" +
                "-fx-font-size: 10px;" +
                "-fx-border-radius: 20px;" +
                "-fx-border-color: #cbbbcc;" +
                "-fx-background-radius: 20px;");


        ToggleGroup colorGroup = new ToggleGroup();
        ToggleButton red = new ToggleButton();
        red.setUserData(Color.RED);
        red.setStyle("-fx-min-height: 30px;" +
                "-fx-min-width: 30px;" +
                "-fx-background-color: red;" +
                "-fx-background-radius: 20;");
        red.setToggleGroup(colorGroup);

        ToggleButton green = new ToggleButton();
        green.setUserData(Color.GREEN);
        green.setStyle("-fx-min-height: 30px;" +
                "-fx-min-width: 30px;" +
                "-fx-background-color: green;" +
                "-fx-background-radius: 20;");
        green.setToggleGroup(colorGroup);

        ToggleButton blue = new ToggleButton();
        blue.setUserData(Color.BLUE);
        blue.setStyle("-fx-min-height: 30px;" +
                "-fx-min-width: 30px;" +
                "-fx-background-color: blue;" +
                "-fx-background-radius: 20;");
        blue.setToggleGroup(colorGroup);

        ToggleButton aqua = new ToggleButton();
        aqua.setUserData(Color.AQUA);
        aqua.setStyle("-fx-min-height: 30px;" +
                "-fx-min-width: 30px;" +
                "-fx-background-color: aqua;" +
                "-fx-background-radius: 20;");
        aqua.setToggleGroup(colorGroup);

        ToggleButton brown = new ToggleButton();
        brown.setUserData(Color.BROWN);
        brown.setStyle("-fx-min-height: 30px;" +
                "-fx-min-width: 30px;" +
                "-fx-background-color: brown;" +
                "-fx-background-radius: 20;");
        brown.setToggleGroup(colorGroup);

        ToggleButton gold = new ToggleButton();
        gold.setUserData(Color.GOLD);
        gold.setStyle("-fx-min-height: 30px;" +
                "-fx-min-width: 30px;" +
                "-fx-background-color: gold;" +
                "-fx-background-radius: 20;");
        gold.setToggleGroup(colorGroup);

        ToggleButton black = new ToggleButton();
        black.setUserData(Color.BLACK);
        black.setStyle("-fx-min-height: 30px;" +
                "-fx-min-width: 30px;" +
                "-fx-background-color: black;" +
                "-fx-background-radius: 20;");
        black.setToggleGroup(colorGroup);

        ToggleButton orange = new ToggleButton();
        orange.setUserData(Color.ORANGE);
        orange.setStyle("-fx-min-height: 30px;" +
                "-fx-min-width: 30px;" +
                "-fx-background-color: orange;" +
                "-fx-background-radius: 20;");
        orange.setToggleGroup(colorGroup);

        Separator separator = new Separator();
        separator.setStyle("-fx-padding: 10px;" +
                "-fx-min-width: 80px");

        Button selectedColor = new Button();
        selectedColor.setStyle("-fx-background-color: blue;" +
                "-fx-min-width: 60px;" +
                "-fx-min-width: 60px;");


        colorGroup.selectedToggleProperty().addListener(o -> {
            if (colorGroup.getSelectedToggle() != null) {
                Color mainColor = (Color) colorGroup.getSelectedToggle().getUserData();
                BackgroundFill backgroundFill =
                        new BackgroundFill(mainColor,
                                CornerRadii.EMPTY,
                                Insets.EMPTY);
                Background background = new Background(backgroundFill);
                selectedColor.setBackground(background);
            }
        });


        HBox bottomHbox = new HBox();
        bottomHbox.setStyle("-fx-background-color: WHITE;" +
                "-fx-padding: 6;" +
                "-fx-border-insets: 5;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;" +
                "-fx-alignment: CENTER;");

        VBox lbVbox = new VBox();
        lbVbox.setStyle("-fx-background-color: WHITE;" +
                "-fx-padding: 6;" +
                "-fx-border-insets: 5;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        VBox rbVbox = new VBox();
        rbVbox.setStyle("-fx-background-color: WHITE;" +
                "-fx-padding: 6;" +
                "-fx-border-insets: 5;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        bottomHbox.getChildren().addAll(lbVbox, rbVbox);


        bottomHbox.setMinHeight(250);
        lbVbox.setMinSize(480, 200);
        rbVbox.setMinSize(480, 200);

        lbVbox.setAlignment(Pos.TOP_CENTER);
        rbVbox.setAlignment(Pos.TOP_CENTER);

        lbVbox.getChildren().add(propertyText);
        rbVbox.getChildren().add(AnimationText);

        anchorPane = new AnchorPane();

        anchorPane.setStyle("-fx-background-color: WHITE;" +
                "-fx-padding: 10;" +
                "-fx-border-insets: 5;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        borderPane.setCenter(anchorPane);
        borderPane.setBottom(bottomHbox);

        myRectangle.myVbox = lbVbox;

        rectangle.setOnMouseClicked((mouseEvent) ->
        {
            int x = 60 + (int) (Math.random() * 600);
            int y = 60 + (int) (Math.random() * 600);
            Color myColor;
            if (colorGroup.getSelectedToggle() == null) {
                myColor = Color.BLUE;
            } else {
                myColor = (Color) colorGroup.getSelectedToggle().getUserData();
            }
            myRectangle myRectangle = new myRectangle();
            myRectangle.setAnimeduration(Integer.valueOf(animeDuration.getText()));
            myRectangle.setIsMovable(moveCheck);
            myRectangle.setIsRepeatable(repeatable_anime);
            myRectangle.setIsRotatable(rotateCheck);
            myRectangle.setIsRightRotatable(RrotateCheck);
            myRectangle.setIsLeftRotatable(LrotateCheck);
            myRectangle.setIsVmovable(moveUCheck);
            myRectangle.setIsScalable(scaleCheck);
            Rectangle rectangle1 = myRectangle.createRectangle(x, y, 100, 150, myColor, lbVbox, rbVbox);
            anchorPane.getChildren().add(rectangle1);

        });

        circle.setOnMouseClicked((mouseEvent) -> {
            int x = 60 + (int) (Math.random() * 600);
            int y = 60 + (int) (Math.random() * 600);
            Color myColor;
            if (colorGroup.getSelectedToggle() == null) {
                myColor = Color.BLUE;
            } else {
                myColor = (Color) colorGroup.getSelectedToggle().getUserData();
            }

            myCircle myCircle = new myCircle();
            myCircle.setAnimeduration(Integer.valueOf(animeDuration.getText()));
            myCircle.setIsMovable(moveCheck);
            myCircle.setIsRepeatable(repeatable_anime);
            myCircle.setIsScalable(scaleCheck);
            myCircle.setIsVmovable(moveUCheck);
            Circle circle1 = myCircle.createCircle(x, y, 75, myColor, lbVbox, rbVbox);
            anchorPane.getChildren().add(circle1);


        });

        oval.setOnMouseClicked((mouseEvent) -> {
            int x = 60 + (int) (Math.random() * 600);
            int y = 60 + (int) (Math.random() * 600);
            Color myColor;
            if (colorGroup.getSelectedToggle() == null) {
                myColor = Color.BLUE;
            } else {
                myColor = (Color) colorGroup.getSelectedToggle().getUserData();
            }

            myOval myOval = new myOval();
            myOval.setAnimeduration(Integer.valueOf(animeDuration.getText()));
            myOval.setIsMovable(moveCheck);
            myOval.setIsRepeatable(repeatable_anime);
            myOval.setIsRotatable(rotateCheck);
            myOval.setIsRightRotatable(RrotateCheck);
            myOval.setIsLeftRotatable(LrotateCheck);
            myOval.setIsVmovable(moveUCheck);
            myOval.setIsScalable(scaleCheck);
            Ellipse ellipse = myOval.createOval(x, y, 75, 125, myColor, lbVbox, rbVbox);
            anchorPane.getChildren().add(ellipse);
        });

        line.setOnMouseClicked((mouseEvent) -> {
            int Sx = 60 + (int) (Math.random() * 800);
            int Sy = 60 + (int) (Math.random() * 800);
            int Ex = 60 + (int) (Math.random() * 800);
            int Ey = 60 + (int) (Math.random() * 800);
            Color myColor;
            if (colorGroup.getSelectedToggle() == null) {
                myColor = Color.BLUE;
            } else {
                myColor = (Color) colorGroup.getSelectedToggle().getUserData();
            }

            LIne myLine = new LIne();
            myLine.setAnimeduration(Integer.valueOf(animeDuration.getText()));
            myLine.setIsMovable(moveCheck);
            myLine.setIsRepeatable(repeatable_anime);
            myLine.setIsRotatable(rotateCheck);
            myLine.setIsRightRotatable(RrotateCheck);
            myLine.setIsLeftRotatable(LrotateCheck);
            myLine.setIsVmovable(moveUCheck);
            Line line1 = myLine.createLine(Sx, Sy, Ex, Ey, myColor, lbVbox, rbVbox);
            anchorPane.getChildren().add(line1);
        });

        final FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open an Image");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg")
        );

        Image FSimage = new Image("sample/img/fileChooser.png");
        ToggleButton FS = new ToggleButton("Open an image", new ImageView(FSimage));
        FS.setPadding(new Insets(2, 2, 2, 2));
        FS.setStyle("-fx-content-display: top;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-min-height: 60px;" +
                "-fx-min-width: 80px;" +
                "-fx-font-size: 10px;" +
                "-fx-background-color: linear-gradient(#ffffff, #d68fe6);" +
                "-fx-border-radius: 20px;" +
                "-fx-border-color: #cbbbcc; " +
                "-fx-background-radius: 20px;");
        FS.setToggleGroup(shapes);
        FS.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            FS.setEffect(shadow);
        });
        FS.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            FS.setEffect(null);
        });
        FS.setUserData(FS);
        FS.setOnMouseClicked((mouseEvent) ->
        {
            double ratio;
            int x = 60 + (int) (Math.random() * 600);
            int y = 60 + (int) (Math.random() * 600);
            File file = fileChooser.showOpenDialog(new Stage());
            if (file != null) {
                myImage myImage1 = new myImage();
                myImage1.setFile(file);
                if (imageRatio.getText() != null) {
                    ratio = Integer.valueOf(imageRatio.getText());
                } else {
                    ratio = 100;
                }

                myImage1.setAnimeduration(Integer.valueOf(animeDuration.getText()));
                myImage1.setIsMovable(moveCheck);
                myImage1.setIsRepeatable(repeatable_anime);
                myImage1.setIsRotatable(rotateCheck);
                myImage1.setIsRightRotatable(RrotateCheck);
                myImage1.setIsLeftRotatable(LrotateCheck);
                myImage1.setIsVmovable(moveUCheck);
                myImage1.setIsScalable(scaleCheck);
                ImageView myImageView = myImage1.createImage(x, y, ratio, lbVbox, rbVbox);
                anchorPane.getChildren().add(myImageView);
            }

        });

        Image play = new Image("sample/img/play.png");
        Image pause = new Image("sample/img/pause.png");
        ImageView playView = new ImageView(play);
        ImageView pauseView = new ImageView(pause);
        Button playbutton = new Button("play");
        playbutton.setGraphic(playView);
//        BackgroundImage backgroundImagePause = new BackgroundImage( pause, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
//        Background background1 = new Background(backgroundImagePause);
//        BackgroundImage backgroundImagePlay = new BackgroundImage( play, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
//        Background background2 = new Background(backgroundImagePlay);
        playbutton.setPadding(new Insets(10, 2, 2, 2));
        playbutton.setStyle("-fx-content-display: top;" +
                "-fx-font-family: 'Comic Sans MS';" +
                "-fx-min-height: 64px;" +
                "-fx-min-width: 64px;" +
                "-fx-font-size: 10px;" +
                "-fx-background-color: linear-gradient(#ffffff, #d68fe6);" +
                "-fx-border-radius: 32px;" +
                "-fx-border-color: #cbbbcc; " +
                "-fx-background-radius: 32px;");
        playbutton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            playbutton.setEffect(shadow);
        });
        playbutton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            playbutton.setEffect(null);
        });
        playbutton.setOnMouseClicked((mouseEvent) ->
        {
            isPlaying = !isPlaying;
            if (!isPlaying) {
                playbutton.setText("pause");
                playbutton.setGraphic(pauseView);
                mediaPlayer.play();
            } else {
                playbutton.setText("play");
                playbutton.setGraphic(playView);
                mediaPlayer.pause();
            }

        });

        propertyText.setFont(new Font("Comic Sans MS", 22));
        propertyText.setFill(Color.RED);
        AnimationText.setFont(new Font("Comic Sans MS", 22));
        AnimationText.setFill(Color.GREEN);

        shapesFlowPane.getChildren().add(pencil);
        shapesFlowPane.getChildren().add(line);
        shapesFlowPane.getChildren().add(oval);
        shapesFlowPane.getChildren().add(rectangle);
        shapesFlowPane.getChildren().add(circle);
        shapesFlowPane.getChildren().add(imageRatio);
        shapesFlowPane.getChildren().add(FS);

        colorFlowPane.getChildren().addAll(red, green, blue, aqua, black,
                orange, brown, gold, separator, selectedColor);

        shapesFlowPane.getChildren().add(playbutton);

        animationFlowPane.getChildren().addAll(rotate, rotateCheck, Lrotate, LrotateCheck, Rrotate, RrotateCheck, scale, scaleCheck, move, moveCheck, moveUp, moveUCheck);


        rightVBox.getChildren().add(shapesFlowPane);
        rightVBox.getChildren().add(colorFlowPane);
        leftVBox.getChildren().add(animationFlowPane);
        leftVBox.getChildren().add(animeDuration);
        leftVBox.getChildren().add(repeatable_anime);

        borderPane.setRight(rightVBox);
        borderPane.setLeft(leftVBox);

        Scene scene = new Scene(borderPane, 1000, 1000);
        scene.getStylesheets().add(Main.class.getResource("styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Paint");
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
