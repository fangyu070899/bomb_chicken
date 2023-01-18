package bombchicken;

import bombchicken.utils.GameKernel;
import bombchicken.utils.Global;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class BombChicken {

    public static void main(String[] args) {
        JFrame jf = new JFrame();// 遊戲視窗本體
        jf.setTitle("Bomb Chicken");// 視窗標題
        jf.setSize(Global.WINDOW_WIDTH, Global.WINDOW_HEIGHT);// 視窗大小
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 關閉視窗時關閉程式
        jf.setLocationRelativeTo(null); //視窗置中
        int[][] command = {
            {KeyEvent.VK_LEFT, Global.P1LEFT},
            {KeyEvent.VK_RIGHT, Global.P1RIGHT},
            {KeyEvent.VK_UP, Global.P1UP},
            {KeyEvent.VK_DOWN, Global.P1DOWN},
            {KeyEvent.VK_A, Global.P2LEFT},
            {KeyEvent.VK_D, Global.P2RIGHT},
            {KeyEvent.VK_W, Global.P2UP},
            {KeyEvent.VK_S, Global.P2DOWN},
            {KeyEvent.VK_SPACE, Global.SPACE},
            {KeyEvent.VK_ESCAPE, Global.ESC},
            {KeyEvent.VK_ENTER, Global.ENTER},
            {KeyEvent.VK_T, Global.TEACH},
            {KeyEvent.VK_R, Global.REPLACE2},
            {KeyEvent.VK_P, Global.REPLACE}

        };

        GI gi = new GI();// 遊戲的本體(邏輯 + 畫面處理)

        GameKernel gk = new GameKernel.Builder(gi, Global.LIMIT_DELTA_TIME, Global.NANOSECOND_PER_UPDATE)
                .initListener(command)
                .enableKeyboardTrack(gi)
                .enableMouseTrack(gi)
                .mouseForceRelease()
                //                .keyTypedMode() // 移動會卡卡ㄉ模式
                .keyCleanMode() // 滑順的移動模式s
                .trackChar()
                .gen();

        jf.add(gk);

        jf.setVisible(true);
        gk.run(Global.IS_DEBUG);
    }

}
