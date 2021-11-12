package com.dymchenko.sosapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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


import static com.dymchenko.sosapp.R.mipmap.caraccident_icon_foreground;
import static com.dymchenko.sosapp.R.mipmap.lost_icon_foreground;
import static com.dymchenko.sosapp.R.mipmap.earthquake_icon_foreground;
import static com.dymchenko.sosapp.R.mipmap.faint_icon_foreground;
import static com.dymchenko.sosapp.R.mipmap.fire_icon_foreground;
import static com.dymchenko.sosapp.R.mipmap.gaz_icon_foreground;
import static com.dymchenko.sosapp.R.mipmap.mercury_icon_foreground;
import static com.dymchenko.sosapp.R.mipmap.pepperspray_icon_foreground;
import static com.dymchenko.sosapp.R.mipmap.thief_icon_foreground;

public class Instructions extends AppCompatActivity {
    Button next, previous;
    FragmentTransaction fTrans;
    int index = -1;
    Object[] fragments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

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
        Bundle arguments = getIntent().getExtras();
        String name = arguments.get("name").toString();
        Log.d("name", name);


        for (EmergencySituations cur : situations) {
            if (cur.Name.equals(name)) {
                fragments = cur.Fragments;
            }
        }
        fTrans = getFragmentManager().beginTransaction();
        index++;
        fTrans.replace(R.id.instructions_content, (Fragment) fragments[index]);
        fTrans.commit();
        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index+1<fragments.length) {
                    fTrans = getFragmentManager().beginTransaction();
                    index++;
                    fTrans.replace(R.id.instructions_content, (Fragment) fragments[index]);
                    fTrans.commit();
                }
            }
        });

        previous = findViewById(R.id.previous);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index>0) {
                    fTrans = getFragmentManager().beginTransaction();
                    index--;
                    fTrans.replace(R.id.instructions_content, (Fragment) fragments[index]);
                    fTrans.commit();
                }
            }
        });
    }
}