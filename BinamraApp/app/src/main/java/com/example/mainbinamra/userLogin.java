package com.example.mainbinamra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class userLogin extends AppCompatActivity {
    EditText txt_Email, txt_Password;
    private Button Login;
    private Button RegisterTo;

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);


        Login = findViewById(R.id.login);
        RegisterTo = findViewById(R.id.FrontRegister);
        txt_Email = findViewById(R.id.loginEmail);
        txt_Password = findViewById(R.id.loginPassword);

        firebaseAuth =FirebaseAuth.getInstance();

        RegisterTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(userLogin.this, "Registration....", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(userLogin.this, Register.class);
                startActivity(intent);
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String Email1 = txt_Email.getText().toString();
                String Password = txt_Password.getText().toString();
                String Email = "a";

                if (TextUtils.isEmpty((CharSequence) Email1)) {
                    Toast.makeText(userLogin.this, "Please enter Email ! ", Toast.LENGTH_SHORT).show();
                }

                if (TextUtils.isEmpty((CharSequence) Password)) {
                    Toast.makeText(userLogin.this, "Please enter Valid Password ! ", Toast.LENGTH_SHORT).show();
                }

                if (Password.length() < 6) {
                    Toast.makeText(userLogin.this, "Password too Short ! ", Toast.LENGTH_SHORT).show();
                }

                Toast.makeText(userLogin.this, "Login in progress...", Toast.LENGTH_SHORT).show();
                Email= "D_" + Email1;

                firebaseAuth.signInWithEmailAndPassword(Email, Password)
                        .addOnCompleteListener(userLogin.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    String Email1 = txt_Email.getText().toString().trim();
                                    // String Password = txt_Password.getText().toString().trim();
                                    String Email = "D_" + Email1;
                                    Intent intent = new Intent(userLogin.this, WelcomeCustomers.class).putExtra("email", Email);
                                    startActivity(intent);
                                   /* Intent intent = new Intent(userLogin.this, Guide_section.class);
                                    startActivity(intent);*/

                                    //startActivity(new Intent(getApplicationContext(), Guide_section.class));
                                } else {
                                    String Email1 = txt_Email.getText().toString().trim();
                                    String Password = txt_Password.getText().toString().trim();
                                    String Email = "U_" + Email1;
                                    //Toast.makeText(userLogin.this, "Login Failed.... Please Register before Logging in ! ", Toast.LENGTH_SHORT).show();
                                    firebaseAuth.signInWithEmailAndPassword(Email, Password)
                                            .addOnCompleteListener(userLogin.this, new OnCompleteListener<AuthResult>() {
                                                @Override
                                                public void onComplete(@NonNull Task<AuthResult> task) {
                                                    if (task.isSuccessful()) {
                                                        String email1 = txt_Email.getText().toString().trim();
                                                        String email = "U_" + email1;
                                                        Intent intent = new Intent(userLogin.this, WelcomeCustomers.class).putExtra("email", email);
                                                        startActivity(intent);
                                                    } else {
                                                        String email1 = txt_Email.getText().toString().trim();
                                                        String password = txt_Password.getText().toString().trim();
                                                        String email = "A_" + email1;
                                                        firebaseAuth.signInWithEmailAndPassword(email, password)
                                                                .addOnCompleteListener(userLogin.this, new OnCompleteListener<AuthResult>() {
                                                                    @Override
                                                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                                                        if (task.isSuccessful()) {
                                                                            Intent intent = new Intent(userLogin.this, WelcomeCustomers.class);
                                                                            startActivity(intent);
                                                                        } else {
                                                                            Toast.makeText(userLogin.this, "Login Failed or USER NOT REGISTERED !", Toast.LENGTH_SHORT).show();
                                                                        }
                                                                    }
                                                                });


                                                    }
                                                }
                                            });

                                }

                                //Toast.makeText(userLogin.this, "Please Enter Valid Email.", Toast.LENGTH_SHORT).show();
                            }

                        });

                Toast.makeText(userLogin.this, "Logging in ..... !", Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(userLogin.this, Login.class);
                //    startActivity(intent);
            }

        });


    }
}
