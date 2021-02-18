/*
 * Copyright (C) 2012 The Android Open Source Project
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
package com.example.android.tempconversion;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

public class MainActivity extends FragmentActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_articles);
    }

    public void onArticleSelected(int position) {
        // The user selected the headline of an article from the HeadlinesFragment

        //Log.d("DEFAULT MESSAGE", String.valueOf(position));

        switch(position){
            case 0:
                CalculationFragment calculationFragment = new CalculationFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,calculationFragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;

            case 1:
                FarenheitFragment farenheitFragment = new FarenheitFragment();
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                transaction1.replace(R.id.fragment_container,farenheitFragment);
                transaction1.addToBackStack(null);
                transaction1.commit();
                break;

            case 2:
                ArticleFragment articleFrag = new ArticleFragment();
                FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                transaction2.replace(R.id.fragment_container,articleFrag);
                transaction2.addToBackStack(null);
                transaction2.commit();
                break;

            default:
                Log.d("DEFAULT MESSAGE", "IF YOU SEE THIS SOMETHING IS WRONG");

        }
    }
}