import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.SystemEvent;
import java.util.Arrays;

@ManagedBean
@SessionScoped
public class PlayerHandler {

    private String[][] aMap;
    private Map map = new Map();
    private Integer prevX;
    private Integer prevY;
    private Player aPlayer;

    //should come from another place!
    private Integer y = 6;
    private Integer x = 3;

    //private HighScoreHandler highScoreHandler = new HighScoreHandler();
    //private UI ui = new UI();

    public void movementChoice(Integer dir) {

        aMap = map.getMap();
        prevX = x;
        prevY = y;

        switch (dir) {
            case 1 :
                //move up
                checkPosition(moveUp(y), x);
                break;
            case 2 :
                //move down
                checkPosition(moveDown(y), x);
                break;
            case 3 :
                //move right
                checkPosition(y, moveRight(x));
                break;
            case 4 :
                //move left
                checkPosition(y, moveLeft(x));
                break;
            default:
                //stuff
                break;
        }
    }

    /**
     * move player up
     * @param y players y position
     * @return y plus one
     */
    public Integer moveUp(Integer y) {
        y--;
        return y;
    }
    /**
     * move player down
     * @param y players y position
     * @return y minus one
     */
    public Integer moveDown(Integer y) {
        y++;
        return y;
    }
    /**
     * move player right
     * @param x players x position
     * @return x plus one
     */
    public Integer moveRight(Integer x) {
        x++;
        return x;
    }
    /**
     * move player up
     * @param x players x position
     * @return x minus one
     */
    public Integer moveLeft(Integer x) {
        x--;
        return x;
    }

    /**
     * checks if the position the player want to go to is possible
     * @param y players y position
     * @param x players x position
     */
    public void checkPosition(Integer y, Integer x) {

        //BattleHandler battleHandler = new BattleHandler();

        System.out.println("X is: "+x+" Y is: "+y);

        switch (aMap[y][x]) {
            case "#":
                //ui.print("You walked into a wall, try walking another way.\n");
                System.out.println("You walked into a wall, try walking another way.\n");
                aMap[prevY][prevX] = "X";
                setPosition(prevY, prevX);
                break;
            case "+":
                //battleHandler.startBattle(aPlayer);
                System.out.println("battle");
                setPosition(y, x);
                break;
            case "O":
                //ui.clear();
                //ui.print("Congratulations!\nYou survived this level, please select another!\n");
                System.out.println("Congratulations!\nYou survived this level, please select another!\n");
                break;
            default:
                setPosition(y, x);
                System.out.println(aMap[y][x]);
                break;
        }
    }

    /**
     * @param y players y position on the map
     * @param x players y position on the map
     */
    private void setPosition(Integer y, Integer x) {

        aMap[prevY][prevX] = ".";
        aMap[y][x] = "X";
        //System.out.print(Arrays.deepToString(aMap));
        //getDirectionChoice(aMap, y, x, aPlayer);
        map.setMap(aMap);
    }
}
