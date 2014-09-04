package ioio.lib.impl;

import java.io.IOException;

import ioio.lib.api.IrTransmitter;
import ioio.lib.api.PwmOutput;
import ioio.lib.api.exception.ConnectionLostException;


public class IrTransmitterImpl extends AbstractResource implements
        IrTransmitter {
    PwmOutput pwm_;

    public IrTransmitterImpl(IOIOImpl ioio, PwmOutput pwm) throws ConnectionLostException {
        super(ioio);
        pwm_ = pwm;
    }

    @Override
    public void irTransmit(int freqHz, int bursts[][]) throws ConnectionLostException {
        checkState();

        if (freqHz < 20000) {
            throw new IllegalArgumentException("Frequency must be greater than 20000Hz");
        }

        if (bursts.length <= 0) {
            return;
        } else if (bursts[0].length != 2) {
            throw new IllegalArgumentException("Bursts array must be Nx2 in size");
        }

        try {
            ioio_.protocol_.irTransmit(freqHz, bursts);
        } catch (IOException e) {
            throw new ConnectionLostException(e);
        }
    }

    @Override
    public void irTransmit(int[][] bursts) throws ConnectionLostException {
        irTransmit(38000, bursts);
    }

    @Override
    public synchronized void close() {
        super.close();
        pwm_.close();
    }
}
