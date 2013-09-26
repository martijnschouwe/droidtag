/**
 * a simple infrared transmission of IR code in "Raw Oscillated IR Format"
 *
 * AUTHORS: Andrej Eisfeld <andrej.eisfeld@hs-furtwangen.de>, Sergej Proskurin <sergej.proskurin@googlemail.com>
 */

#ifndef __IR_H__
#define __IR_H__

/**
 * IRBurstPair implies all important information about a burst pair
 *
 * countOnPeriods - count of logical HIGH to be sent out
 * countOffPeriods - count of logical LOW to be sent out
 * pulseWidth - calculated pulse width
 */
typedef struct IRBurstPair {
	int countOnPeriods;
	int countOffPeriods;
	int pulseWidth;
} IR_BURST_PAIR;

void storeIRData( int data1, int data2 );
void sendIRCommand( int pin );
void sendIRBurstPair( int pin, IR_BURST_PAIR burstPair );

#endif  // __IR_H__
