package com.test.tt100702;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   Button btn; // 在按鈕上長按可呼叫出ContextMenu

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      setSupportActionBar(toolbar);

      FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
      fab.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
         }
      });

      btn = (Button) findViewById(R.id.button);
      registerForContextMenu(btn);
   }

   @Override
   public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
      menu.add("AAA");
      menu.add("BBB");
      menu.add("CCC");
      super.onCreateContextMenu(menu, v, menuInfo);
   }

   @Override
   public boolean onContextItemSelected(MenuItem item) {
      return super.onContextItemSelected(item);
   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      getMenuInflater().inflate(R.menu.menu_main, menu);
      return true;
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
      int id = item.getItemId();

      if (id == R.id.action_settings) {
         Toast.makeText(MainActivity.this, "Click Settings", Toast.LENGTH_SHORT).show();
         return true;
      }
      if (id == R.id.action_about) {
         Toast.makeText(MainActivity.this, "Click About", Toast.LENGTH_SHORT).show();
         return true;
      }
      return super.onOptionsItemSelected(item);
   }

}
