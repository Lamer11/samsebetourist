package se.android.samsebetourist;

public class ObjectAudio {

    String nameAudio;
    int runButton;
    int downButton;

    public ObjectAudio(String nameAudio, int runButton, int downButton) {
        this.nameAudio = nameAudio;
        this.runButton = runButton;
        this.downButton = downButton;
    }


    public void setNameAudio(String nameAudio) {
        this.nameAudio = nameAudio;
    }

    public void setRunButton(int runButton) {
        this.runButton = runButton;
    }

    public void setDownButton(int downButton) {
        this.downButton = downButton;
    }


    public String getNameAudio() {
        return nameAudio;
    }

    public int getRunButton() {
        return runButton;
    }

    public int getDownButton() {
        return downButton;
    }


}
