package com.example.android.learnchinese;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.id.list;

public class NumbersActivity extends AppCompatActivity {
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

        // Create a list of words
        final ArrayList<Word> numbers = new ArrayList<Word>();
        initNumbers(numbers);

        WordAdapter adapter = new WordAdapter(this, numbers);
        ListView listView = (ListView) findViewById(R.id.words_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();
                Word word = numbers.get(position);

                // listen for audio change
                int result = audioManager.requestAudioFocus(onAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioID());
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

    // initialize numbers array
    private void initNumbers(ArrayList<Word> numbers) {
        numbers.add(new Word(getString(R.string.one_numbers), "一", "yī",
                R.raw.one));
        numbers.add(new Word(getString(R.string.two_numbers), "二", "èr",
                R.raw.two));
        numbers.add(new Word(getString(R.string.three_numbers), "三", "sān",
                R.raw.three));
        numbers.add(new Word(getString(R.string.four_numbers), "四", "sì",
                R.raw.four));
        numbers.add(new Word(getString(R.string.five_numbers), "五", "wǔ",
                R.raw.five));
        numbers.add(new Word(getString(R.string.six_numbers), "六", "liù",
                R.raw.six));
        numbers.add(new Word(getString(R.string.seven_numbers), "七", "qī",
                R.raw.seven));
        numbers.add(new Word(getString(R.string.eight_numbers), "八", "bā",
                R.raw.eight));
        numbers.add(new Word(getString(R.string.nine_numbers), "九", "jiǔ",
                R.raw.nine));
        numbers.add(new Word(getString(R.string.ten_numbers), "十", "shí",
                R.raw.ten));

    }
}
