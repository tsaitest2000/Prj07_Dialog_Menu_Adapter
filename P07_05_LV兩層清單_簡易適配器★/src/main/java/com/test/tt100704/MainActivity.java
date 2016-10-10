package com.test.tt100704;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

   ListView mListView;
   ArrayList<Map<String, String>> mListCity;
   SimpleAdapter mSimpleAdapter;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      mListView = (ListView) this.findViewById(R.id.listView);
      mListCity = new ArrayList<>();

      Map<String, String> map1 = new HashMap<>();
      map1.put("city", "Taipei");
      map1.put("code", "02");
      mListCity.add(map1);

      Map<String, String> map2 = new HashMap<>();
      map2.put("city", "Taichung");
      map2.put("code", "04");
      mListCity.add(map2);

      Map<String, String> map3 = new HashMap<>();
      map3.put("city", "Tainan");
      map3.put("code", "06");
      mListCity.add(map3);

      mSimpleAdapter = new SimpleAdapter(
         MainActivity.this,
         mListCity, R.layout.myitem,
         new String[]{"city", "code"},
         new int[]{R.id.textView1, R.id.textView2}
      );

      mListView.setAdapter(mSimpleAdapter);
   }

}
