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

        ArrayList<Word> greetings = new ArrayList<Word>();
        initGreetings(greetings);

        WordAdapter adapter = new WordAdapter(this, greetings);
        ListView listView = (ListView) findViewById(R.id.words_list);
        listView.setAdapter(adapter);
    }

    private final void initGreetings(ArrayList<Word> greetings)
    {
        String packageName = getPackageName();
        greetings.add(new Word(getResources().getString(R.string.hello_greeting), "你好", "nǐ hǎo",
                getResources().getIdentifier("hello", "raw", packageName)));
        greetings.add(new Word(getResources().getString(R.string.how_are_you_greeting), "你好吗", "nǐ hǎo ma",
                getResources().getIdentifier("how_are_you", "raw", packageName)));
        greetings.add(new Word(getResources().getString(R.string.i_am_fine_greeting), "我很好，谢谢", "wǒ hěn hǎo，xiè xiè",
                getResources().getIdentifier("i_am_fine", "raw", packageName)));
        greetings.add(new Word(getResources().getString(R.string.my_name_is_greeting), "我叫...", "wǒ jiào...",
                getResources().getIdentifier("my_name_is", "raw", packageName)));
        greetings.add(new Word(getResources().getString(R.string.nice_to_meet_you_greeting), "很高兴认识你", "hěn gāo xìng rèn shí nǐ",
                getResources().getIdentifier("nice_to_meet_you", "raw", packageName)));
        greetings.add(new Word(getResources().getString(R.string.goodbye_greeting), "再见", "zài jiàno",
                getResources().getIdentifier("goodbye", "raw", packageName)));
        greetings.add(new Word(getResources().getString(R.string.speak_eng_question_greeting), "你会说英语吗", "nǐ huì shuō yīng yǔ ma",
                getResources().getIdentifier("speak_eng_question", "raw", packageName)));
        greetings.add(new Word(getResources().getString(R.string.yes_speak_eng_greeting), "会，我会说英语", "huì，wǒ huì shuō yīng yǔ",
                getResources().getIdentifier("yes_speak_eng", "raw", packageName)));
        greetings.add(new Word(getResources().getString(R.string.no_speak_eng_greeting), "不会， 我不会说英语", "bú huì, wǒ bú huì shuō yīng yǔ",
                getResources().getIdentifier("no_speak_eng", "raw", packageName)));

    }
}
