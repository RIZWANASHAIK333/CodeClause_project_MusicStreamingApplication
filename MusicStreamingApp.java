import java.io.File;
import java.util.Scanner;
public class MusicStreamingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Music Streaming App!");
        System.out.println("Enter the directory path where your music files are located:");
        String musicDirPath = scanner.nextLine();

        File musicDir = new File(musicDirPath);

        if (!musicDir.exists() || !musicDir.isDirectory()) {
            System.out.println("Invalid directory path or directory does not exist.");
            scanner.close();
            return;
        }

        File[] musicFiles = musicDir.listFiles();
        if (musicFiles == null || musicFiles.length == 0) {
            System.out.println("No music files found in the directory.");
            scanner.close();
            return;
        }

        System.out.println("Available Music:");
        for (int i = 0; i < musicFiles.length; i++) {
            System.out.println((i + 1) + ". " + musicFiles[i].getName());
        }

        System.out.print("Enter the number of the song you want to play: ");
        int songNumber = scanner.nextInt();

        if (songNumber <= 0 || songNumber > musicFiles.length) {
            System.out.println("Invalid song number.");
            scanner.close();
            return;
        }

        String chosenSong = musicFiles[songNumber - 1].getAbsolutePath();
        System.out.println("Now playing: " + musicFiles[songNumber - 1].getName());
        playMusic(chosenSong);

        System.out.println("Thank you for using the Music Streaming App!");
        scanner.close();
    }

    private static void playMusic(String filePath) {
        // This is a placeholder method to simulate playing music.
        // In a real application, you'd use a library like JavaFX or JLayer for audio playback.
        System.out.println("Playing music: " + filePath);
        try {
            // Simulate playing by pausing for a few seconds
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Music finished playing.");
    }
}
