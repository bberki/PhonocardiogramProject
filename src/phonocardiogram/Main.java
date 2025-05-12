package phonocardiogram;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filePath = "data/sample_signal.wav"; // WAV dosyanızın yolu
        List<Double> signalData = readWavSignal(filePath);

        if (signalData != null) {
            // Sinyali işleyin (örneğin her değeri iki katına çıkarma)
            for (Double signal : signalData) {
                System.out.println(processSignal(signal));
            }
        }
    }

    // WAV dosyasından ses verilerini okuma
    public static List<Double> readWavSignal(String filePath) {
        try {
            File file = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            AudioFormat format = audioStream.getFormat();
            
            // Ses dosyasını okurken veri tutacak bir byte dizisi oluşturuyoruz
            byte[] audioBytes = new byte[audioStream.available()];
            audioStream.read(audioBytes); // Veriyi okuyoruz

            List<Double> signalData = new ArrayList<>();
            
            // Ses verilerini PCM formatında byte'lar olarak alır
            for (int i = 0; i < audioBytes.length; i += 2) {
                // PCM formatında her iki byte'ı alıp bir 'short' değeri oluşturuyoruz
                short sample = (short) (((audioBytes[i+1] << 8) | (audioBytes[i] & 0xff)));
                
                // Veriyi double'a çevirip listeye ekliyoruz
                signalData.add((double) sample);
            }
            return signalData;

        } catch (UnsupportedAudioFileException | IOException e) {
            System.out.println("Error reading WAV signal: " + e.getMessage());
            return null;
        }
    }

    // Sinyali işleyen basit fonksiyon
    public static Double processSignal(Double signal) {
        // Basit bir işlem: her değeri iki katına çıkar
        return signal * 2;
    }
}
