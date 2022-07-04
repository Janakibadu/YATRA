package com.example.projectii;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
      private TextView textView;
      EditText inputEmail,inputPassword,inputConfirmPassword;
      boolean password_visible;
      Button btnRegister;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

      FirebaseAuth mAuth;
      FirebaseUser mauser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        textView=findViewById(R.id.already);
        inputEmail=findViewById(R.id.etemail2);
        inputPassword=findViewById(R.id.etpassword2);
        inputConfirmPassword=findViewById(R.id.etrepassword);
        btnRegister=findViewById(R.id.btnRegister);
        progressDialog=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mauser=mAuth.getCurrentUser();
        getSupportActionBar().hide();

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,MainActivity.class));
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PerformAuth();
            }
        });
        inputPassword.setOnTouchListener(new View.OnTouchListener() { //for visibility
            @Override
            public boolean onTouch(View view, MotionEvent Event) {
                final int Right=2;
                if(Event.getAction()==MotionEvent.ACTION_UP) {
                    if (Event.getRawX() >= inputPassword.getRight() - inputPassword.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=inputPassword.getSelectionEnd();
                        if(password_visible){
                            //set drawable image here
                            inputPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_visibilityoff,0);
                            //for hide password
                            inputPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            password_visible=false;
                        }else {

                            //set drawable image here
                            inputPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_eye,0);
                            //for show password
                            inputPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            password_visible=true;
                        }
                        inputPassword.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });
        inputConfirmPassword.setOnTouchListener(new View.OnTouchListener() { //for visibility
            @Override
            public boolean onTouch(View view, MotionEvent Event) {
                final int Right=2;
                if(Event.getAction()==MotionEvent.ACTION_UP) {
                    if (Event.getRawX() >= inputConfirmPassword.getRight() - inputConfirmPassword.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=inputConfirmPassword.getSelectionEnd();
                        if(password_visible){
                            //set drawable image here
                            inputConfirmPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_visibilityoff,0);
                            //for hide password
                            inputConfirmPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            password_visible=false;
                        }else {

                            //set drawable image here
                            inputConfirmPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_eye,0);
                            //for show password
                            inputConfirmPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            password_visible=true;
                        }
                        inputConfirmPassword.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });
    }

    private void PerformAuth() {
        String email=inputEmail.getText().toString();
        String password=inputPassword.getText().toString();
        String confirmpassword=inputConfirmPassword.getText().toString();
        if(!email.matches(emailPattern))
        {
            inputEmail.setError("Enter correct Email" );
        }else if(password.isEmpty()||password.length()<6)
        {
            inputPassword.setError("Enter proper Password");
        }else if (!password.equals(confirmpassword))
        {
            inputConfirmPassword.setError("Password not match both field");
        }else
        {
            progressDialog.setMessage("Please wait while Registration...");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    } else {
                        progressDialog.dismiss();
                        Toast.makeText(RegisterActivity.this, "" + task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void sendUserToNextActivity() {
        Intent intent= new Intent(RegisterActivity.this,MainActivity.class);
        intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}