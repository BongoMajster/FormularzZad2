package com.example.formularz;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private EditText firstName, lastName, email, phoneNumber, password, confirmPassword;
    private Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstName = findViewById(R.id.Imie);
        lastName = findViewById(R.id.Nazwisko);
        email = findViewById(R.id.Email);
        phoneNumber = findViewById(R.id.NrTel);
        password = findViewById(R.id.Haslo1);
        confirmPassword = findViewById(R.id.Haslo2);
        submitButton = findViewById(R.id.Zatwierdzenie);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateForm();
            }
        });
    }
    private void validateForm() {
        if (TextUtils.isEmpty(firstName.getText())) { //Jak jest puste to wyskakuje komunikat
            firstName.setError("Prosze wprowadzic imie");
            return;
        } //Jak puste t o wyskakuje komunikat
        if (TextUtils.isEmpty(lastName.getText())) {
            lastName.setError("Prosze wprowadzic nazwisko");
            return;
        } // Sprawdza poprawny patern maila
        if (TextUtils.isEmpty(email.getText()) || !Patterns.EMAIL_ADDRESS.matcher(email.getText()).matches()) {
            email.setError("Prosze wprowadzic poprawny adres e-mail");
            return;
        } //Sorawdza czy nr tel ma conajmniej 9 cyfr
        if (TextUtils.isEmpty(phoneNumber.getText()) || phoneNumber.getText().toString().length() < 9) {
            phoneNumber.setError("Prosze wprowadzic poprawny numer telefonu (co najmniej 9 cyfr)");
            return;
        } // Sprawdza wymaganie czy hasło ma conajmniej 6 znakow
        if (TextUtils.isEmpty(password.getText()) || password.getText().toString().length() < 6) {
            password.setError("Haslo musi miec co najmniej 6 znakow");
            return;
        } // Komunikat jak hasło sie rózni
        if (!password.getText().toString().equals(confirmPassword.getText().toString())) {
            confirmPassword.setError("Hasła muszą byc takie same");
            return;
        }  // Komunikat o wysłaniu formularza
        Toast.makeText(MainActivity.this, "Formularz wyslany", Toast.LENGTH_SHORT).show();
    }
}