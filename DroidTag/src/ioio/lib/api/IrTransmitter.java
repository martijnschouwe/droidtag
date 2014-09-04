package ioio.lib.api;

import ioio.lib.api.exception.ConnectionLostException;

public interface IrTransmitter extends Closeable {

    public void irTransmit(int freqHz, int bursts[][]) throws ConnectionLostException;

    /**
     * Shorthand for irTransmit(38000, bursts)
     *
     * @see #irTransmit(int, int[][])
     */
    public void irTransmit(int bursts[][]) throws ConnectionLostException;
}
