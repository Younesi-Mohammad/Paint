package sample;

import javafx.animation.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.Cursor;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class myCircle extends Circle {

    private double animeduration;
    double scaleSize;
    double moveSize;
    double VmoveSize;
    private CheckBox isRepeatable;
    private CheckBox isScalable;
    private CheckBox isMovable;
    private CheckBox isVmovable;


    public void setAnimeduration(double animeduration) {
        this.animeduration = animeduration;
    }

    public void setIsRepeatable(CheckBox isRepeatable) {
        this.isRepeatable = isRepeatable;
    }

    public void setIsScalable(CheckBox isScalable) {
        this.isScalable = isScalable;
    }

    public void setIsMovable(CheckBox isMovable) {
        this.isMovable = isMovable;
    }

    public void setIsVmovable(CheckBox isVmovable) {
        this.isVmovable = isVmovable;
    }

    double orgSceneX, orgSceneY;


    public Circle createCircle(double x, double y, double r, Color color, VBox vBoxShape, VBox anime) {
        Circle circle = new Circle(x, y, r, color);

        circle.setCursor(Cursor.HAND);

        circle.setOnMousePressed((t) -> {
            orgSceneX = t.getSceneX();
            orgSceneY = t.getSceneY();

            writeProperty(vBoxShape, circle, anime);

            Circle c = (Circle) (t.getSource());
            c.toFront();
        });
        circle.setOnMouseDragged((t) -> {
            double offsetX = t.getSceneX() - orgSceneX;
            double offsetY = t.getSceneY() - orgSceneY;

            Circle c = (Circle) (t.getSource());

            c.setCenterX(c.getCenterX() + offsetX);
            c.setCenterY(c.getCenterY() + offsetY);

            orgSceneX = t.getSceneX();
            orgSceneY = t.getSceneY();

            writeProperty(vBoxShape, circle, anime);
        });

//        Path star = new Path();
//        star.getElements().addAll(new MoveTo(300,50),
//                new LineTo(50,300),
//                new LineTo(600,300),
//                new ClosePath(),
//                new MoveTo(50,100),
//                new LineTo(600,100),
//                new LineTo(300,400),
//                new ClosePath());
//
//        Circle pathCircle = new Circle(300,300,200);


        if (isScalable.isSelected()) {
            scaleSize = 1.75;
            ScaleTransition scaleTransition = new ScaleTransition(new Duration(animeduration * 1000), circle);
            scaleTransition.setByX(scaleSize);
            scaleTransition.setByY(scaleSize);
            scaleTransition.play();

            if (isRepeatable.isSelected()) {
                scaleTransition.setOnFinished(event -> {
                    scaleTransition.setByX(-scaleSize);
                    scaleTransition.setByY(-scaleSize);
                    scaleTransition.play();
                    scaleSize = -scaleSize;
                });
            }
        }

        if (isMovable.isSelected()) {
            moveSize = 125;
            TranslateTransition horizontalTransition = new TranslateTransition(new Duration(animeduration * 1000), circle);
            horizontalTransition.setByX(circle.getCenterX() - 100);
            horizontalTransition.setToX(circle.getCenterX() + moveSize - 100);
            horizontalTransition.setInterpolator(Interpolator.LINEAR);
            horizontalTransition.play();

            if (isRepeatable.isSelected()) {
                horizontalTransition.setOnFinished(event -> {
                    horizontalTransition.setByX(circle.getCenterX());
                    horizontalTransition.setToX(circle.getCenterX() - moveSize);
                    horizontalTransition.play();
                    moveSize = -moveSize;
                });
            }
        }

        if (isVmovable.isSelected()) {
            VmoveSize = 95;
            TranslateTransition verticalTransition = new TranslateTransition(new Duration(animeduration * 1000), circle);
            verticalTransition.setByY(circle.getCenterY() - 120);
            verticalTransition.setToY(circle.getCenterY() + VmoveSize - 120);
            verticalTransition.setInterpolator(Interpolator.LINEAR);
            verticalTransition.play();

            if (isRepeatable.isSelected()) {
                verticalTransition.setOnFinished(event -> {
                    verticalTransition.setByY(circle.getCenterY());
                    verticalTransition.setToY(circle.getCenterY() - VmoveSize);
                    verticalTransition.play();
                    VmoveSize = -VmoveSize;
                });
            }
        }

        return circle;
    }

    Canvas canvas = new Canvas();

    public Canvas getCanvas() {
        return canvas;
    }

    public void writeProperty(VBox vBox, Circle circle, VBox vBox1) {

        Text radius = new Text();
        Text X = new Text();
        Text Y = new Text();

        Text scale = new Text();
        Text moveUp = new Text();
        Text moveFw = new Text();
        Text animeDure = new Text();
        Text repeat = new Text();

        radius.setFont(new Font("Comic Sans MS", 18));
        radius.setFill(Color.PURPLE);
        X.setFont(new Font("Comic Sans MS", 18));
        X.setFill(Color.PURPLE);
        Y.setFont(new Font("Comic Sans MS", 18));
        Y.setFill(Color.PURPLE);

        scale.setFont(new Font("Comic Sans MS", 18));
        scale.setFill(Color.ORANGE);
        moveFw.setFont(new Font("Comic Sans MS", 18));
        moveFw.setFill(Color.ORANGE);
        moveUp.setFont(new Font("Comic Sans MS", 18));
        moveUp.setFill(Color.ORANGE);
        animeDure.setFont(new Font("Comic Sans MS", 18));
        animeDure.setFill(Color.ORANGE);
        repeat.setFont(new Font("Comic Sans MS", 18));
        repeat.setFill(Color.ORANGE);

        if (vBox.getChildren().size() > 1) {
            vBox.getChildren().remove(1, vBox.getChildren().size());
        }

        if (vBox1.getChildren().size() > 1) {
            vBox1.getChildren().remove(1, vBox1.getChildren().size());
        }

        radius.setText("Radius : " + circle.getRadius());
        X.setText("X coordinate : " + circle.getCenterX());
        Y.setText("Y coordinate : " + circle.getCenterY());
        vBox.getChildren().addAll(radius, X, Y);

        scale.setText("Scale : " + scaleSize);
        moveFw.setText("Horizontally move : " + isMovable.isSelected());
        moveUp.setText("Vertically move : " + isVmovable.isSelected());
        animeDure.setText("Animation duration : " + animeduration + "(s)");
        repeat.setText("Is animation repeatable : " + isRepeatable.isSelected());
        vBox1.getChildren().addAll(scale, moveFw, moveUp, animeDure, repeat);

    }
}
