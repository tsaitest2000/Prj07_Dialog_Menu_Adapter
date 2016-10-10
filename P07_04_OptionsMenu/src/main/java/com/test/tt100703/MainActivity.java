package com.test.tt100703;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      menu.add(0, 1, 0, "Test1");
      menu.add(0, 2, 0, "Test2");
      return super.onCreateOptionsMenu(menu);
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
      if (item.getItemId() == 1) {
         Toast.makeText(MainActivity.this, "Test1", Toast.LENGTH_SHORT).show();
      }
      return super.onOptionsItemSelected(item);
   }

}
