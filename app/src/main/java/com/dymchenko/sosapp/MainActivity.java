package com.dymchenko.sosapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.dymchenko.sosapp.fragments.CarAccident_01;
import com.dymchenko.sosapp.fragments.CarAccident_02;
import com.dymchenko.sosapp.fragments.CarAccident_03;
import com.dymchenko.sosapp.fragments.CarAccident_04;
import com.dymchenko.sosapp.fragments.CarAccident_05;
import com.dymchenko.sosapp.fragments.CarAccident_06;
import com.dymchenko.sosapp.fragments.CarAccident_07;
import com.dymchenko.sosapp.fragments.Earthquake_01;
import com.dymchenko.sosapp.fragments.Earthquake_02;
import com.dymchenko.sosapp.fragments.Earthquake_03;
import com.dymchenko.sosapp.fragments.Earthquake_04;
import com.dymchenko.sosapp.fragments.Earthquake_05;
import com.dymchenko.sosapp.fragments.Earthquake_06;
import com.dymchenko.sosapp.fragments.Fainting_01;
import com.dymchenko.sosapp.fragments.Fainting_02;
import com.dymchenko.sosapp.fragments.Fainting_03;
import com.dymchenko.sosapp.fragments.Fainting_04;
import com.dymchenko.sosapp.fragments.Fainting_05;
import com.dymchenko.sosapp.fragments.Fire_01;
import com.dymchenko.sosapp.fragments.Fire_02;
import com.dymchenko.sosapp.fragments.Fire_03;
import com.dymchenko.sosapp.fragments.Fire_04;
import com.dymchenko.sosapp.fragments.Fire_05;
import com.dymchenko.sosapp.fragments.GasLeak_01;
import com.dymchenko.sosapp.fragments.GasLeak_02;
import com.dymchenko.sosapp.fragments.GasLeak_03;
import com.dymchenko.sosapp.fragments.GasLeak_04;
import com.dymchenko.sosapp.fragments.GasLeak_05;
import com.dymchenko.sosapp.fragments.GasLeak_06;
import com.dymchenko.sosapp.fragments.Mercury_01;
import com.dymchenko.sosapp.fragments.Mercury_02;
import com.dymchenko.sosapp.fragments.Mercury_03;
import com.dymchenko.sosapp.fragments.MissingPerson_01;
import com.dymchenko.sosapp.fragments.MissingPerson_02;
import com.dymchenko.sosapp.fragments.MissingPerson_03;
import com.dymchenko.sosapp.fragments.MissingPerson_04;
import com.dymchenko.sosapp.fragments.PepperSpray_01;
import com.dymchenko.sosapp.fragments.Robbery_01;
import com.dymchenko.sosapp.fragments.Robbery_02;
import com.dymchenko.sosapp.fragments.Robbery_03;
import com.dymchenko.sosapp.models.EmergencySituations;
import com.dymchenko.sosapp.models.SituationsAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.dymchenko.sosapp.R.mipmap.caraccident_icon_foreground;
import static com.dymchenko.sosapp.R.mipmap.earthquake_icon_foreground;
import static com.dymchenko.sosapp.R.mipmap.faint_icon_foreground;
import static com.dymchenko.sosapp.R.mipmap.fire_icon_foreground;
import static com.dymchenko.sosapp.R.mipmap.gaz_icon_foreground;

import static com.dymchenko.sosapp.R.mipmap.lost_icon_foreground;
import static com.dymchenko.sosapp.R.mipmap.mercury_icon_foreground;
import static com.dymchenko.sosapp.R.mipmap.pepperspray_icon_foreground;
import static com.dymchenko.sosapp.R.mipmap.thief_icon_foreground;

public class MainActivity extends AppCompatActivity {

    RecyclerView situations_recycler;
    EditText find_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        situations_recycler = findViewById(R.id.situations_recycler);
        find_edit = findViewById(R.id.find_edit);

        Resources res = getResources();
        EmergencySituations[] situations = new EmergencySituations[]{new EmergencySituations("Землетрясение",
                "частично расплескивается вода в сосудах, могут опрокинуться легкие предметы, разбиться посуда",
                new String[]{"землетрясение", "колебания", "шатаются", "здания шатаются"},
                ResourcesCompat.getDrawable(res, earthquake_icon_foreground, null), new Object[]{new Earthquake_01(), new Earthquake_02(), new Earthquake_03(), new Earthquake_04(), new Earthquake_05(), new Earthquake_06()}),

                new EmergencySituations("Пожар",
                        "что то загорелось или взорвалось",
                        new String[]{"горит", "пожар", "огонь", "взрыв"},
                        ResourcesCompat.getDrawable(res, fire_icon_foreground, null), new Object[]{new Fire_01(), new Fire_02(), new Fire_03(), new Fire_04(), new Fire_05()}),

                new EmergencySituations("Запах газа",
                        "явный сильный запах газа при выключенных источниках",
                        new String[]{"газ", "вытек", "взрыв"},
                        ResourcesCompat.getDrawable(res, gaz_icon_foreground, null), new Object[]{new GasLeak_01(), new GasLeak_02(), new GasLeak_03(), new GasLeak_04(), new GasLeak_04(), new GasLeak_05(), new GasLeak_06()}),

                new EmergencySituations("Человек без сознания",
                        "человек потерял сознание, не реагирует на внешние раздражители ",
                        new String[]{"плохо", "потеря сознания", "плохое самочувствие"},
                        ResourcesCompat.getDrawable(res, faint_icon_foreground, null), new Object[]{new Fainting_01(), new Fainting_02(), new Fainting_03(), new Fainting_04(), new Fainting_05()}),

                new EmergencySituations("Пропал человек",
                        "никто не знает о местоположении человека",
                        new String[]{"пропажа", "потерялся человек", "пропал ребенок"},
                        ResourcesCompat.getDrawable(res, lost_icon_foreground, null), new Object[]{new MissingPerson_01(), new MissingPerson_02(), new MissingPerson_03(), new MissingPerson_04()}),

                new EmergencySituations("Разлилась ртуть",
                        "например, разбился градусник",
                        new String[]{"разлилась ртуть", "разлилась", "ртуть"},
                        ResourcesCompat.getDrawable(res, mercury_icon_foreground, null), new Object[]{new Mercury_01(), new Mercury_02(), new Mercury_03()}),

                new EmergencySituations("ДТП",
                        "вы полпали в ДТП(стал свидетелем)",
                        new String[]{"авария", "ДТП", "травма"},
                        ResourcesCompat.getDrawable(res, caraccident_icon_foreground, null), new Object[]{new CarAccident_01(), new CarAccident_02(), new CarAccident_03(), new CarAccident_04(), new CarAccident_05(), new CarAccident_06(), new CarAccident_07()}),

                new EmergencySituations("Ограбление",
                        "вы стали свидетелем ограбления(жертвой)",
                        new String[]{"ограбление", "вор", "кража"},
                        ResourcesCompat.getDrawable(res, thief_icon_foreground, null), new Object[]{new Robbery_01(), new Robbery_02(), new Robbery_03()}),

                new EmergencySituations("Распыление перцового балона",
                        "вы стали свидетелем распыления перцового балона",
                        new String[]{"перцовка", "распыление", "балончик"},
                        ResourcesCompat.getDrawable(res, pepperspray_icon_foreground, null), new Object[]{new PepperSpray_01()})
        };

        SituationsAdapter situationsAdapter = new SituationsAdapter(this, Arrays.asList(situations));
        situations_recycler.setAdapter(situationsAdapter);

        find_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                SituationsAdapter situationsAdapter = new SituationsAdapter(MainActivity.this, checkResult(s));
                situations_recycler.setAdapter(situationsAdapter);
            }

            private List<EmergencySituations> checkResult(CharSequence part) {
                List<EmergencySituations> result = new ArrayList<>();
                for (int x = 0; x < situations.length; x++) {
                    for (String keyword : situations[x].KeyWords) {
                        if (keyword.contains(part)) {
                            result.add(situations[x]);
                            break;
                        }
                    }
                }
                return result;
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}