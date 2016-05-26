package com.oc.rss.jeuxde;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by combo on 25/05/16.
 */
public class RetiredplayersActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retiredplayers);

        setTitle("Retired players");

        final RecyclerView rv = (RecyclerView) findViewById(R.id.list);

        rv.setLayoutManager(new LinearLayoutManager(this)); // LayoutManager gère le mode d'affichage du contenu, ici mode lineaire
        rv.setAdapter(new MyAdapter()); // setAdapter s'occupe du contenu
    }
}
