package com.example.challange1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
EditText mname,memail,mpassword,mrepassword;
Button mpickbtn,mregisterbtn;
RadioGroup mradiogroup;
CheckBox mcheckbox;
ImageView imageView;
RelativeLayout mparent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      mname = findViewById(R.id.name);
      memail = findViewById(R.id.email);
      mpassword = findViewById(R.id.password);
      mrepassword = findViewById(R.id.repassword);
      mpickbtn = findViewById(R.id.pickbtn);
      mregisterbtn = findViewById(R.id.registerbtn);
      mradiogroup = findViewById(R.id.radioGroup);
      mcheckbox = findViewById(R.id.checkBox);
      imageView = findViewById(R.id.img);
      mparent = findViewById(R.id.parent);
      mpickbtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              if(imageView.getDrawable()==null){
                  //image is empty
                  showSnackBar();
              }else{
                  //there is a image in ImageView
                  Snackbar.make(mparent," Image Uploded",Snackbar.LENGTH_SHORT).setTextColor(Color.YELLOW).show();
              }
          }
      });
      mregisterbtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String name = mname.getText().toString();
              String email = memail.getText().toString();
              String password = mpassword.getText().toString();
              String rePassword = mrepassword.getText().toString();

              if(name.isEmpty() || email.isEmpty() || password.isEmpty() || rePassword.isEmpty()){
                  Snackbar.make(mparent,"All Fields Are Required",Snackbar.LENGTH_SHORT).show();
              }
              else if(!password.equals(rePassword)){
                  Snackbar.make(mparent,"Password Mismatch",Snackbar.LENGTH_SHORT).show();
              }


              else if(!mcheckbox.isChecked()){
                  Snackbar.make(mparent,"Check I Agree Box",Snackbar.LENGTH_SHORT).show();
              }


              else{
                  Snackbar.make(mparent,"Registration is Sucessful",Snackbar.LENGTH_SHORT).setAction("Dismis", new View.OnClickListener() {
                      @Override
                      public void onClick(View view) {
                            mname.setText("");
                            memail.setText("");
                            mpassword.setText("");
                            mrepassword.setText("");
                      }
                  }).show();
              }



          }
      });

    }
    private void showSnackBar(){
        Snackbar.make(mparent,"Please Uploade Image",Snackbar.LENGTH_INDEFINITE).setAction("Retry", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Retry is clicked",Toast.LENGTH_SHORT).show();
            }
        }).setActionTextColor(Color.RED).show();
    }


}