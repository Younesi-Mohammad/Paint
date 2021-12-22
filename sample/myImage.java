package sample;

import javafx.animation.*;
import javafx.scene.Cursor;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.File;

public class myImage {

    private Image image;
    private File file;
    private int height;
    private int width;
    private int minX;
    private int minY;
    double orgSceneX, orgSceneY;
    public static VBox myVbox;

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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
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

    public ImageView createImage(double x, double y, double imageRatio, VBox vBox, VBox anime) {

        boolean chooser = false;
        image = new Image(file.toURI().toString());
        ImageView imageView = new ImageView(image);
        double big = image.getHeight();
        double small = image.getWidth();
        if (big < small) {
            big = image.getWidth();
            small = image.getHeight();
            chooser = true;
        }

        double width = image.getWidth() * (imageRatio / 100);
        double height = image.getHeight() * (imageRatio / 100);

        if ((width > 600) || (height > 600)) {
            if (chooser) {
                width = 600;
                height = small * (600 / big);
            } else {
                height = 600;
                width = small * (600 / big);
            }
        }
        imageView.setX(x);
        imageView.setY(y);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);

        imageView.setCursor(Cursor.HAND);

        imageView.setOnMousePressed((t) -> {
            orgSceneX = t.getSceneX();
            orgSceneY = t.getSceneY();

            writeProperty(vBox, imageView, anime);

            ImageView i = (ImageView) (t.getSource());
            i.toFront();
        });
        imageView.setOnMouseDragged((t) -> {
            double offsetX = t.getSceneX() - orgSceneX;
            double offsetY = t.getSceneY() - orgSceneY;

            ImageView i = (ImageView) (t.getSource());

            i.setX(i.getX() + offsetX);
            i.setY(i.getY() + offsetY);

            orgSceneX = t.getSceneX();
            orgSceneY = t.getSceneY();


            writeProperty(vBox, imageView, anime);


        });

        if (isMovable.isSelected()) {
            moveSize = 105;
            TranslateTransition horizontalTransition = new TranslateTransition(new Duration(animeduration * 1000), imageView);
            horizontalTransition.setByX(imageView.getX() - 100);
            horizontalTransition.setToX(imageView.getX() + moveSize - 100);
            horizontalTransition.setInterpolator(Interpolator.LINEAR);
            horizontalTransition.play();

            if (isRepeatable.isSelected()) {
                horizontalTransition.setOnFinished(event -> {
                    horizontalTransition.setByX(imageView.getX());
                    horizontalTransition.setToX(imageView.getX() - moveSize);
                    horizontalTransition.play();
                    moveSize = -moveSize;
                });
            }
        }

        if (isRotatable.isSelected()) {
            RotateTransition rotateTransition = new RotateTransition(new Duration(animeduration * 1000), imageView);
            rotateTransition.setFromAngle(0.0);
            rotateTransition.setToAngle(360.0);
            rotateTransition.setCycleCount(Animation.INDEFINITE);
            rotateTransition.setAutoReverse(isRepeatable.isSelected());
            rotateTransition.play();
        }

        if (isRightRotatable.isSelected()) {
            RotateTransition clkRotate = new RotateTransition(new Duration(animeduration * 1000), imageView);
            clkRotate.setFromAngle(0.0);
            clkRotate.setToAngle(-180.0);
            clkRotate.setCycleCount(Animation.INDEFINITE);
            clkRotate.setAutoReverse(isRepeatable.isSelected());
            clkRotate.play();
        }

        if (isLeftRotatable.isSelected() && !isRightRotatable.isSelected()) {
            RotateTransition cntrclkRotate = new RotateTransition(new Duration(animeduration * 1000), imageView);
            cntrclkRotate.setFromAngle(0.0);
            cntrclkRotate.setToAngle(180.0);
            cntrclkRotate.setCycleCount(Animation.INDEFINITE);
            cntrclkRotate.setAutoReverse(isRepeatable.isSelected());
            cntrclkRotate.play();
        }

        if (isVmovable.isSelected()) {
            VmoveSize = 160;
            TranslateTransition verticalTransition = new TranslateTransition(new Duration(animeduration * 1000), imageView);
            verticalTransition.setByY(imageView.getY() - 110);
            verticalTransition.setToY(imageView.getY() + VmoveSize - 110);
            verticalTransition.setInterpolator(Interpolator.LINEAR);
            verticalTransition.play();

            if (isRepeatable.isSelected()) {
                verticalTransition.setOnFinished(event -> {
                    verticalTransition.setByY(imageView.getY());
                    verticalTransition.setToY(imageView.getY() - VmoveSize);
                    verticalTransition.play();
                    VmoveSize = -VmoveSize;
                });
            }

            if (isScalable.isSelected()) {
                scaleSize = 1.5;
                ScaleTransition scaleTransition = new ScaleTransition(new Duration(animeduration * 1000), imageView);
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

        return imageView;
    }

    public void writeProperty(VBox vBox, ImageView imageView, VBox vBox1) {

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

        Width.setText("Width : " + imageView.getFitWidth());
        Height.setText("Height : " + imageView.getFitHeight());
        X.setText("X coordinate : " + imageView.getX());
        Y.setText("Y coordinate : " + imageView.getY());
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
