package sg.edu.rp.c346.myapplication;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;
    RadioGroup rgGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
        rgGender = findViewById(R.id.RadioGroupGender);
    }
     // hello
    @Override
    protected void onPause() {
        super.onPause();

        String strName = etName.getText().toString();

        String strgpa = etGPA.getText().toString();

        float fgpa = Float.parseFloat(strgpa);
        int rb = rgGender.getCheckedRadioButtonId();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor prefEdit = prefs.edit();

        prefEdit.putString("name",strName);

        prefEdit.putFloat("gpa",fgpa);

        prefEdit.putInt("radiob",rb);


        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        String name = prefs.getString("name", "");

        float gpa = prefs.getFloat("gpa", 0.0f);

        int radiob = prefs.getInt("radiob", 0);

        etName.setText(name);
        etGPA.setText(String.valueOf(gpa));
        rgGender.check(radiob);
    }
}
