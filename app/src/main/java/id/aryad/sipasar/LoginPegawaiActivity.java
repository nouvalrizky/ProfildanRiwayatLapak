package id.aryad.sipasar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;

import id.aryad.sipasar.data.AdminData;

public class LoginPegawaiActivity extends AppCompatActivity {

    private AdminData akunAdmin;
    private Button buttonLogin;
    private EditText inputUsername;
    private EditText inputPassword;
    private Button togglePassword;
    private int passVisiblityFlag=0;
    private ProgressBar progressLogin;

    @Override
    protected void onStart() {
        super.onStart();
//      Ketika user sudah login, maka langsung ke MainActivity

        SessionManagement sessionManagement = new SessionManagement(LoginPegawaiActivity.this);
        int loggedUserID = sessionManagement.getSession();

        if(loggedUserID != -1){
            Intent intent = new Intent(LoginPegawaiActivity.this, ListLapakActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_pegawai);

        akunAdmin = new AdminData();

        buttonLogin = findViewById(R.id.buttonLogin);
        inputUsername = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        togglePassword = findViewById(R.id.toggle_pass);

        togglePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwordVisiblity();
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginValidation();
            }
        });

    }

    private void passwordVisiblity(){
        if(passVisiblityFlag==0){
            passVisiblityFlag=1;
            togglePassword.setText("Hide password");
            inputPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            togglePassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_visibility, 0);
        }else {
            togglePassword.setText("Show password");
            inputPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            togglePassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_invisible, 0);
            passVisiblityFlag=0;
        }
    }

    private void loginValidation(){
        String userName =  inputUsername.getText().toString();
        String passwordUser = inputPassword.getText().toString();

        int countNotMatch = 0;

        if(userName.isEmpty()){
            inputUsername.requestFocus();
            inputUsername.setError("Silahkan isi username dahulu");
        }else if (passwordUser.isEmpty()){
            inputPassword.requestFocus();
            inputPassword.setError("Silahkan isi password dahulu");
        }else{
            for (int b = 0 ; b<akunAdmin.getAkunAdmin().size() ; b++) {
                if (userName.equals(akunAdmin.getAkunAdmin().get(b).getUsername())) {
                    if (passwordUser.equals(akunAdmin.getAkunAdmin().get(b).getPassword())) {
                        if (akunAdmin.getAkunAdmin().get(b).getRole().equals("pegawai")){
                            //                      Login Session
                            SessionManagement sessionManagement =
                                    new SessionManagement(LoginPegawaiActivity.this);
                            sessionManagement.saveSession(akunAdmin.getAkunAdmin().get(b));

//                      Intent
                            Intent intent = new Intent(LoginPegawaiActivity.this, ListLapakActivity.class);
                            startActivity(intent);
                            Toast toast = Toast.makeText(LoginPegawaiActivity.this,
                                    "Selamat Datang, " + userName,
                                    Toast.LENGTH_SHORT);
                            toast.show();
                            break;
                        }else{
                            Toast toast = Toast.makeText(LoginPegawaiActivity.this,
                                    "Anda bukan pegawai!",
                                    Toast.LENGTH_LONG);
                            toast.show();
                        }
                    } else {
                        inputPassword.requestFocus();
                        inputPassword.setError("Password salah!");
                        break;
                    }
                }else{
                    countNotMatch++;
                }
            }
            if (countNotMatch==akunAdmin.getAkunAdmin().size()){
                inputUsername.requestFocus();
                inputUsername.setError("Username salah!");
            }
        }
    }
}


