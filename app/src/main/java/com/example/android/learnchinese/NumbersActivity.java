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
        ArrayList<Word> numbers = new ArrayList<Word>();
        initNumbers(numbers);

        WordAdapter adapter = new WordAdapter(this, numbers);
        ListView listView = (ListView) findViewById(R.id.words_list);
        listView.setAdapter(adapter);
    }

    private final void initNumbers(ArrayList<Word> numbers)
    {
        String packageName = getPackageName();
        numbers.add(new Word(getResources().getString(R.string.one_numbers), "一", "yī",
                getResources().getIdentifier("one", "raw", packageName)));
        numbers.add(new Word(getResources().getString(R.string.two_numbers), "二", "èr",
                getResources().getIdentifier("two", "raw", packageName)));
        numbers.add(new Word(getResources().getString(R.string.three_numbers), "三", "sān",
                getResources().getIdentifier("three", "raw", packageName)));
        numbers.add(new Word(getResources().getString(R.string.four_numbers), "四", "sì",
                getResources().getIdentifier("four", "raw", packageName)));
        numbers.add(new Word(getResources().getString(R.string.five_numbers), "五", "wǔ",
                getResources().getIdentifier("five", "raw", packageName)));
        numbers.add(new Word(getResources().getString(R.string.six_numbers), "六", "liù",
                getResources().getIdentifier("six", "raw", packageName)));
        numbers.add(new Word(getResources().getString(R.string.seven_numbers), "七", "qī",
                getResources().getIdentifier("seven", "raw", packageName)));
        numbers.add(new Word(getResources().getString(R.string.eight_numbers), "八", "bā",
                getResources().getIdentifier("eight", "raw", packageName)));
        numbers.add(new Word(getResources().getString(R.string.nine_numbers), "九", "jiǔ",
                getResources().getIdentifier("nine", "raw", packageName)));
        numbers.add(new Word(getResources().getString(R.string.ten_numbers), "十", "shí",
                getResources().getIdentifier("ten", "raw", packageName)));

    }
}
