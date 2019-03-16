package com.crosska.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {

    private static CrimeLab sCrimeLab;
    private List<Crime> mCrimes;

    public static CrimeLab get(Context context) { // Get-метод класса CrimeLab
        if (sCrimeLab == null) { // Если экземпляр CrimeLab существует, то пропускает создание (Приставка s- значит, что переменная статическая)
            sCrimeLab = new CrimeLab(context); // Вызов закрытого конструктора
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) { // Закрытый конструктор класса
        mCrimes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0); // Для каждого второго объекта
            mCrimes.add(crime);
        }
    }

    public List<Crime> getCrimes() { // Метод, возвращающий лист
        return mCrimes;
    }

    public Crime getCrime(UUID id) { // Метод, возвращающий обьект Crime с заданный идентификатором
        for (Crime crime : mCrimes) {
            if (crime.getId().equals(id)) {
                return crime;
            }
        }
        return null;
    }

}
