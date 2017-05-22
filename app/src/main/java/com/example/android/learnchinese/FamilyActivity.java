package com.example.android.learnchinese;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.android.learnchinese.R.id.numbers;

public class FamilyActivity extends AppCompatActivity {
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

        final ArrayList<Word> family = new ArrayList<Word>();
        initFamily(family);

        WordAdapter adapter = new WordAdapter(this, family);
        ListView listView = (ListView) findViewById(R.id.words_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();
                Word word = family.get(position);

                // listen for audio change
                int result = audioManager.requestAudioFocus(onAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudioID());
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

    private void initFamily(ArrayList<Word> family) {
        family.add(new Word(getString(R.string.friend_family), "朋友", "péng yǒu",
                R.raw.friend));
        family.add(new Word(getString(R.string.son_family), "儿子", "ér zi",
                R.raw.son));
        family.add(new Word(getString(R.string.daughter_family), "女儿", "nǚ ér",
                R.raw.daughter));
        family.add(new Word(getString(R.string.wife_family), "太太", "tài tài",
                R.raw.wife));
        family.add(new Word(getString(R.string.husband_family), "丈夫", "zhàng fū",
                R.raw.husband));
        family.add(new Word(getString(R.string.mother_family), "妈妈", "mā mā",
                R.raw.mother));
        family.add(new Word(getString(R.string.father_family), "爸爸", "bà bà",
                R.raw.father));
        family.add(new Word(getString(R.string.grandma_family), "奶奶", "nǎi nai",
                R.raw.grandma));
        family.add(new Word(getString(R.string.grandpa_family), "爷爷", "yé ye",
                R.raw.grandpa));
        family.add(new Word(getString(R.string.older_brother_family), "哥哥", "gē ge",
                R.raw.older_brother));
        family.add(new Word(getString(R.string.younger_brother_family), "弟弟", "dì dì",
                R.raw.younger_brother));
        family.add(new Word(getString(R.string.younger_sister_family), "妹妹", "mèi mei",
                R.raw.younger_sister));
        family.add(new Word(getString(R.string.older_sister_family), "姐姐", "jiě jie",
                R.raw.older_sister));

    }
}
