package com.utiles.qacg.utiles.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.orm.query.Select;
import com.utiles.qacg.utiles.R;
import com.utiles.qacg.utiles.adapter.UtilsAdapter;
import com.utiles.qacg.utiles.interfaces.ListUserCallBacks;
import com.utiles.qacg.utiles.models.Utiles;
import com.utiles.qacg.utiles.services.InitBDServices;

import java.util.List;
import java.util.Random;

public class ListUserActivity extends AppCompatActivity implements View.OnClickListener, ListUserCallBacks {

    //<editor-fold des=" * * * * *  U I    R E F E R E N C E S  * * * * * ">
    private RecyclerView rv_utils;
    //</editor-fold>

    //<editor-fold des=" * * * * *  I N T E R N A L   V A R I A B L E S  * * * * * ">
    private String userName;
    private UtilsAdapter utilsAdapter;
    private List<Utiles> listUtils;
    //</editor-fold>

    //<editor-fold des=" * * * * *  S E R V I C E S  A N D  C A L L B A C K S  * * * * * ">
    private InitBDServices initBDServices;
    private ListUserCallBacks mListUserCallback;
    //</editor-fold>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
       mListUserCallback=this;
        recoverIntentValue();
        getSupportActionBar().setTitle(userName);
        initElements();

    }

    //<editor-fold des=" * * * * * R E C O V E R   V A L U E   I N T E N T   * * * * * ">
    private void recoverIntentValue() {
        if(getIntent().getExtras()!= null) {
            userName = (String) getIntent().getExtras().get("parametro");
        }
    }

    //</editor-fold>

    //<editor-fold des=" * * * * *  I N I T   E L E M E N T S  * * * * * ">

    private void initElements() {
        rv_utils = (RecyclerView) findViewById(R.id.rv_utils);
        initBDServices = new InitBDServices();
        initBDServices.insertUtils();
        initRecyclerView();
    }

    private void initRecyclerView() {

        listUtils = Select.from(Utiles.class).list();
        utilsAdapter = new UtilsAdapter(this,listUtils,mListUserCallback);
        rv_utils.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv_utils.setItemAnimator(new DefaultItemAnimator());
        rv_utils.setHasFixedSize(true);
        rv_utils.setAdapter(utilsAdapter);

    }
    //</editor-fold>


    //<editor-fold des=" * * * * *  O N   C L I C K  E L E M E N T S  * * * * * ">
    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_random:
                showAlertDialog();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //</editor-fold>


    //<editor-fold des=" * * * * *  M E N U   E L E M E N T S  * * * * * ">
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }



    @Override
    public void callIntent(Long id) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("idUtil",id);
        startActivity(intent);
    }
    //</editor-fold>

    //<editor-fold des=" * * * * *  M E T O D O S  * * * * * ">
    public void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);




        builder.setTitle(R.string.alert_dialog_title);
        builder.setMessage(generateNumberRandom());
        builder.setPositiveButton(getString(R.string.alert_dialog_message_positive), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton(getString(R.string.alert_dialog_message_negative), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }

    public String generateNumberRandom() {

        int min = 0;
        int max = 99;

        Random r = new Random();
        int numberRandom = r.nextInt(max - min + 1) + min;
        String strNumberRandom;

        if (numberRandom >= 0 && numberRandom <= 9) {
            strNumberRandom = "0" + String.valueOf(numberRandom);
        } else {
            strNumberRandom = String.valueOf(numberRandom);
        }
        return  strNumberRandom;
    }

    //</editor-fold>

    //<editor-fold des=" * * * * *  E V E N T     V I E W  * * * * * ">
    //</editor-fold>

    //<editor-fold des=" * * * * *  L I F E C Y C L E  * * * * * ">
    //</editor-fold>
}





