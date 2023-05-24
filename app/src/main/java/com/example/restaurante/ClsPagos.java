/*3.Leer el valor de la cena y luego imprimir el valor neto a pagar sabiendo que la propina es voluntaria
 y si se paga es del 10% sobre el valor básico y que además se debe pagar el IVA. Se debe leer además la cantidad de personas.
  Utilizar clases y funciones para (utilizar para cada uno un método)
 */
package com.example.restaurante;

public class ClsPagos {

    public double iva;
    public double Calcular_iva(double valor_cena){
        iva = 14;
        return (valor_cena * iva)/100;
    }

    public double Calcular_propina(double valor_cena){
        double propina;
        propina = (valor_cena*10)/100;
        return propina;
    }

    public double Calcular_venta(double valor_cena, int cantidad_personas){
        return valor_cena * cantidad_personas;
    }

     public double Total_pagar(double valor_cena, double propina, double iva, int cantidad_personas){
        return cantidad_personas * valor_cena + propina + iva;
     }
}
