package avi.singh.externalinternalmemoryread;

import android.media.MediaPlayer;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    String items[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.listView);
        ArrayList<File> mySongs = findSongs(Environment.getExternalStorageDirectory());






        items = new String[mySongs.size()];

        for(int i =0 ; i<mySongs.size(); i++)
        {
           // Toast(mySongs.get(i).getName().toString());
            items[i] = mySongs.get(i).getName().toString().replace(".mp3","").replace("190Kbps","").replace("320Kbps","");
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.list_view_layout,R.id.tv,items);
        lv.setAdapter(arrayAdapter);



    }





        public ArrayList<File> findSongs(File root) {

            ArrayList<File> arrayList = new ArrayList<>();

            File[] files = root.listFiles();
            for (File singleFile : files) {
                if (singleFile.isDirectory()) {
                    arrayList.addAll(findSongs(singleFile));
                } else {
                    if (singleFile.getName().endsWith(".mp3")) {
                        arrayList.add(singleFile);
                    }

                }
            }
            return arrayList;
        }





}
