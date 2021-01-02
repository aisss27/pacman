import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class MyPlayer implements Player {

    private Circle ball;
    private Map map;
    private Position position;

    final Timeline timeline = new Timeline();

    public MyPlayer(Map map) {
        this.map = map;
        position = map.getStart();
        ball = new Circle(position.getX() * map.getUnit() + 0.5 * map.getUnit(), position.getY()
                * map.getUnit() + 0.5 * map.getUnit(), map.getUnit()/2 - map.getUnit()/10);
        ball.setFill(Color.RED);
        map.getChildren().add(ball);

    }

    @Override
    public void moveRight() {
        if(position.getX() + 1 > map.getSize() - 1){
            System.out.println("Invalid position!");
        }
        else{
            if(map.getValueAt( position.getY(),position.getX() + 1) == 1){
                System.out.println("Invalid position!");
            }
            else{
                position.setX(position.getX() + 1);
                //ball.setCenterX(ball.getCenterX() + map.getUnit());
                final KeyValue kv = new KeyValue(ball.centerXProperty(), ball.getCenterX() + map.getUnit());
                final KeyFrame kf = new KeyFrame(Duration.millis(100), kv);
                timeline.getKeyFrames().clear();
                timeline.getKeyFrames().add(kf);
                timeline.play();
            }
        }

    }


    @Override
    public void moveDown() {
        if(position.getY() + 1 > map.getSize() - 1){
            System.out.println("Invalid position!");
        }
        else{
            if(map.getValueAt(position.getY() + 1, position.getX()) == 1){
                System.out.println("Invalid position!");
            }
            else{
                position.setY(position.getY() + 1);
                //ball.setCenterY(ball.getCenterY() + map.getUnit());
                final KeyValue kv = new KeyValue(ball.centerYProperty(), ball.getCenterY() + map.getUnit());
                final KeyFrame kf = new KeyFrame(Duration.millis(100), kv);
                timeline.getKeyFrames().clear();
                timeline.getKeyFrames().add(kf);
                timeline.play();
            }
        }
    }
    @Override
    public void moveUp() {
        if(position.getY() - 1 < 0){
            System.out.println("Invalid position!");
        }
        else{
            if(map.getValueAt( position.getY() - 1,position.getX()) == 1){
                System.out.println("Invalid position!");
            }
            else{
                position.setY(position.getY() - 1);
                //ball.setCenterY(ball.getCenterY() - map.getUnit());
                final KeyValue kv = new KeyValue(ball.centerYProperty(), ball.getCenterY() - map.getUnit());
                final KeyFrame kf = new KeyFrame(Duration.millis(100), kv);
                timeline.getKeyFrames().clear();
                timeline.getKeyFrames().add(kf);
                timeline.play();
            }
        }
    }


    @Override
    public void moveLeft() {
        if(position.getX() - 1  < 0){
            System.out.println("Invalid position!");
        }
        else{
            if(map.getValueAt(position.getY(), position.getX() - 1) == 1){

            }
            else{
                position.setX(position.getX() - 1);
                //ball.setCenterX(ball.getCenterX() - map.getUnit());
                final KeyValue kv = new KeyValue(ball.centerXProperty(), ball.getCenterX() - map.getUnit());
                final KeyFrame kf = new KeyFrame(Duration.millis(100), kv);
                timeline.getKeyFrames().clear();
                timeline.getKeyFrames().add(kf);
                timeline.play();
            }
        }
    }




    @Override
    public Position getPosition() {
        return position;
    }
}