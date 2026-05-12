package com.example.viewmodellivedatademoenrichi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * ViewModel pour gérer la logique du compteur.
 * Cette classe survit aux changements de configuration (ex: rotation).
 */
public class CounterViewModel extends ViewModel {

    // Encapsulation : MutableLiveData en privé pour modification interne, 
    // LiveData en public pour observation externe (Lecture seule).
    private final MutableLiveData<Integer> mCounterState = new MutableLiveData<>();

    public CounterViewModel() {
        // Initialisation de la valeur de départ
        mCounterState.setValue(0);
    }

    /**
     * Retourne le flux de données (LiveData) pour l'observation par l'UI.
     */
    public LiveData<Integer> getCounter() {
        return mCounterState;
    }

    public void incrementCounter() {
        Integer value = mCounterState.getValue();
        if (value != null) {
            mCounterState.setValue(value + 1);
        }
    }

    public void decrementCounter() {
        Integer value = mCounterState.getValue();
        if (value != null) {
            mCounterState.setValue(value - 1);
        }
    }

    public void resetCounter() {
        mCounterState.setValue(0);
    }
}
