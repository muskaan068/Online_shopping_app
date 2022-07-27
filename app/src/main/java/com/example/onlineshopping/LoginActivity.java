package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    EditText email, pass;
    Button login;
    TextView reg;
    TextInputLayout email_lay, pass_lay;
    private DatabaseHelper databaseHelper;
    private InputValidation inputValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText) findViewById(R.id.editTextemail);
        pass = (EditText) findViewById(R.id.editTextPassword2);
        login = (Button) findViewById(R.id.loginbutton);
        reg = (TextView) findViewById(R.id.register);
        email_lay = (TextInputLayout) findViewById(R.id.textinputemail2);
        pass_lay = (TextInputLayout) findViewById(R.id.textinputpswd);
        databaseHelper = new DatabaseHelper(LoginActivity.this);
        inputValidation = new InputValidation(LoginActivity.this);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!inputValidation.isInputEditTextFilled(email, email_lay, "Enter Valid Email")) {
                    return;
                }
                if (!inputValidation.isInputEditTextEmail(email, email_lay, "Enter Valid Email")) {
                    return;
                }
                if (!inputValidation.isInputEditTextFilled(pass, pass_lay, "Enter Valid Password")) {
                    return;
                }
                if (databaseHelper.checkUser(email.getText().toString().trim(),
                        pass.getText().toString().trim())) {
                    Intent acc_Intent = new Intent(LoginActivity.this, HomeActivity.class);
                    acc_Intent.putExtra("EMAIL", email.getText().toString().trim());
                    emptyInputEditText();
                    startActivity(acc_Intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Wrong Email or Password", Toast.LENGTH_SHORT).show();

                }


            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }


    public void emptyInputEditText() {
        email.setText(null);
        pass.setText(null);
    }
}
