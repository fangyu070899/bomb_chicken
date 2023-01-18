package bombchicken.gameobj;

import bombchicken.animator.PopsAnimator;
import java.awt.Graphics;

public class Belt extends GameObject { //輸送帶

    private PopsAnimator animator;
    private PopsAnimator.State state;
    private int moveSpeed; //輸送帶轉速

    public Belt(int x, int y, int width, int height, int moveSpeed) {
        super(x, y, width/2 , height/2 );
        animator = new PopsAnimator(PopsAnimator.State.WORK);
        setState(PopsAnimator.State.WORK);
        this.moveSpeed = moveSpeed;
        towardRight();
    }

    public void setState(PopsAnimator.State state) {
        this.state = state;
        animator.setState(state);
    }

    public int getMoveSpeed() {
        return this.moveSpeed;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public void towardRight() {
        if (moveSpeed < 0) {
            animator.setTowardRight(false);
        } else {
            animator.setTowardRight(true);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        animator.paint(
                painter().left(), painter().top(),
                painter().right(), painter().bottom(), g);
    }

    @Override
    public void update() {
        animator.update();
    }

}
