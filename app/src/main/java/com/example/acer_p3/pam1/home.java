package com.example.acer_p3.pam1;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class home extends ActionBarActivity implements TextToSpeech.OnInitListener {

    TextToSpeech TTS;
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private String[] Greetings = {"Good Morning", "Good Afternoon", "Good Evening", "Good Night", "Good Bye"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TTS = new TextToSpeech(home.this, home.this);
        listView = (ListView) findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Greetings);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TTS.speak(((TextView) view).getText().toString(), TextToSpeech.QUEUE_ADD, null);
                if (((TextView) view).getText().toString().equals("Good Morning")) {
                    Toast.makeText(home.this, "Selamat Pagi dalam Bahasa Inggris", Toast.LENGTH_SHORT).show();
                } else if (((TextView) view).getText().toString().equals("Good Afternoon")) {
                    Toast.makeText(home.this, "Selamat Siang dalam Bahasa Inggris", Toast.LENGTH_SHORT).show();
                } else if (((TextView) view).getText().toString().equals("Good Evening")) {
                    Toast.makeText(home.this, "Selamat Sore dalam Bahasa Inggris", Toast.LENGTH_SHORT).show();
                } else if (((TextView) view).getText().toString().equals("Good Night")) {
                    Toast.makeText(home.this, "Selamat Malam dalam Bahasa Inggris", Toast.LENGTH_SHORT).show();
                } else if (((TextView) view).getText().toString().equals("Good Bye")) {
                    Toast.makeText(home.this, "Selamat Tinggal dalam Bahasa Inggris", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onInit(int status) {

    }
}
