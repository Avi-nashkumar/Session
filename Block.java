package Day12;
import java.util.Date;

public class Block {
	public String hash;
	public String previousHash;
	public String data;
	public long timeStamp;
	private int nonce;
	
	public Block(String data,  String previousHash) {
		this.data= data;
		this.previousHash= previousHash;
		this.timeStamp= new Date().getTime();
		this.hash= hashCalculation();
	}
	
	public String hashCalculation() {
		String calculatedHash= StringUtil.applySha256(previousHash+Long.toString(timeStamp)+
				Integer.toString(nonce) +data);
		return calculatedHash;
	}
	public void mineBlock(int difficulty) {
		String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0" 
		while(!hash.substring( 0, difficulty).equals(target)) {
			nonce ++;
			hash = hashCalculation();
		}
		System.out.println("Block Mined!!! : " + hash);
	}

}
