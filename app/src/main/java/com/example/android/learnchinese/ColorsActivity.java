package com.example.android.learnchinese;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        // list of words for colors
        final ArrayList<Word> colors = new ArrayList<Word>();
        initColors(colors);

        // init list view
        WordAdapter adapter = new WordAdapter(this, colors);
        ListView listView = (ListView) findViewById(R.id.words_list);
        listView.setAdapter(adapter);

    }

    private void initColors(ArrayList<Word> colors)
    {
        String packageName = this.getPackageName();
        colors.add(new Word(getString(R.string.white_color), "白色", "bái sè",
                R.raw.white));
        colors.add(new Word(getString(R.string.black_color), "黑色", "hēi sè",
                R.raw.black)));
        colors.add(new Word(getString(R.string.red_color), "红色", "hóng sè",
                R.raw.red)));
        colors.add(new Word(getString(R.string.yellow_color), "黄色", "huáng sè",
                R.raw.yellow)));
        colors.add(new Word(getString(R.string.green_color), "绿色", "lǜ sè",
                R.raw.green)));
        colors.add(new Word(getString(R.string.blue_color), "蓝色", "lán sè",
                R.raw.blue)));
        colors.add(new Word(getString(R.string.brown_color), "褐色", "hé sè",
                R.raw.brown)));
        colors.add(new Word(getString(R.string.orange_color), "橙色", "chéng sè",
                R.raw.orange)));
        colors.add(new Word(getString(R.string.grey_color), "灰色", "huī sè",
                R.raw.grey)));
        colors.add(new Word(getString(R.string.pink_color), "粉红色色", "fěn hóng sè",
                R.raw.pink)));
        colors.add(new Word(getString(R.string.purple_color), "紫色", "zǐ sè",
                R.raw.purple)));
    }

}
