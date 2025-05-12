package phonocardiogram;

import java.util.Arrays;
import java.util.List;

public class SignalProcessorTest {

    public static void main(String[] args) {
        testSignalProcessing();
    }

    public static void testSignalProcessing() {
        List<Double> sampleSignal = Arrays.asList(1.0, -2.0, 3.0, -4.0, 5.0);

        // Sinyal işleme işlemini başlat
        List<Double> processedSignal = SignalProcessor.processSignals(sampleSignal);

        // İşlenmiş sinyalleri kontrol et
        processedSignal.forEach(signal -> System.out.println("Processed Signal: " + signal));
        
        // Beklenen sonuçları karşılaştır
        assert processedSignal.get(0) == 1.0 : "Test failed!";
        assert processedSignal.get(1) == 0.0 : "Test failed!";
        assert processedSignal.get(2) == 3.0 : "Test failed!";
        assert processedSignal.get(3) == 0.0 : "Test failed!";
        assert processedSignal.get(4) == 5.0 : "Test failed!";

        System.out.println("All tests passed!");
    }
}
