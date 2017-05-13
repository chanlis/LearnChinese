package com.example.android.learnchinese;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by lisachan on 5/10/17.
 */

public class FoodsActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        final ArrayList<Word> foods = new ArrayList<Word>();
        initFoods(foods);

        WordAdapter adapter = new WordAdapter(this, foods);
        ListView listView = (ListView) findViewById(R.id.words_list);
        listView.setAdapter(adapter);
    }

    private void initFoods(ArrayList<Word> foods)
    {
        foods.add(new Word(getString(R.string.hungry_foods), "饿", "è",
                R.raw.hungry));
        foods.add(new Word(getString(R.string.thirsty_food), "渴", "kě",
                R.raw.thirsty));
        foods.add(new Word(getString(R.string.eaten_enough_food), "有足够的食物", "yǒu zú gòu de shí wù",
                R.raw.eaten_enough));
        foods.add(new Word(getString(R.string.breakfast_food), "早餐", "zǎo cān",
                R.raw.breakfast));
        foods.add(new Word(getString(R.string.lunch_food), "午餐", "wǔ cān",
                R.raw.lunch));
        foods.add(new Word(getString(R.string.dinner_food), "晚餐", "wǎn cān",
                R.raw.dinner));
        foods.add(new Word(getString(R.string.bread_food), "面包", "miàn bāo",
                R.raw.bread));
        foods.add(new Word(getString(R.string.meat_food), "肉", "ròu",
                R.raw.meat));
        foods.add(new Word(getString(R.string.soup_food), "汤", "tāng",
                R.raw.soup));
        foods.add(new Word(getString(R.string.fruit_food), "水果", "shuǐ guǒ",
                R.raw.fruit));
        foods.add(new Word(getString(R.string.salad_food), "沙拉", "shā lā",
                R.raw.salad));
        foods.add(new Word(getString(R.string.tea_food), "茶", "chá",
                R.raw.tea));
        foods.add(new Word(getString(R.string.coffee_food), "咖啡", "kā fēi",
                R.raw.coffee));
        foods.add(new Word(getString(R.string.french_fries_food), "薯条", "shǔ tiáo",
                R.raw.french_fries));
        foods.add(new Word(getString(R.string.sausage_food), "香肠", "xiāng cháng",
                R.raw.sausage));
        foods.add(new Word(getString(R.string.cake_food), "蛋糕", "dàn gāo",
                R.raw.cake));
        foods.add(new Word(getString(R.string.cheese_food), "乳酪", "rǔ lào",
                R.raw.cheese));
        foods.add(new Word(getString(R.string.apple_food), "苹果", "píng guǒ",
                R.raw.apple));
        foods.add(new Word(getString(R.string.orange_food), "橙", "chéng",
                R.raw.orange));
        foods.add(new Word(getString(R.string.banana_food), "香蕉", "xiāng jiāo",
                R.raw.banana));
        foods.add(new Word(getString(R.string.sugar_food), "糖", "táng",
                R.raw.sugar));
        foods.add(new Word(getString(R.string.salt_food), "盐", "yán",
                R.raw.salt));
        foods.add(new Word(getString(R.string.pepper_food), "胡椒粉", "hú jiāo fěn",
                R.raw.pepper));

    }
}
