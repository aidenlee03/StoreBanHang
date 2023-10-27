package com.example.storebanhang.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.storebanhang.R;
import com.example.storebanhang.Retrofit.ApiBanHang;
import com.example.storebanhang.Retrofit.RetrofitClient;
import com.example.storebanhang.Utils.Utils;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class XemDonActivity extends AppCompatActivity {
    CompositeDisposable compositeDisposable= new CompositeDisposable();
    ApiBanHang apiBanHang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_don);
        apiBanHang= RetrofitClient.getInstance(Utils.BASE_URL).create(ApiBanHang.class);
        compositeDisposable.add(apiBanHang.xemDonHang(Utils.user_current.getId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        donHangModel -> {
                            Toast.makeText(getApplicationContext(),donHangModel.getResult().get(0).getItem().get(1).getTensp(),Toast.LENGTH_LONG).show();
                        },
                        throwable ->{
                            Toast.makeText(getApplicationContext(),"lỗi",Toast.LENGTH_LONG).show();
                        }
                ));

    }
}