public class Square {

    private int num;
    private boolean isUncovered = false;
    private boolean flag = false;
    private boolean DEBUG_MODE = false; //uncovers the board if true

    public static String FLAG_DISPLAY = "F";
    public static String COVERED_DISPLAY = "*";
    public static String EMPTY_DISPLAY = " ";
    public static String BOMB_DISPLAY = "x";


    public Square(int num, boolean flag) {
        setNumVal(num);
        this.flag = flag;
    }

    public int getNumVal() {
        return num;
    }

    public void setNumVal(int num) {
        this.num = num;
    }

    public void addNumVal(int val) {
        num += val;
    }

    public boolean getIsUncovered() {
        return isUncovered;
    }

    public void setIsUncovered() {
        isUncovered = true;
    }
    
    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isBomb() {
        return (getNumVal() == -1);
    }


    //display method toString
    public String toString() {
        if (getIsUncovered() || DEBUG_MODE) {
            if (getNumVal() == 0) {
                return EMPTY_DISPLAY;
            }
            else if (getNumVal() < 0) {
                return BOMB_DISPLAY;
            }
            else {
                return Integer.toString(num);
            }
        }
        else { // covered case
            if (getFlag()) {
                return FLAG_DISPLAY;
            }
            else {
                return COVERED_DISPLAY;
            }

        }
    }

}
