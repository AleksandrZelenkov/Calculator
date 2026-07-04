package mlya;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

class MlyaRun implements Runnable{

    @Override
    public void run() {

        File audioFile = new File(RundomFilePath.getRundomFilePath());

        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

            Thread.sleep(clip.getMicrosecondLength() / 1000 + 1000);

            clip.close();
            audioInputStream.close();
        }
        catch (UnsupportedAudioFileException | LineUnavailableException | IOException | InterruptedException exception){
            exception.printStackTrace();
        }
    }
}