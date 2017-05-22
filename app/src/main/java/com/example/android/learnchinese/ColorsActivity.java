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

import static com.example.android.learnchinese.R.id.numbers;

public class ColorsActivity extends AppCompatActivity {
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

        // list of words for colors
        final ArrayList<Word> colors = new ArrayList<Word>();
        initColors(colors);

        // init list view
        WordAdapter adapter = new WordAdapter(this, colors);
        ListView listView = (ListView) findViewById(R.id.words_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();
                Word word = colors.get(position);

                // listen for audio change
                int result = audioManager.requestAudioFocus(onAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudioID());
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

    private void initColors(ArrayList<Word> colors) {
        colors.add(new Word(getString(R.string.white_color), "白色", "bái sè",
                R.raw.white));
        colors.add(new Word(getString(R.string.black_color), "黑色", "hēi sè",
                R.raw.black));
        colors.add(new Word(getString(R.string.red_color), "红色", "hóng sè",
                R.raw.red));
        colors.add(new Word(getString(R.string.yellow_color), "黄色", "huáng sè",
                R.raw.yellow));
        colors.add(new Word(getString(R.string.green_color), "绿色", "lǜ sè",
                R.raw.green));
        colors.add(new Word(getString(R.string.blue_color), "蓝色", "lán sè",
                R.raw.blue));
        colors.add(new Word(getString(R.string.brown_color), "褐色", "hé sè",
                R.raw.brown));
        colors.add(new Word(getString(R.string.orange_color), "橙色", "chéng sè",
                R.raw.orange));
        colors.add(new Word(getString(R.string.grey_color), "灰色", "huī sè",
                R.raw.grey));
        colors.add(new Word(getString(R.string.pink_color), "粉红色色", "fěn hóng sè",
                R.raw.pink));
        colors.add(new Word(getString(R.string.purple_color), "紫色", "zǐ sè",
                R.raw.purple));
    }

}
