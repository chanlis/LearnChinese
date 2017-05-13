package com.example.android.learnchinese;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class GreetingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        final ArrayList<Word> greetings = new ArrayList<Word>();
        initGreetings(greetings);

        WordAdapter adapter = new WordAdapter(this, greetings);
        ListView listView = (ListView) findViewById(R.id.words_list);
        listView.setAdapter(adapter);
    }

    private void initGreetings(ArrayList<Word> greetings)
    {
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
