package mlya.audioFiles;
import java.security.ProtectionDomain;

public class AutoAudioPath {
    public static String getAudioPath() {

        // Абсолютный путь к корневой папке проекта:
        ProtectionDomain jarPath = AutoAudioPath.class.getProtectionDomain();
        String path = jarPath.getCodeSource().getLocation().getPath();

        // Относительный путь к пакету с аудио:
        Package pkg = AutoAudioPath.class.getPackage();
        String packageName = pkg.getName();
        packageName = packageName.replace(".", "/");

        String audioPath = path.concat(packageName);

        // System.out.println("Расположение пакета с аудиофайлами: ".concat(audioPath));

        return audioPath;
    }
}
