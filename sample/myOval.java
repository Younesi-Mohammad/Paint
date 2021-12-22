package sample;

import javafx.animation.*;
import javafx.scene.Cursor;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class myOval {

    private double animeduration;
    double scaleSize;
    double moveSize;
    double VmoveSize;
    private CheckBox isRepeatable;
    private CheckBox isScalable;
    private CheckBox isMovable;
    private CheckBox isVmovable;
    private CheckBox isRotatable;
    private CheckBox isRightRotatable;
    private CheckBox isLeftRotatable;

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

    public void setIsRotatable(CheckBox isRotatable) {
        this.isRotatable = isRotatable;
    }

    public void setIsRightRotatable(CheckBox isRightRotatable) {
        this.isRightRotatable = isRightRotatable;
    }

    public void setIsLeftRotatable(CheckBox isLeftRotatable) {
        this.isLeftRotatable = isLeftRotatable;
    }

    double orgSceneX, orgSceneY;

    public Ellipse createOval(double x, double y, double XRad, double YRad, Color color, VBox vBox, VBox anime) {

        Ellipse ellipse = new Ellipse(x, y, XRad, YRad);
        ellipse.setFill(color);

        ellipse.setCursor(Cursor.HAND);

        ellipse.setOnMousePressed((t) -> {
            orgSceneX = t.getSceneX();
            orgSceneY = t.getSceneY();

            writeProperty(vBox, ellipse, anime);

            Ellipse e = (Ellipse) (t.getSource());
            e.toFront();
        });

        ellipse.setOnMouseDragged((t) -> {
            double offsetX = t.getSceneX() - orgSceneX;
            double offsetY = t.getSceneY() - orgSceneY;

            Ellipse e = (Ellipse) (t.getSource());

            e.setCenterX(e.getCenterX() + offsetX);
            e.setCenterY(e.getCenterY() + offsetY);

            orgSceneX = t.getSceneX();
            orgSceneY = t.getSceneY();

            writeProperty(vBox, ellipse, anime);
        });

        if (isMovable.isSelected()) {
            moveSize = 100;
            TranslateTransition horizontalTransition = new TranslateTransition(new Duration(animeduration * 1000), ellipse);
            horizontalTransition.setByX(ellipse.getCenterX() - 110);
            horizontalTransition.setToX(ellipse.getCenterX() + moveSize - 110);
            horizontalTransition.setInterpolator(Interpolator.LINEAR);
            horizontalTransition.play();

            if (isRepeatable.isSelected()) {
                horizontalTransition.setOnFinished(event -> {
                    horizontalTransition.setByX(ellipse.getCenterX());
                    horizontalTransition.setToX(ellipse.getCenterX() - moveSize);
                    horizontalTransition.play();
                    moveSize = -moveSize;
                });
            }
        }

        if (isRotatable.isSelected()) {
            RotateTransition rotateTransition = new RotateTransition(new Duration(animeduration * 1000), ellipse);
            rotateTransition.setFromAngle(0.0);
            rotateTransition.setToAngle(360.0);
            rotateTransition.setCycleCount(Animation.INDEFINITE);
            rotateTransition.setAutoReverse(isRepeatable.isSelected());
            rotateTransition.play();

        }

        if (isRightRotatable.isSelected()) {
            RotateTransition clkRotate = new RotateTransition(new Duration(animeduration * 1000), ellipse);
            clkRotate.setFromAngle(0.0);
            clkRotate.setToAngle(-180.0);
            clkRotate.setCycleCount(Animation.INDEFINITE);
            clkRotate.setAutoReverse(isRepeatable.isSelected());
            clkRotate.play();

        }

        if (isLeftRotatable.isSelected() && !isRightRotatable.isSelected()) {
            RotateTransition cntrclkRotate = new RotateTransition(new Duration(animeduration * 1000), ellipse);
            cntrclkRotate.setFromAngle(0.0);
            cntrclkRotate.setToAngle(180.0);
            cntrclkRotate.setCycleCount(Animation.INDEFINITE);
            cntrclkRotate.setAutoReverse(isRepeatable.isSelected());
            cntrclkRotate.play();
        }

        if (isVmovable.isSelected()) {
            VmoveSize = 85;
            TranslateTransition verticalTransition = new TranslateTransition(new Duration(animeduration * 1000), ellipse);
            verticalTransition.setByY(ellipse.getCenterY() - 120);
            verticalTransition.setToY(ellipse.getCenterY() + VmoveSize - 120);
            verticalTransition.setInterpolator(Interpolator.LINEAR);
            verticalTransition.play();

            if (isRepeatable.isSelected()) {
                verticalTransition.setOnFinished(event -> {
                    verticalTransition.setByY(ellipse.getCenterY());
                    verticalTransition.setToY(ellipse.getCenterY() - VmoveSize);
                    verticalTransition.play();
                    VmoveSize = -VmoveSize;
                });
            }

            if (isScalable.isSelected()) {
                scaleSize = 1.6;
                ScaleTransition scaleTransition = new ScaleTransition(new Duration(animeduration * 1000), ellipse);
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
        }

        return ellipse;
    }

    public void writeProperty(VBox vBox, Ellipse ellipse, VBox vBox1) {

        Text horizontalradius = new Text();
        Text verticalradius = new Text();
        Text X = new Text();
        Text Y = new Text();

        Text rotate = new Text();
        Text Rrotate = new Text();
        Text Lrotate = new Text();
        Text Vmove = new Text();
        Text Hmove = new Text();
        Text animeDure = new Text();
        Text repeat = new Text();
        Text scale = new Text();

        horizontalradius.setFont(new Font("Comic Sans MS", 18));
        horizontalradius.setFill(Color.PURPLE);
        verticalradius.setFont(new Font("Comic Sans MS", 18));
        verticalradius.setFill(Color.PURPLE);
        X.setFont(new Font("Comic Sans MS", 18));
        X.setFill(Color.PURPLE);
        Y.setFont(new Font("Comic Sans MS", 18));
        Y.setFill(Color.PURPLE);

        rotate.setFont(new Font("Comic Sans MS", 18));
        rotate.setFill(Color.ORANGE);
        Rrotate.setFont(new Font("Comic Sans MS", 18));
        Rrotate.setFill(Color.ORANGE);
        Lrotate.setFont(new Font("Comic Sans MS", 18));
        Lrotate.setFill(Color.ORANGE);
        Vmove.setFont(new Font("Comic Sans MS", 18));
        Vmove.setFill(Color.ORANGE);
        Hmove.setFont(new Font("Comic Sans MS", 18));
        Hmove.setFill(Color.ORANGE);
        animeDure.setFont(new Font("Comic Sans MS", 18));
        animeDure.setFill(Color.ORANGE);
        repeat.setFont(new Font("Comic Sans MS", 18));
        repeat.setFill(Color.ORANGE);
        scale.setFont(new Font("Comic Sans MS", 18));
        scale.setFill(Color.ORANGE);

        if (vBox.getChildren().size() > 1) {
            vBox.getChildren().remove(1, vBox.getChildren().size());
        }
        if (vBox1.getChildren().size() > 1) {
            vBox1.getChildren().remove(1, vBox1.getChildren().size());
        }

        horizontalradius.setText("Horizontal radius : " + ellipse.getRadiusX());
        verticalradius.setText("Vertical radius : " + ellipse.getRadiusY());
        X.setText("X coordinate : " + ellipse.getCenterX());
        Y.setText("Y coordinate : " + ellipse.getCenterY());
        vBox.getChildren().addAll(horizontalradius, verticalradius, X, Y);

        rotate.setText("Rotate animation : " + isRotatable.isSelected());
        Rrotate.setText("Clockwise rotate : " + isRightRotatable.isSelected());
        Lrotate.setText("Counter clockwise animation : " + isLeftRotatable.isSelected());
        Vmove.setText("Is vertically movable : " + isVmovable.isSelected());
        Hmove.setText("Is horizontally movable : " + isMovable.isSelected());
        repeat.setText("Is animation repeatable : " + isRepeatable.isSelected());
        animeDure.setText("Animation duration : " + animeduration);
        scale.setText("Scale : " + scaleSize);
        vBox1.getChildren().addAll(rotate, Rrotate, Lrotate, scale, Vmove, Hmove, repeat, animeDure);

    }
}
