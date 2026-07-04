package mlya;

import mlya.audioFiles.AutoAudioPath;

public class RundomFilePath {

    public static String getRundomFilePath(){
        int random = (int) (Math.random() * 142+1);

        String rundomPath = AutoAudioPath.getAudioPath() + "/untitled - Track " + random + ".wav";

        return rundomPath;
    }
}
