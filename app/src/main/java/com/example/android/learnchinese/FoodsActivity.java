package com.example.android.learnchinese;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.android.learnchinese.R.id.numbers;

/**
 * Created by lisachan on 5/10/17.
 */

public class FoodsActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // enable Up button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // set view to correct xml layout
        setContentView(R.layout.words_list);
        // Create and setup audio manager
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> foods = new ArrayList<Word>();
        initFoods(foods);

        WordAdapter adapter = new WordAdapter(this, foods);
        ListView listView = (ListView) findViewById(R.id.words_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();
                Word word = foods.get(position);

                // listen for audio change
                int result = audioManager.requestAudioFocus(onAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer = MediaPlayer.create(FoodsActivity.this, word.getAudioID());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(completionListener);
                }
            }
        });
    }

    // when activity is stopped, release media player resource
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    // on completion listener used to release media player resource
    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    private AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            // media paused if audio interupted
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
                // gaining focus starts audio from media player
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer.start();
                // lost focus releases media player resource
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };

    // force release when media player is not null to free up resource
    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;

            // release audio manager use
            audioManager.abandonAudioFocus(onAudioFocusChangeListener);
        }
    }

    private void initFoods(ArrayList<Word> foods) {
        foods.add(new Word(getString(R.string.hungry_foods), "饿", "è",
                R.raw.hungry));
        foods.add(new Word(getString(R.string.thirsty_food), "渴", "kě",
                R.raw.thirsty));
        foods.add(new Word(getString(R.string.eaten_enough_food), "有足够的食物", "yǒu zú gòu de shí wù",
                R.raw.eaten_enough));
        foods.add(new Word(getString(R.string.breakfast_food), "早餐", "zǎo cān",
                R.raw.breakfast));
        foods.add(new Word(getString(R.string.lunch_food), "午餐", "wǔ cān",
                R.raw.lunch));
        foods.add(new Word(getString(R.string.dinner_food), "晚餐", "wǎn cān",
                R.raw.dinner));
        foods.add(new Word(getString(R.string.bread_food), "面包", "miàn bāo",
                R.raw.bread));
        foods.add(new Word(getString(R.string.meat_food), "肉", "ròu",
                R.raw.meat));
        foods.add(new Word(getString(R.string.soup_food), "汤", "tāng",
                R.raw.soup));
        foods.add(new Word(getString(R.string.fruit_food), "水果", "shuǐ guǒ",
                R.raw.fruit));
        foods.add(new Word(getString(R.string.salad_food), "沙拉", "shā lā",
                R.raw.salad));
        foods.add(new Word(getString(R.string.tea_food), "茶", "chá",
                R.raw.tea));
        foods.add(new Word(getString(R.string.coffee_food), "咖啡", "kā fēi",
                R.raw.coffee));
        foods.add(new Word(getString(R.string.french_fries_food), "薯条", "shǔ tiáo",
                R.raw.french_fries));
        foods.add(new Word(getString(R.string.sausage_food), "香肠", "xiāng cháng",
                R.raw.sausage));
        foods.add(new Word(getString(R.string.cake_food), "蛋糕", "dàn gāo",
                R.raw.cake));
        foods.add(new Word(getString(R.string.cheese_food), "乳酪", "rǔ lào",
                R.raw.cheese));
        foods.add(new Word(getString(R.string.apple_food), "苹果", "píng guǒ",
                R.raw.apple));
        foods.add(new Word(getString(R.string.orange_food), "橙", "chéng",
                R.raw.orange));
        foods.add(new Word(getString(R.string.banana_food), "香蕉", "xiāng jiāo",
                R.raw.banana));
        foods.add(new Word(getString(R.string.sugar_food), "糖", "táng",
                R.raw.sugar));
        foods.add(new Word(getString(R.string.salt_food), "盐", "yán",
                R.raw.salt));
        foods.add(new Word(getString(R.string.pepper_food), "胡椒粉", "hú jiāo fěn",
                R.raw.pepper));

    }
}
