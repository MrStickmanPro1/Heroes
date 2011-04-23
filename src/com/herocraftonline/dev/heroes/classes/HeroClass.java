package com.herocraftonline.dev.heroes.classes;

import java.util.HashSet;
import java.util.Set;

public class HeroClass {

    public static enum ArmorType {
        LEATHER,
        IRON,
        GOLD,
        DIAMOND
    }

    public static enum ArmorItems {
        HELMET,
        CHESTPLATE,
        LEGGINGS,
        BOOTS
    }

    public static enum WeaponType {
        WOOD,
        STONE,
        IRON,
        GOLD,
        DIAMOND
    }

    public static enum WeaponItems {
        PICKAXE,
        AXE,
        HOE,
        SPADE,
        SWORD
    }

    public static enum ExperienceType {
        KILLING,
        MINING,
        CRAFTING,
        LOGGING,
    }

    private String name;
    private HeroClass parent;
    private boolean tameWolves;
    private int tameMax;
    private boolean summonCreatures;
    private int summonMax;
    private Set<String> allowedArmor;
    private Set<String> allowedWeapons;
    private Set<ExperienceType> experienceSources;
    private Set<String> skills;
    private Set<HeroClass> specializations;

    public HeroClass() {
        name = new String();
        allowedArmor = new HashSet<String>();
        allowedWeapons = new HashSet<String>();
        experienceSources = new HashSet<ExperienceType>();
        specializations = new HashSet<HeroClass>();
        skills = new HashSet<String>();
        tameWolves = false;
        tameMax = 0;
        summonCreatures = false;
        summonMax = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof HeroClass) {
            return name.equalsIgnoreCase(((HeroClass) o).getName());
        } else {
            return false;
        }
    }

    public HeroClass(String name) {
        this();
        this.name = name;
    }

    public boolean isPrimary() {
        return parent == null;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getAllowedArmor() {
        return this.allowedArmor;
    }

    public void addAllowedArmor(String armor) {
        this.allowedArmor.add(armor);
    }

    public Set<String> getAllowedWeapons() {
        return this.allowedWeapons;
    }

    public void addAllowedWeapon(String weapon) {
        this.allowedWeapons.add(weapon);
    }

    public HeroClass getParent() {
        return parent == null ? null : parent;
    }

    public boolean getTamable() {
        return tameWolves;
    }

    public int getTameMax() {
        return tameMax;
    }

    public boolean getSummonable() {
        return summonCreatures;
    }

    public int getSummonMax() {
        return summonMax;
    }

    public void setParent(HeroClass parent) {
        this.parent = parent;
    }

    public Set<HeroClass> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<HeroClass> specializations) {
        this.specializations = specializations;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    public Set<ExperienceType> getExperienceSources() {
        return experienceSources;
    }

    public void setExperienceSources(Set<ExperienceType> experienceSources) {
        this.experienceSources = experienceSources;
    }

    public void setTamable(Boolean tameWolves) {
        this.tameWolves = tameWolves;
    }

    public void setTameMax(int tameMax) {
        this.tameMax = tameMax;
    }

    public void setSummonable(Boolean summonCreatures) {
        this.summonCreatures = summonCreatures;
    }

    public void setSummonMax(int summonMax) {
        this.summonMax = summonMax;
    }

}
