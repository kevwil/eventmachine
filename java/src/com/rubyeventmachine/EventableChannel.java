/**
 * $Id$
 * 
 * Author:: Francis Cianfrocca (gmail: blackhedd)
 * Homepage::  http://rubyeventmachine.com
 * Date:: 15 Jul 2007
 * 
 * See EventMachine and EventMachine::Connection for documentation and
 * usage examples.
 * 
 *
 *----------------------------------------------------------------------------
 *
 * Copyright (C) 2006-07 by Francis Cianfrocca. All Rights Reserved.
 * Gmail: blackhedd
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of either: 1) the GNU General Public License
 * as published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version; or 2) Ruby's License.
 * 
 * See the file COPYING for complete licensing information.
 *
 *---------------------------------------------------------------------------
 *
 * 
 */


package com.rubyeventmachine;

import java.nio.ByteBuffer;
import java.io.IOException;
import java.nio.channels.ClosedChannelException;

public interface EventableChannel {
	
	void scheduleOutboundData (ByteBuffer bb);
	
	void scheduleOutboundDatagram (ByteBuffer bb, String recipAddress, int recipPort);
	
	boolean scheduleClose (boolean afterWriting);
	
	void startTls();
	
	long getBinding();
	
	void readInboundData (ByteBuffer dst) throws IOException;
	
	void register() throws ClosedChannelException;

	/**
	 * This is called by the reactor after it finishes running.
	 * The idea is to free network resources.
	 */
	void close();
	
	boolean writeOutboundData() throws IOException;

	long getOutboundDataSize();

	void setCommInactivityTimeout (long seconds);

	Object[] getPeerName();
	Object[] getSockName();

	boolean isWatchOnly();

	boolean isNotifyReadable();
	boolean isNotifyWritable();

}
