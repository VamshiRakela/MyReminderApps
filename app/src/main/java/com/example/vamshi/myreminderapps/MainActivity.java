package com.example.vamshi.myreminderapps;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {


    private DialogueExample dialogueExample;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.new_reminder:

                dialogueExample=new DialogueExample();
                FragmentManager manager;
                manager=getFragmentManager();
                dialogueExample=new DialogueExample();
                dialogueExample.show(manager,"showthedialogue");
                break;

            case R.id.action_settings:
                break;
        }
        return super.onOptionsItemSelected(item);
    }



}

