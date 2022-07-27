package com.example.onlineshopping;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;


public class SignUpActivity extends AppCompatActivity {
    TextInputLayout name_lay, email_lay, pass_lay, conf_lay;
    EditText name_reg, email_reg, pass_reg, confirmPass_reg;
    Button register;
    TextView already_ac;
    private DatabaseHelper databaseHelper;
    private InputValidation inputValidation;
   // User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name_lay = findViewById(R.id.textinputname);
        email_lay = findViewById(R.id.textinputemail);
        pass_lay = findViewById(R.id.textinputpswd);
        conf_lay = findViewById(R.id.textinputconfirmpswd);
        name_reg = findViewById(R.id.editTextName);
        email_reg = findViewById(R.id.editTextEmail);
        pass_reg = findViewById(R.id.editTextPassword);
        confirmPass_reg = findViewById(R.id.editTextconfirmPassword);
        register = findViewById(R.id.button);
        already_ac = findViewById(R.id.logintext);
        databaseHelper = new DatabaseHelper(SignUpActivity.this);
        inputValidation = new InputValidation(SignUpActivity.this);
        //user = new User();


        register.setOnClickListener(view -> {
            if (!inputValidation.isInputEditTextFilled(name_reg, name_lay, "Enter Full Name")) {
                return;
            }

            if (!inputValidation.isInputEditTextFilled(email_reg, email_lay, "Enter Valid Email")) {
                return;
            }
            if (!inputValidation.isInputEditTextEmail(email_reg, email_lay, "Enter valid Email")) {
                return;
            }
            if (!inputValidation.isInputEditTextFilled(pass_reg, pass_lay, "Enter Password")) {
                return;
            }
            if (!inputValidation.isInputEditTextMatches(pass_reg, confirmPass_reg,
                    conf_lay, "Password Does Not Matches")) {
                return;
            }

            if (!databaseHelper.checkUser(email_reg.getText().toString().trim())) {
                //user.setName(name_reg.getText().toString().trim());
                //user.setEmail(email_reg.getText().toString().trim());
               // user.setPwsd(pass_reg.getText().toString().trim());
                String name=name_reg.getText().toString().trim();
                String email=email_reg.getText().toString().trim();
                String pswd= pass_reg.getText().toString().trim();
                databaseHelper.addUser(name,email,pswd);
                Toast.makeText(SignUpActivity.this, "Registration successful", Toast.LENGTH_LONG).show();
                emptyInputEditText();
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);

            }
            else {
                Toast.makeText(SignUpActivity.this, "Email already exists", Toast.LENGTH_LONG).show();
            }

        });


        already_ac.setOnClickListener(v -> {
            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
            startActivity(intent);

        });




    }

    public void emptyInputEditText()

    {
        name_reg.setText(null);
        email_reg.setText(null);
        pass_reg.setText(null);
        confirmPass_reg.setText(null);
    }

}



