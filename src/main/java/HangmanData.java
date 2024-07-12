public class HangmanData {

    int wins = 0;
    int losses = 0;
    int attemptsLeft = 7;
    int displayTimes = 0;
    int count = 0;
    String playerName;

    public void resetData(){
        attemptsLeft = 7;
        displayTimes = 0;
        count++;
    }
}
