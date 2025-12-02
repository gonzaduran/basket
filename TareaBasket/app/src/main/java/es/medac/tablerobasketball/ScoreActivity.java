package es.medac.tablerobasketball;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import es.medac.tablerobasketball.databinding.ActivityScoreBinding;

public class ScoreActivity extends AppCompatActivity {

    private ActivityScoreBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        displayResults();
    }

    /**
     * Obtiene los marcadores del intent, calcula el ganador y muestra los resultados
     */
    private void displayResults() {
        // Obtener los marcadores pasados desde MainActivity
        int localScore = getIntent().getIntExtra(MainActivity.EXTRA_LOCAL_SCORE, 0);
        int visitorScore = getIntent().getIntExtra(MainActivity.EXTRA_VISITOR_SCORE, 0);

        // Mostrar el marcador en formato "X - Y"
        String scoreText = localScore + " - " + visitorScore;
        binding.tvFinalScore.setText(scoreText);

        // Determinar y mostrar el mensaje del resultado
        String resultMessage;
        if (localScore > visitorScore) {
            resultMessage = getString(R.string.local_wins);
        } else if (visitorScore > localScore) {
            resultMessage = getString(R.string.visitor_wins);
        } else {
            resultMessage = getString(R.string.tie);
        }

        binding.tvResultMessage.setText(resultMessage);
    }
}