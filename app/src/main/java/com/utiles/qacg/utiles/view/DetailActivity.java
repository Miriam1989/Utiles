package com.utiles.qacg.utiles.view;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.orm.query.Condition;
import com.orm.query.Select;
import com.utiles.qacg.utiles.R;
import com.utiles.qacg.utiles.adapter.UtilsAdapter;
import com.utiles.qacg.utiles.interfaces.ListUserCallBacks;
import com.utiles.qacg.utiles.models.Utiles;
import com.utiles.qacg.utiles.services.InitBDServices;

import java.util.List;

public class DetailActivity extends AppCompatActivity {
    //<editor-fold des=" * * * * *  U I    R E F E R E N C E S  * * * * * ">
    private TextInputEditText tiet_name;
    private TextInputEditText tiet_size;
    private TextInputEditText tiet_color;
    private TextInputEditText tiet_brand;
    private TextInputEditText tiet_price;
    //</editor-fold>

    //<editor-fold des=" * * * * *  I N T E R N A L   V A R I A B L E S  * * * * * ">
    private Long id;
    private boolean isNewUtils;

    //</editor-fold>

    //<editor-fold des=" * * * * *  S E R V I C E S  A N D  C A L L B A C K S  * * * * * ">
    //</editor-fold>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initElements();
        recoverIntentValue();


    }

    //<editor-fold des=" * * * * * R E C O V E R   V A L U E   I N T E N T   * * * * * ">

    //TODO: #1 Identificar de donde proviene la llamada identificandolo por medio del intent
    private void recoverIntentValue() {
        id = (Long) getIntent().getLongExtra("idUtil", 0);

        if (id != 0) {
            isNewUtils = false;
            setElementToView();
        } else {
            initElementsForNewUtils();
        }

    }


    //</editor-fold>

    //<editor-fold des=" * * * * *  I N I T   E L E M E N T S  * * * * * ">
    private void initElements() {
        tiet_name = (TextInputEditText) findViewById(R.id.tiet_name);
        tiet_size = (TextInputEditText) findViewById(R.id.tiet_size);
        tiet_color = (TextInputEditText) findViewById(R.id.tiet_color);
        tiet_brand = (TextInputEditText) findViewById(R.id.tiet_brand);
        tiet_price = (TextInputEditText) findViewById(R.id.tiet_price);
    }
    //</editor-fold>

    public void setElementToView() {

        Utiles utiles = Select.from(Utiles.class)
                .where(Condition.prop("ID")
                        .eq(id))
                .first();
        if (utiles.getName() != null) {
            tiet_name.setText(utiles.getName().toString());
        }
        if (utiles.getSizeUtils() != null) {
            tiet_size.setText(utiles.getSizeUtils().toString());
        }
        //otro tipo de condicion si es vacio me regresa un "TRUE" entonces negamos con "!"
        if (!TextUtils.isEmpty(utiles.getBrand())) {
            tiet_brand.setText(utiles.getBrand().toString());
        }

        if (utiles.getColor() != null) {
            tiet_color.setText(utiles.getColor().toString());
        }
        if (utiles.getPrice() != null) {
            tiet_price.setText(utiles.getPrice().toString());
        }


        insetKeylistenerNull();

    }


    //<editor-fold des=" * * * * *  O N   C L I C K  E L E M E N T S  * * * * * ">

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save:
                checkFilds();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    //</editor-fold>

    //<editor-fold des=" * * * * *  M E N U   E L E M E N T S  * * * * * ">

    //TODO  se agrega la actionBar y el icono de guardar en el XML new_utils
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.new_utils, menu);
        MenuItem itemSave = menu.findItem(R.id.save);
        if (isNewUtils) {
            itemSave.setVisible(true);
        } else {
            itemSave.setVisible(false);
        }

        return true;
    }
    //</editor-fold>

    //<editor-fold des=" * * * * *  E V E N T     V I E W  * * * * * ">

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    //</editor-fold>

    //<editor-fold des=" * * * * *  L I F E C Y C L E  * * * * * ">
    //</editor-fold>

    // <editor-fold des=" * * * * *  M E T H O D S * * * * * ">
    private void initElementsForNewUtils() {
        initElements();
        initButtonSave();
    }

    private void initButtonSave() {
        isNewUtils = true;
    }

    private void checkFilds() {
        if (TextUtils.isEmpty(tiet_name.getText().toString()) ||
                TextUtils.isEmpty(tiet_size.getText().toString()) ||
                TextUtils.isEmpty(tiet_color.getText().toString()) ||
                TextUtils.isEmpty(tiet_brand.getText().toString()) ||
                TextUtils.isEmpty(tiet_price.getText().toString())
                ) {
            showToast("Debe de completar todos los campos");
        } else {
            saveUtils();
        }
    }

    private void insetKeylistenerNull() {
        tiet_name.setKeyListener(null);
        tiet_size.setKeyListener(null);
        tiet_color.setKeyListener(null);
        tiet_brand.setKeyListener(null);
        tiet_price.setKeyListener(null);
    }

    private void saveUtils() {
        Utiles newUtil = new Utiles();
        newUtil.setName(tiet_name.getText().toString());
        newUtil.setBrand(tiet_size.getText().toString());
        newUtil.setColor(tiet_color.getText().toString());
        newUtil.setPrice(Double.valueOf(tiet_price.getText().toString()));
        newUtil.setSizeUtils(tiet_size.getText().toString());
        newUtil.save();

        finalizeActivity();
    }

    private void finalizeActivity() {
        finish();
    }
    //</editor-fold>

}


