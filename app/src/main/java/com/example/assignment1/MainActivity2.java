package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        MathBook[] books = new MathBook[3];
        books[0] = new MathBook("addition");
        books[1] = new MathBook("subtract");
        books[2] = new MathBook("multiplication");

        // Book book = new Book("Professional C#", "Samer");

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String booksString = gson.toJson(books);

        editor.putString("123", booksString);
        editor.commit();
        Toast.makeText(this, "Data Saved:\n" + booksString,
                Toast.LENGTH_SHORT).show();


        String str = prefs.getString("123", "");
        MathBook[] book = gson.fromJson(str, MathBook[].class);

        Toast.makeText(this, "number of books" + books.length
                , Toast.LENGTH_SHORT).show();


        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) RecyclerView recycler = findViewById(R.id.pizza_recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
       // CaptionedImagesAdapter adapterr = new CaptionedImagesAdapter();
       // recycler.setAdapter(adapterr);


        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Spinner spinner = findViewById(R.id.spnTypes);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView s1 = findViewById(R.id.s1);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView s = findViewById(R.id.s);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView gg = findViewById(R.id.gg);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView bv = findViewById(R.id.bv);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView hb = findViewById(R.id.hb);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView bh = findViewById(R.id.bh);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView A = findViewById(R.id.A);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button text = findViewById(R.id.text);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView im = findViewById(R.id.im);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView m = findViewById(R.id.m);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView bnv = findViewById(R.id.bnv);


        // s1.setVisibility(View.INVISIBLE);
        //s1.setVisibility(android.view.View.GONE);

        //s.setVisibility(View.INVISIBLE);
        //s.setVisibility(android.view.View.GONE);

        //gg.setVisibility(View.INVISIBLE);
        //gg.setVisibility(android.view.View.GONE);

        //ss.setVisibility(View.INVISIBLE);
        //ss.setVisibility(android.view.View.GONE);


        // im.setVisibility(View.INVISIBLE);
        // im.setVisibility(android.view.View.GONE);


      /*  MathData bookDa=new MathData();
        String [] types = bookDa.getBookTypesSpinner();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, types);
        spinner.setAdapter(adapter); // set the adapter to the spinner in the xml file*/
        ArrayAdapter<MathBook> adapter = new ArrayAdapter<MathBook>(this, android.R.layout.simple_spinner_item, book);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


       spinner.setAdapter(adapter);









        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override


            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String item = parentView.getItemAtPosition(position).toString();
                if(item.equals("MathBook{operation='multiplication'}")){
                    text.setOnClickListener(new View.OnClickListener()

                    {
                        @Override
                        public void onClick (View view){

                            s.setText("multiplication is a method of finding the product of two or more numbers. It is one of the basic arithmetic operations, that we use in everyday life");

                            gg.setText(" *These are solving exercises on multiplication");
                            im.setImageResource(R.drawable.d);
                            m.setImageResource(R.drawable.c);
                            //bnv.setText("  *Here are tests for the multiplication process");
                            // editText.setText(editText.getText() + "");

                        }
                    });
                }

                else   if(item.equals("MathBook{operation='addition'}")) {

                    text.setOnClickListener(new View.OnClickListener()

                    {
                        @Override
                        public void onClick (View view){

                            s.setText(" Addition in math is a process of combining two or more numbers. Addends are the numbers being added, and the result or the final answer we get after the process is called the sum.");

                            gg.setText("  *These are solving exercises on addition");
                            // bnv.setText("   *Here are tests for the Addition process");
                            // editText.setText(editText.getText() + "");

                        }
                    });

                }

                else   if(item.equals("MathBook{operation='subtract'}")) {

                    text.setOnClickListener(new View.OnClickListener()

                    {
                        @Override
                        public void onClick (View view){

                            s.setText(" The operation or process of finding the difference between two numbers or quantities is known as subtraction. ");
                            im.setImageResource(R.drawable.subt);
                            m.setImageResource(R.drawable.subb);
                            gg.setText("  *These are solving exercises on subtraction");
                            bnv.setText("   *Here are tests for the subtraction process");
                            // editText.setText(editText.getText() + "");

                        }
                    });

                }



                // your code here
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });


        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) CheckBox CheckBox1 = (CheckBox) findViewById(R.id.checkbox1);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) CheckBox CheckBox5 = (CheckBox) findViewById(R.id.checkbox5);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) CheckBox CheckBox7 = (CheckBox) findViewById(R.id.checkbox7);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) CheckBox CheckBox9 = (CheckBox) findViewById(R.id.checkbox9);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) CheckBox CheckBox8 = (CheckBox) findViewById(R.id.checkbox8);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) CheckBox CheckBox3 = (CheckBox) findViewById(R.id.checkbox3);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) CheckBox CheckBox24 = (CheckBox) findViewById(R.id.checkbox24);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) CheckBox CheckBox50 = (CheckBox) findViewById(R.id.checkbox50);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) CheckBox CheckBox48 = (CheckBox) findViewById(R.id.checkbox48);




        CheckBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                                 @Override
                                                 public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                                                     hb.setText("Sorry your answer is wrong");

                                                 }
                                             }
        );

        CheckBox7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                                 @Override
                                                 public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {

                                                     hb.setText("Sorry your answer is wrong");

                                                 }
                                             }
        );

        CheckBox5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                                 @Override
                                                 public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {

                                                     hb.setText("Your answer is correct");

                                                 }
                                             }
        );

        CheckBox8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                                 @Override
                                                 public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                                                     bh.setText("Sorry your answer is wrong");

                                                 }
                                             }
        );

        CheckBox9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                                 @Override
                                                 public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {

                                                     bh.setText("Sorry your answer is wrong");

                                                 }
                                             }
        );

        CheckBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                                 @Override
                                                 public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {

                                                     bh.setText("Your answer is correct");

                                                 }
                                             }
        );

        CheckBox24.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                                  @Override
                                                  public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                                                      A.setText("Sorry your answer is wrong");

                                                  }
                                              }
        );

        CheckBox48.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                                  @Override
                                                  public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                                                      A.setText("Your answer is correct");



                                                  }
                                              }
        );

        CheckBox50.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                                  @Override
                                                  public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                                                      A.setText("Sorry your answer is wrong");

                                                  }
                                              }
        );









// displayed text of the check box

    }


}


      /*  spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
            // your code here
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }


//

       */



