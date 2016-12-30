package com.utiles.qacg.utiles.services;

import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;

import com.utiles.qacg.utiles.R;
import com.utiles.qacg.utiles.interfaces.LoginCallbacks;

/**
 * Created by QACG on 26/12/2016.
 */

public class LoginServices {

private Context context;
private LoginCallbacks mLoginCallbacks;

    public LoginServices(Context context, LoginCallbacks mLoginCallbacks) {
        this.context = context;
        this.mLoginCallbacks = mLoginCallbacks;
    }

    public void validarCampos(TextInputEditText tiet_user, TextInputEditText tiet_pass,TextInputEditText tiet_school ) {
        if (TextUtils.isEmpty(tiet_user.getText().toString())) {
             mLoginCallbacks.showToast(context.getResources().getString(R.string.login_message_error_user),0);
        } else if (TextUtils.isEmpty(tiet_pass.getText().toString())) {
            mLoginCallbacks.showToast(context.getResources().getString(R.string.login_message_error_pass),0);
        } else if (TextUtils.isEmpty(tiet_school.getText().toString())) {
            mLoginCallbacks.showToast(context.getResources().getString(R.string.login_message_error_school), 0);
        }else {
           // mLoginCallbacks.showToast(context.getResources().getString(R.string.login_message_validate_data),1);
            mLoginCallbacks.callIntent(tiet_user.getText().toString());
        }
 /*
        if (tiet_user.getText() == null || tiet_user.getText().length() == 0) {
            return false;

        } else if (tiet_pass.getText() == null || tiet_pass.getText().length() == 0) {
            return false;

        } else {
            return true;
        }
  */
/*
        if (TextUtils.isEmpty(tiet_user.getText().toString()) && TextUtils.isEmpty(tiet_pass.getText().toString())) {
            return false;

        } else {
            return true;
        }
*/

    }
}
