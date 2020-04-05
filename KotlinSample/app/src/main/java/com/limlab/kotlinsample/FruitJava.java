package com.limlab.kotlinsample;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Objects;

public class FruitJava {
    String fruitName;

    String description;

    @NonNull
    @Override
    public String toString() {
        return "FruitJava(" + fruitName + "," + description + ")";
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        //먼저 같은 클래스인지 확인 한다.
        if (obj instanceof FruitJava) {
            //FruitJava 클래스로 캐스팅한다.
            FruitJava another = (FruitJava) obj;

            //모든 필드가 같다면 같은 객체로 취급한다.
            return fruitName.equals(another.fruitName) && description.equals(another.description);
        }
        return false;
    }

    @Override
    public int hashCode() {
        //객체가 같으면 해쉬코드도 같아야 한다.
        int hash = Objects.hash(fruitName, description);

        return hash;
    }
}
