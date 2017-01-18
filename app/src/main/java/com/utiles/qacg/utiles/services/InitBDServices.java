package com.utiles.qacg.utiles.services;

import com.google.common.math.DoubleMath;
import com.orm.query.Select;
import com.utiles.qacg.utiles.models.Utiles;

/**
 * Created by QACG on 27/12/2016.
 */

public class InitBDServices {

    public void insertUtils() {

        if (Select.from(Utiles.class).count() == 0) {

            Utiles lapizUtils = new Utiles();
            lapizUtils.setName("Lapiz");
            lapizUtils.setBrand("Verol");
            //lapizUtils.setColor("verde");
            lapizUtils.setPrice(Double.valueOf("10"));
            lapizUtils.setSizeUtils("Mediano");
            lapizUtils.save();

            Utiles lapizUtils1 = new Utiles();
            lapizUtils1.setName("Lapiz");
            //   lapizUtils1.setBrand("Verol");
            //lapizUtils1.setColor("verde");
            //    lapizUtils1.setPrice(Double.valueOf("10"));
            // lapizUtils1.setSizeUtils("Mediano");
            lapizUtils1.save();

            Utiles gomaUtils = new Utiles("Goma", "Verol", "Blanco", Double.valueOf("5"), "chica");
            gomaUtils.save();

            Utiles mochilaUtils = new Utiles("Mochila", "Nike", ""/* "Rosa"*/, Double.valueOf("450"), "mediana");
            mochilaUtils.save();

            Utiles zacapuntasUtils = new Utiles("Zacapuntas", "Bic", "Rojo", Double.valueOf("1.50"), "chico");
            zacapuntasUtils.save();

            Utiles reglaUtils = new Utiles("Regla", "Verol", "Blanco", Double.valueOf("15"), "normal");
            reglaUtils.save();

            Utiles cuadernoUtils = new Utiles("Cuaderno", "Scribe", "Verde", null /*Double.valueOf("5.50")*/, "grande");
            cuadernoUtils.save();

            Utiles libroUtils = new Utiles("Libro", "Larrouse", "Naranja", Double.valueOf("60"), "pequeño");
            libroUtils.save();

            Utiles bicolorUtils = new Utiles(/*"Bicolor"*/"", "Bic", "Rojo y Azul", Double.valueOf("5.50"), "normal");
            bicolorUtils.save();

            Utiles marcadorUtils = new Utiles("Marcador", "Aquacolor", "Verde", Double.valueOf("11"), "normal");
            marcadorUtils.save();

            Utiles plumaUtils = new Utiles("Pluma", ""/* "Bic"*/, "Negro", Double.valueOf("6.50"), "Normal");
            plumaUtils.save();

            Utiles libretaUtils = new Utiles("Libreta", "Norma", "Azul", Double.valueOf("23"), "Mediana");
            libretaUtils.save();

        }


    }
}
