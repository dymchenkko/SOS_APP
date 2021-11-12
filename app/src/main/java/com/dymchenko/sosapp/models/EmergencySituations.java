package com.dymchenko.sosapp.models;

import android.graphics.drawable.Drawable;

import androidx.fragment.app.Fragment;

public class EmergencySituations {
   public String Name;
   public String Description;
   public String[] KeyWords;
   public Drawable Icon;
   public Object[] Fragments;

    public EmergencySituations(String name, String description, String[] keyWords, Drawable icon, Object[] fragments) {
        Name = name;
        Description = description;
        KeyWords = keyWords;
        Icon = icon;
        Fragments = fragments;
    }
}
