package com.example.uxraiso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.uxraiso.HomeActivity;
import com.example.uxraiso.R;

public class MainActivity extends AppCompatActivity {

    EditText usernameET, passwordET;
    Button loginBtn;

//    int[] images = {R.drawable.atomic, R.drawable.map, R.drawable.tereliye};
//    ViewFlipper carousel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameET = findViewById(R.id.emailET);
        passwordET = findViewById(R.id.passwordET);
        loginBtn = findViewById(R.id.LoginBtn);

//        carousel = findViewById(R.id.carousel);

//        for (int image : images){
//            slideImage(image);
//        }

        loginBtn.setOnClickListener(view -> {
            String username = usernameET.getText().toString();
            String password = passwordET.getText().toString();

            if(username.isEmpty()){
                Toast.makeText(this, "Email cannot be empty.", Toast.LENGTH_SHORT).show();
            } else if(password.isEmpty()){
                Toast.makeText(this, "Password cannot be empty.", Toast.LENGTH_SHORT).show();
            } else if(!username.contains(".")){
                Toast.makeText(this, "Email must contains .", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(this, HomeActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
    }

//    public void slideImage(int image){
////        menerima parameter image
////        mau taro image view dimana? kalo di main activity(page yg skrg) taro aja this
//        ImageView imageView = new ImageView(this);
//        imageView.setBackgroundResource(image);
//
//        carousel.addView(imageView);
//
//        carousel.setFlipInterval(3000);
//        carousel.setAutoStart(true);
//
//        carousel.setInAnimation(this, android.R.anim.fade_in);
//        carousel.setOutAnimation(this, android.R.anim.fade_out);
//    }

}