package com.example.agendacontactos;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText txtNombres, txtTelefono, txtEmail;
    SharedPreferences preferences;
    List<Map<String, String>> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instanciar objetos View
        txtNombres = findViewById(R.id.txtNombres);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtEmail = findViewById(R.id.txtEmail);

        // Inicializar SharedPreferences y lista de contactos
        preferences = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        contactos = obtenerListaContactos();
    }

    private List<Map<String, String>> obtenerListaContactos() {
        String agendaJson = preferences.getString("lista_contactos", "[]");
        try {
            return new Gson().fromJson(agendaJson, new TypeToken<List<Map<String, String>>>() {}.getType());
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void cmdGuardar_onClick(View v) {
        String nombre = txtNombres.getText().toString();
        String telefono = txtTelefono.getText().toString();
        String email = txtEmail.getText().toString();

        Map<String, String> nuevoContacto = new Gson().fromJson(
                "{\"nombre\": \"" + nombre + "\", \"telefono\": \"" + telefono + "\", \"email\": \"" + email + "\"}",
                new TypeToken<Map<String, String>>() {}.getType());

        contactos.add(nuevoContacto);
        guardarListaContactos(contactos);

        Toast.makeText(this, "Datos guardados correctamente!!", Toast.LENGTH_SHORT).show();
    }

    private void guardarListaContactos(List<Map<String, String>> listaContactos) {
        String nuevaListaContactosJson = new Gson().toJson(listaContactos);
        preferences.edit().putString("lista_contactos", nuevaListaContactosJson).apply();
    }

    public void cmdBuscar_onClick(View v) {
        String nombre = txtNombres.getText().toString().toLowerCase(); // Convertir a minúsculas para comparación más flexible

        boolean contactoEncontrado = false;
        String telefono = "";
        String email = "";
        for (Map<String, String> contacto : contactos) {
            String nombreContacto = contacto.get("nombre").toLowerCase(); // Convertir a minúsculas para comparación más flexible
            if (nombreContacto.contains(nombre)) { // Verificar si el nombre del contacto contiene la cadena ingresada por el usuario
                telefono = contacto.get("telefono");
                email = contacto.get("email");
                contactoEncontrado = true;
                break;
            }
        }

        if (contactoEncontrado) {
            txtTelefono.setText(telefono);
            txtEmail.setText(email);
            Toast.makeText(this, "Datos buscados correctamente!!", Toast.LENGTH_LONG).show();
        } else {
            txtTelefono.setText("");
            txtEmail.setText("");
            Toast.makeText(this, "Datos no encontrados!!", Toast.LENGTH_LONG).show();
        }
    }
}
