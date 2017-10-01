import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ronan Watkins on 21/08/2017.
 */
public class Blockchain {
    ArrayList<Block> chain = new ArrayList<Block>();

    public Blockchain() {
        this.chain.add(this.createGenesisBlock());
    }

    public Block createGenesisBlock() {
        return new Block(0, "01/01/2017", "Genesis block", "0");
    }

    public Block getLatestBlock() {
        return this.chain.get(this.chain.size()-1);
    }

    public void addBlock(Block newBlock) {
        newBlock.previousHash = this.getLatestBlock().calculateHash();
        newBlock.hash = newBlock.calculateHash();
        this.chain.add(newBlock);
    }

    @Override
    public String toString() {
        JSONObject obj = new JSONObject();
        JSONArray array = new JSONArray();
        array.put(this.chain.toString());
        obj.put("chain", array);

        return obj.toString().replace("\\", "");
    }
}
