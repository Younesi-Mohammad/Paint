package sample;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Cursor;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class LIne {

    double orgSceneX, orgSceneY;

    private double animeduration;
    double moveSize;
    double VmoveSize;
    private CheckBox isRepeatable;
    private CheckBox isMovable;
    private CheckBox isVmovable;
    private CheckBox isRotatable;
    private CheckBox isRightRotatable;
    private CheckBox isLeftRotatable;

    public void setAnimeduration(double animeduration) {
        this.animeduration = animeduration;
    }

    public void setMoveSize(double moveSize) {
        this.moveSize = moveSize;
    }

    public void setVmoveSize(double vmoveSize) {
        VmoveSize = vmoveSize;
    }

    public void setIsRepeatable(CheckBox isRepeatable) {
        this.isRepeatable = isRepeatable;
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

    public Line createLine(double startX, double startY, double endX, double endY, Color color, VBox vBox, VBox anime) {

        Line line = new Line();
        line.setStrokeWidth(6);
        line.setStartX(startX);
        line.setStartY(startY);
        line.setEndX(endX);
        line.setEndY(endY);
        line.setStroke(color);

        line.setCursor(Cursor.HAND);

        line.setOnMousePressed((t) -> {
            orgSceneX = t.getSceneX();
            orgSceneY = t.getSceneY();

            writeProperty(vBox, line, anime);

            Line l = (Line) (t.getSource());
            l.toFront();
        });
        line.setOnMouseDragged((t) -> {
            double offsetX = t.getSceneX() - orgSceneX;
            double offsetY = t.getSceneY() - orgSceneY;

            Line l = (Line) (t.getSource());

            l.setStartX(l.getStartX() + offsetX);
            l.setEndX(l.getEndX() + offsetX);
            l.setStartY(l.getStartY() + offsetY);
            l.setEndY(l.getEndY() + offsetY);

            orgSceneX = t.getSceneX();
            orgSceneY = t.getSceneY();

            writeProperty(vBox, line, anime);
        });

        if (isMovable.isSelected()) {
            moveSize = 100;
            TranslateTransition horizontalTransition = new TranslateTransition(new Duration(animeduration * 1000), line);
            horizontalTransition.setByX(line.getStartX() - 100);
            horizontalTransition.setToX(line.getStartX() + moveSize - 100);
            horizontalTransition.setInterpolator(Interpolator.LINEAR);
            horizontalTransition.play();

            if (isRepeatable.isSelected()) {
                horizontalTransition.setOnFinished(event -> {
                    horizontalTransition.setByX(line.getStartX());
                    horizontalTransition.setToX(line.getStartX() - moveSize);
                    horizontalTransition.play();
                    moveSize = -moveSize;
                });
            }
        }

        if (isRotatable.isSelected()) {
            RotateTransition rotateTransition = new RotateTransition(new Duration(animeduration * 1000), line);
            rotateTransition.setFromAngle(0.0);
            rotateTransition.setToAngle(360.0);
            rotateTransition.setCycleCount(Animation.INDEFINITE);
            rotateTransition.setAutoReverse(isRepeatable.isSelected());
            rotateTransition.play();
        }

        if (isRightRotatable.isSelected()) {
            RotateTransition clkRotate = new RotateTransition(new Duration(animeduration * 1000), line);
            clkRotate.setFromAngle(0.0);
            clkRotate.setToAngle(-180.0);
            clkRotate.setCycleCount(Animation.INDEFINITE);
            clkRotate.setAutoReverse(isRepeatable.isSelected());
            clkRotate.play();
        }

        if (isLeftRotatable.isSelected() && !isRightRotatable.isSelected()) {
            RotateTransition cntrclkRotate = new RotateTransition(new Duration(animeduration * 1000), line);
            cntrclkRotate.setFromAngle(0.0);
            cntrclkRotate.setToAngle(180.0);
            cntrclkRotate.setCycleCount(Animation.INDEFINITE);
            cntrclkRotate.setAutoReverse(isRepeatable.isSelected());
            cntrclkRotate.play();
        }

        if (isVmovable.isSelected()) {
            VmoveSize = 130;
            TranslateTransition verticalTransition = new TranslateTransition(new Duration(animeduration * 1000), line);
            verticalTransition.setByY(line.getStartY() - 120);
            verticalTransition.setToY(line.getStartY() + VmoveSize - 120);
            verticalTransition.setInterpolator(Interpolator.LINEAR);
            verticalTransition.play();

            if (isRepeatable.isSelected()) {
                verticalTransition.setOnFinished(event -> {
                    verticalTransition.setByY(line.getStartY());
                    verticalTransition.setToY(line.getStartY() - VmoveSize);
                    verticalTransition.play();
                    VmoveSize = -VmoveSize;
                });
            }
        }


        return line;
    }

    public void writeProperty(VBox vBox, Line line, VBox vBox1) {

        Text startX = new Text();
        Text startY = new Text();
        Text endX = new Text();
        Text endY = new Text();

        Text rotate = new Text();
        Text Rrotate = new Text();
        Text Lrotate = new Text();
        Text Vmove = new Text();
        Text Hmove = new Text();
        Text animeDure = new Text();
        Text repeat = new Text();


        startX.setFont(new Font("Comic Sans MS", 18));
        startX.setFill(Color.PURPLE);
        startY.setFont(new Font("Comic Sans MS", 18));
        startY.setFill(Color.PURPLE);
        endX.setFont(new Font("Comic Sans MS", 18));
        endX.setFill(Color.PURPLE);
        endY.setFont(new Font("Comic Sans MS", 18));
        endY.setFill(Color.PURPLE);

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

        if (vBox.getChildren().size() > 1) {
            vBox.getChildren().remove(1, vBox.getChildren().size());
        }

        if (vBox1.getChildren().size() > 1) {
            vBox1.getChildren().remove(1, vBox1.getChildren().size());
        }

        startX.setText("Start X coordinate : " + line.getStartX());
        startY.setText("Start Y coordinate : " + line.getStartY());
        endX.setText("End X coordinate : " + line.getEndX());
        endY.setText("End Y coordinate : " + line.getEndY());
        vBox.getChildren().addAll(startX, startY, endX, endY);

        rotate.setText("Rotate animation : " + isRotatable.isSelected());
        Rrotate.setText("Clockwise rotate : " + isRightRotatable.isSelected());
        Lrotate.setText("Counter clockwise animation : " + isLeftRotatable.isSelected());
        Vmove.setText("Is vertically movable : " + isVmovable.isSelected());
        Hmove.setText("Is horizontally movable : " + isMovable.isSelected());
        repeat.setText("Is animation repeatable : " + isRepeatable.isSelected());
        animeDure.setText("Animation duration : " + animeduration);
        vBox1.getChildren().addAll(rotate, Rrotate, Lrotate, Vmove, Hmove, repeat, animeDure);
    }
}
