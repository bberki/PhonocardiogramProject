package phonocardiogram;

import java.util.List;
import java.util.stream.Collectors;

public class SignalProcessor {

    // Sinyal işleme fonksiyonu (FP)
    public static List<Double> processSignals(List<Double> signals) {
        return signals.stream()
                      .map(SignalProcessor::detectAnomalies)  // Anomali tespiti
                      .collect(Collectors.toList());
    }

    // Örnek bir sinyal işleme fonksiyonu
    public static Double detectAnomalies(Double signal) {
        // Basit bir anomali kontrolü: 0'dan küçükse sinyali değiştir
        return signal < 0 ? 0 : signal;
    }
}
