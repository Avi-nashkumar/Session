package Day12;
import com.google.gson.*;
import java.util.ArrayList;

import com.google.gson.GsonBuilder;

public class Blockchain {
	
	public static ArrayList<Block> blockchain = new ArrayList<Block>(); 
	public static int difficulty = 8;
	
	public static Boolean isChainValid() {
		Block currentBlock;
		Block previousBlock;
		for(int i=0;i<blockchain.size()-1;i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i-1);
			if(!currentBlock.hash.equals(currentBlock.hashCalculation()) ){
				System.out.println("Current Hashes not equal");			
				return false;
			}
			if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
				System.out.println("Previous Hashes not equal");
				return false;
			
		}
		}
			return true;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		blockchain.add(new Block("Hi im the first block", "0"));		
		blockchain.add(new Block("Yo im the second block",blockchain.get(blockchain.size()-1).hash)); 
		blockchain.add(new Block("Hey im the third block",blockchain.get(blockchain.size()-1).hash));
		
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);		
		System.out.println(blockchainJson);
		
		blockchain.add(new Block("Hi im the first block", "0"));
		System.out.println("Trying to Mine block 1... ");
		blockchain.get(0).mineBlock(difficulty);
		
		blockchain.add(new Block("Yo im the second block",blockchain.get(blockchain.size()-1).hash));
		System.out.println("Trying to Mine block 2... ");
		blockchain.get(1).mineBlock(difficulty);
		
		blockchain.add(new Block("Hey im the third block",blockchain.get(blockchain.size()-1).hash));
		System.out.println("Trying to Mine block 3... ");
		blockchain.get(2).mineBlock(difficulty);	
		
		System.out.println("\nBlockchain is Valid: " + isChainValid());
		
		System.out.println("\nThe block chain: ");
		System.out.println(blockchainJson);
	}

}
