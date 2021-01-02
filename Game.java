import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import java.util.*;

public class Game extends Application {
    private Map map;
    private Player player;
    private Food food;
    

   

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        in.close();

        Parameters parameters = getParameters();
        List<String> listParams = parameters.getRaw();

        map = new Map(listParams.get(0));
        player = new MyPlayer(map);
        food = new Food(map, player);

        Scene s = new Scene(map);
        primaryStage.setTitle("Eater");
        primaryStage.setScene(s);
        primaryStage.show();
        primaryStage.setResizable(false);



        s.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.RIGHT) {
                player.moveRight();
            }
            else if(e.getCode() == KeyCode.LEFT) {
                player.moveLeft();
            }
            else if(e.getCode() == KeyCode.UP) {
                player.moveUp();
            }
           else if(e.getCode() == KeyCode.DOWN) {
                player.moveDown();
            }
        });

    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
