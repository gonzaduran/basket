package es.medac.tablerobasketball;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import es.medac.tablerobasketball.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Pasar datos
    public static final String EXTRA_LOCAL_SCORE = "extra_local_score";
    public static final String EXTRA_VISITOR_SCORE = "extra_visitor_score";

    private ActivityMainBinding binding;
    private int localScore = 0;
    private int visitorScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupButtons();
    }

    private void setupButtons() {
        // Botones equipo local
        binding.btnLocalPlusOne.setOnClickListener(v -> addPoints(true, 1));
        binding.btnLocalPlusTwo.setOnClickListener(v -> addPoints(true, 2));
        binding.btnLocalMinusOne.setOnClickListener(v -> subtractPoints(true));

        // Botones equipo visitante
        binding.btnVisitorPlusOne.setOnClickListener(v -> addPoints(false, 1));
        binding.btnVisitorPlusTwo.setOnClickListener(v -> addPoints(false, 2));
        binding.btnVisitorMinusOne.setOnClickListener(v -> subtractPoints(false));

        // Botón reset
        binding.btnReset.setOnClickListener(v -> resetScores());

        // Botón navegar a resultados
        binding.btnNext.setOnClickListener(v -> showResults());
    }

    /**
     * Añade puntos al equipo correspondiente
     * @param isLocal true para equipo local, false para visitante
     * @param points cantidad de puntos a añadir
     */
    private void addPoints(boolean isLocal, int points) {
        if (isLocal) {
            localScore += points;
            binding.tvLocalScore.setText(String.valueOf(localScore));
        } else {
            visitorScore += points;
            binding.tvVisitorScore.setText(String.valueOf(visitorScore));
        }
    }

    /**
     * Resta un punto al equipo, sin permitir negativos
     * @param isLocal true para equipo local, false para visitante
     */
    private void subtractPoints(boolean isLocal) {
        if (isLocal) {
            if (localScore > 0) {
                localScore--;
                binding.tvLocalScore.setText(String.valueOf(localScore));
            }
        } else {
            if (visitorScore > 0) {
                visitorScore--;
                binding.tvVisitorScore.setText(String.valueOf(visitorScore));
            }
        }
    }

    /**
     * Reinicia ambos marcadores a 0
     */
    private void resetScores() {
        localScore = 0;
        visitorScore = 0;
        binding.tvLocalScore.setText(String.valueOf(localScore));
        binding.tvVisitorScore.setText(String.valueOf(visitorScore));
    }

    /**
     * Navega a la pantalla de resultados pasando los marcadores
     */
    private void showResults() {
        Intent intent = new Intent(this, ScoreActivity.class);
        intent.putExtra(EXTRA_LOCAL_SCORE, localScore);
        intent.putExtra(EXTRA_VISITOR_SCORE, visitorScore);
        startActivity(intent);
    }
}