package com.andyyy.googlemapsscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;

public class RegisterLogin extends AppCompatActivity {


    //CREATE VARIABLE
    EditText email, password;
    Button login, register, signout;
    //private FirebaseAuth mAuth;
    //FirebaseUser currentUser;
    CardView loginCardView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mAuth = FirebaseAuth.getInstance();

        //SET VARIABLES
        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);
        login = findViewById(R.id.btnLogin);
        register = findViewById(R.id.btnRegister);
       // currentUser = mAuth.getCurrentUser();
        loginCardView = findViewById(R.id.cardView_login);
        signout = findViewById(R.id.btnSignOut);





        //REGISTER BUTTON
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //GETS VALUES FROM TEXT BOXES
                String enteredEmail = email.getText().toString().trim();
                String enteredPassword = password.getText().toString().trim();
                //CREATES FIREBASE USER
                /*mAuth.createUserWithEmailAndPassword(enteredEmail, enteredPassword)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                //IF TASK IS SUCCESSFUL A MESSAGE IS DISPLAYED
                                if (task.isSuccessful()) {
                                    Context context = RegisterLogin.this;
                                    CharSequence text = "USER ";
                                    CharSequence text2 = " SUCCESSFULLY REGISTERED!";
                                    int duration = Toast.LENGTH_SHORT;

                                    Toast.makeText(context, text +
                                            mAuth.getCurrentUser().getEmail() + text2, duration).show();


                                }
                                else
                                {
                                    //DISPLAYS ERROR MESSAGE
                                    Context context = RegisterLogin.this ;
                                    CharSequence text = "ERROR HAS OCCURRED, UNABLE TO REGISTER!";
                                    int duration = Toast.LENGTH_SHORT;
                                    Toast.makeText( context, text, duration).show();
                                }//DISPLAYS WHY USER COULDN'T BE CREATED
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Context context = RegisterLogin.this;
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }


        });
*/
        //LOGIN BUTTON
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //GETS VALUES FROM TEXTBOXES
                String enteredEmail = email.getText().toString().trim();
                String enteredPassword = password.getText().toString().trim();

                //CHECKS IF USER EXISTS IN FIREBASE
                mAuth.signInWithEmailAndPassword(enteredEmail,enteredPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful())
                        {
                            //DISPLAYS MESSAGE IF SUCCESSFUL AND SHOWS MENU ACTIVITY
                            loginCardView.setVisibility(View.GONE);

                            Context context = RegisterLogin.this;
                            CharSequence text = "LOGGED IN ";
                            CharSequence text2 = " SUCCESSFULLY!";
                            int duration = Toast.LENGTH_SHORT;
                            Toast.makeText(context, text + mAuth.getCurrentUser().getEmail() + text2, duration).show();

                            Intent i = new Intent(RegisterLogin.this, Menu.class);
                            startActivity(i);
                        }

                        else
                        {
                            //DISPLAYS ERROR MESSAGE
                            Context context = RegisterLogin.this ;
                            CharSequence text = "ERROR HAS OCCURRED, UNABLE TO LOGIN!";
                            int duration = Toast.LENGTH_SHORT;
                            Toast.makeText( context, text, duration).show();
                        }


                    }

                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e)
                    {
                        Context context = RegisterLogin.this;
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }*/
                });

            }
        });

                //SIGN OUT BUTTON
                signout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // mAuth.signOut();

                        Context context = RegisterLogin.this;
                        CharSequence text = "YOU HAVE BEEN SIGNED OUT!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast.makeText(context, text, duration).show();
                        loginCardView.setVisibility(View.VISIBLE);
                    }
                });


            }

            @Override
            protected void onStart() {
                super.onStart();

                //IF USER IS ALREADY SIGNED IN A MESSAGE IS DISPLAYED
                if (currentUser != null) {
                    Context context = RegisterLogin.this;
                    CharSequence text = "ALREADY LOGGED IN!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast.makeText(context, text, duration).show();

                    Intent i = new Intent(RegisterLogin.this, Menu.class);
                    startActivity(i);

                }

            }
        }
