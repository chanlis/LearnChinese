/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.learnchinese;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the View that shows the respective category
        TextView numberView = (TextView) findViewById(R.id.numbers);
        TextView familyView = (TextView) findViewById(R.id.family);
        TextView colorsView = (TextView) findViewById(R.id.colors);
        TextView phrasesView = (TextView) findViewById(R.id.phrases);

        // Set a ClickListener on that View
        numberView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new Intent to open {@link NumbersActivity}
                Intent numbersIntent = new Intent (MainActivity.this, NumbersActivity.class);
                // Start Activity
                startActivity(numbersIntent);
            }
        });
        familyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent familyIntent = new Intent (MainActivity.this, FamilyActivity.class);
                startActivity(familyIntent);
            }
        });
        colorsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent colorsIntent = new Intent (MainActivity.this, ColorsActivity.class);
                startActivity(colorsIntent);
            }
        });
        phrasesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phrasesIntent = new Intent (MainActivity.this, PhrasesActivity.class);
                startActivity(phrasesIntent);
            }
        });
    }
}
