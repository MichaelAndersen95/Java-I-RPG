import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Arrays;

@ManagedBean
@SessionScoped
public class Map {

    public Map() {

    }

    public String[][] map = new String[][]{
            { "#", "#", "#", "O", "#", "#", "#", "#" },
            { "#", "#", "#", ".", "#", "#", "#", "#" },
            { "#", "#", "#", ".", "#", "#", "#", "#" },
            { "#", "#", "#", "+", "#", "#", "#", "#" },
            { "#", "#", "#", ".", "#", "#", "#", "#" },
            { "#", "#", "#", ".", "#", "#", "#", "#" },
            { "#", "#", ".", "X", ".", "#", "#", "#" },
            { "#", "#", "#", ".", "#", "#", "#", "#" }
    };

    public void setMap(String[][] newMap) {

        System.out.println("HALLO "+map[6][3]);
        this.map = newMap;
    }

    public String[][] getMap() {

        System.out.println(map[6][3]);
        return map;
    }

    public String getMiniMap() {

        System.out.println(map[6][3]);
        return createMiniMap(map);
    }



    public String createMiniMap(String[][] map) {

        System.out.println(map[6][3]);

        Integer i, j;
        String miniMap = "";

        for (i = 0; i < map.length; i++) {
            for (j = 0; j < map.length; j++)
                miniMap += (map[i][j] + "  ");
            miniMap += "<br/>";
        }
        return miniMap;
    }

}
