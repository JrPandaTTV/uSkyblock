package com.jrpanda.Ranks;

import com.jrpanda.Util.CustomFile;
import org.bukkit.configuration.file.FileConfiguration;

public class Ranks{
    private String prefix, suffix, name, perm;
    private boolean isDefault;

    private CustomFile file;

    public Ranks(){
        load();
    }

    public void load(){
        file = new CustomFile("plugins/uSkyblock/groups.yml");
    }

    public String getName(String name){
        return name;
    }

    public boolean getDefault(boolean isDefault){
        return isDefault;
    }

    public void setDefault(boolean isDefault){
        this.isDefault = isDefault;
    }

    public void setName(String name){
        FileConfiguration config = file.getConfig();
        config.set("Groups", name);
        file.save();
    }

}
