package com.example.language_demo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import org.greenrobot.eventbus.EventBus;


public class SettingAc extends BaseAc {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.set_activity));
        final String[] cities = {getString(R.string.lan_chinese), getString(R.string.lan_en), getString(R.string.lan_ja), getString(R.string.lan_de),getString(R.string.alaboyu)};
        final String[] locals = {"zh_CN", "en", "ja", "de","ar"};
        Button button = (Button) findViewById(R.id.btn_setting);
        button.setText(R.string.language_set);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SettingAc.this);
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setTitle(R.string.select_language);
                builder.setItems(cities, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Store.setLanguageLocal(SettingAc.this, locals[which]);
                        EventBus.getDefault().post("EVENT_REFRESH_LANGUAGE");
                    }
                });
                builder.show();
            }
        });
    }
}
