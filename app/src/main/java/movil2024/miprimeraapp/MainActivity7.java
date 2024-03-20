package movil2024.miprimeraapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity7 extends AppCompatActivity {

    private EditText editTextName;
    private Spinner spinnerCountry, spinnerCity;
    private CheckBox checkBoxAgree;
    private Switch switchReminder;
    private RadioButton radioButtonMorning, radioButtonAfternoon;
    private DatePicker datePicker;
    private TimePicker timePicker;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear3_layout);


        editTextName = findViewById(R.id.editTextName);
        checkBoxAgree = findViewById(R.id.checkBoxAgree);
        switchReminder = findViewById(R.id.switchReminder);
        radioButtonMorning = findViewById(R.id.radioButtonMorning);
        radioButtonAfternoon = findViewById(R.id.radioButtonAfternoon);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Configurar spinner de países
        ArrayAdapter<CharSequence> adapterCountry = ArrayAdapter.createFromResource(this,
                R.array.countries_array, android.R.layout.simple_spinner_item);
        adapterCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(adapterCountry);

        // Configurar spinner de ciudades
        ArrayAdapter<CharSequence> adapterCity = ArrayAdapter.createFromResource(this,
                R.array.cities_array, android.R.layout.simple_spinner_item);
        adapterCity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCity.setAdapter(adapterCity);

        // Configurar botón de envío
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener valores de los elementos de la interfaz
                String name = editTextName.getText().toString();
                String country = spinnerCountry.getSelectedItem().toString();
                String city = spinnerCity.getSelectedItem().toString();
                boolean agree = checkBoxAgree.isChecked();
                boolean reminder = switchReminder.isChecked();
                String timeOfDay = radioButtonMorning.isChecked() ? "Mañana" : "Tarde";


                // Obtener la fecha seleccionada
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth();
                int year = datePicker.getYear();
                Calendar selectedDate = Calendar.getInstance();
                selectedDate.set(year, month, day);
                SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                String date = sdfDate.format(selectedDate.getTime());

                // Obtener la hora seleccionada
                int hour = timePicker.getCurrentHour();
                int minute = timePicker.getCurrentMinute();
                String time = String.format(Locale.getDefault(), "%02d:%02d", hour, minute);

                // Mostrar los valores obtenidos
                String message = "Nombre: " + name + "\n";
                message += "De acuerdo: " + (agree ? "Sí" : "No") + "\n";
                message += "Recordatorio: " + (reminder ? "Activado" : "Desactivado") + "\n";
                message += "Momento del día: " + timeOfDay + "\n";
                message += "Fecha: " + date + "\n";
                message += "Hora: " + time;
                Toast.makeText(MainActivity7.this, message, Toast.LENGTH_LONG).show();

            }
        });
    }
    public void linear3_layout (View v) {
        Intent linear = new Intent(this, MainActivity8.class);
        startActivity(linear);
    }

}
