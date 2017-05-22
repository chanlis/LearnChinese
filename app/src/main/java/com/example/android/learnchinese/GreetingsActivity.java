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

public class GreetingsActivity extends AppCompatActivity {
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

        final ArrayList<Word> greetings = new ArrayList<Word>();
        initGreetings(greetings);

        WordAdapter adapter = new WordAdapter(this, greetings);
        ListView listView = (ListView) findViewById(R.id.words_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();
                Word word = greetings.get(position);

                // listen for audio change
                int result = audioManager.requestAudioFocus(onAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer = MediaPlayer.create(GreetingsActivity.this, word.getAudioID());
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

    private void initGreetings(ArrayList<Word> greetings) {
        greetings.add(new Word(getString(R.string.hello_greeting), "你好", "nǐ hǎo",
                R.raw.hello));
        greetings.add(new Word(getString(R.string.how_are_you_greeting), "你好吗", "nǐ hǎo ma",
                R.raw.how_are_you));
        greetings.add(new Word(getString(R.string.i_am_fine_greeting), "我很好，谢谢", "wǒ hěn hǎo，xiè xiè",
                R.raw.i_am_fine));
        greetings.add(new Word(getString(R.string.my_name_is_greeting), "我叫...", "wǒ jiào...",
                R.raw.my_name_is));
        greetings.add(new Word(getString(R.string.nice_to_meet_you_greeting), "很高兴认识你", "hěn gāo xìng rèn shí nǐ",
                R.raw.nice_to_meet_you));
        greetings.add(new Word(getString(R.string.goodbye_greeting), "再见", "zài jiàno",
                R.raw.goodbye));
        greetings.add(new Word(getString(R.string.speak_eng_question_greeting), "你会说英语吗", "nǐ huì shuō yīng yǔ ma",
                R.raw.speak_eng_question));
        greetings.add(new Word(getString(R.string.yes_speak_eng_greeting), "会，我会说英语", "huì，wǒ huì shuō yīng yǔ",
                R.raw.yes_speak_eng));
        greetings.add(new Word(getString(R.string.no_speak_eng_greeting), "不会， 我不会说英语", "bú huì, wǒ bú huì shuō yīng yǔ",
                R.raw.no_speak_eng));

    }
}
