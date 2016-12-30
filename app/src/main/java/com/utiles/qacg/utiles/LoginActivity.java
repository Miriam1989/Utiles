package com.utiles.qacg.utiles;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.utiles.qacg.utiles.interfaces.LoginCallbacks;
import com.utiles.qacg.utiles.services.LoginServices;
import com.utiles.qacg.utiles.view.ListUserActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginCallbacks {

    //<editor-fold des=" * * * * *  U I    R E F E R E N C E S  * * * * * ">
    private TextInputEditText tiet_user;
    private TextInputEditText tiet_pass;
    private Button btn_enter;
    private TextInputEditText tiet_school;
    //</editor-fold>

    //<editor-fold des=" * * * * *  I N T E R N A L   V A R I A B L E S  * * * * * ">
    //</editor-fold>

    //<editor-fold des=" * * * * *  S E R V I C E S  A N D  C A L L B A C K S  * * * * * ">
    private LoginServices loginServices;
    private LoginCallbacks mLoginCallbacks;
    //</editor-fold>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeServicesAndCallback();
        initElement();
    }

    //<editor-fold des=" * * * * *  I N I T   E L E M E N T S  * * * * * ">
    private void initializeServicesAndCallback() {
        mLoginCallbacks=this;
        loginServices=new LoginServices(this,mLoginCallbacks);

    }
    private void initElement() {
        tiet_user = (TextInputEditText) findViewById(R.id.username);
        tiet_pass = (TextInputEditText) findViewById(R.id.password);
        btn_enter = (Button) findViewById(R.id.buttonLogin);
        tiet_school=(TextInputEditText) findViewById(R.id.text_school);
        btn_enter.setOnClickListener(this);

    }
    //</editor-fold>


    //<editor-fold des=" * * * * *  O N   C L I C K  E L E M E N T S  * * * * * ">
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonLogin:
                loginServices.validarCampos(tiet_user,tiet_pass,tiet_school);
                break;
        }
    }

    //</editor-fold>

    //<editor-fold des=" * * * * *  M E N U   E L E M E N T S  * * * * * ">

    //</editor-fold>

    //<editor-fold des=" * * * * *  E V E N T     V I E W  * * * * * ">

    @Override
    public void callIntent(String user) {
        Intent intent = new Intent(this, ListUserActivity.class);
        intent.putExtra("parametro",user);
        startActivity(intent);
    }

    @Override
    public void showToast(String message, int duration) {
        if (duration == 0) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else if (duration == 1) {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }
    //</editor-fold>

    //<editor-fold des=" * * * * *  L I F E C Y C L E  * * * * * ">

    //</editor-fold>
}
