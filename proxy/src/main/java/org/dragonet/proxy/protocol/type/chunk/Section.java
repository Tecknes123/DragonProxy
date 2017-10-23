/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock137.xml
 */
package org.dragonet.proxy.protocol.type.chunk;

import org.dragonet.proxy.utilities.BinaryStream;

import java.util.Arrays;


/**
 * Section of a chunk with informations about blocks and lights. The array of bytes
 * are always ordered `xzy`.
 */
public class Section {

	public byte storageVersion = 0;
	public byte[] blockIds = new byte[4096];
	public byte[] blockMetas = new byte[2048];

	public Section() {}

	public Section(byte storageVersion, byte[] blockIds, byte[] blockMetas) {
		this.storageVersion = storageVersion;
		this.blockIds = blockIds;
		this.blockMetas = blockMetas;
	}

	public void encode(BinaryStream out) {
		out.putByte(storageVersion);
		out.put(blockIds);
		out.put(blockMetas);
	}

	public void decode(BinaryStream in) {
		storageVersion = (byte) (in.getByte() & 0xFF);
		blockIds = in.get(4096);
		blockMetas = in.get(2048);
	}

	@Override
	public String toString() {
		return "Section(storageVersion: " + this.storageVersion + ", blockIds: " + Arrays.toString(this.blockIds) + ", blockMetas: " + Arrays.toString(this.blockMetas) + ")";
	}


}