import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map extends Pane
{
    private  final int UNIT = 40; //number of pixels
    private int size; //array-side size
    private int[][] map; // map as double array
    private Position start; // if == 2 then start

    public Map(String str){
        try {
            //region<txt read and map[][] initialization>
            File myObj = new File(str);
            Scanner myReader = new Scanner(myObj);
            ArrayList<String> array = new ArrayList<>();
            while (myReader.hasNextLine()) {
                array.add(myReader.nextLine());
            }
            myReader.close();

            size = Integer.parseInt(array.get(0));
            map = new int[getSize()][getSize()];
            //changed stupid error with indexes(be more careful i, j);
            for (int i = 1; i < array.size(); i++) {
                String[] rowNumbers = array.get(i).split(" ");
                for(int j = 0; j < size; j++){
                    map[i-1][j] = Integer.parseInt(rowNumbers[j]);
                }
            }
            //endregion
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    Rectangle rec = new Rectangle(j * UNIT, i * UNIT ,UNIT, UNIT);
                    rec.setStroke(Color.BLACK);
                    rec.setFill(Color.WHITE);

                    if(map[i][j] == 2){
                        start = new Position(i,j);
                    }

                    //good
                    if(map[i][j] == 1){
                        rec.setFill(Color.BLACK);
                    }
                    getChildren().add(rec);
                }
            }

        }
        catch(FileNotFoundException e){
            System.out.println("Can not find a file!!! Nicole A is the best!!!");
            e.printStackTrace();
        }
    }


    public int getUnit() {
        return UNIT;
    }

    public int getSize() {
        return size;
    }

    public int getValueAt(int x, int y){
        return map[x][y];
    }

    public Position getStart() {
        return start;
    }
}
