package com.example.android.learnchinese;

import android.app.Activity;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lisachan on 5/8/17.
 */

class WordAdapter extends ArrayAdapter<Word> {
    public static final String TAG = "ArrayAdapter";

    public WordAdapter(Activity context, ArrayList<Word> wordsList)
    {
        super(context, 0, wordsList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // get current word according to array position
        final Word currentWord = getItem(position);

        // set onClickListener on list item
        if(currentWord.getAudioID() >= 0) {
            listItemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    MediaPlayer audio = new MediaPlayer().create(getContext(), currentWord.getAudioID());
                    audio.start();
                }
            });
        }

        // translation view
        TextView translationTextView = (TextView) listItemView.findViewById(R.id.translation_text_view);
        translationTextView.setText(currentWord.getTranslation());

        // prounciation and word view
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.word_text_view);
        defaultTextView.setText(currentWord.getPronouciation() + "\n" + currentWord.toString());

        // return final list item view
        return listItemView;
    }
}
