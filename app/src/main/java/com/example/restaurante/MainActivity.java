package com.example.restaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText jetcantidad, jetvalor;
    CheckBox jchpropina;
    TextView jtvventabruta, jtviva, jtvpropina, jtvtotalpagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ocultar la barra de titulo por defecto y asociar objetos Java con
        //objetos Xml
        getSupportActionBar().hide();
        //Relacionamos los objetos xml con los objetos java

        jetcantidad = findViewById(R.id.etcantidad);
        jetvalor = findViewById(R.id.etvalor);
        jchpropina = findViewById(R.id.chpropina);
        jtvventabruta = findViewById(R.id.tvventabruta);
        jtviva = findViewById(R.id.tviva);
        jtvpropina = findViewById(R.id.tvpropina);
        jtvtotalpagar = findViewById(R.id.tvtotalpagar);

    }//FIN ONCREATE

    public void Calcular(View view){
        String cantidad, valor;
        cantidad = jetcantidad.getText().toString();
        valor = jetvalor.getText().toString();
        //Validar que si digitaron numeros

        if (cantidad.isEmpty() || valor.isEmpty()) {
            Toast.makeText(this, "Las cantidades son requeridas", Toast.LENGTH_SHORT).show();
            jetcantidad.requestFocus();
        }else{
            int cantidad1;
            double valor1, propina=0, venta_bruta, total_pagar, iva;
            //Conversiones de texto a numerico
            cantidad1 = Integer.parseInt(cantidad);
            valor1 = Double.parseDouble(valor);
            //Intanciar la clase ClsPagos
            ClsPagos Obj_Calculos = new ClsPagos();
            venta_bruta = Obj_Calculos.Calcular_venta(valor1,cantidad1);
            if (jchpropina.isChecked()){
                propina = Obj_Calculos.Calcular_propina(venta_bruta);
            }
            iva = Obj_Calculos.Calcular_iva(venta_bruta);
            total_pagar = Obj_Calculos.Total_pagar(valor1,propina,iva,cantidad1);
            //Mostrar los resultados
            jtvventabruta.setText(String.valueOf(venta_bruta));
            jtviva.setText(String.valueOf(iva));
            jtvpropina.setText(String.valueOf(propina));
            jtvtotalpagar.setText(String.valueOf(total_pagar));

        }

    }//Fin Calcular

    public void Limpiar(View vie){
        jetcantidad.setText("");
        jetvalor.setText("");
        jchpropina.isEnabled();
        jtvventabruta.setText("0");
        jtviva.setText("0");
        jtvpropina.setText("0");
        jtvtotalpagar.setText("0");


    }
}