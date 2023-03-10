package bombchicken.utils;

public class Delay {
    
    private int count;
    private int countLimit;//幀

    private boolean isPause;
    private boolean isLoop;

    public Delay(int countLimit) {
        this.countLimit = countLimit;
        count = 0;
        isPause = true;
        this.isLoop = false;
    }

    public void setLimit(int limit) {
        this.countLimit = limit;
    }

    public void stop() {
        isPause = true;
        isLoop = false;
        count = 0;
    }

    public void pause() {
        isPause = true;
    }

    public void play() {
        isPause = false;
        isLoop = false;
    }

    public void loop() {
        isPause = false;
        isLoop = true;
    }

    public boolean count() {
        if (isPause) {
            return false;
        }
        if (count >= countLimit) {
            if (isLoop) {
                count = 0;
            }else{
                stop();
            }
            return true;
        }
        count++;
        return false;
    }
    
    public int getCount(){
        return this.count;
    }
}
