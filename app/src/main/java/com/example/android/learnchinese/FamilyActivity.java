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

        final ArrayList<Word> family = new ArrayList<Word>();
        initFamily(family);

        WordAdapter adapter = new WordAdapter(this, family);
        ListView listView = (ListView) findViewById(R.id.words_list);
        listView.setAdapter(adapter);
    }

    private void initFamily(ArrayList<Word> family)
    {
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
