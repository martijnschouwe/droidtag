package org.droidtag.game;


/**
 * @author mschouwe
 *         Team class for setup of a team
 */
public class Team {

    private int id;
    private int captainId;
    private String name;

    public Team() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCaptainId() {
        return captainId;
    }

    public void setCaptainId(int captainId) {
        this.captainId = captainId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
