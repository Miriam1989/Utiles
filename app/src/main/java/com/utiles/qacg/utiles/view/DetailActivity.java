package com.utiles.qacg.utiles.view;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

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

    //</editor-fold>

    //<editor-fold des=" * * * * *  S E R V I C E S  A N D  C A L L B A C K S  * * * * * ">
    //</editor-fold>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        recoverIntentValue();
        initElements();
        setElementToView();

    }

    //<editor-fold des=" * * * * * R E C O V E R   V A L U E   I N T E N T   * * * * * ">
    private void recoverIntentValue() {
        id = (Long) getIntent().getLongExtra("idUtil", 0);
        id.toString();
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

        tiet_name.setText(utiles.getName().toString());
        tiet_size.setText(utiles.getSizeUtils().toString());
        tiet_brand.setText(utiles.getBrand().toString());
        tiet_color.setText(utiles.getColor().toString());
        tiet_price.setText(utiles.getPrice().toString());

    }


    //<editor-fold des=" * * * * *  O N   C L I C K  E L E M E N T S  * * * * * ">
    //</editor-fold>

    //<editor-fold des=" * * * * *  M E N U   E L E M E N T S  * * * * * ">
    //</editor-fold>

    //<editor-fold des=" * * * * *  E V E N T     V I E W  * * * * * ">
    //</editor-fold>

    //<editor-fold des=" * * * * *  L I F E C Y C L E  * * * * * ">
    //</editor-fold>

}


