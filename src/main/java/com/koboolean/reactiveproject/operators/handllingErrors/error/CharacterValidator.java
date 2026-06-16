package com.koboolean.reactiveproject.operators.handllingErrors.error;

import java.util.zip.DataFormatException;

public class CharacterValidator {

    public static void isAlphabeticCharacter(char ch) throws DataFormatException {
        if(!Character.isAlphabetic(ch)){
            throw new DataFormatException("NotAlphabetic");
        }
    }
}
