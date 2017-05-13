package com.example.android.learnchinese;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        // Create a list of words
        final ArrayList<Word> numbers = new ArrayList<Word>();
        initNumbers(numbers);

        WordAdapter adapter = new WordAdapter(this, numbers);
        ListView listView = (ListView) findViewById(R.id.words_list);
        listView.setAdapter(adapter);
    }

    private void initNumbers(ArrayList<Word> numbers)
    {
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
