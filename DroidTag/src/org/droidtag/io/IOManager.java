package org.droidtag.io;


/**
 * @author mschouwe
 *         Interface which communicates with low level io of the android ioio board
 */
public interface IOManager {

    /*
     * Calls firing io pwm
     */
    public boolean fire();

    /*
     * reload the clips
     */
    public boolean reload();

}
