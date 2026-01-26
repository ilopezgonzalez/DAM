package com.example.ejerciciobotongiroscopio;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private SensorManager gestorSensores;
    private Sensor acelerometro;
    private SensorEventListener escuchadorAcelerometro;
    private Button miBoton;
    private View mainLayout;

    // Multiplicador para ajustar la velocidad. Un valor bajo es mejor para este enfoque.
    private static final float SENSIBILIDAD = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencia a las vistas del XML
        miBoton = findViewById(R.id.button);
        mainLayout = findViewById(R.id.main);

        // Inicialización del SensorManager
        gestorSensores = (SensorManager) getSystemService(SENSOR_SERVICE);
        // Obtener el sensor del acelerómetro
        acelerometro = gestorSensores.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        // Comprobar si el dispositivo tiene acelerómetro
        if (acelerometro == null) {
            // El dispositivo no tiene acelerómetro, puedes manejarlo aquí
            return;
        }

        // Creación del SensorEventListener
        escuchadorAcelerometro = new SensorEventListener() {
            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
                // No es necesario implementar nada aquí para este caso.
            }

            @Override
            public void onSensorChanged(SensorEvent event) {
                // Umbral para ignorar pequeñas fluctuaciones del sensor cuando está plano.
                final float UMBRAL = 0.2f;

                float accelX = event.values[0];
                float accelY = event.values[1];

                // Si la inclinación es menor que el umbral en ambos ejes, no movemos el botón.
                if (Math.abs(accelX) < UMBRAL && Math.abs(accelY) < UMBRAL) {
                    return; // Detiene el movimiento si no hay una inclinación clara.
                }

                // Obtenemos la posición actual y le sumamos un desplazamiento.
                float nuevaX = miBoton.getX() - (accelX * SENSIBILIDAD);
                float nuevaY = miBoton.getY() + (accelY * SENSIBILIDAD);

                // Comprobamos que el botón no se salga de los límites de la pantalla
                if (nuevaX < 0) {
                    nuevaX = 0;
                } else if (nuevaX > mainLayout.getWidth() - miBoton.getWidth()) {
                    nuevaX = mainLayout.getWidth() - miBoton.getWidth();
                }

                if (nuevaY < 0) {
                    nuevaY = 0;
                } else if (nuevaY > mainLayout.getHeight() - miBoton.getHeight()) {
                    nuevaY = mainLayout.getHeight() - miBoton.getHeight();
                }

                // Establecemos la nueva posición del botón
                miBoton.setX(nuevaX);
                miBoton.setY(nuevaY);
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
         //Registrar el listener cuando la actividad está en primer plano
        if (acelerometro != null) {
            gestorSensores.registerListener(escuchadorAcelerometro, acelerometro, SensorManager.SENSOR_DELAY_UI);
        }
    }

    @Override
    protected void onPause() {
       super.onPause();
        // Detener el listener para ahorrar batería cuando la actividad no está visible
        gestorSensores.unregisterListener(escuchadorAcelerometro);
    }
}
