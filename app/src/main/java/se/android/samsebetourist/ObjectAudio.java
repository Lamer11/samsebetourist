package se.android.samsebetourist;

public class ObjectAudio {

    private String nameCountry;
    private String nameAudio;
    private int runButton;
    private int downButton;

    public ObjectAudio(String nameCountry, String nameAudio) {
        this.nameAudio = nameAudio;
        this.nameCountry = nameCountry;
    }


    public ObjectAudio(String nameCountry, String nameAudio, int runButton, int downButton) {
        this.nameAudio = nameAudio;
        this.nameCountry = nameCountry;
        this.runButton = runButton;
        this.downButton = downButton;
    }


    public void setNameCountry(String nameCountry) { this.nameCountry = nameCountry; }

    public void setNameAudio(String nameAudio) {
        this.nameAudio = nameAudio;
    }

    public void setRunButton(int runButton) {
        this.runButton = runButton;
    }

    public void setDownButton(int downButton) {
        this.downButton = downButton;
    }



    public String getNameCountry() {
        return nameCountry;
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
