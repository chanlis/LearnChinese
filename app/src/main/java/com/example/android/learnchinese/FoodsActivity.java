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

        ArrayList<Word> foods = new ArrayList<Word>();
        initFoods(foods);

        WordAdapter adapter = new WordAdapter(this, foods);
        ListView listView = (ListView) findViewById(R.id.words_list);
        listView.setAdapter(adapter);
    }

    private final void initFoods(ArrayList<Word> foods)
    {
        String packageName = getPackageName();
        foods.add(new Word(getResources().getString(R.string.hungry_foods), "饿", "è",
                getResources().getIdentifier("hungry", "raw", packageName)));
        foods.add(new Word(getResources().getString(R.string.thirsty_food), "渴", "kě",
                getResources().getIdentifier("thirsty", "raw", packageName)));
        foods.add(new Word(getResources().getString(R.string.eaten_enough_food), "有足够的食物", "yǒu zú gòu de shí wù",
                getResources().getIdentifier("eaten_enough", "raw", packageName)));
        foods.add(new Word(getResources().getString(R.string.breakfast_food), "早餐", "zǎo cān",
                getResources().getIdentifier("breakfast", "raw", packageName)));
        foods.add(new Word(getResources().getString(R.string.lunch_food), "午餐", "wǔ cān",
                getResources().getIdentifier("lunch", "raw", packageName)));
        foods.add(new Word(getResources().getString(R.string.dinner_food), "晚餐", "wǎn cān",
                getResources().getIdentifier("dinner", "raw", packageName)));
        foods.add(new Word(getResources().getString(R.string.bread_food), "面包", "miàn bāo",
                getResources().getIdentifier("bread", "raw", packageName)));
        foods.add(new Word(getResources().getString(R.string.meat_food), "肉", "ròu",
                getResources().getIdentifier("meat", "raw", packageName)));
        foods.add(new Word(getResources().getString(R.string.soup_food), "汤", "tāng",
                getResources().getIdentifier("soup", "raw", packageName)));
        foods.add(new Word(getResources().getString(R.string.fruit_food), "水果", "shuǐ guǒ",
                getResources().getIdentifier("fruit", "raw", packageName)));
        foods.add(new Word(getResources().getString(R.string.salad_food), "沙拉", "shā lā",
                getResources().getIdentifier("salad", "raw", packageName)));
        foods.add(new Word(getResources().getString(R.string.tea_food), "茶", "chá",
                getResources().getIdentifier("tea", "raw", packageName)));
        foods.add(new Word(getResources().getString(R.string.coffee_food), "咖啡", "kā fēi",
                getResources().getIdentifier("coffee", "raw", packageName)));
        foods.add(new Word(getResources().getString(R.string.french_fries_food), "薯条", "shǔ tiáo",
                getResources().getIdentifier("french_fries", "raw", packageName)));
        foods.add(new Word(getResources().getString(R.string.sausage_food), "香肠", "xiāng cháng",
                getResources().getIdentifier("sausage", "raw", packageName)));
        foods.add(new Word(getResources().getString(R.string.cake_food), "蛋糕", "dàn gāo",
                getResources().getIdentifier("cake", "raw", packageName)));
        foods.add(new Word(getResources().getString(R.string.cheese_food), "乳酪", "rǔ lào",
                getResources().getIdentifier("cheese", "raw", packageName)));
        foods.add(new Word(getResources().getString(R.string.apple_food), "苹果", "píng guǒ",
                getResources().getIdentifier("apple", "raw", packageName)));
        foods.add(new Word(getResources().getString(R.string.orange_food), "橙", "chéng",
                getResources().getIdentifier("orange", "raw", packageName)));
        foods.add(new Word(getResources().getString(R.string.banana_food), "香蕉", "xiāng jiāo",
                getResources().getIdentifier("banana", "raw", packageName)));
        foods.add(new Word(getResources().getString(R.string.sugar_food), "糖", "táng",
                getResources().getIdentifier("sugar", "raw", packageName)));
        foods.add(new Word(getResources().getString(R.string.salt_food), "盐", "yán",
                getResources().getIdentifier("salt", "raw", packageName)));
        foods.add(new Word(getResources().getString(R.string.pepper_food), "胡椒粉", "hú jiāo fěn",
                getResources().getIdentifier("pepper", "raw", packageName)));

    }
}
