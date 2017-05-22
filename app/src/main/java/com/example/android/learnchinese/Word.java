package com.example.android.learnchinese;

/**
 * Created by lisachan on 5/8/17.
 */

public class Word {
    private final String word;
    private final String translation;
    private final String pronouciation;
    private final int audio_id;

    Word(String word, String translation, String pronouciation) {
        this.word = word;
        this.translation = translation;
        this.pronouciation = pronouciation;
        this.audio_id = -1;
    }

    Word(String word, String translation, String pronouciation, int audio_id) {
        this.word = word;
        this.translation = translation;
        this.pronouciation = pronouciation;
        this.audio_id = audio_id;
    }

    public String getTranslation() {
        return translation;
    }

    public String getPronouciation() {
        return pronouciation;
    }

    public int getAudioID() {
        return audio_id;
    }

    @Override
    public String toString() {
        return word;
    }

}
