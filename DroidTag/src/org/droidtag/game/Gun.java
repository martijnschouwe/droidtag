package org.droidtag.game;

import java.util.List;

public class Gun {

    private GunType gunType;
    private List<Clip> clips;

    public Gun() {
    }

    public GunType getGunType() {
        return gunType;
    }

    public void setGunType(GunType gunType) {
        this.gunType = gunType;
    }

    public List<Clip> getClips() {
        return clips;
    }

    public void setClips(List<Clip> clips) {
        this.clips = clips;
    }

}
