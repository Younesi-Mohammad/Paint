package sample;

import javafx.animation.*;
import javafx.scene.Cursor;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class myRectangle {

    private int height;
    private int width;
    private int minX;
    private int minY;
    double orgSceneX, orgSceneY;
    public static VBox myVbox;
    private Text X;
    private Text Y;
    private Text Height;
    private Text Width;

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


    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getMinX() {
        return minX;
    }

    public void setMinX(int minX) {
        this.minX = minX;
    }

    public int getMinY() {
        return minY;
    }

    public void setMinY(int minY) {
        this.minY = minY;
    }

    public Rectangle createRectangle(double x, double y, double width, double height, Color color, VBox vBox, VBox anime) {

        Rectangle rectangle = new Rectangle(x, y, width, height);
        rectangle.setFill(color);

        rectangle.setCursor(Cursor.HAND);

        rectangle.setOnMousePressed((t) -> {
            orgSceneX = t.getSceneX();
            orgSceneY = t.getSceneY();

            writeProperty(vBox, rectangle, anime);

            Rectangle r = (Rectangle) (t.getSource());
            r.toFront();
        });
        rectangle.setOnMouseDragged((t) -> {
            double offsetX = t.getSceneX() - orgSceneX;
            double offsetY = t.getSceneY() - orgSceneY;

            Rectangle r = (Rectangle) (t.getSource());

            r.setX(r.getX() + offsetX);
            r.setY(r.getY() + offsetY);

            orgSceneX = t.getSceneX();
            orgSceneY = t.getSceneY();


            writeProperty(vBox, rectangle, anime);


        });

        if (isMovable.isSelected()) {
            moveSize = 130;
            TranslateTransition horizontalTransition = new TranslateTransition(new Duration(animeduration * 1000), rectangle);
            horizontalTransition.setByX(rectangle.getX() - 105);
            horizontalTransition.setToX(rectangle.getX() + moveSize - 105);
            horizontalTransition.setInterpolator(Interpolator.LINEAR);
            horizontalTransition.play();

            if (isRepeatable.isSelected()) {
                horizontalTransition.setOnFinished(event -> {
                    horizontalTransition.setByX(rectangle.getX());
                    horizontalTransition.setToX(rectangle.getX() - moveSize);
                    horizontalTransition.play();
                    moveSize = -moveSize;
                });
            }
        }

        if (isRotatable.isSelected()) {
            RotateTransition rotateTransition = new RotateTransition(new Duration(animeduration * 1000), rectangle);
            rotateTransition.setFromAngle(0.0);
            rotateTransition.setToAngle(360.0);
            System.out.println(isRepeatable.isSelected());
            rotateTransition.setCycleCount(Animation.INDEFINITE);
            rotateTransition.setAutoReverse(isRepeatable.isSelected());
            rotateTransition.play();
        }

        if (isRightRotatable.isSelected()) {
            RotateTransition clkRotate = new RotateTransition(new Duration(animeduration * 1000), rectangle);
            clkRotate.setFromAngle(0.0);
            clkRotate.setToAngle(180.0);
            clkRotate.setCycleCount(Animation.INDEFINITE);
            clkRotate.play();
            clkRotate.setAutoReverse(isRepeatable.isSelected());
        }

        if (isLeftRotatable.isSelected() && !isRightRotatable.isSelected()) {
            RotateTransition cntrclkRotate = new RotateTransition(new Duration(animeduration * 1000), rectangle);
            cntrclkRotate.setFromAngle(0.0);
            cntrclkRotate.setToAngle(180.0);
            cntrclkRotate.play();
            cntrclkRotate.setCycleCount(Animation.INDEFINITE);
            cntrclkRotate.setAutoReverse(isRepeatable.isSelected());
        }

        if (isVmovable.isSelected()) {
            VmoveSize = 108;
            TranslateTransition verticalTransition = new TranslateTransition(new Duration(animeduration * 1000), rectangle);
            verticalTransition.setByY(rectangle.getY() - 115);
            verticalTransition.setToY(rectangle.getY() + VmoveSize - 115);
            verticalTransition.setInterpolator(Interpolator.LINEAR);
            verticalTransition.setCycleCount(Animation.INDEFINITE);
            verticalTransition.setAutoReverse(isRepeatable.isSelected());
            verticalTransition.play();

//            if(isRepeatable.isSelected()){
//                verticalTransition.setOnFinished(event -> {
//                    verticalTransition.setByY(rectangle.getY());
//                    verticalTransition.setToY(rectangle.getY()-VmoveSize);
//                    verticalTransition.play();
//                    VmoveSize = -VmoveSize;
//                });
//            }

            if (isScalable.isSelected()) {
                scaleSize = 1.4;
                ScaleTransition scaleTransition = new ScaleTransition(new Duration(animeduration * 1000), rectangle);
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

        return rectangle;
    }

    public void writeProperty(VBox vBox, Rectangle rectangle, VBox vBox1) {

        Text Height = new Text();
        Text Width = new Text();
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

        Height.setFont(new Font("Comic Sans MS", 18));
        Height.setFill(Color.PURPLE);
        Width.setFont(new Font("Comic Sans MS", 18));
        Width.setFill(Color.PURPLE);
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

        Width.setText("Width : " + rectangle.getWidth());
        Height.setText("Height : " + rectangle.getHeight());
        X.setText("X coordinate : " + rectangle.getX());
        Y.setText("Y coordinate : " + rectangle.getY());
        vBox.getChildren().addAll(Width, Height, X, Y);

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

