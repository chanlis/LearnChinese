package com.example.android.learnchinese;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        // list of words for colors
        ArrayList<Word> colors = new ArrayList<Word>();
        initColors(colors);

        WordAdapter adapter = new WordAdapter(this, colors);
        ListView listView = (ListView) findViewById(R.id.colors_list);
        listView.setAdapter(adapter);

    }

    private final void initColors(ArrayList<Word> colors)
    {
        String packageName = this.getPackageName();
        colors.add(new Word(getResources().getString(R.string.white_color), "白色", "bái sè",
                getResources().getIdentifier("white", "raw", packageName)));
        colors.add(new Word(getResources().getString(R.string.black_color), "黑色", "hēi sè",
                getResources().getIdentifier("black", "raw", packageName)));
        colors.add(new Word(getResources().getString(R.string.red_color), "红色", "hóng sè",
                getResources().getIdentifier("red", "raw", packageName)));
        colors.add(new Word(getResources().getString(R.string.yellow_color), "黄色", "huáng sè",
                getResources().getIdentifier("yellow", "raw", packageName)));
        colors.add(new Word(getResources().getString(R.string.green_color), "绿色", "lǜ sè",
                getResources().getIdentifier("green", "raw", packageName)));
        colors.add(new Word(getResources().getString(R.string.blue_color), "蓝色", "lán sè",
                getResources().getIdentifier("blue", "raw", packageName)));
        colors.add(new Word(getResources().getString(R.string.brown_color), "褐色", "hé sè",
                getResources().getIdentifier("brown", "raw", packageName)));
        colors.add(new Word(getResources().getString(R.string.orange_color), "橙色", "chéng sè",
                getResources().getIdentifier("orange", "raw", packageName)));
        colors.add(new Word(getResources().getString(R.string.grey_color), "灰色", "huī sè",
                getResources().getIdentifier("grey", "raw", packageName)));
        colors.add(new Word(getResources().getString(R.string.pink_color), "粉红色色", "fěn hóng sè",
                getResources().getIdentifier("pink", "raw", packageName)));
        colors.add(new Word(getResources().getString(R.string.purple_color), "紫色", "zǐ sè",
                getResources().getIdentifier("purple", "raw", packageName)));
    }

}
