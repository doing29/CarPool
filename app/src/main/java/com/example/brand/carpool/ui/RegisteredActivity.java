package com.example.brand.carpool.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.brand.carpool.R;
import com.example.brand.carpool.entity.MyUser;
import com.example.brand.carpool.utils.L;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/*
 @ project: CarPool
 @ package: com.example.brand.carpool.ui
 @ file: RegisteredActivity
 @ author : Jingliang Zhang (Brand)
 @ create time: 2018/8/29 2:40
 @ description: TODO
 */
public class RegisteredActivity extends BaseActivity implements View.OnClickListener{

    private EditText et_user;
    private EditText et_age;
    private EditText et_desc;
    private RadioGroup mRadioGroup;
    private EditText et_pass;
    private EditText et_password;
    private EditText et_email;
    private Button btnRegistered;
    private boolean isGender = true;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);
        initView();
    }

    private void initView() {
        et_user = (EditText) findViewById(R.id.et_user);
        et_age = (EditText) findViewById(R.id.et_age);
        et_desc = (EditText) findViewById(R.id.et_desc);
        mRadioGroup = (RadioGroup) findViewById(R.id.mRadioGroup);
        et_pass = (EditText) findViewById(R.id.et_pass);
        et_password = (EditText) findViewById(R.id.et_password);
        et_email = (EditText) findViewById(R.id.et_email);
        btnRegistered = (Button) findViewById(R.id.btnRegistered);
        btnRegistered.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnRegistered:
                String name =et_user.getText().toString().trim();
                String age =et_age.getText().toString().trim();
                String desc =et_desc.getText().toString().trim();
                String pass =et_pass.getText().toString().trim();
                String password =et_password.getText().toString().trim();
                String email =et_email.getText().toString().trim();

                //whether null
                if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(age) && !TextUtils.isEmpty(pass)
                        && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(email)){

                    // pass == password
/*                    if(pass != password){
                        Toast.makeText(this, "password should be same", Toast.LENGTH_SHORT).show();
                    }*/
                    //judge gender
                    mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup radioGroup, int i) {
                            if(i == R.id.rb_boy){
                                isGender = true;
                            }else if(i == R.id.rb_girl){
                                isGender = false;
                            }
                        }
                    });
                    //check introduction
                    if(!TextUtils.isEmpty(desc)){
                        desc = " This guy is lazy that fuck him";
                    }

                    //register
                    MyUser user = new MyUser();
                    user.setUsername(name);
                    user.setPassword(password);
                    user.setEmail(email);
                    user.setAge(Integer.parseInt(age));
                    user.setSex(isGender);
                    user.setDesc(desc);
                    user.signUp(new SaveListener<MyUser>(){

                        @Override
                        public void done(MyUser myUser, BmobException e) {
                            if(e==null){
                                Toast.makeText(RegisteredActivity.this, "success", Toast.LENGTH_SHORT).show();
                                finish();
                            }else{
                                Toast.makeText(RegisteredActivity.this, "fail:" + e.toString(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }else{
                    Toast.makeText(this, "cannot be null", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
