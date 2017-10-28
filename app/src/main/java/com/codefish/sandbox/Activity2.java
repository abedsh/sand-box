package com.codefish.sandbox;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.codefish.sandbox.retrofit.SandBoxService;
import com.facebook.drawee.view.SimpleDraweeView;

import org.reactivestreams.Subscription;

import java.util.Observable;


public class Activity2 extends AppCompatActivity {

    TextView textView;
    SandBoxService service;
    SimpleDraweeView draweeView;
    private Subscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_1);
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://api.github.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//         service = retrofit.create(SandBoxService.class);


        Observable obs = new Observable();


        Uri uri = Uri.parse("https://raw.githubusercontent.com/samiwinston/movie-images-host/master/CcS37nh.jpg");
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
        draweeView.setImageURI(uri);

//        draweeView.getHierarchy().setPlaceholderImage(R.drawable.fb_icon);

    }

    public void onRepoButtonClick(View view)
    {
//          service.listRepos("samiwinston").enqueue(new Callback<List<Object>>() {
//              @Override
//              public void onResponse(Call<List<Object>> call, Response<List<Object>> response) {
//                  List<Object> result = response.body();
//              }
//
//              @Override
//              public void onFailure(Call<List<Object>> call, Throwable t) {
//                  Log.d("getUser","ooops");
//              }
//          });
    }





    public static Activity2 newInstance() {
        Activity2 actv = new Activity2();
        return actv;
    }
}
