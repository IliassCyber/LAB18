package com.example.viewmodellivedatademoenrichi;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

/**
 * LAB 18 - Partie 2 : Solution avec ViewModel et LiveData.
 * L'UI observe maintenant les changements de données via LiveData.
 * L'état survit à la rotation car le ViewModel est conservé en mémoire.
 */
public class MainActivity extends AppCompatActivity {

    private CounterViewModel mViewModel;
    private TextView mTextDisplay;
    private Button mBtnAdd, mBtnSubtract, mBtnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Liaison avec les vues
        initViews();

        // 1. Initialisation du ViewModel
        // On demande au ViewModelProvider de nous donner une instance de CounterViewModel
        // associée au cycle de vie de cette Activity.
        mViewModel = new ViewModelProvider(this).get(CounterViewModel.class);

        // 2. Observation du LiveData
        // Dès que la valeur dans le ViewModel change, ce bloc est exécuté.
        mViewModel.getCounter().observe(this, count -> {
            mTextDisplay.setText(String.valueOf(count));
        });

        // 3. Actions utilisateur
        // Les clics n'incrémentent plus une variable locale, mais appellent le ViewModel.
        mBtnAdd.setOnClickListener(v -> mViewModel.incrementCounter());
        mBtnSubtract.setOnClickListener(v -> mViewModel.decrementCounter());
        mBtnReset.setOnClickListener(v -> mViewModel.resetCounter());
    }

    private void initViews() {
        mTextDisplay = findViewById(R.id.text_counter);
        mBtnAdd = findViewById(R.id.button_add);
        mBtnSubtract = findViewById(R.id.button_subtract);
        mBtnReset = findViewById(R.id.button_clear);
    }
}
