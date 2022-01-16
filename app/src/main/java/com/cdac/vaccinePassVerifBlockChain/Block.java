package com.cdac.vaccinePassVerifBlockChain;

import java.util.Date;

public class Block {
	int id;
	String data;
	String previousHash;
	String hash;
	long timeStamp;
	int nonce;
	String calculatedhash;
    static int icr =0;


	public Block(String data, String previousHash) {
		this.data = data;
		this.previousHash = previousHash;
		timeStamp = new Date().getTime();
		this.hash = calculatedhash();
		this.id=icr;
		icr+=1;
	}

	public String calculatedhash()
	{
		calculatedhash = StringUtil.applySha256(
				previousHash +
						Long.toString(timeStamp)+
						Integer.toString(nonce) +
						data
		);
		//System.out.println("hash!!! : " + calculatedhash);

		return calculatedhash;
	}
	public void mineBlock(int difficulty) {
		String target = new String(new char[difficulty]).replace('\0', '0');
		while(!hash.substring( 0, difficulty).equals(target)) {
			nonce ++;
			hash = calculatedhash();
			//  System.out.println( nonce + " Block while Mining!!! : " + hash);
		}
		System.out.println("Block Mined!!! : " + hash);
	}
}
