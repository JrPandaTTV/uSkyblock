package com.jrpanda.Util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {
    private ItemMeta meta = null;

    private Material mat;
    private int amount;
    private String
            displayName = null,
            locname = null;
    private List<String> lore = new ArrayList<>();

    public ItemBuilder(Material material, int amount){
        this.mat = material;
        this.amount = amount;
    }

    public ItemBuilder(Material material){
        this(material, 1);
    }

    public ItemBuilder(ItemStack item){
        this.meta = item.getItemMeta();
        this.mat = item.getType();
        this.amount = item.getAmount();
    }

    public ItemBuilder setName(String name) {
        this.displayName = name;
        return this;
    }

    public ItemBuilder addLore(String line){
        this.lore.add(Helper.toColor(line));
        return this;
    }

    public ItemBuilder setLocname(String name){
        this.locname = name;
        return this;
    }

    public ItemStack build(){
        ItemStack item = new ItemStack(mat, amount);
        ItemMeta meta = item.getItemMeta();
        if (this.meta != null) meta = this.meta;

        if (displayName != null) meta.setDisplayName(Helper.toColor(displayName));
        if (!lore.isEmpty()) meta.setLore(lore);
        if (locname != null) meta.setLocalizedName(locname);

        item.setItemMeta(meta);
        return item;
    }
}
