package com.example.android.learnchinese;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        ArrayList<Word> family = new ArrayList<Word>();
        initFamily(family);

        WordAdapter adapter = new WordAdapter(this, family);
        ListView listView = (ListView) findViewById(R.id.words_list);
        listView.setAdapter(adapter);
    }

    private final void initFamily(ArrayList<Word> family)
    {
        String packageName = getPackageName();
        family.add(new Word(getResources().getString(R.string.friend_family), "朋友", "péng yǒu",
                getResources().getIdentifier("friend", "raw", packageName)));
        family.add(new Word(getResources().getString(R.string.son_family), "儿子", "ér zi",
                getResources().getIdentifier("son", "raw", packageName)));
        family.add(new Word(getResources().getString(R.string.daughter_family), "女儿", "nǚ ér",
                getResources().getIdentifier("daughter", "raw", packageName)));
        family.add(new Word(getResources().getString(R.string.wife_family), "太太", "tài tài",
                getResources().getIdentifier("wife", "raw", packageName)));
        family.add(new Word(getResources().getString(R.string.husband_family), "丈夫", "zhàng fū",
                getResources().getIdentifier("husband", "raw", packageName)));
        family.add(new Word(getResources().getString(R.string.mother_family), "妈妈", "mā mā",
                getResources().getIdentifier("mother", "raw", packageName)));
        family.add(new Word(getResources().getString(R.string.father_family), "爸爸", "bà bà",
                getResources().getIdentifier("father", "raw", packageName)));
        family.add(new Word(getResources().getString(R.string.grandma_family), "奶奶", "nǎi nai",
                getResources().getIdentifier("grandma", "raw", packageName)));
        family.add(new Word(getResources().getString(R.string.grandpa_family), "爷爷", "yé ye",
                getResources().getIdentifier("grandpa", "raw", packageName)));
        family.add(new Word(getResources().getString(R.string.older_brother_family), "哥哥", "gē ge",
                getResources().getIdentifier("older_brother", "raw", packageName)));
        family.add(new Word(getResources().getString(R.string.younger_brother_family), "弟弟", "dì dì",
                getResources().getIdentifier("younger_brother", "raw", packageName)));
        family.add(new Word(getResources().getString(R.string.younger_sister_family), "妹妹", "mèi mei",
                getResources().getIdentifier("younger_sister", "raw", packageName)));
        family.add(new Word(getResources().getString(R.string.older_sister_family), "姐姐", "jiě jie",
                getResources().getIdentifier("older_sister", "raw", packageName)));

    }
}
