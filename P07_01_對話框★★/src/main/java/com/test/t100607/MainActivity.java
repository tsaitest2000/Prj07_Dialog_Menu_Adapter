package com.test.t100607;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   TextView mTextView;
   int intSelected = -1; // 商業邏輯之用
   boolean chk[] = new boolean[4]; // 商業邏輯之用

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      mTextView = (TextView) findViewById(R.id.textView);
   }

   public void click1(View v) {
      AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
      builder.setTitle("這是對話框");
      builder.setMessage("這是對話框的內容");
      builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
         @Override
         public void onClick(DialogInterface dialog, int which) {

         }
      });
      builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
         @Override
         public void onClick(DialogInterface dialog, int which) {

         }
      });
      builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
         @Override
         public void onClick(DialogInterface dialog, int which) {

         }
      });
      builder.show();
   }

   public void click2(View v) {
      AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
      builder.setTitle("這是對話框");
      final EditText editText = new EditText(MainActivity.this);
      builder.setView(editText);
      builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
         @Override
         public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(MainActivity.this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
         }
      });
      builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
         @Override
         public void onClick(DialogInterface dialog, int which) {

         }
      });
      builder.show();
   }

   // 商業邏輯：按下按鈕時需自動選定上次選擇的項目
   public void click3(View v) {
      AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
      builder.setTitle("這是對話框");
      final String fruits[] = {"蘋果", "香蕉", "檸檬", "芭樂"};
      builder.setSingleChoiceItems(fruits, intSelected, new DialogInterface.OnClickListener() {
         @Override
         public void onClick(DialogInterface dialog, int which) {
            intSelected = which;
            mTextView.setText(fruits[which]);
            dialog.dismiss();
         }
      });
      builder.show();
   }

   public void click4(View v) {
      AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
      builder.setTitle("這是對話框");
      final String fruits[] = {"蘋果", "香蕉", "檸檬", "芭樂"};
      builder.setItems(fruits, new DialogInterface.OnClickListener() {
         @Override
         public void onClick(DialogInterface dialog, int which) {
            mTextView.setText(fruits[which]);
            dialog.dismiss();
         }
      });
      builder.show();
   }

   // 商業邏輯：按下按鈕時需自動選定上次選擇的項目
   public void click5(View v) {
      AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
      builder.setTitle("這是對話框");
      final String drinks[] = {"汽水", "可樂", "果汁", "紅茶"};
      final boolean tmp[] = chk.clone(); // ★★★
      builder.setMultiChoiceItems(drinks, chk, new DialogInterface.OnMultiChoiceClickListener() {
         @Override
         public void onClick(DialogInterface dialog, int which, boolean isChecked) {

         }
      });
      builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
         @Override
         public void onClick(DialogInterface dialog, int which) {
            String message = "";
            for (int i = 0; i < chk.length; i++) {
               if (chk[i] == true) {
                  message = message + drinks[i] + " ";
               }
            }
            mTextView.setText(message);
         }
      });
      builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
         @Override
         public void onClick(DialogInterface dialog, int which) {
            chk = tmp;
         }
      });
      builder.show();
   }

   public void click6(View v) {
      AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
      builder.setTitle("這是自訂對話框");
      LayoutInflater inflater = getLayoutInflater();
      View myView = inflater.inflate(R.layout.mydialog, null);
      Button btn = (Button) myView.findViewById(R.id.button6);
      final TextView tv2 = (TextView) myView.findViewById(R.id.textView2);
      btn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            tv2.setText("Hello Hello");
         }
      });
      builder.setView(myView);
      builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
         @Override
         public void onClick(DialogInterface dialog, int which) {
         }
      });
      builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
         @Override
         public void onClick(DialogInterface dialog, int which) {
         }
      });

      builder.show();
   }

   public void click7(View v) {
      final ProgressDialog pd = new ProgressDialog(MainActivity.this);
      pd.setTitle("運作中..");
      pd.setMessage("請稍後 ....");
      pd.setCancelable(false);
      pd.show();
      new Thread() {
         @Override
         public void run() {
            super.run();
            try {
               Thread.sleep(3000);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
            runOnUiThread(new Runnable() {
               @Override
               public void run() {
                  pd.dismiss();
               }
            });
         }
      }.start();
   }

}
