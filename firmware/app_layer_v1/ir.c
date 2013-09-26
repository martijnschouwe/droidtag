/**
 * a simple infrared transmission of IR code in "Raw Oscillated IR Format"
 *
 * AUTHORS: Andrej Eisfeld <andrej.eisfeld@hs-furtwangen.de>, Sergej Proskurin <sergej.proskurin@googlemail.com>
 */

#include "Compiler.h"
#include "HardwareProfile.h"
#include "ir.h"
#include "pins.h"
#include "timer.h"
#include "logging.h"

#define TX_BUF_SIZE 	256		/* fixed buffer size */
#define IR_CONST 	4145146UL	/* IR constant for calculating the pulse width */
#define SEC_IN_USEC 	1000000UL	/* one sec in usec */
#define IR_DATA_OFFSET 	4		/* data offset in IR code */

static int txBuffer[TX_BUF_SIZE];
static int numTxBytes = 0;    // buffer index

/**
 * storeIRDate()
 *
 * stores the IR command, which should be transmitted, in the tx_buffer.
 * NOTE that the tx_buffer is limited to TX_BUF_SIZE entries, thus limiting the
 * IR command to TX_BUF_SIZE words
 */
void storeIRData( int byteHigh, int byteLow ) {
	if(numTxBytes < TX_BUF_SIZE) {
		txBuffer[numTxBytes] = (byteHigh << 8) | byteLow;
		numTxBytes = numTxBytes + 1;
	}
}

/**
 * sendIRCommand()
 *
 * interprets the IR code:
 * - calculates the needed frequence
 * - stores the number of burst pairs of the initial and the repeating sequence
 * - sends out the burst pairs by calling the sendIRBurstPair() function
 */
void sendIRCommand( int pin ) {
	int i = 0;
    	int FreqDiv = txBuffer[1];
	int initSeqLength = txBuffer[2] * 2;
	int repeatSeqLength = txBuffer[3] * 2;
	int commandOnIndex = 0;
	int commandOffIndex = 0;
	IR_BURST_PAIR burstPair;

	burstPair.pulseWidth = (int) ((SEC_IN_USEC / (IR_CONST / FreqDiv)) / 2);

        if( (initSeqLength + repeatSeqLength) < (TX_BUF_SIZE * 2) ) {
            if(initSeqLength > 0) {
                /* Transmit InitialSequence of IR Code */
                for(i = 0; i < initSeqLength; i += 2) {
                    commandOnIndex = IR_DATA_OFFSET + i;
                    commandOffIndex = IR_DATA_OFFSET + i + 1;

                    burstPair.countOnPeriods = txBuffer[commandOnIndex];
                    burstPair.countOffPeriods = txBuffer[commandOffIndex];

                    sendIRBurstPair(pin, burstPair);
                }
            }

            if(repeatSeqLength > 0) {
                /* Transmit RepeatingSequence of IR Code (only one time) */
                for(i = 0; i < repeatSeqLength; i += 2) {
                    commandOnIndex = IR_DATA_OFFSET + initSeqLength + i;
                    commandOffIndex = IR_DATA_OFFSET + initSeqLength + i + 1;

                    burstPair.countOnPeriods = txBuffer[commandOnIndex];
                    burstPair.countOffPeriods = txBuffer[commandOffIndex];

                    sendIRBurstPair(pin, burstPair);
                }
            }
        }

	numTxBytes = 0;
}


/**
 * own delay_function, since Delay10us somehow didn't work
 *
 * @param us
 */
void delayUs(int us) {
    unsigned long _dcnt;

    _dcnt = (unsigned long) ((us * 1000) / 750);

    while(_dcnt--);
}

/**
 * sendIRBurstPair()
 *
 * sends out the received burst pair in "Raw Oscillated IR Format" using the calculated frequency
 */
void sendIRBurstPair(int pin, IR_BURST_PAIR burstPair) {
    int off_delay = (2 * burstPair.pulseWidth);

    for(; burstPair.countOnPeriods > 0; burstPair.countOnPeriods--) {
        PinSetLat(pin, 1);
        delayUs(burstPair.pulseWidth);
        PinSetLat(pin, 0);
        delayUs(burstPair.pulseWidth);
    }

    for(; burstPair.countOffPeriods > 0; burstPair.countOffPeriods--) {
        delayUs(off_delay);
    }
}
