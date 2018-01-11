public class ScoreBoard{

  private int score = 0;
  private int linesCleared = 0;
  private boolean tetris;
  private long startTime;
  private long stopTime;
  private boolean running;

  // make score
  // count score
  // count lines
  // l: lines cleared in move
  public void CountScore(int l){
    if (l == 1){
      score+= 100;
      tetris = false;
    }
    if (l == 2){
      score+= 200;
      tetris = false;
    }
    if (l == 3){
      score+= 400;
      tetris = false;
    }
    if (l == 4){
      if (tetris){
        score+= 1600;
      }
      score+= 800;
      tetris = true;
    }
    linesCleared+= l;
  }

  // track time
  public void start(){
    this.startTime = System.currentTimeMillis();
    this.running = true;
  }

  public void stop(){
    this.stopTime = System.currentTimeMillis();
    this.running = false;
  }

  public long getTime(){
    long time;
    if (running){
      time = System.currentTimeMillis() - startTime;
    }
    else{
      time = stopTime - startTime;
    }
    return time;
  }

}
