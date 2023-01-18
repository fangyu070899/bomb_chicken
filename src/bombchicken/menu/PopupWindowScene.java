package bombchicken.menu;

import bombchicken.animator.PopsAnimator;
import bombchicken.controllers.SceneController;
import bombchicken.gameobj.Fire;
import bombchicken.utils.CommandSolver;
import bombchicken.utils.Global;
import bombchicken.utils.MouseTriggerImpl;
import bombchicken.utils.Path;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;

public class PopupWindowScene extends PopupWindow {

    private Image img;
    private Type type;

    public enum Type {

        MODE(0), 
        EXIT(1), 
        CLIENT(2),
        NAME(3),
        IP(4),
        CHECK(5),
        TEACH(6),
        MAP(7); 

        private int value;

        Type(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public PopupWindowScene(int x, int y, int width, int height, Type type) {   //設定此彈出視窗的位置、大小
        super(x, y, width, height);
        this.type = type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return this.type;
    }

    @Override  //設定視窗開始後載入的元件、以及按鈕按下後觸發的動作
    public void sceneBegin() {
        switch (type) {
            case EXIT:
                img = SceneController.instance().irc().tryGetImage(new Path().img().objs().exitChoose());
                break;
        }

    }

    @Override
    public void sceneEnd() {
        img = null;

    }

    @Override //整個視窗paint出來的樣式
    public void paintWindow(Graphics g) {
        g.drawImage(img, this.getX(), this.getY(), this.getWidth(), this.getHeight(), null);
//     
    }

    @Override
    public void update() {
    }

    @Override
    protected void mouseTrig(MouseEvent e, CommandSolver.MouseState state, long trigTime) {

    }

    @Override
    public CommandSolver.KeyListener keyListener() {
        return null;
    }

}
